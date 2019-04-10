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
package org.apache.pluto.container.om.portlet;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.namespace.QName;

public interface PortletApplicationDefinition {

   String JSR_168_VERSION = "1.0";
   String JSR_286_VERSION = "2.0";
   String JSR_362_VERSION = "3.0";

   String getName();
   void setName(String name);

   String getId();
   void setId(String id);
    
   String getContextPath();
   void setContextPath(String contextPath);
    
   PortletDefinition getPortlet(String portletName);
   List<PortletDefinition> getPortlets();
   /**
    * The portlet name can end with the wildcard character '*'. The wildcard 
    * matches any suffix. For filter mapping.
    * 
    * @return     The list of matching portlets
    */
   public List<PortletDefinition> getMatchingPortlets(String portletName);
   void addPortlet(PortletDefinition pd);
   boolean removePortlet(PortletDefinition pd);
   
   List<EventDefinition> getEventDefinitions();
   EventDefinition getEventDefinition(QName qn);
   void addEventDefinition(EventDefinition ed);
   boolean removeEventDefinition(EventDefinition ed);

   PublicRenderParameter getPublicRenderParameter(String identifier);
   List<PublicRenderParameter> getPublicRenderParameters();
   void addPublicRenderParameter(PublicRenderParameter prp);
   boolean removePublicRenderParameter(PublicRenderParameter prp);

   String getVersion();
   void setVersion(String version);

   CustomPortletMode getCustomPortletMode(String name);
   List<CustomPortletMode> getCustomPortletModes();
   void addCustomPortletMode(CustomPortletMode cpm);
   boolean removeCustomPortletMode(CustomPortletMode pm);

   CustomWindowState getCustomWindowState(String name);
   List<CustomWindowState> getCustomWindowStates();
   void addCustomWindowState(CustomWindowState cws);
   boolean removeCustomWindowState(CustomWindowState ws);

   UserAttribute getUserAttribute(String name);
   List<UserAttribute> getUserAttributes();
   void addUserAttribute(UserAttribute ua);
   boolean removeUserAttribute(UserAttribute ua);

   List<SecurityConstraint> getSecurityConstraints();
   void addSecurityConstraint(SecurityConstraint sc);
   boolean removeSecurityCOnstraint(SecurityConstraint sc);

   String getResourceBundle();
   void setResourceBundle(String resourceBundle);

   Filter getFilter(String filterName);
   List<Filter> getFilters();
   void addFilter(Filter filter);
   boolean removeFilter(Filter filter);

   FilterMapping getFilterMapping(String filterName);
   List<FilterMapping> getFilterMappings();
   void addFilterMapping(FilterMapping fm);
   boolean removeFilterMapping(FilterMapping fm);

   Listener getListener(String name);
   List<Listener> getListeners();
   void addListener(Listener listener);
   boolean removeListener(Listener listener);

   String getDefaultNamespace();
   void setDefaultNamespace(String defaultNamespace);

   ContainerRuntimeOption getContainerRuntimeOption(String name);
   List<ContainerRuntimeOption> getContainerRuntimeOptions();
   void addContainerRuntimeOption(ContainerRuntimeOption cro);
   boolean removeRuntimeOption(ContainerRuntimeOption cro);

   Map<Locale, String> getLocaleEncodingMappings();
   void addLocaleEncodingMapping(Locale locale, String encoding);
   String removeLocaleEncodingMapping(Locale locale);
}