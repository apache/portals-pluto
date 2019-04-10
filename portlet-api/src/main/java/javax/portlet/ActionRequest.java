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
 * <span class="changed_modified_3_0">The</span> 
 * <CODE>ActionRequest</CODE> represents the request sent to the portlet
 * to handle an action.<br>
 * It extends the ClientDataRequest interface and provides action request
 * information to portlets.
 * <p>
 * The portlet container creates an <CODE>ActionRequest</CODE> object and
 * passes it as argument to the portlet's <CODE>processAction</CODE> method.
 * 
 * @see ClientDataRequest
 */
public interface ActionRequest extends ClientDataRequest
{
   /**
    * Predefined action name for usage with the
    * <code>@ProcessAction</code> annotation.
    * 
    * @since 2.0
    */
   public static final String ACTION_NAME = "javax.portlet.action";


   /**
    * <div class="changed_added_3_0">
    * Gets the action parameters set for this request.
    * <p>
    * Action parameters are additional portlet parameters added to the 
    * URL triggering the request that extend the state information provided by 
    * the render parameters.
    * <p>
    * Action parameters can also contain information provided by the client,
    * for example, form parameters provided when a form is submitted. 
    * <p>
    * {@link PortletParameters} provides a description of the parameter concept.
    * </div>
    * 
    * @return   an immutable object representing
    *           the action parameters
    * @since    3.0
    * @see      ActionParameters 
    * @see      MutableActionParameters 
    * @see      ActionURL 
    */

   public ActionParameters getActionParameters();

}
