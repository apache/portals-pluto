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

package org.apache.pluto.driver.actions;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMessages;
import org.apache.pluto.driver.RequestParameters;
import org.apache.pluto.driver.PortalPage;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.PortletWindow;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.portlet.WindowState;
import javax.portlet.PortletMode;
import java.util.Map;
import java.util.Iterator;

/** The entry point of all actions.  This action should be
 *  configured to preprocess ALL actions.  It sets up the
 *  current page and other important attributes.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 22, 2004 at 8:02:27 AM
 */
public class PortalPreProcessingAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest req,
                                 HttpServletResponse res)
    throws Exception {

        // First retrieve and set the current page.
        String pageId = req.getParameter(RequestParameters.PAGE_ID);
        Map pages = (Map)req.getSession()
                        .getAttribute(AttributeKeys.PAGE_SET);

        PortalPage page = null;
        if(pageId!=null) {
            page = (PortalPage)pages.get(pageId);
        }
        else {
            Iterator it = pages.values().iterator();
            if(it.hasNext()) {
                page = (PortalPage)it.next();
            }
        }

        if(page==null) {
            ActionError error = new ActionError("error.page.null", pageId);
            ActionMessages msg = new ActionMessages();
            msg.add(ActionMessages.GLOBAL_MESSAGE, error);
            saveMessages(req, msg);
            return mapping.findForward("failure");
        }

        // Second, retrieve and set the portlet upon which action
        // has occured.
        String portletId =
            req.getParameter(RequestParameters.ACTION_PORTLET_ID);

        // If this exists, update the window state and portlet mode.
        if(portletId!=null) {
            PortletWindow window = page.getPortlet(portletId);
            req.setAttribute(AttributeKeys.ACTION_PORTLET, window);

            String windowState =
                req.getParameter(RequestParameters.WINDOW_STATE);
            if(windowState!=null) {
                window.setWindowState(new WindowState(windowState));
            }

            String portletMode =
                req.getParameter(RequestParameters.PORTLET_MODE);
            if(portletMode!=null) {
                window.setPortletMode(new PortletMode(portletMode));
            }
        }
        req.setAttribute(AttributeKeys.CURRENT_PAGE, page);

        return mapping.findForward("success");
    }
}
