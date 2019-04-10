/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import org.apache.pluto.container.PortletAppDescriptorService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service that reads the portlet deployment descriptor.
 */

public class PortletAppDescriptorServiceImpl implements PortletAppDescriptorService {
   
   /** Logger. */
   private static final Logger LOG = LoggerFactory.getLogger(PortletAppDescriptorServiceImpl.class);
   @SuppressWarnings("unused")
   private static final boolean isDebug = LOG.isDebugEnabled();
   

   public PortletAppDescriptorServiceImpl() {
   }

   /**
    * Read the Web Application Deployment Descriptor.
    * 
    * @return WebAppDD instance representing the descriptor.
    * @throws java.io.IOException
    */
   public PortletApplicationDefinition read(String name, String contextPath,
         InputStream in) throws IOException {
      if (in == null) {
         throw new IOException("Cannot read from a null InputStream");
      }

      PortletApplicationDefinition pad        = null;
      ConfigurationHolder          confHolder = new ConfigurationHolder();

      // read the deployment descriptor
      try {
         confHolder.processPortletDD(in);
         pad = confHolder.getPad();
      } catch (XMLStreamException | IllegalArgumentException | JAXBException e) {
         final IOException ioe = new IOException(e.getLocalizedMessage());
         ioe.initCause(e);
         throw ioe;
      }

      pad.setName(name);
      pad.setContextPath(contextPath);

      return pad;
   }

   public void mergeWebDescriptor(PortletApplicationDefinition pad,
         InputStream webDescriptor) throws Exception {
      
//       ConfigurationHolder confHolder = new ConfigurationHolder(pad);
//       confHolder.processWebDD(webDescriptor);
//       
//       if (isDebug) {
//          StringBuilder txt = new StringBuilder(128);
//          txt.append("Processed web DD for Portlet app: ").append(pad.getName());
//          txt.append(", context path: ").append(pad.getContextPath());
//          txt.append(", # portlets: ").append(pad.getPortlets().size());
//          txt.append(", names: ");
//          String sep = "";
//          for (PortletDefinition pd : pad.getPortlets()) {
//             txt.append(sep).append(pd.getPortletName());
//             sep = ", ";
//          }
//          LOG.debug(txt.toString());
//       }
   }

   /**
    * Write the deployment descriptor.
    * 
    * @param app
    * @throws java.io.IOException
    */
   public void write(PortletApplicationDefinition app, OutputStream out) throws IOException {
//       try {
//          final Object src;
//          if (PortletApplicationDefinition.JSR_168_VERSION.equals(app
//                .getVersion())) {
//             // src = new
//             // org.apache.pluto.container.om.portlet10.impl.PortletAppType(app);
//          } else {
//             src = app;
//          }
//          final Marshaller marshaller = this.jaxbContext.createMarshaller();
//          marshaller.setEventHandler(new DefaultValidationEventHandler());
//          marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//          // marshaller.marshal(src,out);
//       } catch (JAXBException jaxbEx) {
//          final IOException ioe = new IOException(jaxbEx.getMessage());
//          ioe.initCause(jaxbEx);
//          throw ioe;
//       } catch (Exception me) {
//          final IOException ioe = new IOException(me.getLocalizedMessage());
//          ioe.initCause(me);
//          throw ioe;
//       }
   }

}
