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
package org.apache.portals.pluto.test.utilities;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.LogFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import sun.util.logging.resources.logging;


/**
 * @author nick
 * @author Kyle Stiemann
 *
 */
public class SimpleTestDriver {

   protected static String baseUrl, loginUrl, host, port, testFile, browser,
         username, usernameId, password, passwordId, testContextBase, module;
   protected static int timeout = 3; // for waiting on page load
   protected static boolean useGeneratedUrl = true, debug = false, dryrun = false, scroll;

   protected static WebDriver driver;
   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {

      if (driver == null) {
         loginUrl = System.getProperty("test.server.login.url");
         host = System.getProperty("test.server.host");
         port = System.getProperty("test.server.port");
         username = System.getProperty("test.server.username");
         usernameId = System.getProperty("test.server.username.id");
         password = System.getProperty("test.server.password");
         passwordId = System.getProperty("test.server.password.id");
         browser = System.getProperty("test.browser");
         testContextBase = System.getProperty("test.context.base");
         StringBuilder sb = new StringBuilder();
         sb.append("http://");
         sb.append(host);
         if (port != null && !port.isEmpty()) {
            sb.append(":");
            sb.append(port);
         }
         sb.append("/");
         sb.append(testContextBase);
         baseUrl = sb.toString();
         String str = System.getProperty("test.url.strategy");
         useGeneratedUrl = str.equalsIgnoreCase("generateURLs");
         str = System.getProperty("test.debug");
         debug = str.equalsIgnoreCase("true");
         str = System.getProperty("test.timeout");
         dryrun = Boolean.valueOf(System.getProperty("test.dryrun"));
         timeout = ((str != null) && str.matches("\\d+")) ? Integer.parseInt(str) : 3;
         String wd = System.getProperty("test.browser.webDriver");
         String binary = System.getProperty("test.browser.binary");
         String headlessProperty = System.getProperty("test.browser.headless");
         boolean headless = (((headlessProperty == null) || (headlessProperty.length() == 0) ||
               Boolean.valueOf(headlessProperty)));
         String maximizedProperty = System.getProperty("test.browser.maximized");
         boolean maximized = Boolean.valueOf(maximizedProperty);

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
         System.out.println("   binary       =" + binary);
         System.out.println("   headless     =" + headless);
         System.out.println("   maximized    =" + maximized);

         if (browser.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", wd);
            FirefoxOptions options = new FirefoxOptions();
            options.setLegacy(true);
            options.setAcceptInsecureCerts(true);

            if ((binary != null) && (binary.length() != 0)) {
               options.setBinary(binary);
            }

            if (headless) {
               options.setHeadless(true);
            }

            driver = new FirefoxDriver(options);

         } else if (browser.equalsIgnoreCase("internetExplorer")) {
            System.setProperty("webdriver.ie.driver", wd);
            driver = new InternetExplorerDriver();
         } else if (browser.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", wd);
            ChromeOptions options = new ChromeOptions();

            if ((binary != null) && (binary.length() > 0)) {
               options.setBinary(binary);
            }

            if (headless) {
               options.addArguments("--headless");
            }

            options.addArguments("--disable-infobars");
            options.setAcceptInsecureCerts(true);

            if (maximized) {
               // The webDriver.manage().window().maximize() feature does not work correctly in headless mode, so set the
               // window size to 1920x1200 (resolution of a 15.4 inch screen).
               options.addArguments("--window-size=1920,1200");
            }

            driver = new ChromeDriver(options);

         } else if (browser.equalsIgnoreCase("phantomjs")) {
            DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
            capabilities.setJavascriptEnabled(true);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, binary);
            driver = new PhantomJSDriver(capabilities);
         } else if (browser.equalsIgnoreCase("htmlUnit")) {
           LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
              "org.apache.commons.logging.impl.NoOpLog");
           Logger.getLogger("com.gargoylesoftware").setLevel(Level.SEVERE); 
           Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.SEVERE);
           driver = new HtmlUnitDriver() {
               @Override
               protected WebClient getWebClient() {
                   WebClient webClient = super.getWebClient();
                   WebClientOptions options = webClient.getOptions();
                   options.setThrowExceptionOnFailingStatusCode(false);
                   options.setThrowExceptionOnScriptError(false);
                   options.setPrintContentOnFailingStatusCode(false);
                   webClient.setCssErrorHandler(new SilentCssErrorHandler());
                   return webClient;
               }
           };
         } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
         } else {
            throw new Exception("Unsupported browser: " + browser);
         }

         Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
               driver.quit();
            }
         }));

         if (maximized) {
            driver.manage().window().maximize();
         }

         if (!dryrun) {
            login();
         }
      }
   }

   /**
    * Called to login to the portal if necessary.
    */
   protected static void login() {

      driver.get(loginUrl);

      List<WebElement> uels = driver.findElements(By.id(usernameId));
      List<WebElement> pwels = driver.findElements(By.id(passwordId));

      // If there is no login or password fields, don't need to login.
      if (!uels.isEmpty() && !pwels.isEmpty()) {

         System.out.println("login: found userid and password fields");
         WebElement userEl = uels.get(0);
         WebElement pwEl = pwels.get(0);

         // perform login
         userEl.clear();
         userEl.sendKeys(username);
         pwEl.clear();
         pwEl.sendKeys(password);
         pwEl.submit();

      }
   }

   /**
    * @throws java.lang.Exception
    */
   @AfterClass
   public static void tearDownAfterClass() throws Exception {
      System.out.println("   after class.");
   }

}
