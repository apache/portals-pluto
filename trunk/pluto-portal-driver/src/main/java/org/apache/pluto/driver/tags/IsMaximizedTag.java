package org.apache.pluto.driver.tags;

import org.apache.pluto.driver.core.PortalRequestContext;
import org.apache.pluto.driver.url.PortalURL;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspException;
import javax.servlet.http.HttpServletRequest;
import javax.portlet.WindowState;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ddewolf
 * Date: Sep 4, 2006
 * Time: 9:27:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class IsMaximizedTag extends TagSupport {

    private String var;

    public int doStartTag() throws JspException {
        PortalRequestContext portalEnv = PortalRequestContext.getContext(
                (HttpServletRequest) pageContext.getRequest());

        PortalURL portalURL = portalEnv.getRequestedPortalURL();

        // Check if someone else is maximized. If yes, don't show content.
        Map windowStates = portalURL.getWindowStates();
        for (Iterator it = windowStates.values().iterator(); it.hasNext();) {
            WindowState windowState = (WindowState) it.next();
            if (WindowState.MAXIMIZED.equals(windowState)) {
                pageContext.setAttribute(var, Boolean.TRUE);
                break;
            }
        }
        return SKIP_BODY;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

}
