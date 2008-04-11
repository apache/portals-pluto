package org.apache.pluto.core;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import junit.framework.TestCase;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletWindowID;


public class ContainerInvocationTest extends TestCase
{
    private static PortletContainerImpl container = 
        new PortletContainerImpl("test", null, null);

    public void testSetInvocation()
    {
        ContainerInvocation.setInvocation(container, new PortletWindow() {

            public PortletWindowID getId() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public String getContextPath() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public String getPortletName() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public WindowState getWindowState() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public PortletMode getPortletMode() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

    }

    public void testClearInvocation()
    {
        ContainerInvocation.clearInvocation();
    }

}
