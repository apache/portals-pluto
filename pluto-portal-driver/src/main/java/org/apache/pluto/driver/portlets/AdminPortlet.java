package org.apache.pluto.driver.portlets;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class AdminPortlet extends GenericPortlet {

	private static final String VIEW_PAGE = "/WEB-INF/fragments/admin/view.jsp";
	private static final String EDIT_PAGE = "/WEB-INF/fragments/admin/edit.jsp";
	private static final String HELP_PAGE = "/WEB-INF/fragments/admin/help.jsp";
	
	// GenericPortlet Impl -----------------------------------------------------
	
    public void doView(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {
        PortletContext context = getPortletContext();
        PortletRequestDispatcher requestDispatcher =
        		context.getRequestDispatcher(VIEW_PAGE);
        requestDispatcher.include(request, response);
    }

    protected void doEdit(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {
        PortletContext context = getPortletContext();
        PortletRequestDispatcher requestDispatcher =
        		context.getRequestDispatcher(EDIT_PAGE);
        requestDispatcher.include(request, response);
    }
    
    protected void doHelp(RenderRequest request, RenderResponse response)
    throws PortletException, IOException {
    	PortletContext context = getPortletContext();
    	PortletRequestDispatcher requestDispatcher =
    			context.getRequestDispatcher(HELP_PAGE);
    	requestDispatcher.include(request, response);
    }
    
}
