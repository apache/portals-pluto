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
import org.apache.pluto.util.StringManager;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import java.util.*;

/**
 * Factory object used to create Portlet Resource Bundles.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 *
 */
class ResourceBundleFactory {
    
    private static final Log LOG = 
        LogFactory.getLog(ResourceBundleFactory.class);
    
    private static final StringManager EXCEPTIONS =
        StringManager.getManager(ResourceBundleFactory.class.getPackage().getName());

    /**
     * The String value utilized for missing keys.
     * Specifically, whenever <code>javax.portlet.title</code>,
     * <code>javax.portlet.shorttitle</code>, or <code>javax.portlet.keywords</code>
     * are null, this value will be returned.
     */
    private static final String NA = "N/A";

    /**
     * The default resource bundle which is utilized when
     * the info is not set in the PortletInfo OR in the
     * actual resource bundle.
     */
    private static final ResourceBundle EMPTY_BUNDLE = createDefaultBundle(null, null, null);

    /**
     * The default (no local) resources bundle for
     * this bundle.
     */
    private ResourceBundle defaultBundle;

    /**
     * All of the previously loaded bundles.
     */
    private Map bundles = new java.util.HashMap();

    /**
     * The name of the bundle.
     */
    private String bundleName;

    public ResourceBundleFactory(PortletDD dd) {
        bundleName = dd.getResourceBundle();

        PortletInfoDD info = dd.getPortletInfo();
        if(info != null) {
            defaultBundle = createDefaultBundle(
                    info.getTitle(),
                    info.getShortTitle(),
                    info.getKeywords()
            );
        }
        else {
            defaultBundle = EMPTY_BUNDLE;
        }
    }

    public ResourceBundle getResourceBundle(Locale locale) {

        // If allready loaded for this local, return immediately!
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
            LOG.info(
                EXCEPTIONS.getString("warning.resourcebundle.notfound",bundleName, mre.getMessage())
            );
            // intentionally swallow.  Allow the default Bundle.
        }

        bundles.put(locale, defaultBundle);
        return defaultBundle;
    }

    private static ResourceBundle createDefaultBundle(String title, String shortTitle, String keywords) {
        String titleValue = title == null ? NA : title;
        String shortValue = shortTitle == null ? NA : shortTitle;
        String keysValue = keywords == null ? NA : keywords;

        final String[] a = new String[] {"javax.portlet.title", titleValue};
        final String[] b = new String[] {"javax.portlet.shorttitle", shortValue};
        final String[] c = new String[] {"javax.portlet.keywords", keysValue };

        ResourceBundle defaultBundle = new ListResourceBundle() {
            Object[][] contents =  new String[][]{a, b, c};
            public Object[][] getContents() {
                return contents;
            }
        };

        return defaultBundle;
    }
}
