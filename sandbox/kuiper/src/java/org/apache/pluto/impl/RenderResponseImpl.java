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
import org.apache.pluto.services.PortletURLService;

import javax.portlet.RenderResponse;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletResponse;
import java.io.OutputStream;
import java.io.IOException;

/**
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 11:12:53 AM
 */
public class RenderResponseImpl extends PortletResponseImpl
    implements RenderResponse {

    private HttpServletRequest request;
    private PortletURLService service;
    private PortletWindow window;

    public RenderResponseImpl(PortletWindow window,
                              HttpServletRequest req,
                              HttpServletResponse res,
                              PortletURLService service) {
        super(res);
        this.window = window;
        this.request = req;
        this.service = service;
    }

    public PortletURL createRenderURL() {
        return service.createRenderURL(window, request);
    }

    public PortletURL createActionURL() {
        return service.createActionURL(window, request);
    }

    public String getNamespace() {
        return window.getPortletId();
    }

    public void setTitle(String title) {
        super.setProperty("org.apache.pluto.core.dynamic_title", title);
    }

    public OutputStream getPortletOutputStream()
    throws IOException {
        return getResponse().getOutputStream();
    }

// These following contentType methods must be in place
// in order to compensate for the lack of a getContentType()
// method in the 2.3 spec.  2.4 has added this method and
// as such we can remove the below once the portlet spec
// depends up 2.4.

    private String contentType;
    public void setContentType(String type) {
        super.setContentType(type);
        // we set this afterwards to make
        // sure that the response has not been
        // committed (which will cause an exception)
        this.contentType = type;
    }

    public String getContentType() {
        return contentType;
    }

}
