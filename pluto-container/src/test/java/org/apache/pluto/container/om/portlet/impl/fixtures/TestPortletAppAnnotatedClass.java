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


import javax.portlet.annotations.CustomPortletMode;
import javax.portlet.annotations.CustomWindowState;
import javax.portlet.annotations.EventDefinition;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletQName;
import javax.portlet.annotations.PublicRenderParameterDefinition;
import javax.portlet.annotations.RuntimeOption;
import javax.portlet.annotations.UserAttribute;

/**
 * Test class annotated with @PortletAnnotation for testing the configuration
 * reader.
 * 
 * @author Scott Nicklous
 */
@PortletApplication(
      userAttributes = {
         @UserAttribute(
            description = @LocaleString("User Given Name"),
            name = "user.name.given"
         ),
         @UserAttribute(
            description = @LocaleString("User Last Name"),
            name = "user.name.family"
         ),
         @UserAttribute(
            description = @LocaleString("User eMail"),
            name = "user.home-info.online.email"
         ),
         @UserAttribute(
            description = @LocaleString("Company Organization"),
            name = "user.business-info.postal.organization"
         ),
      },
      runtimeOptions = {
         @RuntimeOption(name = "javax.portlet.renderHeaders", values = "true"),    
         @RuntimeOption(name = "runtime.option", values = "value")    
      },
      publicParams = {
            @PublicRenderParameterDefinition(
                  qname = @PortletQName(
                        namespaceURI = "http:some.org/", 
                        localPart = "imgName"),
                  identifier = "imgName"
                  ),
            @PublicRenderParameterDefinition(
                  qname = @PortletQName(
                        namespaceURI = "http:some.org/", 
                        localPart = "color"),
                  identifier = "color",
                  description = {@LocaleString("Some description.")},
                  displayName = {@LocaleString("Company Organization")}
                  ),
      },
      events = {
            @EventDefinition(
                  qname = @PortletQName(
                        namespaceURI = "https://www.some.org/", 
                        localPart = "supported-event"),
                  payloadType = String.class),
            @EventDefinition(
                  qname = @PortletQName(
                        namespaceURI = "https://www.some.org/", 
                        localPart = "another-event"),
                  payloadType = String.class,
                  description = {@LocaleString("Some description.")},
                  displayName = {@LocaleString("Company Organization")}
                  )
      },
      defaultNamespaceURI="https://www.some.org/",
      resourceBundle="org.apache.pluto.container.om.portlet.AnotherBundle",
      version = "3.0",
      customWindowStates = {
            @CustomWindowState(description = {
                  @LocaleString("Occupies 50% of the portal page"),
                  @LocaleString(locale="de", value = "Verwendet 50% der Portal-Seite")
            },
            name = "half_page"),
            @CustomWindowState(
            name = "quarter_page")
      },
      customPortletModes={
            @CustomPortletMode(description={
                  @LocaleString("Provides administration functions"),
                  @LocaleString(locale="de", value="Verwaltungsfunktionen")
            }, 
            name = "admin", 
            portalManaged=true),
            @CustomPortletMode(
            name = "aMode", 
            portalManaged=true) 
})
public class TestPortletAppAnnotatedClass {

}
