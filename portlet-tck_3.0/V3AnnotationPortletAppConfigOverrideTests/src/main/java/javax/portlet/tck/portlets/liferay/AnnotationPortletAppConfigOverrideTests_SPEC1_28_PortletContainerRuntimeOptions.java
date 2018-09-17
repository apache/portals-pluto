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

import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.tck.portlets.AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletContainerRuntimeOptionsBase;
import java.util.Map;

/**
 * This portlet implements several test cases for the JSR 362 TCK. The test case names
 * are defined in the /src/main/resources/xml-resources/additionalTCs.xml
 * file. The build process will integrate the test case names defined in the
 * additionalTCs.xml file into the complete list of test case names for execution by the driver.
 *
 */

@PortletConfiguration(
	portletName = "AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletContainerRuntimeOptions"
)
public class AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletContainerRuntimeOptions extends
	AnnotationPortletAppConfigOverrideTests_SPEC1_28_PortletContainerRuntimeOptionsBase {

	@Override
	public boolean isRuntimeOptionsCorrect(
		Map<String, String[]> runtimeOptions) {

		if (runtimeOptions.containsKey("javax.portlet.escapeXml")) {
			return true;
		}
		else {
			return false;
		}
	}
}
