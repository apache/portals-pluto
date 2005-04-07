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
package org.apache.pluto.portlet.admin.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.util.PlutoAdminContext;

/**
 * Base class to all portlets.
 *
 * @author Craig Doremus
 *
 */
public class ControllerPortlet extends GenericPortlet {

	protected String _incView = "/view.jsp";
	protected String _incEdit = "/edit.jsp";
	protected String _incHelp = "/help.jsp";
	protected Properties _properties = null;
	protected PortletContext _ctx = null;

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doEdit(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType("text/html");

		PortletRequestDispatcher rd = _ctx.getRequestDispatcher(_incEdit);
		rd.include(request, response);
	}
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType("text/html");

		PortletRequestDispatcher rd = _ctx.getRequestDispatcher(_incView);
		rd.include(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		response.setContentType("text/html");

		PortletRequestDispatcher rd = _ctx.getRequestDispatcher(_incHelp);
		rd.include(request, response);
	}


	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#init()
	 */
	public void init() throws PortletException {
		super.init();
		//
		try {
			_ctx = 	getPortletContext();
			PortletConfig config = getPortletConfig();
			String tmp = config.getInitParameter("view_include");
			if (tmp != null) {
				_incView = tmp;
			}
			log("View include: " + _incView);
			tmp = config.getInitParameter("edit_include");
			if (tmp != null) {
				_incEdit = tmp;
			}
			log("Edit include: " + _incEdit);
			tmp = config.getInitParameter("help_include");
			if (tmp != null) {
				_incHelp = tmp;
			}
			log("Help include: " + _incHelp);

			//load properties
			_properties = PlutoAdminContext.getInstance().getProperties();

			//Configure the paths to the container home dir,
			//	Pluto's dir and the deployment dir. This needs to
			//	be done before any admin portlets are called.
			String plutoPath = _ctx.getRealPath("");//Path with single slash is also allowed
//			String plutoPath = null;//for testing
			PlutoAdminContext.getInstance().parseDeploymentPaths(plutoPath);
		} catch (Throwable e) {
			log("Error thrown in ControllerPortlet.init()", e);
		}


	}

	/* (non-Javadoc)
	 * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.processAction(request, response);
	}
	 */

	protected void log(String msg) {
		_ctx.log(msg);
//		System.out.println(msg);
	}

	protected void log(String msg, Throwable e) {
		_ctx.log(msg, e);
//		System.out.println(msg + " Message:" + e.getMessage());
	}

	protected String getPageRegistryFileName() {
		String fileName = _properties.getProperty("pageregistry-file");
		return fileName;
	}

	protected String getPageRegistryFilePath() {
		return getDataDirPath() + PlutoAdminConstants.FS + getPageRegistryFileName();
	}

	protected String getPortletRegistryFileName() {
		String fileName = _properties.getProperty("portletregistry-file");
		return fileName;
	}

	protected String getPortletRegistryFilePath() {
		return getDataDirPath() + PlutoAdminConstants.FS + getPortletRegistryFileName();
	}

	protected String getDataDirPath() {
		String path = null;
//		String realPath = _ctx.getRealPath("/");
//		int indTomcatHome = realPath.indexOf( PlutoAdminConstants.FS + "webapps");
//		String tomcatHome = realPath.substring(0, indTomcatHome);
		
		String plutoHome = PlutoAdminContext.getInstance().getPlutoHome();
//		path = tomcatHome + PlutoAdminConstants.FS + "webapps" +
//			PlutoAdminConstants.FS + _properties.getProperty("pluto-web-context") +
//			PlutoAdminConstants.FS + dataDirRelPath;
		String dataDirRelPath = _properties.getProperty("data-dir-relative-path");
		path = 	plutoHome +	PlutoAdminConstants.FS + dataDirRelPath;
		return path;
	}


	protected void printParams(PortletRequest request) {
		log("Parameter names/values");
		Enumeration penum = request.getParameterNames();
		while (penum.hasMoreElements()) {
			String pname = (String) penum.nextElement();
			String[] pvals = request.getParameterValues(pname);
			for (int i = 0; i < pvals.length; i++) {
				String val = pvals[i];
				log("Parameter: " + pname + "==" + val);
			}
		}
	}
}
