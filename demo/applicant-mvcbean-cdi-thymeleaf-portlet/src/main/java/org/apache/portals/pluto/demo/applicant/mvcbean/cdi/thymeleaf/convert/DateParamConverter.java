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
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletPreferences;
import javax.ws.rs.ext.ParamConverter;


/**
 * @author  Neil Griffin
 */
public class DateParamConverter implements ParamConverter<Date> {

	private DateFormat dateFormat;

	public DateParamConverter(PortletPreferences portletPreferences) {
		this.dateFormat = new SimpleDateFormat(portletPreferences.getValue("datePattern", null));
	}

	@Override
	public Date fromString(String value) {

		try {
			return dateFormat.parse(value);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public String toString(Date date) {
		return dateFormat.format(date);
	}
}
