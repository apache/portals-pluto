/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;

/**
 * The <code>PortletRequestDispatcher</code> interface defines an object that
 * receives requests from the client and sends them to the specified resources
 * (such as a servlet, HTML file, or JSP file) on the server. The portlet
 * container creates the <code>PortletRequestDispatcher</code> object, which
 * is used as a wrapper around a server resource located at a particular path or
 * given by a particular name.
 * 
 */

public interface PortletRequestDispatcher {

    /**
     * 
     * Includes the content of a resource (servlet, JSP page, HTML file) in the
     * response. In essence, this method enables programmatic server-side
     * includes.
     * <p>
     * The included servlet cannot set or change the response status code or set
     * headers; any attempt to make a change is ignored.
     * <p>
     * This method is kept in order to provide backward compatibility with
     * version 1.0. Please use {@link #include(PortletRequest, PortletResponse)} instead
     * of this method.
     * 
     * @param request
     *            a {@link RenderRequest} object that contains the client
     *            request. Must be either the render request passed to the
     *            portlet in <code>render</code> or a wrapped version of this
     *            render request.
     * 
     * @param response
     *            a {@link RenderResponse} object that contains the render
     *            response. Must be either the render response passed to the
     *            portlet in <code>render</code> or a wrapped version of this
     *            render response.
     * 
     * @exception PortletException
     *                if the included resource throws a ServletException, or
     *                other exceptions that are not Runtime- or IOExceptions.
     * 
     * @exception java.io.IOException
     *                if the included resource throws this exception
     * 
     *  
     */

    public void include(RenderRequest request, RenderResponse response)
            throws PortletException, java.io.IOException;

    /**
     * 
     * Includes the content of a resource (servlet, JSP page, HTML file) in the
     * response. In essence, this method enables programmatic server-side
     * includes.
     * <p>
     * The included servlet cannot set or change the response status code or set
     * headers; any attempt to make a change is ignored.
     * 
     * 
     * @param request
     *            a {@link PortletRequest} object that contains the portlet
     *            request. Must be either the original request passed to the
     *            portlet or a wrapped version of this request.
     * 
     * @param response
     *            a {@link PortletResponse} object that contains the portlet
     *            response. Must be either the portlet response passed to the
     *            portlet or a wrapped version of this response.
     * 
     * @exception PortletException
     *                if the included resource throws a ServletException, or
     *                other exceptions that are not Runtime- or IOExceptions.
     * 
     * @exception java.io.IOException
     *                if the included resource throws this exception
     *                
     * @since 2.0
     */

    public void include(PortletRequest request, PortletResponse response)
            throws PortletException, java.io.IOException;

    /**
     * Forwards a portlet request from a portlet to another resource (servlet, JSP file, or HTML file) 
     * on the server. This method allows the portlet to do preliminary processing of a 
     * request and another resource to generate the response.
     * <p>
     * The <code>forward</code> method should be called before the response has been 
     * committed to the portlet container (before response body output has been flushed). 
     * If the response already has been committed, this method throws an 
     * <code>IllegalStateException</code>. Uncommitted output in the response buffer 
     * is automatically cleared before the forward.
     * <p>
     * The request and response parameters must be either the same objects as were passed to 
     * the calling portlet or be wrapped versions of these.
     * 
     * @param request  a request object that represents the request to the 
     *                 portlet
     * @param response a reponse object that contains the portlet response
     *  
     * @exception PortletException
     *                if the included resource throws a ServletException, or
     *                other exceptions that are not Runtime- or IOExceptions.
     * @exception java.io.IOException
     *                if the included resource throws this exception
     * @exception java.lang.IllegalStateException
     *                if the response was already committed
     * @since 2.0
     */
    public void forward(PortletRequest request, PortletResponse response)
    throws PortletException, java.io.IOException;

    

}
