/*
 * Copyright 2004 The Apache Software Foundation.
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

import org.apache.pluto.services.optional.PortletPreferencesService;
import org.apache.pluto.services.optional.PortletEnvironmentService;
import org.apache.pluto.services.optional.PortletInvokerService;
import org.apache.pluto.core.InternalPortletWindow;

/**
 * Defines the services necessary for integration between the Pluto Container
 * and a Portal.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public interface OptionalContainerServices {

    /**
     * Returns the portlet preferences service implementation.
     * @return the portlet preferences service implementation.
     */
    public PortletPreferencesService getPortletPreferencesService();

    public PortletEnvironmentService getPortletEnvironmentService();
    
    /**
     * Returns an invoker for the specified PortletWindow.
     * @param portletWindow  the InternalPortletWindow used for invocation.
     * @return an invoker which can be used to service the indicated portlet.
     */
    public PortletInvokerService getPortletInvokerService(
    		InternalPortletWindow portletWindow);

}
