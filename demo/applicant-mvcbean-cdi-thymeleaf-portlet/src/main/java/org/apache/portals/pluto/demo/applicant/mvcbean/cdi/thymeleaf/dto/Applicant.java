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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.ws.rs.FormParam;


/**
 * @author  Neil Griffin
 */
@Dependent
public class Applicant implements Serializable {

	private static final long serialVersionUID = 2774594923346476261L;

	private List<Attachment> attachments;

	@Inject
	@FormParam("city")
	@NotBlank
	private String city;

	private String comments;

	@Inject
	@FormParam("dateOfBirth")
	@NotNull
	@Past
	private Date dateOfBirth;

	@Inject
	@FormParam("emailAddress")
	@Email
	@NotBlank
	private String emailAddress;

	@Inject
	@FormParam("firstName")
	@NotBlank
	private String firstName;

	@Inject
	@FormParam("lastName")
	@NotBlank
	private String lastName;

	@Inject
	@FormParam("phoneNumber")
	@NotBlank
	@Pattern(regexp = "([0-9]+)")
	private String phoneNumber;

	@Inject
	@FormParam("postalCode")
	@NotBlank
	private String postalCode;

	@Inject
	@FormParam("provinceId")
	@NotNull
	@Positive
	private Long provinceId;

	public Applicant() {

		Calendar calendar = new GregorianCalendar();
		this.dateOfBirth = calendar.getTime();
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public String getCity() {
		return city;
	}

	public String getComments() {
		return comments;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
}
