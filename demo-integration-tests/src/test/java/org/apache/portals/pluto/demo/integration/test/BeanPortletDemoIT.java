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
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 *
 * @author Kyle Stiemann
 */
public class BeanPortletDemoIT extends DemoTestDriver {

   @Test
   public void testBeanPortletDemo() {
      navigateToPage("Bean Portlet Demo");
      By scopeInfoNumbersByXpath = By.xpath(getXpath("table", "BeanPortlet", "scope_info") + "//tr/td[2]");
      waitingAsserter.waitFor(visibilityOfAllElementsLocatedBy(scopeInfoNumbersByXpath));
      List<WebElement> scopeInfoNumbers = driver.findElements(scopeInfoNumbersByXpath);

      for (WebElement scopeInfoNumber : scopeInfoNumbers) {
         Assert.assertTrue(Integer.parseInt(scopeInfoNumber.getText().trim()) > 0);
      }

      sendKeysToElement(driver, waitingAsserter, "(//input[@name='name'][@type='text'])[1]", "user");
      clickElement(driver, waitingAsserter, "(//input[@value='send'][@type='submit'])[1]");
      waitingAsserter.assertTrue(and(
            visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Hello')][contains(text(),'user!!')]")),
            visibilityOfElementLocated(By.xpath(getXpath("div", "BeanPortlet", "putResourceHere") + "/img"))));
   }
}
