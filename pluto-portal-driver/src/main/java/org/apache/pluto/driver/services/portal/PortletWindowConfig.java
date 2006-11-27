/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.services.portal;

/**
 * Configuration of a portlet window on the portal page.
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortletWindowConfig {
	
	// Private Member Variables ------------------------------------------------
	
    /** The context path of the associated portlet. */
    private String contextPath = null;
    
    /** The portlet name. */
    private String portletName = null;
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * No-arg constructor.
     */
    public PortletWindowConfig() {
    	// Do nothing.
    }
    
    
    // Public Methods ----------------------------------------------------------
    
    public String getId() {
    	return createPortletId(contextPath, portletName);
    }

    public String getContextPath() {
        return contextPath;
    }

   public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getPortletName() {
        return portletName;
    }

    public void setPortletName(String portletName) {
        this.portletName = portletName;
    }
    
    
    // Public Static Methods ---------------------------------------------------
    
    /**
     * Creates the portlet ID from context path and portlet name. The portlet ID
     * is constructed by concatinating the context path and the portlet name
     * using a dot ('.').
     * 
     * The method checks that the portlet name parameter does not have a dot. This check
     * is not done for the portlet ID.
     * 
     * @param contextPath  the portlet context path.
     * @param portletName  the portlet name.
     * @throws IllegalArgumentException if the portletName has a dot
     * @throws NullPointerException if the portlet Name or context path is null.
     */
    public static String createPortletId(String contextPath, String portletName) 
    	throws NullPointerException, IllegalArgumentException {
        	
        	if (contextPath == null) {
        		throw new NullPointerException("Context path must not be null.");    		
        	}
        	if (portletName == null) {
        		throw new NullPointerException("Portlet name must not be null.");    		    		
        	}
        	if (portletName.indexOf('.') != -1) {
        		throw new IllegalArgumentException("Portlet name must not have a dot(period). Please remove the dot from the value of the portlet-name element ("+ portletName + ") in portlet.xml");
        	}
        return contextPath + "." + portletName;
    }
    
    /**
     * Parses out the portlet context path from the portlet ID.
     * @param portletId  the portlet ID to parse.
     * @return the portlet context path.
     */
    public static String parseContextPath(String portletId) {
    	int index = getSeparatorIndex(portletId);
        return portletId.substring(0, index);
    }
    
    /**
     * Parses out the portlet context path from the portlet ID.
     * @param portletId  the portlet ID to parse.
     * @return the portlet context path.
     * @throws IllegalArgumentException  if portlet ID is invalid.
     */
    public static String parsePortletName(String portletId) {
    	int index = getSeparatorIndex(portletId);
        return portletId.substring(index + 1);
    }
    
    
    // Private Static Method ---------------------------------------------------
    
    /**
     * Parses the portlet ID and returns the separator (".") index. The portlet
     * ID passed in should be a valid ID: not null, not starts with ".",
     * not ends with ".", and contains ".".
     * @param portletId  the portlet ID to parse.
     * @return the separator index.
     * @throws IllegalArgumentException  if portlet ID is null or invalid.
     */
    private static int getSeparatorIndex(String portletId)
    throws IllegalArgumentException {
    	if (portletId == null) {
    		throw new IllegalArgumentException("Invalid portlet ID: null");
    	}
    	int index = portletId.indexOf(".");
    	if (index <= 0 || index == portletId.length() - 1) {
    		throw new IllegalArgumentException("Invalid portlet ID: " + portletId);
    	}
    	return index;
    }
    
}

