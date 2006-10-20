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
import java.util.Map;

import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

/**
 * The <code>ActionResponseWrapper</code> provides a convenient 
 * implementation of the <code>ActionResponse</code> interface 
 * that can be subclassed by developers wishing to adapt the response.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see ActionResponse
 */
public class ActionResponseWrapper implements ActionResponse {

   ActionResponse response;
    
    /** 
     * Require having a response for constructing
     * the wrapper.
     *
     */
    private ActionResponseWrapper() {
    }
    
    /**
     * Creates an <code>ActionResponse</code> adaptor 
     * wrapping the given response object.
     * 
     * @param response  the action response to wrap
     * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
     */
    public ActionResponseWrapper(ActionResponse response) {
        this.response = response;
    }

    /**
     * The default behavior of this method is to call 
     * <code>sendRedirect(location)</code> on the wrapped response object.
     */
    public void sendRedirect(String location) throws IOException {
        response.sendRedirect(location);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setEvent(name, value)</code> on the wrapped response object.
     */
    public void setEvent(String name, Object value) {
        response.setEvent(name, value);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setEvents(events)</code> on the wrapped response object.
     */
    public void setEvents(Map events) {
        response.setEvents(events);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setPortletMode(portletMode)</code> on the wrapped response object.
     */
    public void setPortletMode(PortletMode portletMode)
            throws PortletModeException {
        response.setPortletMode(portletMode);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setRenderParameter(key, value)</code> on the wrapped response object.
     */
    public void setRenderParameter(String key, String value) {
        response.setRenderParameter(key, value);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setRenderParameter(key, value)</code> on the wrapped response object.
     */
    public void setRenderParameter(String key, String[] values) {
        response.setRenderParameter(key, values);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setRenderParameters(parameters)</code> on the wrapped response object.
     */
    public void setRenderParameters(Map parameters) {
        response.setRenderParameters(parameters);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setWindowState(windowState)</code> on the wrapped response object.
     */
    public void setWindowState(WindowState windowState)
            throws WindowStateException {
        response.setWindowState(windowState);
    }

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
     * Return the wrapped response object.
     * 
     * @return the wrapped response
     */
    public ActionResponse getResponse() {
        return response;
    }

    /**
     * Sets the response object being wrapped.
     * 
     * @param response the response to set
     * @throws java.lang.IllegalArgumentException   if the response is null.
     */
    public void setResponse(ActionResponse response) {
        this.response = response;
    }

}
