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
package org.apache.pluto.core.impl;

import org.apache.pluto.core.PortletPreference;

/**
 * <B>TODO</B>: Document
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 20, 2004
 */
public class PortletPreferenceImpl implements PortletPreference {

    private String name;
    private String[] values;
    private boolean readOnly;

    public PortletPreferenceImpl() {

    }

    public PortletPreferenceImpl(String name, String[] values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
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
    	for (int i = 0; i < values.length; i++) {
        	str.append("value[" + i + "]=" + values[i]);
        	if (i < values.length) {
        		str.append(",");
        	}
		}
    	str.append("; ");
    	str.append("readOnly=" + readOnly);
    	str.append("]");
    	return str.toString();
    }
    
}

