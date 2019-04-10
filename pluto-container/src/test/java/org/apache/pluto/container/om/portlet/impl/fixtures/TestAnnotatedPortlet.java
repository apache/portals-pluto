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


package org.apache.pluto.container.om.portlet.impl.fixtures;

import javax.portlet.annotations.Dependency;
import javax.portlet.annotations.InitParameter;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.Multipart;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.Preference;
import javax.portlet.annotations.RuntimeOption;
import javax.portlet.annotations.SecurityRoleRef;
import javax.portlet.annotations.Supports;

/**
 * @author nick
 *
 */
@PortletConfiguration(portletName="AnnotatedPortlet",
   initParams = {
      @InitParameter(name="AnnoName", value="value", description= {@LocaleString(locale="DE", value="Beschreibung")}),
      @InitParameter(name="ipname", value="ipvalue", description= {@LocaleString("description")}),
      @InitParameter(name="nullValueParam", value="")
   },
   description={
      @LocaleString("Portlet displaying the time in different time zones"),
      @LocaleString(locale="de", value="Dieses Portlet zeigt die Zeit in verschiedenen Zeitzonen an")
   }, displayName={
      @LocaleString("Time Zone Clock Portlet"),
      @LocaleString(locale="de", value="ZeitzonenPortlet")
   }, title={
      @LocaleString("Annotated Portlet"),
      @LocaleString(locale="DE", value="Annotiertes Portlet")
   }, shortTitle={
      @LocaleString("Anno Portlet"),
      @LocaleString(locale="DE", value="Ein Portlet")
   }, keywords={
      @LocaleString("One, Two, Three"),
      @LocaleString(locale="DE", value="Eins, Zwei, Drei")
   }, prefs = {
      @Preference(name="aPref", values="aValue"),
      @Preference(name="bPref", values="bValue")
   },
   publicParams = {"color", "aPrp"},
   resourceBundle = "org.apache.pluto.container.om.portlet.GoodBundle",
   roleRefs = {
      @SecurityRoleRef(roleName="aRole", roleLink="aLink", description= {@LocaleString(locale="de", value="Beschreibung")})
   }, supports = {
      @Supports(mimeType="aMimeType", portletModes= {"aMode"}, windowStates= {"aWS"}),
      @Supports(mimeType="aMimeType2", portletModes= {"aMode2"}, windowStates= {"aWS2"}),
      @Supports(mimeType="mime-type3", portletModes= {"aMode3"}, windowStates= {"aWS3"})
   }, supportedLocales = {"Locale1"},
   cacheExpirationTime = 30,
   cacheScopePublic = false,
   runtimeOptions = {
      @RuntimeOption(name="aRTO", values= {"true", "false"}),
      @RuntimeOption(name="Runtime-Option2", values= {"value2"})
   }, dependencies = {
      @Dependency(name="Dojo", scope="org.dojotoolkit", version="3.1.4"),
      @Dependency(name="AngularJS",  scope="org.angularjs",version="1.4.8")
   },
   asyncSupported = true,
   multipart = @Multipart(supported=true, location="here", 
                          fileSizeThreshold=1, maxFileSize=2, maxRequestSize=3)
   
)
public class TestAnnotatedPortlet {
   // add portlet methods
}
