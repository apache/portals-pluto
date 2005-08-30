/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 

 */

package org.apache.pluto.portalImpl.aggregation;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.UnavailableException;
import javax.portlet.WindowState;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.om.ControllerObjectAccess;
import org.apache.pluto.om.common.Language;
import org.apache.pluto.om.common.LanguageSet;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.om.portlet.ContentType;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.servlet.ServletDefinition;
import org.apache.pluto.om.servlet.ServletDefinitionCtrl;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.om.window.PortletWindowCtrl;
import org.apache.pluto.om.window.PortletWindowList;
import org.apache.pluto.om.window.PortletWindowListCtrl;
import org.apache.pluto.portalImpl.core.DynamicTitleServiceImpl;
import org.apache.pluto.portalImpl.core.PortalControlParameter;
import org.apache.pluto.portalImpl.core.PortalEnvironment;
import org.apache.pluto.portalImpl.core.PortalURL;
import org.apache.pluto.portalImpl.core.PortletContainerFactory;
import org.apache.pluto.portalImpl.factory.FactoryAccess;
import org.apache.pluto.portalImpl.om.window.impl.PortletWindowImpl;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.portalImpl.services.portletentityregistry.PortletEntityRegistry;
import org.apache.pluto.portalImpl.servlet.ServletObjectAccess;
import org.apache.pluto.portalImpl.servlet.ServletResponseImpl;
import org.apache.pluto.portalImpl.util.ObjectID;
import org.apache.pluto.services.information.DynamicInformationProvider;
import org.apache.pluto.services.information.PortalContextProvider;
import org.apache.pluto.services.log.Logger;

/**
 * <p>Responsible for rendering a single Portlet.<p>
 *
 * <p>Requires two JSP files to exist, PortletFragmentHeader.jsp
 * and PortletFragmentFooter.jsp. These pages define the header
 * and footer of the portlet.</p>
 *
 * <p>A PortletFragment.PortletInfo object is added to the request
 * attributes and makes information about the Portlet available to the
 * header and footer JSP pages.</p>
 *
 * @author Stephan Hesmer
 * @author Nick Lothian
 *
 */
public class PortletFragment extends AbstractFragmentSingle {
    
    private PortletWindow portletWindow;
    private Logger log;

    public static final String PORTLET_ERROR_MSG = "Error occurred in portlet!";

    public PortletFragment(String id,
                           ServletConfig config,
                           org.apache.pluto.portalImpl.aggregation.Fragment parent,
                           org.apache.pluto.portalImpl.om.page.Fragment fragDesc,
                           org.apache.pluto.portalImpl.aggregation.navigation.Navigation navigation)
            throws Exception
    {
		super(id, config, parent, fragDesc, navigation);
        log = Log.getService().getLogger(getClass());
		String portletEntityId = getInitParameters().getString("portlet");
		PortletEntity portletEntity = PortletEntityRegistry.getPortletEntity(ObjectID.createFromString(portletEntityId));
		portletWindow = new PortletWindowImpl(getId());
		((PortletWindowCtrl) portletWindow).setPortletEntity(portletEntity);
		PortletWindowList windowList = portletEntity.getPortletWindowList();
		((PortletWindowListCtrl) windowList).add(portletWindow);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
		HttpServletRequest wrappedRequest = ServletObjectAccess.getServletRequest(request, portletWindow);
		ServletResponseImpl wrappedResponse = (ServletResponseImpl)ServletObjectAccess.getServletResponse(response);
		PrintWriter responseWriter = response.getWriter();
		StringWriter storedWriter = new StringWriter();

		// load the Portlet
		// If there is an error loading, then we will save the error message and attempt
		// to render it inside the Portlet, so the Portal has a chance of still looking
		// okay
		String errorMsg = null;
		try {
			PortletContainerFactory.getPortletContainer().portletLoad(portletWindow, wrappedRequest, response);
		} catch (PortletContainerException e) {
			log.error("Error in Portlet", e);
			errorMsg = getErrorMsg();
		} catch (Throwable t) {
			// If we catch any throwable, we want to try to continue
			// so that the rest of the portal renders correctly
			log.error("Error in Portlet", t);
			if (t instanceof VirtualMachineError) {
				// if the Throwable is a VirtualMachineError then
				// it is very unlikely (!) that the portal is going
				// to render correctly.
				throw (Error) t;
			} else {
				errorMsg = getErrorMsg();
			}

		}

		PortalEnvironment env = (PortalEnvironment) request.getAttribute(PortalEnvironment.REQUEST_PORTALENV);
		PortalURL thisURL = env.getRequestedPortalURL();

		PortalControlParameter thisControl = new PortalControlParameter(thisURL);
		if (thisControl.isOnePortletWindowMaximized()) {
			WindowState currentState = thisControl.getState(portletWindow);
			if (!WindowState.MAXIMIZED.equals(currentState)) {
				return;
			}
		}

		PortletDefinition portletDefinition = portletWindow.getPortletEntity().getPortletDefinition();
		LanguageSet languageSet = portletDefinition.getLanguageSet();
		Language lang = languageSet.get(request.getLocale());
		String title = lang != null ? lang.getTitle() : "no title available";

		// create a PortletInfo object. This is used to communicate with
		// the header and footer JSP pages for this portlet
		PortletInfo portletInfo = new PortletInfo();
		
        ServletDefinition servletDefinition = portletWindow.getPortletEntity().getPortletDefinition().getServletDefinition();
        if (servletDefinition != null && !servletDefinition.isUnavailable()) {
			PrintWriter writer2 = new PrintWriter(storedWriter);

			// create a wrapped response which the Portlet will be rendered to
			wrappedResponse = (ServletResponseImpl)ServletObjectAccess.getStoredServletResponse(response, writer2);

			try {
				// render the Portlet to the wrapped response, to be output later.
				PortletContainerFactory.getPortletContainer().renderPortlet(portletWindow, wrappedRequest, wrappedResponse);
			} catch (UnavailableException e) {
				log.error("Portlet is Unavailable", e);
				writer2.println("the portlet is currently unavailable!");

				ServletDefinitionCtrl servletDefinitionCtrl = (ServletDefinitionCtrl) ControllerObjectAccess.get(portletWindow.getPortletEntity().getPortletDefinition().getServletDefinition());
				if (e.isPermanent()) {
					servletDefinitionCtrl.setAvailable(Long.MAX_VALUE);
				} else {
					int unavailableSeconds = e.getUnavailableSeconds();
					if (unavailableSeconds <= 0) {
						unavailableSeconds = 60; // arbitrary default
					}
					servletDefinitionCtrl.setAvailable(System.currentTimeMillis() + unavailableSeconds * 1000);
				}
			} catch (Exception e) {
				log.error("Error in Portlet", e);
				writer2.println(getErrorMsg());
			}
			String dyn_title = ((DynamicTitleServiceImpl) FactoryAccess.getDynamicTitleContainerService()).getDynamicTitle(portletWindow, request);
			if (dyn_title != null) {
				title = dyn_title;
			}

		}
		// set the title, so the header JSP page can use it when rendering
		portletInfo.setTitle(title);

		DynamicInformationProvider provider = FactoryAccess.getDynamicProvider(request);
		ContentType supported = portletDefinition.getContentTypeSet().get(wrappedResponse.getContentType());
		PortalContextProvider portalContextProvider = FactoryAccess.getStaticProvider().getPortalContextProvider();

		// get the list of modes this Portlet supports
		if (supported != null && portalContextProvider != null) {
			// if portlet supports portlet modes
			Iterator modes = supported.getPortletModes();
			while (modes.hasNext()) {
				PortletMode mode = (PortletMode) modes.next();

				// check whether portal also supports portlet mode
				boolean portalSupport = false;
				Iterator portalSupportedModes = portalContextProvider.getSupportedPortletModes().iterator();
				while (portalSupportedModes.hasNext()) {
					PortletMode portalSupportedMode = (PortletMode) portalSupportedModes.next();
					if (mode.equals(portalSupportedMode)) {
						portalSupport = true;
						break;
					}
				}

				// create links for portlet modes in portlet header
				if (portalSupport) {
					env = (PortalEnvironment) request.getAttribute(PortalEnvironment.REQUEST_PORTALENV);
					PortalURL modeURL = env.getRequestedPortalURL();

					PortalControlParameter control = new PortalControlParameter(modeURL);
					PortletMode currentMode = control.getMode(portletWindow);
					control.setMode(portletWindow, mode);

					portletInfo.addPortletMode(mode, modeURL.toString(control, new Boolean(request.isSecure())), mode.equals(currentMode));
				}
			}

			// get the list of window states this Portlet supports
			Iterator states = portalContextProvider.getSupportedWindowStates().iterator();
			while (states.hasNext()) {
				WindowState state = (WindowState) states.next();
				env = (PortalEnvironment) request.getAttribute(PortalEnvironment.REQUEST_PORTALENV);
				PortalURL stateURL = env.getRequestedPortalURL();
				PortalControlParameter control = new PortalControlParameter(stateURL);
				WindowState currentState = control.getState(portletWindow);

				control.setState(portletWindow, state);
				portletInfo.addPortletWindowState(state.toString().substring(0, 3), stateURL.toString(control, new Boolean(request.isSecure())), state.equals(currentState));
			}
		}
		// output the header JSP page
		request.setAttribute("portletInfo", portletInfo);
		RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher(BASE_ROOT + "PortletFragmentHeader.jsp");
		rd.include(request, response);
		try {
			// output the Portlet
			// check if there is an error message
			if (errorMsg == null) {
				// no error message, so output the Portlet
				if (portletWindow.getPortletEntity().getPortletDefinition().getServletDefinition().isUnavailable()) {
					// the portlet is unavailable
					responseWriter.println("the portlet is currently unavailable!");
				} else {
					responseWriter.println(storedWriter.toString());
				}
			} else {
				// output the errror message
				responseWriter.println(errorMsg);
			}
		} finally {
			// output the footer JSP page
			RequestDispatcher rdFooter = getServletConfig().getServletContext().getRequestDispatcher(BASE_ROOT + "PortletFragmentFooter.jsp");
			rdFooter.include(request, response);
			request.removeAttribute("portletInfo");
		}

	}

	public void createURL(PortalURL url) {
		getParent().createURL(url);
		url.addLocalNavigation(getId());
	}

	public boolean isPartOfURL(PortalURL url) {
		return true;
	}

	public PortletWindow getPortletWindow() {
		return portletWindow;
	}

	public static class PortletInfo {
		private String title;
		private List availablePortletModes = new ArrayList();
		private List availablePortletWindowStates = new ArrayList();

		/**
		 * @return portlet title.
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * @param string representing the new title.
		 */
		public void setTitle(String string) {
			title = string;
		}

		/**
		 * @return available modes
		 */
		public List getAvailablePortletModes() {
			return availablePortletModes;
		}

		public void addPortletMode(PortletMode mode, String activationURL, boolean isCurrent) {
		    PortletModeInfo pmi = new PortletModeInfo(mode.toString(), activationURL, isCurrent);
			availablePortletModes.add(pmi);
		}

		/**
		 * @return list of all available portlet states.
		 */
		public List getAvailablePortletWindowStates() {
			return availablePortletWindowStates;
		}

		public void addPortletWindowState(String stateLabel, String activationURL, boolean isCurrent) {
			PortletWindowStateInfo pwsi = new PortletWindowStateInfo(stateLabel, activationURL, isCurrent);
			availablePortletWindowStates.add(pwsi);
		}

	}

	public static class PortletWindowStateInfo implements Comparable {
		private String label;
		private String url;
		private boolean isCurrent;

		/**
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Object compare) {
			if (!(compare instanceof PortletWindowStateInfo)) {
				throw new ClassCastException(compare + " is not a " + PortletWindowStateInfo.class.getName());
			} else {
				PortletWindowStateInfo other = (PortletWindowStateInfo) compare;
				return this.getLabel().compareTo(other.getLabel());
			}
		}
		/**
		 * @param stateLabel
		 * @param activationURL
		 * @param isCurrent
		 */
		public PortletWindowStateInfo(String stateLabel, String activationURL, boolean isCurrent) {
			this.label = stateLabel;
			this.url = activationURL;
			this.isCurrent = isCurrent;
		}
		/**
		 * @return the label.
		 */
		public String getLabel() {
			return label;
		}

		/**
		 * @param string
		 */
		public void setLabel(String string) {
			label = string;
		}

		/**
		 * @return current indicator.
		 */
		public boolean isCurrent() {
			return isCurrent;
		}

		/**
		 * @return url
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * @param b
		 */
		public void setCurrent(boolean b) {
			isCurrent = b;
		}

		/**
		 * @param string
		 */
		public void setUrl(String string) {
			url = string;
		}

		public String toString() {
			return getLabel();
		}

	}

	public static class PortletModeInfo implements Comparable {
		private String name;
		private String url;
		private boolean isCurrent;

		public PortletModeInfo(String name, String url, boolean isCurrent) {
			this.name = name;
			this.url = url;
			this.isCurrent = isCurrent;
		}

		/**
		 * @return current flag
		 */
		public boolean isCurrent() {
			return isCurrent;
		}

		/**
		 * @return name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return url
		 */
		public String getUrl() {
			return url;
		}

		/**
		 * @param b
		 */
		public void setCurrent(boolean b) {
			isCurrent = b;
		}

		/**
		 * @param string
		 */
		public void setName(String string) {
			name = string;
		}

		/**
		 * @param string
		 */
		public void setUrl(String string) {
			url = string;
		}

		/**
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Object compare) {
			if (!(compare instanceof PortletModeInfo)) {
				throw new ClassCastException(compare + " is not a " + PortletModeInfo.class.getName());
			} else {
				PortletModeInfo other = (PortletModeInfo) compare;
				return this.getName().compareTo(other.getName());
			}
		}

		public String toString() {
			return getName();
		}
	}

    protected String getErrorMsg() {
        return PORTLET_ERROR_MSG;
    }



}
