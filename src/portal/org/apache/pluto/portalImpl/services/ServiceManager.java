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

package org.apache.pluto.portalImpl.services;

import java.io.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.util.StringUtils;
import org.apache.pluto.portalImpl.util.Properties;

/**
 * Manages the life-time of services registered during servlet startup.
 * A service has to derive from {@link ContainerService} and implement the
 * <CODE>init()</CODE> and <CODE>destroy()</CODE> methods as appropriate.
 * 
 * <P>
 * By registering the service and its implementation in the file
 * <CODE>/config/services.properties</CODE>, the service will become
 * available to the portal engine. The format of the file is simple:
 * 
 * <PRE>
 *   org.apache.pluto.portalImpl.services.log.LogService = org.apache.pluto.portalImpl.services.log.LogServicesImpl
 * </PRE>
 * 
 * Each entry represents one service. The left-hand side is the abstract
 * service class, the right-hand side is the implementation of this service.
 * The services are initialized in the order of appearance.
 * 
 * <P>
 * Each service can have its own configuration file, located in
 * <CODE>/config/services</CODE>. It has to have the name of either
 * implementation or abstract class of the service, without the
 * leading package name. For example, the service manager looks
 * for <CODE>LogServiceImpl.properties</CODE>. This allows a special
 * implementation to provide different configuration than the
 * general (abstract) service requires.
 * 
 * <P>
 * If present, one of the services configuration files is loaded
 * and passed to the service as {@link org.apache.pluto.portalImpl.util.Properties}
 * object. Not providing a service configuration file is okay too,
 * in that case the properties are empty.
 * 
 * @see ContainerService
 */
public class ServiceManager
{

    private final static String SERVICES_CONFIG_FILE = "/WEB-INF/config/services.properties";
    private final static String SERVICES_CONFIG_DIR  = "/WEB-INF/config/services/";

    /**
     ** Initializes all services specified in <CODE>services.properties</CODE>.
     ** By specifying a different implementation of the service the behaviour
     ** of the portal can be modified.
     **
     ** @param   aConfig
     **          the servlet configuration
     **
     ** @exception    Exception
     **               if loading <CODE>services.properties</CODE>
     **               or initializing any of its contained services fails
     **/

    public static void init (ServletConfig aConfig) throws Exception
    {
        init (aConfig, SERVICES_CONFIG_FILE, SERVICES_CONFIG_DIR);
    }

    /**
     ** Initializes all services specified in <CODE>services.properties</CODE>.
     ** By specifying a different implementation of the service the behaviour
     ** of the portal can be modified.
     **
     ** @param   aConfig
     **          the servlet configuration
     ** @param   aServiceConfigFile
     **          The location of <CODE>services.properties</CODE> (relative to classpath)
     ** @param   aServiceConfigDir
     **          The direcory with the services' properties files (relative to classpath)
     **
     ** @exception    Exception
     **               if loading <CODE>services.properties</CODE>
     **               or initializing any of its contained services fails
     **/

    public static void init (ServletConfig aConfig,
                             String aServiceConfigFile,
                             String aServiceConfigDir) throws Exception
    {
        // avoid duplicate initialization of services

        if (! cInitialized)
        {
            synchronized (ServiceManager.class)
            {
                if (! cInitialized)
                {
                    cInitialized = true;
                }
                else
                {
                    return;
                }
            }
        }
        else
        {
            return;
        }

        ServletContext context = null;

        if (aConfig != null)
            context = aConfig.getServletContext ();

        if (context != null)
            context.log ("ServiceManager: Loading services...");

        Properties props = new Properties ();

        try
        {
            props.load (context.getResourceAsStream (aServiceConfigFile));
        }
        catch (IOException exc)
        {
            if (context != null)
                context.log ("ServiceManager: File \"" + aServiceConfigFile + "\" cannot be found or read.");
            throw new Exception("ServiceManager: File \"" + aServiceConfigFile + "\" cannot be found or read.");
        }

        int numAll = 0;
        int numSuccessful = 0;

        for (Iterator iter = props.names (); iter.hasNext (); )
        {
            String serviceBaseName = (String) iter.next ();

            numAll++;

            // ty to get hold of the base service

            Class serviceBase;

            try
            {
                serviceBase = Class.forName (serviceBaseName);
            }
            catch (ClassNotFoundException exc)
            {
                if (context != null)
                    context.log ("ServiceManager: A service with name " + serviceBaseName + " cannot be found.");

                continue;
            }

            String serviceImplName = props.getString (serviceBaseName);

            Class serviceImpl = null;

            Service service = null;

            try
            {
                serviceImpl = Class.forName (serviceImplName);

                service = (Service) serviceImpl.newInstance ();

                Properties serviceProps = new Properties ();

                try
                {
                    InputStream is = null;

                    is = context.getResourceAsStream (aServiceConfigDir + StringUtils.nameOf (serviceImpl) + ".properties");

                    if (is == null)
                        is = context.getResourceAsStream (aServiceConfigDir + StringUtils.nameOf (serviceBase) + ".properties");

                    if (is != null)
                        serviceProps.load (is);
                }
                catch (IOException exc)
                {
                    // ignore -- we go without properties then
                }

                if (context != null)
                    context.log (StringUtils.nameOf (serviceBase) + " initializing...");

                service.init (aConfig, serviceProps);

                if (context != null)
                    context.log (StringUtils.nameOf (serviceBase) + " done.");
            }
            catch (ClassNotFoundException exc)
            {
                if (context != null)
                    context.log ("ServiceManager: A service implementation with name " + serviceImplName + " cannot be found.", exc);

                continue;
            }
            catch (ClassCastException exc)
            {
                if (context != null)
                    context.log ("ServiceManager: Service implementation " + serviceImplName + " is not a service of the required type.", exc);

                continue;
            }
            catch (InstantiationException exc)
            {
                if (context != null)
                    context.log ("ServiceManager: Service implementation " + serviceImplName + " cannot be instantiated.", exc);

                continue;
            }
            catch (Exception exc)
            {
                if (context != null)
                    context.log ("ServiceManager: An unidentified error occurred", exc);

                service = null;
            }

            if (service != null)
            {
                cServicesMap.put (serviceBase, service);

                // build up list in reverse order for later destruction

                cServicesList.add (0, service);

                numSuccessful++;
            }
        }

        if (context != null)
            context.log ("ServiceManager: Services initialized (" + numSuccessful + "/" + numAll + " successful).");
        if (numSuccessful!=numAll)
        {
            throw new Exception("ServiceManager: Services initialized (" + numSuccessful + "/" + numAll + " successful).");
        }
    }

    /**
     * Calls post init for all services
     * 
     * @param   aConfig
     *         the servlet configuration
     **/
     public static void postInit(ServletConfig aConfig) {
          // avoid duplicate destruction of services

        if (cInitialized)
        {
            synchronized (ServiceManager.class)
            {
                if (cInitialized)
                {
                    cInitialized = false;
                }
                else
                {
                    return;
                }
            }
        }
        else
        {
            return;
        }

        ServletContext context = null;

        if (aConfig != null)
            context = aConfig.getServletContext ();

        // post init all services
        for (Iterator iterator = cServicesList.iterator (); iterator.hasNext (); )
       {
           Service service = (Service) iterator.next ();

           try
           {
               service.postInit(aConfig);
           }
           catch (Exception exc)
           {
               if (context != null)
                   context.log ("ServiceManager: Service couldn't be started (postInit) after init..", exc);
           }
       }

     }

    /**
     ** Destroys all services.
     **
     ** @param   aConfig
     **          the servlet configuration
     **/

    public static void destroy (ServletConfig aConfig)
    {
        // avoid duplicate destruction of services

        if (cInitialized)
        {
            synchronized (ServiceManager.class)
            {
                if (cInitialized)
                {
                    cInitialized = false;
                }
                else
                {
                    return;
                }
            }
        }
        else
        {
            return;
        }

        ServletContext context = null;

        if (aConfig != null)
            context = aConfig.getServletContext ();

        // destroy the services in reverse order

        for (Iterator iterator = cServicesList.iterator (); iterator.hasNext (); )
        {
            Service service = (Service) iterator.next ();

            try
            {
                service.destroy (aConfig);
            }
            catch (Exception exc)
            {
                if (context != null)
                    context.log ("ServiceManager: Service couldn't be destroyed.", exc);
            }
        }

        cServicesList.clear();
        cServicesMap.clear();

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

    public static Service getService (Class aClass)
    {
        // at this state the services map is read-only,
        // therefore we can go without synchronization

        return ((Service) cServicesMap.get (aClass));
    }

    // --- PRIVATE MEMBERS --- //

    private static volatile boolean cInitialized = false;

    private static Map  cServicesMap  = new HashMap ();
    private static List cServicesList = new LinkedList ();
}



