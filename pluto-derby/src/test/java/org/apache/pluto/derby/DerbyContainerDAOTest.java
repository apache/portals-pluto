package org.apache.pluto.derby;

import java.io.File;
import java.sql.SQLException;

import org.apache.pluto.core.PortletPreference;
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
			e.printStackTrace();
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
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testFindPortletPreference() {
		String context = "/testsuite";
		String portletName = "TestPortlet1";
		String preferenceName = "dummyName";
		String authUser = "ANONYMOUS";
		int id = 0;
		try {
			id = DerbyPlutoContainerDAO.findPreferenceId(context, portletName, preferenceName, authUser);
			System.out.println("ID of preference '" + preferenceName + "' in portlet '" + portletName + "' at app context '" + context + "' = " + id);
			assertTrue(id == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	 public void testGetStoredPreferences(){
		 String context = "/testsuite";
		String portletName = "TestPortlet1";
		String authUser = "ANONYMOUS";
			try {
				PortletPreference[] prefs = DerbyPlutoContainerDAO.getStoredPreferences(context, portletName, authUser);
				assertNotNull(prefs);
				assertTrue(prefs.length > 0);
				for (int i = 0; i < prefs.length; i++) {
					PortletPreference pref = (PortletPreference)prefs[i];
					if (i == 0) {
						assertTrue(pref.getName().equals("dummyName"));
						assertTrue(pref.getValues()[0].equals("dummyValue"));
						assertTrue(pref.isReadOnly() == false);						
					}
					if (i == 1) {
						assertTrue(pref.getName().equals("dummyName2"));
						assertTrue(pref.getValues()[0].equals("dummyValue2"));
						assertTrue(pref.isReadOnly() == false);						
					}
					if (i == 2) {
						assertTrue(pref.getName().equals("readonly"));
						assertTrue(pref.getValues()[0].equals("readonly"));
						assertTrue(pref.isReadOnly() == true);						
					}
//					System.out.println("Preference name:" +  pref.getName());
//					String val0 = pref.getValues()[0];
//					System.out.println("Preference value:" +  val0);
//					System.out.println("Read only:" + pref.isReadOnly());
				}
			} catch (SQLException e) {
				e.printStackTrace();
				fail(e.toString());
			}
		 
	 }

	 public void testInsertTransaction() {
		 //Do this with explicit transaction
		 DerbyDataStore ds = new DerbyDataStore(false);
		 int id = 0;
		 int id2 = 0;
		 int pid = 0;
		 int pid2 = 0;
		 
		 final String[] testContext = {"/test"};
		 final String[] testContext2 = {"/test2"};
		 final String testName = "TestPortlet";
		 final String testName2 = "TestPortlet2";
		 
		try {
			id = ds.doInsert("insert into container.portlet_app (app_context) values (?)", testContext);
			 assertTrue(id > 0);
			System.out.println("First Generated ID = " + id);
			id2 = ds.doInsert("insert into container.portlet_app (app_context) values (?)", testContext2);
			 assertTrue(id2  > 0);
			System.out.println("Second Generated ID = " + id2);
			 assertTrue(id2 - id == 1);
			Object[] params1 = new Object[]{
						new Integer(id),
						new String(testName)
						}; 
			pid = ds.doInsert("insert into container.portlet (portlet_app_id, portlet_name) values (?, ?)", params1);
			assertTrue(pid > 0);
			System.out.println("First Portlet Generated ID = " + pid);
			Object[] params2 = new Object[]{
					new Integer(id2),
					new String(testName2)
					}; 
			pid2 = ds.doInsert("insert into container.portlet (portlet_app_id, portlet_name) values (?, ?)", params2);
			assertTrue(pid2 > 0);
   		    assertTrue(pid2 - pid == 1);
   		    ds.commit();
			 
		} catch (SQLException e) {
			ds.rollback();
			e.printStackTrace();
			fail(e.toString());
		} finally {
			if (ds != null) {
				try {
					ds.doDelete("delete from container.portlet where portlet_id=?", pid);
					ds.doDelete("delete from container.portlet where portlet_id=?", pid2);
					ds.doDelete("delete from container.portlet_app where portlet_app_id=?", id);
					ds.doDelete("delete from container.portlet_app where portlet_app_id=?", id2);
					ds.commit();
				} catch (SQLException e) {
					ds.rollback();
					e.printStackTrace();
					fail("Fail during delete: " + e.toString());
				}
			}
			
		}
		ds.closeConnection();
	 }
}


