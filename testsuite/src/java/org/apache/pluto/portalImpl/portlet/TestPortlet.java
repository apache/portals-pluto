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
        response.setTitle("My dynamic PortletTitle");

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
