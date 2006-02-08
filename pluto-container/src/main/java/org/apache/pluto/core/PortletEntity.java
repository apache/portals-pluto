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
/* 

 */

package org.apache.pluto.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.impl.PortletPreferenceImpl;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.PortletPreferenceDD;
import org.apache.pluto.descriptors.portlet.PortletPreferencesDD;
import org.apache.pluto.descriptors.servlet.ServletDD;

import javax.servlet.ServletContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The PortletEntity encapsulates all data pertaining to a single portlet
 * instance.  This instance may appear zero or more times per user. The
 * PortletEntity consists of two primary peices of information, the Portlet
 * Definition as defined by the {@link PortletDD} and the Wrapping Servlet
 * information as defined by the{@link ServletDD}
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortletEntity {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletEntity.class);

    private static final String PREFIX = "/PlutoInvoker/";
    
    
    // Private Member Variables ------------------------------------------------
    
    private ServletContext servletContext = null;
    private PortletWindow portletWindow = null;

    //  Looked up and Cached
    private PortletDD portletDefinition = null;
    
    /** Default portlet preferences defined for this portlet. */
    private PortletPreference[] defaultPreferences = null;
    
    
    // Constructor -------------------------------------------------------------
    
    PortletEntity(ServletContext servletContext, PortletWindow portletWindow) {
        this.servletContext = servletContext;
        this.portletWindow = portletWindow;
    }
    
    
    // Public Methods ----------------------------------------------------------
    
    /**
     * Returns the URI to the controller servlet that wraps this portlet.
     * @return the URI to the controller servlet that wraps this portlet.
     */
    public String getControllerServletUri() {
        return PREFIX + portletWindow.getPortletName();
    }
    
    /**
     * Returns all preferences of this portlet The return value cannot be NULL.
     * @return the preference set
     */
    public PortletPreference[] getDefaultPreferences() {
        if (defaultPreferences == null) {
            PortletDD portletDD = getPortletDefinition();
            PortletPreferencesDD prefsDD = portletDD.getPortletPreferences();
            if (prefsDD != null) {
            	List prefs = new ArrayList();
            	for (Iterator it = prefsDD.getPortletPreferences().iterator();
            			it.hasNext(); ) {
            		PortletPreferenceDD prefDD = (PortletPreferenceDD) it.next();
            		String[] values = (String[]) prefDD.getValues().toArray(
            				new String[prefDD.getValues().size()]);
            		PortletPreferenceImpl pref = new PortletPreferenceImpl(
            				prefDD.getName(), values, prefDD.isReadOnly());
            		prefs.add(pref);
            	}
            	defaultPreferences = (PortletPreference[]) prefs.toArray(
            			new PortletPreference[prefs.size()]);
            }
        }
        return defaultPreferences;
    }

    /**
     * Returns the portlet description. The return value cannot be NULL.
     * @return the portlet description.
     */
    public PortletDD getPortletDefinition() {
        if (portletDefinition == null) {
            load();
        }
        return portletDefinition;
    }

    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Loads the portlet definition.
     */
    private void load() {
    	
    	// Retrieve the cross servlet context for the portlet.
        String contextPath = portletWindow.getContextPath();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Loading portlet definition for context: " + contextPath);
        }
        ServletContext crossContext = servletContext.getContext(contextPath);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Retrieved cross context: " + crossContext);
        }
        
        // Load PortletAppDD and find out the portlet definition.
        try {
            PortletAppDD appDD = PortletDescriptorRegistry.getRegistry()
            		.getPortletAppDD(crossContext);
            for (Iterator it = appDD.getPortlets().iterator(); it.hasNext(); ) {
                PortletDD portletDD = (PortletDD) it.next();
                if (portletDD.getPortletName().equals(
                		portletWindow.getPortletName())) {
                	portletDefinition = portletDD;
                	break;
                }
            }
        } catch (PortletContainerException ex) {
        	String message = "Unable to load Portlet App Deployment Descriptor:"
        			+ ex.getMessage();
        	LOG.error(message, ex);
        	// FIXME: should this be a NullPointerException?
            throw new NullPointerException(message);
        }
    }

}
