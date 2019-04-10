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
 * Designates a method corresponding to the portlet API destroy method.
 * The annotated method must have the following signature:
 * <p>
 *    <code>public void &lt;methodName&gt;()</code>
 * <p>   
 * where the method name can be freely selected.
 * <p>
 * the <code>destroy</code> method is called by the portlet container to 
 * indicate to a portlet that the
 * portlet is being taken out of service.  
 * <p>
 * Before the portlet container calls the destroy method, it should 
 * allow any threads that are currently processing requests within 
 * the portlet object to complete execution. To avoid
 * waiting forever, the portlet container can optionally wait for 
 * a predefined time before destroying the portlet object.
 * <p>
 * This method enables the portlet to do the following:
 * <ul>
 * <li>clean up any resources that it holds (for example, memory,
 * file handles, threads) 
 * <li>make sure that any persistent state is
 * synchronized with the portlet current state in memory.
 * </ul>
 * </div>
 *    
 * @see javax.portlet.Portlet#destroy()
 * 
 * @since 3.0
 */

@Retention(RUNTIME) @Target({METHOD})
public @interface DestroyMethod {
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet name for the annotated method.
    * </div>
    * 
    * @return  The portlet name
    */
   String   value();
}
