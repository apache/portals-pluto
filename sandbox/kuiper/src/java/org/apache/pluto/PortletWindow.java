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

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 10:47:02 PM
 */
public interface PortletWindow {

    String getPortletId();
    String getContextPath();
    String getPortletName();

    WindowState getWindowState();
    PortletMode getPortletMode();

    // Callbacks to the portal.
    void setWindowState(WindowState state);
    void setPortletMode(PortletMode mode);

    PortletPreferences getPortletPreferences();
}
