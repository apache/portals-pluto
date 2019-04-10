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
 * Designates a preferences validator class.
 * The PortletPreferencesValidator allows validation of the set of portlet preferences 
 * before they are stored in the persistent store.
 * The validator method is invoked during execution of the 
 * store method of the PortletPreferences. 
 * <p>
 * The annotated class must implement the <code>PreferencesValidator</code> interface.
 * </div>
 *    
 * @see javax.portlet.PreferencesValidator
 * 
 * @since 3.0
 */

@Retention(RUNTIME) @Target({TYPE})
public @interface PortletPreferencesValidator {
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet names for which the validator applies.
    * <p>
    * The annotated validator method can apply to multiple portlets within the portlet
    * application. The names of the portlets to which the validator applies must be 
    * specified in this field.
    * <p>
    * A wildcard character '*' can be specified in the first portletName array element 
    * to indicate that the validator is to apply to all portlets in the portlet application.
    * If specified, the wildcard character must appear alone in the first array element.
    * </div>
    * 
    * @return     The portlet names
    */
   String[]   portletNames() default "*";
}
