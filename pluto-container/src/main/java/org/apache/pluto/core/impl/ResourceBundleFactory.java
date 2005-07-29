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

import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.PortletInfoDD;

import java.util.*;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
class ResourceBundleFactory {
    
    private static final ResourceBundle EMPTY_BUNDLE =
        new ListResourceBundle() {
            private String[][] contents = new String[][] {};
            public Object[][] getContents() {
                return contents;
            }
        };

    private ResourceBundle defaultBundle;
    private Map bundles = new java.util.HashMap();
    private String bundleName;

    public ResourceBundleFactory(PortletDD dd) {
        PortletInfoDD info = dd.getPortletInfo();
        if(info != null) {
            final String[] title = new String[]{"javax.portlet.title",
                                                info.getTitle()};
            final String[] shrtt = new String[]{"javax.portlet.short-title",
                                                info.getShortTitle()};
            final String[] keys = new String[]{"javax.portlet.keywords",
                                               info.getKeywords()};
            defaultBundle = new ListResourceBundle() {
                Object[][] contents =  new String[][]{title, shrtt, keys};
                public Object[][] getContents() {
                    return contents;
                }
            }; 
        }
        else {
            defaultBundle = EMPTY_BUNDLE;
        }

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
            // intentionally swallow.  Allow the default Bundle.
        }

        bundles.put(locale, defaultBundle);
        return defaultBundle;
    }
}
