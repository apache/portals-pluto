package org.apache.pluto.derby;

import java.io.File;
import java.sql.SQLException;
import org.apache.pluto.derby.DerbyPlutoContainerDAO;

import junit.framework.TestCase;
/**
 * JUnit test of <code>DerbyContainerDA</code>.
 * 
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class DerbyContainerDAOTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();

		//Set up logging
		String home = System.getProperty("user.home");
		File logdir = new File(home + ".logs");
		if (!logdir.exists()) {
			logdir.mkdirs();
		}
	   	System.setProperty("catalina.home", System.getProperty("user.home"));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		//TODO: make sure data is there
	}

	public void testFindPortletAppId() {
		String context = "/testsuite";
		int id = 0;
		try {
			id = DerbyPlutoContainerDAO.findPortletAppId(context);
			System.out.println("Portlet App ID of context '" + context + "' = " + id);
			assertTrue(id == 1);
		} catch (SQLException e) {
			fail(e.toString());
		}
	}
	
	public void testFindPortletId() {
		String context = "/testsuite";
		String portletName = "TestPortlet1";
		int id = 0;
		try {
			id = DerbyPlutoContainerDAO.findPortletId(context, portletName);
			System.out.println("ID of portlet '" + portletName + "' at app context '" + context + "' = " + id);
			assertTrue(id == 1);
		} catch (SQLException e) {
			fail(e.toString());
		}
	}

	public void testFindPortletPreference() {
		String context = "/testsuite";
		String portletName = "TestPortlet1";
		String preferenceName = "dummyName";
		int id = 0;
		try {
			id = DerbyPlutoContainerDAO.findPreferenceId(context, portletName, preferenceName);
			System.out.println("ID of preference '" + preferenceName + "' in portlet '" + portletName + "' at app context '" + context + "' = " + id);
			assertTrue(id == 1);
		} catch (SQLException e) {
			fail(e.toString());
		}
	}
	
}
