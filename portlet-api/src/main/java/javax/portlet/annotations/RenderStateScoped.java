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


import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.NormalScope;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


/**
 * <div class='changed_added_3_0'>
 * Provides a CDI custom scope that is scoped to the render state. 
 * The purpose of this scope is to allow portlet render parameters to be handled like
 * beans.
 * <p>
 * If an <code>{@literal @}RenderStateScoped</code> bean is injected into a class containing 
 * an <code>{@literal @}EventMethod</code> or an <code>{@literal @}ActionMethod</code>,
 * the bean is associated with the corresponding portlet.
 * The bean state is stored as a render parameter of the that portlet.
 * <p>
 * A bean annotated with this scope must implement the {@link PortletSerializable} 
 * interface,
 * which provides methods used by the portlet bean container to synchronize the bean
 * according to the render state.
 * <p>
 * An <code>{@literal @}RenderStateScoped</code> bean is similar to an 
 * <code>{@literal @}RequestScoped</code> bean in that a new instance is created at the
 * beginning of each request.
 * However, for <code>{@literal @}RenderStateScopedScoped</code> beans, the portlet bean
 * container calls the 
 * {@link PortletSerializable#deserialize(String[]) PortletSerializable#deserialize}
 * method at the beginning of each request to initialize the bean and the  
 * {@link PortletSerializable#serialize() PortletSerializable#serialize} method
 * at the end of an action request or event request to obtain the serialized bean data.
 * <p>
 * A <code>{@literal @}RenderStateScoped</code> bean must be a valid bean and
 * must provide a default constructor.
 * <p>
 * Note that only changes made to the bean state during <code>ActionMethod</code>
 * or <code>EventMethod</code> execution are stored in the render state.
 * Changes made during <code>RenderMethod</code>, <code>ServeResourceMethod</code>,
 * or <code>HeaderMethod</code> execution will not be available during subsequent requests.
 * </div>
 *
 * @see PortletSerializable
 * 
 * @since 3.0
 */

@Retention(RUNTIME) 
@Target({TYPE})
@NormalScope()
@Inherited
public @interface RenderStateScoped {
   
   /**
    * <div class='changed_added_3_0'>
    * The name of the render parameter under which the bean state is to be stored.
    * <p>
    * If the name is not specified through the annotation, the portlet container
    * will assign a render parameter name.
    * <p>
    * If this element is a public render parameter identifier as declared in the 
    * portlet application configuration,
    * the render parameter represented by the annotated class will be treated as 
    * a public render parameter.
    * </div>
    * 
    * @return  The parameter name
    */
   String   paramName() default "";
}
