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

package org.apache.pluto.core.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.SupportedMimeTypeDD;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.PortletEntity;
import org.apache.pluto.services.PortalCallbackProvider;
import org.apache.pluto.util.NamespaceMapper;
import org.apache.pluto.util.impl.NamespaceMapperImpl;

public class RenderResponseImpl extends PortletResponseImpl
    implements RenderResponse {
    private static final String illegalStateExceptionText = "No content type set.";

    private String currentContentType = null;   // needed as servlet 2.3 does not have a response.getContentType

    private NamespaceMapper mapper = new NamespaceMapperImpl();

    public RenderResponseImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              javax.servlet.http.HttpServletRequest servletRequest,
                              javax.servlet.http.HttpServletResponse servletResponse) {
        super(container, internalPortletWindow, servletRequest,
              servletResponse);
    }

    // javax.portlet.RenderResponse ---------------------------------------------------------------
    public String getContentType() {
        // in servlet 2.4 we could simply use this:
        // return this._getHttpServletResponse().getContentType();
        return currentContentType;
    }

    public PortletURL createRenderURL() {
        PortletURL url = createURL(false);
        return url;
    }

    public PortletURL createActionURL() {
        PortletURL url = createURL(true);
        return url;
    }

    public String getNamespace() {
        return mapper.encode(getInternalPortletWindow().getId(), "");
    }

    public void setTitle(String title) {
        PortalCallbackProvider callback =
            container.getContainerServices().getPortalCallbackProvider();

        callback.setTitle(this.getHttpServletRequest(),
                          getInternalPortletWindow(),
                          title);
    }

    public void setContentType(String type) {
        String mimeType = stripCharacterEncoding(type);
        if (!isValidContentType(mimeType)) {
            throw new IllegalArgumentException(mimeType);
        }
        this._getHttpServletResponse().setContentType(mimeType);
        currentContentType = mimeType;
    }

    public String getCharacterEncoding() {
        return this._getHttpServletResponse().getCharacterEncoding();
    }

    public PrintWriter getWriter() throws IOException, IllegalStateException {
        if (currentContentType == null) {
            throw new java.lang.IllegalStateException(
                illegalStateExceptionText);
        }

        return super.getWriter();
    }

    public java.util.Locale getLocale() {
        return this.getHttpServletRequest().getLocale();
    }

    public void setBufferSize(int size) {
        throw new IllegalStateException(
            "portlet container does not support buffering");
    }

    public int getBufferSize() {
        //return this._getHttpServletResponse().getBufferSize();
        return 0;
    }

    public void flushBuffer() throws java.io.IOException {
        this._getHttpServletResponse().flushBuffer();
    }

    public void resetBuffer() {
        this._getHttpServletResponse().resetBuffer();
    }

    public boolean isCommitted() {
        return this._getHttpServletResponse().isCommitted();
    }

    public void reset() {
        this._getHttpServletResponse().reset();
    }

    public OutputStream getPortletOutputStream() throws java.io.IOException,
                                                        java.lang.IllegalStateException {
        if (currentContentType == null) {
            throw new java.lang.IllegalStateException(
                illegalStateExceptionText);
        }
        return getOutputStream();
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    /**
     * @param isAction
     * @return
     * @todo make dynamic? as service?
     */
    private PortletURL createURL(boolean isAction) {
        return new PortletURLImpl(container,
                                  getInternalPortletWindow(),
                                  getHttpServletRequest(),
                                  _getHttpServletResponse(),
                                  isAction);

    }

    private boolean isValidContentType(String type) {
        type = stripCharacterEncoding(type);
        String wildcard = null;
        int index = type.indexOf("/");
        if (index > -1) {
            wildcard = type.substring(0, index);
        }

        PortletEntity entity = internalPortletWindow.getPortletEntity();
        PortletDD def = entity.getPortletDefinition();
        SupportedMimeTypeDD[] mimes = def.getSupportedMimeTypes();
        for (int i = 0; i < mimes.length; i++) {
            String mt = mimes[i].getMimeType();
            if (mt.equals(type)) {
                return true;
            } else if (mt.startsWith(wildcard)) {
                return true;
            }
        }
        return false;
    }

    private String stripCharacterEncoding(String type) {
        int xs = type.indexOf(';');
        String strippedType;
        if (xs == -1) {
            strippedType = type;
        } else {
            strippedType = type.substring(0, xs);
        }
        return strippedType.trim();
    }
    // --------------------------------------------------------------------------------------------
}
