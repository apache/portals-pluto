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

package org.apache.pluto.core;

import org.apache.pluto.impl.PortletConfigImpl;
import org.apache.pluto.impl.PortletConfigInlineResourceBundleImpl;
import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.InitParameterDD;
import org.apache.pluto.binding.PortletInfoDD;
import org.apache.pluto.PlutoException;
import org.apache.pluto.PlutoConstants;
import org.apache.pluto.services.LoggerService;
import org.apache.pluto.services.Logger;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletContext;
import javax.portlet.PortletConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Properties;

/** <P>A registry used to ensure that no portlet is instantiated
 *  more than once.  Portlets are registered with the registy
 *  by the {@link org.apache.pluto.core.PortletServlet}.
 *  Subsequently each invocation uses the registry as a lookup
 *  for the allready existing Portlet instance.</P>
 *
 *  <P>The registry also manages the conversion of the
 *  portlet deployment descriptor (represented by the
 *  {@link org.apache.pluto.binding.PortletAppDD} into an actual
 *  Portlet (and associated config) reference.</P>
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 12:01:43 PM
 */
public class PortletRegistry {

    private Logger logger;

    /** The underlying storage container of Portlets. */
    private Map portlets = new HashMap();

    /** Constructor.  If a Pico/Nano implementation
     *  is migrated to, this constructor could be modified
     *  and the entire surrounding container could be passed.
     * @param logger
     */
    public PortletRegistry(LoggerService logger) {
        this.logger = logger.getLogger(PortletRegistry.class);
    }

    /** Register the portlet described by the descriptor
     *  for the given context.
     *
     * @param descriptor
     * @param context
     * @throws PlutoException
     * @throws PortletException
     */
    public void register(PortletDD descriptor, PortletContext context)
    throws PlutoException, PortletException {
        String className = descriptor.getPortletClass();
        Portlet portlet = null;

        try {
            ClassLoader loader =
                Thread.currentThread().getContextClassLoader();

            Class portletClass = loader.loadClass(className);
            portlet = (Portlet)portletClass.newInstance();
        }
        catch(Throwable t) {
            throw new PlutoException(t.getMessage());
        }

        HashMap map = new HashMap();
        InitParameterDD[] params = descriptor.getInitParameters();
        for(int i=0;i<params.length;i++) {
            map.put(
                params[i].getParameterName(),
                params[i].getParameterValue()
            );
        }

        PortletInfoDD info =  descriptor.getPortletInfo();
        Properties props = new Properties();
        props.setProperty(PlutoConstants.PORTLET_TITLE, info.getTitle());
        props.setProperty(PlutoConstants.PORTLET_SHORT_TITLE, info.getShortTitle());
        props.setProperty(PlutoConstants.PORTLET_KEYWORDS, info.getKeywords());

        ResourceBundle bundle
            = new PortletConfigInlineResourceBundleImpl(props);

        /* TODO: Implement Spec PLT6.2
        if(dd.getResourceBundle()!=null) {
            try {
            }
            catch(Throwable t) {
                // now what?
            }
        }
        */

        PortletConfig config =
            new PortletConfigImpl(descriptor.getPortletName(),
                                  context, bundle, map);

        if(logger.isDebugEnabled()) {
            logger.debug("Initializing portlet with config: "+config);
        }

        portlet.init(config);

        if(logger.isDebugEnabled()) {
            logger.debug("Registering portlet: "
                         +config.getPortletName());
        }

        portlets.put(config.getPortletName(),
                     new RegisteredPortlet(portlet, config));
    }

    /** Retrieve an allready registered portlet. */
    public RegisteredPortlet getPortlet(String name) {
        return (RegisteredPortlet)portlets.get(name);
    }
}
