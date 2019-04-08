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
public class FragmentIdentifierDemoIT extends DemoTestDriver {

   @Test
   public void testFragmentIdentifierDemo() {
      navigateToPage("V3.0 Misc Tests - HTTP SC, fragment id");

      String fragmentId = "fragmentId";
      sendKeysToElement(driver, waitingAsserter, "//input[@name='frag'][@type='text']", fragmentId);
      sendKeysToElement(driver, waitingAsserter, "//input[@name='line'][@type='text']", "3");
      clickElement(driver, waitingAsserter,
         "//input[contains(@id,'v3_demo_portlet')][contains(@id,'LongPortlet')][@value='send'][@type='submit']");
      clickElement(driver, waitingAsserter, "//a[text()='Jump to line 3']");
      waitingAsserter.assertTrue(new ExpectedCondition<Boolean>() {
         @Override
         public Boolean apply(WebDriver webDriver) {
            Long pageYOffset = (Long) executeScript(webDriver,
                  "return (document.documentElement.scrollTop || window.pageYOffset);");
            return (pageYOffset > 0);
         }
      });
      waitingAsserter.assertTrue(visibilityOfElementLocated(By.id(fragmentId)));
   }
}
