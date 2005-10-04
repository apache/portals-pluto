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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.services.PageRegistryService;

/**
 * PageRegistryPortlet
 *
 * @author Craig Doremus
 *
 */
public class PageRegistryPortlet extends ControllerPortlet {

	private PageRegistryService service;

	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doEdit(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doEdit(RenderRequest request, RenderResponse response)
	throws PortletException, IOException {
	    String rows = request.getParameter("rows");
	    String cols = request.getParameter("cols");
	    if (rows != null && cols != null) {
		    request.setAttribute("rows", rows);
		    request.setAttribute("cols", cols);
		    _incEdit = "/PageRegistryEdit2.jsp";
	    }
	    super.doEdit(request, response);
	}
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		service.getAllPages(request);
		super.doView(request, response);
	}
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#init()
	 */
	public void init() throws PortletException {
		super.init();
		service = new PageRegistryService();
	}
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doHelp(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.doHelp(request, response);
	}
    /* (non-Javadoc)
     * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
     */
	public void processAction(ActionRequest request, ActionResponse response)
		throws PortletException, IOException {

  	try {
			String action = request.getParameter("action");
			log("Action param == " + action);

			/* TODO: Implement portlet deletion
			if (action == null) {
				;//do nothing
			} else if (action.equals("showallpages")) {

			} else if (action.equals("showhome")) {
				_incView = "/PageRegistryView.jsp";
				response.setPortletMode(PortletMode.VIEW);
			} else if (action.equals("showpage")) {
				//TODO: finish implementation
				//shows page for editing of attributes
				service.getPage(request);
				_incEdit = "/PageRegistryEdit.jsp";
				response.setPortletMode(PortletMode.EDIT);
			} else if (action.equals("showpagelayout")) {
				//TODO: finish implementation
				//shows page for editing of layout cells
				service.modifyPageAttributes(request);
				_incEdit = "/PageRegistryEdit2.jsp";
				response.setPortletMode(PortletMode.EDIT);
			} else if (action.equals("savepagelayout")) {
				//TODO: process new layout
//				delegate.savePage(prPath, request);
				response.setPortletMode(PortletMode.VIEW);
			_incView = "/PageRegistryView.jsp";
			}
	*/
		} catch (Throwable e) {
			log("Error! ", e);
			request.getPortletSession().setAttribute(PlutoAdminConstants.ERROR_ATTR, e);
		}
	}
}
