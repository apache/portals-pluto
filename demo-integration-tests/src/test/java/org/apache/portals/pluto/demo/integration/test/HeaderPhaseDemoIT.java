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

import java.nio.charset.StandardCharsets;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 *
 * @author Kyle Stiemann
 */
public class HeaderPhaseDemoIT extends DemoTestDriver {

   @Test
   public void testHeaderPhaseDemo() {
      navigateToPage("V2 and V3 Header Tests");
      By characterEncodingByXpath = By.xpath("//p[contains(text(),'Character encoding:')]");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(characterEncodingByXpath),
            textToBePresentInElementLocated(characterEncodingByXpath, StandardCharsets.UTF_8.toString())));

      By contentTypeByXpath = By.xpath("//p[contains(text(),'Content type:')]");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(contentTypeByXpath),
            textToBePresentInElementLocated(contentTypeByXpath, "text/html")));

      By cookieDivByXpath = By.xpath(getXpath("div", "cookieDiv"));
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(cookieDivByXpath),
            textToBePresentInElementLocated(cookieDivByXpath, "V3HeaderPortlet=something-special"),
            textToBePresentInElementLocated(cookieDivByXpath, "Author=Scott")));

      String propertyNameXpath = "//li[contains(text(),'Property')][contains(text(),'name:')]";
      By portletPropertyByXpath = By.xpath(propertyNameXpath + "[contains(text(),'Portlet')]");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(portletPropertyByXpath),
            textToBePresentInElementLocated(portletPropertyByXpath, "V3HeaderPortlet"),
            textToBePresentInElementLocated(portletPropertyByXpath, "[V3HeaderPortlet]")));

      By portalPropertyByXpath = By.xpath(propertyNameXpath + "[contains(text(),'Portal')]");
      String portalName = System.getProperty("test.portal.name");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(portalPropertyByXpath),
            textToBePresentInElementLocated(portalPropertyByXpath, portalName),
            textToBePresentInElementLocated(portalPropertyByXpath, "[" + portalName)));
   }
}
