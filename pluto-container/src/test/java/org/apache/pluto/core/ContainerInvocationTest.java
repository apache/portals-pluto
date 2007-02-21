package org.apache.pluto.core;

import junit.framework.TestCase;

import org.apache.pluto.driver.core.PortletWindowImpl;

public class ContainerInvocationTest extends TestCase
{
    private static PortletContainerImpl container = 
        new PortletContainerImpl("test", null, null);
    private static PortletWindowImpl window = 
        new PortletWindowImpl(null, null);

    public void testSetInvocation()
    {
        ContainerInvocation.setInvocation(container, window);
    }

    public void testClearInvocation()
    {
        ContainerInvocation.clearInvocation();
    }

}
