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
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.pluto.driver.Portal;
import org.apache.pluto.driver.PortalPage;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.impl.PortletWindowImpl;
import org.apache.pluto.driver.impl.PortletWindowImpl;
import org.apache.pluto.PortletWindow;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/** Action implementation which invokes the container to perform
 *  actions for a specified portlet.
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 8:40:41 AM
 */
public class PortletActionAction extends Action {
    
    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest req,
                                 HttpServletResponse res)
    throws Exception {

        PortletWindow window = (PortletWindow)req
                                   .getAttribute(AttributeKeys.ACTION_PORTLET);
        Portal.getPortal().doAction(window, req,res);
        // Hmm, I'm not sure here. . .
        // My guess is this shouldn't happen, but what if
        // a response.sendRedirect has occurred?  Perhaps
        // we need to track this a little better. . .
        if(!res.isCommitted()) {
            return mapping.findForward("render");
        }
        else {
            // It's been commited, so we want to do nothing.
            return mapping.findForward("success");
        }
    }
}
