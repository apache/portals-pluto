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
 * The <CODE>EventResponse</CODE> interface represents the portlet
 * response to an event request.
 * It extends the <CODE>StateAwareResponse</CODE> interface.<br>
 * The portlet container creates an <CODE>EventResponse</CODE> object and 
 * passes it as argument to the portlet's <CODE>processEvent</CODE> method.
 * 
 * @see StateAwareResponse 
 * @see PortletResponse
 * @since 2.0
 */
public interface EventResponse extends StateAwareResponse {

    /**
     * Maintain the current render parameters of the request for
     * the response.
     * <p>
     * All previously set render parameters are cleared.
     * <p>
     * These parameters will be accessible in all
     * subsequent render calls via the
     * <code>PortletRequest.getParameter</code> call until
     * a new request is targeted to the portlet.
     * <p>
     * The given parameters do not need to be encoded
     * prior to calling this method.
     *
     * @param  request   The request the portlet has been provided
     *                   with by the portlet container for the current
     *                   <code>processEvent</code> call, must not be 
     *                   <code>null</code>.
     */
    public void setRenderParameters(EventRequest request);

}
