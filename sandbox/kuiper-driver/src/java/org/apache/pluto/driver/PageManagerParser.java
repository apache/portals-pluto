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
import org.apache.pluto.driver.impl.PortletWindowImpl;
import org.apache.pluto.impl.PortletPreferencesImpl;
import org.xml.sax.SAXException;

import java.io.InputStream;
import java.io.IOException;

/**
 * 
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 22, 2004 at 11:49:26 PM
 */
class PageManagerParser {

    private static final Log LOG = LogFactory.getLog(PageManagerParser.class);

    private Digester digester;

    public PageManagerParser() {
        digester = new Digester();
        digester.setClassLoader(Thread.currentThread().getContextClassLoader());

        digester.setLogger(LOG);

        digester.addObjectCreate(
            "pluto-driver/page-manager",
            PageManager.class
        );

        digester.addObjectCreate(
            "pluto-driver/page-manager/page",
            PortalPage.class
        );

        digester.addSetProperties(
            "pluto-driver/page-manager/page",
            "id",
            "pageId"
        );
        /*
        digester.addCallMethod(
            "pluto-driver/page-manager/page",
            "setPageId",
            1
        );

        digester.addCallParam(
            "pluto-driver/page-manager/page",
            0,
            "id"
        );
        */

        digester.addBeanPropertySetter(
            "pluto-driver/page-manager/page/display-name",
            "displayName"
        );

        digester.addObjectCreate(
            "pluto-driver/page-manager/page/portlet-window",
            PortletWindowImpl.class
        );

        digester.addBeanPropertySetter(
            "pluto-driver/page-manager/page/portlet-window/portlet-context",
            "contextPath"
        );

        digester.addBeanPropertySetter(
            "pluto-driver/page-manager/page/portlet-window/portlet-name",
            "portletName"
        );

        // add preferences here.
        digester.addObjectCreate(
            "pluto-driver/page-manager/page/portlet-window/preferences",
            PortletPreferencesImpl.class
        );

        digester.addObjectCreate(
                "pluto-driver/page-manager/page/portlet-window/preferences/preference",
                "java.util.HashMap"
        );

        digester.addCallMethod(
                "pluto-driver/page-manager/page/portlet-window/preferences/preference",
                "put",
                2
        );

        digester.addCallParam(
            "pluto-driver/page-manager/page/portlet-window/preferences/preference/preference-name",
            0
        );

        digester.addCallParam(
            "pluto-driver/page-manager/page/portlet-window/preferences/preference/preference-value",
            1
        );

        digester.addSetNext(
             "pluto-driver/page-manager/page/portlet-window/preferences/preference",
             "addAll"
        );

        digester.addSetNext(
            "pluto-driver/page-manager/page/portlet-window/preferences",
            "setPortletPreferences"
        );


        digester.addSetNext(
            "pluto-driver/page-manager/page/portlet-window",
            "addPortletWindow"
        );

        digester.addSetNext(
            "pluto-driver/page-manager/page",
            "addPage"
        );

        LOG.debug("MATCHES: "+
        digester.getRules().match(null, "pluto-driver/page-manager/page"
        ));

    }

    public PageManager getPageManager(InputStream in)
    throws IOException {
        try {
            Object obj = digester.parse(in);
            LOG.debug("Parsed: "+obj);
            return (PageManager)obj;
        }
        catch(SAXException sax) {
            LOG.fatal("Unable to parse configuration file: "+sax.getMessage(),sax);
            throw new IOException(sax.getMessage());
        }
        catch(RuntimeException re) {
            re.printStackTrace();
            LOG.error("Error parsing portal configuration.", re);
            throw re;
        }
    }
}
