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

import org.apache.pluto.driver.impl.PortletWindowImpl;
import org.apache.pluto.driver.impl.PortletWindowListener;
import org.apache.pluto.driver.impl.PortletWindowEvent;
import org.apache.pluto.PortletWindow;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.portlet.WindowState;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 6, 2004 at 5:09:11 PM
 */
public class PortalPage
    implements Cloneable, Serializable, PortletWindowListener {

    private static final Log LOG = LogFactory.getLog(PortalPage.class);

    private String pageId;
    private String displayName;
    private HashMap windows;

    private String maximizedWindow;

    public PortalPage() {
        windows = new HashMap();

    }

    public PortalPage(String pageId, String displayName) {
        this();
        LOG.info("PortalPage created: ["+pageId+":"+displayName+"]");
        this.pageId = pageId;
        this.displayName = displayName;
    }

    public void addPortletWindow(PortletWindowImpl window) {
        window.addPortletWindowListener(this);
        windows.put(window.getPortletId(), window);
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        LOG.debug("Setting pageId: "+pageId);
        this.pageId = pageId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PortletWindowImpl[] getPortlets() {
        return (PortletWindowImpl[])windows.values()
                   .toArray(new PortletWindowImpl[windows.size()]);
    }

    public PortletWindow getPortlet(String portletId) {
        return (PortletWindow)windows.get(portletId);
    }

    public boolean isMaximizedState() {
        return maximizedWindow!=null;
    }

    public PortletWindow getMaximizedPortletWindow() {
        if(maximizedWindow!=null) {
            return (PortletWindow)windows.get(maximizedWindow);
        }
        return null;
    }

    // Listener Implementation
    public void windowStateChanged(PortletWindowEvent event) {
        PortletWindow source = event.getSource();

        if(source.getPortletId().equals(maximizedWindow)) {
            if(!source.getWindowState().equals(WindowState.MAXIMIZED)) {
                maximizedWindow = null;
            }
        }
        else if(source.getWindowState().equals(WindowState.MAXIMIZED)) {
            if(maximizedWindow!=null) {
                ((PortletWindow)windows.get(maximizedWindow))
                    .setWindowState(WindowState.NORMAL);
            }
            maximizedWindow = source.getPortletId();
        }
    }

    public void portletModeChanged(PortletWindowEvent event) {
        // no op
    }

    public Object clone() {
        PortalPage page = new PortalPage();
        page.setPageId(this.getPageId());
        page.setDisplayName(this.getDisplayName());
        page.windows = new HashMap();
        Iterator it = this.windows.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            PortletWindowImpl impl = (PortletWindowImpl)
                ((PortletWindowImpl)entry.getValue()).clone();
            impl.addPortletWindowListener(page);
            page.windows.put(
                entry.getKey(),
                impl
            );
        }
        return page;
    }
}
