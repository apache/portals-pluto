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
 * Designates a portlet URL generation listener class.
 * The listener method will be invoked before a URL of the corresponding type is
 * generated.
 * <p>
 * The annotated method must implement the <code>PortletListener</code> interface.
 * </div>
 *    
 * @see javax.portlet.PortletURLGenerationListener
 * 
 * @since 3.0
 */

@Retention(RUNTIME) @Target({TYPE})
public @interface PortletListener {
   
   /**
    * <div class='changed_added_3_0'>
    * The listener name. 
    * <p>
    * The listener name is not required. If a listener name is provided, the listener configuration
    * may be addressed through the listener name in the portlet deployment descriptor to modify 
    * or remove the listener.
    * <p>
    * </div>
    * 
    * @return  The listener name
    */
   String   listenerName() default "";
   
   /**
    * <div class='changed_added_3_0'>
    * The ordinal number for this annotated method.
    * <p>
    * The ordinal number determines the order of execution if multiple methods
    * are annotated for a given URL type.
    * Annotated methods with a lower ordinal number are executed before methods with
    * a higher ordinal number.
    * </div>
    * 
    * @return     The ordinal number
    */
   int         ordinal() default 0;
   
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
    * The portlet listener description
    * providing locale-specific text describing the portlet listener for use by the portal application or by tools.
    * </div>
    * 
    * @return  The portlet description
    */
   LocaleString[]   description() default {};
}
