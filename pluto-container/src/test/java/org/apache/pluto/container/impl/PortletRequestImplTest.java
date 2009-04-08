/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.impl;

import javax.portlet.CacheControl;
import javax.portlet.PortalContext;
import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.CCPPProfileService;
import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletURLProvider;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.impl.PortletContainerImpl;
import org.apache.pluto.container.impl.RenderRequestImpl;
import org.jmock.Mock;
import org.jmock.cglib.MockObjectTestCase;

/**
 * Created by IntelliJ IDEA.
 * User: esm
 * Date: Mar 5, 2008
 * Time: 9:50:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class PortletRequestImplTest extends MockObjectTestCase
{
    // Mock Objects
    private Mock mockContainer;
    private Mock mockServices;
    private Mock mockCCPPProfileService;
    private Mock mockPortalContext;
    private Mock mockPortletContext;
    private Mock mockHttpServletRequest;
    private Mock mockPortletURLProvider;
    private Mock mockPortletRequestContext;
    private Mock mockPortletResponseContext;
    private Mock mockCacheControl;
    private PortletWindow window;
    

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp( ) throws Exception
    {
        super.setUp();

        // Create mocks
        mockServices = mock( ContainerServices.class );
        mockCCPPProfileService = mock( CCPPProfileService.class );
        mockPortalContext = mock( PortalContext.class );
        mockPortletContext = mock( PortletContext.class );
        mockPortletURLProvider = mock(PortletURLProvider.class);
        mockContainer = mock( PortletContainerImpl.class,
                new Class[] { String.class, ContainerServices.class },
                new Object[] { "Mock Pluto Container", (ContainerServices) mockServices.proxy() } );
        window = (PortletWindow) mock( PortletWindow.class ).proxy();
        mockHttpServletRequest = mock( HttpServletRequest.class );
        mockPortletRequestContext = mock ( PortletRequestContext.class );
        mockPortletResponseContext = mock ( PortletRenderResponseContext.class );
        mockCacheControl = mock ( CacheControl.class );

        // Constructor expectations for RenderRequestImpl
//        mockContainer.expects( atLeastOnce() ).method( "getOptionalContainerServices" ).will( returnValue( mockOptionalServices.proxy() ) );
//        mockServices.expects( once() ).method( "getPortalContext" ).will( returnValue( mockPortalContext.proxy() ) );
    }
    
    public void testDummy(){}

    /**
     * Test for PLUTO-474.
     */
    // TODO: adjust test to new container implementation, disabled for now
    public void __testInvalidateSessionWithUnititializedLastAccessTime() throws Exception
    {
        // maximum inactive interval of the underlying PortletRequest's HttpSession
        int maxInactiveInterval = 5; // in seconds

        // last accessed time of the underlying PortletRequest's HttpSession
        // A 'lastAccessedTime' of 0 emulates the behavior
        // of a servlet container that doesn't initialize
        // its value.
        long lastAccessedTime = 0L;  // in milliseconds
                
        Mock mockPortletEnvironmentService = mock( PortletEnvironmentService.class );
        
        mockServices.expects( once() ).method( "getPortletEnvironmentService" ).will( returnValue( mockPortletEnvironmentService.proxy() ));
        
        mockCCPPProfileService.expects(once()).method("getCCPPProfile").will(returnValue( null ));
        
        mockServices.expects(once()).method("getCCPPProfileService").will(returnValue( mockCCPPProfileService.proxy() ));
        
        mockContainer.expects(once()).method("getRequiredContainerServices").will(returnValue( mockServices.proxy() ));
        mockContainer.expects(atLeastOnce()).method("getOptionalContainerServices").will(returnValue( mockServices.proxy() ));
        mockPortletRequestContext.expects(atLeastOnce()).method("getContainer").will(returnValue( mockContainer.proxy()));
        
        // Create the render request that is under test, and initialize its state
        RenderRequestImpl request = new RenderRequestImpl( (PortletRequestContext)mockPortletRequestContext.proxy(), (PortletRenderResponseContext)mockPortletResponseContext.proxy() );

        // Mock the HttpSession, and set its expectations: it will return 0 for the last accessed time, and 5
        // for the maximum inactive interval
        Mock mockHttpSession = mock( HttpSession.class );
        mockHttpSession.expects( once() ).method( "getLastAccessedTime" ).will( returnValue( lastAccessedTime ) );
        // Prior to applying PLUTO-474, this expectation is invoked exactly twice, not once
        mockHttpSession.expects( once() ).method( "getMaxInactiveInterval" ).will( returnValue( maxInactiveInterval ) );

        // Set the expectation for the servlet request - it will return the mock http session
        // Prior to applying PLUTO-474, this expectation is invoked exactly twice, not once
        mockHttpServletRequest.expects( once() ).method( "getSession" ).will( returnValue( mockHttpSession.proxy() ) );

        // this is the important expectation -
        // Prior to applying PLUTO-474, the HttpSession was
        // incorrectly determined to be invalid, and thus the
        // HttpSession's invalidate() method was invoked.
        //
        // After applying PLUTO-474, invalidate() should never be called
        mockHttpSession.expects( never() ).method( "invalidate" );
        
        Mock mockPortletSession = mock( PortletSession.class );
        mockPortletEnvironmentService.expects( once() ).method( "createPortletSession" ).will( returnValue( mockPortletSession.proxy() ));

        PortletSession s = request.getPortletSession( true );
    }
}
