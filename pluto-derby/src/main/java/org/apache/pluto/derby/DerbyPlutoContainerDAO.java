package org.apache.pluto.derby;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;

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
	private static final String FIND_PORTLET_APP_ID_SQL = "select portlet_app_id from container.portlet_app where app_context=?";
	private static final String FIND_PORTLET_ID_SQL = "select portlet_id from container.portlet where portlet_app_id=? and portlet_name=?";
	
	private static final String FIND_PORTLET_PREF_ID_SQL = "select preference_id, preference_name, read_only from container.preference where portlet_id=? and preference_name=?";

	private static final String FIND_PREFERENCE_LIST_SQL = "select preference_id, preference_name, read_only from container.preference where portlet_id=?";
	private static final String FIND_PREF_VALUES_SQL = "select preference_value from container.preference_value where preference_id=?";
	
	/* Cascading insert for a new portlet app */
	private static final String INSERT_PORTLET_PREFS1 = "insert into container.portlet_app (app_context) values(?)";
	private static final String INSERT_PORTLET_PREFS2 = "insert into container.portlet (portlet_app_id, portlet_name) values(IDENTITY_VAL_LOCAL(), ?)";
	private static final String INSERT_PORTLET_PREFS3 = "insert into container.preference (portlet_id, preference_name, read_only) values(IDENTITY_VAL_LOCAL(), ?, ?)";
	private static final String INSERT_PORTLET_PREFS4 = "insert into container.preference_value (preference_id, preference_value) values(IDENTITY_VAL_LOCAL(), ?)";
	
	/**
	 * Used by the container to get portlet preferences.
	 * @param context Web context of the portlet application.
	 * @return
	 * @throws SQLException
	 */
    public static PortletPreference[] getStoredPreferences(String context, String portletName) 
    	throws SQLException {
    	int id = findPortletId(context, portletName);
    	List list = findPreferenceList(id);
    	PortletPreference[] prefs = new PortletPreference[list.size()];
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

    public static int findPortletId(String context, String portletName) throws SQLException {
    	int pid = 0;
    	Integer oId = null;
    	int aid = findPortletAppId(context);
		Object[] params = new Object[]{
				new Integer(aid),
				new String(portletName)
				}; 
    	DerbyDataStore ds = new DerbyDataStore();
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
    	return pid;
    }

    public static int findPreferenceId(String context, String portletName, String prefName) throws SQLException {
    	int pid = 0;
    	Integer oId = null;
    	int aid = findPortletId(context, portletName);
		Object[] params = new Object[]{
				new Integer(aid),
				new String(prefName)
				}; 
    	DerbyDataStore ds = new DerbyDataStore();
    	List list = ds.doSelect(FIND_PORTLET_PREF_ID_SQL, params);
    	if (list != null && !list.isEmpty()) {
    		Map row1 = (Map)list.get(0);
    		if (row1 != null) {
        		oId = (Integer)row1.get("PREFERENCE_ID");    			
    		}
    	}
    	if (oId != null) {
    		pid = oId.intValue();
    	}
    	return pid;
    }

    public static List findPreferenceList(int portletId) throws SQLException {
    	List list = null;
    	if (portletId != 0) {
			Object[] params = new Object[]{
					new Integer(portletId),
					}; 
	    	DerbyDataStore ds = new DerbyDataStore();
	    	list = ds.doSelect(FIND_PREFERENCE_LIST_SQL, params);
    	}
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
    public static void storePreferences(String context, PortletPreference[] preferences) {
    	//TODO: implement this
    	
    }
    
    public static void insertPreference(PortletEntity entity, PortletPreference pref) {
    	
    }
}
