package org.apache.pluto.core;

import junit.framework.TestCase;

import javax.servlet.ServletContext;

//import org.easymock.EasyMock;

import java.net.MalformedURLException;
import java.net.URL;


public class PortletContextManagerTest extends TestCase {

    private PortletContextManager manager;
    private ServletContext context;

    public void setUp() {
        /* Java5 Required!
        context = EasyMock.createMock(ServletContext.class);
        */
        manager = PortletContextManager.getManager();
    }

    public void testComputeContextPath() throws MalformedURLException {
        /* Java5 Required!
            URL url = new URL("file://usr/local/apache-tomcat-5.1.19/webapps/my-test-context/WEB-INF/web.xml");
            EasyMock.expect(context.getResource("/WEB-INF/web.xml")).andReturn(url);
            EasyMock.replay(context);
            assertEquals("/my-test-context", manager.computeContextPath(context));
            EasyMock.verify(context);


            EasyMock.reset(context);
            url = new URL("file://usr/local/apache-tomcat-5.1.19/webapps/my-test-context.war!/WEB-INF/web.xml");
            EasyMock.expect(context.getResource("/WEB-INF/web.xml")).andReturn(url);
            EasyMock.replay(context);
            assertEquals("/my-test-context", manager.computeContextPath(context));
        */
        }
}
