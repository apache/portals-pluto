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
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.jsp.el;

/**
 * @author  Neil Griffin
 */
class Expression {

	private final String base;
	private final String property;

	public Expression(String expression) {

		int pos = expression.indexOf(".");

		if (pos < 0) {
			base = null;
			property = expression;
		}
		else {
			base = expression.substring(0, pos);
			property = expression.substring(pos + 1);
		}
	}

	public String getBase() {
		return base;
	}

	public String getProperty() {
		return property;
	}
}
