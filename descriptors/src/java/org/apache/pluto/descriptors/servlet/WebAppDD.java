/*
 * Copyright 2005 The Apache Software Foundation
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
package org.apache.pluto.descriptors.servlet;

import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

import org.apache.pluto.descriptors.common.IconDD;

/**
 * WebApplication configuration as contained
 * within the web.xml Deployment Descriptor.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id:$
 * @since Feb 28, 2005
 */
public class WebAppDD {

    private IconDD icon;
    private String displayName;
    private String description;
    private boolean distributable;
    private Set contextParams;
    private Set filters;
    private Set filterMappings;
    private Set listeners;
    private Set servlets;
    private Set servletMappings;
    private SessionConfigDD sessionConfig;
    private Set mimeMappings;
    private WelcomeFileListDD welcomeFileSet;
    private Set errorPages;
    private Set taglibs;
    private Set resourceRefs;
    private Set securityConstraints;
    private LoginConfigDD loginConfig;
    private Set securityRoles;
    private Set envEntrys;
    private Set ejbRefs;

    public WebAppDD() {

    }

    public IconDD getIcon() {
        return icon;
    }

    public void setIcon(IconDD icon) {
        this.icon= icon;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDistributable() {
        return distributable;
    }

    public void setDistributable() {
        this.distributable = true;
    }

    public void setDistributable(boolean distributable) {
        this.distributable = distributable;
    }

    /**
     * Retrieve the context parameters.
     * @return InitParamDD instances.
     */
    public Set getContextParams() {
        return contextParams;
    }

    public void setContextParams(Set contextParams) {
        this.contextParams = contextParams;
    }

    public Set getFilters() {
        return filters;
    }

    public void setFilters(Set filters) {
        this.filters = filters;
    }

    public Set getFilterMappings() {
        return filterMappings;
    }

    public void setFilterMappings(Set filterMappings) {
        this.filterMappings = filterMappings;
    }

    public Set getListeners() {
        return listeners;
    }

    public void setListeners(Set listeners) {
        this.listeners = listeners;
    }

    public Set getServlets() {
        return servlets;
    }

    public void setServlets(Set servlets) {
        this.servlets = servlets;
    }

    public Set getServletMappings() {
        return servletMappings;
    }

    public void setServletMappings(Set servletMappings) {
        this.servletMappings = servletMappings;
    }

    public SessionConfigDD getSessionConfig() {
        return sessionConfig ;
    }

    public void setSessionConfig(SessionConfigDD sessionConfig) {
        this.sessionConfig = sessionConfig;
    }

    public Set getMimeMappings() {
        return mimeMappings;
    }

    public void setMimeMappings(Set mimeMappings) {
        this.mimeMappings = mimeMappings;
    }

    public WelcomeFileListDD getWelcomeFileList() {
        return welcomeFileSet;
    }

    public void setWelcomeFileList(WelcomeFileListDD welcomeFileSet) {
        this.welcomeFileSet = welcomeFileSet;
    }

    public Set getErrorPages() {
        return errorPages;
    }

    public void setErrorPages(Set errorPages) {
        this.errorPages = errorPages;
    }

    public Set getTaglibs() {
        return taglibs;
    }

    public void setTaglibs(Set taglibs) {
        this.taglibs = taglibs;
    }

    public Set getResourceRefs() {
        return resourceRefs;
    }

    public void setResourceRefs(Set resourceRefs) {
        this.resourceRefs = resourceRefs;
    }

    public Set getSecurityConstraints() {
        return securityConstraints;
    }

    public void setSecurityConstraints(Set securityConstraints) {
        this.securityConstraints = securityConstraints;
    }

    public LoginConfigDD getLoginConfig() {
        return loginConfig;
    }

    public void setLoginConfig(LoginConfigDD loginConfig) {
        this.loginConfig = loginConfig;
    }

    public Set getSecurityRoles() {
        return securityRoles;
    }

    public void setSecurityRoles(Set securityRoles) {
        this.securityRoles = securityRoles;
    }

    public Set getEnvEntrys() {
        return envEntrys;
    }

    public void setEnvEntrys(Set envEntrys) {
        this.envEntrys = envEntrys;
    }

    public Set getEjbRefs() {
        return ejbRefs;
    }

    public void setEjbRefs(Set ejbRefs) {
        this.ejbRefs = ejbRefs;
    }

// Helpers

    public ServletDD getServlet(String name) {
        HashSet set = new HashSet(servlets);
        Iterator it = set.iterator();
        ServletDD dd;
        while(name!=null && it.hasNext()) {
            dd = (ServletDD)it.next();
            if(name.equals(dd.getServletName())) {
                return dd;
            }
        }
        return null;
    }

    public ServletMappingDD getServletMapping(String uri) {
        HashSet set = new HashSet(servletMappings);
        Iterator it = set.iterator();
        ServletMappingDD dd;
        while(uri!=null && it.hasNext()) {
            dd = (ServletMappingDD)it.next();
            if(uri.equals(dd.getUrlPattern())) {
                return dd;
            }
        }
        return null;
    }


}

