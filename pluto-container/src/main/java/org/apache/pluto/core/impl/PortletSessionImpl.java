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
import org.apache.pluto.util.StringManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PortletSessionImpl implements PortletSession,
                                           HttpSession {

    private final int DEFAULT_SCOPE = PortletSession.PORTLET_SCOPE;

    private static final Log LOG =
        LogFactory.getLog(PortletSessionImpl.class);

    private static final StringManager EXCEPTIONS =
        StringManager.getManager(PortletSessionImpl.class.getPackage().getName());

    private HttpSession httpSession;

    private PortletContext portletContext = null;

    private InternalPortletWindow internalPortletWindow;

    public PortletSessionImpl(PortletContext context,
                              InternalPortletWindow internalPortletWindow,
                              HttpSession httpSession) {
        this.portletContext = context;
        this.internalPortletWindow = internalPortletWindow;
        this.httpSession = httpSession;
    }

    public Object getAttribute(String name) {
        return getAttribute(name, DEFAULT_SCOPE);
    }

    public Enumeration getAttributeNames() {
        return getAttributeNames(DEFAULT_SCOPE);
    }

    public long getCreationTime() throws java.lang.IllegalStateException {
        return httpSession.getCreationTime();
    }

    public String getId() throws java.lang.IllegalStateException {
        return httpSession.getId();
    }

    public long getLastAccessedTime() throws java.lang.IllegalStateException {
        return httpSession.getLastAccessedTime();
    }

    public int getMaxInactiveInterval() {
        return httpSession.getMaxInactiveInterval();
    }

    public void invalidate() throws java.lang.IllegalStateException {
        httpSession.invalidate();
    }

    public boolean isNew() throws java.lang.IllegalStateException {
        return httpSession.isNew();
    }

    public void removeAttribute(String name) {
        this.removeAttribute(name, DEFAULT_SCOPE);
    }

    public void setAttribute(String name, Object value) {
        setAttribute(name, value, DEFAULT_SCOPE);
    }

    public void setMaxInactiveInterval(int interval) {
        httpSession.setMaxInactiveInterval(interval);
    }


//
//
//
    public Object getAttribute(String name, int scope)
        throws IllegalStateException {

        if (name == null) {
            throw new IllegalArgumentException("error.attributeName.null");
        }

        if (scope == PortletSession.APPLICATION_SCOPE) {
            return httpSession.getAttribute(name);
        }

        else {
            String key = createPortletScopedId(name);
            Object attribute = httpSession.getAttribute(key);
            if(LOG.isDebugEnabled()) {
                LOG.debug("Key = "+key);
                LOG.debug("Value = "+attribute);
                Enumeration enumer = httpSession.getAttributeNames();
                while(enumer.hasMoreElements()) {
                    LOG.debug("All has: "+enumer.nextElement());
                }
            }

            if (attribute == null) {
               attribute = httpSession.getAttribute(name);
            }
            return attribute;
        }
    }

    public Enumeration getAttributeNames(int scope) {
        if (scope == PortletSession.APPLICATION_SCOPE) {
            return httpSession.getAttributeNames();
        } else {
            Enumeration attributes = httpSession.getAttributeNames();
            Vector portletAttributes = new Vector();

            while(attributes.hasMoreElements()) {
                String attribute = (String) attributes.nextElement();
                int scp =  PortletSessionUtil.decodeScope(attribute);
                if(LOG.isDebugEnabled()) {
                    LOG.debug("Found attribute: "+attribute);
                    LOG.debug("Scope Determined Portlet?" + (scp == PortletSession.PORTLET_SCOPE));
                }

                if(scp == PortletSession.PORTLET_SCOPE) {
                    portletAttributes.add(
                        PortletSessionUtil.decodeAttributeName(attribute)
                    );
                }
           }
            return portletAttributes.elements();
        }
    }

    public void removeAttribute(String name, int scope)
        throws java.lang.IllegalStateException {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (scope == PortletSession.APPLICATION_SCOPE) {
            httpSession.removeAttribute(name);
        } else {
            httpSession.removeAttribute(createPortletScopedId(name));
        }
    }

    public void setAttribute(java.lang.String name, java.lang.Object value,
                             int scope) throws IllegalStateException {
        if (name == null) {
            throw new IllegalArgumentException(
                EXCEPTIONS.getString("error.attributeName.null")
            );
        }

        if (scope == PortletSession.APPLICATION_SCOPE) {
            httpSession.setAttribute(name, value);
        }
        else {
            httpSession.setAttribute(createPortletScopedId(name),  value);
        }
    }

    private StringBuffer createPrefix() {
        StringBuffer sb = new StringBuffer("javax.portlet.p.");
        sb.append(internalPortletWindow.getId()).append("?");
        return sb;
    }

    private String createPortletScopedId(String name) {
       return createPrefix().append(name).toString();
    }

    public PortletContext getPortletContext() {
        return portletContext;
    }

    /**
     * HttpSession Implementation.
     * @return
     */
    public ServletContext getServletContext() {
        return httpSession.getServletContext();
    }

    /**
     * Implemented for backwards compatability.
     * @deprecated
     * @return
     */
    public HttpSessionContext getSessionContext() {
        return httpSession.getSessionContext();
    }

    public Object getValue(String name) {
        return this.getAttribute(name, DEFAULT_SCOPE);
    }

    /**
     * Implemented for backwards compatibility with HttpSession.
     * @deprecated
     * @return
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
