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

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.pluto.portalImpl.util.Properties;

/**
 ** This is the base class for all services of the system. It prototypes
 ** only two methods: <CODE>init()</CODE> and <CODE>destroy()</CODE>, both
 ** of which are optional to override by a service. However, it is
 ** recommended to implement at least <CODE>init()</CODE>. The
 ** <CODE>destroy()</CODE> method only serves as a hook to release any
 ** resources that the service may have cached or opened for its life-time.
 **
 ** <P>
 ** To be more precise, this class prototypes three different
 ** <CODE>init()</CODE> methods. Only one of them should be overriden.
 ** The are different with respect to the arguments they take, but
 ** are otherwise identical.
 **
 ** @see   ServiceManager
 **/

public abstract class Service
{

    /**
     ** Constructs the service.
     **/
    protected Service () {

    }

    /**
     ** Initializes the service using the servlet configuration
     ** and the service properties.
     **
     ** @param   aConfig
     **          the servlet configuration
     ** @param   aProperties
     **          the service properties
     **
     ** @throws   Exception
     **           if the initialization fails
     **/

    protected void init (ServletConfig aConfig,
                         Properties aProperties) throws Exception
    {
        if(aConfig != null)
        {
            init (aConfig.getServletContext (), aProperties);
        }
        else
        {
            init (aProperties);
        }

    }

    /**
     ** Initializes the service using the servlet context
     ** and the service properties.
     **
     ** @param   aContext
     **          the servlet context
     ** @param   aProperties
     **          the service properties
     **
     ** @throws   Exception
     **           if the initialization fails
     **/

    protected void init (ServletContext aContext,
                         Properties aProperties) throws Exception
    {
        init (aProperties);
    }

    /**
     ** Initializes the service using the service properties.
     **
     ** @param   aProperties
     **          the service properties
     **
     ** @throws   Exception
     **           if the initialization fails
     **/

    protected void init (Properties aProperties) throws Exception
    {
    }

    /**
     * This methods can be used to setup things after the services has 
     * been initialized via init.
     * 
     * @throws Exception
     *         if the postInit fails for any reason
     **/
    protected void postInit(ServletConfig aConfig) throws Exception 
    {
        postInit();
    }

    /**
     * This methods can be used to setup things after the services has 
     * been initialized via init.
     * 
     * @throws Exception
     *         if the postInit fails for any reason
     **/
    protected void postInit() throws Exception 
    {
    }

    /**
     ** Destroys the services. This method allows the service
     ** to cleanup any resources.
     **
     ** @param   aConfig
     **          the servlet configuration
     **
     ** @throws   Exception
     **           if the destruction fails
     **/
    protected void destroy (ServletConfig aConfig) throws Exception
    {
        destroy();
    }

    /**
     ** Destroys the services. This method allows the service
     ** to cleanup any resources.
     **
     ** @throws   Exception
     **           if the destruction fails
     **/
    protected void destroy () throws Exception
    {
    }

}
