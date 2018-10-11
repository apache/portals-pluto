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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 *
 * @author Kyle Stiemann
 */
public class MultipartFormDemoIT extends DemoTestDriver {

   @Test
   public void testMultipartFormDemo() throws IOException {
      navigateToPage("File Upload");
      By colorPickerByXpath = By.xpath("//input[@type='color']");
      waitingAsserter.waitFor(and(visibilityOfElementLocated(colorPickerByXpath),
            new ElementEnabled(colorPickerByXpath)));

      String color = "#FFFFFF";
      WebElement colorPicker = driver.findElement(colorPickerByXpath);
      executeScript(driver, "arguments[0].value = '" + color + "'", colorPicker);

      String fileNamePrefix = "pluto-test-";
      Path tempFilePath = Files.createTempFile(fileNamePrefix, ".txt");
      File tempFile = tempFilePath.toFile();
      tempFile.deleteOnExit();

      String text = "Test text.";
      try (PrintWriter out = new PrintWriter(tempFile)) {
         out.println(text);
      }

      sendKeysToElement(driver, waitingAsserter, "//input[@type='file']", tempFilePath.toString());
      clickElement(driver, waitingAsserter, "//input[@type='submit'][@value='submit']");

      By fileInfoByXpath = By.xpath("//h5[text()='Info:']/..");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(fileInfoByXpath),
            textToBePresentInElementLocated(fileInfoByXpath, "Color: " + color.toLowerCase(Locale.ENGLISH)),
            textToBePresentInElementLocated(fileInfoByXpath, "Uploaded file name: " + fileNamePrefix),
            textToBePresentInElementLocated(fileInfoByXpath, "content-type=[text/plain]")));

      By fileContentsByXpath = By.xpath("//h5[text()='File contents:']/..");
      waitingAsserter.assertTrue(and(visibilityOfElementLocated(fileContentsByXpath),
            textToBePresentInElementLocated(fileContentsByXpath, text)));
   }
}
