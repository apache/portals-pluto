/*
 * Copyright 2004 The Apache Software Foundation
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

package org.apache.pluto.driver.deploy;

import org.apache.pluto.descriptors.services.PortletAppDescriptorService;

/**
 * Service interface defining a mechanism for registering
 * a portlet application with a portal.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 9, 2005
 */
public interface PortalRegistrarService {

    /**
     * Register the application defined by the service.
     * @param service
     */
    void register(PortletAppDescriptorService service);
}
