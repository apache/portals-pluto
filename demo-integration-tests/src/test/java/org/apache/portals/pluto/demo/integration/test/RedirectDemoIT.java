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
public class RedirectDemoIT extends DemoTestDriver {

   @Test
   public void testRedirectDemo() {
      navigateToPage("V3.0 Misc Tests - redirect");
      int red = 0xFF;
      int green = 0x00;
      int blue = 0x00;

      String color = getColorCode(red, green, blue);
      sendKeysToElement(driver, waitingAsserter, "//input[@name='color'][@type='text']", color);
      clickElement(driver, waitingAsserter, "//input[@value='redirect'][@type='submit']");
      waitingAsserter.assertTrue(backgroundColor(By.xpath("//h3[text()='V3 Redirect Portlet']/.."), red, green, blue));
      sendKeysToElement(driver, waitingAsserter, "//input[@name='url'][@type='text']",
            ChatRoomDemoIT.CHAT_ROOM_DEMO_URL);
      clickElement(driver, waitingAsserter, "//input[@value='redirect'][@type='submit']");
      waitingAsserter.assertTrue(visibilityOfElementLocated(By.xpath(
            "//h3[contains(text(),'Hello')][contains(text(),'World')][contains(text(),'!!')]")));
   }
}
