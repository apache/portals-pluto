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

import javax.portlet.PortalContext;
import javax.portlet.WindowState;
import javax.portlet.PortletMode;
import javax.servlet.ServletContext;
import java.util.Properties;
import java.util.Set;

/** Container Configuration Parameters.
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 9:34:38 PM
 */
public interface PlutoEnvironment {

    /** Retrieve the unique container name of
     *  this container.
     * @return
     */
    String getContainerName();

    /** The PortalContext of the encapsulating
     *  portal.
     * @return
     */ 
    PortalContext getPortalContext();

    /** The ServletContext of the portal
     *  within which the container resides.
     * @return
     */
    ServletContext getServletContext();

    /** Determine if the WindowState is allowed. */
    boolean isWindowStateAllowed(WindowState state);

    /** Determin if the PortletMode is allowed. */
    boolean isPortletModeAllowed(PortletMode mode);

    /** Retrieve the WindowState identified by state. */
    WindowState getWindowState(String state);

    /** Retrieve any PortalProperties. */
    Properties getPortalProperties();

    /** Retrieve the supported content types. */
    Set getSupportedContentTypes();
}
