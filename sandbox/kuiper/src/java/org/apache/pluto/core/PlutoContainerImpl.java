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

package org.apache.pluto.core;

import org.apache.pluto.PlutoEnvironment;
import org.apache.pluto.PlutoContainer;
import org.apache.pluto.PlutoException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.services.PortletInvokerService;
import org.apache.pluto.services.ServiceFactory;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.OptionalServiceFactory;

import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Default PlutoContainer implementation.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 9:14:28 PM
 */
public class PlutoContainerImpl implements PlutoContainer {

    //Service Commonly Used
    private PortletInvokerService invoker;
    private LoggerService loggerService;

    // Initialization Parameters
    private PlutoEnvironment env;

    // Constructed Internally
    private PortletRegistry registry;

    /** Constructor used to create the PlutoContainer
     *  using only the required services.
     *
     * @param env
     * @param factory
     */
    public PlutoContainerImpl(PlutoEnvironment env, ServiceFactory factory) {
        this(env, new ServiceFactoryWrapper(env, factory));
    }

    /** Constructor used to create the PlutoContainer
     *  using both Required and Optional services.
     * @param env
     * @param factory
     */
    public PlutoContainerImpl(PlutoEnvironment env,
                              OptionalServiceFactory factory) {
        this.env = env;

        this.invoker = factory.getPortletInvokerService();
        this.loggerService = factory.getLoggerService();

        // Initialize the invoker
        this.registry = new PortletRegistry(loggerService);
        invoker.init(registry);
    }

    public String getContainerName() {
        return env.getContainerName();
    }

    public void destroy() {
        this.env = null;
        this.registry = null;
    }

    public void start() {
        // we don't need to do anything to start
    }


    public void stop() {
        // we don't need to do anything to stop
    }

    public void doRender(PortletWindow window,
                         HttpServletRequest req,
                         HttpServletResponse res)
    throws PlutoException, PortletException, IOException {
        invoker.doRender(window, req, res);
    }

    /** Request that the Portlet Action be serviced.
     *  This method should always be invoked before the
     *  Portlet commits any response.
     * 
     * @param window
     * @param req
     * @param res
     * @throws PlutoException
     * @throws PortletException
     * @throws IOException
     */
    public void doAction(PortletWindow window,
                         HttpServletRequest req,
                         HttpServletResponse res)
    throws PlutoException, PortletException, IOException {
        invoker.doAction(window, req, res);
    }

    public void doLoad(PortletWindow window,
                       HttpServletRequest req,
                       HttpServletResponse res)
    throws PlutoException, PortletException, IOException {
        invoker.doLoad(window, req, res);
    }

    /** Retrieve the registry for this container.*/
    public PortletRegistry getPortletRegistry() {
        return registry;
    }
}
