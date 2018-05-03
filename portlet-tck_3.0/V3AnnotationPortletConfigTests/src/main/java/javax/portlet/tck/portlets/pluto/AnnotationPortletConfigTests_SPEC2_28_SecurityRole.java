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

package javax.portlet.tck.portlets.pluto;

import javax.portlet.Portlet;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.SecurityRoleRef;
import javax.portlet.tck.portlets.AnnotationPortletConfigTests_SPEC2_28_SecurityRoleBase;

@PortletConfiguration(
	portletName = "AnnotationPortletConfigTests_SPEC2_28_SecurityRole",
	roleRefs = @SecurityRoleRef(roleName = "tckuser", roleLink = "tckuser")
)
public class AnnotationPortletConfigTests_SPEC2_28_SecurityRole extends
	AnnotationPortletConfigTests_SPEC2_28_SecurityRoleBase implements
	Portlet {

	@Override
	public String getRoleName() {
		return "tckuser";
	}
}
