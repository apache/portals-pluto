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


import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.NormalScope;
import javax.portlet.PortletSession;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


/**
 * <div class='changed_added_3_0'>
 * Provides a CDI custom scope that is scoped to the portlet session rather than to the
 * servlet session.
 * <p>
 * Note that a portlet session scoped bean must implement 
 * <code>java.io.Serializable</code>, since it will be stored in the portlet session.
 * </div>
 * 
 * @since 3.0
 */

@Retention(RUNTIME) 
@Target({TYPE})
@NormalScope(passivating=true)
@Inherited
@Documented
public @interface PortletSessionScoped {
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet scope into which the annotated bean is to be placed. Can be set to 
    * the following values:
    * <ul>
    * <li>
    * PortletSession.PORTLET_SCOPE - scopes the bean to the portlet session
    * </li>
    * <li>
    * PortletSession.APPLICATION_SCOPE - Scopes the bean to the portlet application session.
    * The effect of this scope is the same as using the CDI @SessionScoped annotation.
    * </li>
    * </ul>
    * </div>
    * 
    * @return The portlet scope
    * 
    * @see  PortletSession#PORTLET_SCOPE
    * @see  PortletSession#APPLICATION_SCOPE
    */
   int value() default PortletSession.PORTLET_SCOPE;
}
