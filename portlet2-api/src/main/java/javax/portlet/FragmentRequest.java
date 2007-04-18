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
/*
 * Copyright 2006 IBM Corporation.
 *
 */
package javax.portlet;

/**
 * The <code>FragmentRequest</code> interface represents the request
 * send to the portlet for serving fragment calls made asynchronously.
 * <p>
 * It extends the ClientHttpRequest interface and provides the fragment request
 * information to portlets.
 * <p>
 * The portlet container creates an <CODE>FragmentRequest</CODE> object and
 * passes it as argument to the portlet's <CODE>serveFragment</CODE> method.
 * <p>
 * The <code>FragmentRequest</code> is provided with the current portlet mode, window state, 
 * and render parameters that the portlet can access via the 
 * <code>getPortletMode</code> and, 
 * <code>getWindowState</code>, or one of the <code>getParameter</code> methods.
 * <p>   
 * If a parameter is set that has the same name as a render parameter that this 
 * fragment URL contains, the render parameter must be the last entry in the 
 * parameter value array. 
 * 
 * @see ClientHttpRequest
 * @see FragmentServingPortlet
 * @since 2.0
 */

public interface FragmentRequest extends ClientHttpRequest {
}
