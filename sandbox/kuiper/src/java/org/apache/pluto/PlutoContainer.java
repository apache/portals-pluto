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

package org.apache.pluto;

import org.apache.pluto.core.PortletRegistry;

import javax.portlet.PortletResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletException;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import java.io.IOException;

/**
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 9:00:55 AM
 */
public interface PlutoContainer {

    void init(PlutoEnvironment config);

    void start();
    void stop();

    /** Request that the container render the
     *  given window for the specified request and response.
     *
     * @param window
     * @param request
     * @param response
     * @throws PortletException
     * @throws PlutoException
     * @throws IOException
     */
    public void doRender(PortletWindow window,
                         HttpServletRequest request,
                         HttpServletResponse response)
    throws PortletException, PlutoException, IOException;

    /** Request that the container perform the action
     *  for the given window for the specified request
     *  and response.
     *
     * @param window
     * @param request
     * @param response
     * @throws PortletException
     * @throws PlutoException
     * @throws IOException
     */
    public void doAction(PortletWindow window,
                         HttpServletRequest request,
                         HttpServletResponse response)
    throws PortletException, PlutoException, IOException;

    /** Request that the container perform the (not yet
     *  standardized) load of the given PortletWindow
     *  for the given request and response.
     *
     * @param window
     * @param request
     * @param response
     * @throws PortletException
     * @throws PlutoException
     * @throws IOException
     */
    public void doLoad(PortletWindow window,
                       HttpServletRequest request,
                       HttpServletResponse response)
    throws PortletException, PlutoException, IOException;



// The specification states that we must
// instantiate one and only one instance of
// each portlet. Thus, we must allow the
// app to register and then retrieve each
// portlet it's going to use.

    public PortletRegistry getPortletRegistry();
}
