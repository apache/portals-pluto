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
package org.apache.pluto.binding.impl.digester;

import java.util.ArrayList;

import org.apache.pluto.binding.SupportedMimeTypeDD;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 20, 2004
 */
public class DigesterSupportedMimeTypeDD implements SupportedMimeTypeDD {

    private String mimeType;
    private ArrayList portletModes;

    public DigesterSupportedMimeTypeDD() {
        portletModes = new ArrayList();
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String[] getPortletModes() {
        return (String[]) portletModes.toArray(new String[portletModes.size()]);
    }

    public void addPortletMode(String portletModes) {
        this.portletModes.add(portletModes);
    }
}

