/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.container;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.util.StringManager;

/**
 * Factory object used to create Portlet Resource Bundles.
 *
 *
 */
class ResourceBundleFactory {

    private static final Logger LOG =
        LoggerFactory.getLogger(ResourceBundleFactory.class);

    private static final StringManager EXCEPTIONS =
        StringManager.getManager(ResourceBundleFactory.class.getPackage().getName());

    /**
     * The default (no local) resources bundle for
     * this bundle.
     */
    private InlinePortletResourceBundle defaultBundle;

    /**
     * All of the previously loaded bundles.
     */
    private Map<Locale, ResourceBundle> bundles = new HashMap<Locale, ResourceBundle>();

    /**
     * The name of the bundle.
     */
    private String bundleName;

    public ResourceBundleFactory(PortletDefinition dd, PortletInfo windowInfo) {
        bundleName = dd.getResourceBundle();
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle Created: "+bundleName);
        }

        PortletInfo info = dd.getPortletInfo();


        if(info != null) {
            String title = windowInfo == null ? info.getTitle() : windowInfo.getTitle();
            String shortTitle = windowInfo == null ? info.getShortTitle() : windowInfo.getShortTitle();
            String keywords = windowInfo == null ? info.getKeywords() : windowInfo.getKeywords();

            defaultBundle = new InlinePortletResourceBundle(
                    title, shortTitle, keywords
            );
        }
        else {
            defaultBundle = new InlinePortletResourceBundle(new Object[][] { {"a", "b"} });
        }
    }

    public ResourceBundle getResourceBundle(Locale locale) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle: "+bundleName+" : "+locale+" requested. ");
        }

        // If allready loaded for this local, return immediately!
        if (bundles.containsKey(locale)) {
            return bundles.get(locale);
        }

        try {
            ResourceBundle bundle = null;
            if(bundleName != null) {
                ClassLoader loader =
                    Thread.currentThread().getContextClassLoader();
                bundle = ResourceBundle.getBundle(bundleName, locale, loader);
                bundles.put(locale, new CombinedPortletResourceBundle(defaultBundle, bundle));
            }
            else {
                bundles.put(locale, defaultBundle);
            }
        } catch (MissingResourceException mre) {
            if(bundleName != null && LOG.isWarnEnabled()) {
                LOG.warn(EXCEPTIONS.getString("warning.resourcebundle.notfound",bundleName, mre.getMessage()));
            }
            if(LOG.isDebugEnabled()) {
                LOG.debug("Using default bundle for locale ("+locale+").");
            }
            bundles.put(locale, defaultBundle);
        }
        return bundles.get(locale);
    }
}
