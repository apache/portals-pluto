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

package org.apache.pluto.binding.impl.digester;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.apache.pluto.binding.PortletAppDD;
import org.apache.pluto.binding.WebAppDD;
import org.apache.pluto.binding.XMLBindingFactory;
import org.xml.sax.SAXException;

/**
 * ReadOnly implementation of XMLBindingFactory.
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 10, 2004 at 12:36:17 PM
 */
public class DigesterXMLBindingFactory extends XMLBindingFactory {

    private Digester wDigester;
    private Digester pDigester;

    public DigesterXMLBindingFactory() {
        this.wDigester = new Digester();
        this.pDigester = new Digester();
        init();
    }

    public int getMode() {
        return XMLBindingFactory.READ_ONLY;
    }

    public WebAppDD getWebAppDD(InputStream in) throws IOException {
        try {
            return (WebAppDD) wDigester.parse(in);
        } catch (SAXException saxe) {
            throw new IOException(saxe.getMessage());
        }
    }

    public PortletAppDD getPortletAppDD(InputStream in) throws IOException {
        try {
            return (PortletAppDD) pDigester.parse(in);
        } catch (SAXException saxe) {
            throw new IOException(saxe.getMessage());
        }
    }

    private void init() {
        initWebDigester();
        initPortletDigester();
    }

    private void initWebDigester() {
        wDigester.setValidating(false);

    }

    private void initPortletDigester() {
        pDigester.setValidating(false);
        pDigester.addObjectCreate("portlet-app", DigesterPortletAppDD.class);

        // ** Portlet Entity ** //
        pDigester.addObjectCreate("portlet-app/portlet",
                                  DigesterPortletDD.class);
        pDigester.addBeanPropertySetter("portlet-app/portlet/description",
                                        "description");
        pDigester.addBeanPropertySetter("portlet-app/portlet/portlet-name",
                                        "portletName");
        pDigester.addBeanPropertySetter("portlet-app/portlet/display-name",
                                        "displayName");
        pDigester.addBeanPropertySetter("portlet-app/portlet/portlet-class",
                                        "portletClass");

        // ** Init Parameter ** //
        pDigester.addObjectCreate("portlet-app/portlet/init-param",
                                  DigesterInitParameterDD.class);
        pDigester.addBeanPropertySetter("portlet-app/portlet/init-param/name",
                                        "parameterName");
        pDigester.addBeanPropertySetter("portlet-app/portlet/init-param/value",
                                        "parameterValue");
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/init-param/description", "description");
        pDigester.addSetNext("portlet-app/portlet/init-param",
                             "addInitParameter");

        pDigester.addBeanPropertySetter("portlet-app/portlet/expiration-cache",
                                        "expirationCache");
        pDigester.addBeanPropertySetter("portlet-app/portlet/resource-bundle",
                                        "resourceBundle");


        pDigester.addObjectCreate("portlet-app/portlet/portlet-info",
                                  DigesterPortletInfoDD.class);
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/portlet-info/title", "title");
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/portlet-info/short-title", "shortTitle");
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/portlet-info/keywords", "keywords");
        pDigester.addSetNext("portlet-app/portlet/portlet-info",
                             "setPortletInfo");

        pDigester.addObjectCreate(
            "portlet-app/portlet/portlet-preferences/preference",
            DigesterPortletPreferenceDD.class);
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/portlet-preferences/preference/name", "name");
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/portlet-preferences/preference/value",
            "value");
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/portlet-preferences/preference/read-only",
            "readOnly");
        pDigester.addSetNext(
            "portlet-app/portlet/portlet-preferences/preference",
            "addPortletPreference");


        // ** Supports ** //
        pDigester.addObjectCreate("portlet-app/portlet/supports",
                                  DigesterSupportedMimeTypeDD.class);
        pDigester.addBeanPropertySetter(
            "portlet-app/portlet/supports/mime-type", "mimeType");
        pDigester.addCallMethod("portlet-app/portlet/supports/portlet-mode",
                                "addPortletMode", 0);
        pDigester.addSetNext("portlet-app/portlet/supports",
                             "addSupportedMimeType");

        //** Supported Locale ** //
        pDigester.addCallMethod("portlet-app/portlet/supported-locale",
                                "addSupportedLocale", 0);
        pDigester.addSetNext("portlet-app/portlet", "addPortlet");
    }
}
