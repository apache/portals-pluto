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

package org.apache.pluto.portalImpl.portlet;

import javax.portlet.*;
import java.io.IOException;

public class TestPortlet extends GenericPortlet
{

    public void processAction (ActionRequest request, ActionResponse actionResponse) 
      throws PortletException, java.io.IOException
    {
        String checkAction;
        String checkActionRender;
        String checkPreferences;
        String jspNameTransfer;
        PortletSession portletSession;
        
        portletSession = request.getPortletSession();

        //corresponding action to test4.jsp part1:'checkAction'
        checkAction = (String)request.getParameter("checkAction");
        if ( checkAction != null ) {
            portletSession.setAttribute("checkAction", checkAction);
            actionResponse.setRenderParameter("jspName", "test4.jsp");
        }

        //corresponding action to test4.jsp part2:'checkActionRender'
        checkActionRender = (String)request.getParameter("checkActionRender");
        if(checkActionRender != null && "step1".equals(checkActionRender))
        {
           actionResponse.setRenderParameter("checkActionRender2","step2");
        }
        
        //corresponding action to test6.jsp:'testPreferenceStore' (called from test5.jsp)
        checkPreferences = (String)request.getParameter("checkPreferences");
        if (checkPreferences != null)
        {
            PortletPreferences preferences = request.getPreferences();

            if ("storeAndReset".equals(checkPreferences))
            {
                // store test
                preferences.setValue("TEST_RESET_KEY", "Hello");
                preferences.setValue("TEST_PERMANENCE", "permanent");
                preferences.setValue("TEST_NULL_VALUE", null);
                preferences.setValues("TEST_NULL_VALUES", null);
                preferences.store();

                // reset test
                preferences.reset("TEST_RESET_KEY");
                preferences.store();

                // validation test
                preferences.setValue("VALIDATION_TEST_KEY", " Test PreferencesValidator failed.");
                try
                {
                    preferences.store();
                } 
                catch (ValidatorException e)
                {
                    preferences.setValue("VALIDATION_TEST_KEY", "Expected ValidationException occured");
                    preferences.store();
                }

                // reset after method test
                preferences.setValue("TEST_RESET_2", "success");
            }
            else if ("TidyUp".equals(checkPreferences))
            {
                // reset test
                preferences.reset("TEST_NULL_VALUE");
                preferences.reset("TEST_NULL_VALUES");
                preferences.reset("VALIDATION_TEST_KEY");
                preferences.store();
            }
        }

        // transfer jsp name
        jspNameTransfer = (String)request.getParameter("jspNameTransfer");
        if (jspNameTransfer!=null)
        {
            actionResponse.setRenderParameter("jspName",jspNameTransfer);
        }

        request.setAttribute("portletaction","action1");
        actionResponse.setPortletMode(PortletMode.HELP);
    }

    public void doDispatch (RenderRequest request,
                        RenderResponse response) throws PortletException, IOException
    {
        WindowState state = request.getWindowState();

        if ( ! state.equals(WindowState.MINIMIZED)) {
        	
        	response.setContentType("text/html");
            String jspName = request.getParameter("jspName");
            if (jspName==null) {
                PortletSession session = request.getPortletSession(false);
                if (session!=null)
                {
                    jspName = (String)session.getAttribute("jspName", PortletSession.PORTLET_SCOPE);
                }
                if (jspName==null) jspName = "test1.jsp";
            }
            else
            {
                PortletSession session = request.getPortletSession(false);
                if (session!=null)
                {
                    session.setAttribute("jspName", jspName, PortletSession.PORTLET_SCOPE);
                }
            }
            PortletContext context = getPortletContext();
            PortletRequestDispatcher rd = context.getRequestDispatcher("/jsp/"+jspName);
            rd.include(request,response);
        }
    }
}
