package javax.portlet.tck.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnvironmentTests_PortletContext_ApiRender_servlets extends HttpServlet {
	private static final String LOG_CLASS = 
			   EnvironmentTests_PortletContext_ApiRender_servlets.class.getName();
		   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

		   @Override
		   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		         throws ServletException, IOException {
		      processTCKReq(req, resp);
		   }

		   @Override
		   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		         throws ServletException, IOException {
		      processTCKReq(req, resp);
		   }

		   // The tck uses only get & post requests
		   protected void processTCKReq(HttpServletRequest request, HttpServletResponse response)
		         throws ServletException, IOException {
		      LOGGER.entering(LOG_CLASS, "servlet entry");


		   }
		}
