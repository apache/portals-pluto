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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletConfigurations;
import javax.portlet.annotations.PortletListener;
import javax.portlet.annotations.PortletPreferencesValidator;
import javax.portlet.annotations.PortletLifecycleFilter;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.pluto.container.bean.processor.AnnotatedMethodStore;
import org.apache.pluto.container.bean.processor.ConfigSummary;
import org.apache.pluto.container.bean.processor.MethodAnnotationRecognizer;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class processes the web app deployment descriptor and the portlet deployment descriptor files.
 * 
 * 
 * @author Scott Nicklous
 * 
 */
public class ConfigurationHolder {

   public static final String           ATTRIB_NAME  = "PortletAppConfig";
   private PortletApplicationDefinition pad          = null;
   private ConfigurationProcessor       jcp          = null;

   /** Logger. */
   private static final Logger          LOG          = LoggerFactory.getLogger(ConfigurationHolder.class);
   private static final boolean         isDebug      = LOG.isDebugEnabled();

   private static final String          JAXB_CONTEXT = "org.apache.pluto.container.om.portlet10.impl:"
                                                           + "org.apache.pluto.container.om.portlet20.impl:"
                                                           + "org.apache.pluto.container.om.portlet30.impl";

   private ConfigSummary configSummary = new ConfigSummary();
   private AnnotatedMethodStore methodStore = new AnnotatedMethodStore(configSummary);
   private boolean portletsInstantiated = false;
   
   /**
    * Default constructor
    */
   public ConfigurationHolder() {
      this.pad = new PortletApplicationDefinitionImpl();
   }

   /**
    * Constructor taking existing portlet app definition - for testing purposes
    * @param pad
    */
   public ConfigurationHolder(PortletApplicationDefinition pad) {
      this.pad = pad;
   }

   /**
    * returns the finished portlet application definition
    * 
    * @return the portlet application definition
    */
   public PortletApplicationDefinition getPad() {
      return pad;
   }

   /**
    * @return the methodStore
    */
   public AnnotatedMethodStore getMethodStore() {
      return methodStore;
   }

   /**
    * @param methodStore the methodStore to set
    */
   public void setMethodStore(AnnotatedMethodStore methodStore) {
      this.methodStore = methodStore;
   }

   /**
    * @return the configSummary
    */
   public ConfigSummary getConfigSummary() {
      return configSummary;
   }

   /**
    * @param configSummary the configSummary to set
    */
   public void setConfigSummary(ConfigSummary configSummary) {
      this.configSummary = configSummary;
   }

   /**
    * Processes the portlet deployment descriptor represented by the given input stream.
    * <p>
    * The data is merged into an existing configuration data structure if one is provided. This capability is used by
    * version 3 portlets for merging config data from the files into config data that has been read from annotations.
    * <p>
    * If no existing configuration data is provides, or if a version 1.0 or version 2.0 deployment descriptor is being
    * processed, a new configuration data structure is created.
    * <p>
    * The class also performs validity checking and throws exceptions for invalid data. To maintain compatibility with
    * the earlier Pluto implementation, an <code>IllegalArgumentException</code> is thrown in such cases.
    * 
    * 
    * @param stream
    *           Input stream pointing to deployment descriptor
    * @return The resulting portlet application definition
    * @throws IOException
    *            If an I/O error occurs
    * @throws IllegalArgumentException
    *            If data validation fails
    * @throws XMLStreamException
    */
   public void processPortletDD(InputStream stream) throws IOException, IllegalArgumentException, JAXBException,
         XMLStreamException {

      ClassLoader mycl = this.getClass().getClassLoader();
      JAXBContext cntxt = JAXBContext.newInstance(JAXB_CONTEXT, mycl);

      Unmarshaller um = cntxt.createUnmarshaller();
      XMLInputFactory xif = XMLInputFactory.newFactory();
      XMLStreamReader xsr = xif.createXMLStreamReader(stream);
      JAXBElement<?> jel = (JAXBElement<?>) um.unmarshal(xsr);

      if (jel == null) {
         String warning = "Nothing could be unmarshalled. Stream didn't produce object";
         LOG.warn(warning);
         throw new IOException(warning);
      }

      if (isDebug) {
         StringBuilder txt = new StringBuilder();
         txt.append("Unmarshalled stream. ===> Object type: ");
         txt.append(jel.getValue().getClass().getCanonicalName());
         LOG.debug(txt.toString());
      }

      if (jel.getValue() instanceof org.apache.pluto.container.om.portlet10.impl.PortletAppType) {

         // Ignore existing config data for 1.0 portlets
         pad = new PortletApplicationDefinitionImpl();
         jcp = new JSR168ConfigurationProcessor(pad);

      } else if (jel.getValue() instanceof org.apache.pluto.container.om.portlet20.impl.PortletAppType) {

         // Ignore existing config data for 2.0 portlets
         pad = new PortletApplicationDefinitionImpl();
         jcp = new JSR286ConfigurationProcessor(pad);

      } else if (jel.getValue() instanceof org.apache.pluto.container.om.portlet30.impl.PortletAppType) {

         // if config processor already present, there were annotations. don't overwrite
         jcp = (jcp == null) ? new JSR362ConfigurationProcessor(pad) : jcp;

      } else {
         String warning = "Unknown application type: " + jel.getValue().getClass().getCanonicalName();
         LOG.warn(warning);
         throw new IOException(warning);
      }

      jcp.process(jel);

      if (isDebug) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Parsed DD for Portlet app: ").append(pad.getName());
         txt.append(", # portlets: ").append(pad.getPortlets().size());
         txt.append(", names: ");
         String sep = "";
         for (PortletDefinition pd : pad.getPortlets()) {
            txt.append(sep).append(pd.getPortletName());
            sep = ", ";
         }
         LOG.debug(txt.toString());
      }

   }

   /**
    * extracts the locale-encoding mapping from the web deployment descriptor
    * 
    * @param in
    *           Input stream for the web DD
    * @throws Exception
    */
   public void processWebDD(InputStream in) throws Exception {
      if (jcp == null) {
         jcp = new JSR286ConfigurationProcessor(pad);
      }
      jcp.processWebDD(in);
   }

   /**
    * Accepts a list of classes that are annotated with portlet configuration and portlet application configuration
    * annotations. Extracts the config data from the annotations to create a corresponding portlet application
    * definition structure.
    * <p>
    * This method must be called before processing the portlet xml so that the data from the portlet DD may properly
    * override the annotation configuration data.
    * <p>
    * This method is designed to be used within a ServletContainerInitializer onStartup() method. The SCI should be
    * annotated as follows: <code>@HandlesTypes({PortletApplication.class, PortletConfiguration.class, #
    * PortletConfigurations.class, PortletLifecycleFilter.class})</code>
    * 
    * @param classes
    *           List of classes annotated with portlet config annotations
    */
   public void processConfigAnnotations(Set<Class<?>> classes) {
      if (classes != null) {
         jcp = new JSR362ConfigurationProcessor(pad);
         for (Class<?> cls : classes) {
            
            PortletApplication pa = cls.getAnnotation(PortletApplication.class);
            if (pa != null) {
               jcp.processPortletAppAnnotation(pa);
            }
            
            PortletConfiguration pc = cls.getAnnotation(PortletConfiguration.class);
            if (pc != null) {
               jcp.processPortletConfigAnnotation(pc, cls);
            }
            
            PortletConfigurations pcs = cls.getAnnotation(PortletConfigurations.class);
            if (pcs != null) {
               for (PortletConfiguration config : pcs.value()) {
                  jcp.processPortletConfigAnnotation(config, cls);
               }
            }
            
            if (cls.getAnnotation(PortletLifecycleFilter.class) != null) {
               jcp.processPortletFilterAnnotation(cls);
            }
            
            if (cls.getAnnotation(PortletListener.class) != null) {
               jcp.processListenerAnnotation(cls);
            }
            
            if (cls.getAnnotation(PortletPreferencesValidator.class) != null) {
               jcp.processValidatorAnnotation(cls);
            }
            
         }
      }
   }

   /**
    * validates the configuration. To be called after the configuration has been completely read.
    */
   public void validate() {
      if (jcp == null) {
         jcp = new JSR362ConfigurationProcessor(pad);
      }
      jcp.validate();
   }

   /**
    * Reconciles the bean configuration with the config from annotations & portlet DD.
    */
   public void reconcileBeanConfig() {
      if (jcp == null) {
         jcp = new JSR362ConfigurationProcessor(pad);
      }
      jcp.reconcileBeanConfig(methodStore);
   }

   /**
    * Instantiates the portlets with the helpt of the bean manager. If the bean 
    * manager is <code>null</code>, the classes are instantiated the old-fashioned way.
    * 
    * @param bm   the bean manager; may be <code>null</code>
    */
   public void instantiatePortlets(BeanManager bm) {
      
      // This method will be called once for each deployed portlet servlet. However,
      // it's important that the methods only be instantiated once per servlet context 
      // to avoid losing initialization data.
      
      if (!portletsInstantiated) {
         portletsInstantiated = true;
         jcp.instantiatePortlets(methodStore, bm);
      }
   }

//    /**
//     * Reconciles the bean configuration with the config from annotations & portlet DD.
//     */
//    public void reconcileBeanConfig(AnnotatedMethodStore ams) {
//       if (jcp == null) {
//          jcp = new JSR362ConfigurationProcessor(pad);
//       }
//       jcp.reconcileBeanConfig(ams);
//       jcp.instantiatePortlets(ams, ams.getBeanMgr());
//    }
   
   /**
    * Scans servlet context for method annotations.
    * 
    * @param ctx  the servlet context
    */
   public void scanMethodAnnotations(ServletContext ctx) {
      MethodAnnotationRecognizer mar = new MethodAnnotationRecognizer(methodStore, configSummary);
      mar.scanContext(ctx);
      LOG.debug("Scan complete: \n" + methodStore.getMethodsAsString());
   }
   
   /**
    * Scans list of files for method annotations that do not conform to MVC signatures.
    * (unit test execution path)
    *
    * @param files   the set of files to scan
    */
   public void scanMethodAnnotations(Set<File> files) {
      scanMethodAnnotations(files, false);
   }

   /**
    * Scans list of files for method annotations.
    * (unit test execution path)
    * 
    * @param files   the set of files to scan
    * @param mvc     flag indicating whether or not MVC method signatures are permitted
    */
   public void scanMethodAnnotations(Set<File> files, boolean mvc) {
      MethodAnnotationRecognizer mar = new MethodAnnotationRecognizer(methodStore, configSummary, mvc);
      mar.scanFiles(files);
      LOG.debug("Scan complete: \n" + methodStore.getMethodsAsString());
   }

}
