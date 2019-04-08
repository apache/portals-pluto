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

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 *
 * @author Kyle Stiemann
 */
public class DependencyDemoIT extends DemoTestDriver{

   @Test
   public void testDependencyDemo() {
      navigateToPage("Dependencies");
      assertBadDependencyStringThrewException("String: Hi there!",
            "Exception: java.lang.IllegalArgumentException:");
      assertBadDependencyStringThrewException("String: <script dffsfssf",
            "Exception: java.lang.IllegalArgumentException:");
      assertBadDependencyStringThrewException("String: <link href='hi'>bad string<link href='bye'>",
            "Exception: java.lang.IllegalArgumentException:");
      assertBadDependencyStringThrewException("String: <p>bad head tag</p>",
            "Exception: java.lang.IllegalArgumentException:");
      List<WebElement> versionRadioButtons = driver.findElements(By.xpath("//input[@name='version']"));

      for (int i = 0; i < versionRadioButtons.size(); i++) {

         String expectedVersion = versionRadioButtons.get(i).getAttribute("value");

         if (i == 0) {
            expectedVersion = System.getProperty("test.dependency.portlet.default.jquery.version");
         }

         versionRadioButtons.get(i).click();
         clickElement(driver, waitingAsserter,
               By.xpath("//button[contains(text(),'render with selected version')]"));
         clickElement(driver, waitingAsserter, "button", "v3_demo_portlet", "DependencyPortlet", "button");
         By versionTextByXpath = By.xpath(getXpath("p", "v3_demo_portlet", "DependencyPortlet", "fadeText") +
               "[text()]");
         waitingAsserter.assertTrue(and(visibilityOfElementLocated(versionTextByXpath),
               textToBe(versionTextByXpath, "jQuery version: " + expectedVersion)));

         versionRadioButtons = driver.findElements(By.xpath("//input[@name='version']"));
      }
   }

   private void assertBadDependencyStringThrewException(String badDependencyString, String expectedExceptionString) {
      By badDepencencyStringByXpath = By.xpath("//p[contains(text(),\"" + badDependencyString + "\")]");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(badDepencencyStringByXpath),
            textToBePresentInElementLocated(badDepencencyStringByXpath, expectedExceptionString)));
   }
}
