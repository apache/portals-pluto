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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.portlet.PortletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.core.InternalPortletResponse;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.services.PortletContainerServices;
import org.apache.pluto.services.ResourceURLProvider;
import org.apache.pluto.util.PrintWriterServletOutputStream;

public abstract class PortletResponseImpl
    extends javax.servlet.http.HttpServletResponseWrapper
    implements InternalPortletResponse, PortletResponse {

    PortletContainer container;

    InternalPortletWindow internalPortletWindow;

    /**
     * this variable holds the servlet request of the target/portlet's web
     * module
     */
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;

    private boolean usingWriter;
    private boolean usingStream;

    private ServletOutputStream wrappedWriter;

    /**
     * true if we are in an include call
     */
    private boolean included;

    public PortletResponseImpl(PortletContainer container,
                               InternalPortletWindow internalPortletWindow,
                               HttpServletRequest servletRequest,
                               HttpServletResponse servletResponse) {
        super(servletResponse);
        this.container = container;
        this.httpServletRequest = servletRequest;
        this.httpServletResponse = servletResponse;
        this.internalPortletWindow = internalPortletWindow;
    }

    // javax.portlet.PortletResponse --------------------------------------------------------------
    public void addProperty(String key, String value) {
        if (key == null) {
            throw new IllegalArgumentException("Property key == null");
        }

        container.getContainerServices()
           .getPortalCallbackService()
           .addResponseProperty(
               getHttpServletRequest(), internalPortletWindow, key, value
        );
    }

    public void setProperty(String key, String value) {
        if (key == null) {
            throw new IllegalArgumentException("Property key == null");
        }

        container.getContainerServices()
                .getPortalCallbackService()
                .setResponseProperty(
                        getHttpServletRequest(), internalPortletWindow, key, value
                );
    }

    public String encodeURL(String path) {
        if (path.indexOf("://") == -1 && !path.startsWith("/")) {
            throw new IllegalArgumentException(
                "only absolute URLs or full path URIs are allowed");
        }

        PortletContainerServices services = getContainer()
            .getContainerServices();
        ResourceURLProvider provider =
            services.getPortalCallbackService()
        .getResourceURLProvider(httpServletRequest,internalPortletWindow);
        if (path.indexOf("://") != -1) {
            provider.setAbsoluteURL(path);
        } else {
            provider.setFullPath(path);
        }
        return getHttpServletResponse().encodeURL(provider.toString());
    }
    // --------------------------------------------------------------------------------------------

    // org.apache.pluto.core.InternalPortletResponse implementation -------------------------------
    public void lateInit(
        javax.servlet.http.HttpServletRequest webModuleServletRequest,
        javax.servlet.http.HttpServletResponse webModuleServletResponse) {
        this.httpServletRequest = webModuleServletRequest;
        this.setResponse(webModuleServletResponse);
    }
    // --------------------------------------------------------------------------------------------

    // internal methods ---------------------------------------------------------------------------
    public HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    protected HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    // additional methods -------------------------------------------------------------------------
    // servlet-only implementation 
    // (inherited from HttpServletResponseWrapper)
    public void addCookie(javax.servlet.http.Cookie cookie) {
        getHttpServletResponse().addCookie(cookie);
    }

    public boolean containsHeader(String name) {
        return getHttpServletResponse().containsHeader(name);
    }

    public String encodeRedirectUrl(String url) {
        return included
               ? null : getHttpServletResponse().encodeRedirectURL(url);
    }

    public String encodeRedirectURL(String url) {
        return included
               ? null : getHttpServletResponse().encodeRedirectURL(url);
    }

    public void sendRedirect(String location) throws java.io.IOException {
        getHttpServletResponse().sendRedirect(location);
    }

    public void setDateHeader(String name, long date) {
        getHttpServletResponse().setDateHeader(name, date);
    }

    public void sendError(int sc, String msg) throws java.io.IOException {
        getHttpServletResponse().sendError(sc, msg);
    }

    public void sendError(int sc) throws java.io.IOException {
        getHttpServletResponse().sendError(sc);
    }

    public void addHeader(String name, String value) {
        getHttpServletResponse().addHeader(name, value);
    }

    public void setIntHeader(String name, int value) {
        getHttpServletResponse().setIntHeader(name, value);
    }

    public void addDateHeader(String name, long date) {
        getHttpServletResponse().addDateHeader(name, date);
    }

    public void setHeader(String name, String value) {
        getHttpServletResponse().setHeader(name, value);
    }

    public void setStatus(int sc) {
        getHttpServletResponse().setStatus(sc);
    }

    public void setStatus(int sc, String sm) {
        getHttpServletResponse().setStatus(sc, sm);
    }

    public void addIntHeader(String name, int value) {
        getHttpServletResponse().addIntHeader(name, value);
    }

    public void setContentLength(int len) {
        getHttpServletResponse().setContentLength(len);
    }

    public String encodeUrl(String url) {
        return this.encodeURL(url);
    }

    public void setLocale(java.util.Locale loc) {
        getHttpServletResponse().setLocale(loc);
    }

    public ServletOutputStream getOutputStream() throws IllegalStateException,
                                                        IOException {
        if (usingWriter) {
            throw new IllegalStateException(
                "getPortletOutputStream can't be used after getWriter was invoked");
        }

        if (wrappedWriter == null) {
            wrappedWriter =
            new PrintWriterServletOutputStream(
                getHttpServletResponse().getWriter());
        }

        usingStream = true;

        return wrappedWriter;
    }

    public PrintWriter getWriter() throws UnsupportedEncodingException,
                                          IllegalStateException, IOException {
        if (usingStream) {
            throw new IllegalStateException(
                "getWriter can't be used after getOutputStream was invoked");
        }

        usingWriter = true;

        return getHttpServletResponse().getWriter();
    }

    // other
    public InternalPortletWindow getInternalPortletWindow() {
        return internalPortletWindow;
    }
    
    // internal
    
    HttpServletRequest getHttpDServletRequest() {
        return httpServletRequest;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public boolean isIncluded() {
        return included;
    }

    public PortletContainer getContainer() {
        return container;
    }

}
