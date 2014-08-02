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


package javax.portlet.tck.WrapperTests.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;

import static java.util.logging.Level.*;

import java.util.logging.Logger;

/**
 * Abstract base class to be extended by the specific checker classes for the wrappers.
 * The extending checker class must implement the interface to be tested, and the implemented
 * methods must store their parameters in the parms array. 
 * 
 * @author Scott
 *
 */
public abstract class WrapperChecker {
   private static final String LOG_CLASS = WrapperChecker.class.getName();
   private final Logger        LOGGER    = Logger.getLogger(LOG_CLASS);

   // Must be filled by method of extending class
   protected ArrayDeque<Object> parms = new ArrayDeque<Object>();
   
   // The actual value returned by the wrapper checker. must be set by extending class. 
   protected Object testRetVal = null;   
   
   // must be set by method in extending class
   protected boolean  called = false;
   
   /**
    * Calls the specified method on the specified object with the specified parameter list.
    * The parameters passed through the wrapper and stored by the extending WrapperChecker code
    * are compared and verified. if all is well, <code>true</code> is returned.
    * 
    * @param m          Method to be invoked
    * @param testObj    Object on which method is to be invoked
    * @param args       Arguments for method
    * @return           true, if the wrapped checker class was called correctly
    */
   public boolean checksOK(Method m, Object testObj, Object... args) {
      LOGGER.entering(LOG_CLASS, "checksOK");
      boolean result = false;
      Object retVal = null;       
      try {
         retVal = m.invoke(testObj, args);
         if ((called == true) && (testRetVal == retVal) && (parms.size() == args.length)) {
            result = true;
            for (int ii=0; ii<args.length; ii++) {
               if (parms.remove() != args[ii]) {
                  result = false;
               }
            }
         }
      } catch (IllegalAccessException e) {
         LOGGER.logp(FINE, LOG_CLASS, "checksOK", "", e);
      } catch (IllegalArgumentException e) {
         LOGGER.logp(FINE, LOG_CLASS, "checksOK", "", e);
      } catch (InvocationTargetException e) {
         LOGGER.logp(FINE, LOG_CLASS, "checksOK", "", e);
      }
      return result;
   }
   
   public void reset() {
      LOGGER.entering(LOG_CLASS, "reset");
      testRetVal = null;
      called = false;
      parms.clear();
   }
}
