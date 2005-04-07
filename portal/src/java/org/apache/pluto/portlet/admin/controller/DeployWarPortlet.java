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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.bean.PageTO;
import org.apache.pluto.portlet.admin.bean.PortletMessage;
import org.apache.pluto.portlet.admin.bean.PortletMessageType;
import org.apache.pluto.portlet.admin.services.DeployWarService;


/**
 * Deploys a Portlet Application in a war file including adding a
 * record to portletentityregistry.xml and pageregistry.xml.
 *
 * @author Ken Atherton
 *
 */
public class DeployWarPortlet extends ControllerPortlet {
	private DeployWarService service = null;


	protected void doEdit(RenderRequest request, RenderResponse response)
	throws PortletException, IOException {
		super.doEdit(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		super.doView(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#init()
	 */
	public void init() throws PortletException {
		super.init();
		service = new DeployWarService();
	}

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doHelp(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		super.doHelp(request, response);
	}

    public void processAction(ActionRequest request, ActionResponse response)
            throws PortletException, IOException
    {
	  	try {
				String action = request.getParameter("action");
				log("Action param == " + action);

				if (action == null) {
					//process file upload
 	  		  String fileName = service.processFileUpload(request,response);

 	  		  //Remove .war from the name
					int index = fileName.indexOf(".war");
					String name = null;
					if ( index != -1) {
						name = fileName.substring(0, index);
					} else {
						name = fileName;
					}
					//Add to portletcontexts.txt (for Release Candidate 2+)
					service.addToPortletContexts(name);

					//Create a new Page
					PageTO oPage = new PageTO();
					oPage.setName(name);
					request.getPortletSession().setAttribute(PlutoAdminConstants.PAGE_ATTR, oPage);

					//forward to next page to pick rows/cols
					_incView = "/portlets/admin/PageRegistryAdd.jsp";
					response.setPortletMode(PortletMode.VIEW);

				} else if (action.equals("showhome")) {

					_incView = "/portlets/admin/DeployWarView.jsp";
					response.setPortletMode(PortletMode.VIEW);

				} else if (action.equals("showpagelayout")) {

					PortletSession session = request.getPortletSession();
					PageTO page = (PageTO)session.getAttribute(PlutoAdminConstants.PAGE_ATTR);
					String name = "";
					if (page != null) {
						name = page.getName();
					}
					if (page != null && !service.pageExists(name)) {
						service.setPage(request);
						//forward to page layout page
						_incView = "/portlets/admin/PageRegistryAdd2.jsp";
					} else {
						session.setAttribute(PlutoAdminConstants.MESSAGE_ATTR, new PortletMessage("Page '" + name + "' already exists in pageregistry.xml", PortletMessageType.INFO));
						_incView = "/portlets/admin/DeployWarView.jsp";
					}
					response.setPortletMode(PortletMode.VIEW);

				} else if (action.equals("savepagelayout")) {

					service.savePageLayout(request);
					//forward to first page
          request.getPortletSession().setAttribute(PlutoAdminConstants.MESSAGE_ATTR, new PortletMessage("Deployment successful. Please restart the Pluto portal.", PortletMessageType.SUCCESS));
					_incView = "/portlets/admin/DeployWarView.jsp";
					response.setPortletMode(PortletMode.VIEW);
				}

	  	} catch (Throwable e) {
				log("Error! ", e);
			    request.getPortletSession().setAttribute(PlutoAdminConstants.MESSAGE_ATTR, new PortletMessage("A problem has occurred: " + e.getMessage() + ". Please check the servlet container's error log.", PortletMessageType.ERROR));
			}
    }

}
