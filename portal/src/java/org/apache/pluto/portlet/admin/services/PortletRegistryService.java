/*
 * Copyright 2003,2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.portlet.admin.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;

import org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityImpl;
import org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityListImpl;
import org.apache.pluto.portlet.admin.BaseAdminObject;
import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.PlutoAdminLogger;
import org.apache.pluto.portlet.admin.util.PortletApplicationEntityImplComparator;

/**
 * Service concerned with portletentityregistry.xml persistence
 *
 * @author Craig Doremus
 * @see org.apache.pluto.portlet.admin.controller.PortletEntityRegistryPortlet
 *
 */
public class PortletRegistryService extends BaseAdminObject {

	private static final String CLASS_NAME = "PortletRegistryService";


	/**
	 * Default constructor
	 */
	public PortletRegistryService() {
		super(CLASS_NAME);
	}

	public List getPageRegistryData(String prPath) {
		List alist = null;
		return alist;
	}

	/*
	public void savePortlet(String perPath, ApplicationTypeImpl app){
		final String METHOD_NAME = "savePortlet(perPath,app)";
		logMethodStart(METHOD_NAME);
		logParam(METHOD_NAME, "perPath", perPath);
		logParam(METHOD_NAME, "app", app);
		PortletEntityRegistryXao xao = new PortletEntityRegistryXao();
		xao.saveApplications(perPath,app);
		logMethodEnd(METHOD_NAME);
	}
		*/

	public List getPortletEntityRegistry(String perPath) {
		final String METHOD_NAME = "getPortletEntityRegistry(perPath)";
		logMethodStart(METHOD_NAME);
		logParam(METHOD_NAME, "perPath", perPath);
		List alist = null;
		/*
		PortletEntityRegistryXao xao = new PortletEntityRegistryXao();
		alist = xao.getApplications(perPath);
		Iterator iter = alist.iterator();
		while (iter.hasNext()) {
			ApplicationTypeImpl app = (ApplicationTypeImpl) iter.next();
			logVar(METHOD_NAME, "appId", app.getId());
		}
		logMethodEnd(METHOD_NAME, alist);
		*/
		return alist;
	}

	/*
	public ApplicationTypeImpl getPortletEntityRegistryApp(String perPath, String appId) {
		final String METHOD_NAME = "getPortletEntityRegistryApp(perPath, appId)";
		logMethodStart(METHOD_NAME);
		logParam(METHOD_NAME, "perPath", perPath);
		logParam(METHOD_NAME, "appId", appId);
		ApplicationTypeImpl app = null;
		PortletEntityRegistryXao xao = new PortletEntityRegistryXao();
		app = xao.getApplication(perPath, appId);
		if (app != null) {
			logDebug(METHOD_NAME, "looked up appId=" + app.getId());
		}
		logMethodEnd(METHOD_NAME, app);
		return app;
	}
		*/

		public List getPortletPreferences(String perPath, String appId, String portletId ) {
			final String METHOD_NAME = "getPortletPreferences(perPath,appId,portletId)";
			logMethodStart(METHOD_NAME);
			List list = null;
			/*
			PortletEntityRegistryXao xao = new PortletEntityRegistryXao();
			list = xao.getPortletPreferencesList(perPath, appId, portletId);
			logMethodEnd(METHOD_NAME, list);
*/
			return list;
		}

		public List addPortletPreference(String perPath, String appId, String portletId ) {
			final String METHOD_NAME = "addPortletPreferences(perPath,appId,portletId)";
			logMethodStart(METHOD_NAME);
			List list = null;
			/*
			list = getPortletPreferences(perPath, appId, portletId);
			//create a new empty preference and add it
			PreferencesTypeImpl pref = new PreferencesTypeImpl();
			pref.setPrefName("");
			pref.setPrefValue("");
			pref.setReadOnly(false);
			list.add(pref);
			logMethodEnd(METHOD_NAME, list);
			*/
			return list;
		}

/*
		public PortletTypeImpl getNewPortlet(String perPath, String appId) {
			final String METHOD_NAME = "getNewPortlet(perPath,appId,portletId)";
			logMethodStart(METHOD_NAME);
			PortletTypeImpl portlet = null;
			PortletEntityRegistryXao xao = new PortletEntityRegistryXao();
			ApplicationTypeImpl app = xao.getApplication(perPath, appId);
			portlet.setDefinitionId("");
			portlet.setId("");
			logMethodEnd(METHOD_NAME, portlet);
			return portlet;
		}
*/

		public static String getNextAppId() {
			final String METHOD_NAME = "getNextAppId()";
			PlutoAdminLogger.logMethodStart(CLASS_NAME, METHOD_NAME);
			String appId = null;
			Collection apps;
			try {
				org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao xao =
					new org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao();
				apps = xao.getApplications();
			} catch (Exception e) {
				PlutoAdminLogger.logError(CLASS_NAME, METHOD_NAME, e);
				throw new PlutoAdminException(e);
			}
			ArrayList list = new ArrayList(apps);
			Iterator iter = list.iterator();
			int nNewId = 0;
			while (iter.hasNext()) {
				PortletApplicationEntityImpl app = (PortletApplicationEntityImpl) iter.next();
				String currAppId = app.getCastorId();
				int nCurrAppId = Integer.parseInt(currAppId);
				if (nNewId <= nCurrAppId) {
					nNewId = nCurrAppId;
				}
			}
			nNewId++;
			appId = Integer.toString(nNewId);
			PlutoAdminLogger.logMethodEnd(CLASS_NAME, METHOD_NAME, appId);
			return appId;

		}

		public void getPortletEntityRegistry(RenderRequest request) {
			final String METHOD_NAME = "getPortletEntityRegistry(request)";
			logMethodStart(METHOD_NAME);
			Collection alist = null;
			try {
				org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao xao =
					new org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao();
				PortletApplicationEntityListImpl registry = xao.load();
				alist = registry.getCastorApplications();
				logDebug(METHOD_NAME, "App list: " + alist);
			} catch (Exception e) {
				logError(METHOD_NAME, e);
				throw new PlutoAdminException(e);
			}
			//sort the collection
			ArrayList slist = new ArrayList(alist);
			Collections.sort(slist, new PortletApplicationEntityImplComparator());
			Iterator iter = slist.iterator();
			request.setAttribute(PlutoAdminConstants.PER_LIST_ATTR, iter);
			logMethodEnd(METHOD_NAME, alist);
		}

		public void getPortletEntityRegistryApp(ActionRequest request) {
			final String METHOD_NAME = "getPortletEntityRegistryApp(request)";
			logMethodStart(METHOD_NAME);
			String appId = request.getParameter("appid");
			logDebug(METHOD_NAME, "AppId selected: " + appId);
			PortletSession session = request.getPortletSession();
			PortletApplicationEntityImpl app;
			try {
				org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao xao =
					new org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao();
				app = xao.getApplication(appId);
			} catch (Exception e) {
				logError(METHOD_NAME, e);
				throw new PlutoAdminException(e);
			}
			session.setAttribute(PlutoAdminConstants.APP_ATTR, app, PortletSession.APPLICATION_SCOPE);
			logMethodEnd(METHOD_NAME);
		}

		public void getPortletPreferences(ActionRequest request) {
			String METHOD_NAME = "getPortletPreferences(request)";
			logMethodStart(METHOD_NAME);
			String appId = request.getParameter("appId");
			logDebug(METHOD_NAME, "AppId selected: " + appId);
			String portletId = request.getParameter("portletId");
			logDebug(METHOD_NAME, "PortletId selected: " + portletId);
			List prefs = null;
			try {
				org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao xao =
					new org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao();
				Collection coll = xao.getPortletPreferences(appId, portletId);
				prefs = new ArrayList(coll);
			} catch (Exception e) {
				logError(METHOD_NAME, e);
				throw new PlutoAdminException(e);
			}
			PortletSession session = request.getPortletSession();
			Map map = (Map)session.getAttribute(PlutoAdminConstants.PREF_LIST_ATTR);
			if (map == null) {
				map = new HashMap();
			}
			map.put(portletId, prefs);
			session.setAttribute(PlutoAdminConstants.PREF_LIST_ATTR, map, PortletSession.APPLICATION_SCOPE);
			logMethodEnd(METHOD_NAME);
		}
}
