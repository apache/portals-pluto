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

package org.apache.pluto.driver.webapp;

import org.apache.pluto.driver.Portal;
import org.apache.pluto.PlutoException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

/**
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 9:32:29 AM
 */
public class StartupListener implements ServletContextListener {

    private static final Log LOG = LogFactory.getLog(StartupListener.class);

    public void contextInitialized(ServletContextEvent event) {
        try {
            Portal.getPortal().startup(event.getServletContext());
        }
        catch(PlutoException pe) {
            LOG.fatal("Unable to start portal driver.", pe);
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        Portal.getPortal().shutdown();
    }


}
