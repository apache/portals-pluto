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

package org.apache.pluto.driver;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.io.InputStream;

/**
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 6, 2004 at 5:11:36 PM
 */
public class PageManager {

    private static final Log LOG = LogFactory.getLog(PageManager.class);

    private HashMap registry = new HashMap();

    public PageManager() {

    }

    public PortalPage getPage(String pageId) {
        return (PortalPage)registry.get(pageId);
    }

    public void addPage(PortalPage page) {
        LOG.debug("Adding page: "+page.getPageId());
        registry.put(page.getPageId(), page);
    }

    public Collection getDefaultPageList() {
        return registry.values();
    }

    public Map getDefaultPageMap() {
        Map map = new HashMap();
        Iterator it = registry.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            map.put(entry.getKey(), ((PortalPage)entry.getValue()).clone());
        }
        LOG.debug("Returning page map: "+map);
        return map;
    }
}
