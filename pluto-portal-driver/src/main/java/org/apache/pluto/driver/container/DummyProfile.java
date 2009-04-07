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
package org.apache.pluto.driver.container;

import java.util.Set;

import javax.ccpp.Attribute;
import javax.ccpp.Component;
import javax.ccpp.Profile;
import javax.ccpp.ProfileDescription;

/**
 * A dummy replace for a real CCPP Implementation (TBD)
 */
public class DummyProfile implements Profile {

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getAttribute(java.lang.String)
	 */
	public Attribute getAttribute(String arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getAttributes()
	 */
	@SuppressWarnings("unchecked")
    public Set getAttributes() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getComponent(java.lang.String)
	 */
	public Component getComponent(String arg0) {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getComponents()
	 */
	@SuppressWarnings("unchecked")
    public Set getComponents() {
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.ccpp.Profile#getDescription()
	 */
	public ProfileDescription getDescription() {
		return null;
	}

}
