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
import javax.portlet.annotations.Multipart;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletConfigurations;

/**
 * @author nick
 *
 */
@PortletApplication(
      defaultNamespaceURI="https://www.apache.org/",
      resourceBundle="org.apache.pluto.container.om.portlet.GoodBundle",
      version = "3.0"
)
@PortletConfigurations( {
   @PortletConfiguration(portletName="Portlet1", 
   initParams = {
         @InitParameter(name="color", value="#cafeba"),
      },
      description={
         @LocaleString("Portlet displaying the time in different time zones"),
      }, displayName={
         @LocaleString("Time Zone Clock Portlet"),
      }, title={
         @LocaleString("Annotated Portlet"),
      }, shortTitle={
         @LocaleString("Anno Portlet"),
      }, keywords={
         @LocaleString("One, Two, Three"),
      }
   ),
   @PortletConfiguration(portletName="Portlet2", 
   initParams = {
         @InitParameter(name="color", value="#def"),
      },
      description={
         @LocaleString(locale="de", value="Dieses Portlet zeigt die Zeit in verschiedenen Zeitzonen an")
      }, displayName={
         @LocaleString(locale="de", value="ZeitzonenPortlet")
      }, title={
         @LocaleString(locale="DE", value="Annotiertes Portlet")
      }, shortTitle={
         @LocaleString(locale="DE", value="Ein Portlet")
      }, keywords={
         @LocaleString(locale="DE", value="Eins, Zwei, Drei")
      },
      asyncSupported=true,
      multipart = @Multipart(supported=false)
   ),
   @PortletConfiguration(portletName="Portlet3", 
   initParams = {
         @InitParameter(name="color", value="#def"),
      },
      description={
         @LocaleString(locale="de", value="Dieses Portlet zeigt die Zeit in verschiedenen Zeitzonen an")
      }, displayName={
         @LocaleString(locale="de", value="ZeitzonenPortlet")
      }, title={
         @LocaleString(locale="DE", value="Annotiertes Portlet")
      }, shortTitle={
         @LocaleString(locale="DE", value="Ein Portlet")
      }, keywords={
         @LocaleString(locale="DE", value="Eins, Zwei, Drei")
      },
      asyncSupported=false,
      multipart = @Multipart(supported=true, location="/home", 
            fileSizeThreshold=11, maxFileSize=22, maxRequestSize=33)
   ),
})
public class TestMultiAnnotatedPortlet extends GenericPortlet {
   // add portlet methods
}
