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

/**
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 11:14:47 AM
 */
public class ActionResponseImpl extends PortletResponseImpl
    implements ActionResponse {

    private PortletWindow window;
    private Map renderParameters;
    private boolean commited;

    public ActionResponseImpl(PortletWindow window,
                              HttpServletResponse response) {
        super(response);
        this.window = window;
        this.renderParameters = new java.util.HashMap();
    }
    
    public void setWindowState(WindowState windowState)
    throws WindowStateException {
        commited = true;
        window.setWindowState(windowState);
    }

    public void setPortletMode(PortletMode portletMode)
    throws PortletModeException {
        commited = true;
        window.setPortletMode(portletMode);
    }

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

    public void setRenderParameters(Map map) {
        renderParameters = map;
    }

    public void setRenderParameter(String key, String value) {
        renderParameters.put(key, new String[] {value});
    }

    public void setRenderParameter(String key, String[] values) {
        renderParameters.put(key, values);
    }

    private boolean isInCommitedState() {
        return commited;
    }
}
