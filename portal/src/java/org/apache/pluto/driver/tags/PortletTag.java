package org.apache.pluto.driver.tags;

import java.util.Iterator;
import java.util.Map;

import javax.portlet.WindowState;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.config.PortletWindowConfig;
import org.apache.pluto.driver.core.PortalEnvironment;
import org.apache.pluto.driver.core.PortalServletRequest;
import org.apache.pluto.driver.core.PortalServletResponse;
import org.apache.pluto.driver.core.PortalURL;
import org.apache.pluto.driver.core.PortletWindowImpl;
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 * @version $Id$
 */
public class PortletTag extends BodyTagSupport {

    private static final Log LOG =
        LogFactory.getLog(PortletTag.class);

    public static final int FAILED = 0;
    public static final int SUCCESS = 1;

    private String portletId;
    private String evaluatedPortletId;

    // Cached Results!
    private PortalServletResponse response;
    private int status;
    private Throwable throwable;


    public int doStartTag() throws JspException {
        evaluateExpressions();
        ServletContext ctx = pageContext.getServletContext();
        DriverConfiguration config = (DriverConfiguration)
            ctx.getAttribute(AttributeKeys.DRIVER_CONFIG);

        PortletWindowConfig winConfig = (PortletWindowConfig)
            config.getPortletWindowConfig(evaluatedPortletId);

        if (LOG.isDebugEnabled()) {
            LOG.debug("Rendering Portlet Window: " + winConfig);
        }


        PortalEnvironment env = (PortalEnvironment) pageContext.getRequest()
            .getAttribute(PortalEnvironment.REQUEST_PORTALENV);

        PortalURL thisURL = env.getRequestedPortalURL();

        PortletWindow window = new PortletWindowImpl(winConfig, thisURL);

        Map states = thisURL.getWindowStates();
        Iterator it = states.keySet().iterator();
        while (it.hasNext()) {
            String wdw = (String) it.next();
            WindowState state = (WindowState) states.get(wdw);
            if (WindowState.MAXIMIZED.equals(state) &&
                !window.getId().equals(wdw)) {
                // Someone else is maximized, don't show my content.
                return SKIP_BODY;
            }
        }

        HttpServletRequest request = (HttpServletRequest)
            pageContext.getRequest();

        PortalServletRequest req =
            new PortalServletRequest(request, window);

        PortalServletResponse res =
            new PortalServletResponse(
                (HttpServletResponse) pageContext.getResponse());

        PortletContainer container = (PortletContainer)
            ctx.getAttribute(AttributeKeys.PORTLET_CONTAINER);

        try {
            container.doRender(window, req, res);
            response = res;
            status = SUCCESS;
        } catch (Throwable e) {
            status = FAILED;
            throwable = e;
        }
        return EVAL_BODY_INCLUDE;
    }

    int getStatus() {
        return status;
    }

    PortalServletResponse getPortalServletResponse() {
        return response;
    }

    Throwable getThrowable() {
        return throwable;
    }

    String getEvaluatedPortletId() {
        return evaluatedPortletId;
    }

    public String getPortletId() {
        return portletId;
    }

    public void setPortletId(String portletId) {
        this.portletId = portletId;
    }

    private void evaluateExpressions()
        throws JspException {
        Object obj = ExpressionEvaluatorManager.evaluate("portletId",
                                                         portletId,
                                                         String.class, this,
                                                         pageContext);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Evaluated portletId to: " + obj);
        }
        evaluatedPortletId = (String) obj;
    }
}
