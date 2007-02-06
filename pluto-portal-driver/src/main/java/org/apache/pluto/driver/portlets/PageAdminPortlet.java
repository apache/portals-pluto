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
package org.apache.pluto.driver.portlets;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class PageAdminPortlet extends GenericPlutoPortlet {

    private static final Log LOG = LogFactory.getLog(PageAdminPortlet.class);
    private static final String JSP_DIR = "/WEB-INF/fragments/admin/page/";
    private static final String VIEW_PAGE = JSP_DIR + "view.jsp";
    private static final String EDIT_PAGE = JSP_DIR + "edit.jsp";
    private static final String HELP_PAGE = JSP_DIR + "help.jsp";


    public void processAction(ActionRequest request, ActionResponse response) {
        String command = request.getParameter("command");
        if("add".equalsIgnoreCase(command)) {
            doAddPortlet(request);
        }
        else if ("remove".equalsIgnoreCase(command)) {
            doRemovePortlet(request);
        }
    }

    public void doAddPortlet(ActionRequest request) {
        String page = request.getParameter("page");
        String applicationId = request.getParameter("applications");
        String portletId = request.getParameter("availablePortlets");

        LOG.info("Request: Add [applicationId=" + applicationId + ":portletId=" + portletId + "] to page '" + page + "'");

        PageConfig config = getPageConfig(page);
        config.addPortlet(applicationId, portletId);

    }


    public void doRemovePortlet(ActionRequest request) {
        String page = request.getParameter("page");
        String portletId = request.getParameter("placedPortlets");

        LOG.info("Request: Remove [portletId=" + portletId + "] from page '" + page + "'");

        PageConfig config = getPageConfig(page);
        config.removePortlet(portletId);
    }

    private PageConfig getPageConfig(String page) {
        DriverConfiguration driverConfig = (DriverConfiguration) getPortletContext()
            .getAttribute(AttributeKeys.DRIVER_CONFIG);

        PageConfig config = driverConfig.getPageConfig(page);
        return config;
    }

    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        request.setAttribute("availablePages", getAvailablePages());
        super.doView(request, response);
    }

    public String getViewPage() {
        return VIEW_PAGE;
    }

    public String getEditPage() {
        return EDIT_PAGE;
    }

    public String getHelpPage(RenderRequest request) {
    	String incPage = HELP_PAGE;
    	String page = request.getParameter("helpPage");
    	if (page != null) {
    		incPage = JSP_DIR + page;
    	}
        return incPage;
    }

    public Collection getAvailablePages() {
        DriverConfiguration configuration =
            (DriverConfiguration) getPortletContext().getAttribute(AttributeKeys.DRIVER_CONFIG);

        ArrayList list = new ArrayList();
        Iterator it = configuration.getPages().iterator();
        while (it.hasNext()) {
            PageConfig config = (PageConfig) it.next();
            ArrayList portlets = new ArrayList();
            Iterator pids = config.getPortletIds().iterator();
            while (pids.hasNext()) {
                String pid = pids.next().toString();
                String name = PortletWindowConfig.parsePortletName(pid);
                portlets.add(new Placement(pid, name));
            }
            list.add(new Page(config.getName(), config.getName(), portlets));
        }

        return list;
    }

    public class Page {
        private String id;
        private String name;
        private Collection portlets;


        public Page(String pageId, String pageName, Collection portlets) {
            this.id = pageId;
            this.name = pageName;
            this.portlets = portlets;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Collection getPortlets() {
            return portlets;
        }

        public void setPortlets(Collection portlets) {
            this.portlets = portlets;
        }
    }

    public class Placement {
        private String id;
        private String portletName;

        public Placement(String id, String portletName) {
            this.id = id;
            this.portletName = portletName;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPortletName() {
            return portletName;
        }

        public void setPortletName(String portletName) {
            this.portletName = portletName;
        }
    }

}
