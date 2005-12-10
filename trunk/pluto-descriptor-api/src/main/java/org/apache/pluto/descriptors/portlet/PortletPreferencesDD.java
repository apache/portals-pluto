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
package org.apache.pluto.descriptors.portlet;

import java.util.List;

/**
 * <B>TODO:</B> Document
 *
 * @author ddewolf@apache.org
 * @since Jun 29, 2005
 */
public class PortletPreferencesDD {

    private List portletPreferences;
    private String preferencesValidator;

    public List getPortletPreferences() {
        return portletPreferences;
    }

    public void setPortletPreferences(List portletPreferences) {
        this.portletPreferences = portletPreferences;
    }

    public String getPreferencesValidator() {
        return preferencesValidator;
    }

    public void setPreferencesValidator(String preferencesValidator) {
        this.preferencesValidator = preferencesValidator;
    }
}
