/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* 

 */

package org.apache.pluto.portalImpl.services.factorymanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.factory.Factory;
import org.apache.pluto.portalImpl.util.Properties;
import org.apache.pluto.util.StringUtils;

/**
 * Manages the life-time of factories registered during container startup.
 * A service has to derive from {@link Factory} and implement the
 * <CODE>init()</CODE> and <CODE>destroy()</CODE> methods as appropriate.
 * 
 * @see Factory
 */
public class FactoryManagerServiceImpl extends FactoryManagerService
{

    private final static String CONFIG_FACTORY_PRE = "factory.";

    /**
     ** Initializes all factories specified in the configuration beginning with 'factory.'.
     ** By specifying a different implementation of the factory the behaviour
     ** of the portlet container can be modified.
     **
     ** @param   config
     **          the servlet configuration
     **
     ** @exception    Exception
     **               if initializing any of the factories fails
     **/

    protected void init (ServletConfig config, Properties aProperties) throws Exception
    {

        ServletContext context = null;

        if (config != null)
            context = config.getServletContext ();

        if (context != null)
            context.log ("FactoryManager: Loading factories...");

        Map factoryImpls = new HashMap();
        Map factoryProps = new HashMap();

        Iterator configNames = aProperties.keys();
        String lastFactoryInterfaceName = null;
        while (configNames.hasNext())
        {
            String configName = (String)configNames.next();
            if (configName.startsWith(CONFIG_FACTORY_PRE))
            {
                String name = configName.substring(CONFIG_FACTORY_PRE.length());
                if ((lastFactoryInterfaceName!=null) &&
                    (name.startsWith(lastFactoryInterfaceName)) )
                {
                    String propertyName = name.substring(lastFactoryInterfaceName.length()+1);
                    String propertyValue = aProperties.getString(configName);
                    Map properties = (Map)factoryProps.get(lastFactoryInterfaceName);
                    properties.put(propertyName, propertyValue);
                }
                else
                {
                    String factoryInterfaceName = name;
                    String factoryImplName = aProperties.getString(configName);
                    factoryImpls.put(factoryInterfaceName, factoryImplName);
                    factoryProps.put(factoryInterfaceName, new HashMap());
                    // remember interface name to get all properties
                    lastFactoryInterfaceName = factoryInterfaceName;
                }
            }
        }

        int numAll = 0;

        for (Iterator iter = factoryImpls.keySet().iterator(); iter.hasNext (); )
        {
            String factoryInterfaceName = (String) iter.next ();

            numAll++;

            // try to get hold of the factory

            Class factoryInterface;

            try
            {
                factoryInterface = Class.forName (factoryInterfaceName);
            }
            catch (ClassNotFoundException exc)
            {
                if (context != null)
                    context.log ("FactoryManager: A factory with name " + factoryInterfaceName + " cannot be found.");

                continue;
            }

            String factoryImplName = (String)factoryImpls.get(factoryInterfaceName);

            Class factoryImpl = null;

            Factory factory = null;

            try
            {
                factoryImpl = Class.forName (factoryImplName);

                factory = (Factory) factoryImpl.newInstance ();

                Map props = (Map)factoryProps.get(factoryInterfaceName);

                if (context != null)
                    context.log (StringUtils.nameOf (factoryInterface) + " initializing...");

                factory.init (config, props);

                if (context != null)
                    context.log (StringUtils.nameOf (factoryInterface) + " done.");
            }
            catch (ClassNotFoundException exc)
            {
                if (context != null)
                    context.log ("FactoryManager: A factory implementation with name " + factoryImplName + " cannot be found.", exc);

                throw exc;
            }
            catch (ClassCastException exc)
            {
                if (context != null)
                    context.log ("FactoryManager: Factory implementation " + factoryImplName + " is not a factory of the required type.", exc);

                throw exc;
            }
            catch (InstantiationException exc)
            {
                if (context != null)
                    context.log ("FactoryManager: Factory implementation " + factoryImplName + " cannot be instantiated.", exc);

                throw exc;
            }
            catch (Exception exc)
            {
                if (context != null)
                    context.log ("FactoryManager: An unidentified error occurred", exc);

                throw exc;
            }

            if (factory != null)
            {
                factoryMap.put (factoryInterface, factory);

                // build up list in reverse order for later destruction

                factoryList.add (0, factory);

            }
        }

        if (context != null)
            context.log ("FactoryManager: Factories initialized (" + numAll + " successful).");
            
    }

    /**
     ** Destroys all services.
     **
     ** @param   aConfig
     **          the servlet configuration
     **/

    protected void destroy (ServletConfig config)
    {

        ServletContext context = null;

        if (config != null)
            context = config.getServletContext ();

        // destroy the services in reverse order
  
        for (Iterator iterator = factoryList.iterator (); iterator.hasNext (); )
        {
            Factory factory = (Factory) iterator.next ();

            try
            {
                factory.destroy ();
            }
            catch (Exception exc)
            {
                if (context != null)
                    context.log ("FactoryManager: Factory couldn't be destroyed.", exc);
            }
        }

        factoryList.clear();
        factoryMap.clear();

    }

    /**
     ** Returns the service implementation for the given service class, or
     ** <CODE>null</CODE> if no such service is registered.
     **
     ** @param   aClass
     **          the service class
     **
     ** @return   the service implementation
     **/

    public Factory getFactory (Class theClass)
    {
        // at this state the services map is read-only,
        // therefore we can go without synchronization

        return ((Factory) factoryMap.get (theClass));
    }

    // --- PRIVATE MEMBERS --- //

    private Map  factoryMap  = new HashMap ();
    private List factoryList = new LinkedList ();

}
