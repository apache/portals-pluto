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

import org.apache.pluto.om.servlet.EnvEntry;

/**
 * <B>TODO</B>: Document
 * @version $Id: EnvEntryDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class EnvEntryDD implements EnvEntry {

    private String description;
    private String envEntryName;
    private String envEntryValue;
    private String envEntryType;

    public EnvEntryDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#getDescription()
	 */
    public String getDescription() {
        return description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#setDescription(java.lang.String)
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#getEnvEntryName()
	 */
    public String getEnvEntryName() {
        return envEntryName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#setEnvEntryName(java.lang.String)
	 */
    public void setEnvEntryName(String envEntryName) {
        this.envEntryName = envEntryName;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#getEnvEntryValue()
	 */
    public String getEnvEntryValue() {
        return envEntryValue;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#setEnvEntryValue(java.lang.String)
	 */
    public void setEnvEntryValue(String envEntryValue) {
        this.envEntryValue = envEntryValue;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#getEnvEntryType()
	 */
    public String getEnvEntryType() {
        return envEntryType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.EnvEntry#setEnvEntryType(java.lang.String)
	 */
    public void setEnvEntryType(String envEntryType) {
        this.envEntryType = envEntryType;
    }

}

