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

import javax.portlet.PortalContext;

import org.apache.pluto.services.information.InformationProviderAccess;
import org.apache.pluto.services.information.PortalContextProvider;
import org.apache.pluto.util.Enumerator;
/**
 * The <CODE>PortalContext</CODE> interface gives the portlet
 * the ability to retrieve information about the portal calling this portlet.
 * <p>
 * The portlet can only read the <CODE>PortalContext</CODE> data.
 */
public class PortalContextImpl implements PortalContext
{

    private PortalContextProvider provider = null;

    public PortalContextImpl() 
    {
        provider = InformationProviderAccess.getStaticProvider().getPortalContextProvider();
    }

    // javax.portlet.PortalContext implementation -------------------------------------------------
    public java.lang.String getProperty(java.lang.String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Property name == null");
        }

        return provider.getProperty(name);
    }


    public java.util.Enumeration getPropertyNames()
    {
        return(new Enumerator(provider.getPropertyNames()));
    }

    public java.util.Enumeration getSupportedPortletModes()
    {
        return new Enumerator(provider.getSupportedPortletModes());
    }

    public java.util.Enumeration getSupportedWindowStates()
    {
        return new Enumerator(provider.getSupportedWindowStates());
    }

    public String getPortalInfo()
    {
        return provider.getPortalInfo();
    }
    // --------------------------------------------------------------------------------------------
}
