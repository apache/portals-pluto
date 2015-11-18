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
 * Designates a conditional dispatcher method.
 * The portlet container will invoke the annotated method when it determines 
 * that <code>@RenderMethod</code>, <code>@HeaderMethod</code>, or 
 * <code>@ServeResourceMethod</code> annotated methods
 * are available for dispatching during request processing.
 * <p>
 * The annotated method must have one of the following signatures:
 * <p>
 *    <code>public boolean &lt;methodName&gt;(RenderRequest request, RenderResponse response, 
 *                Set<MethodToken> methods)</code>
 * <p>   
 *    <code>public boolean &lt;methodName&gt;(HeaderRequest request, HeaderResponse response, 
 *                Set<MethodToken> methods)</code>
 * <p>   
 *    <code>public boolean &lt;methodName&gt;(ResourceRequest request, ResourceResponse response, 
 *                Set<MethodToken> methods)</code>
 * <p>   
 * where the method name can be freely selected.
 * <p>
 * For a given portlet name, only a single method of each type may be annotated. 
 * If a conditional dispatcher is declared in the portlet deployment descriptor, that
 * declaration overrides any <code>@ConditionalDispatchMethod</code> annotation.
 * <p>
 * The method should analyze the given <code>Set</code> of candidate methods using
 * the annotations available from each <code>MethodToken</code> 
 * based on the current request and
 * create a list of method tokens representing the methods to be invoked. 
 * The output list may be empty or <code>null</code>. 
 * A given method token may appear in the output list more than once.  
 * <p>
 * If the method returns a non-<code>null</code> List object, the portlet container will
 * invoke the methods in the order they appear in the list, and then 
 * perform no further dispatching operation for the current request.
 * <p>
 * If the method returns <code>null</code>, the portlet container will dispatch the 
 * method using its implementation-specific algorithm.
 * <p>
 * If the method throws an exception, it will be treated as an unhandled exception
 * during request processing. The portlet container will perform no 
 * further dispatching.
 * <p>
 * The method declaration may contain a throws clause. Exceptions declared in the 
 * throws clause should be of type {@link javax.portlet.PortletException} or
 * {@link java.io.IOException}. 
 * If the <code>throws</code> clause defines exceptions of any other type, 
 * it will be treated as a configuration error. 
 * </div>
 *    
 * @see RenderMethod
 * @see HeaderMethod
 * @see ServeResourceMethod
 * @see javax.portlet.ConditionalDispatcher
 * @see javax.portlet.MethodToken
 *
 */

@Retention(RUNTIME) @Target({METHOD})
public @interface ConditionalDispatchMethod {
   
   /**
    * <div class="changed_added_3_0">
    * The portlet names for which the conditional dispatcher applies.
    * <p>
    * The annotated method can apply to multiple portlets within the portlet
    * application. The names of the portlets to which the listener applies must be 
    * specified in this field.
    * <p>
    * A wildcard character '*' can be specified in the first portletName array element 
    * to indicate that the listener is to apply to all portlets in the portlet application.
    * If specified, the wildcard character must appear alone in the first array element.
    * This is the default if no portlet names are explicitly provided.
    * </div>
    * 
    * @return     The portlet names
    */
   String[]    portletNames() default "*";
}
