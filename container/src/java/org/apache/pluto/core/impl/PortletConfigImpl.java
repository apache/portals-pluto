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

import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;

import org.apache.pluto.core.InternalPortletConfig;
import org.apache.pluto.om.common.Language;
import org.apache.pluto.om.common.LanguageSet;
import org.apache.pluto.om.common.Parameter;
import org.apache.pluto.om.portlet.PortletDefinition;

public class PortletConfigImpl implements PortletConfig, InternalPortletConfig
{
    private javax.servlet.ServletConfig servletConfig;
    private PortletContext portletContext;
    private PortletDefinition portletDefinition;

    public PortletConfigImpl(javax.servlet.ServletConfig servletConfig,
                             PortletContext portletContext,
                             PortletDefinition portletDefinition)
    {
        this.servletConfig = servletConfig;
        this.portletContext = portletContext;
        this.portletDefinition = portletDefinition;
    }

    // javax.portlet.PortletConfig implementation -------------------------------------------------
    public String getPortletName()
    {
        return portletDefinition.getName();
    }

    public PortletContext getPortletContext()
    {
        return portletContext;
    }

    public ResourceBundle getResourceBundle(java.util.Locale locale)
    {
        LanguageSet languageSet = portletDefinition.getLanguageSet();
        Language lang = languageSet.get(locale);

        if (lang == null)
        {
            Locale defaultLocale = languageSet.getDefaultLocale();
            lang = languageSet.get(defaultLocale);  
        }

        return lang.getResourceBundle(); 
    }

    public String getInitParameter(String name)
    {
        Parameter parm = null;        
        if (name == null)
        {
            throw new IllegalArgumentException("Parameter name == null");
        }
        parm = portletDefinition.getInitParameterSet().get(name);
        return(String)(parm == null ? null : parm.getValue());
    }

    public java.util.Enumeration getInitParameterNames()
    {
        return new java.util.Enumeration()
        {
            private Iterator iterator = portletDefinition.getInitParameterSet().iterator();

            public boolean hasMoreElements()
            {
                return iterator.hasNext();
            }

            public Object nextElement()
            {
                if (iterator.hasNext())
                {
                    return((Parameter)iterator.next()).getName();
                }
                else
                {
                    return null;
                }
            }
        };
    }
    // --------------------------------------------------------------------------------------------

    // org.apache.pluto.core.InternalPortletConfig implementation ---------------------------------
    public javax.servlet.ServletConfig getServletConfig()
    {
        return servletConfig;
    }

    public PortletDefinition getInternalPortletDefinition()
    {
        return portletDefinition;
    }
    // --------------------------------------------------------------------------------------------
}
