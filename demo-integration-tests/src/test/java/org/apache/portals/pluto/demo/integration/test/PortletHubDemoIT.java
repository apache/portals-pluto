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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import org.openqa.selenium.JavascriptExecutor;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 *
 * @author Kyle Stiemann
 */
public class PortletHubDemoIT extends DemoTestDriver {
   private static final List<String> IMAGE_OPTIONS = Util.unmodifiableList("golfball", "baseball", "fussball");
   private static final String TOKEN = "{0}";
   private static final String IMAGE_XPATH_TEMPLATE =
         "//img[contains(@src,'/hub-demo-portlet/resources/images/" + TOKEN + ".gif')]";

   @Test
   public void testPortletHubDemo() throws UnsupportedEncodingException {
      navigateToPage("V3.0 Portlet Hub Demo");

      // Verify that all the different images appear when clicking each radio button.
      By imageByXpath = By.xpath(IMAGE_XPATH_TEMPLATE.replace(TOKEN, "FullMoon"));
      waitingAsserter.assertTrue(visibilityOfElementLocated(imageByXpath));

      for (String imageName : IMAGE_OPTIONS) {

         clickElement(driver, waitingAsserter,
               getXpath("div", "hub_demo_portlet", "ImageSelPortlet") + "/input[@value='" + imageName + "']");
         waitingAsserter.assertTrue(elementNotPresentOrNotVisible(imageByXpath));
         imageByXpath = By.xpath(IMAGE_XPATH_TEMPLATE.replace(TOKEN, imageName + "-trans"));
         waitingAsserter.assertTrue(visibilityOfElementLocated(imageByXpath));
      }

      // Verify that all the different images appear when clicking each dropdown option.
      clickElement(driver, waitingAsserter, "input", "hub_demo_portlet", "ImageSelPortlet", "dropdown");
      By imageSelectByXpath = By.xpath(getXpath("select", "hub_demo_portlet", "ImageSelPortlet") + "[@name='imgName']");
      waitingAsserter.waitFor(elementToBeClickable(imageSelectByXpath));
      Select select = new Select(driver.findElement(imageSelectByXpath));
      select.selectByValue("default");
      imageByXpath = By.xpath(IMAGE_XPATH_TEMPLATE.replace(TOKEN, "FullMoon"));
      waitingAsserter.assertTrue(visibilityOfElementLocated(imageByXpath));

      for (String imageName : IMAGE_OPTIONS) {

         select = new Select(driver.findElement(imageSelectByXpath));
         select.selectByValue(imageName);
         waitingAsserter.assertTrue(elementNotPresentOrNotVisible(imageByXpath));
         imageByXpath = By.xpath(IMAGE_XPATH_TEMPLATE.replace(TOKEN, imageName + "-trans"));
         waitingAsserter.assertTrue(visibilityOfElementLocated(imageByXpath));
      }

      // Verify that the border checkbox shows and hides the border on the image.
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(imageByXpath), attributeEmpty(imageByXpath, "style")));
      clickElement(driver, waitingAsserter, "input", "hub_demo_portlet", "PH", "ResourcePortlet", "PRP", "border");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(imageByXpath),
            attributeContains(imageByXpath, "style", "border:")));

      // Verify that the different cacheability radion buttons change the visible cacheability text.
      String cacheabilityRadioButtonXpathTemplate =
            getXpath("input", "hub_demo_portlet", "PH", "ResourcePortlet", "PRP") + "[@value='" + TOKEN + "']";
      String resourcePortletDivXpath = getXpath("div", "hub_demo_portlet", "PH", "ResourcePortlet", "PRP");
      By actionButtonByXpath = By.xpath(resourcePortletDivXpath + "//input[@value='Action']");

      for (String cacheability : Util.unmodifiableList("Portlet", "Full", "Page")) {

         String cacheabilityResultXpath = resourcePortletDivXpath + "//p[contains(text(),'Cacheability')]";
         waitingAsserter.assertTrue(elementNotPresentOrNotVisible(By.xpath(cacheabilityResultXpath +
               "[contains(text(),'" + cacheability + "')]")));
         String cacheabilityRadioButtonXpath = cacheabilityRadioButtonXpathTemplate.replace(TOKEN,
               cacheability.toUpperCase(Locale.ENGLISH));
         clickElement(driver, waitingAsserter, cacheabilityRadioButtonXpath);
         By cacheabilityResultByXpath = By.xpath(cacheabilityResultXpath);
         waitingAsserter.assertTrue(and(visibilityOfElementLocated(cacheabilityResultByXpath),
               textToBePresentInElementLocated(cacheabilityResultByXpath, cacheability)));

         if ("Page".equalsIgnoreCase(cacheability)) {
            waitingAsserter.assertTrue(visibilityOfElementLocated(actionButtonByXpath));
         } else {
            waitingAsserter.assertTrue(visibilityOfElementLocated(By.xpath(resourcePortletDivXpath +
               "[contains(.,'Action URL could not be created.')]")));
         }
      }

      // Click the Action button.
      clickElement(driver, waitingAsserter, actionButtonByXpath);
      waitingAsserter.assertTrue(visibilityOfElementLocated(actionButtonByXpath));

      // Verify the background color changes.
      navigateToPage("V3.0 Portlet Hub Demo");
      ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight);");

      By coloredTableByXpath =
            By.xpath(getXpath("div", "hub_demo_portlet", "PH", "ResourcePortlet", "PRP", "putResourceHere") +
			"//table[@style]");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(coloredTableByXpath),
            backgroundColor(coloredTableByXpath, 0xFF, 0xFF, 0xFF)));
      String colorInputXpath = getXpath("input", "hub_demo_portlet", "PH", "ColorSelPortlet", "color");
      sendKeysToElement(driver, waitingAsserter, colorInputXpath, "#FF0000", Keys.ENTER);
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(coloredTableByXpath),
            backgroundColor(coloredTableByXpath, 0xFF, 0, 0)));

      // Verify that messages can be sent in different colors by different methods.
      for (String formSubmissionMethod : Util.unmodifiableList("URL", "form")) {

         for (ColorCombo colorCombo : ColorCombo.getAllPossibleCombos()) {

            String lowerCaseFormSubmissionMethod = formSubmissionMethod.toLowerCase(Locale.ENGLISH);
            clickElement(driver, waitingAsserter, "input", "hub_demo_portlet", "PH", "ColorSelPortlet",
                  lowerCaseFormSubmissionMethod);
            testMessageSent(colorCombo);
         }

         clickElement(driver, waitingAsserter, "input", "hub_demo_portlet", "MessageBoxPortlet", "clear");
      }

      // Click the Do Partial Action button and check that the reponse text appears.
      By responseDivByXpath = By.xpath(getXpath("div", "hub_demo_portlet", "PartialActionPortlet", "responseDiv"));
      waitingAsserter.assertTrue(textEmpty(responseDivByXpath));

      for (int i = 1; i <= 10; i++) {

         clickElement(driver, waitingAsserter, "input", "hub_demo_portlet", "PartialActionPortlet", "doPA");
         waitingAsserter.assertTrue(and(visibilityOfElementLocated(responseDivByXpath),
               textToBePresentInElementLocated(responseDivByXpath,
                     "Partial Action has been executed " + i + " times.")));
      }
   }

   private void testMessageSent(ColorCombo colorCombo) {

      handleColorCheckbox("red", colorCombo.isRedSelected());
      handleColorCheckbox("green", colorCombo.isGreenSelected());
      handleColorCheckbox("blue", colorCombo.isBlueSelected());

      String messageInputXpath = getXpath("input", "hub_demo_portlet", "PH", "ColorSelPortlet", "msg");
      String message = colorCombo.getHexString();
      sendKeysToElement(driver, waitingAsserter, messageInputXpath, message);
      clickElement(driver, waitingAsserter, "input", "hub_demo_portlet", "PH", "ColorSelPortlet", "send");

      By messageOutputByXpath =
            By.xpath(getXpath("div", "hub_demo_portlet", "MessageBoxPortlet", "responseDiv") +
                  "/p[contains(text(),'" + colorCombo.getIndex() + ": " + message + "')]");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(messageOutputByXpath),
            or(attributeContains(messageOutputByXpath, "style", "color:#" + message + ";"),
                  attributeContains(messageOutputByXpath, "style", "color: " + colorCombo.getCSS_RGBString() + ";"))));
   }

   private void handleColorCheckbox(String colorName, boolean colorSelected) {

      WebElement colorCheckbox =
            driver.findElement(By.xpath(getXpath("input", "hub_demo_portlet", "PH", "ColorSelPortlet", colorName)));

      if ((colorSelected && !colorCheckbox.isSelected()) || (!colorSelected && colorCheckbox.isSelected())) {
         colorCheckbox.click();
      }
   }

   private static final class ColorCombo {

      // Constants
      private static final byte BLUE_BIT_POSITION = 0;
      private static final byte GREEN_BIT_POSITION = BLUE_BIT_POSITION + 1;
      private static final byte RED_BIT_POSITION = GREEN_BIT_POSITION + 1;
      private static final byte BINARY_STRING_LENGTH = RED_BIT_POSITION + 1;

      // Data
      private final byte selectedColorsInBinary;

      public ColorCombo(byte selectedColorsInBinary) {
         this.selectedColorsInBinary = selectedColorsInBinary;
      }

      public boolean isRedSelected() {
         return isColorSelected(selectedColorsInBinary, RED_BIT_POSITION);
      }

      public boolean isGreenSelected() {
         return isColorSelected(selectedColorsInBinary, GREEN_BIT_POSITION);
      }

      public boolean isBlueSelected() {
         return isColorSelected(selectedColorsInBinary, BLUE_BIT_POSITION);
      }

      public String getCSS_RGBString() {
         return "rgb(" +
               getBinaryString()
               .replace("", " ").trim().replace(" ", ", ")
               .replace("1", Integer.toString(0xFF)) +
               ")";
      }

      public String getHexString() {
         return "#" + getBinaryString().replace("1", "F");
      }

      public String getIndex() {
         return Integer.toString(selectedColorsInBinary + 1);
      }

      private String getBinaryString() {
         return getZeroPaddedString(Integer.toBinaryString(selectedColorsInBinary), BINARY_STRING_LENGTH);
      }

      private static boolean isColorSelected(byte selectedColors, byte colorBitPosition) {
         return ((selectedColors >> colorBitPosition) & 1) == 1;
      }

      public static Iterable<ColorCombo> getAllPossibleCombos() {
         return new AllPossibleCombosIterable();
      }

      private static final class AllPossibleCombosIterator implements Iterator<ColorCombo> {

         // Constants
         private static final byte ALL_COLORS = 0b111;
         private static final byte NO_COLORS = 0b000;

         // Data
         private byte selectedColorsInBinary = NO_COLORS;

         @Override
         public boolean hasNext() {
            return selectedColorsInBinary <= ALL_COLORS;
         }

         @Override
         public ColorCombo next() {

            if (!hasNext()) {
               throw new NoSuchElementException();
            }

            ColorCombo colorCombo = new ColorCombo(selectedColorsInBinary);
            selectedColorsInBinary++;

            return colorCombo;
         }
      }

      private static final class AllPossibleCombosIterable implements Iterable<ColorCombo> {

         @Override
         public Iterator<ColorCombo> iterator() {
            return new AllPossibleCombosIterator();
         }
      }
   }
}
