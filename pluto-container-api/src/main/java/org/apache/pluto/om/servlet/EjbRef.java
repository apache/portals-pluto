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

public interface EjbRef {

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getEjbRefName();

	public abstract void setEjbRefName(String ejbRefName);

	public abstract String getEjbRefType();

	public abstract void setEjbRefType(String ejbRefType);

	public abstract String getHome();

	public abstract void setHome(String home);

	public abstract String getRemote();

	public abstract void setRemote(String remote);

	public abstract String getEjbLink();

	public abstract void setEjbLink(String ejbLink);

	public abstract String getRunAs();

	public abstract void setRunAs(String runAs);

}