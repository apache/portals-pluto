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

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.servlet.ServletConfig;

import org.apache.pluto.core.impl.ActionRequestImpl;
import org.apache.pluto.factory.ActionRequestFactory;
import org.apache.pluto.om.window.PortletWindow;

/**

 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ActionRequestFactoryImpl implements ActionRequestFactory {

    /**
     * @see org.apache.pluto.factory.Factory#init(ServletConfig, Map)
     */
    public void init(ServletConfig config, Map properties) throws Exception {
    }

    // org.apache.pluto.factory.ActionRequestFactory implementation -------------------------------
    public ActionRequest getActionRequest(PortletWindow portletWindow,
                                          javax.servlet.http.HttpServletRequest servletRequest,
                                          javax.servlet.http.HttpServletResponse servletResponse)
    {
        ActionRequest actionRequest = new ActionRequestImpl(portletWindow, servletRequest);
        return actionRequest;
    }
    // --------------------------------------------------------------------------------------------

    // additional methods -------------------------------------------------------------------------
    /**
     * @see org.apache.pluto.factory.Factory#destroy()
     */
    public void destroy() throws Exception {
    }
    // --------------------------------------------------------------------------------------------
}
