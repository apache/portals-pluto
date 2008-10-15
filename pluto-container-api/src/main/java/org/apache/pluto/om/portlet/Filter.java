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
package org.apache.pluto.om.portlet;

import java.util.List;

import org.apache.pluto.om.ElementFactoryList;
import org.apache.pluto.om.common.Description;
import org.apache.pluto.om.common.DisplayName;
import org.apache.pluto.om.common.InitParam;

public interface Filter {

	ElementFactoryList<Description> getDescriptions();

	ElementFactoryList<DisplayName> getDisplayNames();

	String getFilterClass();

	void setFilterClass(String filterClass);

	String getFilterName();

	void setFilterName(String filterName);

	ElementFactoryList<InitParam> getInitParams();

	List<String> getLifecycles();

	void setLifecycles(List<String> lifecycles);
}