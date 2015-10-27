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

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class processes the web app deployment descriptor and the portlet
 * deployment descriptor files.
 * 
 * 
 * @author Scott Nicklous
 * 
 */
public class ConfigurationHolder {

   private PortletApplicationDefinition   pad = null;
   private ConfigurationProcessor         jcp = null;


   /** Logger. */
   private static final Logger          LOG          = LoggerFactory
                                                           .getLogger(ConfigurationHolder.class);
   private static final boolean         isDebug      = LOG.isDebugEnabled();

   private static final String          JAXB_CONTEXT = "org.apache.pluto.container.om.portlet10.impl:"
                                                           + "org.apache.pluto.container.om.portlet20.impl:"
                                                           + "org.apache.pluto.container.om.portlet30.impl";

   
   /**
    * Default constructor
    */
   public ConfigurationHolder() {
      this.pad = new PortletApplicationDefinitionImpl();
   }
   /**
    * Constructor
    * 
    * @param pad
    */
   public ConfigurationHolder(PortletApplicationDefinition pad) {
      this.pad = pad;
   }

   /**
    * returns the finished portlet application definition
    * 
    * @return  the portlet application definition
    */
   public PortletApplicationDefinition getPad() {
      return pad;
   }

   /**
    * Sets the portlet application definition to be processed
    * 
    * @param pad
    */
   public void setPad(PortletApplicationDefinition pad) {
      this.pad = pad;
   }

   /**
    * Processes the portlet deployment descriptor represented by the given input
    * stream.
    * <p>
    * The data is merged into an existing configuration data structure if one is
    * provided. This capability is used by version 3 portlets for merging config
    * data from the files into config data that has been read from annotations.
    * <p>
    * If no existing configuration data is provides, or if a version 1.0 or
    * version 2.0 deployment descriptor is being processed, a new configuration
    * data structure is created.
    * <p>
    * The class also performs validity checking and throws exceptions for
    * invalid data. To maintain compatibility with the earlier Pluto
    * implementation, an <code>IllegalArgumentException</code> is thrown in such
    * cases.
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
   public void processPortletDD(InputStream stream)
         throws IOException, IllegalArgumentException, JAXBException, XMLStreamException {

      if (isDebug) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Info about classloaders:");
         ClassLoader mycl = this.getClass().getClassLoader();
         ClassLoader jaxbcl = JAXBContext.class.getClassLoader();
         ClassLoader ofcl = org.apache.pluto.container.om.portlet20.impl.ObjectFactory.class.getClassLoader();
         ClassLoader syscl = null;
         try {syscl = ClassLoader.getSystemClassLoader();} catch(Exception e) {}
         txt.append("\nmy classloader: ").append((mycl != null) ? mycl.toString() : "null");
         txt.append("\njaxb classloader: ").append((jaxbcl != null) ? jaxbcl.toString() : "null");
         txt.append("\nof classloader: ").append((ofcl != null) ? ofcl.toString() : "null");
         txt.append("\nsys classloader: ").append((syscl != null) ? syscl.toString() : "null");
         Class<?> myof = null;
         Class<?> jaxbof = null;
         Class<?> ofof = null;
         Class<?> sysof = null;
         String clsName = "org.apache.pluto.container.om.portlet20.impl.ObjectFactory";
         try {myof = mycl.loadClass(clsName);} catch(Exception e) {}
         try {jaxbof = jaxbcl.loadClass(clsName);} catch(Exception e) {}
         try {ofof = ofcl.loadClass(clsName);} catch(Exception e) {}
         try {sysof = syscl.loadClass(clsName);} catch(Exception e) {}
         txt.append("\nNow attempting to load: ").append(clsName);
         txt.append("\nMycl loaded: ").append(myof != null);
         txt.append("\nJaxbofcl loaded: ").append(jaxbof != null);
         txt.append("\nOfcl loaded: ").append(ofof != null);
         txt.append("\nSyscl loaded: ").append(sysof != null);
         LOG.debug(txt.toString());
      }
      
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
      
      if (jel.getValue() instanceof 
            org.apache.pluto.container.om.portlet10.impl.PortletAppType) {

         // Ignore existing config data for 1.0 portlets 
         pad = new PortletApplicationDefinitionImpl();
         jcp = new JSR168ConfigurationProcessor();
         
      } else if (jel.getValue() instanceof 
            org.apache.pluto.container.om.portlet20.impl.PortletAppType) {
         
         // Ignore existing config data for 2.0 portlets
         pad = new PortletApplicationDefinitionImpl();
         jcp = new JSR286ConfigurationProcessor();
         
      } else if (jel.getValue() instanceof 
            org.apache.pluto.container.om.portlet30.impl.PortletAppType) {

         // for v3, let config data from DD overwrite existing data from annotations
         if (pad == null) {
            pad = new PortletApplicationDefinitionImpl();
         }
         jcp = new JSR362ConfigurationProcessor();
         
      } else {
         String warning = "Unknown application type: " + 
               jel.getValue().getClass().getCanonicalName();
         LOG.warn(warning);
         throw new IOException(warning);
      }

      pad = jcp.process(jel);

   }
   
   /**
    * extracts the locale-encoding mapping from the web deployment descriptor
    * 
    * @param in   Input stream for the web DD
    * @throws Exception 
    */
   public void processWebDD(InputStream in) throws Exception {
      if (jcp == null) {
         jcp = new JSR286ConfigurationProcessor();
      }
      jcp.processWebDD(in, pad);
   }

}
