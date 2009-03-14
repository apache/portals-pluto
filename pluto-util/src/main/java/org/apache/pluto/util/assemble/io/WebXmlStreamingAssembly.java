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
package org.apache.pluto.util.assemble.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.pluto.container.impl.PortletAppDescriptorServiceImpl;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.util.assemble.Assembler;
import org.apache.pluto.util.descriptors.web.PlutoWebXmlRewriter;

/**
 * Utility class responsible for accepting web.xml and portlet.xml as InputStreams, and assembling the web.xml to an
 * OutputStream.
 */
public class WebXmlStreamingAssembly
{
    /**
     * Assembles the web.xml represented by the <code>InputStream</code>.
     * 
     * @param webXmlIn
     *            the unassembled web.xml file
     * @param portletXmlIn
     *            the corresponding portlet.xml file
     * @param assembledWebXmlOut
     *            the assembled web.xml file
     * @param dispatchServletClass
     *            the dispatch servlet
     * @throws IOException
     */
    public static void assembleStream(InputStream webXmlIn, InputStream portletXmlIn, OutputStream assembledWebXmlOut,
                                      String dispatchServletClass) throws IOException
    {
        if (dispatchServletClass == null || dispatchServletClass.length() == 0 ||
            dispatchServletClass.trim().length() == 0)
        {
            dispatchServletClass = Assembler.DISPATCH_SERVLET_CLASS;
        }
        PlutoWebXmlRewriter webXmlRewriter = null;
        try
        {
            webXmlRewriter = new PlutoWebXmlRewriter(webXmlIn);
        }
        catch (Exception e)
        {
            if (e instanceof IOException)
            {
                throw (IOException) e;
            }
            throw new IOException(e.getMessage());
        }
        PortletApplicationDefinition portletAppDD = new PortletAppDescriptorServiceImpl().read("test", "/test", portletXmlIn);
        portletXmlIn.close();
        for (PortletDefinition portlet : portletAppDD.getPortlets())
        {
            webXmlRewriter.injectPortletServlet(dispatchServletClass, portlet.getPortletName());
        }
        webXmlRewriter.write(assembledWebXmlOut);
    }
}
