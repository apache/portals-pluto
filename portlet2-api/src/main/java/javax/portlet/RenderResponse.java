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
 * NOTE: this source code is based on an early draft version of JSR 286 and not intended for product
 * implementations. This file may change or vanish in the final version of the JSR 286 specification.
 */
/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */
/**
 * Copyright 2006 IBM Corporation.
 */

package javax.portlet;

/**
 * The <CODE>RenderResponse</CODE> defines an object to assist a portlet in
 * sending a response to the portal. It extends the <CODE>MimeResponse</CODE>
 * interface to provide specific render response functionality to portlets.<br>
 * The portlet container creates a <CODE>RenderResponse</CODE> object and
 * passes it as argument to the portlet's <CODE>render</CODE> method.
 * 
 * @see RenderRequest
 * @see PortletResponse
 * @see MimeResponse
 */
public interface RenderResponse extends MimeResponse {

    /**
     * This method sets the title of the portlet.
     * <p>
     * The value can be a text String
     * 
     * @param title
     *            portlet title as text String or resource URI
     */
    public void setTitle(String title);


    
    
	/**
     * This method allows the portlet to tell the portal the next possible
     * portlet modes that the make sense from the portlet point of view.
     * <p>
     * If set, the portal should honor these enumeration of portlet modes and
     * only provide the end user with choices to the provided portlet modes or a
     * subset of these modes based on access control considerations.
     * <p>
     * If the portlet does not set any next possible portlet modes the default
     * is that all portlet modes that the portlet has defined supporting in the
     * portlet deployment descriptor are meaningful new portlet modes.
     * 
     * @param portletModes
     *            <code>Enumeration</code> of <code>PortletMode</code> objects with the
     *            next possible portlet modes that the make sense from the
     *            portlet point of view, must not be <code>null</code> or an
     *            empty enumeration.
     * @since 2.0
     */
	public void setNextPossiblePortletModes(java.util.Enumeration<PortletMode> portletModes);

}
