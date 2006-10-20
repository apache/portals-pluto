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
package javax.portlet;



/**
 * The <code>PortletRequestDispatcher</code> interface 
 * defines an object that receives requests from the client
 * and sends them to the specified resources (such as a servlet,
 * HTML file, or JSP file) on the server. The portlet
 * container creates the <code>PortletRequestDispatcher</code> object,
 * which is used as a wrapper around a server resource located
 * at a particular path or given by a particular name.
 *
 */
 
public interface PortletRequestDispatcher {

    /**
     *
     * Includes the content of a resource (servlet, JSP page,
     * HTML file) in the response. In essence, this method enables 
     * programmatic server-side includes.
     * <p>
     * The included servlet cannot set or change the response status code
     * or set headers; any attempt to make a change is ignored.
     *
     *
     * @param request 			a {@link RenderRequest} object 
     *					that contains the client request. Must be either
     *                  the render request passed to the portlet in <code>render</code>
     *                  or a wrapped version of this render request.
     *
     * @param response 			a {@link RenderResponse} object 
     * 					that contains the render response. Must be either
     *                  the render response passed to the portlet in <code>render</code>
     *                  or a wrapped version of this render response.
     *
     * @exception PortletException 	if the included resource throws a ServletException, 
     *                                  or other exceptions that are not Runtime-
     *                                  or IOExceptions.
     *
     * @exception java.io.IOException	if the included resource throws this exception
     *
     *
     */
     
    public void include(RenderRequest request, RenderResponse response)
	throws PortletException, java.io.IOException;


    /**
    *
    * Includes the content of a resource (servlet, JSP page,
    * HTML file) in the response. In essence, this method enables 
    * programmatic server-side includes.
    * <p>
    * The included servlet can set or change the response status code
    * or set headers.
    *
    *
    * @param request            a {@link RenderRequest} object 
    *                   that contains the client request. Must be either
     *                  the resource request passed to the portlet in <code>serveResource</code>
     *                  or a wrapped version of this resource request.
    *
    * @param response           a {@link RenderResponse} object 
    *                   that contains the render response. Must be either
     *                  the resource response passed to the portlet in <code>serveResource</code>
     *                  or a wrapped version of this resource response.
    *
    * @exception PortletException   if the included resource throws a ServletException, 
    *                                  or other exceptions that are not Runtime-
    *                                  or IOExceptions.
    *
    * @exception java.io.IOException    if the included resource throws this exception
    *
    *
    */
    
   public void include(ResourceRequest request, RenderResponse response)
    throws PortletException, java.io.IOException;


}








