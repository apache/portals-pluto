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

import java.util.List;

import org.apache.pluto.om.common.Icon;

public interface Filter {

	public abstract String getFilterName();

	public abstract void setFilterName(String filterName);

	public abstract String getFilterClass();

	public abstract void setFilterClass(String filterClass);

	public abstract String getDisplayName();

	public abstract void setDisplayName(String displayName);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract Icon getIcon();

	public abstract void setIcon(Icon icon);

	public abstract List getInitParams();

	public abstract void setInitParams(List initParams);

	public abstract boolean isValid();

}