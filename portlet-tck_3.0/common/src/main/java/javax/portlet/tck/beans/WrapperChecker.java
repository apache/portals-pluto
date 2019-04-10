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

package javax.portlet.tck.beans;

/**
 * Abstract base class to be extended by the specific checker classes for the wrappers. The extending checker class must
 * implement the interface to be tested.
 * 
 * This class provides the mechanism for verifying that the arguments passed to each wrapper class method are passed
 * correctly to the wrapped class and to verfiy that the returned value from the wrapped method is received correctly by
 * the caller.
 * 
 * @author Scott
 * 
 */
public abstract class WrapperChecker {

   // expected values set before method call
   String     name;
   Object[]   args;

   // expected return value from wrapped method
   Object     retVal;

   // Test case handling
   TestResult tr;

   /**
    * Prepares the wrapper tester for a specific test case
    * 
    * @param tr
    *           test result to be updated as necessary
    * @param name
    *           name of method to be tested
    * @param args
    *           parameter array
    */
   public void prepare(TestResult tr, String name, Object... args) {
      this.tr = tr;
      this.name = name;
      this.args = (args == null) ? new Object[] {} : args;
      this.retVal = null;
   }

   public void checkRetval(Object retVal) {
      if (tr.isTcSuccess() == false)
         return; // parameter check failed

      if (retVal == this.retVal) {
         tr.setTcSuccess(true);
      } else {
         tr.setTcSuccess(false);
         tr.appendTcDetail("return value mismatch. Expected: " + this.retVal + ", Actual: " + retVal);
      }
   }

   protected void checkArgs(String name, Object[] args) {
      tr.setTcSuccess(true);
      if (!name.equals(this.name)) {
         tr.setTcSuccess(false);
         tr.appendTcDetail("Wrong method called. Expected: " + this.name + ", Actual: " + name);
      } else if (args.length != this.args.length) {
         tr.setTcSuccess(false);
         tr.appendTcDetail("Wrong number of arguments. Expected: " + this.args.length + ", Actual: " + args.length);
      } else {
         for (int ii = 0; ii < args.length; ii++) {
            if (args[ii] != this.args[ii]) {
               tr.setTcSuccess(false);
               tr.appendTcDetail("Argument " + ii + " mismatch: " + "Expected: " + this.args[ii] + ", Actual: "
                     + args[ii]);
            }
         }
      }
   }
}
