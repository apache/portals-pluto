/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
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
