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

package javax.portlet.tck.driver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertTrue;


/**
 * @author Vernon Singleton
 *
 */
@RunWith(value = Parameterized.class)
public class TCKLiferayTestDriver extends TCKTestDriver {

   private static Properties nonExclusiveTCs = new Properties();
   private static boolean hadToGet = false;
   private static boolean wasExclusive = false;
   private static boolean stillExclusive = false;
   private static boolean exclusive = false;

   private void getNonExclusiveTCs() {
      String nonExclusiveTCsFile = System.getProperty("test.non.exclusive.file", "");
      System.out.println("   nonExclusiveTCsFile  =" + nonExclusiveTCsFile);

      if ("".equals(nonExclusiveTCsFile)) {
         System.out.println("   no nonExclusiveTCsFile given.");
      } else {
         try {
            FileInputStream fis = new FileInputStream(nonExclusiveTCsFile);
            nonExclusiveTCs.loadFromXML(fis);
         } catch (Exception e) {
            System.err.println("Could not read nonExclusiveTCs file. Attempted to read file " + nonExclusiveTCsFile);
            e.printStackTrace();
         }
      }
      System.out.println("   # nonExclusiveTCs =" + nonExclusiveTCs.size());
   }

   public TCKLiferayTestDriver(String p, String t) {
      super(p, t);
      if (nonExclusiveTCs.size() == 0) {
         getNonExclusiveTCs();
      }
   }

   private List<WebElement> getExclusive() {

      String[] tokens = tcName.split("_");
      String liferayWar = "_WAR_tck" + tokens[0];
      String noV = tcName.replaceFirst("^V[0-9]+", "");
      String portletName = noV.substring(0, noV.lastIndexOf("_"));
      String portletId =  portletName + liferayWar;

      String url = baseUrl +
                   page +
                   "?p_p_id=" + portletId +
                   "&p_p_state=exclusive";

      // System.out.println("getExclusive: url = " + url);
      hadToGet = true;
      exclusive = true;
      driver.get(url);

      WebDriverWait wdw = new WebDriverWait(driver, timeout);
      wdw.until(ExpectedConditions.visibilityOfElementLocated(By.name(tcName)));
      List<WebElement> wels = driver.findElements(By.name(tcName));
      return wels;

   }

   @Test
   public void test() {
      debugLines.add("   execute test.");

      if (dryrun) {
         return;
      }

      try {

         // This is optimized for many results being present on the same page.
         // First look for the test results or links already being present on the page.

         List<WebElement> wels = driver.findElements(By.name(tcName));
         hadToGet = false;

         List<WebElement> metas = driver.findElements(By.tagName("meta"));
         if (metas.isEmpty()) {
            stillExclusive = true;
         } else {
            stillExclusive = false;
         }

         if (nonExclusiveTCs.getProperty(tcName) == null) {

            // tcName is NOT in the list of nonExclusive tests, so it should be tested in exclusive state
            // System.out.println("test: " + tcName + " should be tested in exclusive state ...");
            // System.out.println("test: driver.getCurrentUrl() = " + driver.getCurrentUrl());

            if (!stillExclusive) {
               wels = getExclusive();
            }

            // get exclusive portlet for this test case if we are on the wrong page
            // this usually occurs when the last test case was for a different portlet
            // wels = driver.findElements(By.name(tcName));
            if (wels.isEmpty()) {
               wels = getExclusive();
            }

         } else {

            // tcName is in the list of nonExclusive tests, so it should NOT be tested in exclusive state
            if (wels.isEmpty() || stillExclusive) {
               wels = accessPage();
               hadToGet = true;
               exclusive = false;
            }

         }

         if (wasExclusive && !stillExclusive && !hadToGet) {
            exclusive = false;
         }

         debugLines.add("   TC elements already on page: " + !wels.isEmpty() + ", tcname===" + tcName + "===");
         if (wels.isEmpty()) {
            System.out.println("test: wels.isEmpty() ... accessing page normally ... WHY IS THIS HAPPENING?");
            wels = accessPage();
            hadToGet = true;
            exclusive = false;
         }

         // process links if present
         wels = processClickable(wels);
         debugLines.add("   After processing clickable, results found: " + !wels.isEmpty());

         // wait for any async JavaScript tests to complete
         processAsync();

         checkResults();

      } catch(Exception e) {

         // Some type of unexpected error occurred, so generate text
         // and mark the TC as failed.
         String currentUrl = driver.getCurrentUrl();

         System.out.println("   Exception occurred: " + e.getMessage());
         System.out.println("      diagnostic url = " + currentUrl);
         for (String line : debugLines) {
            System.out.println(line);
         }

         throw new AssertionError("Test case " + tcName + " failed. " +
                 "\nException: ", e);
      } finally {

         wasExclusive = exclusive;

      }
   }

   protected void click(WebElement wel) {

	   boolean sennaJS = true;
	   String url = null;

	   if (wel != null) {
          String tagName = wel.getTagName();

	      if ("a".equals(tagName)) {
             url = wel.getAttribute("href");
             sennaJS = !url.contains("v3headerportlettests") && !url.contains("v3portlethubtests");
          }
	   }

	   if (sennaJS) {
          wel.click();
       } else {
          driver.get(url);
	   }
   }
}
