package org.apache.pluto.derby;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.core.PortletEntity;
import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.core.impl.PortletPreferenceImpl;

/**
 * Data access object for the persistence of container-related
 * data in Apache Derby. This class is a facade for <code>DerbyDataStore</code>.
 * 
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 *
 */
public class DerbyPlutoContainerDAO {
    private static final Log LOG =
        LogFactory.getLog(DerbyPlutoContainerDAO.class);
    
	private static final String FIND_PORTLET_APP_ID_SQL = "select portlet_app_id from container.portlet_app where app_context=?";
	private static final String FIND_PORTLET_ID_SQL = "select portlet_id from container.portlet where portlet_app_id=? and portlet_name=?";
	
	private static final String FIND_PORTLET_PREF_ID_SQL = "select preference_id, preference_name, read_only from container.preference where portlet_id=? and preference_name=? and auth_user=?";

	private static final String FIND_PREFERENCE_LIST_SQL = 
		"select pr.preference_id, pr.preference_name, pr.read_only " + 
		"from container.preference pr, container.portlet plt, " +
		"container.portlet_app pa " +
		"where pa.portlet_app_id=plt.portlet_app_id " +
		"and plt.portlet_id=pr.portlet_id " + 
		"and pa.app_context=? " +
		"and plt.portlet_name=? " + 
		"and pr.auth_user=?";

	private static final String FIND_PREF_VALUES_SQL = 
		"select preference_value from container.preference_value " +
		"where preference_id=?";
	
	/* Cascading insert for a new portlet app */
	private static final String INSERT_PORTLET_APP = "insert into container.portlet_app (app_context) values(?)";
	private static final String INSERT_PORTLET = "insert into container.portlet (portlet_app_id, portlet_name) values(?, ?)";
	private static final String UPDATE_PREF = "update container.preference set read_only=? where preference_id=?";
	private static final String INSERT_PORTLET_PREF = "insert into container.preference (portlet_id, preference_name, read_only) values(?, ?, ?)";
	private static final String INSERT_PREF_VALUES = "insert into container.preference_value (preference_id, preference_value) values(?, ?)";
	private static final String DELETE_PREF_VALUES = "delete from container.preference_value where preference_id=?";

	/**
	 * Used by the container to get portlet preferences.
	 * @param context Web context of the portlet application.
	 * @return
	 * @throws SQLException
	 */
    public static PortletPreference[] getStoredPreferences(String context, String portletName, String authUser) 
    	throws SQLException {
    	List list = findPreferenceList(context, portletName, authUser);
    	if (list == null) {
    		String msg = "Null preference list returned";
    		LOG.error(msg);
    		throw new IllegalStateException(msg);
    	}
    	int listSize = list.size();
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Preference list size=" + listSize);
    	}
    	PortletPreference[] prefs = new PortletPreference[listSize];
    	int ind = 0;
    	for (Iterator iter = list.iterator(); iter.hasNext();) {
			Map element = (Map) iter.next();
			PortletPreferenceImpl pref = new PortletPreferenceImpl();
			String name = (String)element.get("PREFERENCE_NAME");
			pref.setName(name);
			String readonly = (String)element.get("READ_ONLY");
			boolean ro = (readonly.equalsIgnoreCase("N") || readonly.equalsIgnoreCase("false") ? false : true );
			pref.setReadOnly(ro);
			Integer prefid = (Integer)element.get("PREFERENCE_ID");
			List pvals = findPreferenceValues(prefid.intValue());
			int len = pvals.size();
			String[] vals = new String[len];
			for (int i = 0; i < len; i++) {
				Map map = (Map)pvals.get(i);
				String val = (String)map.get("PREFERENCE_VALUE");
				vals[i] = val;
			}
			pref.setValues(vals);
			prefs[ind] = pref;
			ind++;
		}
    	return prefs;
    }
    
    public static int findPortletAppId(String context) throws SQLException {
    	int id = 0;
    	Integer oId = null;
    	DerbyDataStore ds = new DerbyDataStore();
    	String[] params = {context};
    	List list = ds.doSelect(FIND_PORTLET_APP_ID_SQL, params);
    	if (list != null && !list.isEmpty()) {
    		Map row1 = (Map)list.get(0);
    		if (row1 != null) {
        		oId = (Integer)row1.get("PORTLET_APP_ID");    			
    		}
    	}
    	if (oId != null) {
    		id = oId.intValue();
    	}
    	return id;
    }

    public static int findPortletId(String context, String portletName) 
    	throws SQLException {
    	int pid = 0;
    	Integer oId = null;
    	DerbyDataStore ds = new DerbyDataStore();
    	try {
	    	int aid = findPortletAppId(context);
			Object[] params = new Object[]{
					new Integer(aid),
					new String(portletName)
					}; 
	    	List list = ds.doSelect(FIND_PORTLET_ID_SQL, params);
	    	if (list != null && !list.isEmpty()) {
	    		Map row1 = (Map)list.get(0);
	    		if (row1 != null) {
	        		oId = (Integer)row1.get("PORTLET_ID");    			
	    		}
	    	}
	    	if (oId != null) {
	    		pid = oId.intValue();
	    	}
	    	ds.commit();
    	} catch (SQLException e) {
    		ds.rollback();
    		throw e;
    	}
    	return pid;
    }

    public static int findPreferenceId(String context, String portletName, 
    		String prefName, String authUser) throws SQLException {
    	int prid = 0;
    	Integer oPrId = null;
    	int pltid = findPortletId(context, portletName);
    	System.out.println("PortletID:" + pltid);
    	System.out.println("Pref name: " + prefName);
    	System.out.println("User: " + authUser);
		Object[] params = new Object[]{
				new Integer(pltid),
				new String(prefName),
				new String(authUser)
				}; 
    	DerbyDataStore ds = new DerbyDataStore();
    	List list = ds.doSelect(FIND_PORTLET_PREF_ID_SQL, params);
    	if (list == null) {
    		String msg = "Null preference list returned";
    		LOG.error(msg);
    		throw new IllegalStateException(msg);
    	}
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Preference list size=" + list.size());
    	}
    	if (list != null && !list.isEmpty()) {
    		Map row1 = (Map)list.get(0);
    		if (row1 != null) {
        		oPrId = (Integer)row1.get("PREFERENCE_ID");    			
    		}
    	}
    	if (oPrId != null) {
    		prid = oPrId.intValue();
    	}
    	return prid;
    }

    public static List findPreferenceList(String appContext, String portletName, String authUser) throws SQLException {
    	List list = null;
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("findPreferenceList() parameters: appContext='" + appContext + "'; portletName='" + portletName + "'; authUser='" + authUser + "'");
    	}
    	System.out.println("");
		Object[] params = new Object[]{
				new String(appContext),
				new String(portletName),
				new String(authUser)
				}; 
    	DerbyDataStore ds = new DerbyDataStore();
    	list = ds.doSelect(FIND_PREFERENCE_LIST_SQL, params);
    	return list;
    }

    
    public static List findPreferenceValues(int preferenceId) throws SQLException {
    	List list = null;
    	if (preferenceId != 0) {
			Object[] params = new Object[]{
					new Integer(preferenceId)
					}; 
	    	DerbyDataStore ds = new DerbyDataStore();
	    	list = ds.doSelect(FIND_PREF_VALUES_SQL, params);
    	}
    	return list;
    }
    
    /**
     * Stores portlet preferences in Derby.
     * @param context
     * @param preferences
     */
    public static void storePreferences(String context, String portletName, PortletPreference[] preferences, String authUser) 
    	throws SQLException {
    	DerbyDataStore ds = new DerbyDataStore(false);
    	try {
	    	//find portlet app
	    	int appid = findPortletAppId(context);
	    	if (appid == 0) {
	    		//create new portlet app record
				Object[] params = new Object[]{
						context
						}; 
		    	appid = ds.doInsert(INSERT_PORTLET_APP, params);
	    	}
	    	int pid = 0;
	    	pid = findPortletId(context, portletName);
	    	if (pid == 0) {
	    		//create new portlet record
				Object[] params = new Object[]{
						new Integer(appid),
						context
						}; 
		    	pid = ds.doInsert(INSERT_PORTLET, params);
	    	}
	
	    	int len = preferences.length;
	    	for (int i = 0; i < len; i++) {
	    		PortletPreference pref = preferences[i];
	    		int prefid = findPreferenceId(context, portletName, pref.getName(),authUser);
	    		boolean dRO = pref.isReadOnly();
	    		String ro = dRO ? "Y" : "N";
	     		if (prefid == 0) {
	    			//insert preference
	    			Object[] params = new Object[]{
	    					new Integer(pid),
	    					pref.getName(),
	    					ro
	    					};     			
	    			prefid = ds.doInsert(INSERT_PORTLET_PREF, params);
	    		} else {
	    			//update preference
	      			Object[] params = new Object[]{
	    					ro,
	    					new Integer(prefid)
	    					};     			
	    			ds.doUpdate(UPDATE_PREF, params);    			
	    		}
	    		//delete and insert pref vals
				ds.doDelete(DELETE_PREF_VALUES, pid);
				String[] vals = pref.getValues();
				int vlen = vals.length;
				for (int j = 0; j < vlen; j++) {
	    			Object[] params2 = new Object[]{
	    					new Integer(prefid),
	    					vals[j]
	    					}; 
	    			ds.doUpdate(INSERT_PREF_VALUES, params2);
				}
	    	}
	    	ds.commit();
    	} catch (SQLException e) {
    		ds.rollback();
    		throw e;
    	} finally {
    		ds.closeConnection();
    	}
    }
    
}
