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
package org.apache.pluto.descriptors.portlet;

import java.util.List;
import java.util.ArrayList;

/**
 * Bare bones implementation of the Portlet descriptor.
 * Eventually this should be flushed out :), but for the sake
 * of timing I'll be lazy for now.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id: PortletDD.java 157475 2005-03-14 22:13:18Z ddewolf $
 * @since Mar 6, 2005
 */
public class PortletDD {

    /** The unique name of the portlet. */
    private String portletName;

    /** The class which implements the portlet interface. */
    private String portletClass;

    private String resourceBundle;

    private PortletInfoDD portletInfo;

    private PortletPreferencesDD portletPreferences = new PortletPreferencesDD();

    private List initParams = new ArrayList();

    private List supports = new ArrayList();

    /** All security role references. */
    private List securityRoleRefs = new ArrayList();


    /**
     * Default Constructor.
     */
    public PortletDD() {

    }

    /**
     * Retrieve the unique name of the portlet.
     * @return
     */
    public String getPortletName() {
        return portletName;
    }

    /**
     * Set the unique name of the portlet.
     * @param portletName
     */
    public void setPortletName(String portletName) {
        this.portletName = portletName;
    }

    /**
     * Retrieve the name of the portlet class.
     * @return the fully qualified portlet class name.
     */
    public String getPortletClass() {
        return portletClass;
    }

    /**
     * Set the name of the portlet class.
     * @param portletClass
     */
    public void setPortletClass(String portletClass) {
        this.portletClass = portletClass;
    }

    public String getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(String resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public PortletInfoDD getPortletInfo() {
        return portletInfo;
    }

    public void setPortletInfo(PortletInfoDD portletInfo) {
        this.portletInfo = portletInfo;
    }

    public List getSupports() {
        return supports;
    }

    public void setSupports(List supports) {
        this.supports = supports;
    }

    public List getInitParams() {
        return initParams;
    }

    public void setInitParams(List initParams) {
        this.initParams = initParams;
    }

    public PortletPreferencesDD getPortletPreferences() {
        return portletPreferences;
    }

    public void setPortletPreferences(PortletPreferencesDD portletPreferences) {
        this.portletPreferences = portletPreferences;
    }

    /**
     * Retrieve the security role references for this portlet.
     * @return
     */
    public List getSecurityRoleRefs() {
        return securityRoleRefs;
    }

    /**
     * Set the security role references for this portlet.
     * @param securityRoleRefs
     */
    public void setSecurityRoleRefs(List securityRoleRefs) {
        this.securityRoleRefs = securityRoleRefs;
    }
}

