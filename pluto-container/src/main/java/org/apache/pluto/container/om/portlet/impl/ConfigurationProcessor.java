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
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.Portlet;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class ConfigurationProcessor {
   
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(ConfigurationProcessor.class);
   private static final boolean isDebug = LOG.isDebugEnabled();


   protected PortletApplicationDefinition pad;
   
   public ConfigurationProcessor(PortletApplicationDefinition pad) {
      this.pad = pad;
   }

   public PortletApplicationDefinition getPad() {
      return pad;
   }

   /**
    * Traverses the portlet deployment descriptor tree and returns the data in
    * the form of a portlet application definition.
    * 
    * @param rootElement
    *           Root element of portlet DD tree
    * @return The parsed portlet application definition
    * @throws IllegalArgumentException
    *            If there is a data validation error
    */
   public abstract void process(JAXBElement<?> rootElement) throws IllegalArgumentException;

   /**
    * Validates the given portlet application definition. This method should only be called after 
    * the complete configuration has been read.
    * <p>
    * The validation method is designed to be called within the portlet application servlet context.
    * It throws exceptions when specified classes cannot be loaded or other severe configuration
    * problem is discovered. It logs warnings for less severe configuration problems.
    * <p>
    * The validation code is separate from the 
    * configuration reading code so that the config reading code won't cause exceptions when it 
    * is used by the maven-portlet-plugin packaging code. 
    * 
    * @throws IllegalArgumentException
    *             If there is a validation error.
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
            locale = Locale.forLanguageTag(lang);     //BCP47
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
    * checks if class name is valid by trying to load it. If the optional
    * argument <code>assignable</code> is provided, the method will check if the
    * class can be assigned.
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
    * Generates a unique name for use in cases where the item is ordered by name, but the name 
    * is optional to from the point of view of the portlet developer. For example, the filter name
    * need not be specified in the filter annotation, but if it is, the filter config can be
    * modified through a corresponding specification in the portlet deployment descriptor.
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
    * @param in            Input stream for DD
    * @throws Exception    If there is a parsing problem
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
      final XPathExpression GET_LIST = 
            xpath.compile("//locale-encoding-mapping-list/locale-encoding-mapping");
      final XPathExpression GET_LOC = xpath.compile("locale/text()");
      final XPathExpression GET_ENC = xpath.compile("encoding/text()");

      // get list of locale - encoding mappings and process them
      NodeList nodes = (NodeList) GET_LIST.evaluate(root,
            XPathConstants.NODESET);

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
    * Extracts the data from the portlet application annotation and adds it to the 
    * portlet application definition structure.
    * <p>
    * The default method implementation does nothing. The V3 implementation will
    * override this method to provide function.  
    * <p>
    * This method is designed to be called before the portlet deployment descriptor
    * is read so that data from the portlet DD can override that provided through annotations.
    * 
    * @param pa      The portlet application annotation
    */
   public void processPortletAppAnnotation(PortletApplication pa) {
      // default impl = do nothing
   }
   
   /**
    * Extracts the data from the portlet annotation and adds it to a 
    * portlet definition structure. The portlet definition will be created if it does not
    * already exist.
    * <p>
    * The default method implementation does nothing. The V3 implementation will
    * override this method to provide function.  
    * <p>
    * This method is designed to be called before the portlet deployment descriptor
    * is read so that data from the portlet DD can override that provided through annotations.
    * 
    * @param pc   The portlet configuration annotation
    * @param cls  The annotated class
    */
   public void processPortletConfigAnnotation(PortletConfiguration pc, Class<?> cls) {
      // default impl = do nothing
   }

   
   /**
    * Extracts the data from the portlet annotation and adds it to a 
    * portlet filter definition structure. The portlet filter definition will be created if it does not
    * already exist.
    * <p>
    * The default method implementation does nothing. The V3 implementation will
    * override this method to provide function.  
    * <p>
    * This method is designed to be called before the portlet deployment descriptor
    * is read so that data from the portlet DD can override that provided through annotations.
    * 
    * @param cls     The annotated class. 
    */
   public void processPortletFilterAnnotation(Class<?> cls) {
      // default impl = do nothing
   }

   /**
    * Extracts the data from the portlet annotation and adds it to a 
    * portlet listener definition structure. The portlet listener definition will be created if it does not
    * already exist.
    * <p>
    * The default method implementation does nothing. The V3 implementation will
    * override this method to provide function.  
    * <p>
    * This method is designed to be called before the portlet deployment descriptor
    * is read so that data from the portlet DD can override that provided through annotations.
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
    * reconciles the given annotated method store containing the bean configuration
    * with the configuration as read from the portlet deployment descriptor and 
    * the corresponding type annotations.
    * <p>
    * Portlets that are defined in the bean config are added to the portlet application
    * definition if not already present. Event reference information from the 
    * annotations is verified and added to the corresponding portlet definition.
    * <p>
    * Methods from portlet classes definied in the portlet definitions are
    * added to the annotated method store.
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
            pd = new PortletDefinitionImpl(pn, pad);
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
      
      List<PortletDefinition> badPortlets = new ArrayList<PortletDefinition>();
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
         
         Object instance = null;
         if (cls != null) {
            
            // Let CDI instantiate the portlet to allow for injection. 
            // Get the single bean instance for the portlet class.
            
            StringBuilder txt = new StringBuilder(128);
            BeanManager bm = ams.getBeanMgr();
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
               } catch(Exception e) {
                  txt.append(" Exception creating instance of class: ").append(e.toString());
               }
            }
            
            
            if ((instance == null) && (txt.length() > 0)) {
               txt.append(" Portlet name: ").append(pd.getPortletName());
               txt.append(", portlet class: ").append(cls);
               LOG.warn(txt.toString());
            }
         }

         if (instance != null) {
            
            // The annotated method store might contain methods from the configured
            // portlet class being processed. For example, this may occur when an action
            // or event method in the portlet class is annotated to specify processing or
            // publishing event references. Such annotated methods must use the same bean
            // instance, so fix up the method store.
            
            ams.setPortletClassInstance(pd.getPortletName(), cls, instance);

            // extract the methods from the portlet class and add them to the method store
            // as long there is no corresponding annotated method already present.
            // (annotated methods take precedence over portlet class methods). 
            
            AnnotatedMethod am;
            am = getMethod(instance, "init", METH_INI);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.INIT);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }
            
            am = getMethod(instance, "destroy", METH_DES);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.DESTROY);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }
            
            am = getMethod(instance, "processAction", METH_ACT);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.ACTION);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }
            
            am = getMethod(instance, "processEvent", METH_EVT);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.EVENT);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }
            
            am = getMethod(instance, "render", METH_REN);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.RENDER);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }
            
            am = getMethod(instance, "renderHeaders", METH_HDR);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.HEADER);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }
            
            am = getMethod(instance, "serveResource", METH_RES);
            if (am != null) {
               MethodIdentifier mi = new MethodIdentifier(pd.getPortletName(), "", MethodType.RESOURCE);
               if (ams.getMethods(mi).size() == 0) {
                  ams.addMethod(mi, am);
               }
            }

         }
         
         // and finally make sure that the portlet has at least one render, header, or serveResource
         // method. If not, delete it.
         
         boolean methodsOK = false;
         for (MethodIdentifier mi : ams.getMethodIDsForPortlet(pd.getPortletName())) {
            if ((mi.getType() == MethodType.RENDER) || (mi.getType() == MethodType.RESOURCE) ||
                  (mi.getType() == MethodType.HEADER)) {
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
         finalNames.remove("*");    // don't display wildcard
         txt.append("Resulting portlet list: ").append(finalNames.toString());
         LOG.debug(txt.toString());
      }
      
   }
   
   /**
    * helper method for extracting the portlet methods from the portlet class.
    * @param cls
    * @param name
    * @param md
    * @return
    */
   private AnnotatedMethod getMethod(Object instance, String name, MethodDescription md) {
      AnnotatedMethod am = null;
      Class<?> cls = instance.getClass();
      try {
         Method meth = cls.getMethod(name, md.getArgTypes());
         am = new AnnotatedMethod(cls, instance, meth, md);
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