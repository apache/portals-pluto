/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.driver.services.container;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.pluto.core.PortletPreference;

/**
 * PortletPreference implementation used by the PortletPreferencesManager
 * to retrieve the preferences from storage.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Oct 8, 2004
 */
public class PortletPreferenceImpl implements PortletPreference {

    private String name;
    private ArrayList values;

    public PortletPreferenceImpl() {
        this.values = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public String[] getValues() {
        return ((String[])values.toArray(new String[values.size()]));
    }

    public void setValues(String[] values) {
        this.values.addAll(Arrays.asList(values));
    }

    /**
     * Returns false.  Any PortletPreference retrieved by
     * the manager can't be read only.
     * @return
     */
    public boolean isReadOnly() {
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addValue(String value) {
        this.values.add(value);
    }
}

