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

package org.apache.pluto.driver.impl.services;

import org.apache.pluto.services.ServiceFactory;
import org.apache.pluto.services.Logger;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.PortletURLService;
import org.apache.pluto.services.PortletInvokerService;
import org.apache.pluto.core.PortletInvokerServiceImpl;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.servlet.ServletContext;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 9:45:48 AM
 */
public class ServiceFactoryImpl implements ServiceFactory {
    
    private LoggerService loggerService;
    private PortletURLService portletURLService;
    private PortletInvokerService portletInvokerService;
    
    public ServiceFactoryImpl(LoggerService ls,
                              PortletURLService pus,
                              PortletInvokerService pis) {
        this.loggerService = ls;
        this.portletURLService = pus;
        this.portletInvokerService = pis;
    }

    public LoggerService getLoggerService() {
        return loggerService;
    }

    public PortletURLService getPortletURLService() {
        return portletURLService;
    }

    public PortletInvokerService getPortletInvokerService() {
        return portletInvokerService;
    }


}
