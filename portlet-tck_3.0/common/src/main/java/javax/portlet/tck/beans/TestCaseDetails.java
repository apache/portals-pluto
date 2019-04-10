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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contains all test case names and detail strings used by a portlet. Provides helper methods for dealing with test case
 * results.
 * 
 * The goal is to allow additional test cases to be added by adding new test modules without having all test cases
 * defined in a central location, otherwise we could just define all test case names / details here.
 * 
 * @author nick
 */
public class TestCaseDetails implements Map<String, String> {

   private Map<String, String> detailsMap = null;

   /**
    * For use when a new instance with a new map is to be created, for example, when a portlet uses the class directly.
    */
   public TestCaseDetails() {
      detailsMap = new HashMap<String, String>();
   }

   /**
    * Creates an instance using an existing map. Mainly for use by classes that extend this one.
    * 
    * @param map
    *           Existing test case name - test case details map.
    */
   public TestCaseDetails(Map<String, String> map) {
      detailsMap = map;
   }

   @Override
   public void clear() {
      detailsMap.clear();
   }

   @Override
   public boolean containsKey(Object key) {
      return detailsMap.containsKey(key);
   }

   @Override
   public boolean containsValue(Object value) {
      return detailsMap.containsValue(value);
   }

   @Override
   public Set<java.util.Map.Entry<String, String>> entrySet() {
      return detailsMap.entrySet();
   }

   @Override
   public String get(Object key) {
      return detailsMap.get(key);
   }

   @Override
   public boolean isEmpty() {
      return detailsMap.isEmpty();
   }

   @Override
   public Set<String> keySet() {
      return detailsMap.keySet();
   }

   @Override
   public String put(String key, String value) {
      return detailsMap.put(key, value);
   }

   @Override
   public void putAll(Map<? extends String, ? extends String> map) {
      detailsMap.putAll(map);
   }

   @Override
   public String remove(Object key) {
      return detailsMap.remove(key);
   }

   @Override
   public int size() {
      return detailsMap.size();
   }

   @Override
   public Collection<String> values() {
      return detailsMap.values();
   }

   /**
    * Gets a test result initialied with the test case name, the test case detail string, and the results set to
    * <code>false</code> (test failed).
    * 
    * @param tcName
    *           test case name
    * @return
    */
   public TestResult getTestResultFailed(String tcName) {
      return new TestResult(tcName, false, detailsMap.get(tcName));
   }

   /**
    * Gets a test result initialied with the test case name, the test case detail string, and the results set to
    * <code>true</code> (test succeeded).
    * 
    * @param tcName
    *           test case name
    * @return
    */
   public TestResult getTestResultSucceeded(String tcName) {
      return new TestResult(tcName, true, detailsMap.get(tcName));
   }

   /**
    * Gets a test result initialized with the test case name, the test case detail string, and the results set to
    * <code>false</code> (test failed).
    * 
    * For Portlet Hub testing.
    * 
    * @param tcName
    *           test case name
    * @return
    */
   public TestResultAsync getTestResultAsyncFailed(String tcName) {
      return new TestResultAsync(tcName, false, detailsMap.get(tcName));
   }

   /**
    * Gets a test result initialied with the test case name, the test case detail string, and the results set to
    * <code>true</code> (test succeeded).
    * 
    * For Portlet Hub testing.
    * 
    * @param tcName
    *           test case name
    * @return
    */
   public TestResultAsync getTestResultAsyncSucceeded(String tcName) {
      return new TestResultAsync(tcName, true, detailsMap.get(tcName));
   }

}
