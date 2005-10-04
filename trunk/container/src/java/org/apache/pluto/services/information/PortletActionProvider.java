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
/* 

 */

package org.apache.pluto.services.information;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

/**
 * Handle operations that the portlet may perform in an action method.
 * This service is request based.
 */
public interface PortletActionProvider {


    /**
     * Changes the portlet mode to be displayed next.
     *
     * @param mode   the portlet mode defining in which mode the portlet should be shown next.
     */
    public void changePortletMode(PortletMode mode);

    /**
     * Changes the portlet window state to be displayed next.
     *
     * @param state  the portlet window state in which the portlet should be shown next.
     */
    public void changePortletWindowState(WindowState state);

}
