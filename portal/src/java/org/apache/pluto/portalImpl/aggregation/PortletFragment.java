/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.portalImpl.aggregation;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;

import javax.portlet.PortletMode;
import javax.portlet.UnavailableException;
import javax.portlet.WindowState;
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
import org.apache.pluto.portalImpl.services.portletentityregistry.PortletEntityRegistry;
import org.apache.pluto.portalImpl.servlet.ServletObjectAccess;
import org.apache.pluto.portalImpl.util.ObjectID;
import org.apache.pluto.services.information.DynamicInformationProvider;
import org.apache.pluto.services.information.PortalContextProvider;


public class PortletFragment extends AbstractFragmentSingle {

    private PortletWindow portletWindow = null;

    public PortletFragment(String id,
                           ServletConfig config, 
                           org.apache.pluto.portalImpl.aggregation.Fragment parent,
                           org.apache.pluto.portalImpl.om.page.Fragment fragDesc,
                           org.apache.pluto.portalImpl.aggregation.navigation.Navigation navigation)
            throws Exception 
    {
        super(id, config, parent, fragDesc, navigation);           
        String portletEntityId = getInitParameters().getString("portlet");               
        PortletEntity portletEntity = PortletEntityRegistry.getPortletEntity(ObjectID.createFromString(portletEntityId));
        portletWindow = new PortletWindowImpl(getId());                
        ((PortletWindowCtrl)portletWindow).setPortletEntity(portletEntity);
        PortletWindowList windowList = portletEntity.getPortletWindowList();        
        ((PortletWindowListCtrl)windowList).add(portletWindow);        
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpServletRequest wrappedRequest = ServletObjectAccess.getServletRequest(request,portletWindow);

        try {
            PortletContainerFactory.
            getPortletContainer().
            portletLoad(portletWindow, wrappedRequest, response);
        } catch (PortletContainerException e) {
            e.printStackTrace(System.err);
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        }

        PortalEnvironment env = (PortalEnvironment)request.getAttribute(PortalEnvironment.REQUEST_PORTALENV);
        PortalURL thisURL = env.getRequestedPortalURL();

        PortalControlParameter thisControl = new PortalControlParameter(thisURL);
        if (thisControl.isOnePortletWindowMaximized()) {
            WindowState currentState = thisControl.getState(portletWindow);
            if (!WindowState.MAXIMIZED.equals(currentState)) {
                return;
            }
        }

        PrintWriter writer = response.getWriter();
        writer.println("<a name="+thisURL.getLocalNavigationAsString()+"></a>");
        PortletDefinition portletDefinition = portletWindow.getPortletEntity().getPortletDefinition();
        writer.println("<table border='1' cellpadding='1' cellspacing='1' width='100%' height='100%'>");
        writer.println("<tr><td bgcolor='#DDDDDD'>");
        // output title
        writer.println("<table border='0' cellpadding='0' cellspacing='0' width='100%' height='100%'>");
        writer.println("<tr><td>"); //width='70%'

        LanguageSet languageSet = portletDefinition.getLanguageSet();
        Language lang = languageSet.get(request.getLocale());
        String title = lang != null ? lang.getTitle()
                                    : "no title available";

        // get dynamic title
        StringWriter storedWriter = new StringWriter();
        
        if (!portletWindow.getPortletEntity().getPortletDefinition().getServletDefinition().isUnavailable())
        {
            PrintWriter writer2 = new PrintWriter(storedWriter);
            
            HttpServletResponse wrappedResponse = 
                ServletObjectAccess.getStoredServletResponse(response, writer2);
                        
            try {
                PortletContainerFactory.getPortletContainer().renderPortlet(portletWindow, wrappedRequest, wrappedResponse);
            } catch (PortletContainerException e) {
                e.printStackTrace(System.err);
                writer2.println("error occured in portlet!");
            } catch (UnavailableException e) {
                e.printStackTrace(System.err);
                writer2.println("the portlet is currently unavailable!");
                
                ServletDefinitionCtrl servletDefinitionCtrl = (ServletDefinitionCtrl)ControllerObjectAccess.get(portletWindow.getPortletEntity().getPortletDefinition().getServletDefinition());
                if (e.isPermanent()) {
                    servletDefinitionCtrl.setAvailable(Long.MAX_VALUE);
                } else {
                    int unavailableSeconds = e.getUnavailableSeconds();
                    if (unavailableSeconds <= 0) {
                        unavailableSeconds = 60; // arbitrary default
                    }
                    servletDefinitionCtrl.setAvailable(System.currentTimeMillis() + unavailableSeconds * 1000);
                }
            } catch (Throwable t) {
                t.printStackTrace(System.err);
                writer2.println("error occured in portlet!");
            }
            
            String dyn_title = 
            ((DynamicTitleServiceImpl)FactoryAccess.getDynamicTitleContainerService()).getDynamicTitle(portletWindow, request);            
            if (dyn_title!=null) title = dyn_title;            
        }                           

        writer.println("<I><b>" + title + "</b></I>");
        writer.println("</td><td align='right'><font size='-3'>");

        DynamicInformationProvider provider = FactoryAccess.getDynamicProvider(request);
        ContentType supported = portletDefinition.getContentTypeSet().get(wrappedRequest.getContentType());
        PortalContextProvider portalContextProvider = FactoryAccess.getStaticProvider().getPortalContextProvider();

        if (supported != null && portalContextProvider != null) {
            // if portlet supports portlet modes
            Iterator modes = supported.getPortletModes();
            while (modes.hasNext()) {
                PortletMode mode = (PortletMode)modes.next();

                // check whether portal also supports portlet mode
                boolean portalSupport = false;
                Iterator portalSupportedModes = portalContextProvider.getSupportedPortletModes().iterator();
                while (portalSupportedModes.hasNext()) {
                    PortletMode portalSupportedMode = (PortletMode)portalSupportedModes.next();
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
                    if (!mode.equals(currentMode)) {
                        control.setMode(portletWindow, mode);
                        writer.println("<a href='"+modeURL.toString(control,new Boolean(request.isSecure()))+"'>"+mode+"</a>&nbsp;");
                    }
                }
            }

            // create links for window states in portlet header
            Iterator states = portalContextProvider.getSupportedWindowStates().iterator();
            while (states.hasNext()) {
                WindowState state = (WindowState)states.next();
                env = (PortalEnvironment) request.getAttribute(PortalEnvironment.REQUEST_PORTALENV);
                PortalURL stateURL = env.getRequestedPortalURL();
                PortalControlParameter control = new PortalControlParameter(stateURL);
                WindowState currentState = control.getState(portletWindow);
                if (!state.equals(currentState)) {
                    control.setState(portletWindow, state);
                    writer.println("<a href='"+stateURL.toString(control,new Boolean(request.isSecure()))+"'>"+state.toString().substring(0,3)+"</a>&nbsp;");
                }
            }
        }
        writer.println("</font></td></tr>");
        writer.println("</table>");
        // output body
        writer.println("</td></tr>");
        writer.println("<tr><td>");
        if (portletWindow.getPortletEntity().getPortletDefinition().getServletDefinition().isUnavailable()) {
            writer.println("the portlet is currently unavailable!");
        } else {
            writer.println(storedWriter.toString());
/*            
            try {
                PortletContainerFactory.getPortletContainer().renderPortlet(portletWindow, wrappedRequest, response);
            } catch (PortletContainerException e) {
                e.printStackTrace(System.err);
                writer.println("error occured in portlet!");
            } catch (UnavailableException e) {
                e.printStackTrace(System.err);
                writer.println("the portlet is currently unavailable!");
                ServletDefinitionCtrl servletDefinitionCtrl = (ServletDefinitionCtrl)ControllerObjectAccess.get(portletWindow.getPortletEntity().getPortletDefinition().getServletDefinition());
                if (e.isPermanent()) {
                    servletDefinitionCtrl.setAvailable(Long.MAX_VALUE);
                } else {
                    int unavailableSeconds = e.getUnavailableSeconds();
                    if (unavailableSeconds <= 0) {
                        unavailableSeconds = 60; // arbitrary default
                    }
                    servletDefinitionCtrl.setAvailable(System.currentTimeMillis() + unavailableSeconds * 1000);
                }
            } catch (Throwable t) {
                t.printStackTrace(System.err);
                writer.println("error occured in portlet!");
            }
*/            
        }
        writer.println("</td></tr>");
        writer.println("</table>");
    }

    public void createURL(PortalURL url)
    {
        getParent().createURL(url);
        url.addLocalNavigation(getId());
    }

    public boolean isPartOfURL(PortalURL url)
    {
        return true;
    }

    public PortletWindow getPortletWindow() {
        return portletWindow;
    }
}
