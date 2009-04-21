/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.services.container;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURLGenerationListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletURLListenerService;
import org.apache.pluto.container.om.portlet.Listener;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

public class PortletURLListenerServiceImpl implements PortletURLListenerService
{
	/** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(PortletURLListenerServiceImpl.class);

    public List<PortletURLGenerationListener> getPortletURLGenerationListeners(PortletApplicationDefinition app)
    {
        List<PortletURLGenerationListener> listeners = new ArrayList<PortletURLGenerationListener>();
        //this list is needed for the classnames
        List<? extends Listener> portletURLFilterList = app.getListeners();
        //Iterate over the classnames and for each entry in the list the filter..URL is called.
        if (portletURLFilterList != null){
            for (Listener listener : portletURLFilterList) {
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                Class<? extends Object> clazz;
                try {
                    clazz = loader.loadClass(listener.getListenerClass() );
                    if (clazz != null){
                        listeners.add((PortletURLGenerationListener)clazz.newInstance());
                    }
                } catch (ClassNotFoundException e) {
                    String message = "The class isn't found.";
                    LOG.error(message);
                } catch (InstantiationException e) {
                    String message = "The instantiation fail.";
                    LOG.error(message);
                } catch (IllegalAccessException e) {
                    String message = "IllegalAccessException";
                    LOG.error(message);
                }
            }
        }
        return listeners;
    }
}
