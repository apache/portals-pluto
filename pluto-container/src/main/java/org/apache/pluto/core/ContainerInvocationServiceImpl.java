package org.apache.pluto.core;

import org.apache.pluto.container.ContainerInvocation;
import org.apache.pluto.container.ContainerInvocationService;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletWindow;


public class ContainerInvocationServiceImpl implements
        ContainerInvocationService
{
    private final InheritableThreadLocal<ContainerInvocationImpl> CONTAINERS =
        new InheritableThreadLocal<ContainerInvocationImpl>();

    public void clearInvocation()
    {
        CONTAINERS.set(null);
    }

    public ContainerInvocation getInvocation()
    {
        return CONTAINERS.get();
    }

    public void setInvocation(PortletContainer container, PortletWindow window, PortletContainer.Method method)
    {
        CONTAINERS.set(new ContainerInvocationImpl(window, container, method));
    }
}
