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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ActionResponse;
import javax.portlet.PortletResponse;
import javax.portlet.PortletContext;
import java.util.Map;

/** Options Factory Service used by the Pluto Container
 *  to create PortletResponses.
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 25, 2004 at 7:11:05 PM
 */
public interface PortletResponseFactoryService {

    /** Create a RenderResponse for the given response and
     *  associated window.
     *
     * @param res
     * @param window
     * @return
     */
    RenderResponse createRenderResponse(HttpServletRequest req,
                                        HttpServletResponse res,
                                        PortletContext context,
                                        PortletWindow window);

    /** Create an ActionResponse for the given response and
     *  associated window.
     *
     * @param res
     * @param window
     * @return
     */
    ActionResponse createActionResponse(HttpServletRequest req,
                                        HttpServletResponse res,
                                        PortletContext context,
                                        PortletWindow window,
                                        Map renderParameterStorage);

    /** Create a Load Response for the given response and
     *  associated window.
     *
     * @param res
     * @param window
     * @return
     */
    PortletResponse createLoadResponse(HttpServletRequest req,
                                       HttpServletResponse res,
                                       PortletContext context,
                                       PortletWindow window);
}
