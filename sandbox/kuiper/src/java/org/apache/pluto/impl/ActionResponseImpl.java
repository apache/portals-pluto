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

package org.apache.pluto.impl;

import org.apache.pluto.PortletWindow;

import javax.portlet.ActionResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/** ActionResponse implementation.  Leverages the PortletResponseImpl
 *  for most of it's implementation.
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 11:14:47 AM
 */
public class ActionResponseImpl extends PortletResponseImpl
    implements ActionResponse {

    /** The PortletWindow associated with this request. */
    private PortletWindow window;

    /** The render parameters associated with this
     *  response.
     */
    private Map renderParameters;

    /** Flag indicating that the response has been commited. */
    private boolean commited;

    /** Default Constructor. */
    public ActionResponseImpl(PortletWindow window,
                              HttpServletResponse response) {
        super(response);
        this.window = window;
        this.renderParameters = new java.util.HashMap();
    }

    /** Update the window state by utilizing
     *  {@see PortletWindow#setWindowState} callback.
     */
    public void setWindowState(WindowState windowState)
    throws WindowStateException {
        commited = true;
        window.setWindowState(windowState);
    }

    /** Update the PortletMode by utilizing the
     *  {@see PortletMode#setPortletMode} callback.
     * @param portletMode
     * @throws PortletModeException
     */
    public void setPortletMode(PortletMode portletMode)
    throws PortletModeException {
        commited = true;
        window.setPortletMode(portletMode);
    }

    /** Instruct the portal to redirect it's response. */
    public void sendRedirect(String url)
    throws IOException {
        if(isInCommitedState()) {
            throw new IllegalStateException("Response may not be" +
                                            "redirected after the following"+
                                            "methods have been invoked: "+
                                            "setWindowSate,setPortletMode,"+
                                            "setRenderParameter,setRenderParameters");
        }
        super.sendRedirect(url);
    }

    /** Set the render parameters of
     *  that should be used to any subsequent render
     *  request.
     *
     * @param map
     */
    public void setRenderParameters(Map map) {
        renderParameters = map;
    }

    /** Set a render parameters that should be used for
     *  any subsequent render request.
     * @param key
     * @param value
     */
    public void setRenderParameter(String key, String value) {
        renderParameters.put(key, new String[] {value});
    }

    /** Set the render parameter that should be set
     *  for any subsequent render request.
     *
     * @param key
     * @param values
     */
    public void setRenderParameter(String key, String[] values) {
        renderParameters.put(key, values);
    }

    /** Determine whther the response has been commited.
     *
     * @return
     */
    private boolean isInCommitedState() {
        return commited;
    }
}
