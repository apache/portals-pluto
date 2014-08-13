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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.portlet.tck.constants.Constants;


/**
 * @author nick
 *
 */
@RunWith(value = Parameterized.class)
public class TCKSimpleTestDriver {

   private static String loginUrl, host, port, testFile, browser, 
   username, usernameId, password, passwordId, testContextBase, module;
   
   // used to optimize access for tests on the same page
   private static String lastPage = "";

   private static boolean useGeneratedUrl = true;

   private static WebDriver driver;
   private String page, tcName, testUrl;

   /**
    * Reads the consolidated list of test cases and provides the list to Junit
    * for parameterized testing.
    * @return  a Collection of test cases to run
    */
   @Parameters
   public static Collection getTestList () {
      System.out.println("getTestList");
      testFile = System.getProperty("test.list.file");
      System.out.println("   TestFile=" + testFile);
      module = System.getProperty("test.module");
      System.out.println("   Module       =" + module);

      Properties tprops = new Properties();
      try {
         FileInputStream fis = new FileInputStream(testFile);
         tprops.loadFromXML(fis);
      } catch (Exception e) {
         System.out.println("Could not read test cases file. Attempted to read file " + testFile);
         e.printStackTrace();
         return null;
      }
      
      // See if performance can be improved by sorting the test cases by
      // the page to be accessed. The map uses the page as key and has a 
      // set of test cases for that page as value.
      
      TreeMap<String, Set<String>> pages = new TreeMap<String, Set<String>>();
      Set<Object> tcs = tprops.keySet();
      for (Object o : tcs) {
         String tcase = (String) o ;
         if (module == null || module.length() <= 0 || tcase.contains(module)) {
            String tpage = tprops.getProperty(tcase);
            if (!pages.containsKey(tpage)) {
               pages.put(tpage, new TreeSet<String>());
            }
            pages.get(tpage).add(tcase);
         }
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
      System.out.println("Executing " + numTC + " tests on " + numP + "pages.");

      return tests;
   }

   public TCKSimpleTestDriver(String p, String t) {
      page = p;
      tcName = t;
      StringBuilder sb = new StringBuilder();
      sb.append("http://");
      sb.append(host);
      if (port != null && !port.isEmpty()) {
         sb.append(":");
         sb.append(port);
      }
      sb.append("/");
      sb.append(testContextBase);
      sb.append(page);
      testUrl = sb.toString();
      System.out.println("Constructor - Navigating to page: " + testUrl + ", test: " + tcName);
   }

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      loginUrl = System.getProperty("test.server.login.url");
      host = System.getProperty("test.server.host");
      port = System.getProperty("test.server.port");
      username = System.getProperty("test.server.username");
      usernameId = System.getProperty("test.server.username.id");
      password = System.getProperty("test.server.password");
      passwordId = System.getProperty("test.server.password.id");
      browser = System.getProperty("test.browser");
      testContextBase = System.getProperty("test.context.base");
      String str = System.getProperty("test.url.strategy");
      useGeneratedUrl = str.equalsIgnoreCase("generateURLs");
      String wd = System.getProperty("test.browser.webDriver");

      System.out.println("before class.");
      System.out.println("   Login URL    =" + loginUrl);
      System.out.println("   Host         =" + host);
      System.out.println("   Port         =" + port);
      System.out.println("   Context      =" + testContextBase);
      System.out.println("   Generate URL =" + useGeneratedUrl);
      System.out.println("   Username     =" + username);
      System.out.println("   UsernameId   =" + usernameId);
      System.out.println("   Password     =" + password);
      System.out.println("   PasswordId   =" + passwordId);
      System.out.println("   Browser      =" + browser);
      System.out.println("   Driver       =" + wd);

      if (browser.equalsIgnoreCase("firefox")) {
         driver = new FirefoxDriver();
      } else if (browser.equalsIgnoreCase("internetExplorer")) {
         System.setProperty("webdriver.ie.driver", wd);
         driver = new InternetExplorerDriver();
      } else if (browser.equalsIgnoreCase("chrome")) {
         System.setProperty("webdriver.chrome.driver", wd);
         driver = new ChromeDriver();
      } else if (browser.equalsIgnoreCase("htmlUnit")) {
         driver = new HtmlUnitDriver(true);
      } else if (browser.equalsIgnoreCase("safari")) {
         driver = new SafariDriver();
      } else {
         throw new Exception("Unsupported browser: " + browser);
      }
      
      lastPage = "";
      login();

   }

   /**
    * @throws java.lang.Exception
    */
   @AfterClass
   public static void tearDownAfterClass() throws Exception {
      if (driver != null) {
         driver.quit();
      }
      System.out.println("after class.");
   }

   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception {
      System.out.println("before test.");
   }

   /**
    * @throws java.lang.Exception
    */
   @After
   public void tearDown() throws Exception {
      System.out.println("after test.");
   }

   @Test
   public void test() {
      System.out.println("execute test.");
      String actionId = tcName + Constants.CLICK_ID;
      String resultId = tcName + Constants.RESULT_ID;
      String detailId = tcName + Constants.DETAIL_ID;
      
      // This is optimized for many results being present on the same page.
      // First look for the test results or links already being present on the page. 
      
      List<WebElement> wels = driver.findElements(By.name(tcName));
      System.out.println("begin: wels.size=" + wels.size() + ", tcname===" + tcName + "===");
      if (wels.isEmpty()) {
         wels = accessPage();
         System.out.println("after ap: wels.size=" + wels.size() + ", tcname===" + tcName + "===");
         if ((wels == null) || wels.isEmpty()) {
            return;     // errors are handled in accessPage routine
         } 
      }
      
      // Test case results or links are on the page. check for results first.
      List<WebElement> tcels = null;
      for (WebElement wel : wels) {
         tcels = wel.findElements(By.id(resultId));
         if (!tcels.isEmpty()) break;
      }

      // if results aren't there, see if there is a link to be clicked
      if (tcels.isEmpty()) {
         wels = processClickable(wels);
         if ((wels == null) || wels.isEmpty()) {
            return;      // errors are handled in processClickable routine
         }
      }

      checkResults(wels);
   }

   /**
    * Tries to access the page for the test case. Looks for the page link
    * and clicks it, waiting for the page to load.
    * 
    * @return  a list of elements for the TC (should only be one)
    */
   private List<WebElement> accessPage() {
      List<WebElement> wels = driver.findElements(By.linkText(page));
      System.out.println(" in ap: wels.size=" + wels.size() + ", page===" + page + "===");
      if (wels.isEmpty()) {
         //todo - retry through login page
         assertTrue("Test case " + tcName + " failed. Page " + page 
               + " link could not be found. ", false);
      } else {
         WebElement wel = wels.get(0);
         System.out.println("in ap: wel.text===" + wel.getText() + "===, tag===" + wel.getTagName() + "===");
         wel.click();
         try {
            WebDriverWait wdw = new WebDriverWait(driver, 3);
            wdw.until(ExpectedConditions.visibilityOfElementLocated(By.name(tcName)));
            wels = driver.findElements(By.name(tcName));
            System.out.println("in ap: after until #wels=" + wels.size());
         } catch(Exception e) {
            assertTrue("Test case " + tcName + " failed. Page " + page 
                  + " link could not be accessed. Timeout. ", false);
            wels.clear();
         }
      }
      return wels;
   }

   /**
    * Called to login to the portal if necessary. 
    */
   private static void login() {

      driver.get(loginUrl);

      // If there is no login or password fields, don't need to login.
      // find element will throw an exception if element can't be found.
      try {

         WebElement userEl = driver.findElement(By.ById.id(usernameId));
         WebElement pwEl = driver.findElement(By.ById.id(passwordId));

         // perform login
         userEl.sendKeys(username);
         pwEl.sendKeys(password);
         pwEl.submit();

      } catch(Exception e) {
      }
   }

   /**
    * Analyzes the page based on the test case name and records success or failure.
    */
   private void checkResults(List<WebElement> tcels) {
      String resultId = tcName + Constants.RESULT_ID;
      String detailId = tcName + Constants.DETAIL_ID;
      
      List<WebElement> rels = null;
      List<WebElement> dels = null;
      System.out.println("#tcels=" + tcels.size() + ", 1st name=" + tcels.get(0).getText());
      for (WebElement wel : tcels) {
         rels = wel.findElements(By.id(resultId));
         dels = wel.findElements(By.id(detailId));
         System.out.println("Loop: #rels=" + rels.size() + ", #dels=" + dels.size());
         if (!rels.isEmpty() && !dels.isEmpty()) break;
      }
      
      if (!rels.isEmpty() && !dels.isEmpty()) {
         String res = rels.get(0).getText();
         String det = "Test case " + tcName + " failed. " + dels.get(0).getText();
         boolean ok = res.contains(Constants.SUCCESS);
         assertTrue(det, ok);
      } else {
         System.out.println("Not found: #rels=" + rels.size() + ", #dels=" + dels.size());
         assertTrue("Test case " + tcName + " failed. Results could not be found.", false);
      }
   }

   /**
    * Looks for a link or button that can be clicked for the TC and clicks it if found.
    */
   @SuppressWarnings("unused")
   private List<WebElement> processClickable(List<WebElement> wels) {
      String actionId = tcName + Constants.CLICK_ID;
      String resultId = tcName + Constants.RESULT_ID;
      String detailId = tcName + Constants.DETAIL_ID;
      
      List<WebElement> tcels = null;
      for (WebElement wel : wels) {
         tcels = wel.findElements(By.id(actionId));
         if (!tcels.isEmpty()) break;
      }
      
      if ((tcels == null) || tcels.isEmpty()) {
         assertTrue("Test case " + tcName + " failed. TCK error - Unknown TC content.", false);
         return tcels;
      }
      
      WebElement wel = tcels.get(0);
      wel.click();
      try {
         WebDriverWait wdw = new WebDriverWait(driver, 3);
         wdw.until(ExpectedConditions.visibilityOfElementLocated(By.id(resultId)));
         tcels = driver.findElements(By.name(tcName));
      } catch(Exception e) {
         assertTrue("Test case " + tcName + " failed. Test case " + tcName 
               + " link could not be accessed. Timeout. ", false);
         tcels.clear();
      }
      
      return tcels;
   }

}
