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

package org.apache.pluto.services.title;

import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletContainerServices;
import org.apache.pluto.om.window.PortletWindow;


/**
 * The static accessor for the <CODE>DynamicTitleService</CODE>.
 *
 * @see   DynamicTitleService
 **/
public class DynamicTitle
{


    public static void setDynamicTitle(PortletWindow window,
                                       HttpServletRequest request,
                                       String dynamicTitle)
    {
        if (getService() != null)
        {
            getService().setDynamicTitle( window, request, dynamicTitle);
        }
    }

    private static DynamicTitleService getService()
    {
        return(DynamicTitleService )PortletContainerServices.get(DynamicTitleService .class);
    }
}
