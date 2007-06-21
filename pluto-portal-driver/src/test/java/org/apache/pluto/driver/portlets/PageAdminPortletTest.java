package org.apache.pluto.driver.portlets;

import java.io.File;

import junit.framework.TestCase;

import org.apache.pluto.driver.portlets.PageAdminPortlet;

public class PageAdminPortletTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testParseDefaultPage() {
		final String strConfig = "<render-config default=\"Test Page\">";
		String defaultPage = PageAdminPortlet.parseDefaultPage(strConfig);
//		System.out.println("Default page: " + defaultPage);
		assertEquals(defaultPage, "Test Page");
	}
}
