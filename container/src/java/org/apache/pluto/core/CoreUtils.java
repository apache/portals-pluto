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

package org.apache.pluto.core;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.pluto.portlet.PortletRequestWrapper;
import org.apache.pluto.portlet.PortletResponseWrapper;

public class CoreUtils
{
    // Access to InternalPortletRequest
    public static InternalPortletRequest getInternalRequest(PortletRequest request)
    {
        while (!(request instanceof InternalPortletRequest))
        {
            request = ((PortletRequestWrapper)request).getPortletRequest();
            if (request == null)
            {
                throw new IllegalStateException("The internal portlet request cannot be found.");                
            }
        }
        return(InternalPortletRequest)request;
    }

    // Access to InternalPortletResponse
    public static InternalPortletResponse getInternalResponse(PortletResponse response)
    {
        while (!(response instanceof InternalPortletResponse))
        {
            response = ((PortletResponseWrapper)response).getPortletResponse();
            if (response == null)
            {
                throw new IllegalStateException("The internal portlet response cannot be found.");                
            }
        }
        return(InternalPortletResponse)response;
    }

    // Access to InternalPortletConfig
    public static InternalPortletConfig getInternalConfig(PortletConfig config)
    {
        return(InternalPortletConfig)config;
    }

    // Access to InternalPortletContext
    public static InternalPortletContext getInternalContext(PortletContext context)
    {
        return(InternalPortletContext)context;
    }

}
