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

import javax.portlet.WindowState;
import javax.portlet.PortletMode;
import javax.portlet.PortletContext;
import javax.portlet.PortletPreferences;

/** Defines the state of a single window of a
 *  portlet instance. Each PortletWindow represents
 *  a single portlet on a single page for a single
 *  session.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 10:47:02 PM
 */
public interface PortletWindow {

    /** Retrieve the unique portlet identifier. */
    String getPortletId();

    /** Retrieve the name of the context in
     *  which the portlet exists.
     * @return
     */
    String getContextPath();

    /** Retrieve the name of the Portlet which
     *  this window reflects as indicated in the
     *  portlet application deployment descriptor.
     * @return
     */
    String getPortletName();

    /** Retrieve the current window state of this
     *  portlet.
     * @return
     */
    WindowState getWindowState();

    /** Retrieve the current portlet mode of this
     *  portlet.
     * @return
     */
    PortletMode getPortletMode();

    /** Retrieve the portlet preferences for
     *  this window.
     * @return
     */
    PortletPreferences getPortletPreferences();

    /** Set the window state of this PortletWindow. */
    void setWindowState(WindowState state);

    /** Set the mode of this PortletWindow. */
    void setPortletMode(PortletMode mode);
}
