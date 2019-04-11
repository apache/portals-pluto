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
package org.apache.portals.pluto.demo.applicant.mvcbean.cdi.thymeleaf.dto;

import java.io.Serializable;


/**
 * This is a bean that represents a Province and implements the Transfer Object (formerly known as ValueObject/VO)
 * design pattern.
 *
 * @author  "Neil Griffin"
 */
public class Province implements Serializable {

	// serialVersionUID
	private static final long serialVersionUID = 2342374742262228819L;

	// JavaBean Properties
	private final long provinceId;
	private final String provinceName;

	public Province(long provinceId, String provinceName) {
		this.provinceId = provinceId;
		this.provinceName = provinceName;
	}

	public long getProvinceId() {
		return provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}
}
