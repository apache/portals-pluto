/*
 * Copyright 2005 The Apache Software Foundation
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

package org.apache.pluto.descriptors.services;

import java.io.IOException;

import org.apache.pluto.descriptors.portlet.PortletAppDD;

/**
 * Read/Write services for Portlet Application configuration
 * This service reads the portlet.xml and converts it to a
 * standard bean model.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id$
 * @since Mar 6, 2005
 */
public interface PortletAppDescriptorService {

    /**
     * Retrieve the name of the context path
     * within which PortletApps retrieved from this
     * service reside.
     * @return
     */
    String getContextPath();

    /**
     * Retrieve the PortletApp deployment descriptor
     * (portlet.xml).
     * @return Object representation of the descriptor.
     * @throws IOException if an IO error occurs.
     */
    PortletAppDD read() throws IOException;

    /**
     * Write the PortletApp deployment descriptor
     * (portlet.xml).
     * @param pd
     * @throws IOException if an IO error occurs.
     */
    void write(PortletAppDD pd) throws IOException;
}
