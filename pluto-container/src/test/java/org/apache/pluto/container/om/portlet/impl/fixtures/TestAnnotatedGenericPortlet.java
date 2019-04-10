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

import javax.portlet.GenericPortlet;
import javax.portlet.annotations.InitParameter;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletConfiguration;

/**
 * This test class carries a portlet application annotation to define the portlet
 * app along with a portlet configurations annotation that contains configuration 
 * information for two portlets.
 * 
 * @author Scott Nicklous
 *
 */
@PortletConfiguration(portletName="Annotated Generic Portlet", 
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
   }
)
public class TestAnnotatedGenericPortlet extends GenericPortlet {
   // add portlet methods
}
