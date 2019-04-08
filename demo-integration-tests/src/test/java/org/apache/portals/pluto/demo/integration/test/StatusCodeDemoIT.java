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
package org.apache.portals.pluto.demo.integration.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 *
 * @author Kyle Stiemann
 */
public class StatusCodeDemoIT extends DemoTestDriver {

   @Test
   public void testStatusCodeDemo() {
      for (String statusCode : unmodifiableList("404", "200", "500")) {
         navigateToPage("V3.0 Misc Tests - HTTP SC, fragment id");
         sendKeysToElement(driver, waitingAsserter, "//input[@name='statusCode'][@type='text']", statusCode);
         clickElement(driver, waitingAsserter,
               "//input[contains(@id,'v3_demo_portlet')][contains(@id,'AuthSCPortlet')][@value='send'][@type='submit']");
         clickElement(driver, waitingAsserter, "//a[text()='Resource URL, status code = " + statusCode + "']");
         waitingAsserter.assertTrue(visibilityOfElementLocated(By.xpath(
               "//p[contains(text(),'Status code: " + statusCode + "')]")));
      }
   }
}
