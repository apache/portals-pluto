package ${package}.controller;

import ${package}.dto.User;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.engine.ViewEngineContext;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.MutableActionParameters;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.HeaderMethod;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.RenderMethod;

import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Controller
@PortletConfiguration(
	portletName = "portlet1", resourceBundle = "content.portlet1"
)
public class UserRenderController {

	private static final Logger logger = LoggerFactory.getLogger(UserRenderController.class);

	@Inject
	private Models models;

	@Inject
	private ViewEngineContext viewEngineContext;

	@HeaderMethod(portletNames = {"portlet1"})
	public void renderHeaders(HeaderRequest headerRequest, HeaderResponse headerResponse) {

		String contextPath = headerRequest.getContextPath();
		String linkMarkup = "<link rel=\"stylesheet\" type=\"text/css\" href=\"" +
			contextPath + "/resources/css/main.css\"></link>";
		headerResponse.addDependency("main.css", "${package}", null, linkMarkup);
		logger.debug("[HEADER_PHASE] Added resource: " + linkMarkup);
	}

	@RenderMethod(portletNames = {"portlet1"})
	@ValidateOnExecution(type = ExecutableType.NONE)
	public String prepareView(RenderRequest renderRequest, RenderResponse renderResponse) {

		String viewName = viewEngineContext.getView();

		if (viewName == null) {

			viewName = "user.html";

			User user = (User) models.get("user");

			if (user == null) {
				user = new User();
				models.put("user", user);
			}

			ActionURL actionURL = renderResponse.createActionURL();
			MutableActionParameters actionParameters = actionURL.getActionParameters();
			actionParameters.setValue(ActionRequest.ACTION_NAME, "submitUser");

			models.put("submitUserActionURL", actionURL.toString());
		}

		logger.debug("[RENDER_PHASE] prepared model for viewName: {}", viewName);

		return viewName;
	}
}