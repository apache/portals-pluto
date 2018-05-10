/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package javax.portlet.tck.portlets.liferay;

import javax.portlet.Portlet;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.portlets.AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptionsBase;
import java.util.Map;

@PortletConfiguration(
	portletName = "AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptions"
)
public class AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptions extends
	AnnotationPortletApplicationConfigTests_SPEC1_28_PortletContainerRuntimeOptionsBase implements
	Portlet {

	@Override
	public boolean isRuntimeOptionsCorrect(
		Map<String, String[]> runtimeOptions) {

		if (runtimeOptions.containsKey("javax.portlet.escapeXml")
		   && runtimeOptions.get("javax.portlet.escapeXml")[0].equals("true")) {
			return true;
		}

		return false;
	}
}
