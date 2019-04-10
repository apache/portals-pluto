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


package javax.portlet.tck.portlets;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.portlet.tck.beans.TestResult;

/**
 * Class for temporary storage of test results that are produced in two execution phases.
 * This is a singleton class.
 * 
 * @author Scott Nicklous
 */
public class AsyncResults {
   
   private static AsyncResults asyres;
   
   Map<String, TestResult> results = new ConcurrentHashMap<>();  
   
   private AsyncResults() {
   }
   
   public static AsyncResults getAsyncResults() {
      if (asyres == null) {
         asyres = new AsyncResults();
      }
      return asyres;
   }
   
   public void setResult(String testcase, TestResult result) {
      results.put(testcase, result);
   }
   
   public TestResult getAndClearResult(String testcase) {
      TestResult result = results.get(testcase);
      results.remove(testcase);
      return result;
   }

}
