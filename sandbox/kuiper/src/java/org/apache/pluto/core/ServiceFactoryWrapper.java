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

import org.apache.pluto.services.OptionalServiceFactory;
import org.apache.pluto.services.PortletInvokerService;
import org.apache.pluto.services.PortletRequestFactoryService;
import org.apache.pluto.services.PortletResponseFactoryService;
import org.apache.pluto.services.PortletConfigFactoryService;
import org.apache.pluto.services.ServiceFactory;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.PortletURLService;
import org.apache.pluto.PlutoEnvironment;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 29, 2004 at 9:06:05 AM
 */
public class ServiceFactoryWrapper implements OptionalServiceFactory {

    private LoggerService loggerService;
    private PortletURLService portletURLService;

    // Created Services
    private PortletInvokerService invokerService;
    private PortletRequestFactoryService requestFactory;
    private PortletResponseFactoryService responseFactory;
    private PortletConfigFactoryService portletConfigFactory;

    public ServiceFactoryWrapper(PlutoEnvironment env,
                                 ServiceFactory factory) {
        this.loggerService = factory.getLoggerService();
        this.portletURLService = factory.getPortletURLService();

        // Create Optional Services
        this.requestFactory =
            new PortletRequestFactoryServiceImpl(
                env
            );

        this.responseFactory =
            new PortletResponseFactoryServiceImpl(
                factory.getPortletURLService()
            );

        this.portletConfigFactory =
            new PortletConfigFactoryServiceImpl();

        // This must be created last
        this.invokerService =
                new PortletInvokerServiceImpl(
                    env, this
                );
    }

    public LoggerService getLoggerService() {
        return loggerService;
    }

    public PortletURLService getPortletURLService() {
        return portletURLService;
    }

    public PortletInvokerService getPortletInvokerService() {
        return this.invokerService;
    }

    public PortletRequestFactoryService getRequestFactoryService() {
        return this.requestFactory;
    }

    public PortletResponseFactoryService getResponseFactoryService() {
        return this.responseFactory;
    }

    public PortletConfigFactoryService getPortletConfigFactoryService() {
        return this.portletConfigFactory;
    }
}
