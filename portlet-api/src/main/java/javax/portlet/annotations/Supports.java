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
 * This annotation is used within composite portlet configuration annotations to
 * specify the supported portlet modes and window states for a given content type.
 * It cannot be used as a stand-alone portlet annotation.
 * </div>
 * 
 * @since 3.0
 */
@Retention(RUNTIME) @Target({ANNOTATION_TYPE})
public @interface Supports {
   
   /**
    * <div class='container-change changed_added_3_0'>
    * The MIME type for the supported portlet modes and window
    * states listed in this annotation, for example <code>"text{@literal /}html"</code>.
    * <p>
    * The MIME type may also contain the wildcard character '*', 
    * for example <code>"text{@literal /}*"</code> or <code>"*{@literal /}*"</code>.
    * </div>
    * 
    * @return     The MIME type
    */
   String   mimeType() default "text/html";
   
   /**
    * <div class='container-change changed_added_3_0'>
    * Defines the portlet modes supported by this portlet.
    * <p>
    * The following names represent the standard portlet modes: 
    * "edit", "help", "view".
    * Custom portlet modes may also be defined.
    * <p>
    * Portlet mode names are not case sensitive.
    * </div>
    * 
    * @return  The supported portlet modes
    */
   String[] portletModes() default {"view"};
   
   /**
    * <div class='container-change changed_added_3_0'>
    * Defines the window states supported by this portlet.
    * <p>
    * The following names represent the standard window states: 
    * "normal", "minimized", "maximized".
    * Custom window states may also be defined.
    * <p>
    * Window state names are not case sensitive.
    * </div>
    * 
    * @return  The supported window states
    */
   String[] windowStates() default {"normal", "minimized", "maximized"};
}
