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

package org.apache.pluto.services.property;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.ContainerService;

/**
 * The <code>PropertyManagerService</code> interface is a container service
 * providing the portlet container with external defined properties.
 * This interface allows to associate properties with the portlet request
 * and portlet response.
 * <br> 
 * This service represents an abstract layer to make the property 
 * management independent of the portlet container and to allow
 * diverse special implementations. 
 * 
 * <p>This SPI interface can be implemented by the portal.</p>
 **/
public interface PropertyManagerService extends ContainerService 
{

    /**
     * Sets the given property map defined by the portlet window in its response.  
     * <br>
     * The purpose of this method is to provide the portal framework
     * with a new map of properties set by the portlet. The map can be empty, but not NULL
     * <br>
     * This method can be called multiple times during one request by the portlet container
     * 
     * @param window the portlet window of this property
     * @param request the servlet request
     * @param response the servlet response
     * @param properties the String/String array map containing the
     *                  properties to be set.
     **/
    public void setResponseProperties(PortletWindow window,
                                      HttpServletRequest request,
                                      HttpServletResponse response,
                                      Map properties);

    /**
     * Returns all properties for the given portlet window 
     * defined in the portal as String/String array map.
     * They will be made available to the portlet through the
     * portlet request.
     * <br>
     * The purpose of this method is to allow the portal framework
     * to create a map of properties and make it available to the portlet container.
     * <br>
     * This method can be called multiple times during one request by the portlet container
     * <br>
     * The return value cannot be null.
     *
     * @param window the portlet window of this property
     * @param request the servlet request
     * 
     * @return		a <code>Map</code> containing
     *                  all properties. If there are no properties of
     *                  that name returns an empty <code>Map</code>.    
     **/          
    public Map getRequestProperties(PortletWindow window,
                                    HttpServletRequest request);

}
