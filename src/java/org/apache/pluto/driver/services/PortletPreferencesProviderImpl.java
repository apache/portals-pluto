/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.services;

import java.io.IOException;

import javax.portlet.PortletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.services.PortletPreferencesFactory;

/**
 * The Portal Driver's PortletPreferencesFactory implementation. This
 * implementation makes use of the filesystem for writing portlet preferences.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortletPreferencesProviderImpl
    implements PortletPreferencesFactory {

    public PortletPreferencesProviderImpl() {

    }

    public PortletPreference[] getStoredPreferences(PortletWindow window,
                                                    PortletRequest req) {
        return new PortletPreference[0];
    }

    public PortletPreference getStoredPreference(PortletWindow window,
                                                 PortletRequest req,
                                                 String preferenceName) {
        return null;
    }

    public void store(PortletPreference[] preferences) throws IOException {

    }
}

