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

import org.apache.pluto.services.PortletConfigFactoryService;
import org.apache.pluto.impl.PortletConfigImpl;

import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.servlet.ServletConfig;
import java.util.ResourceBundle;
import java.util.Map;

/**
 * <B>TODO</B>: Document
 * 
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 29, 2004 at 9:59:41 AM
 */
public class PortletConfigFactoryServiceImpl 
    implements PortletConfigFactoryService {
    
    public PortletConfig createPortletConfig(String portletId,
                                             PortletContext context,
                                             ResourceBundle bundle,
                                             Map map) {
        return new PortletConfigImpl(portletId, context, bundle, map);
    }
}
