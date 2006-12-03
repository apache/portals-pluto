/*
 * Copyright 2006 The Apache Software Foundation.
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
package org.apache.pluto.driver.portlets;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.config.AdminConfiguration;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.services.portal.admin.DeployWarAdminService;
import org.apache.pluto.driver.services.portal.admin.PortletRegistryAdminService;
import org.apache.pluto.driver.services.portal.admin.ReassembleWarAdminService;
import org.apache.pluto.driver.services.portal.admin.RenderConfigAdminService;
import org.apache.pluto.driver.services.portal.admin.WarUploadAdminService;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.util.UtilityException;
import org.apache.pluto.util.deploy.DeploymentException;
import org.apache.pluto.util.fileupload.FileUploaderException;
import org.apache.pluto.util.ui.PortletUiMessage;
import org.apache.pluto.util.ui.PortletUiMessageType;

/**  
 * Administrative portlet used to deploy wars into the Pluto portal driver.
 * 
 * @author <a href="mailto:cdoremus@apache.org">Craig Doremus</a>
 */
public class AdminDeploymentPortlet extends GenericPortlet {

	public static final Log LOG = LogFactory.getLog(AdminDeploymentPortlet.class); 
	
	/**
	 * JSP file used for the view mode
	 */
	public static final String VIEW_JSP = "/WEB-INF/fragments/admin/deploy/view.jsp";
	/**
	 * JSP file used for the edit mode
	 */
	public static final String EDIT_JSP = "/WEB-INF/fragments/admin/deploy/edit.jsp";
	/**
	 * JSP file used for the help mode
	 */
	public static final String HELP_JSP = "/WEB-INF/fragments/admin/deploy/help.jsp";
	
	public static final String ISCONFIGURED_PARAM = "isconfigured";
	public static final String BUNDLE_ATTR = "bundle";
	public static final String MAXUPLOAD_SIZE_ATTR = "maxupload_size"; 
	public static final String  FILEUPLOAD_CMD = "uploadfile";
	public static final String UPLOAD_PATH_PARAM = "fileupload";
	/**
	 * Resources held in a properties file.
	 */
	private ResourceBundle _bundle = null;
	
	private PortletContext _context = null;
	
	/**
	 * Service to upload the war file
	 */
	private WarUploadAdminService _wuService = null;
	/**
	 * Service to modify the web.xml, reassemble the war with it
	 * and move it into place
	 */
	private ReassembleWarAdminService _awService = null;
	/**
	 * Service to create a deployment descriptor and move it into place
	 */
	private DeployWarAdminService _dwService = null;
	/**
	 * Holds admin configuration info from Spring config file
	 */
	private AdminConfiguration _adminConfig = null;
	/**
	 * Service to get information on the portal driver servlet from Spring
	 * config file
	 */
	private DriverConfiguration _driverConfig = null;

	private PortletRegistryAdminService _portletRegistry;
    private RenderConfigAdminService _renderConfig;

	/**
	 * 
	 */
	public void init(PortletConfig config) throws PortletException {
		super.init(config);
		//create a PortletContext reference
		_context = getPortletContext();
		//create a ResourceBundle reference 
		_bundle = config.getResourceBundle(Locale.getDefault());


			//Get admin service implementations
			//First get the Admin config from the context that contains Spring config info
			//loaded by the PortalStartupListener
			//NOTE: This makes use of the shared nature of the Servlet and Portlet context
			_adminConfig = (AdminConfiguration)_context.getAttribute(AttributeKeys.DRIVER_ADMIN_CONFIG);
			_wuService = _adminConfig.getWarUploadAdminService();
			_awService = _adminConfig.getReassembleWarAdminService();
			_dwService = _adminConfig.getDeployWarAdminService();
//			TODO: Configure registry and render service
//			_renderConfig = _adminConfig.getRenderConfigAdminService();


			//TODO:
//			Get handle to DriverConfiguration for hot deployment
//			_driverConfig = (DriverConfiguration)_context.getAttribute(AttributeKeys.DRIVER_CONFIG);
			//TODO: ??Hot deploy by adding new Portlet to DriverConfiguration
			//portlet application Collection and new config info in XML file to
			//PortletApplicationConfiguration object(reread the file?) 
//		}
	}

	public void doView(RenderRequest req, RenderResponse res)
		throws IOException, PortletException {
		//add bundle to session for use on JSP pages
		PortletSession session = req.getPortletSession();
		try {
//			if (session.getAttribute(BUNDLE_ATTR) == null) {
//				session.setAttribute(BUNDLE_ATTR, _bundle);
//			}
			res.setContentType("text/html;charset=UTF-8");
			//get any messages passed from processAction()
//			PortletUiMessage msg = (PortletUiMessage) req.getPortletSession().getAttribute(MSG_PARAM);
//			req.getPortletSession().removeAttribute(MSG_PARAM);
//			LOG.debug("Message in doView(): " + msg);
//			if (msg == null) {
//				//set default blank message
//				msg = new PortletUiMessage("",PortletUiMessageType.INFO);
//			}
//			req.setAttribute(MSG_PARAM, msg);
			//TODO: pass MAX_FILE_UPLOAD_SIZE_PARAM and UPLOAD_PATH_PARAM to view
//			req.setAttribute(MAX_FILE_UPLOAD_SIZE_PARAM, Long.toString(MAX_FILE_UPLOAD_SIZE));
//			req.setAttribute(UPLOAD_PATH_PARAM, UPLOAD_PATH);
		} catch (Throwable e) {
			LOG.error(e);
			session.setAttribute(AttributeKeys.PORTLET_MSG, new PortletUiMessage(e));			
		}
		getPortletContext().getRequestDispatcher(VIEW_JSP).include(req, res);
	}

	public void doEdit(RenderRequest req, RenderResponse res)
		throws IOException, PortletException {
		res.setContentType("text/html;charset=UTF-8");
		PortletSession session = req.getPortletSession();
		try {
//			validateParams(req);
			//get any messages passed from processAction()
			PortletUiMessage msg = (PortletUiMessage) session.getAttribute(AttributeKeys.PORTLET_MSG);
			session.removeAttribute(AttributeKeys.PORTLET_MSG);
			if (msg == null) {
				//set default blank message
				msg = new PortletUiMessage("",PortletUiMessageType.INFO);
			}
			session.setAttribute(AttributeKeys.PORTLET_MSG, msg);
		} catch (Throwable e) {
			LOG.error(e);
			session.setAttribute(AttributeKeys.PORTLET_MSG, new PortletUiMessage(e));			
		}
		getPortletContext().getRequestDispatcher(EDIT_JSP).include(req, res);
	}
	

	public void doHelp(RenderRequest req, RenderResponse res)
	throws IOException, PortletException {
		res.setContentType("text/html;charset=UTF-8");
		getPortletContext().getRequestDispatcher(HELP_JSP).include(req, res);
	}

	public void processAction(ActionRequest req, ActionResponse res)
		throws IOException, PortletException {
		PortletSession session = req.getPortletSession();
		String command = req.getParameter("command");
		if (command.equalsIgnoreCase("uploadfile")) {
			//tmpWarPath is path to temp directory where war is uploaded to
			File tmpWarPath = null;
			File newWar = null;
			try {
				//set max file upload size if present
				Integer oMaxuploadsize = (Integer)session.getAttribute(MAXUPLOAD_SIZE_ATTR);
				if (oMaxuploadsize != null) {
					_wuService.setMaxUploadSize(oMaxuploadsize.intValue());
				}
				tmpWarPath = _wuService.uploadWar(req);
				//Check a flag to see if assembly was NOT requested
				String isAssemblyNotRequested = req.getParameter("no-assembly");
				if (isAssemblyNotRequested == null || 
						(isAssemblyNotRequested != null && 
						(isAssemblyNotRequested.equalsIgnoreCase("no") || 
								isAssemblyNotRequested.equalsIgnoreCase("false")))) {				
						newWar = _awService.reassembleWar(tmpWarPath);
				}
				/* Deploy: Move reassembled war into place and create deployment descriptor and move it into place  */
				//check parameter to skip configuration if already done
				boolean isConfigured = false; 
				String strIsConfigured = req.getParameter(ISCONFIGURED_PARAM);
				if (strIsConfigured != null && (strIsConfigured.equalsIgnoreCase("true") || strIsConfigured.equalsIgnoreCase("yes"))) {
					isConfigured = true;
				}
				_dwService.deployWar(newWar != null ? newWar : tmpWarPath, isConfigured);
	
				
//				String strWarFile = tmpWarPath.getAbsolutePath();
//				String warFile = strWarFile.substring(strWarFile.indexOf(File.separator) + 1);
//				String context = warFile.substring(0, warFile.indexOf('.'));

			//TODO: ???Add parameter to skip publishing in pluto-portal-driver-config.xml			
			//TODO: call registry service to register the war in 
			//	pluto-portal-driver-config.xml file by adding a portlet-app element
	//			try {
	//				_portletRegistry.addPortletApplication(context);
	//			} catch (DriverAdministrationException e) {
	//				LOG.error("Problem registering portlet app.", e);
	//				req.setAttribute(MSG_PARAM, 
	//						new PortletUiMessage(e.getMessage(), PortletUiMessageType.ERROR));			
	//			}
				//TODO: call render service to add the war in 
				//	pluto-portal-driver-config.xml file to render-config section
	//			PageConfig pconfig = new PageConfig();		
	//			pconfig.setName(context);
	//			pconfig.setPortletIds(portlets);
	//			pconfig.setUri("/" + context);
	//			_renderConfig.addPage(pconfig);	
				
				session.setAttribute(AttributeKeys.PORTLET_MSG, 
						new PortletUiMessage("Portlet successfully deployed!", PortletUiMessageType.INFO));			
			} catch (FileUploaderException e) {
				LOG.error("File upload problem", e);
				//TODO: Check to see if message is in the resource bundle
				session.setAttribute(AttributeKeys.PORTLET_MSG, new PortletUiMessage(e));			
			} catch (UtilityException e) {
				LOG.error("Reassembly problem", e);
				session.setAttribute(AttributeKeys.PORTLET_MSG, new PortletUiMessage(e));			
			} catch (DeploymentException e) {
				LOG.error("Deployment problem", e);
				session.setAttribute(AttributeKeys.PORTLET_MSG, new PortletUiMessage(e));			
			} catch (Exception e) {
				LOG.error("Deployment problem", e);
				session.setAttribute(AttributeKeys.PORTLET_MSG, new PortletUiMessage(e));			
			}
			
		} else if (command.equalsIgnoreCase("config")) {
			//TODO: Actions for edit mode???
			// 1. Put the max file upload size in the PortletSession 
//			_service.doEditAction(req, res);
		}
		
	}
	
}
