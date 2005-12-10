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

package org.apache.pluto.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.impl.PortletPreferenceImpl;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.PortletPreferenceDD;
import org.apache.pluto.descriptors.portlet.PortletPreferencesDD;
import org.apache.pluto.descriptors.servlet.ServletDD;

import javax.servlet.ServletContext;
import java.util.Iterator;

/**
 * The PortletEntity encapsulates all data pertaining to a single portlet
 * instance.  This instance may appear zero or more times per user. The
 * PortletEntity consists of two primary peices of information, the Portlet
 * Definition as defined by the {@link PortletDD} and the Wrapping Servlet
 * information as defined by the{@link ServletDD}
 */
public class PortletEntity {
    private static final Log LOG =
        LogFactory.getLog(PortletEntity.class);

    private static final String PREFIX = "/PlutoInvoker/";

    private ServletContext ctx;
    private PortletWindow window;

    //  Looked up and Cached
    private PortletDD dd;
    private PortletPreference[] prefs;

    PortletEntity(ServletContext ctx, PortletWindow window) {
        this.ctx = ctx;
        this.window = window;
    }

    /**
     * Returns all preferences of this portlet The return value cannot be NULL.
     * @return the preference set
     */
    public PortletPreference[] getDefaultPreferences() {
        if(prefs == null) {
            PortletDD dd = getPortletDefinition();
            PortletPreferencesDD ppdd = dd.getPortletPreferences();
            if (ppdd != null) {
                prefs = new PortletPreference[ppdd.getPortletPreferences().size()];
                Iterator pds = ppdd.getPortletPreferences().iterator();
                for(int i=0;pds.hasNext();i++) {
                    PortletPreferenceDD pd = (PortletPreferenceDD)pds.next();
                    prefs[i] = new PortletPreferenceImpl(
                        pd.getName(), new String[] { pd.getValue()}
                    );
                }
            }
        }
        return prefs;
    }

    /**
     * Returns the portlet description The return value cannot be NULL.
     * @return the portlet description
     */
    public PortletDD getPortletDefinition() {
        if (dd == null) {
            load();
        }
        return dd;

    }

    private void load() {
        String context = window.getContextPath();
        if(LOG.isDebugEnabled()) {
            LOG.debug("Loading PortletAppDD for context: "+context);
        }
        ServletContext ctx = this.ctx.getContext(context);
        if(LOG.isDebugEnabled()) {
            LOG.debug("Retrieved context: "+ctx);
        }
        try {
            PortletAppDD appDD = PortletDescriptorRegistry.getRegistry().getPortletAppDD(ctx);
            Iterator dds = appDD.getPortlets().iterator();
            while(dds.hasNext()) {
                PortletDD pd = (PortletDD)dds.next();
                if (pd.getPortletName().equals(window.getPortletName())) {
                    dd = pd;
                }
            }
        } catch (PortletContainerException e) {
        	String msg = "Unable to load the Portlet Application Deployment Descriptor:";
        	LOG.error(msg, e);
            throw new NullPointerException(msg + e.getMessage());
        }
    }

    public String getControllerServletUri() {
        return PREFIX + window.getPortletName();
    }

}
