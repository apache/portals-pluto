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

import org.apache.pluto.PortletContainer;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.PortletEntity;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.services.PortalCallbackService;
import org.apache.pluto.util.NamespaceMapper;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.util.StringUtils;
import org.apache.pluto.util.impl.NamespaceMapperImpl;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class RenderResponseImpl extends PortletResponseImpl
    implements RenderResponse {
    
    private static final StringManager EXCEPTIONS =
            StringManager.getManager(RenderResponseImpl.class.getPackage().getName());

    /**
     * The current content type.
     * @todo This should be made dynamic
     */
    private String currentContentType = null;

    private NamespaceMapper mapper = new NamespaceMapperImpl();

    public RenderResponseImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              javax.servlet.http.HttpServletRequest servletRequest,
                              javax.servlet.http.HttpServletResponse servletResponse) {
        super(container, internalPortletWindow, servletRequest,
              servletResponse);
    }

    public String getContentType() {
        // in servlet 2.4 we could simply use this:
        // return this.getHttpServletResponse().getContentType();
        return currentContentType;
    }

    public PortletURL createRenderURL() {
        return createURL(false);
    }

    public PortletURL createActionURL() {
        return createURL(true);
    }

    public String getNamespace() {
         String namespace =
            mapper.encode(getInternalPortletWindow().getId(), "");

         StringBuffer validNamespace = new StringBuffer();
         for (int i = 0; i < namespace.length(); i++) {
         	char ch = namespace.charAt(i);
         	if (Character.isJavaIdentifierPart(ch)) {
         		validNamespace.append(ch);
         	} else {
         		validNamespace.append('_');
         	}
         }

         return validNamespace.toString();
    }

    public void setTitle(String title) {
        PortalCallbackService callback =
            container.getContainerServices().getPortalCallbackService();

        callback.setTitle(this.getHttpServletRequest(),
                          getInternalPortletWindow(),
                          title);
    }

    public void setContentType(String type) {
        String mimeType = StringUtils.stringCharacterEncoding(type);
        if (!isValidContentType(mimeType)) {
            throw new IllegalArgumentException(mimeType);
        }
        this.getHttpServletResponse().setContentType(mimeType);
        currentContentType = mimeType;
    }

    public String getCharacterEncoding() {
        return this.getHttpServletResponse().getCharacterEncoding();
    }

    /**
     * @todo is it appropriate to throw an illegal state if content type is not set.  how do we set automatically
     */ 
    public PrintWriter getWriter() throws IOException, IllegalStateException {
        if (currentContentType == null) {
            String msg = EXCEPTIONS.getString("error.contenttype.null");
            //throw new java.lang.IllegalStateException(msg);
        }

        return super.getWriter();
    }

    public java.util.Locale getLocale() {
        return this.getHttpServletRequest().getLocale();
    }

    //@todo port 1.0.1 setBufferSize fix to 1.1
    public void setBufferSize(int size) {
        throw new IllegalStateException(
            "portlet container does not support buffering");
    }

    public int getBufferSize() {
        //return this.getHttpServletResponse().getBufferSize();
        return 0;
    }

    public void flushBuffer() throws java.io.IOException {
        this.getHttpServletResponse().flushBuffer();
    }

    public void resetBuffer() {
        this.getHttpServletResponse().resetBuffer();
    }

    public boolean isCommitted() {
        return this.getHttpServletResponse().isCommitted();
    }

    public void reset() {
        this.getHttpServletResponse().reset();
    }

    /**
     * @todo is it appropriate to throw an illegal state if content type is not set.  how do we set automatically
     * @return
     * @throws java.io.IOException
     * @throws java.lang.IllegalStateException
     */
    public OutputStream getPortletOutputStream() throws java.io.IOException,
                                                        java.lang.IllegalStateException {
        if (currentContentType == null) {
            String msg = EXCEPTIONS.getString("error.contenttype.null");
            //throw new java.lang.IllegalStateException(msg);
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
                                  getHttpServletResponse(),
                                  isAction);

    }

    private boolean isValidContentType(String type)
    {
        type = StringUtils.stringCharacterEncoding(type);
        PortletEntity entity =  getInternalPortletWindow().getPortletEntity();
        PortletDD def = entity.getPortletDefinition();
        List contentTypes = def.getSupports();
        Iterator it = contentTypes.iterator();
        while(it.hasNext()) {
            SupportsDD ct = (SupportsDD)it.next();
            String supportedType = ct.getMimeType();
            if (supportedType.equals(type)) {
                return true;
            } else if (supportedType.indexOf("*") >= 0) {
                // the supported type contains a wildcard
                int index = supportedType.indexOf("/");
                String supportedPrefix = supportedType.substring(0, index);
                String supportedSuffix = supportedType.substring(index + 1, supportedType.length());

                index = type.indexOf("/");
                String typePrefix = type.substring(0, index);
                String typeSuffix = type.substring(index + 1, type.length());

                if (supportedPrefix.equals("*") || supportedPrefix.equals(typePrefix)) {
                    // the prefixes match
                    if (supportedSuffix.equals("*") || supportedSuffix.equals(typeSuffix)) {
                        // the suffixes match
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
