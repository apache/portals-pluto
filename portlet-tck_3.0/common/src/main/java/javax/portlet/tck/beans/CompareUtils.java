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


/** Contains some useful comparison methods 
 * 
 * @author nick
 */
public class CompareUtils {

   /**
    * Compares two strings and sets the test result accordingly. 
    * If both strings are null, comparison is successful.
    * 
    * @param a    1st string to compare
    * @param b    2nd string to compare
    * @param tr   test result to be updated
    */
   static public void stringsEqual(String a, String b, TestResult tr) {
      boolean ok = (a==null) && (b == null);
      if (!ok) {
         if ((a != null) && (b != null)) {
            ok = a.equals(b);
         }
         if (!ok) {
            String str = "Error: " + a + " does not equal " + b + ".";
            tr.appendTcDetail(str);
         }
      }
      tr.setTcSuccess(ok);
   }
}
