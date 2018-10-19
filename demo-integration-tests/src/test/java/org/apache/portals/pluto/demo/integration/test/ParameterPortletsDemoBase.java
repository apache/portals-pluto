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

import java.util.List;
import org.openqa.selenium.By;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 *
 * @author Kyle Stiemann
 */
public class ParameterPortletsDemoBase extends DemoTestDriver {
   protected static final String SEND_BUTTON_XPATH = "//input[@value='send'][@type='submit']";

   private static final List<String> ACTION_PARAMETERS_TABLE_TITLES =
         Util.unmodifiableList("Action parameters for the last ActionRequest:");
   private static final String REMOVE_PARAMETER_CHECKBOX_XPATH =
         "//input[@name='remType'][@value='remPRP'][@type='checkbox']";
   private static final List<String> RENDER_PARAMETERS_TABLE_TITLES =
         Util.unmodifiableList("Currently set render parameters:", "Render parameters for the ResourceRequest:");
   private static final List<String> RESOURCE_PARAMETERS_TABLE_TITLES =
         Util.unmodifiableList("Resource parameters for the ResourceRequest:");
   private static final String SINGLE_VALUE_RADIO_BUTTON_XPATH =
         "//input[@name='setType'][@value='setVal'][@type='radio']";
   private static final String VALUE_ARRAYS_RADIO_BUTTON_XPATH =
         "//input[@name='setType'][@value='setVals'][@type='radio']";

   protected final void testCustomParameters() {
      testCustomParameters(1);
   }

   protected final void testCustomParameters(int portletNumber) {

      assertNoRenderParametersSet(portletNumber);
      clickElement(driver, waitingAsserter,
            getXpath(SEND_BUTTON_XPATH, portletNumber));
      assertNoRenderParametersSet(portletNumber);
      clickElement(driver, waitingAsserter,
            getXpath(SINGLE_VALUE_RADIO_BUTTON_XPATH, portletNumber));
      testParameter(portletNumber, "test1", "v1");
      testParameter(portletNumber, "test1", "v2", "v3", "v4");
      clickElement(driver, waitingAsserter, getXpath(REMOVE_PARAMETER_CHECKBOX_XPATH, portletNumber));
      testParameter(portletNumber, "test1", "v1");
      clickElement(driver, waitingAsserter, getXpath(REMOVE_PARAMETER_CHECKBOX_XPATH, portletNumber));
      testParameter(portletNumber, "test1", "v1");
      clickElement(driver, waitingAsserter,
            getXpath(VALUE_ARRAYS_RADIO_BUTTON_XPATH, portletNumber));
      testParameter(portletNumber, "test1", "v2", "v3", "v4");
      testParameter(portletNumber, "test2", "null");
      testParameter(portletNumber, "test3", "empty");
      testParameter(portletNumber, "Bild", "Bild1");
   }

   protected final void testParameters(int portletNumber, Parameter... parameters) {

      for (Parameter parameter : parameters) {

         sendKeysToElement(driver, waitingAsserter, getXpath("//input[@name='pName'][@type='text']", portletNumber),
               parameter.name);
         sendKeysToElement(driver, waitingAsserter,
               getXpath("//input[@name='pValues'][@type='text']", portletNumber), parameter.values.toString());
         clickElement(driver, waitingAsserter, getXpath(SEND_BUTTON_XPATH, portletNumber));
         boolean removeParameter =
               driver.findElement(By.xpath(getXpath(REMOVE_PARAMETER_CHECKBOX_XPATH, portletNumber))).isSelected();

         if (removeParameter) {
            assertParametersNotSet(portletNumber, parameter);
         }
         else {
            assertParametersSet(portletNumber, parameter);
         }
      }
   }

   protected final void assertNoActionParametersSet(int portletNumber) {
      assertNoParametersSet(1, ACTION_PARAMETERS_TABLE_TITLES);
   }

   protected final void assertNoParametersSet(int portletNumber, List<String> parametersTableTitles) {

      String parametersXpath = getParametersTableXpath(portletNumber, parametersTableTitles) + "/td";
      waitingAsserter.assertTrue(or(not(presenceOfAllElementsLocatedBy(By.xpath(parametersXpath))), 
            invisibilityOfElementLocated(By.xpath(parametersXpath)),
            visibilityOfElementLocated(By.xpath(getParameterTableRowXpath(portletNumber,
                  new Parameter("No parameters available!", "No parameters available!"))))));
   }

   protected final void assertNoRenderParametersSet(int portletNumber) {
      assertNoParametersSet(1, RENDER_PARAMETERS_TABLE_TITLES);
   }

   protected final void assertNoResourceParametersSet(int portletNumber) {
      assertNoParametersSet(1, RESOURCE_PARAMETERS_TABLE_TITLES);
   }

   protected final void assertParametersNotSet(int portletNumber, Parameter... parameters) {
      assertParametersNotSet(portletNumber, null, parameters);
   }

   protected final void assertParametersNotSet(int portletNumber, List<String> parametersTableTitles,
         Parameter... parameters) {

      if (parameters.length == 0) {
         throw new NullPointerException();
      }

      for (Parameter parameter : parameters) {
         String renderParameterTableRowXpath = getParameterTableRowXpath(portletNumber, parametersTableTitles,
               parameter);
         waitingAsserter.assertTrue(or(not(presenceOfAllElementsLocatedBy(By.xpath(renderParameterTableRowXpath))),
               invisibilityOfElementLocated(By.xpath(renderParameterTableRowXpath))));
      }
   }

   protected final void assertParametersSet(int portletNumber, Parameter... parameters) {
      assertParametersSet(portletNumber, null, parameters);
   }

   protected final void assertParametersSet(int portletNumber, List<String> parametersTableTitles,
         Parameter... parameters) {

      if (parameters.length == 0) {
         throw new NullPointerException();
      }

      for (Parameter parameter : parameters) {
         waitingAsserter.assertTrue(visibilityOfElementLocated(By.xpath(
               getParameterTableRowXpath(portletNumber, parametersTableTitles, parameter))));
      }
   }

   private void testParameter(int portletNumber, String paramName, String... paramValues) {

      boolean expectSingleValue = driver.findElement(By.xpath(
            getXpath(SINGLE_VALUE_RADIO_BUTTON_XPATH, portletNumber))).isSelected();
      Parameter parameter = new Parameter(expectSingleValue, paramName, paramValues);
      testParameters(portletNumber, parameter);
   }

   protected static String getParameterTableRowXpath(int portletNumber, Parameter parameter) {
      return getParameterTableRowXpath(portletNumber, null, parameter);
   }

   protected static String getParameterTableRowXpath(int portletNumber, List<String> passedParametersTableTitles,
         Parameter parameter) {

      List<String> parametersTableTitles = passedParametersTableTitles;

      if (passedParametersTableTitles == null) {
         if (Parameter.Type.RENDER.equals(parameter.type)) {
            parametersTableTitles = RENDER_PARAMETERS_TABLE_TITLES;
         }
         else if (Parameter.Type.ACTION.equals(parameter.type)) {
            parametersTableTitles = ACTION_PARAMETERS_TABLE_TITLES;
         }
         else if (Parameter.Type.RESOURCE.equals(parameter.type)) {
            parametersTableTitles = RESOURCE_PARAMETERS_TABLE_TITLES;
         }
      }

      List<String> expectedValues = parameter.values.getExpectedValues();
      StringBuilder expectedValuesStringBuilder = new StringBuilder();

      for (String expectedValue : expectedValues) {
         expectedValuesStringBuilder.append("[contains(text(),'");
         expectedValuesStringBuilder.append(expectedValue);
         expectedValuesStringBuilder.append("')]");
      }

      return getParametersTableXpath(portletNumber, parametersTableTitles) +
            "//td[contains(text(),'Name:')][contains(text(),'" + parameter.name + "')]" +
            "/following-sibling::td[contains(text(),'Val:')][contains(text(),'" + parameter.values.first() + "')]" +
            "/following-sibling::td[contains(text(),'Len:')]" +
                  "[contains(text(),'" + parameter.values.getExpectedLength() + "')]" +
            "/following-sibling::td[contains(text(),'Values:')]" + expectedValuesStringBuilder;
   }

   protected static String getParametersTableXpath(int portletNumber, List<String> parametersTableTitles) {

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("//h3[");

      for (int i = 0; i < parametersTableTitles.size(); i++) {

         if (i > 0) {
            stringBuilder.append(" or ");
         }

         stringBuilder.append("contains(text(),'")
               .append(parametersTableTitles.get(i))
               .append("')");
      }

      stringBuilder.append("]");

      return getXpath(stringBuilder.toString(), portletNumber) + "/following-sibling::div/table";
   }

   protected static String getXpath(String xpath, int portletNumber) {
      return "(" + xpath + ")[" + portletNumber + "]";
   }

   protected static final class Parameter {

      protected static enum Type {
         ACTION,
         RENDER,
         RESOURCE
      }

      protected final String name;
      protected final Type type;

      private final Values values;

      protected Parameter(String name, String... values) {
         this(name, Type.RENDER, values);
      }

      protected Parameter(String name, Type type, String... values) {
         this.name = name;
         this.values = new Values(false, values);
         this.type = type;
      }

      private Parameter(boolean expectSingleValue, String name, String... values) {
         this.name = name;
         this.values = new Values(expectSingleValue, values);
         this.type = Type.RENDER;
      }

      protected String firstValue() {
         return values.first();
      }
   }

   private static final class Values {

      private final boolean expectSingleValue;
      private final String[] values;

      private Values(boolean expectSingleValue, String... values) {
         this.expectSingleValue = expectSingleValue;
         this.values = values;
      }

      private String first() {

         if ("empty".equals(values[0])) {
            return "null";
         }
         else {
            return values[0];
         }
      }

      private int getExpectedLength() {

         if ("empty".equals(values[0])) {
            return 0;
         }
         else if (expectSingleValue) {
            return 1;
         }
         else { 
            return values.length;
         }
      }

      private List<String> getExpectedValues() {

         if ("empty".equals(values[0])) {
            return Util.unmodifiableList("[]");
         }
         else if (expectSingleValue) {
            return Util.unmodifiableList(first());
         }
         else {
            return Util.unmodifiableList(values);
         }
      }

      @Override
      public String toString() {

         StringBuilder stringBuilder = new StringBuilder();

         for (String value : values) {

            if (stringBuilder.length() > 0) {
               stringBuilder.append(", ");
            }

            stringBuilder.append(value);
         }

         return stringBuilder.toString();
      }
   }
}
