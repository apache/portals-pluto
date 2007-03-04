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
package org.apache.pluto.util.assemble;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.pluto.descriptors.common.InitParamDD;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.services.castor.PortletAppDescriptorServiceImpl;
import org.apache.pluto.descriptors.services.castor.WebAppDescriptorServiceImpl;
import org.apache.pluto.descriptors.servlet.LoadOnStartupDD;
import org.apache.pluto.descriptors.servlet.ServletDD;
import org.apache.pluto.descriptors.servlet.ServletMappingDD;
import org.apache.pluto.descriptors.servlet.WebAppDD;

/**
 * @author Eric Dalquist <a href="mailto:eric.dalquist@doit.wisc.edu">eric.dalquist@doit.wisc.edu</a>
 * @version $Revision$
 * @todo fix direct dependency on pluto-descriptor-impl
 */
public abstract class WebXmlRewritingAssembler implements Assembler {    
    
    /**
     * Updates the webapp descriptor by injecting portlet wrapper servlet
     * definitions and mappings.
     * 
     * @param webXmlIn  input stream to the webapp descriptor, it will be closed before the web xml is written out.
     * @param portletXmlIn  input stream to the portlet app descriptor, it will be closed before the web xml is written out.
     * @param webXmlOut output stream to the webapp descriptor, it will be flushed and closed.
     * @param dispatchServletClass The name of the servlet class to use for
     *                         handling portlet requests
     * @throws IOException
     */
    protected void updateWebappDescriptor(InputStream webXmlIn,
                                              InputStream portletXmlIn,
                                              OutputStream webXmlOut,
                                              String dispatchServletClass)
    throws IOException {

        if (dispatchServletClass == null ||
            dispatchServletClass.length() == 0 ||
            dispatchServletClass.trim().length() == 0) {
            dispatchServletClass = DISPATCH_SERVLET_CLASS;
        }
        
        WebAppDescriptorService descriptorSvc = new WebAppDescriptorServiceImpl();
        WebAppDD webAppDDIn = descriptorSvc.read(webXmlIn);

        PortletAppDescriptorService portletAppDescriptorService =
                new PortletAppDescriptorServiceImpl();
        PortletAppDD portletAppDD = portletAppDescriptorService.read(portletXmlIn);
        portletXmlIn.close();
        
        for (Iterator it = portletAppDD.getPortlets().iterator();
                it.hasNext(); ) {
            
            // Read portlet definition.
            PortletDD portlet = (PortletDD) it.next();
            String name = portlet.getPortletName();

            ServletDD servlet = new ServletDD();
            servlet.setServletName(name);
     
            servlet.setServletClass(dispatchServletClass);

            InitParamDD initParam = new InitParamDD();
            initParam.setParamName("portlet-name");
            initParam.setParamValue(name);
            servlet.getInitParams().add(initParam);
            
            LoadOnStartupDD onStartup = new LoadOnStartupDD();
            onStartup.setPriority(1);
            servlet.setLoadOnStartup(onStartup);

            ServletMappingDD servletMapping = new ServletMappingDD();
            servletMapping.setServletName(name);
            servletMapping.setUrlPattern("/PlutoInvoker/" + name);

            webAppDDIn.getServlets().add(servlet);
            webAppDDIn.getServletMappings().add(servletMapping);
            
        }
        
        descriptorSvc.write(webAppDDIn, webXmlOut);
    }
}
