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

package org.apache.pluto.portlet;

import javax.portlet.*;
import org.apache.pluto.core.*;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;


public class PortletUtils
{

    // Access to InternalPortletRequest
    public static PortletWindow getPortletWindow(RenderRequest request)
    {
        InternalPortletRequest internalRequest = CoreUtils.getInternalRequest(request);
        return internalRequest.getInternalPortletWindow();
    }

    public static PortletWindow getPortletWindow(ActionRequest request)
    {
        InternalPortletRequest internalRequest = CoreUtils.getInternalRequest(request);
        return internalRequest.getInternalPortletWindow();
    }

    // Access to InternalPortletResponse
    public static PortletWindow getPortletWindow(RenderResponse response)
    {
        InternalPortletResponse internalResponse = CoreUtils.getInternalResponse(response);
        return internalResponse.getInternalPortletWindow();
    }

    public static PortletWindow getPortletWindow(ActionResponse response)
    {
        InternalPortletResponse internalResponse = CoreUtils.getInternalResponse(response);
        return internalResponse.getInternalPortletWindow();
    }

    // Access to InternalPortletConfig
    public static javax.servlet.ServletConfig getServletConfig(PortletConfig config)
    {
        InternalPortletConfig internalConfig = CoreUtils.getInternalConfig(config);
        return internalConfig.getServletConfig();
    }

    public static PortletDefinition getPortletDefinition(PortletConfig config)
    {
        InternalPortletConfig internalConfig = CoreUtils.getInternalConfig(config);
        return internalConfig.getInternalPortletDefinition();
    }

    // Access to InternalPortletContext
    public static javax.servlet.ServletContext getServletContext(PortletContext context)
    {
        InternalPortletContext internalContext = CoreUtils.getInternalContext(context);
        return internalContext.getServletContext();
    }

    public static PortletApplicationDefinition getPortletApplicationDefinition(PortletContext context)
    {
        InternalPortletContext internalContext = CoreUtils.getInternalContext(context);
        return internalContext.getInternalPortletApplicationDefinition();
    }

}
