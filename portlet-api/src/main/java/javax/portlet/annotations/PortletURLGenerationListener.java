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
 * Designates a portlet URL generation listener method.
 * The listener method will be invoked before a URL of the corresponding type is
 * generated.
 * <p>
 * The annotated method must have one of the following signatures:
 * <p>
 *    <code>public void &lt;methodName&gt;(ActionURL actionURL)</code>
 * <p>   
 * <p>
 *    <code>public void &lt;methodName&gt;(RenderURL renderURL)</code>
 * <p>   
 * <p>
 *    <code>public void &lt;methodName&gt;(ResourceURL resourceURL)</code>
 * <p>   
 * where the method name can be freely selected.
 * </div>
 *    
 * @see javax.portlet.PortletURLGenerationListener
 *
 */

@Retention(RUNTIME) @Target({METHOD})
public @interface PortletURLGenerationListener {
   
   /**
    * <div class='changed_added_3_0'>
    * Needed for V2.0 portlets to discern between a Render URL and an Action URL
    * since both are represented by the interface PortletURL.
    * 
    * Not needed for v3.0 portlets.
    * </div>
    */
   public enum URLType {RENDER, ACTION, RESOURCE}
   
   /**
    * The portlet names for which the listener applies.
    * <p>
    * The annotated listener method can apply to multiple portlets within the portlet
    * application. The names of the portlets to which the listener applies must be 
    * specified in this field.
    * <p>
    * A wildcard character '*' can be specified in the first portletName array element 
    * to indicate that the listener is to apply to all portlets in the portlet application.
    * If specified, the wildcard character must appear alone in the first array element.
    * 
    * @return     The portlet names
    */
   String[]    portletNames();
   
   /**
    * The ordinal number for this annotated method.
    * <p>
    * The ordinal number determines the order of execution if multiple methods
    * are annotated for a given URL type.
    * Annotated methods with a lower ordinal number are executed before methods with
    * a higher ordinal number.
    * 
    * @return     The ordinal number
    */
   int         ordinal() default 0;
   
   /**
    * <div class='not-supported'>
    * The display-name type contains a language-specific short name that is intended to be displayed by tools. 
    * </div>
    * 
    * @return  The display name
    */
   LocaleString[]   displayName() default {};
   
   /**
    * <div class='not-supported'>
    * The portlet filter description
    * providing locale-specific text describing the portlet filter for use by the portal application or by tools.
    * </div>
    * 
    * @return  The portlet description
    */
   LocaleString[]   description() default {};
   
   /**
    * The URL Type. 
    * This field is needed for v2.0 portlets to discern between render URLs and 
    * action URLs, since both are represented by the interface PortletURL.
    * 
    * Needs not be specified for ResourceURLs, as they are identified by the
    * ResourceURL interface.
    * 
    * Not needed for v3.0 portlets
    * 
    * @return  The URL type
    */
   URLType     type() default URLType.RENDER;
}
