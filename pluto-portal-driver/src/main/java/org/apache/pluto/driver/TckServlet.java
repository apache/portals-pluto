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
package org.apache.pluto.driver;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.config.AdminConfiguration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.io.IOException;

/**
 * TCK Driver Servlet
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Dec 11, 2005
 */
public class TckServlet extends PortalDriverServlet {

    private int pageCounter = 0;

    private String portalDriver = "/portal/";

    public String getServletInfo() {
        return "Pluto TCK Driver Servlet";
    }

    public void init() {
        ServletContext servletContext = getServletContext();
        container = (PortletContainer) servletContext.getAttribute(
                AttributeKeys.PORTLET_CONTAINER);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {

        // If portletNames are defined, the driver is attempting to
        //   create a new page.  This page must be setup and then
        //   redirected to the actual page.
        String[] portletNames = request.getParameterValues("portletName");
        if(portletNames != null && portletNames.length < 0) {
            doSetup(request, response);
            return;
        }

        super.doGet(request, response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse response)
    throws IOException, ServletException {
        super.doGet(req, response);
    }

    public void doSetup(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        String[] portletNames = request.getParameterValues("portletName");
        String pageName = request.getParameter("pageName");
        if(pageName == null) {
            pageName = new java.text.DecimalFormat("TCK00000").format(pageCounter);
            PageConfig config = new PageConfig();
            config.setName(pageName);
            config.setUri("/WEB-INF/fragments/portlet.jsp");
            for(int i = 0;i < portletNames.length; i++) {
                int idx = portletNames[i].indexOf("/");
                String context = portletNames[i].substring(0, idx);
                String portletName = portletNames[i].substring(idx, portletNames.length);
                config.addPortlet(context, portletName);
            }

            AdminConfiguration adminConfig = (AdminConfiguration)getServletContext()
                .getAttribute(AttributeKeys.DRIVER_ADMIN_CONFIG);

            if(adminConfig == null) {
                throw new ServletException("Invalid Configuration.  An AdminConfiguration must be specified to run the TCK.");
            }
            adminConfig.getRenderConfigAdminService().addPage(config);
        }

        // The other possibility would be to redirect to the actual portal.
        // I'm not sure which is better at this point.
        response.sendRedirect(request.getContextPath()+request.getRequestURL()+"/"+pageName);
    }
}
