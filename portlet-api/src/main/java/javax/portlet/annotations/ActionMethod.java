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

package javax.portlet.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


/**
 * <div class='changed_added_3_0'>
 * Designates a method corresponding to the portlet API processAction method.
 * The annotated method must have the following signature:
 * <p>
 *    <code>public void &lt;methodName&gt;(ActionRequest, ActionResponse)</code>
 * <p>   
 * where the method name can be freely selected.
 * <p>
 * The method declaration may contain a throws clause. Exceptions declared in the 
 * throws clause should be of type {@link javax.portlet.PortletException} or
 * {@link java.io.IOException}. 
 * Checked exceptions of any other type will be caught, wrapped with a PortletException, 
 * and rethrown.
 * </div>
 *    
 * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse) processAction
 *
 * @since 3.0
 */

@Retention(RUNTIME) @Target({METHOD})
public @interface ActionMethod {
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet name for the annotated method.
    * </div>
    * 
    * @return  The portlet name
    */
   String   portletName();
   
   /**
    * <div class='changed_added_3_0'>
    * The action name. 
    * <p> 
    * If an action name is specified, the bean enabler will dispatch Action requests with 
    * matching values of the reserved "javax.portlet.action" parameter to this method. 
    * <p>
    * An ActionMethod with an empty action name will receive all  
    * Action requests not dispatched to other named ActionMethods.
    * </div>
    * 
    * @return  The action name
    */
   String   actionName() default "";
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The QName definitions of the events published by this method.
    * </div>
    * 
    * @see     EventDefinition
    * @see     PortletQName
    * 
    * @return  The processing event QNames
    */
   PortletQName[]   publishingEvents() default {};
}
