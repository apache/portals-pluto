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
 * Designates a portlet request filter class.
 * The request filter performs filtering tasks on either the request to a portlet, 
 * on the response from a portlet, or on both.
 * <p>
 * Request filters perform filtering in the doFilter method. 
 * Every Filter has access to a FilterConfig object from which it can obtain its 
 * initialization parameters and a reference to the PortletContext object.
 * It can to load resources needed for filtering tasks through the PortletContext object.
 * <p>
 * Request filters can be applied to the Action phase, the Event phase, the Render phase 
 * or the Resource phase depending on which of the filter interfaces the request filter class
 * implements.  
 * <p>
 * The annotated type must implement one or more of the following interfaces:
 * <ul>
 * <li>javax.portlet.filter.PortletFilter</li>
 * <li>javax.portlet.filter.ActionFilter</li>
 * <li>javax.portlet.filter.EventFilter</li>
 * <li>javax.portlet.filter.RenderFilter</li>
 * <li>javax.portlet.filter.ResourceFilter</li>
 * </ul>
 * </div>
 *    
 * @see javax.portlet.filter.PortletFilter
 * @see javax.portlet.filter.ActionFilter
 * @see javax.portlet.filter.EventFilter
 * @see javax.portlet.filter.RenderFilter
 * @see javax.portlet.filter.ResourceFilter
 * 
 * @since 3.0
 */

@Retention(RUNTIME) @Target({TYPE})
public @interface PortletLifecycleFilter {
   
   /**
    * The filter name. 
    * <p>
    * The filter name is not required. If a filter name is provided, the filter configuration
    * may be addressed through the filter name in the portlet deployment descriptor to modify 
    * the filter or filter mapping.
    * <p>
    *  
    * 
    * @return  The filter name
    */
   String   filterName() default "";
   
   /**
    * <div class='not-supported changed_added_3_0'>
    * The portlet names for which the request filter applies.
    * <p>
    * The annotated request filter can apply to multiple portlets within the portlet
    * application. The names of the portlets to which the request filter applies must be 
    * specified in this field.
    * <p>
    * A wildcard character '*' can be specified in the first portletName array element 
    * to indicate that the request filter is to apply to all portlets in the portlet application.
    * If specified, the wildcard character must appear alone in the first array element.
    * </div>
    * 
    * @return     The portlet names
    */
   String[]   portletNames() default "*";
   
   /**
    * <div class='not-supported changed_added_3_0'>
    * The filter initialization parameters.
    * </div>
    * 
    * @return     An array of initialization parameters
    */
   InitParameter[] initParams() default {};
   
   /**
    * <div class='not-supported changed_added_3_0'>
    * The display-name type contains a language-specific short name that is intended to be displayed by tools. 
    * </div>
    * 
    * @return  The display name
    */
   LocaleString[]   displayName() default {};
   
   /**
    * <div class='not-supported changed_added_3_0'>
    * The portlet filter description
    * providing locale-specific text describing the portlet filter for use by the portal application or by tools.
    * </div>
    * 
    * @return  The portlet description
    */
   LocaleString[]   description() default {};
   
   /**
    * <div class='not-supported changed_added_3_0'>
    * The ordinal number for this annotated method.
    * <p>
    * The ordinal number determines the order of execution if multiple methods
    * are annotated for a given request type.
    * Annotated methods with a lower ordinal number are executed before methods with
    * a higher ordinal number.
    * </div>
    * 
    * @return     The ordinal number
    */
   int        ordinal() default 0;
}
