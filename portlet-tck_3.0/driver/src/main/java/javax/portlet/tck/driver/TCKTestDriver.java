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

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.portals.pluto.test.utilities.SimpleTestDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.portlet.tck.constants.Constants;
import org.junit.Assume;


/**
 * @author nick
 *
 */
@RunWith(value = Parameterized.class)
public class TCKTestDriver extends SimpleTestDriver {

   protected static final Set<String> IGNORED_TC_NAMES;

   protected String page, tcName;
   
   protected List<String> debugLines = new ArrayList<>();

   static {

      String ignoreFile = System.getProperty("test.ignore.list.file");
      System.out.println("   Ignore file  =" + ignoreFile);
      boolean doIgnore = Boolean.parseBoolean(System.getProperty("test.ignore"));
      System.out.println("   Ignore TCs   =" + doIgnore);

      Properties ignoredTCs = new Properties();
      if (doIgnore) {
         try {
            FileInputStream fis = new FileInputStream(ignoreFile);
            ignoredTCs.loadFromXML(fis);
         } catch (IOException e) {
            throw new RuntimeException("Could not read test cases file. Attempted to read file " + ignoreFile, e);
         }
      }
      System.out.println("   # ignore TCs =" + ignoredTCs.size());
      IGNORED_TC_NAMES = Collections.unmodifiableSet(ignoredTCs.stringPropertyNames());
   }

   /**
    * Reads the consolidated list of test cases and provides the list to Junit
    * for parameterized testing.
    * @return  a Collection of test cases to run
    */
   @SuppressWarnings("rawtypes")
   @Parameters (name = "{1}")
   public static Collection getTestList () {
      System.out.println("getTestList");
      testFile = System.getProperty("test.list.file");
      System.out.println("   TestFile=" + testFile);
      module = System.getProperty("test.module");
      System.out.println("   Module       =" + module);
      scroll = Boolean.valueOf(System.getProperty("test.scroll"));
      System.out.println("   Scroll       =" + scroll);

      boolean filterTCs = (module != null && module.length() > 0);
      boolean excTCs = true;        // include or exclude TCs
      String filterStr = module;
      if (filterTCs) {
         excTCs = module.startsWith("!");
         filterStr = module.replaceFirst("^!(.*)$", "$1");
         System.out.println("   Filtering    = " + (excTCs?"Excluding":"Including") + 
                            " all " + filterStr + " testcases");
      }

      Properties tprops = new Properties();
      try {
         FileInputStream fis = new FileInputStream(testFile);
         tprops.loadFromXML(fis);
      } catch (IOException e) {
         throw new RuntimeException("Could not read test cases file. Attempted to read file " + testFile, e);
      }
      
      // See if performance can be improved by sorting the test cases by
      // the page to be accessed. The map uses the page as key and has a 
      // set of test cases for that page as value. Filter according to 
      // test.module.
      
      TreeMap<String, Set<String>> pages = new TreeMap<String, Set<String>>();
      Set<Object> tcs = tprops.keySet();
      
      tcloop:
      for (Object o : tcs) {
         String tcase = (String) o ;
         String tpage = tprops.getProperty(tcase);
         if (filterTCs) {
            boolean c = tcase.contains(filterStr);
            if (excTCs && c) continue;       // exclude matches
            if (!excTCs && !c) continue;     // exclude non-matches
         }
         if (!pages.containsKey(tpage)) {
            pages.put(tpage, new TreeSet<String>());
         }
         pages.get(tpage).add(tcase);
      }

      // now pass TCs, sorted by page, to the driver
      
      List<String[]> tests = new ArrayList<String[]>();
      for (String tpage : pages.keySet()) {
         for (String  tcase: pages.get(tpage)) {
            String[] parms = {tpage, tcase};
            tests.add(parms);
         }
      }
      
      int numP = pages.size();
      int numTC = tests.size();
      System.out.println("Executing " + numTC + " tests on " + numP + " pages.");

      return tests;
   }

   public TCKTestDriver(String p, String t) {
      page = p;
      tcName = t;
      System.out.println("Testing: " + tcName);
   }

   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception {
      Assume.assumeFalse("   Ignoring     :" + tcName, IGNORED_TC_NAMES.contains(tcName));
      debugLines.add("   before test.");
   }

   /**
    * @throws java.lang.Exception
    */
   @After
   public void tearDown() throws Exception {
      debugLines.add("   after test.");
      if (debug) {
         for (String line : debugLines) {
            System.out.println(line);
         }
      }
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
         debugLines.add("   TC elements already on page: " + !wels.isEmpty() + ", tcname===" + tcName + "===");
         if (wels.isEmpty()) {
            wels = accessPage();
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
         
         System.out.println("   Exception occurred: " + e.getMessage());
         for (String line : debugLines) {
            System.out.println(line);
         }

         throw new AssertionError("Test case " + tcName + " failed. " +
            "\nException: ", e);
      }
   }

   /**
    * Tries to access the page for the test case. Looks for the page link
    * and clicks it, waiting for the page to load.
    * 
    * @return  a list of elements for the TC (should only be one)
    */
   protected List<WebElement> accessPage() throws Exception {
      List<WebElement> wels = driver.findElements(By.linkText(page));
      debugLines.add("   Access page, link found: " + !wels.isEmpty() + ", page===" + page + "===");
     
      if (wels.isEmpty()) {
         // retry through login page
         debugLines.add("accessPage: debugLines:   logging in ... ");
         login();
         wels = driver.findElements(By.linkText(page));
         if (wels.isEmpty()) {
            throw new Exception("Page " + page + ": link could not be found.");
         }
      } 
      
      WebElement wel = wels.get(0);
      if (scroll) {
         JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
         javascriptExecutor.executeScript("window.scrollTo(0, (arguments[0].getBoundingClientRect().top + window.pageYOffset) - (window.innerHeight / 2));", wel);
      }
      click(wel);
      WebDriverWait wdw = new WebDriverWait(driver, timeout);
      wdw.until(ExpectedConditions.visibilityOfElementLocated(By.name(tcName)));
      wels = driver.findElements(By.name(tcName));
      if (wels.isEmpty()) {
         throw new Exception("For test case " + tcName + ": no elements found.");
      }
      return wels;
   }

   protected void click(WebElement wel) {
      wel.click();
   }

   /**
    * Analyzes the page based on the test case name and records success or failure.
    */
   protected void checkResults() {

      String resultId = tcName + Constants.RESULT_ID;
      String detailId = tcName + Constants.DETAIL_ID;

      List<WebElement> rels = driver.findElements(By.id(resultId));
      List<WebElement> dels = driver.findElements(By.id(detailId));

      if (!rels.isEmpty()) {

         String res = "";
         try {
            res = rels.get(0).getText();
         } catch(StaleElementReferenceException e) {
            System.out.println(e.getClass().getName() + " caught when trying to use WebElements found with " + resultId);
            rels = driver.findElements(By.id(resultId));
            res = rels.get(0).getText();
         }

         String det = "Test case " + tcName + ": ";
         try {
            det += dels.isEmpty() ? "No details provided." : dels.get(0).getText();
         } catch(StaleElementReferenceException e) {
            System.out.println(e.getClass().getName() + " caught when trying to use WebElements found with " + detailId);
            dels = driver.findElements(By.id(detailId));
            det += dels.isEmpty() ? "No details provided." : dels.get(0).getText();
         }

         boolean ok = res.contains(Constants.SUCCESS);
         debugLines.add("   Test OK: " + ok + ", results: " + res + ", details: " + det);
         assertTrue(det, ok);
      } else {
         debugLines.add("   Results not found");
         assertTrue("Test case " + tcName + " failed. Results could not be found.", false);
      }
   }

   /**
    * Looks for a link or button that can be clicked for the TC and clicks it if found.
    * 
    * First looks for a test case setup link or button and clicks it if found. Then it 
    * looks for a test case execution link and clicks it if found. 
    * 
    * @return  web element list containing the test case results.
    * @throws Exception 
    */
   @SuppressWarnings("unused")
   protected List<WebElement> processClickable(List<WebElement> wels) throws Exception {
      String setupId = tcName + Constants.SETUP_ID;
      String actionId = tcName + Constants.CLICK_ID;
      String resultId = tcName + Constants.RESULT_ID;
      String detailId = tcName + Constants.DETAIL_ID;
      String asyncId = tcName + Constants.ASYNC_ID;
      String notreadyId = tcName + Constants.NOTREADY_ID;
      List<WebElement> tcels = null;

      for (WebElement wel : wels) {
         tcels = wel.findElements(By.id(setupId));
         if (!tcels.isEmpty()) break;
      }
      debugLines.add("   Setup link found: " + ((tcels != null) && !tcels.isEmpty()));
      
      // If were dealing with async, make sure the JavaScript is initialized
      List<WebElement> acels = driver.findElements(By.id(asyncId));
      debugLines.add("   Async elements found: " + ((acels != null) && !acels.isEmpty()));
      if (acels != null && !acels.isEmpty()) {
         WebDriverWait wdw = new WebDriverWait(driver, timeout);
         wdw.until(ExpectedConditions.invisibilityOfElementLocated(By.id(notreadyId)));
         debugLines.add("   Async elements are now ready.");
      }

      // Click setup link if found
      if ((tcels != null) && !tcels.isEmpty()) {
         WebElement wel = tcels.get(0);
         if (scroll) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollTo(0, (arguments[0].getBoundingClientRect().top + window.pageYOffset) - (window.innerHeight / 2));", wel);
         }
         try {
            wel.click();
         } catch(StaleElementReferenceException e) {
            System.out.println("setup link: " + e.getClass().getName() + " caught when trying to use WebElements found with " + tcName);
            wels = driver.findElements(By.name(tcName));
            for (WebElement welly : wels) {
               tcels = welly.findElements(By.id(setupId));
               if (!tcels.isEmpty()) break;
            }
            wel = tcels.get(0);
            wel.click();
         }
         debugLines.add("   Clicked setup link.");

         WebDriverWait wdw = new WebDriverWait(driver, timeout);

         String expr = "//*[@id='" + resultId + "'] | //*[@id='" + actionId + "']";
         debugLines.add("   xpath string: ===" + expr + "===");

         wdw.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(expr)));
         wels = driver.findElements(By.name(tcName));
         
         debugLines.add("   Found elements: " + (!wels.isEmpty()));
         List<WebElement> xels = driver.findElements(By.xpath(expr));
         for (WebElement w : xels) {
            debugLines.add("      Element: " + w.getTagName() + ", id=" + w.getAttribute("id"));
         }
      }
      
      // Now click the action link, if present
      for (WebElement wel : wels) {
         tcels = wel.findElements(By.id(actionId));
         if (!tcels.isEmpty()) break;
      }
      debugLines.add("   Clickable link found: " + ((tcels != null) && !tcels.isEmpty()));
      
      if (tcels != null && !tcels.isEmpty()) {
         WebElement wel = tcels.get(0);
         if (scroll) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollTo(0, (arguments[0].getBoundingClientRect().top + window.pageYOffset) - (window.innerHeight / 2));", wel);
         }
         try {
            wel.click();
         } catch(StaleElementReferenceException e) {
            System.out.println("action link: " + e.getClass().getName() + " caught when trying to use WebElements found with " + tcName);
            wels = driver.findElements(By.name(tcName));
            for (WebElement welly : wels) {
               tcels = welly.findElements(By.id(actionId));
               if (!tcels.isEmpty()) break;
            }
            wel = tcels.get(0);
            wel.click();
         }
         WebDriverWait wdw = new WebDriverWait(driver, timeout);
         wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id(resultId)));
         wels = driver.findElements(By.name(tcName));
         if ((wels == null) || wels.isEmpty()) {
            throw new Exception("Test case " + tcName + " failed. No results after action link click.");
         }
      }
      

      return wels;
   }

   /**
    * Looks for an async element on the page. The async element will be filed in 
    * with results by the test case JavaScript code, which runs asynchronously.  
    * 
    * If an async element is found, this function waits the timeout period to 
    * let the async test case code update the results.
    * 
    * @return  <code>true</code> if async was handled; <code>false</code> otherwise.
    * @throws Exception 
    */
   protected boolean processAsync() throws Exception {
      String asyncId = tcName + Constants.ASYNC_ID;
      String resultId = tcName + Constants.RESULT_ID;

      List<WebElement> tcels = null;

      tcels = driver.findElements(By.id(asyncId));

      debugLines.add("   Element with async id=" + asyncId + " found: " + !tcels.isEmpty());
      
      if (tcels.isEmpty()) {
         // no async element
         return false;
      }

      WebDriverWait wdw = new WebDriverWait(driver, timeout);
      wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id(resultId)));

      return true;
   }

}
