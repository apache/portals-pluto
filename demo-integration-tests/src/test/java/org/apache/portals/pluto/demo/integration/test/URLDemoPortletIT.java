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

import org.junit.Test;

import static org.apache.portals.pluto.demo.integration.test.Util.*;

/**
 *
 * @author Kyle Stiemann
 */
public class URLDemoPortletIT extends ParameterPortletsDemoBase {

   @Test
   public void testURLDemoPortlet() {
      navigateToPage("V3.0 URL Tests");

      // Test copying no params.
      testCustomParameters(1);
      clickElement(driver, waitingAsserter, "//a[contains(text(),'1 Copy no params, 0 new')]");
      assertNoRenderParametersSet(1);

      // Test copying only PRPs.
      Parameter publicRenderParameter = new Parameter("Bild", "Bild1");
      Parameter renderParameter = new Parameter("test1", "test1");
      testParameters(1, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//a[contains(text(),'2 Copy public params, 0 new')]");
      assertParametersSet(1, publicRenderParameter);
      assertParametersNotSet(1, renderParameter);

      // Clear parameters.
      clickElement(driver, waitingAsserter, "//a[contains(text(),'1 Copy no params, 0 new')]");
      assertNoRenderParametersSet(1);

      // Test copying all render parameters.
      testParameters(1, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//a[contains(text(),'3 Copy all params, 0 new')]");
      assertParametersSet(1, publicRenderParameter, renderParameter);

      // Test copying no params and adding 2 params.
      testCustomParameters(1);
      clickElement(driver, waitingAsserter, "//a[contains(text(),'4 Copy no params, 2 new')]");
      Parameter addedParameter1 = new Parameter("1", "1");
      Parameter addedParameter2 = new Parameter("2", "2");
      assertParametersSet(1, addedParameter1, addedParameter2);

      // Clear parameters.
      clickElement(driver, waitingAsserter, "//a[contains(text(),'1 Copy no params, 0 new')]");
      assertNoRenderParametersSet(1);

      // Test copying only PRPs and adding 2 params.
      testParameters(1, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//a[contains(text(),'5 Copy public params, 2 new')]");
      assertParametersSet(1, publicRenderParameter, addedParameter1, addedParameter2);
      assertParametersNotSet(1, renderParameter);

      // Clear parameters.
      clickElement(driver, waitingAsserter, "//a[contains(text(),'1 Copy no params, 0 new')]");
      assertNoRenderParametersSet(1);

      // Test copying all render parameters and adding 2 params.
      testParameters(1, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//a[contains(text(),'6 Copy all params, 2 new')]");
      assertParametersSet(1, publicRenderParameter, renderParameter, addedParameter1, addedParameter2);

      // Test Resource URL cachablility PAGE.
      testParameters(1, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//a[contains(text(),'0 ca=PAGE, 0 res params')]");
      assertParametersSet(1, publicRenderParameter, renderParameter);
      assertNoResourceParametersSet(1);

      // Test Resource URL cachablility PORTLET.
      driver.navigate().back();
      clickElement(driver, waitingAsserter, "//a[contains(text(),'1 ca=PORTLET, 0 res params')]");
      assertParametersSet(1, publicRenderParameter, renderParameter);
      assertNoResourceParametersSet(1);

      // Test Resource URL cachablility FULL.
      driver.navigate().back();
      clickElement(driver, waitingAsserter, "//a[contains(text(),'2 ca=FULL, 0 res params')]");
      assertNoRenderParametersSet(1);
      assertNoResourceParametersSet(1);

      // Test Resource URL cachablility PAGE with 2 resource params.
      driver.navigate().back();
      clickElement(driver, waitingAsserter, "//a[contains(text(),'3 ca=PAGE, 2 res params')]");

      Parameter addedResourceParameter1 = new Parameter("UrlParm-Resource2", Parameter.Type.RESOURCE, "2");
      Parameter addedResourceParameter2 = new Parameter("UrlParm2", Parameter.Type.RESOURCE, "2");
      assertParametersSet(1, publicRenderParameter, renderParameter, addedResourceParameter1,
            addedResourceParameter2);

      // Test Resource URL cachablility PORTLET with 2 resource params.
      driver.navigate().back();
      clickElement(driver, waitingAsserter, "//a[contains(text(),'4 ca=PORTLET, 2 res params')]");
      assertParametersSet(1, publicRenderParameter, renderParameter, addedResourceParameter1,
            addedResourceParameter2);

      // Test Resource URL cachablility FULL with 2 resource params.
      driver.navigate().back();
      clickElement(driver, waitingAsserter, "//a[contains(text(),'5 ca=FULL, 2 res params')]");
      assertNoRenderParametersSet(1);
      assertParametersSet(1, addedResourceParameter1, addedResourceParameter2);

      // Test Action URL Parameters copying all Render Parameters.
      navigateToPage("V3.0 URL Tests");
      testParameters(1, renderParameter);
      assertParametersSet(1,
            new Parameter("acopy", Parameter.Type.ACTION, "acopy_all"),
            new Parameter("pName", Parameter.Type.ACTION, renderParameter.name),
            new Parameter("pValues", Parameter.Type.ACTION, renderParameter.firstValue()),
            new Parameter("setType", Parameter.Type.ACTION, "setVals"));
      assertParametersNotSet(1, Util.unmodifiableList("Render parameters for the last ActionRequest:"),
            renderParameter);
      clickElement(driver, waitingAsserter, getXpath(SEND_BUTTON_XPATH, 1));
      assertParametersSet(1, Util.unmodifiableList("Render parameters for the last ActionRequest:"),
            renderParameter);
      assertParametersNotSet(1, Util.unmodifiableList("Render parameters for the last ActionRequest:"),
            publicRenderParameter);

      // Test Action URL Parameters copying public Render Parameters.
      clickElement(driver, waitingAsserter, "//input[@name='acopy'][@value='acopy_public'][@type='radio']");
      testParameters(1, publicRenderParameter);
      assertParametersSet(1,
            new Parameter("acopy", Parameter.Type.ACTION, "acopy_public"),
            new Parameter("pName", Parameter.Type.ACTION, publicRenderParameter.name),
            new Parameter("pValues", Parameter.Type.ACTION, publicRenderParameter.firstValue()));
      clickElement(driver, waitingAsserter, getXpath(SEND_BUTTON_XPATH, 1));
      assertParametersNotSet(1, Util.unmodifiableList("Render parameters for the last ActionRequest:"),
            renderParameter);
      assertParametersSet(1, Util.unmodifiableList("Render parameters for the last ActionRequest:"),
            publicRenderParameter);

      // Test Action URL Parameters not copying Render Parameters.
      clickElement(driver, waitingAsserter, "//input[@name='acopy'][@value='acopy_none'][@type='radio']");
      testParameters(1, addedParameter1);
      assertParametersSet(1,
            new Parameter("acopy", Parameter.Type.ACTION, "acopy_none"),
            new Parameter("pName", Parameter.Type.ACTION, addedParameter1.name),
            new Parameter("pValues", Parameter.Type.ACTION, addedParameter1.firstValue()));
      clickElement(driver, waitingAsserter, getXpath(SEND_BUTTON_XPATH, 1));
      assertNoParametersSet(1, Util.unmodifiableList("Render parameters for the last ActionRequest:"));
   }
}
