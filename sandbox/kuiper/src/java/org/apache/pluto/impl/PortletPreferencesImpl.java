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

package org.apache.pluto.impl;

import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;
import java.util.Collections;
import java.io.IOException;

/** PortletPreferences implementation. This implementation
 *  does NOT support setting preferences.
 *
 *  This implementation still needs a lot of help! We need to
 *  support the prefernce validator as well as all storage
 *  set and resets.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 22, 2004 at 10:32:43 PM
 */
public class PortletPreferencesImpl implements PortletPreferences {

    private Map map = new java.util.HashMap();

    public boolean isReadOnly(String key) {
        return true;
    }

    public String getValue(String key, String dflt) {
        String[] vals = (String[])map.get(key);
        if(vals!=null && vals.length>0) {
            return vals[0];
        }
        return dflt;
    }

    public String[] getValues(String key, String[] dflts) {
        String[] vals = (String[])map.get(key);
        if(vals!=null) {
            return vals;
        }
        return dflts;
    }

    /** Set the value of the given preference. */
    public void setValue(String s, String s1) throws ReadOnlyException {
        throw new ReadOnlyException("Set not implemented/supported");
    }

    /** Set the values of the given preferences. */
    public void setValues(String s, String[] strings) throws ReadOnlyException {
        throw new ReadOnlyException("Set not implemented/supported");
    }

    /** Retrieve all of th names of the preferences. */
    public Enumeration getNames() {
        return new Vector(map.keySet()).elements();
    }

    /** Retrieve the preferences as a map.
     *
     * @return
     */
    public Map getMap() {
        return Collections.unmodifiableMap(map);
    }

    /** Add all of the following preferences
     *  to this preference store.
     * @param map
     */
    public void addAll(Map map) {
        this.map.putAll(map);
    }

    /** Reset the given preferences to the default value. */
    public void reset(String s) throws ReadOnlyException {
        throw new ReadOnlyException("Reset not implemented/supported");
    }

    /** Store any modified preferences. */
    public void store() throws IOException, ValidatorException {
        throw new IOException("Store not supported");
    }
}
