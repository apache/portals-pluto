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

package org.apache.pluto.core.impl;

import java.util.Enumeration;
import java.util.Vector;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import javax.portlet.PortletSessionUtil;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of the <code>javax.portlet.PortletSession</code> interface.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortletSessionImpl implements PortletSession, HttpSession {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletSessionImpl.class);

    private final int DEFAULT_SCOPE = PortletSession.PORTLET_SCOPE;

    
    // Private Member Variables ------------------------------------------------
    
    private HttpSession httpSession = null;

    private PortletContext portletContext = null;

    private InternalPortletWindow internalPortletWindow = null;
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     */
    public PortletSessionImpl(PortletContext portletContext,
                              InternalPortletWindow internalPortletWindow,
                              HttpSession httpSession) {
        this.portletContext = portletContext;
        this.internalPortletWindow = internalPortletWindow;
        this.httpSession = httpSession;
    }
    
    
    // PortletSession Impl: Attributes -----------------------------------------
    
    public Object getAttribute(String name) {
        return getAttribute(name, DEFAULT_SCOPE);
    }
    
    public Object getAttribute(String name, int scope) {
    	ArgumentUtility.validateNotNull("attributeName", name);
    	if (scope == PortletSession.APPLICATION_SCOPE) {
    		return httpSession.getAttribute(name);
    	} else {
            String key = createPortletScopedId(name);
            Object attribute = httpSession.getAttribute(key);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Key = " + key);
                LOG.debug("Value = " + attribute);
                Enumeration enumer = httpSession.getAttributeNames();
                while (enumer.hasMoreElements()) {
                    LOG.debug("All has: " + enumer.nextElement());
                }
            }
            if (attribute == null) {
               attribute = httpSession.getAttribute(name);
            }
            return attribute;
        }
    }
    
    public Enumeration getAttributeNames() {
        return getAttributeNames(DEFAULT_SCOPE);
    }
    
    public Enumeration getAttributeNames(int scope) {
        if (scope == PortletSession.APPLICATION_SCOPE) {
            return httpSession.getAttributeNames();
        } else {
            Enumeration attributes = httpSession.getAttributeNames();
            Vector portletAttributes = new Vector();

            while (attributes.hasMoreElements()) {
            	String attribute = (String) attributes.nextElement();
                int scp =  PortletSessionUtil.decodeScope(attribute);
                if (LOG.isDebugEnabled()) {
                	LOG.debug("Found attribute: "+attribute);
                    LOG.debug("Scope Determined Portlet?" + (scp == PortletSession.PORTLET_SCOPE));
                }
                
                if(scp == PortletSession.PORTLET_SCOPE) {
                	portletAttributes.add(
                			PortletSessionUtil.decodeAttributeName(attribute));
                }
           }
            return portletAttributes.elements();
        }
    }
    
    public void removeAttribute(String name) {
        removeAttribute(name, DEFAULT_SCOPE);
    }

    public void removeAttribute(String name, int scope) {
    	ArgumentUtility.validateNotNull("attributeName", name);
    	if (scope == PortletSession.APPLICATION_SCOPE) {
    		httpSession.removeAttribute(name);
    	} else {
    		httpSession.removeAttribute(createPortletScopedId(name));
    	}
    }
    
    public void setAttribute(String name, Object value) {
        setAttribute(name, value, DEFAULT_SCOPE);
    }

    public void setAttribute(String name, Object value, int scope) {
    	ArgumentUtility.validateNotNull("attributeName", name);
    	if (scope == PortletSession.APPLICATION_SCOPE) {
    		httpSession.setAttribute(name, value);
    	} else {
    		httpSession.setAttribute(createPortletScopedId(name),  value);
    	}
    }

    
    // PortletSession Impl -----------------------------------------------------
    
    public PortletContext getPortletContext() {
        return portletContext;
    }

    public long getCreationTime() {
        return httpSession.getCreationTime();
    }

    public String getId() {
        return httpSession.getId();
    }

    public long getLastAccessedTime() {
        return httpSession.getLastAccessedTime();
    }

    public int getMaxInactiveInterval() {
        return httpSession.getMaxInactiveInterval();
    }

    public void invalidate() throws IllegalStateException {
        httpSession.invalidate();
    }

    public boolean isNew() throws IllegalStateException {
        return httpSession.isNew();
    }

    public void setMaxInactiveInterval(int interval) {
        httpSession.setMaxInactiveInterval(interval);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Session timeout set to: " + interval);
        }
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Creates portlet-scoped ID for the specified attribute name.
     * @param name  the attribute name.
     * @return portlet-scoped ID for the attribute name.
     */
    private String createPortletScopedId(String name) {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("javax.portlet.p.");
    	buffer.append(internalPortletWindow.getId()).append("?");
    	buffer.append(name);
    	return buffer.toString();
    }
    
    
    // HttpSession Impl --------------------------------------------------------
    
    public ServletContext getServletContext() {
        return httpSession.getServletContext();
    }

    /**
     * DEPRECATED: implemented for backwards compatability with HttpSession.
     * @deprecated
     */
    public HttpSessionContext getSessionContext() {
        return httpSession.getSessionContext();
    }

    public Object getValue(String name) {
        return this.getAttribute(name, DEFAULT_SCOPE);
    }

    /**
     * DEPRECATED: Implemented for backwards compatibility with HttpSession.
     * @deprecated
     */
    public String[] getValueNames() {
        return httpSession.getValueNames();
    }

    public void putValue(String name, Object value) {
        this.setAttribute(name, value, DEFAULT_SCOPE);
    }

    public void removeValue(String name) {
        this.removeAttribute(name, DEFAULT_SCOPE);
    }
    
}
