package org.apache.pluto;

import java.util.HashMap;
import java.util.Stack;

import org.apache.pluto.services.ContainerService;
import org.apache.pluto.services.PortletContainerEnvironment;

/**
 * 
 */
public class PortletContainerServices
{

    public static ContainerService get(Class service)
    {
        // get current environment from thread local
        // after prepare has been called
        Stack currentContainerServiceStack = (Stack)currentContainerService.get();

        if (currentContainerServiceStack.isEmpty())
        {
            throw new IllegalStateException("The prepare method was never called");
        }

        PortletContainerEnvironment environment = (PortletContainerEnvironment)currentContainerServiceStack.peek();

        if (environment == null)
        {
            throw new IllegalStateException("The prepare method was never called");
        }

        return environment.getContainerService(service);            
    }

    public static String getUniqueContainerName()
    {
        // get uniqueContainerName stack out of the thread local
        Stack currentNameStack = (Stack)currentUniqueContainerName.get();

        if (currentNameStack.isEmpty())
        {
            throw new IllegalStateException("The prepare method was never called");
        }

        return(String)currentNameStack.peek();
    }

    synchronized public static void createReference(String uniqueContainerName, PortletContainerEnvironment environment)
    {
        if (containerServices.containsKey(uniqueContainerName))
        {
            throw new IllegalArgumentException("The given container name is not unique: "+uniqueContainerName);
        }

        containerServices.put(uniqueContainerName,  environment);
    }

    synchronized public static void destroyReference(String uniqueContainerName)
    {
        // removes environment from Map of possible environments
        containerServices.remove(uniqueContainerName);
    }

    /**
     * This method needs to be called to prepare the portlet container
     * environment. This allows to have multiple container instances.
     */
    synchronized public static void prepare(String uniqueContainerName)
    {
        // get container service stack out of the thread local
        Stack currentContainerServiceStack = (Stack)currentContainerService.get();
        // add current environment to stack stored in thread local
        currentContainerServiceStack.push(containerServices.get(uniqueContainerName));

        // get uniqueContainerName stack out of the thread local
        Stack currentNameStack = (Stack)currentUniqueContainerName.get();
        // add current uniqueContainerName to stack stored in thread local
        currentNameStack.push(uniqueContainerName);
    }

    /**
     * Releases the current container services.
     */
    public static void release()
    {
        // remove current environment from thread local
        // after prepare has been called
        Stack currentContainerServiceStack = (Stack)currentContainerService.get();
        if (!currentContainerServiceStack.isEmpty())
        {
            currentContainerServiceStack.pop();
        }

        // remove uniqueContainerName from thread local
        // after prepare has been called
        Stack currentNameStack = (Stack)currentUniqueContainerName.get();
        if (!currentNameStack.isEmpty())
        {
            currentNameStack.pop();
        }
    }

    // holds a stack of the current environments for temporary use
    private static ThreadLocal currentContainerService = new StackedThreadLocal(); 
    // holds the current environment reference for temporary use
    private static ThreadLocal currentUniqueContainerName = new StackedThreadLocal(); 

    // map of possible environments
    private static HashMap containerServices = new HashMap();  



    private static class StackedThreadLocal extends ThreadLocal
    {
        public Object initialValue()
        {
            return new Stack();
        }
    }

}
