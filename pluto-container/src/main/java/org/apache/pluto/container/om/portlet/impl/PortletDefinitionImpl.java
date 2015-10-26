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


package org.apache.pluto.container.om.portlet.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.om.portlet.Preferences;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;

/**
 * @author Scott Nicklous
 *
 */
public class PortletDefinitionImpl implements PortletDefinition {
   
   private PortletApplicationDefinition pad;
   
   private String portletName;
   private String portletClass;
   private String resourceBundle;
   private String cacheScope;
   
   private int expirationCache;
   
   private PortletInfo info;
   private Preferences prefs;
   
   private final List<String> supportedLocales = new ArrayList<String>();
   private final List<String> pubParms = new ArrayList<String>();
   
   private final List<Description> descs = new ArrayList<Description>();
   private final List<DisplayName> dispNames = new ArrayList<DisplayName>();

   private final List<EventDefinitionReference> proEvtRefs = new ArrayList<EventDefinitionReference>();
   private final List<EventDefinitionReference> pubEvtRefs =  new ArrayList<EventDefinitionReference>();

   private final List<ContainerRuntimeOption> crtOptions = new ArrayList<ContainerRuntimeOption>();
   
   private final List<InitParam> iparms = new ArrayList<InitParam>(); 
   private final List<SecurityRoleRef> secRefs = new ArrayList<SecurityRoleRef>(); 
   private final List<Supports> supps = new ArrayList<Supports>(); 

   /**
    * Copy constructor
    * @param pd   The portlet definition
    */
   public PortletDefinitionImpl(PortletDefinition pd) {
      this.pad = pd.getApplication();        // intentionally not copied
      this.portletName = pd.getPortletName();
      this.portletClass = pd.getPortletClass();
      this.resourceBundle = pd.getResourceBundle();
      this.cacheScope = pd.getCacheScope();
      this.expirationCache = pd.getExpirationCache();
      
      PortletInfo pi = pd.getPortletInfo();
      this.info = (pi == null) ? null : new PortletInfoImpl(pi);
      
      Preferences prefs = pd.getPortletPreferences();
      this.prefs = (prefs == null) ? null : new PreferencesImpl(prefs);
      
      this.supportedLocales.addAll(pd.getSupportedLocales());
      this.pubParms.addAll(pd.getSupportedPublicRenderParameters());
      
      for (Description d : pd.getDescriptions()) {
         this.descs.add(new DescriptionImpl(d));
      }
      for (DisplayName dn : pd.getDisplayNames()) {
         this.dispNames.add(new DisplayNameImpl(dn));
      }
      for (EventDefinitionReference edr : pd.getSupportedProcessingEvents()) {
         this.proEvtRefs.add(
               new EventDefinitionReferenceImpl(edr));
      }
      for (EventDefinitionReference edr : pd.getSupportedPublishingEvents()) {
         this.pubEvtRefs.add(
               new EventDefinitionReferenceImpl(edr));
      }
      for (ContainerRuntimeOption crt : pd.getContainerRuntimeOptions()) {
         this.crtOptions.add(new ContainerRuntimeOptionImpl(crt));
      }
      for (InitParam ip : pd.getInitParams()) {
         this.iparms.add(new InitParamImpl(ip));
      }
      for (SecurityRoleRef srr : pd.getSecurityRoleRefs()) {
         this.secRefs.add(new SecurityRoleRefImpl(srr));
      }
      for (Supports s : pd.getSupports()) {
         this.supps.add(new SupportsImpl(s));
      }
   }
   
   /**
    * Constructor
    * @param pn      portlet name
    * @param pad     portlet application
    */
   public PortletDefinitionImpl(String pn, PortletApplicationDefinition pad) {
      this.portletName = pn;
      this.pad = pad;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getPortletName()
    */
   @Override
   public String getPortletName() {
      return portletName;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getApplication()
    */
   @Override
   public PortletApplicationDefinition getApplication() {
      return pad;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getInitParam(java.lang.String)
    */
   @Override
   public InitParam getInitParam(String paramName) {
      InitParam ret = null;
      for (InitParam item : iparms) {
         if (item.getParamName().equals(paramName)) {
            ret = new InitParamImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getInitParams()
    */
   @Override
   public List<InitParam> getInitParams() {
      ArrayList<InitParam> ips = new ArrayList<InitParam>();
      for (InitParam ip : iparms) {
         ips.add(new InitParamImpl(ip));
      }
      return ips;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addInitParam(java.lang.String)
    */
   @Override
   public void addInitParam(InitParam ip) {
      iparms.add(ip);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getPortletClass()
    */
   @Override
   public String getPortletClass() {
      return portletClass;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setPortletClass(java.lang.String)
    */
   @Override
   public void setPortletClass(String portletClass) {
      this.portletClass = portletClass;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getPortletInfo()
    */
   @Override
   public PortletInfo getPortletInfo() {
      return (info != null) ? new PortletInfoImpl(info) : null;
   }

   @Override
   public void setPortletInfo(PortletInfo info) {
      this.info = info;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getPortletPreferences()
    */
   @Override
   public Preferences getPortletPreferences() {
      return (prefs != null) ? new PreferencesImpl(prefs) : null;
   }

   @Override
   public void setPortletPreferences(Preferences prefs) {
      this.prefs = prefs;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedProcessingEvents()
    */
   @Override
   public List<EventDefinitionReference> getSupportedProcessingEvents() {
      return new ArrayList<EventDefinitionReference>(proEvtRefs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedProcessingEvent(EventDefinitionReference)
    */
   @Override
   public void addSupportedProcessingEvent(EventDefinitionReference edr) {
      proEvtRefs.add(edr);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedPublishingEvents()
    */
   @Override
   public List<EventDefinitionReference> getSupportedPublishingEvents() {
      return new ArrayList<EventDefinitionReference>(pubEvtRefs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedPublishingEvent(javax.xml.namespace.QName)
    */
   @Override
   public void addSupportedPublishingEvent(EventDefinitionReference edr) {
      pubEvtRefs.add(edr);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedPublicRenderParameters()
    */
   @Override
   public List<String> getSupportedPublicRenderParameters() {
      return new ArrayList<String>(pubParms);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedPublicRenderParameter(java.lang.String)
    */
   @Override
   public void addSupportedPublicRenderParameter(String identifier) {
      pubParms.add(identifier);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getResourceBundle()
    */
   @Override
   public String getResourceBundle() {
      return resourceBundle;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setResourceBundle(java.lang.String)
    */
   @Override
   public void setResourceBundle(String resourceBundle) {
      this.resourceBundle = resourceBundle;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSecurityRoleRef(java.lang.String)
    */
   @Override
   public SecurityRoleRef getSecurityRoleRef(String roleName) {
      SecurityRoleRef ret = null;
      for (SecurityRoleRef item : secRefs) {
         if (item.getRoleName().equals(roleName)) {
            ret = new SecurityRoleRefImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSecurityRoleRefs()
    */
   @Override
   public List<SecurityRoleRef> getSecurityRoleRefs() {
      return new ArrayList<SecurityRoleRef>(secRefs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSecurityRoleRef(SecurityRoleRef)
    */
   @Override
   public void addSecurityRoleRef(SecurityRoleRef srr) {
      secRefs.add(srr);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupports(java.lang.String)
    */
   @Override
   public Supports getSupports(String mimeType) {
      Supports ret = null;
      for (Supports item : supps) {
         if (item.getMimeType().equals(mimeType)) {
            ret = new SupportsImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupports()
    */
   @Override
   public List<Supports> getSupports() {
      return new ArrayList<Supports>(supps);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupports(java.lang.String)
    */
   @Override
   public void addSupports(Supports supp) {
      supps.add(supp);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDescription(java.util.Locale)
    */
   @Override
   public Description getDescription(Locale locale) {
      Description ret = null;
      for (Description item : descs) {
         if (item.getLocale().equals(locale)) {
            ret = new DescriptionImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addDescription(org.apache.pluto.container.om.portlet.Description)
    */
   @Override
   public void addDescription(Description desc) {
      descs.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDisplayName(java.util.Locale)
    */
   @Override
   public DisplayName getDisplayName(Locale locale) {
      DisplayName ret = null;
      for (DisplayName item : dispNames) {
         if (item.getLocale().equals(locale)) {
            ret = new DisplayNameImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDisplayNames()
    */
   @Override
   public List<DisplayName> getDisplayNames() {
      return new ArrayList<DisplayName>(dispNames);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addDisplayName(org.apache.pluto.container.om.portlet.DisplayName)
    */
   @Override
   public void addDisplayName(DisplayName desc) {
      dispNames.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedLocales()
    */
   @Override
   public List<String> getSupportedLocales() {
      return new ArrayList<String>(supportedLocales);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedLocale(java.lang.String)
    */
   @Override
   public void addSupportedLocale(String lang) {
      supportedLocales.add(lang);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getExpirationCache()
    */
   @Override
   public int getExpirationCache() {
      return expirationCache;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setExpirationCache(int)
    */
   @Override
   public void setExpirationCache(int expirationCache) {
      this.expirationCache = expirationCache;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getCacheScope()
    */
   @Override
   public String getCacheScope() {
      return cacheScope;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setCacheScope(java.lang.String)
    */
   @Override
   public void setCacheScope(String cacheScope) {
      this.cacheScope = cacheScope;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getContainerRuntimeOption(java.lang.String)
    */
   @Override
   public ContainerRuntimeOption getContainerRuntimeOption(String name) {
      ContainerRuntimeOption ret = null;
      for (ContainerRuntimeOption item : crtOptions) {
         if (item.getName().equals(name)) {
            ret = new ContainerRuntimeOptionImpl(item);
         }
      }
      return ret;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getContainerRuntimeOptions()
    */
   @Override
   public List<ContainerRuntimeOption> getContainerRuntimeOptions() {
      ArrayList<ContainerRuntimeOption> crtos = new ArrayList<ContainerRuntimeOption>();
      for (ContainerRuntimeOption crto : crtOptions) {
         crtos.add(new ContainerRuntimeOptionImpl(crto));
      }
      return crtos;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addContainerRuntimeOption(java.lang.String)
    */
   @Override
   public void addContainerRuntimeOption(ContainerRuntimeOption cro) {
      crtOptions.add(new ContainerRuntimeOptionImpl(cro));
   }

}
