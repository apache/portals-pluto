/*
 * Copyright 2008 The Apache Software Foundation
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
package org.apache.pluto.om.servlet;

public interface LoginConfig {

	public abstract String getAuthMethod();

	public abstract void setAuthMethod(String authMethod);

	public abstract String getRealmName();

	public abstract void setRealmName(String realmName);

	public abstract FormLoginConfig getFormLoginConfig();

	public abstract void setFormLoginConfig(FormLoginConfig formLoginConfig);

}