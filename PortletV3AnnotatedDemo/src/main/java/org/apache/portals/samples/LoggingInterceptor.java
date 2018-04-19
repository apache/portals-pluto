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
package org.apache.portals.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Interceptor to provide logging for our project
 * 
 * @author Scott Nicklous
 */
@Interceptor
@Log
public class LoggingInterceptor implements Serializable {

   private static final long serialVersionUID = -73481963162413796L;

   private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class.getCanonicalName());

   /**
    * Method called for use as an interceptor. Called before the intercepted method is 
    * called. 
    * 
    * @param ic
    * @return
    * @throws Exception
    */
   @AroundInvoke
   public Object log(InvocationContext ic) throws Exception {

      String cls = ic.getMethod().getDeclaringClass().getCanonicalName();
      String meth = ic.getMethod().getName();
      
      // Log method entry
      Logger mlogger = LoggerFactory.getLogger(cls);
      mlogger.debug("ENTERING: " + cls, meth);
      
      // Continue through chain until actual bean method is executed
      Object obj = ic.proceed(); 
   
      // this logging statement is only for debugging.
      logger.debug("Method " + meth + " has been called.");
      
      // Now log the exit
      mlogger.debug("EXITING: " + cls, meth);

      return obj;
   }

}
