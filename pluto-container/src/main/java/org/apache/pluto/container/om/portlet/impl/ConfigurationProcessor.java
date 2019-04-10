package org.apache.pluto.container.om.portlet.impl;

import static org.apache.pluto.container.bean.processor.MethodDescription.METH_ACT;
import static org.apache.pluto.container.bean.processor.MethodDescription.METH_DES;
import static org.apache.pluto.container.bean.processor.MethodDescription.METH_EVT;
import static org.apache.pluto.container.bean.processor.MethodDescription.METH_HDR;
import static org.apache.pluto.container.bean.processor.MethodDescription.METH_INI;
import static org.apache.pluto.container.bean.processor.MethodDescription.METH_REN;
import static org.apache.pluto.container.bean.processor.MethodDescription.METH_RES;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.Portlet;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.pluto.container.bean.processor.AnnotatedMethod;
import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.MethodDescription;
import org.apache.pluto.container.bean.processor.MethodIdentifier;
import org.apache.pluto.container.bean.processor.MethodType;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.Supports;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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


public abstract class ConfigurationProcessor {

   /** Logger. */
   private static final Logger            LOG     = LoggerFactory.getLogger(ConfigurationProcessor.class);
   private static final boolean           isDebug = LOG.isDebugEnabled();
   private static final boolean           isTrace = LOG.isTraceEnabled();

   protected PortletApplicationDefinition pad;

   public ConfigurationProcessor(PortletApplicationDefinition pad) {
      this.pad = pad;
   }

   public PortletApplicationDefinition getPad() {
      return pad;
   }

   /**
    * Traverses the portlet deployment descriptor tree and returns the data in the form of a portlet application
    * definition.
    * 
    * @param rootElement
    *           Root element of portlet DD tree
    * @return The parsed portlet application definition
    * @throws IllegalArgumentException
    *            If there is a data validation error
    */
   public abstract void process(JAXBElement<?> rootElement) throws IllegalArgumentException;

   /**
    * Validates the given portlet application definition. This method should only be called after the complete
    * configuration has been read.
    * <p>
    * The validation method is designed to be called within the portlet application servlet context. It throws
    * exceptions when specified classes cannot be loaded or other severe configuration problem is discovered. It logs
    * warnings for less severe configuration problems.
    * <p>
    * The validation code is separate from the configuration reading code so that the config reading code won't cause
    * exceptions when it is used by the maven-portlet-plugin packaging code.
    * 
    * @throws IllegalArgumentException
    *            If there is a validation error.
    */
   public abstract void validate() throws IllegalArgumentException;

   /**
    * Handle the locale the old-fashioned way (v1 & v2)
    */
   protected Locale deriveLocale(String lang) {
      Locale locale = Locale.ENGLISH;
      if (lang != null) {
         if (lang.contains("_") == true) {

            // tolerate underscores to support old portlets
            String[] parts = lang.split("_");
            if (parts.length == 2) {
               locale = new Locale(parts[0], parts[1]);
            } else {
               locale = new Locale(parts[0], parts[1], parts[2]);
            }

         } else {
            locale = Locale.forLanguageTag(lang); // BCP47
         }
      }
      return locale;
   }

   /**
    * Check if input string is valid java identifier
    * 
    * @param id
    * @return
    */
   protected boolean isValidIdentifier(String id) {
      if (id == null || id.length() == 0) {
         return false;
      }
      char[] chars = id.toCharArray();
      if (!Character.isJavaIdentifierStart(chars[0])) {
         return false;
      }
      for (char c : Arrays.copyOfRange(chars, 1, chars.length)) {
         if (!Character.isJavaIdentifierPart(c) && (c != '.')) {
            return false;
         }
      }
      return true;
   }

   /**
    * checks if class name is valid by trying to load it. If the optional argument <code>assignable</code> is provided,
    * the method will check if the class can be assigned.
    * 
    * @param clsName
    *           Class name string from configuration
    * @param assignable
    *           Interface to which the class should be assignable
    * @param msg
    *           Error message used when exception is thrown.
    */
   protected void checkValidClass(String clsName, Class<?> assignable, String msg) {

      StringBuilder txt = new StringBuilder(128);
      txt.append(msg).append(", class name: ");
      txt.append(clsName);
      if (!isValidIdentifier(clsName)) {
         txt.append(". Invalid java identifier.");
         LOG.warn(txt.toString());
         throw new IllegalArgumentException(txt.toString());
      }

      // Make sure the class can be loaded
      Class<?> valClass = null;
      try {
         ClassLoader cl = Thread.currentThread().getContextClassLoader();
         if (cl == null) {
            cl = this.getClass().getClassLoader();
         }
         valClass = cl.loadClass(clsName);
         if (assignable != null && !assignable.isAssignableFrom(valClass)) {
            txt.append(". Specified class is not a ");
            txt.append(assignable.getCanonicalName());
            throw new Exception();
         }
      } catch (Exception e) {
         txt.append(" Exception: ").append(e.toString());
         if (isDebug) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            txt.append("\n").append(sw.toString());
         }
         LOG.warn(txt.toString());
         throw new IllegalArgumentException(txt.toString(), e);
      }
   }

   /**
    * checks if resource bundle name is valid by trying to load it.
    * 
    * @param bundleName
    *           Class name string from configuration
    */
   protected void checkValidBundle(String bundleName) {

      StringBuilder txt = new StringBuilder(128);
      txt.append("Bad resource bundle: ");
      txt.append(bundleName);
      if (!isValidIdentifier(bundleName)) {
         txt.append(". Invalid java identifier.");
         LOG.warn(txt.toString());
         throw new IllegalArgumentException(txt.toString());
      }

      try {
         ClassLoader cl = Thread.currentThread().getContextClassLoader();
         if (cl == null) {
            cl = this.getClass().getClassLoader();
         }
         @SuppressWarnings("unused")
         ResourceBundle rb = ResourceBundle.getBundle(bundleName, Locale.getDefault(), cl);
      } catch (Exception e) {
         LOG.warn(txt.toString());
         throw new IllegalArgumentException(txt.toString(), e);
      }
   }

   /**
    * Generates a unique name for use in cases where the item is ordered by name, but the name is optional to from the
    * point of view of the portlet developer. For example, the filter name need not be specified in the filter
    * annotation, but if it is, the filter config can be modified through a corresponding specification in the portlet
    * deployment descriptor.
    * 
    * @return
    */
   protected String genUniqueName() {

      // create random name
      final String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZüÜäÄöÖß";
      StringBuilder txt = new StringBuilder(128);
      txt.append("Generated:");
      Random rand = new Random();
      for (int ii = 0; ii < 32; ii++) {
         txt.append(chars.charAt(rand.nextInt(chars.length())));
      }
      return txt.toString();

   }

   /**
    * Reads web app deployment descriptor to extract the locale - encoding mappings
    * 
    * @param in
    *           Input stream for DD
    * @throws Exception
    *            If there is a parsing problem
    */
   public void processWebDD(InputStream in) throws Exception {

      // set up document
      DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
      fact.setValidating(false);

      final DocumentBuilder builder = fact.newDocumentBuilder();
      builder.setEntityResolver(new EntityResolver() {
         public InputSource resolveEntity(String arg0, String arg1) throws SAXException, IOException {
            return new InputSource(new StringReader(""));
         }
      });

      final Document document = builder.parse(in);
      final Element root = document.getDocumentElement();

      // Generate xpath queries
      final XPathFactory xpathFactory = XPathFactory.newInstance();
      final XPath xpath = xpathFactory.newXPath();
      final XPathExpression GET_LIST = xpath.compile("//locale-encoding-mapping-list/locale-encoding-mapping");
      final XPathExpression GET_LOC = xpath.compile("locale/text()");
      final XPathExpression GET_ENC = xpath.compile("encoding/text()");

      // get list of locale - encoding mappings and process them
      NodeList nodes = (NodeList) GET_LIST.evaluate(root, XPathConstants.NODESET);

      int mappings = 0;
      for (int jj = 0; jj < nodes.getLength(); jj++) {
         Node node = nodes.item(jj);
         String locstr = (String) GET_LOC.evaluate(node, XPathConstants.STRING);
         String encstr = (String) GET_ENC.evaluate(node, XPathConstants.STRING);
         Locale locale = deriveLocale(locstr);
         pad.addLocaleEncodingMapping(locale, encstr);
         mappings++;
      }
      LOG.debug("done parsing web DD, # mappings: " + mappings);
   }

   /**
    * Extracts the data from the portlet application annotation and adds it to the portlet application definition
    * structure.
    * <p>
    * The default method implementation does nothing. The V3 implementation will override this method to provide
    * function.
    * <p>
    * This method is designed to be called before the portlet deployment descriptor is read so that data from the
    * portlet DD can override that provided through annotations.
    * 
    * @param pa
    *           The portlet application annotation
    */
   public void processPortletAppAnnotation(PortletApplication pa) {
      // default impl = do nothing
   }

   /**
    * Extracts the data from the portlet annotation and adds it to a portlet definition structure. The portlet
    * definition will be created if it does not already exist.
    * <p>
    * The default method implementation does nothing. The V3 implementation will override this method to provide
    * function.
    * <p>
    * This method is designed to be called before the portlet deployment descriptor is read so that data from the
    * portlet DD can override that provided through annotations.
    * 
    * @param pc
    *           The portlet configuration annotation
    * @param cls
    *           The annotated class
    */
   public void processPortletConfigAnnotation(PortletConfiguration pc, Class<?> cls) {
      // default impl = do nothing
   }

   /**
    * Extracts the data from the portlet annotation and adds it to a portlet filter definition structure. The portlet
    * filter definition will be created if it does not already exist.
    * <p>
    * The default method implementation does nothing. The V3 implementation will override this method to provide
    * function.
    * <p>
    * This method is designed to be called before the portlet deployment descriptor is read so that data from the
    * portlet DD can override that provided through annotations.
    * 
    * @param cls
    *           The annotated class.
    */
   public void processPortletFilterAnnotation(Class<?> cls) {
      // default impl = do nothing
   }

   /**
    * Extracts the data from the portlet annotation and adds it to a portlet listener definition structure. The portlet
    * listener definition will be created if it does not already exist.
    * <p>
    * The default method implementation does nothing. The V3 implementation will override this method to provide
    * function.
    * <p>
    * This method is designed to be called before the portlet deployment descriptor is read so that data from the
    * portlet DD can override that provided through annotations.
    * 
    * @param cls
    */
   public void processListenerAnnotation(Class<?> cls) {
   }

   /**
    * Processes PortletPreferencesValidator annotated classes.
    * 
    * @param cls
    */
   public void processValidatorAnnotation(Class<?> cls) {
   }

   /**
    * reconciles the given annotated method store containing the bean configuration with the configuration as read from
    * the portlet deployment descriptor and the corresponding type annotations.
    * <p>
    * Portlets that are defined in the bean config are added to the portlet application definition if not already
    * present. Event reference information from the annotations is verified and added to the corresponding portlet
    * definition.
    * <p>
    * Methods from portlet classes definied in the portlet definitions are added to the annotated method store.
    * 
    * @param ams
    */
   public void reconcileBeanConfig(AnnotatedMethodStore ams) {

      Set<String> portletNames = ams.getPortletNames();
      // the wildcard is only in the store for display / debug purposes. don't reconcile.
      portletNames.remove("*");
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Beginning reconciliation. Annotated portlets: ").append(portletNames.toString());
         LOG.debug(txt.toString());
      }

      ams.setDefaultNamespace(pad.getDefaultNamespace());

      for (String pn : portletNames) {

         // copy data from the method store to the portlet definition

         PortletDefinition pd = pad.getPortlet(pn);
         if (pd == null) {

            // Implied configuration; no portlet.xml or @PortletConfiguration data

            pd = new PortletDefinitionImpl(pn, pad);
         }

         if (pd.getSupports().isEmpty()) {

            // add default and implicitly configured values

            // there can potentially be multiple mime types configured
            Map<String, Supports> mimeSupps = new HashMap<String, Supports>();

            Set<MethodIdentifier> mis = ams.getMethodIDsForPortlet(pn);
            for (MethodIdentifier mi : mis) {
               if (mi.getType() == MethodType.RENDER) {
                  String mode = (String) mi.getId();
                  if (mode.equalsIgnoreCase("view") || mode.equalsIgnoreCase("help") || mode.equalsIgnoreCase("edit")) {
                     List<AnnotatedMethod> meths = ams.getMethods(mi);
                     for (AnnotatedMethod meth : meths) {
                        RenderMethod rm = (RenderMethod) meth.getAnnotation();
                        String mimeType = "*/*";
                        if (rm != null) {
                           mimeType = rm.contentType().replaceAll(" ", "").replaceAll("([^;]+).*", "$1").toLowerCase();
                           mimeType = mimeType.equals("*") ? "*/*" : mimeType;
                        }
                        Supports sup = mimeSupps.get(mimeType);
                        if (sup == null) {
                           sup = new SupportsImpl(mimeType);
                           mimeSupps.put(mimeType, sup);
                        }
                        if (!sup.getPortletModes().contains(mode)) {
                           sup.addPortletMode(mode);
                        }
                     }
                  }
               }
            }
            
            for (Supports sup : mimeSupps.values()) {
               pd.addSupports(sup);
            }
            
            if (isDebug) {
               StringBuilder txt = new StringBuilder();
               txt.append("There are ").append(mimeSupps.size()).append(" unique MIME types configured:");
               for (String mt : mimeSupps.keySet()) {
                  txt.append("\n   MIME: ").append(mt);
                  txt.append(",    portlet modes: ");
                  txt.append(((Supports)mimeSupps.get(mt)).getPortletModes().toString());
               }
               LOG.debug(txt.toString());
            }

         }

         // if one of the @serveResourceMethod annotations has its ayncSupported
         // flag set to true, set the flag to true in the portlet definition

         Set<MethodIdentifier> mis = ams.getMethodIDsForPortlet(pn);
         for (MethodIdentifier mi : mis) {
            if (mi.getType() == MethodType.RESOURCE) {
               List<AnnotatedMethod> meths = ams.getMethods(mi);
               for (AnnotatedMethod meth : meths) {
                  ServeResourceMethod srm = (ServeResourceMethod) meth.getAnnotation();
                  if (srm != null && srm.asyncSupported()) {
                     pd.setAsyncSupported(true);
                  }
               }
            }
         }

         // The processing event references

         List<EventDefinitionReference> edrs = pd.getSupportedProcessingEvents();
         for (QName qn : ams.getProcessingEventRefs(pn)) {
            EventDefinition ed = pad.getEventDefinition(qn);
            if (ed == null) {
               StringBuilder txt = new StringBuilder(128);
               txt.append("No event definition found for annotated processing event reference.");
               txt.append(" Portlet name: ").append(pn);
               txt.append(", QName: ").append(qn);
               LOG.warn(txt.toString());

               // remove the defective method from the store
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), qn, MethodType.EVENT);
               ams.removeMethod(mi);

               continue;
            }
            EventDefinitionReference newedr = new EventDefinitionReferenceImpl(qn);
            if (!edrs.contains(newedr)) {
               pd.addSupportedProcessingEvent(newedr);
            }
         }

         // The publishing event references

         edrs = pd.getSupportedPublishingEvents();
         for (QName qn : ams.getPublishingEventRefs(pn)) {
            EventDefinition ed = pad.getEventDefinition(qn);
            if (ed == null) {
               StringBuilder txt = new StringBuilder(128);
               txt.append("No event definition found for annotated publishing event reference.");
               txt.append(" Portlet name: ").append(pn);
               txt.append(", QName: ").append(qn);
               LOG.warn(txt.toString());
               continue;
            }
            EventDefinitionReference newedr = new EventDefinitionReferenceImpl(qn);
            if (!edrs.contains(newedr)) {
               pd.addSupportedPublishingEvent(newedr);
            }
         }

         pad.addPortlet(pd);
      }

      // Now add the declared portlet class methods to the store

      for (PortletDefinition pd : pad.getPortlets()) {
         Class<?> cls = null;

         String clsName = pd.getPortletClass();
         if (isValidIdentifier(clsName)) {

            // Make sure the class can be loaded
            Class<?> valClass = null;
            StringBuilder txt = new StringBuilder(128);
            try {
               ClassLoader cl = Thread.currentThread().getContextClassLoader();
               if (cl == null) {
                  cl = this.getClass().getClassLoader();
               }
               valClass = cl.loadClass(clsName);
               if (Portlet.class.isAssignableFrom(valClass)) {
                  cls = valClass;
               } else {
                  txt.append("Specified portlet class does not implement the Portlet interface.");
               }
            } catch (Exception e) {
               txt.append("Specified portlet class could not be loaded.");
            } finally {
               if (cls == null) {
                  txt.append(" Portlet name: ").append(pd.getPortletName());
                  txt.append(", Portlet class: ").append(clsName);
                  LOG.warn(txt.toString());
               }
            }
         }

         if (cls != null) {

            // extract the methods from the portlet class and add them to the method store
            // as long there is no corresponding annotated method already present.
            // (annotated methods take precedence over portlet class methods).

            AnnotatedMethod am;
            am = getMethod(cls, "init", METH_INI);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.INIT);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

            am = getMethod(cls, "destroy", METH_DES);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.DESTROY);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

            am = getMethod(cls, "processAction", METH_ACT);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.ACTION);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

            am = getMethod(cls, "processEvent", METH_EVT);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.EVENT);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

            am = getMethod(cls, "render", METH_REN);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.RENDER);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

            am = getMethod(cls, "renderHeaders", METH_HDR);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.HEADER);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

            am = getMethod(cls, "serveResource", METH_RES);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.RESOURCE);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

         }

      }
      
      // At this point we have all portlet methods in the store.
            
      // See if there is a portlet with a wild-card character. If so, then
      // replicate the method identifiers to cover all other portlet names
      
      Set<MethodIdentifier> mis = ams.getMethodIDsForPortlet("*");
      
      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Wild card portlets: ");
         String sep = "";
         for (MethodIdentifier mi : mis) {
            txt.append(sep).append(mi.toString());
            sep = ";";
         }
         LOG.debug(txt.toString());
      }

      for (MethodIdentifier mi : mis) {
         List<AnnotatedMethod> meths = ams.getMethods(mi);
         for (PortletDefinition pd : pad.getPortlets()) {
            MethodIdentifier newMi = new MethodIdentifier(pd.getPortletName(), mi.getId(), mi.getType());
            for (AnnotatedMethod meth : meths) {
               ams.addMethod(newMi, meth);
            }
         }
      }

      // and finally make sure that each portlet has at least one render, header, or serveResource
      // method. If not, delete it.

      List<PortletDefinition> badPortlets = new ArrayList<PortletDefinition>();
      for (PortletDefinition pd : pad.getPortlets()) {

         boolean methodsOK = false;
         for (MethodIdentifier mi : ams.getMethodIDsForPortlet(pd.getPortletName())) {
            if ((mi.getType() == MethodType.RENDER) || (mi.getType() == MethodType.RESOURCE) || (mi.getType() == MethodType.HEADER)) {
               methodsOK = true;
               break;
            }
         }
         if (!methodsOK) {

            ams.removeMethodsForPortlet(pd.getPortletName());
            badPortlets.add(pd);

            StringBuilder txt = new StringBuilder();
            txt.append("Portlet does not have a render, resource, or header method, so cannot be taken into service. ");
            txt.append("Portlet name: ").append(pd.getPortletName());
            LOG.warn(txt.toString());
         }
         
      }

      // if there are bad portlets, delete them from the config
      for (PortletDefinition pd : badPortlets) {
         pad.removePortlet(pd);
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Finished reconciling bean config. ");
         Set<String> finalNames = ams.getPortletNames();
         finalNames.remove("*"); // don't display wildcard
         txt.append("Resulting portlet list: ").append(finalNames.toString());
         LOG.debug(txt.toString());
      }
      
      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append(ams.getMethodsAsString());
         LOG.trace(txt.toString());
      }

   }

   /**
    * Activates the bean methods in the method store. Instantiates any portlet classes and fixes up the method store so
    * that methods of the same class use the same class instance.
    */
   public void instantiatePortlets(AnnotatedMethodStore ams, BeanManager bm) {

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Instantiating the portlets.");
         txt.append(" beanMgr: ").append((bm == null) ? "null" : "not null");
         txt.append(", portlet names: ").append(Arrays.toString(ams.getPortletNames().toArray()));
         LOG.debug(txt.toString());
      }

      ams.activateMethods(bm);

      for (PortletDefinition pd : pad.getPortlets()) {
         Set<Class<?>> processedClasses = new HashSet<Class<?>>();
         String clsName = pd.getPortletClass();
         Object instance = null;

         if (clsName != null) {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
               cl = this.getClass().getClassLoader();
            }
            try {
               Class<?> cls = cl.loadClass(clsName);
               processedClasses.add(cls);

               // Let CDI instantiate the portlet to allow for injection.
               // Get the single bean instance for the portlet class.

               StringBuilder txt = new StringBuilder(128);
               if (bm == null) {
                  txt.append("Could not get portlet bean. Bean manager is null.");
               } else {
                  Set<Bean<?>> beans = bm.getBeans(cls);
                  if (beans == null || beans.size() == 0) {
                     txt.append("Could not get portlet bean. No beans found.");
                  } else {
                     Bean<?> bean = bm.resolve(beans);
                     if (bean == null) {
                        txt.append("Could not get portlet bean. Could not resolve bean.");
                     } else {
                        instance = bm.getReference(bean, bean.getBeanClass(), bm.createCreationalContext(bean));
                        if (instance == null) {
                           txt.append("Could not get portlet bean. Could not get bean instance.");
                        }
                     }
                  }
               }

               // If the instance is still null, the portlet class might not be in a valid bean
               // archive, as a JSR 286 portlet might be. Try to get a regular old instance.

               if (instance == null) {
                  LOG.debug("Could not create bean (possibly not in a valid bean archive). Now directly instantiating class: " + cls.getCanonicalName());
                  try {
                     instance = cls.newInstance();
                  } catch (Exception e) {
                     txt.append(" Exception creating instance of class: ").append(e.toString());
                  }
               }

               // If all went well, fix up the method store with the instance

               if (instance != null) {

                  // The annotated method store might contain methods from the configured
                  // portlet class being processed. For example, this may occur when an action
                  // or event method in the portlet class is annotated to specify processing or
                  // publishing event references. Such annotated methods must use the same bean
                  // instance, so fix up the method store.

                  ams.setPortletClassInstance(pd.getPortletName(), cls, instance);

                  if (isTrace) {
                     StringBuilder str = new StringBuilder();
                     str.append("Updating class instances.");
                     str.append(" portlet name: ").append(pd.getPortletName());
                     str.append(", class: ").append(cls.getCanonicalName());
                     str.append(", instance: ").append((instance == null) ? "null" : "not null");
                     LOG.debug(str.toString());
                  }

               }

               // handle error situation

               if (instance == null) {
                  txt.append(" Portlet name: ").append(pd.getPortletName());
                  txt.append(", portlet class: ").append(cls);
                  LOG.warn(txt.toString());
               }

            } catch (ClassNotFoundException e) {
               LOG.debug("Could not instantiate portlet class: " + clsName);
            }

         }

         if (bm == null) {

            // Running in an environment without CDI support, the portlet classes
            // need to be instantiated in such a way that all methods of a given portlet and
            // a given class use the same instance of that class. Also, annotated portlet
            // methods can appear in classes that do not implement the Portlet interface
            // and those classes need to be instantiated as well.

            for (MethodIdentifier mi : ams.getMethodIDsForPortlet(pd.getPortletName())) {
               for (AnnotatedMethod am : ams.getMethods(mi)) {
                  Class<?> cls = am.getBeanClass();
                  if (!processedClasses.contains(cls)) {
                     processedClasses.add(cls);
                     try {
                        instance = cls.newInstance();
                        ams.setPortletClassInstance(pd.getPortletName(), cls, instance);
                     } catch (Exception e) {
                        StringBuilder txt = new StringBuilder(128);
                        txt.append("Exception creating instance of class: ").append(e.toString());
                        txt.append(" Portlet name: ").append(pd.getPortletName());
                        txt.append(", portlet class: ").append(cls);
                        LOG.warn(txt.toString());
                     }
                  }
               }
            }

         }
      }
   }

   /**
    * helper method for extracting the portlet methods from the portlet class.
    * 
    * @param cls
    * @param name
    * @param md
    * @return
    */
   private AnnotatedMethod getMethod(Class<?> cls, String name, MethodDescription md) {
      AnnotatedMethod am = null;
      try {
         Method meth = cls.getMethod(name, md.getArgTypes());
         am = new AnnotatedMethod(cls, null, meth, md);
      } catch (Exception e) {
         if (isDebug) {
            StringBuilder txt = new StringBuilder();
            txt.append("Could not retrieve method from portlet class.");
            txt.append(" Method name: ").append(name);
            txt.append(", Class: ").append(cls.getCanonicalName());
            txt.append(", Argument types: ").append(md.getArgTypes());
            LOG.debug(txt.toString());
         }
      }
      return am;
   }

}