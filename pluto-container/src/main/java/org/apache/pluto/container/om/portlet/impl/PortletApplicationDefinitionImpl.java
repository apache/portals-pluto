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


package org.apache.pluto.container.om.portlet.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.CustomWindowState;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.Listener;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PublicRenderParameter;
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.UserAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Portlet application definition
 * 
 * @author Scott Nicklous
 */
public class PortletApplicationDefinitionImpl implements
      PortletApplicationDefinition {
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortletApplicationDefinitionImpl.class);

   private String id;
   private String name;
   private String contextPath;
   private String version = "3.0";
   private String resourceBundle;
   private String defaultNamespace;
   
   private final List<PublicRenderParameter> prps = new ArrayList<PublicRenderParameter>();
   private final List<PortletDefinition> portlets = new ArrayList<PortletDefinition>();
   private final List<EventDefinition> events =     new ArrayList<EventDefinition>();
   private final List<CustomPortletMode> cpms =     new ArrayList<CustomPortletMode>();
   private final List<CustomWindowState> cwss =     new ArrayList<CustomWindowState>();
   private final List<UserAttribute> uattrs =       new ArrayList<UserAttribute>();
   private final List<Filter> filters =             new ArrayList<Filter>();
   private final List<FilterMapping> fmaps =        new ArrayList<FilterMapping>();
   private final List<ContainerRuntimeOption> cros = new ArrayList<ContainerRuntimeOption>();
   
   // for the locale - encoding mappings from the web.xml
   private final Map<Locale, String> localemap = new HashMap<Locale, String>();
   
   private final List<Listener> listeners = new ArrayList<Listener>();
   private final List<SecurityConstraint> constraints = new ArrayList<SecurityConstraint>();

   /**
    * Default constructor
    */
   public PortletApplicationDefinitionImpl() {
   }

   /**
    * Copy constructor. This class is written such that the accessors copy the 
    * objects being returned, so the return values can be directly used in the
    * copy constructor.
    * 
    * @param pad     The portlet application definition
    */
   public PortletApplicationDefinitionImpl(PortletApplicationDefinition pad) {
      this.contextPath = pad.getContextPath();
      this.id = pad.getId();
      this.name = pad.getName();
      this.version = pad.getVersion();
      this.resourceBundle = pad.getResourceBundle();
      this.defaultNamespace = pad.getDefaultNamespace();

      for (PortletDefinition pd : pad.getPortlets()) {
         portlets.add(pd);
      }
      for (EventDefinition item : pad.getEventDefinitions()) {
         events.add(item);
      }
      for (PublicRenderParameter prp : pad.getPublicRenderParameters()) {
         prps.add(prp);
      }
      for (CustomPortletMode cpm : pad.getCustomPortletModes()) {
         cpms.add(cpm);
      }
      for (CustomWindowState item : pad.getCustomWindowStates()) {
         cwss.add(item);
      }
      for (UserAttribute ua : pad.getUserAttributes()) {
         uattrs.add(ua);
      }
      for (Filter f : pad.getFilters()) {
         filters.add(f);
      }
      for (FilterMapping fm : pad.getFilterMappings()) {
         fmaps.add(fm);
      }
      for (ContainerRuntimeOption cro : pad.getContainerRuntimeOptions()) {
         cros.add(cro);
      }
      
      localemap.putAll(pad.getLocaleEncodingMappings());
      
      if (pad.getListeners() != null) {
         for (Listener l : pad.getListeners()) {
            listeners.add(new ListenerImpl(l));
         }
      }
      constraints.addAll(pad.getSecurityConstraints());
      
   }
   
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
   
   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#getName()
    */
   @Override
   public String getName() {
      return name;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#setName(java.lang.String)
    */
   @Override
   public void setName(String name) {
      this.name = name;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#getContextPath()
    */
   @Override
   public String getContextPath() {
      return contextPath;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#setContextPath(java.lang.String)
    */
   @Override
   public void setContextPath(String contextPath) {
      this.contextPath = contextPath;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#getVersion()
    */
   @Override
   public String getVersion() {
      return version;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#setVersion(java.lang.String)
    */
   @Override
   public void setVersion(String version) {
      this.version = version;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#getResourceBundle()
    */
   @Override
   public String getResourceBundle() {
      return resourceBundle;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#setResourceBundle(java.lang.String)
    */
   @Override
   public void setResourceBundle(String resourceBundle) {
      this.resourceBundle = resourceBundle;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#getDefaultNamespace()
    */
   @Override
   public String getDefaultNamespace() {
      return (defaultNamespace == null) ? XMLConstants.NULL_NS_URI : defaultNamespace;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletApplicationDefinition#setDefaultNamespace(java.lang.String)
    */
   @Override
   public void setDefaultNamespace(String defaultNamespace) {
      this.defaultNamespace = defaultNamespace;
   }

   @Override
   public PortletDefinition getPortlet(String portletName) {
      PortletDefinition pd = null;
      for (PortletDefinition item : portlets) {
         if (item.getPortletName().equals(portletName)) {
            pd = new PortletDefinitionImpl(item);
         }
      }
      return pd;
   }

   @Override
   public List<PortletDefinition> getPortlets() {
      ArrayList<PortletDefinition> ret = new ArrayList<PortletDefinition>();
      for (PortletDefinition pd : portlets) {
         ret.add(new PortletDefinitionImpl(pd));
      }
      return ret;
   }

   /**
    * The portlet name can end with the wildcard character '*'. The wildcard 
    * matches any suffix. For filter mapping.
    * 
    * @return     The list of matching portlets
    */
   @Override
   public List<PortletDefinition> getMatchingPortlets(String portletName) {
      ArrayList<PortletDefinition> ret = new ArrayList<PortletDefinition>();
      String match = portletName.replaceAll("^(.*)\\*$",  "$1");
      for (PortletDefinition pd : portlets) {
         if (pd.getPortletName().startsWith(match)) {
            ret.add(new PortletDefinitionImpl(pd));
         }
      }
      return ret;
   }

   @Override
   public void addPortlet(PortletDefinition pd) {
      if (portlets.remove(pd)) {
         LOG.debug("Removed duplicate portlet: " + pd.getPortletName());
      }
      portlets.add( pd);
   }

   @Override
   public boolean removePortlet(PortletDefinition pd) {
      return portlets.remove(pd);
   }

   @Override
   public List<EventDefinition> getEventDefinitions() {
      ArrayList<EventDefinition> items = new ArrayList<EventDefinition>();
      for (EventDefinition item : events) {
         items.add(new EventDefinitionImpl(item));
      }
      return items;
   }

   @Override
   public EventDefinition getEventDefinition(QName qn) {
      EventDefinition ret = null;
      for (EventDefinition item : events) {
         if (item.getQName().equals(qn)) {
            ret = new EventDefinitionImpl(item);
         }
      }
      return ret;
   }

   @Override
   public void addEventDefinition(EventDefinition ed) {
      if (events.remove(ed)) {
         LOG.debug("Removed duplicate event definition: " + ed.getQName());
      }
      events.add(ed);
   }

   @Override
   public boolean removeEventDefinition(EventDefinition ed) {
      return events.remove(ed);
   }

   @Override
   public PublicRenderParameter getPublicRenderParameter(String identifier) {
      PublicRenderParameter ret = null;
      for (PublicRenderParameter prp : prps) {
         if (prp.getIdentifier().equals(identifier)) {
            ret = new PublicRenderParameterImpl(prp);
         }
      }
      return ret;
   }

   @Override
   public List<PublicRenderParameter> getPublicRenderParameters() {
      ArrayList<PublicRenderParameter> items = new ArrayList<PublicRenderParameter>();
      for (PublicRenderParameter item : prps) {
         items.add(new PublicRenderParameterImpl(item));
      }
      return items;
   }

   @Override
   public void addPublicRenderParameter(PublicRenderParameter prp) {
      int ii = prps.indexOf(prp);
      if (ii >= 0) {
         
         PublicRenderParameter tprp = prps.get(ii);
         prps.remove(prp);
         
         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate public render parameter definition for QName: ");
         txt.append(tprp.getQName());
         txt.append(", id: ").append(tprp.getIdentifier());
         LOG.debug(txt.toString());
      }
      prps.add(prp);
   }

   @Override
   public boolean removePublicRenderParameter(PublicRenderParameter prp) {
      return prps.remove(prp);
   }

   @Override
   public CustomPortletMode getCustomPortletMode(String arg) {
      CustomPortletMode ret = null;
      for (CustomPortletMode item : cpms) {
         if (item.getPortletMode().equals(arg)) {
            ret = new CustomPortletModeImpl(item);
         }
      }
      return ret;
   }

   @Override
   public List<CustomPortletMode> getCustomPortletModes() {
      ArrayList<CustomPortletMode> items = new ArrayList<CustomPortletMode>();
      for (CustomPortletMode item : cpms) {
         items.add(new CustomPortletModeImpl(item));
      }
      return items;
   }

   @Override
   public void addCustomPortletMode(CustomPortletMode cpm) {
      if (cpms.remove(cpm)) {
         LOG.debug("Removed duplicate custom portlet mode: " + cpm.getPortletMode());
      }
      cpms.add(cpm);
   }

   @Override
   public boolean removeCustomPortletMode(CustomPortletMode pm) {
      return cpms.remove(pm);
   }

   @Override
   public CustomWindowState getCustomWindowState(String arg) {
      CustomWindowState ret = null;
      for (CustomWindowState item : cwss) {
         if (item.getWindowState().equals(arg)) {
            ret = new CustomWindowStateImpl(item);
         }
      }
      return ret;
   }

   @Override
   public List<CustomWindowState> getCustomWindowStates() {
      ArrayList<CustomWindowState> items = new ArrayList<CustomWindowState>();
      for (CustomWindowState item : cwss) {
         items.add(new CustomWindowStateImpl(item));
      }
      return items;
   }

   @Override
   public void addCustomWindowState(CustomWindowState cws) {
      if (cwss.remove(cws)) {
         LOG.debug("Removed duplicate custom window state: " + cws.getWindowState());
      }
      cwss.add(cws);
   }

   @Override
   public boolean removeCustomWindowState(CustomWindowState ws) {
      return cwss.remove(ws);
   }

   @Override
   public UserAttribute getUserAttribute(String arg) {
      UserAttribute ret = null;
      for (UserAttribute item : uattrs) {
         if (item.getName().equals(arg)) {
            ret = new UserAttributeImpl(item);
         }
      }
      return ret;
   }

   @Override
   public List<UserAttribute> getUserAttributes() {
      ArrayList<UserAttribute> items = new ArrayList<UserAttribute>();
      for (UserAttribute item : uattrs) {
         items.add(new UserAttributeImpl(item));
      }
      return items;
   }

   @Override
   public void addUserAttribute(UserAttribute ua) {
      if (uattrs.remove(ua)) {
         LOG.debug("Removed duplicate user attribute: " + ua.getName());
      }
      uattrs.add(ua);
   }

   @Override
   public boolean removeUserAttribute(UserAttribute ua) {
      return uattrs.remove(ua);
   }

   @Override
   public Filter getFilter(String arg) {
      Filter ret = null;
      for (Filter item : filters) {
         if (item.getFilterName().equals(arg)) {
            ret = new FilterImpl(item);
         }
      }
      return ret;
   }

   @Override
   public List<Filter> getFilters() {
      ArrayList<Filter> items = new ArrayList<Filter>();
      for (Filter item : filters) {
         items.add(new FilterImpl(item));
      }
      return items;
   }

   @Override
   public void addFilter(Filter filter) {
      // If the filter class is null, remove the filter definition, otherwise replace it
      boolean removed = filters.remove(filter);
      
      if (removed) {
         LOG.debug("Removed duplicate filter definition: " + filter.getFilterName());
      } 
      
      // If a filter class is present, add the new one. Otherwise, if the filter was
      // removed, get rid of the filter mapping as well.
      if (filter.getFilterClass() != null && filter.getFilterClass().length() > 0) {
         filters.add(filter);
         // sort by ordinal. for JSR286 portlets, the ordinal will always be 0, so
         // the list will remain in the original order.
         Collections.sort(filters, new FilterComparator());
      } else {
         LOG.debug("No filter class for filter. Deleting filter mapping. filter name: " + filter.getFilterName());
         removeFilterMapping(getFilterMapping(filter.getFilterName()));
      }
   }

   @Override
   public boolean removeFilter(Filter filter) {
      return filters.remove(filter);
   }

   @Override
   public FilterMapping getFilterMapping(String arg) {
      FilterMapping ret = null;
      for (FilterMapping item : fmaps) {
         if (item.getFilterName().equals(arg)) {
            ret = new FilterMappingImpl(item);
         }
      }
      return ret;
   }

   @Override
   public List<FilterMapping> getFilterMappings() {
      ArrayList<FilterMapping> items = new ArrayList<FilterMapping>();
      for (FilterMapping item : fmaps) {
         items.add(new FilterMappingImpl(item));
      }
      return items;
   }

   @Override
   public void addFilterMapping(FilterMapping fm) {
      // If the filter mapping has no portlet names, remove the filter mapping definition, otherwise replace it
      if (fmaps.remove(fm)) {
         LOG.debug("Removed duplicate filter mapping: " + fm.getFilterName());
      }
      if (fm.getPortletNames().size() > 0) {
         fmaps.add(fm);
      } else {
         LOG.debug("No portlet names for filter mapping. Filter name: " + fm.getFilterName());
      }
   }

   @Override
   public boolean removeFilterMapping(FilterMapping fm) {
      return fmaps.remove(fm);
   }

   @Override
   public ContainerRuntimeOption getContainerRuntimeOption(String arg) {
      ContainerRuntimeOption ret = null;
      for (ContainerRuntimeOption item : cros) {
         if (item.getName().equals(arg)) {
            ret = new ContainerRuntimeOptionImpl(item);
         }
      }
      return ret;
   }

   @Override
   public List<ContainerRuntimeOption> getContainerRuntimeOptions() {
      ArrayList<ContainerRuntimeOption> items = new ArrayList<ContainerRuntimeOption>();
      for (ContainerRuntimeOption item : cros) {
         items.add(new ContainerRuntimeOptionImpl(item));
      }
      return items;
   }

   @Override
   public void addContainerRuntimeOption(ContainerRuntimeOption cro) {
      if (cros.remove(cro)) {
         LOG.debug("Removed duplicate container runtime option: " + cro.getName());
      }
      cros.add(cro);
   }

   @Override
   public boolean removeRuntimeOption(ContainerRuntimeOption cro) {
      return cros.remove(cro);
   }
   
   @Override
   public Listener getListener(String name) {
      for (Listener l : listeners) {
         if (l.getListenerName().equals(name)) {
            return new ListenerImpl(l);
         }
      }
      return null;
   }

   @Override
   public List<Listener> getListeners() {
      ArrayList<Listener> list = new ArrayList<Listener>();
      for (Listener l : listeners) {
         list.add(new ListenerImpl(l));
      }
      return list;
   }

   @Override
   public void addListener(Listener listener) {
      
      // Remove the listener if already present. This is based on the listener class
      // for JSR 286 portlets and on the listener name for JSR 362 portlets

      if (version.equals("3.0")) {
         for (int ii = 0; ii < listeners.size(); ii++) {
            if (listeners.get(ii).getListenerName().equals(listener.getListenerName())) {
               listeners.remove(ii);
               LOG.debug("Removed duplicate listener with name: " + listener.getListenerName());
               break;
            }
         }
      } else {

         // If the listener class is null, remove the listener definition, otherwise replace it
         if (listeners.remove(listener)) {
            LOG.debug("Removed duplicate listener for class: " + listener.getListenerClass());
         } 
      } 
      
      if (listener.getListenerClass() != null && listener.getListenerClass().length() > 0) {
         listeners.add(listener);
         // sort by ordinal. for JSR286 portlets, the ordinal will always be 0, so
         // the list will remain in the original order.
         Collections.sort(listeners, new ListenerComparator());
      } else {
         LOG.debug("No listener class for listener: " + listener.getListenerName());
      }
   }

   @Override
   public boolean removeListener(Listener listener) {
      return listeners.remove(listener);
   }

   @Override
   public List<SecurityConstraint> getSecurityConstraints() {
      ArrayList<SecurityConstraint> scs = new ArrayList<SecurityConstraint>();
      for (SecurityConstraint sc : constraints) {
         scs.add(new SecurityConstraintImpl(sc));
      }
      return scs;
   }

   @Override
   public void addSecurityConstraint(SecurityConstraint sc) {
      if (constraints.remove(sc)) {
         LOG.debug("Removed duplicate security constraint: " + sc.getUserDataConstraint().getTransportGuarantee());
      }
      constraints.add(sc);
   }

   @Override
   public boolean removeSecurityCOnstraint(SecurityConstraint sc) {
      return constraints.remove(sc);
   }

   @Override
   public Map<Locale, String> getLocaleEncodingMappings() {
      Map<Locale, String> lem = new HashMap<Locale, String>();
      for (Locale l : localemap.keySet()) {
         lem.put((Locale) l.clone(), localemap.get(l));
      }
      return lem;
   }

   @Override
   public void addLocaleEncodingMapping(Locale locale, String encoding) {
      localemap.put(locale, encoding);
   }
   
   @Override
   public String removeLocaleEncodingMapping(Locale locale) {
      return localemap.remove(locale);
   }

}
