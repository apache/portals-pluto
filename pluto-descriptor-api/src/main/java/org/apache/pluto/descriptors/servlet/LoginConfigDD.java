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
package org.apache.pluto.descriptors.servlet;

import org.apache.pluto.om.servlet.FormLoginConfig;
import org.apache.pluto.om.servlet.LoginConfig;

/**
 * @version $Id: LoginConfigDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class LoginConfigDD implements LoginConfig  {

    private String authMethod;
    private String realmName;
    private FormLoginConfig formLoginConfig;

    public LoginConfigDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.LoginConfig#getAuthMethod()
	 */
    public String getAuthMethod() {
        return authMethod;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.LoginConfig#setAuthMethod(java.lang.String)
	 */
    public void setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.LoginConfig#getRealmName()
	 */
    public String getRealmName() {
        return realmName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.LoginConfig#setRealmName(java.lang.String)
	 */
    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.LoginConfig#getFormLoginConfig()
	 */
    public FormLoginConfig getFormLoginConfig() {
        return formLoginConfig ;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.LoginConfig#setFormLoginConfig(org.apache.pluto.descriptors.servlet.FormLoginConfig)
	 */
    public void setFormLoginConfig(FormLoginConfig formLoginConfig) {
        this.formLoginConfig = formLoginConfig;
    }
}

