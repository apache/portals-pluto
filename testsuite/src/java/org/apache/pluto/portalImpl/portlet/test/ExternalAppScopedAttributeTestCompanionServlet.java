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
package org.apache.pluto.portalImpl.portlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class ExternalAppScopedAttributeTestCompanionServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        HttpSession session = req.getSession();
        String val = (String)
            session.getAttribute(ExternalAppScopedAttributeTest.INT_KEY);

        if(ExternalAppScopedAttributeTest.VALUE.equals(val)) {
            req.setAttribute("passed", new Boolean(true));

            session.setAttribute(
                ExternalAppScopedAttributeTest.EXT_KEY,
                ExternalAppScopedAttributeTest.VALUE
            );
        }

        RequestDispatcher dis = req.getRequestDispatcher("/jsp/external_app_scoped_test_ext.jsp");
        dis.forward(req, res);

    }
}
