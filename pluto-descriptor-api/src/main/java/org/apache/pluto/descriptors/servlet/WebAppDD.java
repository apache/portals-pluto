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
package org.apache.pluto.descriptors.servlet;

import org.apache.pluto.om.common.Icon;
import org.apache.pluto.om.servlet.Distributable;
import org.apache.pluto.om.servlet.LoginConfig;
import org.apache.pluto.om.servlet.Servlet;
import org.apache.pluto.om.servlet.ServletMapping;
import org.apache.pluto.om.servlet.SessionConfig;
import org.apache.pluto.om.servlet.WebApp;
import org.apache.pluto.om.servlet.WelcomeFileList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * WebApplication configuration as contained
 * within the web.xml Deployment Descriptor.
 *
 * @version $Id: WebAppDD.java 157475 2005-03-14 22:13:18Z ddewolf $
 * @since Feb 28, 2005
 */
public class WebAppDD implements WebApp {

    private Icon icon;
    private String displayName;
    private String description;
    private List contextParams = new ArrayList();
    private List filters = new ArrayList();
    private List filterMappings = new ArrayList();
    private List listeners = new ArrayList();
    private List servlets = new ArrayList();
    private List servletMappings = new ArrayList();
    private SessionConfig sessionConfig;
    private List mimeMappings = new ArrayList();
    private WelcomeFileList welcomeFileList;
    private List errorPages = new ArrayList();
    private List taglibs = new ArrayList();
    private List resourceRefs = new ArrayList();
    private List securityConstraints = new ArrayList();
    private LoginConfig loginConfig;
    private List securityRoles = new ArrayList();
    private List envEntrys = new ArrayList();
    private List ejbRefs = new ArrayList();
    // Default to servletVersion 2.3.  If a <web-app>
    // element is present with a version attribute,
    // the Castor mapping will update this field.
    private String servletVersion = "2.3";
    // Default to false.  If a <web-app>
    // contains a <distributable/> element, then
    // Castor will update this field to true.
    private Distributable distributableDD = new DistributableDD();

    public WebAppDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getIcon()
	 */
    public Icon getIcon() {
        return icon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setIcon(org.apache.pluto.om.common.Icon)
	 */
    public void setIcon(Icon icon) {
        this.icon= icon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getDisplayName()
	 */
    public String getDisplayName() {
        return displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setDisplayName(java.lang.String)
	 */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#isDistributable()
	 */
    public boolean isDistributable() {
        return distributableDD.isDistributable().booleanValue();
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getDistributable()
	 */
    public Distributable getDistributable() {
        return distributableDD;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setDistributable()
	 */
    public void setDistributable() {
        this.distributableDD.setDistributable(true);
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setDistributable(boolean)
	 */
    public void setDistributable(boolean distributable) {
        this.distributableDD.setDistributable(distributable);
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getContextParams()
	 */
    public List getContextParams() {
        return contextParams;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setContextParams(java.util.List)
	 */
    public void setContextParams(List contextParams) {
        this.contextParams = contextParams;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getFilters()
	 */
    public List getFilters() {
        return filters;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setFilters(java.util.List)
	 */
    public void setFilters(List filters) {
        this.filters = filters;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getFilterMappings()
	 */
    public List getFilterMappings() {
        return filterMappings;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setFilterMappings(java.util.List)
	 */
    public void setFilterMappings(List filterMappings) {
        this.filterMappings = filterMappings;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getListeners()
	 */
    public List getListeners() {
        return listeners;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setListeners(java.util.List)
	 */
    public void setListeners(List listeners) {
        this.listeners = listeners;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getServlets()
	 */
    public List getServlets() {
        return servlets;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setServlets(java.util.List)
	 */
    public void setServlets(List servlets) {
        this.servlets = servlets;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getServletMappings()
	 */
    public List getServletMappings() {
        return servletMappings;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setServletMappings(java.util.List)
	 */
    public void setServletMappings(List servletMappings) {
        this.servletMappings = servletMappings;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getSessionConfig()
	 */
    public SessionConfig getSessionConfig() {
        return sessionConfig ;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setSessionConfig(org.apache.pluto.descriptors.servlet.SessionConfig)
	 */
    public void setSessionConfig(SessionConfig sessionConfig) {
        this.sessionConfig = sessionConfig;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getMimeMappings()
	 */
    public List getMimeMappings() {
        return mimeMappings;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setMimeMappings(java.util.List)
	 */
    public void setMimeMappings(List mimeMappings) {
        this.mimeMappings = mimeMappings;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getWelcomeFileList()
	 */
    public WelcomeFileList getWelcomeFileList() {
        return welcomeFileList;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setWelcomeFileList(org.apache.pluto.descriptors.servlet.WelcomeFileListDD)
	 */
    public void setWelcomeFileList(WelcomeFileList welcomeFileList) {
        this.welcomeFileList = welcomeFileList;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getErrorPages()
	 */
    public List getErrorPages() {
        return errorPages;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setErrorPages(java.util.List)
	 */
    public void setErrorPages(List errorPages) {
        this.errorPages = errorPages;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getTaglibs()
	 */
    public List getTaglibs() {
        return taglibs;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setTaglibs(java.util.List)
	 */
    public void setTaglibs(List taglibs) {
        this.taglibs = taglibs;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getResourceRefs()
	 */
    public List getResourceRefs() {
        return resourceRefs;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setResourceRefs(java.util.List)
	 */
    public void setResourceRefs(List resourceRefs) {
        this.resourceRefs = resourceRefs;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getSecurityConstraints()
	 */
    public List getSecurityConstraints() {
        return securityConstraints;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setSecurityConstraints(java.util.List)
	 */
    public void setSecurityConstraints(List securityConstraints) {
        this.securityConstraints = securityConstraints;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getLoginConfig()
	 */
    public LoginConfig getLoginConfig() {
        return loginConfig;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setLoginConfig(org.apache.pluto.descriptors.servlet.LoginConfig)
	 */
    public void setLoginConfig(LoginConfig loginConfig) {
        this.loginConfig = loginConfig;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getSecurityRoles()
	 */
    public List getSecurityRoles() {
        return securityRoles;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setSecurityRoles(java.util.List)
	 */
    public void setSecurityRoles(List securityRoles) {
        this.securityRoles = securityRoles;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getEnvEntrys()
	 */
    public List getEnvEntrys() {
        return envEntrys;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setEnvEntrys(java.util.List)
	 */
    public void setEnvEntrys(List envEntrys) {
        this.envEntrys = envEntrys;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getEjbRefs()
	 */
    public List getEjbRefs() {
        return ejbRefs;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setEjbRefs(java.util.List)
	 */
    public void setEjbRefs(List ejbRefs) {
        this.ejbRefs = ejbRefs;
    }


    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getServletVersion()
	 */
    public String getServletVersion() {
        return servletVersion;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#setServletVersion(java.lang.String)
	 */
    public void setServletVersion(String servletVersion) {
        this.servletVersion = servletVersion;
    }

// Helpers

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getServlet(java.lang.String)
	 */
    public Servlet getServlet(String name) {
        ArrayList set = new ArrayList(servlets);
        Iterator it = set.iterator();
        Servlet dd;
        while(name!=null && it.hasNext()) {
            dd = (Servlet)it.next();
            if(name.equals(dd.getServletName())) {
                return dd;
            }
        }
        return null;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WebApp#getServletMapping(java.lang.String)
	 */
    public ServletMapping getServletMapping(String uri) {
        ArrayList set = new ArrayList(servletMappings);
        Iterator it = set.iterator();
        ServletMapping dd;
        while(uri!=null && it.hasNext()) {
            dd = (ServletMapping)it.next();
            if(uri.equals(dd.getUrlPattern())) {
                return dd;
            }
        }
        return null;
    }


}

