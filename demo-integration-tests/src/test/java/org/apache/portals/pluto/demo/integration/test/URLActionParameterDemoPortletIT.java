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
public class URLActionParameterDemoPortletIT extends URLMethodsPortletsDemoBase {

   @Test
   public void testURLActionParameterDemoPortlet() {

      Parameter publicRenderParameter = new Parameter("Bild", "Bild1");
      testURLMethods(2, "button", publicRenderParameter);

      // Verify that the public render parameter is available to all portlets on the page.
      assertParametersSet(1, publicRenderParameter);

      // Test no action parameters.
      navigateToPage("V3.0 Render URL Parameter Tests");
      clickElement(driver, waitingAsserter, "//button[@type='submit'][contains(text(),'5 AP Add thru clone 3')]");

      Parameter addedParam1 = new Parameter("UParm1", "1");
      Parameter addedParam2 = new Parameter("UParm2", "2");
      Parameter addedParam3 = new Parameter("UParm3", "3");
      assertParametersSet(2, addedParam1, addedParam2, addedParam3);

      clickElement(driver, waitingAsserter, "//button[@type='submit'][contains(text(),'1 No action parameters')]");
      assertNoActionParametersSet(2);

      // Test set and clear action parameters.
      clickElement(driver, waitingAsserter, "//button[@type='submit'][contains(text(),'5 AP Add thru clone 3')]");
      assertParametersSet(2, addedParam1, addedParam2, addedParam3);

      clickElement(driver, waitingAsserter,
            "//button[@type='submit'][contains(text(),'2 set & clear action params')]");
      assertNoActionParametersSet(2);

      // Test clear clone all action parameters.
      clickElement(driver, waitingAsserter, "//button[@type='submit'][contains(text(),'5 AP Add thru clone 3')]");
      assertParametersSet(2, addedParam1, addedParam2, addedParam3);

      clickElement(driver, waitingAsserter, "//button[@type='submit'][contains(text(),'3 AP Clear clone all')]");
      assertNoActionParametersSet(2);

      // Test add thru clone 2 action parameters.
      clickElement(driver, waitingAsserter, "//button[@type='submit'][contains(text(),'4 AP Add thru clone 2')]");
      assertParametersSet(2, new Parameter(addedParam1.name, addedParam1.firstValue(), "2"), addedParam3);
   }
}
