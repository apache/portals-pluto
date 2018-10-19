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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 *
 * @author Kyle Stiemann
 */
public final class Util {
   private static final int COLOR_HEX_STRING_LENGTH = 2;

   private Util() {
      throw new AssertionError();
   }

   public static String encodeURL(String url) {

      String portalName = System.getProperty("test.portal.name", "Pluto");

      if ("Pluto".equalsIgnoreCase(portalName)) {
         try {
            return URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
         }
         catch (UnsupportedEncodingException e) {
           throw new RuntimeException(e);
         }
      }
      else {
         return url.replace(" ", "-").toLowerCase(Locale.ENGLISH);
      }
   }

   public static Object executeScript(WebDriver webDriver, String script, Object... arguments) {
      return ((JavascriptExecutor)webDriver).executeScript(script, arguments);
   }

   public static String getColorCode(int red, int green, int blue) {

      return "#" +
            getHexString(red, COLOR_HEX_STRING_LENGTH) +
            getHexString(green, COLOR_HEX_STRING_LENGTH) +
            getHexString(blue, COLOR_HEX_STRING_LENGTH);
   }

   public static String getZeroPaddedString(String string, int stringLength) {
      return String.format("%" + stringLength + "s", string).replace(" ", "0");
   }

   public static <T> List<T> unmodifiableList(T... items) {
      return Collections.unmodifiableList(Arrays.asList(items));
   }

   // Expected Conditions
   public static ExpectedCondition<Boolean> attributeEmpty(By locator, String attributeName) {
      return or(attributeToBe(locator, attributeName, null), attributeToBe(locator, attributeName, ""));
   }

   public static ExpectedCondition<Boolean> backgroundColor(By locator, int red, int green, int blue) {

      String colorCode = getColorCode(red, green, blue);

      return and(visibilityOfElementLocated(locator),
            or(attributeContains(locator, "style", "background-color:" + colorCode + ";"),
                  attributeContains(locator, "style",
                        "background-color: rgb(" + red + ", " + green + ", " + blue + ");")));
   }

   public static ExpectedCondition<Boolean> elementNotPresentOrNotVisible(By locator) {
      return or(not(presenceOfAllElementsLocatedBy(locator)), invisibilityOfElementLocated(locator));
   }

   public static ExpectedCondition<Boolean> textEmpty(By locator) {
      return or(elementNotPresentOrNotVisible(locator), textToBe(locator, ""));
   }

   // Element Methods
   public static void clearElement(WebDriver webDriver, WaitingAsserter waitingAsserter, By locator) {

      waitingAsserter.waitFor(and(visibilityOfElementLocated(locator), new ElementEnabled(locator)));
      locator.findElement(webDriver).clear();
   }

   public static void clearElement(WebDriver webDriver, WaitingAsserter waitingAsserter, String elementTagName,
         String... elementIdFragments) {
      clearElement(webDriver, waitingAsserter, getXpath(elementTagName, elementIdFragments));
   }

   public static void clearElement(WebDriver webDriver, WaitingAsserter waitingAsserter, String elementXpath) {
      clearElement(webDriver, waitingAsserter, By.xpath(elementXpath));
   }

   public static void clickElement(WebDriver webDriver, WaitingAsserter waitingAsserter, By locator) {

      waitingAsserter.waitFor(and(visibilityOfElementLocated(locator),
            elementToBeClickable(locator)));
      locator.findElement(webDriver).click();
   }

   public static void clickElement(WebDriver webDriver, WaitingAsserter waitingAsserter, String elementTagName,
         String... elementIdFragments) {
      clickElement(webDriver, waitingAsserter, getXpath(elementTagName, elementIdFragments));
   }

   public static void clickElement(WebDriver webDriver, WaitingAsserter waitingAsserter, String elementXpath) {
      clickElement(webDriver, waitingAsserter, By.xpath(elementXpath));
   }

   public static WebElement findElement(WebDriver webDriver, String elementXpath) {
      return webDriver.findElement(By.xpath(elementXpath));
   }

   public static String getXpath(String elementTagName, String... elementIdFragments) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("//");
      stringBuilder.append(elementTagName);

      for (String idFragment : elementIdFragments) {
         stringBuilder.append("[");
         stringBuilder.append("contains(@id,'");
         stringBuilder.append(idFragment);
         stringBuilder.append("')]");
      }

      return stringBuilder.toString();
   }

   public static void sendKeysToElement(WebDriver webDriver, WaitingAsserter waitingAsserter, By locator,
         CharSequence... keys) {
      sendKeysToElement(webDriver, waitingAsserter, true, locator, keys);
   }

   public static void sendKeysToElement(WebDriver webDriver, WaitingAsserter waitingAsserter, String elementXpath,
         CharSequence... keys) {
      sendKeysToElement(webDriver, waitingAsserter, true, By.xpath(elementXpath), keys);
   }

   public static void sendKeysToElement(WebDriver webDriver, WaitingAsserter waitingAsserter,
         boolean clearBeforeSendingKeys, By locator, CharSequence... keys) {

      waitingAsserter.waitFor(and(visibilityOfElementLocated(locator), new ElementEnabled(locator)));

      if (clearBeforeSendingKeys) {
         clearElement(webDriver, waitingAsserter, locator);
      }

      locator.findElement(webDriver).sendKeys(keys);
   }

   public static void sendKeysToElement(WebDriver webDriver, WaitingAsserter waitingAsserter,
         boolean clearBeforeSendingKeys, String elementXpath, CharSequence... keys) {
      sendKeysToElement(webDriver, waitingAsserter, clearBeforeSendingKeys, By.xpath(elementXpath), keys);
   }

   private static String getHexString(int toHexValue, int stringLength) {
      return getZeroPaddedString(Integer.toHexString(toHexValue), stringLength);
   }
}
