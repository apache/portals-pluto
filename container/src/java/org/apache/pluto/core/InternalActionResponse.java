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

package org.apache.pluto.core;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

/**
 * ActionResponse implemntation.
 *
 */
public interface InternalActionResponse extends InternalPortletResponse {

    /**
     * Retrieve the render parameters associated with
     * this response.
     *
     * @return map of all render parameters associated with this request.
     */
    public Map getRenderParameters();

    /**
     * Retrieve the portlet mode.
     * @return
     */
    public PortletMode getChangedPortletMode();

    /**
     * Retrieve the window state.
     * @return
     */
    public WindowState getChangedWindowState();

    /**
     * Retreive the location for which the action should
     * be redirected.
     * @return
     */
    public String getRedirectLocation();
}


