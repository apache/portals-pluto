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


package org.apache.pluto.services;

import org.apache.pluto.PortletWindow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletContext;
import java.util.Map;

/** Optional Factory Service used by the Pluto Container
 *  to create PortletRequests.
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 25, 2004 at 7:07:35 PM
 */
public interface PortletRequestFactoryService {

    /** Create a RenderRequest for the given
     *  servlet request and associated window.
     * @param req
     * @param window
     * @return
     */
    RenderRequest createRenderRequest(HttpServletRequest req,
                                      HttpServletResponse res,
                                      PortletContext context,
                                      PortletWindow window,
                                      Map renderParameters);

    /** Create an ActionRequest for the given
     *  servlet request and associated window.
     * @param req
     * @param window
     * @return
     */
    ActionRequest createActionRequest(HttpServletRequest req,
                                      HttpServletResponse res,
                                      PortletContext context,
                                      PortletWindow window);

    /** Create a load request for the given
     *  servlet request and associated window.
     *
     * @param req
     * @param window
     * @return
     */
    PortletRequest createLoadRequest(HttpServletRequest req,
                                     HttpServletResponse res,
                                     PortletContext context,
                                     PortletWindow window);
}
