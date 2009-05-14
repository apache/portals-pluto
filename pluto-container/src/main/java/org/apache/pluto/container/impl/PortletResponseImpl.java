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
package org.apache.pluto.container.impl;

import java.util.Enumeration;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.ResourceURLProvider;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.util.ArgumentUtility;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/**
 * Abstract <code>javax.portlet.PortletResponse</code> implementation.
 */
public abstract class PortletResponseImpl implements PortletResponse
{
	
    private String namespace;    
    private PortletResponseContext responseContext;
    
    // Constructor -------------------------------------------------------------
    
    public PortletResponseImpl(PortletResponseContext responseContext) {
        this.responseContext = responseContext;
    }
    
    protected PortletResponseContext getResponseContext()
    {
        return responseContext;
    }
    
    protected PortletWindow getPortletWindow() 
    {
        return responseContext.getPortletWindow();
    }

    protected PortletContainer getPortletContainer() 
    {
        return responseContext.getContainer();
    }
    
    protected PortalContext getPortalContext()
    {
        return getPortletContainer().getContainerServices().getPortalContext();
    }

    protected HttpServletRequest getServletRequest()
    {
        return responseContext.getServletRequest();
    }
    
    protected HttpServletResponse getServletResponse()
    {
        return responseContext.getServletResponse();
    }

    protected boolean isPortletModeAllowed(PortletMode mode)
    {
        if(PortletMode.VIEW.equals(mode))
        {
            return true;
        }
        
        String modeName = mode.toString();

        PortletDefinition dd = getPortletWindow().getPortletDefinition();

        for (Supports sup : dd.getSupports())
        {
            for (String m : sup.getPortletModes())
            {
                if (m.equalsIgnoreCase(modeName)) 
                {
                    // check if a portlet managed mode which is always allowed.
                    CustomPortletMode cpm = dd.getApplication().getCustomPortletMode(modeName);
                    if (cpm != null && !cpm.isPortalManaged())
                    {
                        return true;
                    }
                    Enumeration<PortletMode> supportedModes = getPortalContext().getSupportedPortletModes();
                    while (supportedModes.hasMoreElements()) 
                    {
                        if (supportedModes.nextElement().equals(mode)) 
                        {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    // PortletResponse Impl ----------------------------------------------------
    
    public void addProperty(Cookie cookie)
    {
        ArgumentUtility.validateNotNull("cookie", cookie);
        responseContext.addProperty(cookie);
    }

    public void addProperty(String key, Element element)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        responseContext.addProperty(key, element);
    }


    public void addProperty(String key, String value)
    {
    	ArgumentUtility.validateNotEmpty("key", key);
    	responseContext.addProperty(key, value);
    }
    
    public Element createElement(String tagName) throws DOMException
    {
        ArgumentUtility.validateNotEmpty("tagName", tagName);
        return responseContext.createElement(tagName);
    }
    
    public String encodeURL(String path)
    {
        if (path.indexOf("://") == -1 && !path.startsWith("/"))
        {
            throw new IllegalArgumentException("only absolute URLs or full path URIs are allowed");
        }
                
        ResourceURLProvider provider = responseContext.getResourceURLProvider();
        if (path.indexOf("://") != -1) {
            provider.setAbsoluteURL(path);
        } else {
            provider.setFullPath(path);
        }
        return getServletResponse().encodeURL(provider.toString());
    }
    
    public String getNamespace()
    {
        if (namespace == null)
        {
             namespace = getPortletContainer().getContainerServices().getNamespaceMapper().encode(getPortletWindow().getId(), "");
             StringBuffer validNamespace = new StringBuffer();
             for (int i = 0; i < namespace.length(); i++)
             {
                char ch = namespace.charAt(i);
                if (Character.isJavaIdentifierPart(ch))
                {
                    validNamespace.append(ch);
                } 
                else
                {
                    validNamespace.append('_');
                }
             }
             namespace = validNamespace.toString();
        }
        return namespace;
    }
    
    public void setProperty(String key, String value)
    {
        ArgumentUtility.validateNotEmpty("key", key);
        responseContext.setProperty(key, value);
    }
}
