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
 * <div class="changed_added_3_0">
 * Action parameters are additional portlet parameters added to the portlet
 * URL or provided by the client that extend the state information provided by 
 * the render parameters.
 * The client can supply additional action parameters when a form is submitted, for example.
 * <p>
 * The <code>MutableActionParameters</code> interface provides methods for modifying
 * the action parameters attached to a portlet action URL. 
 * <p>
 * If the <code>MutableActionParameters</code> object was retrieved from 
 * a URL, changes made will be applied to the URL. 
 * The modified parameters will be available during requests
 * triggered by the URL.
 * <p>
 * {@link RenderState} provides a description of the render state.
 * {@link PortletParameters} provides a description of the parameter concept.
 * </div>
 * @see     RenderState
 * @see     PortletParameters
 * @see     ActionParameters
 * @see     ActionRequest
 * @see     ActionURL
 * @since   3.0
 */
public interface MutableActionParameters extends MutablePortletParameters, ActionParameters
{

}
