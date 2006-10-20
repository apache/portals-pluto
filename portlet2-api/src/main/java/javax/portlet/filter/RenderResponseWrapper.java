/*
 * Copyright 2006 The Apache Software Foundation
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
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/*
 * Copyright 2006 IBM Corporation.
 */
package javax.portlet.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

/**
 * The <code>RenderResponseWrapper</code> provides a convenient 
 * implementation of the <code>RenderResponse</code> interface 
 * that can be subclassed by developers wishing to adapt the response.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see RenderResponse
 */

public class RenderResponseWrapper implements RenderResponse {

    RenderResponse response;
    
    /** 
     * Require having a response for constructing
     * the wrapper.
     *
     */
    private RenderResponseWrapper() {
    }
    
    /**
     * Creates an <code>RenderResponse</code> adaptor 
     * wrapping the given response object.
     * 
     * @param response  the event response to wrap
     * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
     */
    public RenderResponseWrapper(RenderResponse response) {
        this.response = response;
    }

    /**
     * The default behavior of this method is to call 
     * <code>setEvent(name, value)</code> on the wrapped response object.
     */
     /**
     * The default behavior of this method is to call 
     * <code>addProperty(key, value)</code> on the wrapped response object.
     */
    public void addProperty(String key, String value) {
        response.addProperty(key, value);
    }

    /**
     * The default behavior of this method is to call 
     * <code>addProperty(key, value, scope)</code> on the wrapped response object.
     */
    public void addProperty(String key, String value, int scope) {
        response.addProperty(key, value, scope);
    }

    /**
     * The default behavior of this method is to call 
     * <code>createActionURL()</code> on the wrapped response object.
     */
    public PortletURL createActionURL() {
        return response.createActionURL();
    }

    /**
     * The default behavior of this method is to call 
     * <code>createRenderURL()</code> on the wrapped response object.
     */
    public PortletURL createRenderURL() {
        return response.createRenderURL();
    }

    /**
     * The default behavior of this method is to call 
     * <code>createResourceURL</code> on the wrapped response object.
     */
    public ResourceURL createResourceURL() {
        return response.createResourceURL();
    }

    /**
     * The default behavior of this method is to call 
     * <code>encodeURL(path)</code> on the wrapped response object.
     */
    public String encodeURL(String path) {
        return response.encodeURL(path);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getNamespace()</code> on the wrapped response object.
     */
    public String getNamespace() {
        return response.getNamespace();
    }

    /**
     * The default behavior of this method is to call 
     * <code>setProperty(key, value)</code> on the wrapped response object.
     */
    public void setProperty(String key, String value) {
        response.setProperty(key, value);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setProperty(key, value, scope)</code> on the wrapped response object.
     */
    public void setProperty(String key, String value, int scope) {
        response.setProperty(key, value, scope);
    }

    /**
     * The default behavior of this method is to call 
     * <code>flushBuffer()</code> on the wrapped response object.
     */ 
    public void flushBuffer() throws IOException {
        response.flushBuffer();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getBufferSize()</code> on the wrapped response object.
     */
    public int getBufferSize() {
        return response.getBufferSize();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getCharacterEncoding()</code> on the wrapped response object.
     */
    public String getCharacterEncoding() {
        return response.getCharacterEncoding();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getContentType()</code> on the wrapped response object.
     */
    public String getContentType() {
        return response.getContentType();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getLocale()</code> on the wrapped response object.
     */
    public Locale getLocale() {
        return response.getLocale();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPortletOutputStream()</code> on the wrapped response object.
     */
    public OutputStream getPortletOutputStream() throws IOException {
        return response.getPortletOutputStream();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getWriter()</code> on the wrapped response object.
     */
    public PrintWriter getWriter() throws IOException {
        return response.getWriter();
    }

    /**
     * The default behavior of this method is to call 
     * <code>isCommitted()</code> on the wrapped response object.
     */
    public boolean isCommitted() {
        return response.isCommitted();
    }

    /**
     * The default behavior of this method is to call 
     * <code>reset()</code> on the wrapped response object.
     */
    public void reset() {
        response.reset();
    }

    /**
     * The default behavior of this method is to call 
     * <code>resetBuffer()</code> on the wrapped response object.
     */
    public void resetBuffer() {
        response.resetBuffer();
    }

    /**
     * The default behavior of this method is to call 
     * <code>setBufferSize(size)</code> on the wrapped response object.
     */
    public void setBufferSize(int size) {
        response.setBufferSize(size);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setContentType(type)</code> on the wrapped response object.
     */
    public void setContentType(String type) {
        response.setContentType(type);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setTitle(title)</code> on the wrapped response object.
     */
    public void setTitle(String title) {
        response.setTitle(title);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getCacheControl()</code> on the wrapped response object.
     */
    public CacheControl getCacheControl() {
        return response.getCacheControl();
    }



}
