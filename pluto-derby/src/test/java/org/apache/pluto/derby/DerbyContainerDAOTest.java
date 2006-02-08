package org.apache.pluto.derby;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.core.impl.PortletPreferenceImpl;
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

	 /* Test data */
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
	 /* end test data */

	 /* Ids used to delete test data */
	 private int firstappId = 0;
	 private int firstpltid = 0;
	 private int firstprefid = 0;
	 private int firstprefvalid = 0;
	 
	protected void setUp() throws Exception {
		super.setUp();
		//Set up logging to to log to ${user.home}/logs
		//	rather than ${catlina.home}/logs
		String home = System.getProperty("user.home");
		File logdir = new File(home + "/logs");
		if (!logdir.exists()) {
			logdir.mkdirs();
		}
	   	System.setProperty("catalina.home", System.getProperty("user.home"));
	   	//load test data into database
	   	createTestData();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	   	//remove test data from database
		deleteTestData();
		//Shut down embedded Derby
		DerbyDataStore.shutdown();
	}
	
	/**
	 * Inserts test data into the database
	 * for use in these tests.
	 * Called by startUp().
	 *
	 */
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

	/**
	 * Deletes test data from the database.
	 * Called by tearDown().
	 */
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
	 }
	
	/**
	 * Test that a portlet_app_id can be found
	 * given an app_context value.
	 */ 
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
	
	/**
	 * Test that a portlet_id can be found
	 * given an app_context and portlet_name value.
	 */ 
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

	/**
	 * Test that a preference_id can be found
	 * given app_context, portlet_name, preferenceName
	 * and authenticated user name values.
	 */ 
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
	
	/**
	 * Tests DerbyContainerDAO.getStoredPreferences()
	 *
	 */
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

	 /**
	  * Tests a inserting a portlet_app
	  * and portlet into the database.
	  *
	  */
	 public void testInsert() {
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

	 public void testStorePreferences() {
		 final String testContext = "/testContext1sp";
		 final String testName = "TestPortlet1sp";
		 final String prefName1 = "TestPrefName1sp";
		 final String prefVal1a = "TestPrefVal1asp";
		 final String prefVal1b = "TestPrefVal1bsp";
		 final String prefName2 = "TestPrefName2sp";
		 final String prefVal2 = "TestPrefVal2sp";
		 final String authUser = "TestUserSp";
		 
		 //create and load PortletPreference objects
		 String[] vals = {prefVal1a, prefVal1b};
		 PortletPreferenceImpl pref1 = new PortletPreferenceImpl(
				 prefName1, vals, false);
		 String[] vals2 = {prefVal2};
		 PortletPreferenceImpl pref2 = new PortletPreferenceImpl(
				 prefName2, vals2, true);
		 //fill pref array
		 PortletPreference[] prefs = {pref1, pref2};
		 
		 DerbyDataStore ds = new DerbyDataStore();
		 int maxapp = 0;
		 int maxplt = 0;
		 int maxpref = 0;
		 try {
			 //find highest Ids
			 maxapp = findMaxId("PORTLET_APP_ID", "PORTLET_APP");
			 maxplt = findMaxId("PORTLET_ID", "PORTLET");
			 maxpref = findMaxId("PREFERENCE_ID", "PREFERENCE");
			 //Store 1 app, 1 portlet and 2 preference values
			 DerbyPlutoContainerDAO.storePreferences(testContext, testName, prefs, authUser);
			 //Find new high IDs
			 int maxapp2 = findMaxId("PORTLET_APP_ID", "PORTLET_APP");
			 assertTrue(maxapp + 1 == maxapp2);
			 int maxplt2 = findMaxId("PORTLET_ID", "PORTLET");
			 assertTrue(maxplt + 1 == maxplt2);
			 //Now find new max preference_id
			 int maxpref2 = findMaxId("PREFERENCE_ID", "PREFERENCE");
			 //there should be 2 new values in preference table
			 assertTrue(maxpref + 2 == maxpref2);
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e.toString());
		} finally {
			ds.closeConnection();
			//delete test values
 		    DerbyDataStore ds2 = new DerbyDataStore(false);
			try {
				if (maxpref != 0) {
					ds2.doDelete("delete from preference_value where preference_id > ?", maxpref);
					ds2.doDelete("delete from preference where preference_id > ?", maxpref);
				}
				if (maxplt != 0) {
					ds2.doDelete("delete from portlet where portlet_id > ?", maxplt);
				}
				if (maxapp != 0) {
					ds2.doDelete("delete from portlet_app where portlet_app_id > ?", maxapp);
				}
				ds2.commit();
			} catch (Throwable e) {
				ds2.rollback();
				e.printStackTrace();
				fail("Data not deleted!!" + e.toString());
			} finally {
				ds2.closeConnection();				
			}			
		}
	 }

	 private int findMaxId(String idCol, String table) {
		 DerbyDataStore ds = new DerbyDataStore();
		 int maxid = 0;
		 final String ALIAS = "MAX_ID";
		 try {
			 StringBuffer sql = new StringBuffer();
			 sql.append("select max(");
			 sql.append(idCol);
			 sql.append(") ");
			 sql.append(ALIAS);
			 sql.append(" from ");
			 sql.append(table);
			 List rs = ds.doSelect(sql.toString());
			 assertNotNull(rs);
			 assertTrue(rs.size() == 1);
			 Map record = (Map)rs.get(0);
			 Integer omaxid = (Integer)record.get(ALIAS);
			 assertNotNull(omaxid);
			 maxid = omaxid.intValue();
			} catch (SQLException e) {
				e.printStackTrace();
				fail(e.toString());
			} finally {
				ds.closeConnection();
			}
		return maxid;
	}

}


