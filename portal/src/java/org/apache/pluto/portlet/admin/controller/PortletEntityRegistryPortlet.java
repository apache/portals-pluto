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

import org.apache.pluto.portlet.admin.services.PortletRegistryService;


/**
 * Portlet concerned with portletentityregistry.xml persistence.
 *
 * @author Craig Doremus
 *
 */
public class PortletEntityRegistryPortlet extends ControllerPortlet {
	private PortletRegistryService service = null;
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doEdit(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		log("Edit Mode");
		super.doEdit(request, response);
	}
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
	  	log("View Mode");
	  	String perPath = getPortletRegistryFilePath();
	  	log("PER file path = " + perPath);
	  	//get the new registry list and add to session
	  	service.getPortletEntityRegistry(request);
	  	super.doView(request, response);
	}
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#init()
	 */
	public void init() throws PortletException {
		super.init();
  	service = new PortletRegistryService();
	}
	/* (non-Javadoc)
	 * @see javax.portlet.GenericPortlet#doHelp(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
  	log("Help Mode");
		super.doHelp(request, response);
	}
    /* (non-Javadoc)
     * @see javax.portlet.Portlet#processAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
     */
    public void processAction(ActionRequest request, ActionResponse response)
            throws PortletException, IOException {
    	String action = request.getParameter("action");
    	log("action param == " + action);
   	 /*//TODO: Implement editing
    	printParams(request);
    	if (action == null) {
    		;//so we don't have to do null checks later
    		response.setPortletMode(PortletMode.EDIT);
    	} else if (action.equals("showportlet")) {
    		//Edit link clicked on View page
    	  service.getPortletEntityRegistryApp(request);
//    		delegate.getPortletEntityRegistryApp(perPath, request, response);
    		_incEdit = "/PortletEntityRegistryEdit.jsp";
    		response.setPortletMode(PortletMode.EDIT);
    	} else if (action.equals("addportlet")) {
    		//Add Portlet button on View page clicked
//    		delegate.addPortletEntityRegistryApp(perPath, request, response);
    		_incEdit = "/PortletEntityRegistryEdit.jsp";
    		response.setPortletMode(PortletMode.EDIT);
    	} else if (action.equals("showprefs")) {
    		//show portlet preferences
    		String appId = request.getParameter("appId");
    		String portletId = request.getParameter("portletId");
//    	  delegate.getPortletPreferences(perPath, request, response);
    		service.getPortletPreferences(request);
    		_incEdit = "/PERPortletPreferencesEdit.jsp?appId=" + appId + "&portletId=" + portletId;
    		response.setPortletMode(PortletMode.EDIT);
    	} else if (action.equals("addpref")) {
    		//add a portlet preference name/value pair
    		String appId = request.getParameter("appId");
    		String portletId = request.getParameter("portletId");
//    		delegate.addPortletPreference(perPath, request, response);
    		_incEdit = "/PERPortletPreferencesEdit.jsp?appId=" + appId + "&portletId=" + portletId;
    		response.setPortletMode(PortletMode.EDIT);
    	} else if (action.equals("addportlettoapp")) {
    		//Add a portlet to App on Edit page
    		//add a portlet preference name/value pair
    		String appId = request.getParameter("appId");
    		String portletId = request.getParameter("portletId");
//    		delegate.addPortlet(perPath, request, response);
    		_incEdit = "/PortletEntityRegistryEdit.jsp";
    		response.setPortletMode(PortletMode.EDIT);
    	} else if (action.equals("savepref")) {
    		//Button clicked on Preference Edit page
    		String submit = request.getParameter("submit");
    		log("Button clicked: " + submit);
    		//ignore Cancel button
    		if (submit.equalsIgnoreCase("OK")) {
	    		//add the pref data to the session
//	    		delegate.savePreference(perPath, request, response);
    		}
    		_incEdit = "/PortletEntityRegistryEdit.jsp";
    		response.setPortletMode(PortletMode.EDIT);
    	} else if (action.equals("saveportlet")) {
    		String submit = request.getParameter("submit");
    		log("Button clicked: " + submit);
    		//ignore Cancel button
    		//Save button clicked on Edit page
    		if (submit.equalsIgnoreCase("Save")) {
	    		//Save the portlet data to portletentityregistry.xml
//	    		delegate.savePortlet(perPath, request, response);
    		}
    		_incView = "/PortletEntityRegistryView.jsp";
    		response.setPortletMode(PortletMode.VIEW);
    	}
    	printParams(request);
*/
    }
}
