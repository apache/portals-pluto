package org.apache.pluto.derby;

import java.io.File;
import java.sql.SQLException;

import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.derby.DerbyPlutoContainerDAO;

import junit.framework.Assert;
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
	   	createTestData();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		deleteTestData();
		DerbyDataStore.shutdown();
	}

	public void testFindPortletAppId() {
		String context = TEST_APP_CONTEXT;
		int id = 0;
		try {
			id = DerbyPlutoContainerDAO.findPortletAppId(context);
			assertTrue(id == firstappId);
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	public void testFindPortletId() {
		String context = TEST_APP_CONTEXT;
		String portletName = TEST_PORTLET_NAME;
		int id = 0;
		try {
			id = DerbyPlutoContainerDAO.findPortletId(context, portletName);
			System.out.println("ID of portlet '" + portletName + "' at app context '" + context + "' = " + id);
			assertTrue(id == firstpltid);
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testFindPortletPreference() {
		String context = TEST_APP_CONTEXT;
		String portletName = TEST_PORTLET_NAME;
		String preferenceName = TEST_PREF_NAME;
		String authUser = TEST_USER;
		int id = 0;
		try {
			id = DerbyPlutoContainerDAO.findPreferenceId(context, portletName, preferenceName, authUser);
			System.out.println("ID of preference '" + preferenceName + "' in portlet '" + portletName + "' at app context '" + context + "' = " + id);
			assertTrue(id == firstprefid);
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	
	 public void testGetStoredPreferences(){
		 String context = TEST_APP_CONTEXT;
		String portletName = TEST_PORTLET_NAME;
		String authUser = TEST_USER;
			try {
				PortletPreference[] prefs = DerbyPlutoContainerDAO.getStoredPreferences(context, portletName, authUser);
				assertNotNull(prefs);
				assertTrue(prefs.length > 0);
				for (int i = 0; i < prefs.length; i++) {
					PortletPreference pref = (PortletPreference)prefs[i];
					if (i == 0) {
						assertTrue(pref.getName().equals(TEST_PREF_NAME));
						assertTrue(pref.getValues()[0].equals(TEST_PREF_VALUEa));
						assertTrue(pref.getValues()[1].equals(TEST_PREF_VALUEb));
						assertTrue(pref.isReadOnly() == true);						
					}
					if (i == 1) {
						assertTrue(pref.getName().equals(TEST_PREF_NAME1));
						assertTrue(pref.getValues()[0].equals(TEST_PREF_VALUE1a));
						assertTrue(pref.isReadOnly() == false);						
					}
//					if (i == 2) {
//						assertTrue(pref.getName().equals(TEST_PREF_NAME2));
//						assertTrue(pref.getValues()[0].equals(TEST_PREF_VALUE2a));
//						assertTrue(pref.isReadOnly() == false);						
//					}
//					System.out.println("Preference name:" +  pref.getName());
//					String val0 = pref.getValues()[0];
//					System.out.println("Preference value:" +  val0);
//					System.out.println("Read only:" + pref.isReadOnly());
				}
			} catch (Throwable e) {
				e.printStackTrace();
				fail(e.toString());
			}
		 
	 }

	 public void testInsertTransaction() {
		 //Use an explicit transaction
		 DerbyDataStore ds = new DerbyDataStore(false);
		 int id = 0;
		 int id2 = 0;
		 int pid = 0;
		 int pid2 = 0;
		 
		 final String[] testContext = {"/test1"};
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
			 
		} catch (Throwable e) {
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
				} catch (Throwable e) {
					ds.rollback();
					e.printStackTrace();
					fail("Fail during delete: " + e.toString());
				}
			}
			ds.closeConnection();			
		}
	 }


	 /** Test data */
	 private static final String TEST_APP_CONTEXT = "/test";
	 
	 private static final String TEST_PORTLET_NAME = "TestPortletName";
	 private static final String TEST_PREF_NAME = "TestPrefName";
	 private static final String TEST_PREF_READ_ONLY = "Y";
	 private static final String TEST_PREF_VALUEa = "TestPrefVala";
	 private static final String TEST_PREF_VALUEb = "TestPrefValb";
	 private static final String TEST_PREF_NAME1 = "TestPrefName1";
	 private static final String TEST_PREF_READ_ONLY1 = "N";
	 private static final String TEST_PREF_VALUE1a = "TestPrefVal1a";
	 
	 private static final String TEST_PORTLET_NAME2 = "TestPortletName2";
	 private static final String TEST_PREF_NAME2 = "TestPrefName2";
	 private static final String TEST_PREF_READ_ONLY2 = "N";
	 private static final String TEST_PREF_VALUE2a = "TestPrefVal2a";
	 
	 private static final String TEST_USER = "TestUser";
	 private int firstappId = 0;
	 private int firstpltid = 0;
	 private int firstprefid = 0;
	 private int firstprefvalid = 0;
	 
	 private void createTestData() {
		 //Use an explicit transaction
		 DerbyDataStore ds = new DerbyDataStore(false);
		 int appid = 0;
		 int pid = 0;
		 int pid2 = 0;
		 int prefid = 0;
		 int prefid2 = 0;
		 int prefvalid = 0;
		 int prefid1 = 0;
		 int prefvalid1 = 0;
		 
		 int prefvalid2 = 0;
		 int prefvalid2a = 0;
		 
		 final String[] testAppContext = {TEST_APP_CONTEXT};
		 
		try {
			appid = ds.doInsert("insert into container.portlet_app (app_context) values (?)", testAppContext);
			firstappId = appid;

			Object[] params1 = new Object[]{
						new Integer(appid),
						new String(TEST_PORTLET_NAME)
						}; 
			pid = ds.doInsert("insert into container.portlet (portlet_app_id, portlet_name) values (?, ?)", params1);
			firstpltid = pid;

			Object[] params3 = new Object[]{
					new Integer(pid),
					new String(TEST_PREF_NAME),
					new String(TEST_PREF_READ_ONLY),
					new String(TEST_USER)					
					}; 		   		    
			prefid = ds.doInsert("insert into container.preference (portlet_id, preference_name, read_only, auth_user) values (?, ?, ?, ?)", params3);
			firstprefid = prefid;

			Object[] params4 = new Object[]{
					new Integer(prefid),
					new String(TEST_PREF_VALUEa)
					}; 		   		    
			prefvalid = ds.doInsert("insert into container.preference_value (preference_id, preference_value) values (?, ?)", params4);
			firstprefvalid = prefvalid;

			Object[] params5 = new Object[]{
					new Integer(prefid),
					new String(TEST_PREF_VALUEb)
					}; 		   		    
			prefvalid2 = ds.doInsert("insert into container.preference_value (preference_id, preference_value) values (?, ?)", params5);
			
		Object[] params9 = new Object[]{
				new Integer(pid),
				new String(TEST_PREF_NAME1),
				new String(TEST_PREF_READ_ONLY1),
				new String(TEST_USER)					
				}; 		
		prefid1 = ds.doInsert("insert into container.preference (portlet_id, preference_name, read_only, auth_user) values (?, ?, ?, ?)", params9);
		    

		Object[] params10 = new Object[]{
				new Integer(prefid1),
				new String(TEST_PREF_VALUE1a)
				}; 		   		    
		prefvalid1 = ds.doInsert("insert into container.preference_value (preference_id, preference_value) values (?, ?)", params10);
			
 
		Object[] params2 = new Object[]{
				new Integer(appid),
				new String(TEST_PORTLET_NAME2)
				}; 		
		pid2 = ds.doInsert("insert into container.portlet (portlet_app_id, portlet_name) values (?, ?)", params2);
			
			Object[] params6 = new Object[]{
					new Integer(pid2),
					new String(TEST_PREF_NAME2),
					new String(TEST_PREF_READ_ONLY2),
					new String(TEST_USER)					
					}; 		   		    
			prefid2 = ds.doInsert("insert into container.preference (portlet_id, preference_name, read_only, auth_user) values (?, ?, ?, ?)", params6);

			Object[] params7 = new Object[]{
					new Integer(prefid2),
					new String(TEST_PREF_VALUE2a)
					}; 		   		    
			prefvalid2a = ds.doInsert("insert into container.preference_value (preference_id, preference_value) values (?, ?)", params7);
   		    			
   		    ds.commit();
			 
		} catch (Throwable e) {
			ds.rollback();
			e.printStackTrace();
			fail(e.toString());
		} finally {
			ds.closeConnection();			
		}
	 }
	 private void deleteTestData(){
		 //Use an explicit transaction
		 DerbyDataStore ds = new DerbyDataStore(false);
		try {
			ds.doDelete("delete from container.preference_value where preference_id > ?", firstprefvalid - 1);
			ds.doDelete("delete from container.preference where preference_id > ?", firstprefid - 1);
			ds.doDelete("delete from container.portlet where portlet_id > ?", firstpltid - 1);
			ds.doDelete("delete from container.portlet_app where portlet_app_id > ?", firstappId - 1);
			ds.commit();
		} catch (Throwable e) {
			ds.rollback();
			e.printStackTrace();
			fail("Fail during delete: " + e.toString());
		} finally {
			ds.closeConnection();			
			
		}
			
//		 delete from preference_value where preference_id > 6;
//		 delete from preference where preference_id > 6;
//		 delete from portlet where portlet_id > 2;
//		 delete from portlet_app where portlet_app_id > 1;
		 
	 }

}


