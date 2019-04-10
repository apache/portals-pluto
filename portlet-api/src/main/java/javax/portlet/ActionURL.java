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
 * An action URL is created with {@link MimeResponse#createActionURL()}. 
 * An action URL is used to trigger an action request.
 * </div>
 * @since   3.0
 */
public interface ActionURL extends PortletURL
{


   /**
    * <div class="changed_added_3_0">
    * Gets the action parameter values set for this URL.
    * <p>
    * Action parameters are additional portlet parameters added to the 
    * URL that extend the state information provided by 
    * the render parameters.
    * <p>
    * Initially the returned object is empty. 
    * <p>
    * Modifying the parameter values encapsulated by the returned object directly
    * modifies the action parameters applied to the URL.
    * <p>
    * {@link PortletParameters} provides a description of the parameter concept.
    * </div>
    * 
    * @return   a <code>MutableActionParameters</code> object representing
    *           the action parameters.
    * @see      ActionParameters 
    * @see      MutableActionParameters 
    */

   public MutableActionParameters getActionParameters();
}
