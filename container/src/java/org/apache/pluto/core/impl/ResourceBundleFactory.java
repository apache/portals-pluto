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
package org.apache.pluto.core.impl;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.pluto.binding.PortletDD;
import org.apache.pluto.binding.PortletInfoDD;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
class ResourceBundleFactory {

    private ResourceBundle defaultBundle;
    private Map bundles = new java.util.HashMap();
    private String bundleName;

    public ResourceBundleFactory(PortletDD dd) {
        PortletInfoDD info = dd.getPortletInfo();
        final String[] title = new String[]{"javax.portlet.title",
                                            info.getTitle()};
        final String[] shrtt = new String[]{"javax.portlet.short-title",
                                            info.getShortTitle()};
        final String[] keys = new String[]{"javax.portlet.keywords",
                                           info.getKeywords()};
        defaultBundle = new ListResourceBundle() {
            public Object[][] getContents() {
                return new String[][]{title, shrtt, keys};
            }
        };

        bundleName = dd.getResourceBundle();
    }

    public ResourceBundle getResourceBundle(Locale locale) {
        if (bundles.containsKey(locale)) {
            return (ResourceBundle) bundles.get(locale);
        }

        try {
            if (bundleName != null) {
                ClassLoader loader = Thread.currentThread()
                    .getContextClassLoader();
                ResourceBundle bundle = ResourceBundle.getBundle(bundleName,
                                                                 locale,
                                                                 loader);
                if (bundle != null) {
                    bundles.put(locale, bundle);
                    return bundle;
                }
            }
        } catch (MissingResourceException mre) {
            bundles.put(locale, defaultBundle);
        }

        return defaultBundle;
    }
}
