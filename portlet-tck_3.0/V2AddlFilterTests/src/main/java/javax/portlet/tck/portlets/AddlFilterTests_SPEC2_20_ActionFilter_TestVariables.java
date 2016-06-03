/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package javax.portlet.tck.portlets;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names are defined
 * in the /src/main/resources/xml-resources/additionalTCs.xml file. The build process will integrate
 * the test case names defined in the additionalTCs.xml file into the complete list of test case
 * names for execution by the driver.
 *
 * This is the main portlet for the test cases. If the test cases call for events, this portlet will
 * initiate the events, but not process them. The processing is done in the companion portlet
 * AddlFilterTests_SPEC2_20_ActionFilter_TestVariables
 * @author ahmed
 */
public class AddlFilterTests_SPEC2_20_ActionFilter_TestVariables {
  public static boolean actionTr5a_success = false;
  public static boolean actionTr5b_success = false;
  public static boolean actionTr6a_success = false;
  public static boolean actionTr6b_success = false;
  public static boolean actionTr7a_success = false;
  public static boolean actionTr7b_success = false;
  public static boolean actionTr9_success = false;
  public static boolean actionTr10a_success = false;
  public static boolean actionTr10b_success = false;
}
