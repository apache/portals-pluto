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
package org.apache.pluto.driver.services.container.memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

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
    private List values;
    private boolean readOnly;

    public PortletPreferenceImpl() {
        this.values = new ArrayList();
    }

    public PortletPreferenceImpl(String name, String value) {
        this(name,  Arrays.asList(new String[] { value }));
    }

    public PortletPreferenceImpl(String name, String value, boolean readOnly) {
        this(name,  Arrays.asList(new String[] { value }));
        this.readOnly = readOnly;
    }

    public PortletPreferenceImpl(String name, List values) {
        this.name = name;
        this.values = values;
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
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addValue(String value) {
        this.values.add(value);
    }


    /**
     * Override of toString() that prints out 
     * name and values of fields.
     * 
     * @see java.lang.Object#toString()
     */
    public String toString(){
    	StringBuffer str = new StringBuffer();
    	str.append(getClass().getName());
    	str.append("[");
    	str.append("name=" + name + "; ");
    	String[] values = getValues();
    	for (int i = 0; i < values.length; i++) {
        	str.append("value[" + i + "]=" + values[i]);
        	if (i < values.length) {
        		str.append(",");
        	}
		}
    	str.append("; ");
    	str.append("readOnly=" + isReadOnly());
    	str.append("]");
    	return str.toString();
    }

}

