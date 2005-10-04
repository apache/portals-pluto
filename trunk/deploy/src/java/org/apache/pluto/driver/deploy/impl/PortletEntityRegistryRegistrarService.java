/*
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.deploy.impl;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
import org.apache.pluto.driver.deploy.PortalRegistrarService;

/**
 * Service Implementation used by the command line deployer
 * to register portlet applications with the Portal.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 6, 2005
 */
public class PortletEntityRegistryRegistrarService
 implements PortalRegistrarService {

    private static final String REGISTRY_FILE =
        "WEB-INF/data/portletentityregistry.xml";

    private File portalRoot;

    /**
     * Default Constructor wich provides the root of
     * the portal application.
     *
     * @param portalRoot
     */
    public PortletEntityRegistryRegistrarService(File portalRoot) {
        this.portalRoot = portalRoot;
    }

    /**
     * Register the portlet application represented by the
     * descriptor service provided.
     * @param service service used to obtain desc info.
     */
    public void register(PortletAppDescriptorService service)
    throws IOException {
        System.out.println("<VERBOSE> Registering application '"+service.getContextPath()+"'");

        File file = new File(portalRoot, REGISTRY_FILE);
        RandomAccessFile ras = new RandomAccessFile(file, "rw");
        long length = ras.length();
        byte[] contentByte = new byte[(int) length];
        ras.read(contentByte);
        String contentString = new String(contentByte);
        long pos = contentString.indexOf("<definition-id>"+service.getContextPath()+"</definition-id>");
        if(pos > 0) {
            System.out.println("<VERBOSE> Found previous entity registery; Registration Aborted.");
            ras.close();
            return;
        }
        pos = contentString.lastIndexOf("</portlet-entity-registry>");
        ras.seek(pos);
        ras.writeBytes("    <application id=\"" + service.getContextPath() + "\">\n");
        ras.writeBytes("        <definition-id>" + service.getContextPath() + "</definition-id>\n");

        PortletAppDD app = service.read();
        PortletDD p;
        Iterator i = app.getPortlets().iterator();
        while(i.hasNext()) {
            p = (PortletDD)i.next();
            ras.writeBytes("        <portlet id=\"" + p.getPortletName() + "\">\n");
            ras.writeBytes("            <definition-id>" + service.getContextPath()
                               + "." + p.getPortletName() + "</definition-id>\n");
            ras.writeBytes("        </portlet>\n");
        }
        ras.writeBytes("    </application>\n");
        ras.writeBytes("</portlet-entity-registry>\n");
        ras.close();
    }
}

