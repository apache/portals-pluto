package org.apache.pluto.portalImpl.portlet.test;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
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
