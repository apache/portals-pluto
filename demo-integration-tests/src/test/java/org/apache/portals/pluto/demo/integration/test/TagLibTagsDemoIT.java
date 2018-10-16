/*	Licensed to the Apache Software Foundation (ASF) under one
 *	or more contributor license agreements.	See the NOTICE file
 *	distributed with this work for additional information
 *	regarding copyright ownership.	The ASF licenses this file
 *	to you under the Apache License, Version 2.0 (the
 *	"License"); you may not use this file except in compliance
 *	with the License.	You may obtain a copy of the License at
 *
 *	 http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing,
 *	software distributed under the License is distributed on an
 *	"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *	KIND, either express or implied.	See the License for the
 *	specific language governing permissions and limitations
 *	under the License.
 */
package org.apache.portals.pluto.demo.integration.test;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.apache.portals.pluto.demo.integration.test.Util.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 *
 * @author Kyle Stiemann
 */
public class TagLibTagsDemoIT extends DemoTestDriver {

	private static final String BUTTON_LINK_XPATH_TEMPLATE =
			"//*[local-name()='a' or local-name()='button'][contains(text(),'{0}')]";

	@Test
	public void testTagLibTagsDemo() {
		navigateToPage("Tag Library");

		testRenderURLs();
		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "Copy & add res param pr3=vr3"));
		assertRenderParametersSet(new Parameter("p1", "v1"), new Parameter("p2", "v2"), new Parameter("addrp", "true"));
		assertNoParametersSet("Action");
		assertParametersSet("Resource", new Parameter("pr3", "vr3"));

		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "Copy & add res param pr3=vr3"));
		assertRenderParametersSet(new Parameter("p1", "v1"), new Parameter("p2", "v2"),
				new Parameter("addrp", "true, true"));
		assertNoParametersSet("Action");
		assertParametersSet("Resource", new Parameter("pr3", "vr3"));

		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "Copy & add res param pr3=vr3"));
		assertRenderParametersSet(new Parameter("p1", "v1"), new Parameter("p2", "v2"),
				new Parameter("addrp", "true, true, true"));
		assertNoParametersSet("Action");
		assertParametersSet("Resource", new Parameter("pr3", "vr3"));

		clickElement(driver, waitingAsserter,
				"(" + BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "action pa7=va7 & render pr6=vr6") + ")[2]");
		assertRenderParametersSet(new Parameter("p1", "v1"), new Parameter("p2", "v2"),
				new Parameter("addrp", "true, true, true"), new Parameter("pr6", "vr6"));
		assertParametersSet("Action", new Parameter("pa7", "va7"));
		assertParametersSet("Resource", new Parameter("pr3", "vr3"));

		testRenderURLs();
		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "add resource parameter pr3=vr3"));
		assertRenderParametersSet(new Parameter("addrp", "true"));
		assertNoParametersSet("Action");
		assertParametersSet("Resource", new Parameter("pr3", "vr3"));

		testRenderURLs();
		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "Action, no parameters"));
		assertNoRenderParametersSet();
		assertNoParametersSet("Action");
		assertNoParametersSet("Resource");

		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "render param pr5=vr5"));
		assertRenderParametersSet(new Parameter("pr5", "vr5"));
		assertNoParametersSet("Action");
		assertNoParametersSet("Resource");

		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "action pa4=va4"));
		assertNoRenderParametersSet();
		assertParametersSet("Action", new Parameter("pa4", "va4"));
		assertNoParametersSet("Resource");

		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "action pa7=va7 & render pr6=vr6"));
		assertRenderParametersSet(new Parameter("pr6", "vr6"));
		assertParametersSet("Action", new Parameter("pa7", "va7"));
		assertNoParametersSet("Resource");

		testRenderURLs();
		clickElement(driver, waitingAsserter,
				"(" + BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "action pa7=va7 & render pr6=vr6") + ")[2]");
		clickElement(driver, waitingAsserter,
				"(" + BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "action pa4=va4") + ")[2]");
		assertRenderParametersSet(new Parameter("p1", "v1"), new Parameter("p2", "v2"), new Parameter("pr6", "vr6"));
		assertParametersSet("Action", new Parameter("pa4", "va4"));
		assertNoParametersSet("Resource");
	}

	private void testRenderURLs() {

		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "No parameters"));
		assertNoRenderParametersSet();
		assertNoParametersSet("Action");
		assertNoParametersSet("Resource");
		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "Add parameter p1=v1"));
		assertRenderParametersSet(new Parameter("p1", "v1"));
		assertNoParametersSet("Action");
		assertNoParametersSet("Resource");
		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "Copy parameters"));
		assertRenderParametersSet(new Parameter("p1", "v1"));
		assertNoParametersSet("Action");
		assertNoParametersSet("Resource");
		clickElement(driver, waitingAsserter,
				BUTTON_LINK_XPATH_TEMPLATE.replace("{0}", "Copy parameters & add p2=v2"));
		assertRenderParametersSet(new Parameter("p1", "v1"), new Parameter("p2", "v2"));
		assertNoParametersSet("Action");
		assertNoParametersSet("Resource");
	}

	private void assertNoParametersSet(String methodType, String parametersType) {

		String parametersXpath = getParametersTableXpath(methodType, parametersType) + "/td";
		waitingAsserter.assertTrue(or(not(presenceOfAllElementsLocatedBy(By.xpath(parametersXpath))), 
				invisibilityOfElementLocated(By.xpath(parametersXpath))));
	}

	private void assertNoParametersSet(String parametersType) {
		assertNoParametersSet(parametersType, parametersType);
	}

	private void assertNoRenderParametersSet() {
		assertNoParametersSet("Render");
		assertNoParametersSet("Resource", "Render");		
	}

	private void assertParametersSet(String methodType, String parametersType, Parameter... parameters) {

		if (parameters.length == 0) {
			throw new NullPointerException();
		}

		String parametersTableXpath = getParametersTableXpath(methodType, parametersType);

		for (Parameter parameter : parameters) {
			waitingAsserter.assertTrue(visibilityOfElementLocated(By.xpath(parametersTableXpath +
					"//td[contains(text(),'" + parameter.name + "')]" +
					"/following-sibling::td[contains(text(),'" + parameter.value + "')]")));
		}
	}

	private void assertParametersSet(String parametersType, Parameter... parameters) {
		assertParametersSet(parametersType, parametersType, parameters);
	}

	private void assertRenderParametersSet(Parameter... parameters) {
		assertParametersSet("Render", parameters);
		assertParametersSet("Resource", "Render", parameters);
	}

	private static String getParametersTableXpath(String methodType, String parametersType) {
		return "//h4[contains(text(),'" + methodType + "')][contains(text(),'Method') or contains(text(),'method')]" +
			"/following-sibling::h5[contains(text(),'" + parametersType + "')][contains(text(),'Parameters')]" +
			"/following-sibling::table";
	}

	private static final class Parameter {

		private final String name;
		private final String value;

		public Parameter(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}
}
