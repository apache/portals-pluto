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

import java.util.ArrayList;
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
public class PathInfoDemoIT extends DemoTestDriver{

   private static final List<String> EXPECTED_TITLES = unmodifiableList(
         "Included by resource method.",
         "Forwarded to Servlet by render method.",
         "Forwarded to JSP by render method.",
         "Included by render method.",
         "Included nested in Portlet -> Servlet -> JSP.",
         "Included named Servlet.");

   @Test
   public void testPathInfoDemo() {
      navigateToPage("Async Tests");
      By linksByXpath = By.xpath("//h3[text()='Path Info Portlet']/parent::div[@class='body']//a");
      waitingAsserter.waitFor(visibilityOfAllElementsLocatedBy(linksByXpath));
      List<WebElement> links = driver.findElements(linksByXpath);
      List<String> urls = new ArrayList<>();

      for (WebElement link : links) {
         urls.add(link.getAttribute("href"));
      }

      for (int i = 0; i < urls.size(); i++) {
         driver.get(urls.get(i));
         By titleByXpath = By.xpath("//p[contains(@id,'path_info_title')]");
         waitingAsserter.assertTrue(and(visibilityOfElementLocated(titleByXpath),
               textToBe(titleByXpath, EXPECTED_TITLES.get(i))));
      }
   }
}
