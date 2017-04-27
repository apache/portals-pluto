package ${package};

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldPortlet extends GenericPortlet {

	private static final Logger logger = LoggerFactory.getLogger(HelloWorldPortlet.class);

	public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse)
		throws PortletException, IOException {

		String contextPath = headerRequest.getContextPath();
		String linkMarkup = "<link rel=\"stylesheet\" type=\"text/css\" href=\"" +
			contextPath + "/resources/css/main.css\"></link>";
		headerResponse.addDependency("main.css", "${package}", null, linkMarkup);
		logger.debug("[HEADER_PHASE] Added resource: " + linkMarkup);
	}

	protected void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {

		String foo = getPortletConfig().getInitParameter("foo");
		logger.debug("[RENDER_PHASE] init-param foo: " + foo);
		String viewPath = "/WEB-INF/views/portletViewMode.jspx";
		PortletRequestDispatcher portletRequestDispatcher =
			getPortletContext().getRequestDispatcher(viewPath);
		portletRequestDispatcher.include(renderRequest, renderResponse);
		logger.debug("[RENDER_PHASE] Rendering view: " + viewPath);
	}
}