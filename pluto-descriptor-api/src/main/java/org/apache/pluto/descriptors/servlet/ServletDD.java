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

import java.util.ArrayList;
import java.util.List;

import org.apache.pluto.om.common.Icon;
import org.apache.pluto.om.servlet.LoadOnStartup;
import org.apache.pluto.om.servlet.Servlet;

/**
 * Filter DD() uration as contained within the
 * web.xml Deployment Descriptor.
 *
 * @version $Id: ServletDD.java 156743 2005-03-10 05:50:30Z ddewolf $
 * @since Feb 28, 2005
 */
public class ServletDD implements Servlet {

    private String servletName;
    private String servletClass;
    private String displayName;
    private String description;
    private String jspFile;
    private LoadOnStartup loadOnStartup;

    private Icon icon;
    private List initParams = new ArrayList();
    private List securityRoleRefs = new ArrayList();

    public ServletDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getServletName()
	 */
    public String getServletName() {
        return servletName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setServletName(java.lang.String)
	 */
    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getServletClass()
	 */
    public String getServletClass() {
        return servletClass;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setServletClass(java.lang.String)
	 */
    public void setServletClass(String servletClass) {
        this.servletClass = servletClass;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getDisplayName()
	 */
    public String getDisplayName() {
        return displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setDisplayName(java.lang.String)
	 */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getJspFile()
	 */
    public String getJspFile() {
        return jspFile;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setJspFile(java.lang.String)
	 */
    public void setJspFile(String jspFile) {
        this.jspFile = jspFile;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getLoadOnStartup()
	 */
    public LoadOnStartup getLoadOnStartup() {
        return loadOnStartup;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setLoadOnStartup(org.apache.pluto.descriptors.servlet.LoadOnStartup)
	 */
    public void setLoadOnStartup(LoadOnStartup loadOnStartup) {
        this.loadOnStartup = loadOnStartup;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getIcon()
	 */
    public Icon getIcon() {
        return icon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setIcon(org.apache.pluto.om.common.Icon)
	 */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getInitParams()
	 */
    public List getInitParams() {
        return initParams;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setInitParams(java.util.List)
	 */
    public void setInitParams(List initParams) {
        this.initParams = initParams;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#getSecurityRoleRefs()
	 */
    public List getSecurityRoleRefs() {
        return securityRoleRefs;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.Servlet#setSecurityRoleRefs(java.util.List)
	 */
    public void setSecurityRoleRefs(List securityRoleRefs) {
        this.securityRoleRefs = securityRoleRefs;
    }

}

