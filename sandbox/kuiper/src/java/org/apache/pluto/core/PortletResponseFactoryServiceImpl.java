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

import org.apache.pluto.services.PortletResponseFactoryService;
import org.apache.pluto.services.PortletURLService;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.impl.RenderResponseImpl;
import org.apache.pluto.impl.ActionResponseImpl;
import org.apache.pluto.impl.LoadResponseImpl;

import javax.portlet.RenderResponse;
import javax.portlet.ActionResponse;
import javax.portlet.PortletResponse;
import javax.portlet.PortletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 29, 2004 at 9:51:13 AM
 */
public class PortletResponseFactoryServiceImpl implements
        PortletResponseFactoryService{

    private PortletURLService service;
    public PortletResponseFactoryServiceImpl(PortletURLService url) {
        this.service = url;
    }

    public RenderResponse createRenderResponse(HttpServletRequest req,
                                               HttpServletResponse res,
                                               PortletContext context,
                                               PortletWindow window) {
        return new RenderResponseImpl(window, req, res, service);
    }

    public ActionResponse createActionResponse(HttpServletRequest req,
                                               HttpServletResponse res,
                                               PortletContext context,
                                               PortletWindow window,
                                               Map renderParameterStorage) {
        return new ActionResponseImpl(window, res, renderParameterStorage);
    }

    public PortletResponse createLoadResponse(HttpServletRequest req,
                                              HttpServletResponse res,
                                              PortletContext context,
                                              PortletWindow window) {
        return new LoadResponseImpl(res);
    }
}
