/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */


package org.apache.pluto.container.bean.processor;

import static org.apache.pluto.container.bean.processor.MethodType.ACTION;
import static org.apache.pluto.container.bean.processor.MethodType.EVENT;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.EventMethod;
import javax.portlet.annotations.PortletQName;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Makes the configuration data & annotated portlet methods that are read during the
 * CDI scanning phase available for the portlets.
 * 
 * @author Scott Nicklous
 *
 */
public class AnnotatedMethodStore {
   private static final Logger LOG = LoggerFactory.getLogger(AnnotatedMethodStore.class);
   private static final boolean isDebug = LOG.isDebugEnabled();
   private static final boolean isTrace = LOG.isTraceEnabled();
   

   // Note that the maps do not need to be synchronized, as the writes are only performed
   // during the single-threaded CDI archive scanning phase.
   // Also, TreeMap & TreeSet are used here to provide config & debug output ordered by 
   // portlet name.
   
   // Map containing the annotated methods. Key is the MethodIdentifier, which consists
   // of the portlet name, the method type, and the dispatch ID. There can be more
   // than one method per method identifier.
   // Important: In this map, a value can be linked to by more than one key!!
   private final Map<MethodIdentifier, List<AnnotatedMethod>> methods =
         new HashMap<MethodIdentifier, List<AnnotatedMethod>>();
   
   // Set containing all portlet names appearing in either the configuration map, 
   // the method map, or both.
   private final Set<String>  portletNames = new TreeSet<String>();
   
   // Holds deployment error descriptions and other information for display.
   private final ConfigSummary summary;

   // per portlet processing event references
   private final Map<String, List<QName>> procEvtRefs = new HashMap<String, List<QName>>();

   // Set of processing event method identifiers that have the QName namespace 
   // equal to XMLConstants.NULL_NS_URI. These may need to be fixed up when the
   // default namespace becomes known during config reconciliation.
   private final Set<MethodIdentifier> procEvtRefFixups = new HashSet<MethodIdentifier>();
   
   // per portlet publishing event references
   private final Map<String, List<QName>> pubEvtRefs = new HashMap<String, List<QName>>();
   
   // The bean manager for use during config reconciliation
   private BeanManager beanMgr = null;
   
   /**
    * Constructor
    * @param consum
    */
   public AnnotatedMethodStore(ConfigSummary consum) {
      this.summary = consum;
   }
   
   /**
    * Returns the method list for a given method identifier, or null if an entry
    * already exists, but multiple entries are not allowed.
    * 
    * @param mi   the method identifier
    * @param am   the annotated method
    * @return     the list, or null if error condition
    */
   private List<AnnotatedMethod> getMethodList(MethodIdentifier mi, AnnotatedMethod am) {
      List<AnnotatedMethod> list = methods.get(mi);
      if (list != null) {
         
         // A method already exists for this ID. 
         // Verify that multiple methods are allowed. 
         
         if (!am.getDescription().isAllowMultiple()) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Duplicate method specification. Method identifier: ");
            txt.append(mi.toString());
            txt.append(" / Method 1: ").append(list.get(0).toString());
            txt.append(" / Method 2: ").append(am.toString());
            summary.addErrorString(mi.getName(), txt.toString());
            LOG.warn("Disallowed duplicate entry: " + mi.toString());
            list = null;
         }
      } else {
         list = new ArrayList<AnnotatedMethod>();
         methods.put(mi, list);
      }
      return list;
   }

   /**
    * Adds a annotated method for the given method identifier.
    * 
    * @param mi      Method identifier
    * @param am      Annotated method
    * @return        <code>true</code> if the AnnotatedMethod was added
    *                <code>false</code> if there was a disallowed duplicate entry.
    */
   public boolean addMethod(MethodIdentifier mi, AnnotatedMethod am) {
            
      // First collect the event references, if any
      
      List<QName> procqns = new ArrayList<QName>();
      List<QName> pubqns = new ArrayList<QName>();
      if (mi.getType() == ACTION && am.getAnnotation() != null) {
         ActionMethod anno = (ActionMethod) am.getAnnotation();
         for (PortletQName pqn : anno.publishingEvents()) {
            String uri = pqn.namespaceURI().trim();
            uri = (uri.length() == 0) ? XMLConstants.NULL_NS_URI : uri;
            QName qn = new QName(uri, pqn.localPart());
            pubqns.add(qn);
         }
      } else if (mi.getType() == EVENT && am.getAnnotation() != null) {
         EventMethod anno = (EventMethod) am.getAnnotation();
         for (PortletQName pqn : anno.publishingEvents()) {
            String uri = pqn.namespaceURI().trim();
            uri = (uri.length() == 0) ? XMLConstants.NULL_NS_URI : uri;
            QName qn = new QName(uri, pqn.localPart());
            pubqns.add(qn);
         }
         for (PortletQName pqn : anno.processingEvents()) {
            String uri = pqn.namespaceURI().trim();
            uri = (uri.length() == 0) ? XMLConstants.NULL_NS_URI : uri;
            QName qn = new QName(uri, pqn.localPart());
            procqns.add(qn);
         }
      }
      
      if (mi.getType() == EVENT && procqns.size() > 0) {
         
         // If this is an event method, verify that the processing event QName 
         // is not a duplicate. Add a separate entry for each processing event.

         List<QName> qns = procEvtRefs.get(mi.getName());
         if (qns != null) {
            EventMethod anno = (EventMethod) am.getAnnotation();
            for (PortletQName pqn : anno.processingEvents()) {
               QName qn = new QName(pqn.namespaceURI(), pqn.localPart());
               if (qns.contains(qn)) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Duplicate processing event QName. Portlet name: ");
                  txt.append(mi.getName());
                  txt.append(", QName: ").append(qn);
                  txt.append(", Annotation: @EventMethod");
                  txt.append(", Class: ").append(am.getJavaMethod().getDeclaringClass().getCanonicalName());
                  summary.addErrorString(mi.getName(), txt.toString());
                  LOG.warn(txt.toString());
                  return false;
               }
            }
         } else if (procqns.size() == 0) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Missing processing event QName. Portlet name: ");
            txt.append(mi.getName());
            txt.append(", Annotation: @EventMethod");
            txt.append(", Class: ").append(am.getJavaMethod().getDeclaringClass().getCanonicalName());
            summary.addErrorString(mi.getName(), txt.toString());
            LOG.warn(txt.toString());
            return false;
         }
         
         List<QName> badQns = new ArrayList<QName>();
         for (QName qn : procqns) {
            MethodIdentifier newmi = new MethodIdentifier(mi);
            newmi.setId(qn);

            List<AnnotatedMethod> list = getMethodList(newmi, am);
            if (list == null) {
               badQns.add(qn);
               continue;
            }
            
            if (qn.getNamespaceURI().equals(XMLConstants.NULL_NS_URI)) {
               procEvtRefFixups.add(newmi);
            }
            list.add(am);
         }
         
         if (badQns.size() > 0) {
            procqns.removeAll(badQns);
            if (procqns.size() == 0) {
               return false;
            }
         }
         
      } else {
         
         // For all other methods, including the event default method with dispatchId = "",
         // just get the list and add the method
         
         List<AnnotatedMethod> list = getMethodList(mi, am);
         if (list == null) {
            return false;
         }
         
         list.add(am);
         
      }
      
      // Collect additional info about the added method(s)
      
      portletNames.add(mi.getName());
      
      String portletName = mi.getName();
      if (procqns.size() > 0) {
         if (!procEvtRefs.containsKey(portletName)) {
            procEvtRefs.put(portletName, new ArrayList<QName>());
         }
         procEvtRefs.get(portletName).addAll(procqns);
      }
      
      if (pubqns.size() > 0) {
         if (!pubEvtRefs.containsKey(portletName)) {
            pubEvtRefs.put(portletName, new ArrayList<QName>());
         }
         pubEvtRefs.get(portletName).addAll(pubqns);
      }
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Stored annotated method for: ").append(mi.toString());
         txt.append(", Processing event refs: ").append(procqns);
         txt.append(", Publishing event refs: ").append(procqns);
         LOG.debug(txt.toString());
      }
      return true;
   }
   
   /**
    * Removes the annotated method or methods stored for the given method identifier.
    * 
    * @param mi   the method identifier
    * @return     The list of annotated methods removed, or <code>null</code> if no list exists
    */
   public List<AnnotatedMethod> removeMethod(MethodIdentifier mi) {
      return methods.remove(mi);
   }
   
   /**
    * Returns the annotated method for a given identifier.
    * 
    * It's a programming error if this method is used when multiple methods could be expected. 
    * 
    * @param mi   The method identifier
    * @return     The annotated method, or <code>null</code> if none was found.
    */
   public AnnotatedMethod getMethod(MethodIdentifier mi) {
      AnnotatedMethod pm = null;
      List<AnnotatedMethod> list = methods.get(mi);
      if (list != null) {
         assert list.size() == 1;
         assert !list.get(0).getDescription().isAllowMultiple();
         pm = list.get(0);
      }
      if (isTrace) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Retrieved annotated method for: ").append(mi.toString());
         txt.append(", Method: ").append(pm == null ? "null" : pm.toString());
         LOG.trace(txt.toString());
      }
      return pm;
   }
   
   /**
    * Returns all registered methods for the given method identifier.
    * <p>
    * This is intended for use with method identifiers such as PortletResources
    * that can have more than one annotated method for each method identifier.
    * 
    * @param mi     The method identifier
    * @return       A list of annotated methods.
    */
   public List<AnnotatedMethod> getMethods(MethodIdentifier mi){
      List<AnnotatedMethod> aList = new ArrayList<AnnotatedMethod>();
      if (methods.containsKey(mi)) {
         aList.addAll(methods.get(mi));
      }
      return aList;
   }
   
   /**
    * Returns a String representation of the stored methods.
    * 
    * @return  String
    */
   public String getMethodsAsString() {
      
      List<MethodIdentifier> meths = new ArrayList<MethodIdentifier>();
      meths.addAll(methods.keySet());
      Collections.sort(meths, new MethodIdentifierComparator());

      StringBuilder txt = new StringBuilder(256);
      txt.append("Stored methods: ");
      for (MethodIdentifier mi : meths) {
         txt.append("\n\t").append(mi.toString());
         for (AnnotatedMethod pm : methods.get(mi)) {
            txt.append("\n\t\t").append(pm.toString());
         }
      }
      return txt.toString();
   }
   
   /**
    * returns a String representation of all data stored.
    */
   @Override
   public String toString() {
      StringBuilder txt = new StringBuilder(256);
      txt.append("\n");
      txt.append(getMethodsAsString());
      return txt.toString();
   }
   
   /**
    * Returns a Set containing the unique portlet names represented in the store.
    * @return     The portlet names
    */
   public Set<String> getPortletNames() {
      return new HashSet<String>(portletNames);
   }
   
   /**
    * Returns the stored methods for the given portlet name.
    * 
    * @param   portletName    The portlet name
    * @return                 Set of method identifiers. The Set is empty if there are no 
    *                         methods available
    */
   public Set<MethodIdentifier> getMethodIDsForPortlet(String portletName) {
      Set<MethodIdentifier> meths = new HashSet<MethodIdentifier>();
      for (MethodIdentifier mi : methods.keySet()) {
         if (mi.getName().equals(portletName)) {
            meths.add(mi);
         }
      }
      return meths;
   }
   
   /**
    * Removes the stored methods for the given portlet name.
    * 
    * @param   portletName    The portlet name
    */
   public void removeMethodsForPortlet(String portletName) {
      
      Set<MethodIdentifier> meths = new HashSet<MethodIdentifier>();
      for (MethodIdentifier mi : methods.keySet()) {
         if (mi.getName().equals(portletName)) {
            meths.add(mi);
         }
      }
      
      for (MethodIdentifier mi : meths) {
         methods.remove(mi);
      }
      
      portletNames.remove(portletName);
   }
   
   /**
    * Activate the methods by providing them with a bean manager. 
    * Sort the method lists for the method types that can have multiple
    * entries.
    * 
    * @param bm
    */
   public void activateMethods(BeanManager bm) {
      beanMgr = bm;
      Collection<List<AnnotatedMethod>> methlists = methods.values();
      for (List<AnnotatedMethod> list : methlists) {
         Collections.sort(list, new AnnotatedMethodComparator());
         for (AnnotatedMethod meth : list) {
            meth.activate(bm);
         }
      }
   }
   
   /**
    * Returns the configured processing event references for the given portlet.
    * <p>
    * Used during configuration reconciliation.
    * 
    * @param   portletName
    * @return  The event references
    */
   public List<QName> getProcessingEventRefs(String portletName) {
      List<QName> list = new ArrayList<QName>();
      if (procEvtRefs.containsKey(portletName)) {
         list.addAll(procEvtRefs.get(portletName));
      }
      return list;
   }
   
   /**
    * Returns the configured publishing event references for the given portlet.
    * <p>
    * Used during configuration reconciliation.
    * 
    * @param   portletName
    * @return  The event references
    */
   public List<QName> getPublishingEventRefs(String portletName) {
      List<QName> list = new ArrayList<QName>();
      if (pubEvtRefs.containsKey(portletName)) {
         list.addAll(pubEvtRefs.get(portletName));
      }
      return list;
   }
   
   /**
    * Sets the default namespace for method identifiers whose QName NS URIs are
    * XMLConstants.NULL_NS_URI.
    * <p>
    * Used during configuration reconciliation.
    * This method should be called after the bean configuration has been read, but before
    * the processing and publishing event references are retrieved. 
    * 
    * @param ns      The default namespace
    */
   public void setDefaultNamespace(String ns) {
      if ((ns != null) && !ns.equals(XMLConstants.NULL_NS_URI)) {
         
         // fix up the invokable event methods
         
         for (MethodIdentifier mi : procEvtRefFixups) {
            List<AnnotatedMethod> meths = methods.get(mi);
               
            assert (meths != null) && (meths.size() > 0);
            assert (mi.getType() == EVENT) && (mi.getId() instanceof QName);
            QName oldqn = (QName) mi.getId();
            assert oldqn.getNamespaceURI().equals(XMLConstants.NULL_NS_URI);
            QName newqn = new QName(ns, oldqn.getLocalPart());
            MethodIdentifier newmi = new MethodIdentifier(mi);
            newmi.setId(newqn);

            methods.remove(mi);
            methods.put(newmi, meths);
            
            if (isDebug) {
               StringBuilder txt = new StringBuilder();
               txt.append("Fixing up Method identifier with default namespace: ").append(ns);
               txt.append(", old MI: ").append(mi);
               txt.append(", new MI: ").append(newmi);
               LOG.debug(txt.toString());
            }
         }
         
         // Fixup the per-portlet processing event references
         
         for (String pn : procEvtRefs.keySet()) {
            List<QName> oldqns = new ArrayList<QName>(procEvtRefs.get(pn));
            for (QName oldqn : oldqns) {
               if (oldqn.getNamespaceURI().equals(XMLConstants.NULL_NS_URI)) {
                  QName newqn = new QName(ns, oldqn.getLocalPart());
                  procEvtRefs.get(pn).remove(oldqn);
                  procEvtRefs.get(pn).add(newqn);
                  
                  if (isDebug) {
                     StringBuilder txt = new StringBuilder();
                     txt.append("Fixed up processing event reference for portlet: ").append(pn);
                     txt.append(", old QN: ").append(oldqn);
                     txt.append(", new QN: ").append(newqn);
                     LOG.debug(txt.toString());
                  }
               }
            }
         }
         
         // Fixup the per-portlet publishing event references
         
         for (String pn : pubEvtRefs.keySet()) {
            List<QName> oldqns = new ArrayList<QName>(pubEvtRefs.get(pn));
            for (QName oldqn : oldqns) {
               if (oldqn.getNamespaceURI().equals(XMLConstants.NULL_NS_URI)) {
                  QName newqn = new QName(ns, oldqn.getLocalPart());
                  pubEvtRefs.get(pn).remove(oldqn);
                  pubEvtRefs.get(pn).add(newqn);
                  
                  if (isDebug) {
                     StringBuilder txt = new StringBuilder();
                     txt.append("Fixed up publishing event reference for portlet: ").append(pn);
                     txt.append(", old QN: ").append(oldqn);
                     txt.append(", new QN: ").append(newqn);
                     LOG.debug(txt.toString());
                  }
               }
            }
         }
      }
   }

   /**
    * @return the beanMgr
    */
   public BeanManager getBeanMgr() {
      return beanMgr;
   }
   
   /**
    * Sets the bean instance for all annotated methods for a given portlet that are members of 
    * a configured portlet class to ensure that all annotated methods of the portlet class use 
    * the same bean instance.
    * 
    * @param portletName      The portlet name
    * @param cls              The class
    * @param beanInstance     The instance to use
    */
   public void setPortletClassInstance(String portletName, Class<?> cls, Object beanInstance) {
      for (MethodIdentifier mi : getMethodIDsForPortlet(portletName)) {
         List<AnnotatedMethod> list =  methods.get(mi);
         for (AnnotatedMethod am : list) {
            if (am.getBeanClass().equals(cls)) {
               am.setPortletClassInstance(beanInstance);
            }
         }
      }
   }
   
}
