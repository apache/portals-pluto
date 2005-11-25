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
package org.apache.pluto.optional.db;

import org.apache.pluto.core.PortletPreference;
import org.apache.pluto.core.impl.PortletPreferenceImpl;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 23, 2005
 */
class PortletPreferenceContainer {

    private Map preferences = new HashMap();

    public void add(List preferences) {
        Iterator it = preferences.iterator();
        while(it.hasNext()) {
            PortletPreference p = (PortletPreference)it.next();
            add(p.getName(), p.getValues());
        }
    }

    private void add(String name, String[] values) {
        for(int i=0;i<values.length;i++) {
            add(name, values[i]);
        }
    }

    public void add(String name, String value) {
        if(!preferences.containsKey(name)) {
            preferences.put(name, new String[] { name });
        }
        else {
            String[] values = (String[])preferences.get(name);
            String[] nw = new String[values.length+1];
            System.arraycopy(values, 0, nw, 0, values.length);
            nw[values.length] = value;
            preferences.put(name, nw);
        }
   }

    public PortletPreference[] createPreferences() {
        PortletPreference[] prefs = new PortletPreference[preferences.size()];

        Iterator it = preferences.entrySet().iterator();
        int i = 0;
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            prefs[i++] = new PortletPreferenceImpl(
                entry.getKey().toString(),
                (String[])entry.getValue()
            );
        }
        return prefs;
    }
}
