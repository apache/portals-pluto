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

package org.apache.pluto.portalImpl.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.portalImpl.util.Properties;
import org.apache.pluto.util.StringUtils;

/**
 * Manages the life-time of services registered during servlet startup.
 * There are two types of services: Services required by the container,
 * and Services used for the portal driver configuration and execution.
 * All services required by the container have to derive from
 * {@link org.apache.pluto.services.ContainerService} and implement the
 * <CODE>init()</CODE> and <CODE>destroy()</CODE> methods as appropriate.
 * All services must derive from the
 * {@link org.apache.pluto.portalImpl.services.Service} interface if they
 * are to be used with the portal driver.
 * <P>
 * By registering the service and its implementation in the file
 * <CODE>/config/services.properties</CODE>, the service will become
 * available to the portal engine. The format of the file is simple:
 * 
 * <PRE>
 *   org.apache.pluto.portalImpl.services.log.Logger = org.apache.pluto.portalImpl.services.log.LogServicesImpl
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
 * for <CODE>LoggerImpl
.properties</CODE>. This allows a special
 * implementation to provide different configuration than the
 * general (abstract) service requires.
 * 
 * <P>
 * If present, one of the services configuration files is loaded
 * and passed to the service as {@link org.apache.pluto.portalImpl.util.Properties}
 * object. Not providing a service configuration file is okay too,
 * in that case the properties are emptyemptySessionPath .
 * 
 * @see org.apache.pluto.services.ContainerService
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

    //Start hot deploy patch
      
      public static void hotInit (ServletConfig aConfig, String theService) throws Exception
 	    {
 	        hotInit (aConfig, SERVICES_CONFIG_FILE, SERVICES_CONFIG_DIR, theService);
 	    }     
 	    
 	    public static void hotInit(ServletConfig aConfig,
 				String aServiceConfigFile, String aServiceConfigDir, String theService)
 				throws Exception {
 			// avoid duplicate initialization of services
 
 			if (!cInitialized) {
 				synchronized (ServiceManager.class) {
 					if (!cInitialized) {
 						cInitialized = true;
 					} else {
 						return;
 					}
 				}
 			} else {
 				return;
 			}
 
 			ServletContext context = null;
 
 			if (aConfig != null)
				context = aConfig.getServletContext();
 
 			if (context != null)
 				context.log("ServiceManager: HOTHOT Loading service: "+theService);
 
 			Properties props = new Properties();
 
 			try {
				props.load(context.getResourceAsStream(aServiceConfigFile));
 			} catch (IOException exc) {
 				if (context != null)
 					context.log("ServiceManager: File \"" + aServiceConfigFile
 							+ "\" cannot be found or read.");
 				throw new Exception("ServiceManager: File \"" + aServiceConfigFile
 						+ "\" cannot be found or read.");
 			}
 
 			int numAll = 0;
 			int numSuccessful = 0;
 
			for (Iterator iter = props.names(); iter.hasNext();) {
 				String serviceBaseName = (String) iter.next();
 
 				if (serviceBaseName.equals(theService)) {
 					context.log("ServiceManager: Service "+theService+" FOUND!!");
 					numAll++;
 
 					// ty to get hold of the base service
 					Class serviceBase;
 					try {
 						serviceBase = Class.forName(serviceBaseName);
 					} catch (ClassNotFoundException exc) {
 						if (context != null)
							context.log("ServiceManager: A service with name "
							+ serviceBaseName + " cannot be found.");
 						continue;
 					}
 
 					String serviceImplName = props.getString(serviceBaseName);
 					Class serviceImpl = null;
 					Service service = null;
 					try {
 						serviceImpl = Class.forName(serviceImplName);
 						service = (Service) serviceImpl.newInstance();
 						Properties serviceProps = new Properties();
 						try {
 							InputStream is = null;
 							is = context.getResourceAsStream(aServiceConfigDir
							+ StringUtils.nameOf(serviceImpl)
							+ ".properties");
 							if (is == null)
 								is = context.getResourceAsStream(aServiceConfigDir
							+ StringUtils.nameOf(serviceBase)
							+ ".properties");
 							if (is != null)
								serviceProps.load(is);
 						} catch (IOException exc) {
 							// ignore -- we go without properties then
 						}
 						if (context != null)
							context.log(StringUtils.nameOf(serviceBase)
							+ " initializing...");
 
 						service.init(aConfig, serviceProps);
 
 						if (context != null)
							context.log(StringUtils.nameOf(serviceBase) + " done.");
 					} catch (ClassNotFoundException exc) {
 						if (context != null)
 							context
						.log(
						"ServiceManager: A service implementation with name "
						+ serviceImplName
						+ " cannot be found.", exc);
 						continue;
 					} catch (ClassCastException exc) {

 						if (context != null)
							context.log("ServiceManager: Service implementation "
							+ serviceImplName
							+ " is not a service of the required type.",
							exc);
 						continue;
 					} catch (InstantiationException exc) {
 						if (context != null)
						context.log("ServiceManager: Service implementation "
						+ serviceImplName + " cannot be instantiated.",
						exc);
 						continue;
 					} catch (Exception exc) {
 						if (context != null)
 							context
							.log(
							"ServiceManager: An unidentified error occurred",
							exc);
 						service = null;
 					}
 
 					if (service != null) {
 						cServicesMap.put(serviceBase, service);
 						// build up list in reverse order for later destruction
 						cServicesList.add(0,service);
 						numSuccessful++;
 					}
 				}
 			}
 
 			if (context != null)
 				context.log("ServiceManager: Services initialized (" + numSuccessful + "/" + numAll + " successful).");
 			if (numSuccessful != numAll) {
 				throw new Exception("ServiceManager: Services initialized (" + numSuccessful + "/" + numAll + " successful).");
 			}
 		}
 
 	    public static void postHotInit(ServletConfig aConfig, String theService) {
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
 			try {
 				Service service = (Service)cServicesMap.get(Class.forName(theService));
 				service.postInit(aConfig);
 			} catch (Exception exc) {
 				if (context != null)
 					context.log("ServiceManager:Service couldn't be started (postInit) after init..",exc);
 	     }
 
 	   }
   
   //End hot deploy patch
    // --- PRIVATE MEMBERS --- //

    private static volatile boolean cInitialized = false;

    private static Map  cServicesMap  = new HashMap ();
    private static List cServicesList = new LinkedList ();
}



