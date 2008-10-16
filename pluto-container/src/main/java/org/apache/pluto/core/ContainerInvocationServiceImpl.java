package org.apache.pluto.core;

import org.apache.pluto.ContainerInvocation;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.spi.ContainerInvocationService;


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
        return (ContainerInvocation)CONTAINERS.get();
    }

    public void setInvocation(PortletContainer container, PortletWindow window)
    {
        CONTAINERS.set(new ContainerInvocationImpl(window, container));
    }

}
