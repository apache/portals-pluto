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

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.ContainerService;

/**
 * The interfaces defined in this package represent an abstract object
 * model (OM) that is applicable for different implementations.
 * <P>
 * This abstraction layer helps to generalize the portlet container from
 * special implementations like data storage and moreover it is not bound
 * to a special implementation.
 * 
 **/
public interface DynamicTitleService extends ContainerService 
{

    /**
     * Sets all properties of the given map to the portlet response.
     * 
     * @param window the portlet window 
     * @param dynamicTitle the string containing the dynamic title. NULL will reset the title to the default one.
     **/
    public void setDynamicTitle(PortletWindow window,
                                HttpServletRequest request,
                                String dynamicTitle);

}
