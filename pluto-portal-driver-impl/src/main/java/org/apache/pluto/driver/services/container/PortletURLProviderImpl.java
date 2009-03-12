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
package org.apache.pluto.driver.services.container;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.PortletSecurityException;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;

import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.url.PortalURLParameter;

/**
 *
 */
public class PortletURLProviderImpl implements PortletURLProvider {

    private final PortalURL url;
    private final TYPE type;
    private final String window;
    private PortletMode portletMode;
    private WindowState windowState;
    private String cacheLevel;
    private String resourceID;
    private Map<String, String[]> renderParameters;
    private Map<String, String[]> publicRenderParameters;
    private Map<String, List<String>> properties;

    public PortletURLProviderImpl(PortalURL url, TYPE type, PortletWindow portletWindow)
    {
        this.url = url;
        this.type = type;
        this.window = portletWindow.getId().getStringId();
    }
    
    public PortalURL apply()
    {
        PortalURL url = this.url.clone();
        if (PortletURLProvider.TYPE.ACTION == type)
        {
            url.setActionWindow(window);
            url.setResourceWindow(null);
            url.clearParameters(window);
        }
        else if (PortletURLProvider.TYPE.RESOURCE == type)
        {
            url.setActionWindow(null);
            url.setResourceWindow(window);
            if (ResourceURL.FULL.equals(cacheLevel) || ResourceURL.PORTLET.equals(cacheLevel))
            {
                url.clearParameters(window);                
            }
        }
        else
        {
            url.setResourceWindow(null);
            url.setActionWindow(null);
            url.clearParameters(window);
        }
        url.setPortletMode(window, portletMode);
        url.setWindowState(window, windowState);
        if (renderParameters != null)
        {
            for (Map.Entry<String,String[]> entry : renderParameters.entrySet())
            {
                if (PortletURLProvider.TYPE.RESOURCE == type)
                {
                    url.getPrivateParameters().put(entry.getKey(), entry.getValue().clone());
                }
                else if (publicRenderParameters != null && !publicRenderParameters.containsKey(entry.getKey()))
                {
                    url.addParameter(new PortalURLParameter(window, entry.getKey(), entry.getValue()));
                }
            }
        }
        if (publicRenderParameters != null)
        {
            for (Map.Entry<String,String[]> entry : publicRenderParameters.entrySet())
            {
                url.addParameter(new PortalURLParameter(window, entry.getKey(), entry.getValue() != null ? entry.getValue() : new String[]{null}));
            }
        }
        url.setResourceID(resourceID);
        return url;
    }
    
    public TYPE getType()
    {
        return type;
    }
    
    public void setPortletMode(PortletMode mode)
    {
        this.portletMode = mode;
    }
    
    public PortletMode getPortletMode()
    {
        return portletMode;
    }

    public void setWindowState(WindowState state)
    {
        this.windowState = state;
    }

    public WindowState getWindowState()
    {
        return windowState;
    }

    public void setSecure(boolean secure) throws PortletSecurityException {
        // ignore: not supported
    }
    
    public boolean isSecure()
    {
        return false;
    }
    
    public Map<String,String[]> getRenderParameters()
    {
        if (renderParameters == null)
        {
            renderParameters = new HashMap<String,String[]>();
        }
        return renderParameters;
    }
    
    public Map<String,String[]> getPublicRenderParameters()
    {
        if (publicRenderParameters == null)
        {
            publicRenderParameters = new HashMap<String,String[]>();
        }
        return publicRenderParameters;
    }
    
    public String getCacheability()
    {
        return cacheLevel;
    }

    public void setCacheability(String cacheLevel)
    {
        this.cacheLevel = cacheLevel;
    }

    public String getResourceID()
    {
        return resourceID;
    }

    public void setResourceID(String resourceID)
    {
        this.resourceID = resourceID;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.container.PortletURLProvider#toURL(boolean)
     */
    public String toURL(boolean absolute)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.container.PortletURLProvider#write(java.io.Writer, boolean)
     */
    public void write(Writer out, boolean escapeXML)
    {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.container.PortletURLProvider#write(java.io.Writer)
     */
    public void write(Writer out)
    {
        // TODO Auto-generated method stub
        
    }

    public Map<String, List<String>> getProperties()
    {
        if (properties == null)
        {
            properties = new HashMap<String, List<String>>();
        }
        return properties;
    }
}
