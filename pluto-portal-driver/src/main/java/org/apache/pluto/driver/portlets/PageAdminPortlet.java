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

import org.apache.commons.io.FileUtils;
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

import java.io.File;
import java.io.FileReader;
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

    private static final String CONFIG_FILE_PATH = "/WEB-INF/pluto-portal-driver-config.xml";
    /** Token used to search for default page value in config file */
    private static final String RENDER_CONFIG_SEARCH_TOKEN = "<render-config default=\"";

    public void processAction(ActionRequest request, ActionResponse response) {
        String command = request.getParameter("command");
        if("Add Portlet".equalsIgnoreCase(command)) {
            doAddPortlet(request);
        }
        else if ("Remove Portlet".equalsIgnoreCase(command)) {
            doRemovePortlet(request);
        }
        try {
			persistPages();
		} catch (IOException e) {
			String msg = "Problem persisting configuration changes";
			LOG.error(msg, e);
			IllegalStateException ese = new IllegalStateException(msg);
			ese.initCause(e);
			throw ese;
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

    private void persistPages() throws IOException {
    	//TODO: Null checks. Substitute empty string or throw an Exception
    	final String NL = System.getProperty("line.separator");
        DriverConfiguration driverConfig = (DriverConfiguration) getPortletContext()
        	.getAttribute(AttributeKeys.DRIVER_CONFIG);
    	String path = getPortletContext().getRealPath(CONFIG_FILE_PATH);
    	File configFile = new File(path);
    	String configFileContents = FileUtils.readFileToString(configFile);
    	StringBuffer renderConfig = new StringBuffer();
    	//start with render-config element
    	renderConfig.append(" ");//indent
    	renderConfig.append(RENDER_CONFIG_SEARCH_TOKEN);
    	String defaultPage = parseDefaultPage(configFileContents);
    	renderConfig.append(defaultPage);
    	renderConfig.append("\">");
    	renderConfig.append(NL);
    	Collection pages = getAvailablePages();
    	//iterate through pages
    	for (Iterator iter = pages.iterator(); iter.hasNext();) {
			Page page = (Page) iter.next();
	        PageConfig config = driverConfig.getPageConfig(page.getName());
	        renderConfig.append("    <page name=\"");
	        String pageName = config.getName();
	        renderConfig.append(pageName);
	        renderConfig.append("\" uri=\"");
	        String uri = config.getUri();
	        renderConfig.append(uri);
	    	renderConfig.append("\">");
	    	renderConfig.append(NL);
	        
	        //iterate through portlets in current page
	        Collection portletIds = config.getPortletIds();
	        for (Iterator iterator = portletIds.iterator(); iterator.hasNext();) {
		        renderConfig.append("      <portlet context=\"");
				String pid = (String) iterator.next();
				String pletContext = PortletWindowConfig.parseContextPath(pid);
				renderConfig.append(pletContext);
				renderConfig.append("\" name=\"");
				String pletName = PortletWindowConfig.parsePortletName(pid);
				renderConfig.append(pletName);
				renderConfig.append("\"/>");
		    	renderConfig.append(NL);
			}
	        renderConfig.append("    </page>");
	    	renderConfig.append(NL);
		}
    	renderConfig.append("  </render-config>");
    	renderConfig.append(NL);
    	renderConfig.append(NL);
    	renderConfig.append("</pluto-portal-driver>");
    	renderConfig.append(NL);
    	//create new config file content
    	StringBuffer newFileContents = new StringBuffer();
    	newFileContents.append(getContentBeforeRenderConfig(configFileContents));
    	newFileContents.append(renderConfig);
    	//persist to new config file content to file
    	FileUtils.writeStringToFile(configFile, newFileContents.toString());
    }
    
    
    protected static String getContentBeforeRenderConfig(String contents) {
    	return contents.substring(0, contents.indexOf(RENDER_CONFIG_SEARCH_TOKEN));
    }
    
    /**
     * Parse out default attribute value of render-config element in pluto-portal-driver-config.xml. 
     * This method is protected to allow unit testing (see <code>PageAdminPortletTest.testParseDefaultPage()</code>.)
     * 
     * @param configFileContents Contents of pluto-portal-driver-config.xml file.
     * @return The value of the default attribute in the render-config element.
     */
    protected static String parseDefaultPage(String configFileContents) {
    	String defPage = null;
    	//length of token used to find default page
    	final int DEF_TOK_LEN = RENDER_CONFIG_SEARCH_TOKEN.length();
    	//index of start of default attribute value
    	int startInd = configFileContents.indexOf(RENDER_CONFIG_SEARCH_TOKEN) + DEF_TOK_LEN;
    	//rest of file after DEFAULT_TOK
    	String restOfConfigFile = configFileContents.substring(startInd);
    	//index of first quote in substring, which indicates end of default attribute value
    	int endInd = restOfConfigFile.indexOf('"');
    	defPage = configFileContents.substring(startInd, startInd + endInd);
    	return defPage;
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
