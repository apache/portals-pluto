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

package org.apache.pluto.services.property;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainerServices;
import org.apache.pluto.om.window.PortletWindow;


/**
 * The static accessor for the <CODE>PropertyManagerService</CODE>.
 *
 * @see   PropertyManagerService
 **/
public class PropertyManager
{


    public static void setResponseProperties(PortletWindow window,
                                             HttpServletRequest request,
                                             HttpServletResponse response,
                                             Map properties)
    {
        if (getService() != null)
        {
            getService().setResponseProperties( window, request, response, properties);
        }
    }

    public static Map getRequestProperties(PortletWindow window,
                                           HttpServletRequest request)
    {
        if (getService() == null)
        {
            return null;
        }

        return getService().getRequestProperties( window, request);
    }

    private static PropertyManagerService getService()
    {
        return(PropertyManagerService)PortletContainerServices.get(PropertyManagerService.class);
    }
}
