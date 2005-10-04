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

package org.apache.pluto.portalImpl.aggregation.navigation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;

import org.apache.pluto.portalImpl.core.PortalURL;

public class TabNavigation extends AbstractNavigationFragment {

    public TabNavigation(String id,
                         ServletConfig config, 
                         org.apache.pluto.portalImpl.aggregation.Fragment parent,
                         org.apache.pluto.portalImpl.om.page.Fragment fragDesc,
                         org.apache.pluto.portalImpl.aggregation.navigation.Navigation navigation)
    throws Exception
    {
        super(id, config, parent, fragDesc, navigation);
    }

    public NavigationTreeBean[] getNavigationView(PortalURL url) {
        List result = new ArrayList();
        for (Iterator it = getRootNavigation().getChildren().iterator(); it.hasNext();) {
            Navigation child = (Navigation) it.next();
            walkTree(child, url , result, 0);
        }
        return(NavigationTreeBean[]) result.toArray(new NavigationTreeBean[0]);
    }

    private static void walkTree(Navigation nav, PortalURL url, List path, int depth)
    {
        if (url.isPartOfGlobalNavigation(nav.getLinkedFragment().getId())) {
            path.add(new NavigationTreeBean(nav, true, depth));
            for (Iterator it = nav.getChildren().iterator(); it.hasNext();) {
                Navigation child = (Navigation) it.next();
                walkTree(child, url, path, depth+1);
            }
        } else {
            path.add(new NavigationTreeBean(nav, false, depth));
        }
    }


}
