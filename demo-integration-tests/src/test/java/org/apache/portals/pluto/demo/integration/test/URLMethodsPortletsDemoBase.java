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

import static org.apache.portals.pluto.demo.integration.test.Util.*;

/**
 *
 * @author Kyle Stiemann
 */
public class URLMethodsPortletsDemoBase extends ParameterPortletsDemoBase {

   protected final void testURLMethods(int portletNumber, String linkButtonTagName, Parameter publicRenderParameter) {

      // Test copying no params.
      navigateToPage("V3.0 Render URL Parameter Tests");
      testCustomParameters(portletNumber);

      // Clear parameters.
      navigateToPage("V3.0 Render URL Parameter Tests");

      // Test no render parameters.
      Parameter renderParameter = new Parameter("test1", "test1");
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'1 No render parameters')]");
      assertNoRenderParametersSet(portletNumber);

      // Test copy render parameters.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'2 Copy with req clone')]");
      assertParametersSet(portletNumber, publicRenderParameter, renderParameter);

      // Test copy render parameters and add 1.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter,
            "//" + linkButtonTagName + "[contains(text(),'3 Copy with req clone, 1 addl')]");

      Parameter addedParam1 = new Parameter("UParm1", "1");
      assertParametersSet(portletNumber, publicRenderParameter, renderParameter, addedParam1);

      // Test clear private render parameters.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'4 Clear private')]");
      assertParametersSet(portletNumber, publicRenderParameter);
      assertParametersNotSet(portletNumber, renderParameter);

      // Test clear public render parameters.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'5 Clear public')]");
      assertParametersNotSet(portletNumber, publicRenderParameter);
      assertParametersSet(portletNumber, renderParameter);

      // Test clear all render parameters.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'6 Clear all')]");
      assertNoRenderParametersSet(portletNumber);

      // Test clear clone private render parameters.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'7 Clear clone private')]");
      assertParametersSet(portletNumber, publicRenderParameter);
      assertParametersNotSet(portletNumber, renderParameter);

      // Test clear clone public render parameters.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'8 Clear clone public')]");
      assertParametersNotSet(portletNumber, publicRenderParameter);
      assertParametersSet(portletNumber, renderParameter);

      // Test clear all clone render parameters.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'9 Clear clone all')]");
      assertNoRenderParametersSet(portletNumber);

      // Test clone render parameters and add 1.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'A Add thru clone 1')]");
      assertParametersSet(portletNumber, publicRenderParameter, renderParameter, addedParam1);

      // Test clone render parameters and add 2.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'B Add thru clone 2')]");

      Parameter addedParam2 = new Parameter("UParm2", "2");
      Parameter addedParam3 = new Parameter("UParm3", "3");
      assertParametersSet(portletNumber, publicRenderParameter, renderParameter, addedParam1, addedParam2,
            addedParam3);

      // Test clone render render parameters and add 3.
      testParameters(portletNumber, publicRenderParameter, renderParameter);
      clickElement(driver, waitingAsserter, "//" + linkButtonTagName + "[contains(text(),'C Add thru clone 3')]");

      Parameter addedParam4 = new Parameter("UParm4", "4");
      Parameter addedParam5 = new Parameter("UParm5", "5");
      Parameter addedParam6 = new Parameter("UParm6", "6");
      assertParametersSet(portletNumber, publicRenderParameter, renderParameter, addedParam1, addedParam2,
            addedParam3, addedParam4, addedParam5, addedParam6);
   }
}
