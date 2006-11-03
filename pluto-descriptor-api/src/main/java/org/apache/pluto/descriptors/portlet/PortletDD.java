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
 * 
 * FIXME: Hmmm... What do you mean, David?  --ZHENG Zhong
 * 
 * Eventually this should be flushed out :), but for the sake of timing I'll be lazy for now.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * 
 * @since Mar 6, 2005
 */
public class PortletDD {
	
	// Private Member Variables ------------------------------------------------
	
    /** The unique name of the portlet. */
    private String portletName = null;

    /** The class which implements the portlet interface. */
    private String portletClass = null;

    private String resourceBundle = null;

    private PortletInfoDD portletInfo = null;

    private PortletPreferencesDD portletPreferences = new PortletPreferencesDD();

    private List initParams = new ArrayList();

    private List supports = new ArrayList();

    /** All security role references. */
    private List securityRoleRefs = new ArrayList();
    
    /** the Sharing Parameter */    
    private List sharingParams = new ArrayList();
    
    /** the supported processing Events */
    private List<EventDD> processingEvents = new ArrayList<EventDD>();
    
    /** the supported publishing Events */
    private List<EventDD> publishingEvents = new ArrayList<EventDD>();
    
    /** the supported shared render parameter */
    private List<RenderDD> renderParameter = new ArrayList<RenderDD>();
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Default no-arg constructor.
     */
    public PortletDD() {
    	// Do nothing.
    }
    
    
    // Public Methods ----------------------------------------------------------
    
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
    
    public List getSharingParams() {
    	return sharingParams;
    }
    
    public void setSharingParams(List sharingParams){
    	this.sharingParams = sharingParams;
    }
    
    /**
	 * @return Returns the processingEvents.
	 */
	public List<EventDD> getProcessingEvents() {
		return processingEvents;
	}


	/**
	 * @param processingEvents The processingEvents to set.
	 */
	public void setProcessingEvents(List<EventDD> processingEvents) {
		this.processingEvents = processingEvents;
	}


	/**
	 * @return Returns the publishingEvents.
	 */
	public List<EventDD> getPublishingEvents() {
		return publishingEvents;
	}


	/**
	 * @param publishingEvents The publishingEvents to set.
	 */
	public void setPublishingEvents(List<EventDD> publishingEvents) {
		this.publishingEvents = publishingEvents;
	}


	/**
	 * @return Returns the render parameter.
	 */
	public List<RenderDD> getRenderParameter() {
		return renderParameter;
	}


	/**
	 * @param renderParameter The render parameter to set.
	 */
	public void setRenderParameter(List<RenderDD> renderParameter) {
		this.renderParameter = renderParameter;
	}
    
    
    // Object Methods ----------------------------------------------------------
    
    /**
     * Returns a string representation of this instance.
     * FIXME: more info!
     * @return a string representation of this instance.
     */
    public String toString() {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(getClass().getName());
    	buffer.append("[portletName=").append(portletName);
    	buffer.append(",portletClass=").append(portletClass);
    	// TODO:
    	return buffer.toString();
    }
    
    /**
     * Returns the hash code for this instance.
     * @return the hash code for this instance.
     */
    public int hashCode() {
    	return toString().hashCode();
    }
    
}

