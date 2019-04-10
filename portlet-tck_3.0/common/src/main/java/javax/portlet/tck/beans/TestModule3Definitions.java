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
 * Contains definitions shared by the portlets in Test Module 3
 * 
 * @author nick
 */
public class TestModule3Definitions {

   // Test case names
   public final static String          TEST0    = "TestModule3_PublicRenderParameterTestDifferentPortletApplications";
   public final static String          TEST1    = "TestModule3_PublicRenderParameterTestDifferentQName";
   public final static String          TEST2    = "TestModule3_PublicRenderParameterTestDifferentIdentifier";

   // PRP identifiers
   public final static String          TM3PRP0  = "TM3PRP";
   public final static String          TM3PRP1  = "TM3DifferentQName";
   public final static String          TM3PRP2  = "TM3DifferentIdentifier";
   public final static String          TM3PRP2a = "TM3DifferentIdentifier-a";

   // Test case details
   public final static TestCaseDetails tcd      = initTests();

   private static TestCaseDetails initTests() {
      TestCaseDetails t = new TestCaseDetails();
      t.put(TEST0,
            "A PRP set on the render URL is visible in companion portlet of different portlet application. Same QName & Same identifier.");
      t.put(TEST1,
            "A PRP matching identifier but differing QNames is not visible in companion portlet of different portlet application.");
      t.put(TEST2,
            "A PRP with matching QName but differing identifier is visible in companion portlet of different portlet application.");
      return t;
   }

}
