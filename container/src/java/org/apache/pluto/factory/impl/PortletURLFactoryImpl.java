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

package org.apache.pluto.factory.impl;

import javax.portlet.PortletURL;

import org.apache.pluto.core.impl.PortletURLImpl;
import org.apache.pluto.factory.PortletURLFactory;
import org.apache.pluto.om.window.PortletWindow;

public class PortletURLFactoryImpl implements PortletURLFactory {

    public void init(javax.servlet.ServletConfig config, java.util.Map properties) throws Exception
    {
    }

    // org.apache.pluto.factory.PortletURLFactory implementation ----------------------------------
    public PortletURL getPortletURL(PortletWindow portletWindow,
                                    javax.servlet.http.HttpServletRequest servletRequest,
                                    javax.servlet.http.HttpServletResponse servletResponse)
    {
        return getPortletURL(portletWindow, servletRequest, servletResponse, false);
    }

    public PortletURL getPortletURL(PortletWindow portletWindow,
                                    javax.servlet.http.HttpServletRequest servletRequest,
                                    javax.servlet.http.HttpServletResponse servletResponse,
                                    boolean isAction) {
        return new PortletURLImpl(portletWindow, servletRequest, servletResponse, isAction);
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    public void destroy() throws Exception
    {
    }
    // --------------------------------------------------------------------------------------------
}
