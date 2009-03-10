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
package org.apache.pluto.internal.impl;

import java.util.Enumeration;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.spi.ResourceURLProvider;
import org.apache.pluto.container.spi.optional.PortletResponseContext;
import org.apache.pluto.util.ArgumentUtility;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Abstract <code>javax.portlet.PortletResponse</code> implementation.
 */
public abstract class PortletResponseImpl implements PortletResponse
{
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletResponseImpl.class);
	
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
        return getPortletContainer().getRequiredContainerServices().getPortalContext();
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
        return isPortletModeAllowedByPortlet(mode) && isPortletModeAllowedByPortal(mode);
    }

    protected boolean isPortletModeAllowedByPortlet(PortletMode portletMode)
    {
        //Not checking for VIEW mode in portetlDefinition, as VIEW mode is default
        // as per specs.
        if(PortletMode.VIEW.equals(portletMode))
            return true;
        
        String mode = portletMode.toString();
        for (Supports sub : getPortletWindow().getPortletEntity().getPortletDefinition().getSupports())
        {
            for (String pm : sub.getPortletModes())
            {
                if (mode.equalsIgnoreCase(pm))
                {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isPortletModeAllowedByPortal(PortletMode mode)
    {
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
        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        try
        {
            docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            return doc.createElement(tagName);
        }
        catch (ParserConfigurationException e)
        {
            LOG.warn(e);
            throw new DOMException((short) 0, "Initialization failure");
        }
    }
    
    public String encodeURL(String path)
    {
        if (path.indexOf("://") == -1 && !path.startsWith("/"))
        {
            throw new IllegalArgumentException("only absolute URLs or full path URIs are allowed");
        }
        
        ResourceURLProvider provider = getPortletContainer()
                .getRequiredContainerServices()
                .getPortalCallbackService()
                .getResourceURLProvider(getServletRequest(), getPortletWindow());
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
             namespace = getPortletContainer().getOptionalContainerServices().getNamespaceMapper().encode(getPortletWindow().getId(), "");
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
