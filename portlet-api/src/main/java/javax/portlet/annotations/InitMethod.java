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
 * Designates a method corresponding to the portlet API init method.
 * The annotated method must have the following signature:
 * <p>
 *    <code>public void &lt;methodName&gt;(PortletConfig) throws PortletException</code>
 * <p>   
 * where the method name can be freely selected.
 * <p>
 * the <code>init</code> method is called by the portlet container to 
 * initialize the portlet when it is  
 * being placed into service.
 * <p>
 * The portlet container calls the <code>init</code>
 * method exactly once after instantiating the portlet.
 * The <code>init</code> method must complete successfully
 * before the portlet can receive any requests.
 * <p>
 * The portlet container cannot place the portlet into service
 * if the <code>init</code> method
 * <ol>
 * <li>Throws a <code>PortletException</code>
 * <li>Does not return within a time period defined by the portlet container.
 * </ol>
 * </div>
 *    
 * @see javax.portlet.Portlet#init(javax.portlet.PortletConfig)
 * 
 * @since 3.0
 */

@Retention(RUNTIME) @Target({METHOD})
public @interface InitMethod {
   
   /**
    * <div class='changed_added_3_0'>
    * The portlet name for the annotated method.
    * </div>
    * 
    * @return  The portlet name
    */
   String   value();
}
