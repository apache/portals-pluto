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

import javax.servlet.ServletConfig;
import javax.portlet.PortletConfig;

/** Optional Factory Service used by the PlutoContainer
 *  to create PortletConfigs.
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 25, 2004 at 7:13:53 PM
 */
public interface PortletConfigFactoryService {

    /** Create a PortletConfig for the given  portletId
     *  and the servlet config within which it resides.
     *
     * @param portletId
     * @param config
     * @return
     */ 
    PortletConfig createPortletConfig(String portletId, ServletConfig config);

}
