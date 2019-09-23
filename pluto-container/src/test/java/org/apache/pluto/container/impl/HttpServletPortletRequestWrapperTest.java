package org.apache.pluto.container.impl;

import javax.portlet.PortalContext;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.PortletWindowID;
import org.jmock.Mock;
import org.jmock.cglib.MockObjectTestCase;

public class HttpServletPortletRequestWrapperTest extends MockObjectTestCase {

    private Mock mockHttpRequest = mock(HttpServletRequest.class);
    private Mock mockServletContext = mock(ServletContext.class);
    private Mock mockSession = mock(HttpSession.class);
    private Mock mockResourceRequest = mock(ResourceRequest.class);
    private Mock mockPortletRequestContext = mock(PortletRequestContext.class);
    private Mock mockPortletContainer = mock(PortletContainer.class);
    private Mock mockContainerServices = mock(ContainerServices.class);
    private Mock mockNamespaceMapper = mock(NamespaceMapper.class);
    private Mock mockPortalContext = mock(PortalContext.class);
    private Mock mockPortletWindow = mock(PortletWindow.class);
    private Mock mockPortletWindowId = mock(PortletWindowID.class);
    
    private HttpServletRequest httpRequest = (HttpServletRequest)mockHttpRequest.proxy();
    private HttpSession httpSession = (HttpSession)mockSession.proxy();
    private ServletContext servletContext = (ServletContext)mockServletContext.proxy();
    private ResourceRequest portletRequest = (ResourceRequest)mockResourceRequest.proxy();
    private PortletRequestContext portletRequestContext = (PortletRequestContext)mockPortletRequestContext.proxy();
    

    
    protected void setUp( ) throws Exception
    {
        super.setUp();
        PortletContainer portletContainer = (PortletContainer)mockPortletContainer.proxy();
        ContainerServices containerServices = (ContainerServices)mockContainerServices.proxy();
        NamespaceMapper namespaceMapper = (NamespaceMapper)mockNamespaceMapper.proxy();
        PortalContext portalContext = (PortalContext)mockPortalContext.proxy();
        PortletWindow portletWindow = (PortletWindow)mockPortletWindow.proxy();
        PortletWindowID portletWindowId = (PortletWindowID)mockPortletWindowId.proxy();

        mockResourceRequest.expects(once()).method("getAttribute")
            .with(eq(PortletRequest.LIFECYCLE_PHASE))
            .will(returnValue(PortletRequest.RESOURCE_PHASE));
        mockPortletRequestContext.expects(once()).method("getContainer")
            .will(returnValue(portletContainer));
        mockPortletRequestContext.expects(once()).method("getPortletWindow")
            .will(returnValue(portletWindow));
        mockPortletContainer.expects(once()).method("getContainerServices")
            .will(returnValue(containerServices));
        mockContainerServices.expects(once()).method("getNamespaceMapper")
            .will(returnValue(namespaceMapper));
        mockContainerServices.expects(once()).method("getPortalContext")
            .will(returnValue(portalContext));
        mockPortletWindow.expects(once()).method("getId")
            .will(returnValue(portletWindowId));
    }

    /**
     * Test for PLUTO-781 with 
     */
    public void testNestedResourceForwardWithOptionEnabled() throws Exception
    {
        expectForwardStart("true");

        HttpServletPortletRequestWrapper portletRequestWrapper = new HttpServletPortletRequestWrapper(
            httpRequest, httpSession, portletRequest);
        
        mockPortletRequestContext.expects(exactly(2)).method("startDispatch")
            .with(eq(portletRequestWrapper), ANYTHING , eq(PortletRequest.RESOURCE_PHASE));

        mockHttpRequest.expects(exactly(3)).method("getServletPath")
            .will(returnValue("/testServletPath"));
        mockHttpRequest.expects(exactly(1)).method("getPathInfo")
            .will(returnValue("/servlet1"));

        portletRequestWrapper.startForward("/testServletPath/servlet1");
        assertEquals("/testServletPath", portletRequestWrapper.getServletPath());
        assertEquals("/servlet1", portletRequestWrapper.getPathInfo());

        mockHttpRequest.expects(exactly(2)).method("getServletPath")
            .will(returnValue("/testJspPath"));
        mockHttpRequest.expects(exactly(1)).method("getPathInfo")
            .will(returnValue("/jsp1.jsp"));

        portletRequestWrapper.startForward("/testJspPath/jsp1.jsp");
        
        assertEquals("/testJspPath", portletRequestWrapper.getServletPath());
        assertEquals("/jsp1.jsp", portletRequestWrapper.getPathInfo());
        
    }

    public void testNestedResourceForward() throws Exception
    {
        expectForwardStart(null);

        HttpServletPortletRequestWrapper portletRequestWrapper = new HttpServletPortletRequestWrapper(
            httpRequest, httpSession, portletRequest);
        
        mockPortletRequestContext.expects(exactly(2)).method("startDispatch")
            .with(eq(portletRequestWrapper), ANYTHING , eq(PortletRequest.RESOURCE_PHASE));
        mockHttpRequest.expects(exactly(3)).method("getServletPath")
            .will(returnValue("/testServletPath"));

        portletRequestWrapper.startForward("/testServletPath/servlet1");
        
        assertEquals("/testServletPath", portletRequestWrapper.getServletPath());
        assertEquals("/servlet1", portletRequestWrapper.getPathInfo());

        portletRequestWrapper.startForward("/testJspPath/jsp1.jsp");
        
        assertEquals("/testServletPath", portletRequestWrapper.getServletPath());
        assertEquals("/servlet1", portletRequestWrapper.getPathInfo());
        
    }

    private void expectForwardStart(String forwardOption) {
        mockPortalContext.expects(once()).method("getProperty")
            .with(eq("pluto.enable.nested.resource.forwards"))
            .will(returnValue(forwardOption));
        mockHttpRequest.expects(once()).method("getServletContext")
            .will(returnValue(servletContext));
        mockServletContext.expects(once()).method("getContextPath")
            .will(returnValue("/testcontext"));
        mockResourceRequest.expects(once()).method("getAttribute")
            .with(eq("org.apache.pluto.container.PortletRequestContext"))
            .will(returnValue(portletRequestContext));
    }
}
