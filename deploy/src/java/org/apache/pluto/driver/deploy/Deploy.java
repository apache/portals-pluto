/*
 * Copyright 2003,2004 The Apache Software Foundation.
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

package org.apache.pluto.driver.deploy;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.apache.pluto.descriptors.common.InitParamDD;
import org.apache.pluto.descriptors.common.SecurityRoleRefDD;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.services.PortletAppDescriptorService;
import org.apache.pluto.descriptors.services.WebAppDescriptorService;
import org.apache.pluto.descriptors.servlet.SecurityRoleDD;
import org.apache.pluto.descriptors.servlet.ServletDD;
import org.apache.pluto.descriptors.servlet.ServletMappingDD;
import org.apache.pluto.descriptors.servlet.WebAppDD;

public class Deploy {

    private static final String INVOKER_SERVLET =
        "org.apache.pluto.core.PortletServlet";

    // Services Which Must Be Initiated
    private WebAppDescriptorService webAppDescriptorService;
    private PortletAppDescriptorService portletAppDescriptorService;

    // Private Services we use internally but don't
    // want to expose to the rest of the work - yet.
    private PortletApplicationExploder exploder;
    private List registrars = new ArrayList();

    private boolean debug = false;

    public Deploy(WebAppDescriptorService webAppDescriptorService,
                  PortletAppDescriptorService portletAppDescriptorService) {
        this.webAppDescriptorService = webAppDescriptorService;
        this.portletAppDescriptorService = portletAppDescriptorService;
    }

    /**
     * Service Getter.
     * @return
     */
    public WebAppDescriptorService getWebAppDDService() {
        return webAppDescriptorService;
    }

    /**
     * Service Setter.
     */
    public void setWebAppDDService(WebAppDescriptorService webAppDescriptorService) {
        this.webAppDescriptorService = webAppDescriptorService;
    }

    /**
     * Service Getter.
     * @return
     */
    public PortletAppDescriptorService getPortletAppDDService() {
        return portletAppDescriptorService;
    }

    /**
     * Service Setter.
     * @param portletAppDescriptorService
     */
    public void setPortletAppDDService(PortletAppDescriptorService portletAppDescriptorService) {
        this.portletAppDescriptorService = portletAppDescriptorService;
    }

    PortletApplicationExploder getExploder() {
        return exploder;
    }

    void setExploder(PortletApplicationExploder exploder) {
        this.exploder = exploder;
    }

    List getRegistrars() {
        return registrars;
    }

    void setRegistrars(List registrars) {
        this.registrars = registrars;
    }

    void addRegistrar(PortalRegistrarService registrar) {
        this.registrars.add(registrar);
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    /**
     * Deploy the war file at the given location
     * utilizing the preconfigured resources.
     *
     * @param warFile
     * @throws IOException
     */
    public void deploy(File warFile) throws IOException {
        if(exploder != null) {
            exploder.explode(warFile);
        }
        updateDescriptors();
        Iterator it = registrars.iterator();
        PortalRegistrarService registrar = null;
        while(it.hasNext()) {
            registrar = (PortalRegistrarService)it.next();
            registrar.register(portletAppDescriptorService);
        }
    }

    public void updateDescriptors()
        throws IOException {
        PortletAppDD portletApp = portletAppDescriptorService.read();
        WebAppDD webApp = webAppDescriptorService.read();

        Iterator portlets = portletApp.getPortlets().iterator();
        PortletDD portlet;
        while (portlets.hasNext()) {
            portlet = (PortletDD) portlets.next();
            createServlet(webApp, portlet);
            createServletMapping(webApp, portlet);
        }

        this.webAppDescriptorService.write(webApp);
    }




    private void createServlet(WebAppDD webApp, PortletDD portlet) {
        if(debug) {
            System.out.println("<VERBOSE> Creating Servlet Wrapper for Portlet: '"+portlet.getPortletName()+"'");
        }
        String pnm = portlet.getPortletName();
        // check if already exists
        ServletDD servlet = webApp.getServlet(pnm);
        if (servlet != null) {
            String cl = servlet.getServletClass();
            if (!INVOKER_SERVLET.equals(cl)) {
                System.out.println(
                    "Note: Replaced already existing the servlet with the name '"
                    + pnm
                    + "' with the wrapper servlet."
                );
                servlet.setServletClass(INVOKER_SERVLET);
            }
        } else {
            servlet = new ServletDD();
            servlet.setServletName(pnm);
            servlet.setServletClass(INVOKER_SERVLET);
            webApp.getServlets().add(servlet);
        }

        servlet.setDisplayName(pnm + "Wrapper (Pluto Invoker)");
        servlet.setDescription("Auto Generated Portlet Invoker Servlet");

        InitParamDD param = new InitParamDD();
        param.setParamName("portlet-class");
        param.setParamValue(portlet.getPortletClass());
        servlet.getInitParams().add(param);

        param = new InitParamDD();
        param.setParamName("portlet-guid");
        param.setParamValue(portletAppDescriptorService.getContextPath()+"."+portlet.getPortletName());
        servlet.getInitParams().add(param);

        createSecurityRoleRefs(webApp, servlet, portlet);
    }

    private void createSecurityRoleRefs(WebAppDD webApp,
                                        ServletDD servlet,
                                        PortletDD portlet) {

        HashMap sRefs = new HashMap();
        List sSecRoleRefs = servlet.getSecurityRoleRefs();
        Iterator i = sSecRoleRefs.iterator();
        SecurityRoleRefDD srr;
        while(i.hasNext()) {
            srr = (SecurityRoleRefDD)i.next();
            sRefs.put(srr.getRoleName(), srr);
        }

        HashMap wRoles = new HashMap();
        i = webApp.getSecurityRoles().iterator();
        SecurityRoleDD sr;
        while(i.hasNext()) {
            sr = (SecurityRoleDD)i.next();
            wRoles.put(sr.getRoleName(), sr);
        }

        Collection pRoles = portlet.getSecurityRoleRefs();
        Iterator p = pRoles.iterator();
        SecurityRoleRefDD pRole;
        while(p.hasNext()) {
            pRole = (SecurityRoleRefDD) p.next();
            if (pRole.getRoleLink()==null
                && wRoles.get(pRole.getRoleName())==null) {
                    System.out.println(
                        "Note: The web application has no security role defined which matches the role name \""
                        + pRole.getRoleName()
                        + "\" of the security-role-ref element defined for the wrapper-servlet with the name '"
                        + portlet.getPortletName()
                        + "'.");
                    break;
            }
            SecurityRoleRefDD sRR = (SecurityRoleRefDD)
                sRefs.get(pRole.getRoleName());

            if (null != sRR) {
                System.out.println("Note: Replaced already existing element of type <security-role-ref> with value \""
                        + pRole.getRoleName()
                        + "\" for subelement of type <role-name> for the wrapper-servlet with the name '"
                        + portlet.getPortletName()
                        + "'.");
                    sSecRoleRefs.remove(sRR);
            }
            SecurityRoleRefDD dd = new SecurityRoleRefDD();
            dd.setDescription(pRole.getDescription());
            dd.setRoleLink(pRole.getRoleLink());
            dd.setRoleName(pRole.getRoleName());
            sSecRoleRefs.add(dd);
        }
    }

    private void createServletMapping(WebAppDD webApp,
                                      PortletDD portlet) {
        if(debug) {
            System.out.println("<VERBOSE> Creating Servlet Mapping for Portlet: '"+portlet.getPortletName()+"'");
        }
        String url= "/"+portlet.getPortletName().replace(' ', '_') + "/*";
        ServletMappingDD servletMapping = webApp.getServletMapping(url);
        if (servletMapping != null) {
            String nm = servletMapping.getServletName();
            if (!nm.equals(portlet.getPortletName())) {
                System.out.println(
                    "Note: Replaced Servlet Mapping with pattern: "+url
                );
                servletMapping.setServletName(portlet.getPortletName());
            }
        }
        else  {
            servletMapping = new ServletMappingDD();
            servletMapping.setUrlPattern(url);
            servletMapping.setServletName(portlet.getPortletName());
            webApp.getServletMappings().add(servletMapping);
        }
    }
}
