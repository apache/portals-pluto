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

import java.net.MalformedURLException;

import javax.portlet.PortletContext;

import org.apache.pluto.core.InternalPortletContext;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;

public class PortletContextImpl implements PortletContext, InternalPortletContext
{
    private PortletApplicationDefinition portletApplicationDefinition;
    private javax.servlet.ServletContext servletContext;

    public PortletContextImpl(javax.servlet.ServletContext servletContext,
                              PortletApplicationDefinition portletApplicationDefinition)
    {
        this.servletContext = servletContext;
        this.portletApplicationDefinition = portletApplicationDefinition;
    }

    // javax.portlet.PortletContext implementation ------------------------------------------------
    public String getServerInfo()
    {
        return "Pluto/1.0";
    }

    public javax.portlet.PortletRequestDispatcher getRequestDispatcher(String path)
    {
		try {
	        javax.servlet.RequestDispatcher rd = servletContext.getRequestDispatcher(path);
    	    return new PortletRequestDispatcherImpl(rd);
        } catch (Exception e) {
    		// need to catch exception because of tomcat 4.x bug
    		// tomcat throws an exception instead of return null
    		// if the path was not found
    		return null;
    	}

    }

    public javax.portlet.PortletRequestDispatcher getNamedDispatcher(String name)
    {
       	javax.servlet.RequestDispatcher rd = servletContext.getNamedDispatcher(name);
       	return rd != null ? new PortletRequestDispatcherImpl(rd)
           	              : null;
    }

    public java.io.InputStream getResourceAsStream(String path)
    {
        return servletContext.getResourceAsStream(path);
    }
    
    public int getMajorVersion()
    {
        return 1;
    }

    public int getMinorVersion()
    {
        return 0;
    }

    public String getMimeType(String file)
    {
        return servletContext.getMimeType(file);
    }

    public String getRealPath(String path)
    {
        return servletContext.getRealPath(path);
    }

    public java.util.Set getResourcePaths(String path)
    {
        return servletContext.getResourcePaths(path);
    }

    public java.net.URL getResource(String path) throws java.net.MalformedURLException
    {
        if (path == null || !path.startsWith("/"))
        {
            throw new MalformedURLException("path must start with a '/'");
        }
        return servletContext.getResource(path);
    }

    public java.lang.Object getAttribute(java.lang.String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Attribute name == null");
        }

        return servletContext.getAttribute(name);
    }

    public java.util.Enumeration getAttributeNames()
    {
        return servletContext.getAttributeNames();
    }

    public java.lang.String getInitParameter(java.lang.String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Parameter name == null");
        }

        return servletContext.getInitParameter(name);
    }

    public java.util.Enumeration getInitParameterNames()
    {
        return servletContext.getInitParameterNames();
    }

    public void log(java.lang.String msg)
    {
        servletContext.log(msg);
    }

    public void log(java.lang.String message, java.lang.Throwable throwable)
    {
        servletContext.log(message, throwable);
    }

    public void removeAttribute(java.lang.String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Attribute name == null");
        }

        servletContext.removeAttribute(name);
    }

    public void setAttribute(java.lang.String name, java.lang.Object object)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Attribute name == null");
        }

        servletContext.setAttribute(name, object);
    }

    public String getPortletContextName()
    {
        return servletContext.getServletContextName();
    }
    // --------------------------------------------------------------------------------------------

    // org.apache.pluto.core.InternalPortletContext implementation --------------------------------
    public javax.servlet.ServletContext getServletContext()
    {
        return servletContext;
    }

    public PortletApplicationDefinition getInternalPortletApplicationDefinition()
    {
        return portletApplicationDefinition;
    }
    // --------------------------------------------------------------------------------------------
}

