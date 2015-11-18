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


package javax.portlet;

import java.lang.annotation.Annotation;

/**
 * <div class="changed_added_3_0">
 * Interface designating an implementation-specific token used for annotated
 * method invocation. The token represents a single candidate method for
 * conditional dispatching.
 * </div>
 *
 * @see  ConditionalDispatcher
 * @see  javax.portlet.annotations.ConditionalDispatchMethod
 */
public interface MethodToken {
   
   /**
    * <div class="changed_added_3_0">
    * Returns the annotation on the candidate method of the given type
    * if present, otherwise <code>null</code>.
    * </div>
    * 
    * @param annotationClass     The annotation type to be returned
    * @return                    The annotation on the candidate method of the 
    *                            given type, otherwise <code>null</code>.
    */
   <A extends Annotation> A getAnnotation(Class<A> annotationClass);
   
   /**
    * <div class="changed_added_3_0">
    * Returns an array containing all annotations present on the candidate method.
    * </div>
    * 
    * @return     The array of all candidate method annotations.
    */
   Annotation[] getAnnotations();
   
   /**
    * <div class="changed_added_3_0">
    * Returns true if an annotation of the given type is present on the candidate method, 
    * else false. 
    * This method is designed primarily for convenient access to marker annotations.
    * </div>
    * 
    * @return     <code>true</code> if the given annotation type is present
    */
   boolean isAnnotationPresent(Class<? extends Annotation> annotationClass);

}
