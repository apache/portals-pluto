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

import java.util.ArrayList;
import java.util.Collection;

import javax.portlet.PortletMode;
import javax.portlet.RenderResponse;

import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.util.ArgumentUtility;


/**
 * Implementation of the <code>javax.portlet.RenderResponse</code> interface.
 * 
 */
public class RenderResponseImpl extends MimeResponseImpl implements RenderResponse
{	
    private PortletRenderResponseContext responseContext;
    
    public RenderResponseImpl(PortletRenderResponseContext responseContext)
    {
        super(responseContext);
        this.responseContext = responseContext;
    }
    
    /**
     * Checks if the specified content type is valid (supported by the portlet).
     * The specified content type should be a tripped mime type without any
     * character encoding suffix.
     * @param contentType  the content type to check.
     * @return true if the content type is valid, false otherwise.
     */
    protected boolean isValidContentType(String contentType)
    {
        boolean valid = false;
        for (String supportedType : getResponseContentTypes())
        {
            // Content type is supported by an exact match.
            if (supportedType.equals(contentType))
            {
                valid = true;
            }
            // The supported type contains a wildcard.
            else if (supportedType.indexOf("*") >= 0)
            {
                int index = supportedType.indexOf("/");
                String supportedPrefix = supportedType.substring(0, index);
                String supportedSuffix = supportedType.substring(index + 1);
                index = contentType.indexOf("/");
                String typePrefix = contentType.substring(0, index);
                String typeSuffix = contentType.substring(index + 1);
                // Check if the prefixes match AND the suffixes match.
                if (supportedPrefix.equals("*") || supportedPrefix.equals(typePrefix))
                {
                    if (supportedSuffix.equals("*") || supportedSuffix.equals(typeSuffix))
                    {
                        valid = true;
                    }
                }
            }
        }
        // Return the check result.
        return valid;
    }
    
    @Override
    public void setContentType(String contentType)
    {
        ArgumentUtility.validateNotNull("contentType", contentType);
        int index =contentType.indexOf(';');
        if (index != -1)
        {
            contentType = contentType.substring(0, index);
        }
        contentType = contentType.trim();
        if (!isValidContentType(contentType))
        {
            throw new IllegalArgumentException("Specified content type '" + contentType + "' is not supported.");
        }
        super.setContentType(contentType);
    }
    
    public void setNextPossiblePortletModes(Collection<PortletMode> portletModes)
    {
        ArgumentUtility.validateNotNull("portletModes", portletModes);
        if (portletModes.isEmpty())
        {
            throw new IllegalArgumentException("At least one possible PortletMode should be specified.");            
        }
        ArrayList<PortletMode> modes = new ArrayList<PortletMode>();
        for (PortletMode mode : portletModes)
        {
            if (isPortletModeAllowed(mode))
            {
                modes.add(mode);
            }
        }
        if (modes.isEmpty())
        {
            modes.add(getPortletWindow().getPortletMode());
        }
        responseContext.setNextPossiblePortletModes(modes);
    }
    
    public void setTitle(String title)
    {
        responseContext.setTitle(title);
    }
}
