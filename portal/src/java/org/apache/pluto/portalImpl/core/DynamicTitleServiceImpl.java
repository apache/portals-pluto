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

package org.apache.pluto.portalImpl.core;

import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.title.DynamicTitleService;

public class DynamicTitleServiceImpl implements DynamicTitleService
{    

    DynamicTitleServiceImpl()
    {
    }    

    public void setDynamicTitle(PortletWindow window,
                                HttpServletRequest request,
                                String dynamicTitle)
    {
        request.setAttribute("org.apache.pluto.dynamic_title"+window.getId(), dynamicTitle);
    }
                                
    public String getDynamicTitle(PortletWindow window,
                                  HttpServletRequest request)
    {
        return (String)request.getAttribute("org.apache.pluto.dynamic_title"+window.getId());
    }


}
