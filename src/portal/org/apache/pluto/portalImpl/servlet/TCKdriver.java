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

package org.apache.pluto.portalImpl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.om.entity.PortletApplicationEntity;
import org.apache.pluto.om.entity.PortletApplicationEntityList;
import org.apache.pluto.om.entity.PortletApplicationEntityListCtrl;
import org.apache.pluto.om.entity.PortletEntity;
import org.apache.pluto.om.entity.PortletEntityListCtrl;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinitionList;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.portalImpl.aggregation.RootFragment;
import org.apache.pluto.portalImpl.om.page.impl.FragmentImpl;
import org.apache.pluto.portalImpl.om.page.impl.NavigationImpl;
import org.apache.pluto.portalImpl.om.page.impl.PropertyImpl;
import org.apache.pluto.portalImpl.services.pageregistry.PageRegistry;
import org.apache.pluto.portalImpl.services.portletdefinitionregistry.PortletDefinitionRegistry;
import org.apache.pluto.portalImpl.services.portletentityregistry.PortletEntityRegistry;

/**
 * TCK test driver, that supports generation of pages via URLs as described in the JSR 168 TCK section.
 * 
 */
public class TCKdriver extends org.apache.pluto.portalImpl.Servlet {


    private int testpageNo = 1;
    private int windowNo = 100;  // start with a high # to avoid conficts with already defined windows in portletEntityRegistry
    
    
    public TCKdriver()
    {
    }

    public final String getServletInfo()
    {
        return "portalImpl - Pluto TCK Driver";
    }





    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    public void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
    throws ServletException, IOException {

        // check if it is TCK create page command

        String[] portletNames = servletRequest.getParameterValues("portletName");
        if ( portletNames != null ) {
            String pageName = servletRequest.getParameter("pageName");
            if ( pageName == null ) {
                pageName = "TCK_testpage"+testpageNo++;
            }
            
            // create page with given portlets
            RootFragment root = PageRegistry.getRootFragment();
            ArrayList fragments = new ArrayList();

            PortletApplicationEntityList     entityList     = PortletEntityRegistry.getPortletApplicationEntityList();
            PortletApplicationDefinitionList definitionList = PortletDefinitionRegistry.getPortletApplicationDefinitionList();

            // put all portlets in one column
            StringTokenizer tokenizer;
            Iterator appIt, portletIt;
            for ( int i=0; i < portletNames.length; ++i) {
                tokenizer =  new StringTokenizer(portletNames[i], "/");
                String appName = tokenizer.nextToken();
                String portletName = tokenizer.nextToken();
                appIt = entityList.iterator();
                PortletApplicationEntity appEntity = null;
                // search for application
                boolean found = false;
                while ( appIt.hasNext() && ! found ) {            
                    appEntity = (PortletApplicationEntity) appIt.next();
                    String displayName = appEntity.getPortletApplicationDefinition().getWebApplicationDefinition().getDisplayName(Locale.ENGLISH).getDisplayName();
                    if ( (displayName != null) && (displayName.equals(appName)) )
                      found = true;
                }
                if (!found) {
                    for (Iterator iter = definitionList.iterator(); !found && iter.hasNext();) {
                        PortletApplicationDefinition portletApp = (PortletApplicationDefinition)iter.next();
                        if (portletApp.getId().toString().equals(appName)) {
                            //PortletApplicationEntityListCtrl appEntityListCtrl = (PortletApplicationEntityListCtrl)ControllerObjectAccess.get(entityList);
                            PortletApplicationEntityListCtrl appEntityListCtrl = (PortletApplicationEntityListCtrl)entityList;
                            appEntity = appEntityListCtrl.add(portletApp.getId().toString());
                            log("added Portlet Application " + appName + " to PortletEntityRegistry");
                            found = true;
                        }
                    }
                }
                if ( !found ) {
                    log("Portlet Application "+appName+" not found!");
                    throw new ServletException("Portlet Application "+appName+" not found!");
                }
                portletIt = appEntity.getPortletEntityList().iterator();
                PortletEntity portlet = null;
                // search for portlet
                found = false;
                while ( portletIt.hasNext() && ! found ) {
                    portlet = (PortletEntity) portletIt.next();
                    PortletDefinition tmpPortletDef = portlet.getPortletDefinition();
                    if ( tmpPortletDef == null ) {
    	                log("ERROR: Portlet definition of portlet enity (id="+portlet.getId()+") not found!");
    	                log("       Portlet may not be defined in portlet.xml!");
        	            throw new ServletException("Portlet definition of portlet enity (id="+portlet.getId()+") not found!");
            	    }
                    String tmpPortletName = tmpPortletDef.getName();
                    //delete all existing preferences for this portlet entity
                    if (tmpPortletName != null && tmpPortletName.equals(portletName)) {
                        for (Iterator iter = portlet.getPreferenceSet().iterator(); iter.hasNext();) {
                            iter.next();
                            iter.remove();
                        }
                        found = true;
                    }
                }
                if (!found) {
                    for (Iterator appIter = definitionList.iterator(); !found && appIter.hasNext();) {
                        PortletApplicationDefinition appDef = (PortletApplicationDefinition)appIter.next();
                        if (appDef.getId().toString().equals(appName)) {
                            for (Iterator portletIter = appDef.getPortletDefinitionList().iterator(); !found && portletIter.hasNext();) {
                                PortletDefinition portletDef = (PortletDefinition)portletIter.next();
                                if (portletDef.getId().toString().equals(appName + "." + portletName)) {
                                    //PortletEntityListCtrl entityListCtrl = (PortletEntityListCtrl)ControllerObjectAccess.get(appEntity.getPortletEntityList());
                                    PortletEntityListCtrl entityListCtrl = (PortletEntityListCtrl)appEntity.getPortletEntityList();
                                    portlet = entityListCtrl.add(appEntity, portletDef.getId().toString());
                                    PortletEntityRegistry.refresh(portlet);
                                    log("added Portlet " + portletName + " to PortletEntityRegistry");
                                    found = true;
                                }
                            }
                        }
                    }
                }
                if ( ! found ) {
                    log("ERROR: Portlet "+portletName+" not found!");
                    throw new ServletException("Portlet "+portletName+" not found!");
                }
                FragmentImpl tckPortlet = new FragmentImpl();
                tckPortlet.setType("portlet");
                tckPortlet.setName("p"+windowNo++);   // set portlet
                // property
                PropertyImpl property = new PropertyImpl();
                property.setName("portlet");
                property.setValue(portlet.getId().toString());
                tckPortlet.getProperties().add(property);
                fragments.add(tckPortlet);
            }
            FragmentImpl tckCol = new FragmentImpl();
            tckCol.setType("column");
            tckCol.setName("col");
            tckCol.setFragments(fragments);        
            ArrayList colFragments = new ArrayList();
            colFragments.add(tckCol);
            FragmentImpl tckRow = new FragmentImpl();
            tckRow.setType("row");
            tckRow.setName("row");
            tckRow.setFragments(colFragments);
            ArrayList rowFragments = new ArrayList();
            rowFragments.add(tckRow);
            //page
            FragmentImpl tckPage = new FragmentImpl();
            tckPage.setType("page");
            tckPage.setName(pageName);
            // navigation
            NavigationImpl tckNav = new NavigationImpl();
            tckNav.setTitle(pageName);
            tckNav.setDescription("dynamically generated TCK test page");
            tckPage.setNavigation(tckNav);
            tckPage.setFragments(rowFragments);
   
            try {
                org.apache.pluto.portalImpl.aggregation.Fragment rootFragment = 
                    tckPage.build(getServletConfig(), root);
                root.addChild(rootFragment);
            } catch (Exception e) {
                log("Exception in building new TCK page occured! "+e.getMessage());
                throw new ServletException("Exception in building new TCK page occured!", e);                
            }

            // redirect to newly created page
            StringBuffer path = servletRequest.getRequestURL();
            path.append("/");
            path.append(pageName);
            servletResponse.sendRedirect(path.toString());
            return;
        }


        // normal execution
        super.doGet(servletRequest, servletResponse);
        

    }

   public void doPost (HttpServletRequest request,
                              HttpServletResponse response) throws IOException, ServletException
    {
        doGet (request, response);
    }

    // --- PRIVATE MEMBERS --- //

    private static boolean IS_DEBUG_ENABLED;

}
