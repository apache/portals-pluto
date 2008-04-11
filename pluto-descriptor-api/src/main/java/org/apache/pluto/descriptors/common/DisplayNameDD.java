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
package org.apache.pluto.descriptors.common;

import java.util.Locale;

import org.apache.pluto.om.common.DisplayName;

/**
 *
 * @since 1.1.0
 */
public class DisplayNameDD implements DisplayName {

    private String displayName;
    private String lang = Locale.ENGLISH.toString();

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.DisplayName#getDisplayName()
	 */
    public String getDisplayName() {
        return displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.DisplayName#setDisplayName(java.lang.String)
	 */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.DisplayName#getLang()
	 */
    public String getLang() {
        return lang;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.DisplayName#setLang(java.lang.String)
	 */
    public void setLang(String lang) {
        this.lang = lang;
    }
}
