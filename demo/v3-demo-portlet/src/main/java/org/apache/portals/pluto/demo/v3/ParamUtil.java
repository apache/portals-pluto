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

package org.apache.portals.pluto.demo.v3;

/**
 * Utility class for {@link ActEvtProxyServlet} and {@link TagLibPortlet}.
 */
public class ParamUtil {
	private static final String JSPOBJ     = "/WEB-INF/jsp/tagLibObjects.jsp";
	private static final String JSPBEANS   = "/WEB-INF/jsp/tagLibBeans.jsp";
	public static final String  TEST_BEAN  = "bean";

	/**
	 * for selecting the JSP based on parameter value
	 */
	public static String getJsp(String ttype) {
		String jsp = JSPOBJ;
		if (ttype != null && ttype.equals(TEST_BEAN)) {
			jsp = JSPBEANS;
		}
		return jsp;
	}
}
