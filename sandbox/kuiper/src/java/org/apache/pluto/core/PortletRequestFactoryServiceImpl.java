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

package org.apache.pluto.core;

import org.apache.pluto.services.PortletRequestFactoryService;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.PlutoEnvironment;
import org.apache.pluto.impl.RenderRequestImpl;
import org.apache.pluto.impl.ActionRequestImpl;
import org.apache.pluto.impl.LoadRequestImpl;

import javax.portlet.RenderRequest;
import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 29, 2004 at 9:12:48 AM
 */
public class PortletRequestFactoryServiceImpl
    implements PortletRequestFactoryService {

    private PlutoEnvironment env;

    public PortletRequestFactoryServiceImpl(PlutoEnvironment env) {
        this.env = env;
    }

    public RenderRequest createRenderRequest(HttpServletRequest req,
                                             HttpServletResponse res,
                                             PortletContext context,
                                             PortletWindow window,
                                             Map renderParameters) {
        return new RenderRequestImpl(env, context, window, req, renderParameters);
    }

    public ActionRequest createActionRequest(HttpServletRequest req,
                                             HttpServletResponse res,
                                             PortletContext context,
                                             PortletWindow window) {
        return new ActionRequestImpl(env, context, window, req);
    }

    public PortletRequest createLoadRequest(HttpServletRequest req,
                                            HttpServletResponse res,
                                            PortletContext context,
                                            PortletWindow window) {
        return new LoadRequestImpl(env, context, window, req);
    }

}
