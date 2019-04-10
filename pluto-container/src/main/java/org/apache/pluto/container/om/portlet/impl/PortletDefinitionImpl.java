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
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.PortletMode;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.Dependency;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Scott Nicklous
 * 
 */
public class PortletDefinitionImpl implements PortletDefinition {

   /** Logger. */
   private static final Logger                  LOG                = LoggerFactory.getLogger(PortletDefinitionImpl.class);

   private PortletApplicationDefinition         pad;

   private String                               portletName;
   private String                               portletClass;
   private String                               resourceBundle;
   private String                               cacheScope;

   private int                                  expirationCache;

   private PortletInfo                          info;
   private Preferences                          prefs              = new PreferencesImpl();

   private final List<String>                   supportedLocales   = new ArrayList<String>();
   private final List<String>                   pubParms           = new ArrayList<String>();

   private final List<Description>              descs              = new ArrayList<Description>();
   private final List<DisplayName>              dispNames          = new ArrayList<DisplayName>();

   private final List<EventDefinitionReference> proEvtRefs         = new ArrayList<EventDefinitionReference>();
   private final List<EventDefinitionReference> pubEvtRefs         = new ArrayList<EventDefinitionReference>();

   private final List<ContainerRuntimeOption>   crtOptions         = new ArrayList<ContainerRuntimeOption>();

   private final List<InitParam>                iparms             = new ArrayList<InitParam>();
   private final List<SecurityRoleRef>          secRefs            = new ArrayList<SecurityRoleRef>();
   private final List<Supports>                 supps              = new ArrayList<Supports>();
   private final List<Dependency>               dependencies       = new ArrayList<Dependency>();
   private boolean                              asyncSupported     = false;

   private boolean                              multipartSupported = false;
   private String                               location           = "";
   private Long                                 maxFileSize        = -1L;
   private Long                                 maxRequestSize     = -1L;
   private Integer                              fileSizeThreshold  = 0;

   /**
    * Copy constructor
    * 
    * @param pd
    *           The portlet definition
    */
   public PortletDefinitionImpl(PortletDefinition pd) {
      this.pad = pd.getApplication(); // intentionally not copied
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
         this.proEvtRefs.add(new EventDefinitionReferenceImpl(edr));
      }
      for (EventDefinitionReference edr : pd.getSupportedPublishingEvents()) {
         this.pubEvtRefs.add(new EventDefinitionReferenceImpl(edr));
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
      for (Dependency dep : pd.getDependencies()) {
         this.dependencies.add(dep);
      }
      this.asyncSupported = pd.isAsyncSupported();
      this.multipartSupported = pd.isMultipartSupported();
      this.location = pd.getLocation();
      this.maxFileSize = pd.getMaxFileSize();
      this.maxRequestSize = pd.getMaxRequestSize();
      this.fileSizeThreshold = pd.getFileSizeThreshold();
   }

   /**
    * Constructor
    * 
    * @param pn
    *           portlet name
    * @param pad
    *           portlet application
    */
   public PortletDefinitionImpl(String pn, PortletApplicationDefinition pad) {
      this.portletName = pn;
      this.pad = pad;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getPortletName()
    */
   @Override
   public String getPortletName() {
      return portletName;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getApplication()
    */
   @Override
   public PortletApplicationDefinition getApplication() {
      return pad;
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addInitParam(java.lang.String)
    */
   @Override
   public void addInitParam(InitParam ip) {
      int ii = iparms.indexOf(ip);
      if (ii >= 0) {

         InitParam x = iparms.get(ii);
         iparms.remove(ii);

         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate init parameter. name: ").append(x.getParamName());
         txt.append(", value: ").append(x.getParamValue());
         LOG.debug(txt.toString());
      }
      iparms.add(ip);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getPortletClass()
    */
   @Override
   public String getPortletClass() {
      return portletClass;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setPortletClass(java.lang.String)
    */
   @Override
   public void setPortletClass(String portletClass) {
      this.portletClass = portletClass;
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getPortletPreferences()
    */
   @Override
   public Preferences getPortletPreferences() {
      return new PreferencesImpl(prefs);
   }

   @Override
   public void setPortletPreferences(Preferences prefs) {
      this.prefs = prefs;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedProcessingEvents()
    */
   @Override
   public List<EventDefinitionReference> getSupportedProcessingEvents() {
      return new ArrayList<EventDefinitionReference>(proEvtRefs);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedProcessingEvent(EventDefinitionReference)
    */
   @Override
   public void addSupportedProcessingEvent(EventDefinitionReference edr) {
      if (proEvtRefs.remove(edr)) {
         LOG.debug("Removed duplicate supported processing event ref: " + edr.getQualifiedName());
      }
      proEvtRefs.add(edr);
   }

   @Override
   public boolean removeSupportedProcessingEvent(EventDefinitionReference edr) {
      return proEvtRefs.remove(edr);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedPublishingEvents()
    */
   @Override
   public List<EventDefinitionReference> getSupportedPublishingEvents() {
      return new ArrayList<EventDefinitionReference>(pubEvtRefs);
   }

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedPublishingEvent(javax.xml.namespace.QName)
    */
   @Override
   public void addSupportedPublishingEvent(EventDefinitionReference edr) {
      if (pubEvtRefs.remove(edr)) {
         LOG.debug("Removed duplicate supported publishing event ref: " + edr.getQualifiedName());
      }
      pubEvtRefs.add(edr);
   }

   @Override
   public boolean removeSupportedPublishingEvent(EventDefinitionReference edr) {
      return pubEvtRefs.remove(edr);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedPublicRenderParameters()
    */
   @Override
   public List<String> getSupportedPublicRenderParameters() {
      return new ArrayList<String>(pubParms);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedPublicRenderParameter(java.lang.String)
    */
   @Override
   public void addSupportedPublicRenderParameter(String identifier) {
      if (pubParms.remove(identifier)) {
         LOG.debug("Removed duplicate supported render param: " + identifier);
      }
      pubParms.add(identifier);
   }

   @Override
   public boolean removeSupportedPublicRenderParameter(String identifier) {
      return pubParms.remove(identifier);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getResourceBundle()
    */
   @Override
   public String getResourceBundle() {
      return resourceBundle;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setResourceBundle(java.lang.String)
    */
   @Override
   public void setResourceBundle(String resourceBundle) {
      this.resourceBundle = resourceBundle;
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSecurityRoleRefs()
    */
   @Override
   public List<SecurityRoleRef> getSecurityRoleRefs() {
      return new ArrayList<SecurityRoleRef>(secRefs);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSecurityRoleRef(SecurityRoleRef)
    */
   @Override
   public void addSecurityRoleRef(SecurityRoleRef srr) {
      if (secRefs.remove(srr)) {
         LOG.debug("Removed duplicate security role ref: " + srr.getRoleName());
      }
      secRefs.add(srr);
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupports()
    */
   @Override
   public List<Supports> getSupports() {
      return new ArrayList<Supports>(supps);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupports(java.lang.String)
    */
   @Override
   public void addSupports(Supports supp) {
      if (supps.remove(supp)) {
         LOG.warn("Overwriting duplicate supports block for: " + supp.getMimeType());
      }
      supps.add(supp);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getConfiguredMimeTypes()
    */
   @Override
   public Set<String> getConfiguredMimeTypes() {
      Set<String> types = new HashSet<String>();
      for (Supports supp : supps) {
         types.add(supp.getMimeType());
      }
      return types;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#isPortletModeSupported(String, PrtletMode)
    */
   @Override
   public boolean isPortletModeSupported(String mimeType, PortletMode pm) {
      boolean supported = false;
      if (supps.isEmpty()) {
         // No supports blocks configured for portlet; assume view is always supported
         if (pm.equals(PortletMode.VIEW)) {
            supported = true;
         }
      } else {
         if (getSupports(mimeType) != null) {
            if (pm.equals(PortletMode.VIEW)) {
               supported = true;
            } else {
               for (String strpm : getSupports(mimeType).getPortletModes()) {
                  if ((new PortletMode(strpm)).equals(pm)) {
                     supported = true;
                     break;
                  }
               }
            }
         } else {
            for (Supports supp : supps) {
               if (supp.getMimeType().matches("(?:\\*/\\*|\\*|text/\\*)")) {
                  if (pm.equals(PortletMode.VIEW)) {
                     supported = true;
                  } else {
                     for (String strpm : supp.getPortletModes()) {
                        if ((new PortletMode(strpm)).equals(pm)) {
                           supported = true;
                           break;
                        }
                     }
                  }
                  if (supported == true) {
                     break;
                  }
               }
            }
         }
      }
      
      if (LOG.isDebugEnabled()) {
         StringBuilder txt = new StringBuilder();
         txt.append("Portlet mode: ").append(pm.toString());
         txt.append(", MIME type: ").append(mimeType);
         txt.append(", is supported: ").append(supported);
         LOG.debug(txt.toString());
      }
      
      return supported;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDependency(java.lang.String)
    */
   @Override
   public Dependency getDependency(String name) {
      Dependency ret = null;
      for (Dependency item : dependencies) {
         if (item.getName().equals(name)) {
            ret = new DependencyImpl(item);
         }
      }
      return ret;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDependency()
    */
   @Override
   public List<Dependency> getDependencies() {
      return new ArrayList<Dependency>(dependencies);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addDependency(java.lang.String)
    */
   @Override
   public void addDependency(Dependency dep) {
      if (dependencies.remove(dep)) {
         LOG.debug("Removed duplicate dependencies block for: " + dep.getName());
      }
      dependencies.add(dep);
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addDescription(org.apache.pluto.container.om.portlet.
    * Description)
    */
   @Override
   public void addDescription(Description desc) {
      if (descs.remove(desc)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate description for locale: ").append(desc.getLocale().toString());
         txt.append(", description: ").append(desc.getText());
         LOG.debug(txt.toString());
      }
      descs.add(desc);
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getDisplayNames()
    */
   @Override
   public List<DisplayName> getDisplayNames() {
      return new ArrayList<DisplayName>(dispNames);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addDisplayName(org.apache.pluto.container.om.portlet.
    * DisplayName)
    */
   @Override
   public void addDisplayName(DisplayName dispName) {
      if (dispNames.remove(dispName)) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate description for locale: ").append(dispName.getLocale().toString());
         txt.append(", description: ").append(dispName.getText());
         LOG.debug(txt.toString());
      }
      dispNames.add(dispName);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getSupportedLocales()
    */
   @Override
   public List<String> getSupportedLocales() {
      return new ArrayList<String>(supportedLocales);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addSupportedLocale(java.lang.String)
    */
   @Override
   public void addSupportedLocale(String lang) {
      if (supportedLocales.remove(lang)) {
         LOG.debug("Removed duplicate supported locale: " + lang);
      }
      supportedLocales.add(lang);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getExpirationCache()
    */
   @Override
   public int getExpirationCache() {
      return expirationCache;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setExpirationCache(int)
    */
   @Override
   public void setExpirationCache(int expirationCache) {
      this.expirationCache = expirationCache;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#getCacheScope()
    */
   @Override
   public String getCacheScope() {
      return cacheScope;
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#setCacheScope(java.lang.String)
    */
   @Override
   public void setCacheScope(String cacheScope) {
      this.cacheScope = cacheScope;
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.PortletDefinition#addContainerRuntimeOption(java.lang.String)
    */
   @Override
   public void addContainerRuntimeOption(ContainerRuntimeOption cro) {
      int ii = crtOptions.indexOf(cro);
      if (ii >= 0) {

         ContainerRuntimeOption x = crtOptions.get(ii);
         crtOptions.remove(ii);

         StringBuilder txt = new StringBuilder(128);
         txt.append("Removed duplicate portlet container runtime option: ").append(x.getName());
         txt.append(", vals: ").append(x.getValues().toString());
         LOG.debug(txt.toString());
      }
      crtOptions.add(new ContainerRuntimeOptionImpl(cro));
   }

   /**
    * @return the asyncSupported
    */
   @Override
   public boolean isAsyncSupported() {
      return asyncSupported;
   }

   /**
    * @param asyncSupported
    *           the asyncSupported to set
    */
   @Override
   public void setAsyncSupported(boolean asyncSupported) {
      this.asyncSupported = asyncSupported;
   }

   /**
    * @return the multipartSupported
    */
   @Override
   public boolean isMultipartSupported() {
      return multipartSupported;
   }

   /**
    * @param multipartSupported
    *           the multipartSupported to set
    */
   @Override
   public void setMultipartSupported(boolean multipartSupported) {
      this.multipartSupported = multipartSupported;
   }

   /**
    * @return the location
    */
   @Override
   public String getLocation() {
      return location;
   }

   /**
    * @param location
    *           the location to set
    */
   @Override
   public void setLocation(String location) {
      this.location = location;
   }

   /**
    * @return the maxFileSize
    */
   @Override
   public Long getMaxFileSize() {
      return maxFileSize;
   }

   /**
    * @param maxFileSize
    *           the maxFileSize to set
    */
   @Override
   public void setMaxFileSize(Long maxFileSize) {
      this.maxFileSize = maxFileSize;
   }

   /**
    * @return the maxRequestSize
    */
   @Override
   public Long getMaxRequestSize() {
      return maxRequestSize;
   }

   /**
    * @param maxRequestSize
    *           the maxRequestSize to set
    */
   @Override
   public void setMaxRequestSize(Long maxRequestSize) {
      this.maxRequestSize = maxRequestSize;
   }

   /**
    * @return the fileSizeThreshold
    */
   @Override
   public Integer getFileSizeThreshold() {
      return fileSizeThreshold;
   }

   /**
    * @param fileSizeThreshold
    *           the fileSizeThreshold to set
    */
   @Override
   public void setFileSizeThreshold(Integer fileSizeThreshold) {
      this.fileSizeThreshold = fileSizeThreshold;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((portletName == null) ? 0 : portletName.hashCode());
      return result;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      PortletDefinitionImpl other = (PortletDefinitionImpl) obj;
      if (portletName == null) {
         if (other.portletName != null) {
            return false;
         }
      } else if (!portletName.equals(other.portletName)) {
         return false;
      }
      return true;
   }

}
