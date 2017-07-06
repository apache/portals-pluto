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

import java.io.File;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
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
   private static int timeout = 3; // for waiting on page load
   private static boolean useGeneratedUrl = true, debug = false, dryrun = false;

   private static WebDriver driver;
   private String page, tcName;
   
   private List<String> debugLines = new ArrayList<>();

   /**
    * Reads the consolidated list of test cases and provides the list to Junit
    * for parameterized testing.
    * @return  a Collection of test cases to run
    */
   @SuppressWarnings("rawtypes")
   @Parameters
   public static Collection getTestList () {
      System.out.println("getTestList");
      testFile = System.getProperty("test.list.file");
      System.out.println("   TestFile=" + testFile);
      module = System.getProperty("test.module");
      System.out.println("   Module       =" + module);
      
      String ignoreFile = System.getProperty("test.ignore.list.file");
      System.out.println("   Ignore file  =" + ignoreFile);
      boolean doIgnore = new Boolean(System.getProperty("test.ignore"));
      System.out.println("   Ignore TCs   =" + doIgnore);
      
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
      } catch (Exception e) {
         System.out.println("Could not read test cases file. Attempted to read file " + testFile);
         e.printStackTrace();
         return null;
      }

      Properties ignoredTCs = new Properties();
      if (doIgnore) {
         try {
            FileInputStream fis = new FileInputStream(ignoreFile);
            ignoredTCs.loadFromXML(fis);
         } catch (Exception e) {
            System.out.println("Could not read test cases file. Attempted to read file " + ignoreFile);
            e.printStackTrace();
            return null;
         }
      }
      System.out.println("   # ignore TCs =" + ignoredTCs.size());
      
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
         // handle ignore list
         if (doIgnore) {
            for (Object itc : ignoredTCs.keySet()) {
               if (tcase.equalsIgnoreCase((String)itc)) {
                  System.out.println("   Ignoring     :" + tcase);
                  continue tcloop;
               }
            }
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
      sb.toString();
      System.out.println("Testing: " + tcName);
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
      str = System.getProperty("test.debug");
      debug = str.equalsIgnoreCase("true");
      str = System.getProperty("test.timeout");
      dryrun = new Boolean(System.getProperty("test.dryrun"));
      timeout = ((str != null) && str.matches("\\d+")) ? Integer.parseInt(str) : 3; 
      String wd = System.getProperty("test.browser.webDriver");
      String binary = System.getProperty("test.browser.binary");
      String headlessString = System.getProperty("test.browser.headless");
      System.err.println("   headlessString     =" + headlessString);

      // Assume that chrome can run headless unless specified false
      if ((headlessString == null || "".equalsIgnoreCase(headlessString)) &&
              browser.equalsIgnoreCase("chrome")) {
         headlessString = "true";
      }
      boolean headless = Boolean.parseBoolean(headlessString);

      System.out.println("before class.");
      System.out.println("   Debug        =" + debug);
      System.out.println("   Dryrun       =" + dryrun);
      System.out.println("   Timeout      =" + timeout);
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
      System.out.println("   binary       =" + binary + " ... used for ChromeDriver & FirefoxDriver only, for now");
      System.out.println("   headless     =" + headless);

      if (browser.equalsIgnoreCase("firefox")) {
         if (binary == null || "".equalsIgnoreCase(binary)) {
            driver = new FirefoxDriver(new FirefoxProfile());
         } else {
            driver = new FirefoxDriver(new FirefoxBinary(new File(binary)), new FirefoxProfile());
         }
      } else if (browser.equalsIgnoreCase("internetExplorer")) {
         System.setProperty("webdriver.ie.driver", wd);
         driver = new InternetExplorerDriver();
      } else if (browser.equalsIgnoreCase("chrome")) {
         System.setProperty("webdriver.chrome.driver", wd);
         ChromeOptions options = new ChromeOptions();
         if (!(binary == null || "".equalsIgnoreCase(binary))) {
            options.setBinary(binary);
         }
         if (headless) {
            options.addArguments("--headless");
            options.addArguments("--disable-infobars");
         }
         driver = new ChromeDriver(options);
      } else if (browser.equalsIgnoreCase("phantomjs")) {
         DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
         capabilities.setJavascriptEnabled(true);
         capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, binary);
         driver = new PhantomJSDriver(capabilities);
      } else if (browser.equalsIgnoreCase("htmlUnit")) {
        driver = new HtmlUnitDriver(true);
      } else if (browser.equalsIgnoreCase("safari")) {
         driver = new SafariDriver();
      } else {
         throw new Exception("Unsupported browser: " + browser);
      }

      if (!dryrun) {
         login();
      }

   }

   /**
    * @throws java.lang.Exception
    */
   @AfterClass
   public static void tearDownAfterClass() throws Exception {
      if (driver != null) {
         driver.quit();
      }
      System.out.println("   after class.");
   }

   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception {
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
         
         checkResults(wels);

      } catch(Exception e) {
         
         // Some type of unexpected error occurred, so generate text
         // and mark the TC as failed.
         
         System.out.println("   Exception occurred: " + e.getMessage());
         for (String line : debugLines) {
            System.out.println(line);
         }
         
         assertTrue("Test case " + tcName + " failed. " +  
               " Setup link could not be accessed. \nException: " + e.toString(), false);
      }
   }

   /**
    * Tries to access the page for the test case. Looks for the page link
    * and clicks it, waiting for the page to load.
    * 
    * @return  a list of elements for the TC (should only be one)
    */
   private List<WebElement> accessPage() throws Exception {
      List<WebElement> wels = driver.findElements(By.linkText(page));
      debugLines.add("   Access page, link found: " + !wels.isEmpty() + ", page===" + page + "===");
     
      if (wels.isEmpty()) {
         // retry through login page
         debugLines.add("   logging in ... ");
         login();
         wels = driver.findElements(By.linkText(page));
         if (wels.isEmpty()) {
            throw new Exception("Page " + page + ": link could not be found.");
         }
      } 
      
      WebElement wel = wels.get(0);
      wel.click();
      WebDriverWait wdw = new WebDriverWait(driver, timeout);
      wdw.until(ExpectedConditions.visibilityOfElementLocated(By.name(tcName)));
      wels = driver.findElements(By.name(tcName));
      if (wels.isEmpty()) {
         throw new Exception("For test case " + tcName + ": no elements found.");
      }
      return wels;
   }

   /**
    * Called to login to the portal if necessary. 
    */
   private static void login() {

      driver.get(loginUrl);
      
      List<WebElement> uels = driver.findElements(By.id(usernameId));
      List<WebElement> pwels = driver.findElements(By.id(passwordId));

      // If there is no login or password fields, don't need to login.
      if (!uels.isEmpty() && !pwels.isEmpty()) {

         System.out.println("   No userid / password fields");
         WebElement userEl = uels.get(0);
         WebElement pwEl = pwels.get(0);

         // perform login
         userEl.sendKeys(username);
         pwEl.sendKeys(password);
         pwEl.submit();

      }
   }

   /**
    * Analyzes the page based on the test case name and records success or failure.
    */
   private void checkResults(List<WebElement> tcels) {
      String resultId = tcName + Constants.RESULT_ID;
      String detailId = tcName + Constants.DETAIL_ID;

      debugLines.add("   Checking results, #TC elements: " + tcels.size());

      List<WebElement> rels = driver.findElements(By.id(resultId)); 
      List<WebElement> dels = driver.findElements(By.id(detailId)); 
      
      if (!rels.isEmpty()) {
         String res = rels.get(0).getText();
         String det = "Test case " + tcName + ": ";
         det += dels.isEmpty() ? "No details provided." : dels.get(0).getText(); 
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
   private List<WebElement> processClickable(List<WebElement> wels) throws Exception {
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
         wel.click();
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
         wel.click();
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
   private boolean processAsync() throws Exception {
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
