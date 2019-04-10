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
 * represent a single portlet preference.
 * It cannot be used as a stand-alone portlet annotation.
 * </div>
 * 
 * @since 3.0
 */
@Retention(RUNTIME) @Target({ANNOTATION_TYPE})
public @interface Preference {
   
   /**
    * <div class='changed_added_3_0'>
    * The preference name.
    * </div>
    * 
    * @return  The preference name
    */
   String      name();
   
   /**
    * <div class='changed_added_3_0'>
    * The preference values array.
    * </div>
    * 
    * @return  The preference values.
    */
   String[]    values();
   
   /**
    * <div class='changed_added_3_0'>
    * Marks the preference as being read-only.
    * </div>
    * 
    * @return  The read-only flag
    */
   boolean     isReadOnly() default false;
}
