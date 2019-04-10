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
 * Annotation for the portlet application configuration. 
 * These configuration parameters also appear in
 * the portlet deployment descriptor.
 * <p>
 * The portlet deployment descriptor can continue to be used. 
 * Values of configuration parameters appearing in the deployment descriptor have 
 * precedence over the corresponding values defined in the annotation.   
 * </div>
 * 
 * @since 3.0
 */
@Retention(RUNTIME) @Target({TYPE})
public @interface PortletApplication {
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet API version required by this portlet application.
    * </div>
    * 
    * @return The portlet API version
    */
   String version() default "3.0";
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet container runtime options.
    * </div>
    * 
    * @return     An array of portlet container runtime options
    */
   RuntimeOption[] runtimeOptions() default {};
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The public render parameters used by the portlet.
    * </div>
    * 
    * @return     The array of public render parameters.
    */
   PublicRenderParameterDefinition[]  publicParams() default {};
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The events defined for the portlet.
    * This includes the processing events as well as the publishing events.
    * <p>
    * The publishing event QNames are specified in the
    * <code>ActionMethod</code> and <code>EventMethod</code> annotations.
    * The processing event QNames are specified in the
    * <code>ActionMethod</code> and <code>EventMethod</code> annotations.
    * </div>
    * 
    * @see        PortletQName
    * @see        ActionMethod
    * @see        EventMethod
    * 
    * @return     The event definitions
    */
   EventDefinition[] events() default {};
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The resource bundle name for this portlet.
    * Name of the resource bundle containing the language specific 
    * portlet information in different languages.
    * <p>
    * the file name is specified without 
    * the language specific part (e.g. _en) or the file extension.
    * </div>
    * 
    * @return     The resource bundle name
    */
   String   resourceBundle()  default "";
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The custom portlet modes defined for this portlet.
    * </div>
    * 
    * @return     The custom portlet modes
    */
   CustomPortletMode[] customPortletModes() default {};
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The custom window states defined for this portlet.
    * </div>
    * 
    * @return     The custom window states
    */
   CustomWindowState[] customWindowStates() default {};
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The default QName namespace URI.
    * <p>
    * The default namespace URI is used when no namespace URI is specified 
    * when declaring a QName for a public render parameter or portlet event. 
    * </div>
    * 
    * @return  The default namespace URI.
    */
   String      defaultNamespaceURI() default "";
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The user aattribute declarations. 
    * </div>
    * 
    * @return  The user attribute declarations
    */
   UserAttribute[] userAttributes() default {};
}
