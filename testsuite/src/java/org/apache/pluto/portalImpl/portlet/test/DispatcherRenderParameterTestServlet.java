/*
 * Copyright 2004 The Apache Software Foundation
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

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 9, 2005
 */
public class DispatcherRenderParameterTestServlet extends GenericServlet {

    public DispatcherRenderParameterTestServlet() {

    }

    public void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException {
        String valA = req.getParameter(DispatcherRenderParameterTest.KEY_A);
        String valB = req.getParameter(DispatcherRenderParameterTest.KEY_B);
        if(DispatcherRenderParameterTest.VAL_A.equals(valA) && DispatcherRenderParameterTest.VAL_B.equals(valB)) {
            req.setAttribute(DispatcherRenderParameterTest.RESULT_KEY, Boolean.TRUE);
        }
    }

    public String getServletInfo() {
        return "Dispather Render Parameter Include Servlet";
    }

}

