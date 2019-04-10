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
 * add multipart configuration information. 
 * This is the portlet analog of the
 * <code>javax.servlet.annotation.MultipartConfig</code> annotation.
 * <p> 
 * This annotation cannot be used as a stand-alone portlet annotation.
 * </div>
 * 
 * @see     javax.servlet.annotation.MultipartConfig
 * 
 * @since 3.0
 */
@Retention(RUNTIME) @Target({ANNOTATION_TYPE})
public @interface Multipart {
   
   /**
    * <div class='changed_added_3_0'>
    * Flag indicating if the portlet supports multipart forms.
    * Must be set to <code>true</code> to activate multipart forms support.
    * </div>
    * 
    * @return <code>true</code> if multipart forms are supported; <code>false</code> otherwise.
    */
   boolean supported();
   
   /**
    * <div class='changed_added_3_0'>
    * The size threshold after which the file will be written to disk.
    * </div>
    * 
    * @return The file size threshold
    */
   int fileSizeThreshold() default 0;
   
   /**
    * <div class='changed_added_3_0'>
    * The directory location where files will be stored.
    * </div>
    * 
    * @return  The directory location
    */
   String location() default "";
   
   /**
    * <div class='changed_added_3_0'>
    * The maximum size allowed for uploaded files.
    * </div>
    * 
    * @return The maximum size allowed for uploaded files
    */
   long maxFileSize() default -1L;
   
   /**
    * <div class='changed_added_3_0'>
    * The maximum size allowed for multipart/form-data requests.
    * </div>
    * 
    * @return The maximum size allowed for multipart/form-data requests
    */
   long maxRequestSize() default -1L; 
}
