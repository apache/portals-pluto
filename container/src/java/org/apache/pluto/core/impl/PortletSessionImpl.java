/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.core.impl;

import java.util.Enumeration;
import java.util.Vector;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import javax.portlet.PortletSessionUtil;

import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.om.window.PortletWindow;

public class PortletSessionImpl implements PortletSession, javax.servlet.http.HttpSession
{
    private final int DEFAULT_SCOPE = PortletSession.PORTLET_SCOPE;

    private javax.servlet.http.HttpSession httpSession;
    private PortletContext portletContext = null;

    private PortletWindow portletWindow;

    public PortletSessionImpl(PortletWindow portletWindow,
                              javax.servlet.http.HttpSession httpSession)
    {
        this.portletWindow = portletWindow;
        this.httpSession = httpSession;
    }

    // javax.portlet.PortletSession and javax.servlet.http.HttpSession implementation -------------
    public Object getAttribute(String name)
    {
        return this.getAttribute(name, DEFAULT_SCOPE);
    }

    public Enumeration getAttributeNames()
    {
        return this.getAttributeNames(DEFAULT_SCOPE);
    }

    public long getCreationTime() throws java.lang.IllegalStateException
    {
        return httpSession.getCreationTime();
    }

    public String getId() throws java.lang.IllegalStateException
    {
        return httpSession.getId();
    }

    public long getLastAccessedTime() throws java.lang.IllegalStateException
    {
        return httpSession.getLastAccessedTime();
    }

    public int getMaxInactiveInterval()
    {
        return httpSession.getMaxInactiveInterval();
    }

    public void invalidate() throws java.lang.IllegalStateException
    {
        httpSession.invalidate();
    }

    public boolean isNew() throws java.lang.IllegalStateException
    {
        return httpSession.isNew();
    }

    public void removeAttribute(String name)
    {
        this.removeAttribute(name, DEFAULT_SCOPE);
    }

    public void setAttribute(String name, Object value)
    {
        this.setAttribute(name, value, DEFAULT_SCOPE);
    }

    public void setMaxInactiveInterval(int interval)
    {
        httpSession.setMaxInactiveInterval(interval);
    }
    // --------------------------------------------------------------------------------------------

    // javax.portlet.PortletSession implementation ------------------------------------------------
    public java.lang.Object getAttribute(String name, int scope) throws java.lang.IllegalStateException
    {
        if (name == null)
        {
            throw new IllegalArgumentException("name must not be null");
        }
        if (scope==PortletSession.APPLICATION_SCOPE)
        {
            return httpSession.getAttribute(name);
        }
        else
        {
            Object attribute = httpSession.getAttribute("javax.portlet.p."+portletWindow.getId()+"?"+name);
            if (attribute == null)
            {
                // not sure, if this should be done for all attributes or only javax.servlet.
                attribute = httpSession.getAttribute(name);
            }
            return attribute;
        }
    }

    public java.util.Enumeration getAttributeNames(int scope)
    {
        if (scope==PortletSession.APPLICATION_SCOPE)
        {
            return httpSession.getAttributeNames();
        }
        else
        {
            Enumeration attributes = httpSession.getAttributeNames();

            Vector portletAttributes = new Vector();

	        /* Fix that ONLY attributes of PORTLET_SCOPE are returned. */
            int prefix_length = "javax.portlet.p.".length();
            String portletWindowId = portletWindow.getId().toString();
            
            while (attributes.hasMoreElements())
            {
                String attribute = (String)attributes.nextElement();

                int attributeScope = PortletSessionUtil.decodeScope(attribute);
                
                if (attributeScope == PortletSession.PORTLET_SCOPE && attribute.startsWith(portletWindowId, prefix_length))
                {
                	String portletAttribute = PortletSessionUtil.decodeAttributeName(attribute);
                	
                	if (portletAttribute!=null)
                	{ // it is in the portlet's namespace
                		portletAttributes.add(portletAttribute);
                	}
                }
           }

           return portletAttributes.elements();
        }
    }

    public void removeAttribute(String name, int scope) throws java.lang.IllegalStateException
    {
        if (name == null)
        {
            throw new IllegalArgumentException("name must not be null");
        }
        if (scope == PortletSession.APPLICATION_SCOPE)
        {
            httpSession.removeAttribute(name);
        }
        else
        {
            httpSession.removeAttribute("javax.portlet.p."+portletWindow.getId()+"?"+name);
        }
    }

    public void setAttribute(java.lang.String name, java.lang.Object value, int scope) throws IllegalStateException
    {
        if (name == null)
        {
            throw new IllegalArgumentException("name must not be null");
        }
        if (scope==PortletSession.APPLICATION_SCOPE)
        {
            httpSession.setAttribute(name,value);
        }
        else
        {
            httpSession.setAttribute("javax.portlet.p."+portletWindow.getId()+"?"+name, value);
        }
    }

    public PortletContext getPortletContext()
    {
        return getInternalPortletContext();
    }
    // --------------------------------------------------------------------------------------------

    // javax.servlet.http.HttpSession implementation ----------------------------------------------
    public javax.servlet.ServletContext getServletContext()
    {
        // TBD, open issue. it would be good if we could also implement the ServletContext interface at the PortletContextImpl
        return httpSession.getServletContext();
    }

    public javax.servlet.http.HttpSessionContext getSessionContext()
    {
        return httpSession.getSessionContext();
    }

    public Object getValue(String name)
    {
        return this.getAttribute(name, DEFAULT_SCOPE);
    }

    public String[] getValueNames()
    {
        // TBD
        return null;
    }

    public void putValue(String name, Object value)
    {
        this.setAttribute(name, value, DEFAULT_SCOPE);
    }

    public void removeValue(String name)
    {
        this.removeAttribute(name, DEFAULT_SCOPE);
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    private synchronized PortletContext getInternalPortletContext()
    {
        if (this.portletContext == null)
        {
            this.portletContext = PortletObjectAccess.getPortletContext(
                                                                       getServletContext(), 
                                                                       portletWindow.getPortletEntity().getPortletApplicationEntity().getPortletApplicationDefinition()
                                                                       );
        }
        return this.portletContext;
    }
    // --------------------------------------------------------------------------------------------
}
