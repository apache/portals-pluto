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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.PreferencesValidator;
import javax.portlet.annotations.InitParameter;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.Multipart;
import javax.portlet.annotations.PortletApplication;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.PortletListener;
import javax.portlet.annotations.PortletPreferencesValidator;
import javax.portlet.annotations.PortletLifecycleFilter;
import javax.portlet.annotations.PublicRenderParameterDefinition;
import javax.portlet.annotations.RuntimeOption;
import javax.portlet.annotations.UserAttribute;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.HeaderFilter;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.CustomWindowState;
import org.apache.pluto.container.om.portlet.Dependency;
import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.EventDefinitionReference;
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.Listener;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.om.portlet.Preference;
import org.apache.pluto.container.om.portlet.Preferences;
import org.apache.pluto.container.om.portlet.PublicRenderParameter;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.om.portlet30.impl.ContainerRuntimeOptionType;
import org.apache.pluto.container.om.portlet30.impl.CustomPortletModeType;
import org.apache.pluto.container.om.portlet30.impl.CustomWindowStateType;
import org.apache.pluto.container.om.portlet30.impl.DependencyType;
import org.apache.pluto.container.om.portlet30.impl.DescriptionType;
import org.apache.pluto.container.om.portlet30.impl.DisplayNameType;
import org.apache.pluto.container.om.portlet30.impl.EventDefinitionReferenceType;
import org.apache.pluto.container.om.portlet30.impl.EventDefinitionType;
import org.apache.pluto.container.om.portlet30.impl.FilterMappingType;
import org.apache.pluto.container.om.portlet30.impl.FilterType;
import org.apache.pluto.container.om.portlet30.impl.InitParamType;
import org.apache.pluto.container.om.portlet30.impl.KeywordsType;
import org.apache.pluto.container.om.portlet30.impl.ListenerType;
import org.apache.pluto.container.om.portlet30.impl.MimeTypeType;
import org.apache.pluto.container.om.portlet30.impl.MultipartType;
import org.apache.pluto.container.om.portlet30.impl.PortletAppType;
import org.apache.pluto.container.om.portlet30.impl.PortletInfoType;
import org.apache.pluto.container.om.portlet30.impl.PortletModeType;
import org.apache.pluto.container.om.portlet30.impl.PortletNameType;
import org.apache.pluto.container.om.portlet30.impl.PortletPreferencesType;
import org.apache.pluto.container.om.portlet30.impl.PortletType;
import org.apache.pluto.container.om.portlet30.impl.PreferenceType;
import org.apache.pluto.container.om.portlet30.impl.PublicRenderParameterType;
import org.apache.pluto.container.om.portlet30.impl.RoleLinkType;
import org.apache.pluto.container.om.portlet30.impl.SecurityRoleRefType;
import org.apache.pluto.container.om.portlet30.impl.ShortTitleType;
import org.apache.pluto.container.om.portlet30.impl.SupportedLocaleType;
import org.apache.pluto.container.om.portlet30.impl.SupportsType;
import org.apache.pluto.container.om.portlet30.impl.TitleType;
import org.apache.pluto.container.om.portlet30.impl.UserAttributeType;
import org.apache.pluto.container.om.portlet30.impl.ValueType;
import org.apache.pluto.container.om.portlet30.impl.WindowStateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Processes configuration for JSR 168 portlet app.
 * 
 * @author Scott Nicklous
 * 
 */
public class JSR362ConfigurationProcessor extends JSR286ConfigurationProcessor {

   /** Logger. */
   private static final Logger                      LOG            = LoggerFactory
                                                                         .getLogger(JSR362ConfigurationProcessor.class);
   private static final boolean                     isTrace        = LOG.isTraceEnabled();

   // For holding the preference validators while the portlet configuration
   // annotations are being processed.
   private Map<PortletPreferencesValidator, String> prefValidators = new HashMap<PortletPreferencesValidator, String>();

   public JSR362ConfigurationProcessor(PortletApplicationDefinition pad) {
      super(pad);
   }

   /*
    * (non-Javadoc)
    * 
    * @see org.apache.pluto.container.om.portlet.impl.jsr362.ConfigurationProcessor #process(javax.xml.bind.JAXBElement)
    */
   @Override
   public void process(JAXBElement<?> rootElement) throws IllegalArgumentException {

      // make sure we were called properly
      assert (rootElement != null);
      assert (rootElement.getValue() instanceof PortletAppType);

      PortletAppType app = (PortletAppType) rootElement.getValue();

      // handle string values

      pad.setId(app.getId());

      if ((app.getVersion() == null) || !app.getVersion().equals("3.0")) {
         String warning = "Bad version. Expected 3.0, was: " + app.getVersion();
         LOG.warn(warning);
         throw new IllegalArgumentException(warning);
      }
      pad.setVersion(app.getVersion());

      if (isTrace) {
         StringBuilder txt = new StringBuilder();
         txt.append("Reading portlet DD. ");
         txt.append("Version: ");
         txt.append(app.getVersion());
         txt.append(", ID: ");
         txt.append(app.getId());
         LOG.trace(txt.toString());
      }

      if (app.getDefaultNamespace() != null && !app.getDefaultNamespace().equals("")) {
         pad.setDefaultNamespace(app.getDefaultNamespace());
      }

      if (app.getResourceBundle() != null && app.getResourceBundle().getValue() != null
            && !app.getResourceBundle().getValue().equals("")) {
         pad.setResourceBundle(app.getResourceBundle().getValue());
      }

      for (EventDefinition ed : handleEventDefs(app.getEventDefinition())) {
         pad.addEventDefinition(ed);
      }

      for (PublicRenderParameter prp : handlePRPs(app.getPublicRenderParameter())) {
         pad.addPublicRenderParameter(prp);
      }

      for (ContainerRuntimeOption cro : handleRTOptions(app.getContainerRuntimeOption())) {
         pad.addContainerRuntimeOption(cro);
      }

      handleCPM(app.getCustomPortletMode());
      handleCWS(app.getCustomWindowState());
      handleUA(app.getUserAttribute());
      handleListeners(app.getListener());
      handleFilters(app.getFilter());
      handlePortlets(app.getPortlet());
      handleFilterMappings(app.getFilterMapping());

   }

   /**
    * DisplayNames
    */
   private List<DisplayName> handleDisplayNames(List<DisplayNameType> dispNames) {
      ArrayList<DisplayName> list = new ArrayList<DisplayName>();
      for (DisplayNameType dispName : dispNames) {

         if (dispName.getValue() == null) {
            String warning = "Bad display name - no display name value; will be ignored. continuing ...";
            LOG.warn(warning);
            continue;
         }

         Locale loc = deriveLocale(dispName.getLang());

         DisplayNameImpl d = new DisplayNameImpl(loc, dispName.getValue());
         list.add(d);
      }
      return list;
   }

   /**
    * Descriptions
    */
   private List<Description> handleDescriptions(List<DescriptionType> descs) {
      ArrayList<Description> list = new ArrayList<Description>();
      for (DescriptionType desc : descs) {

         if (desc.getValue() == null) {
            String warning = "Bad description - no description value; will be ignored. continuing ...";
            LOG.warn(warning);
            continue;
         }

         Locale loc = deriveLocale(desc.getLang());

         DescriptionImpl d = new DescriptionImpl(loc, desc.getValue());
         list.add(d);
      }
      return list;
   }

   /**
    * User attributes
    */
   private void handleUA(List<UserAttributeType> uats) {
      for (UserAttributeType uat : uats) {

         // validate data
         if ((uat.getName() == null) || (uat.getName().getValue() == null)) {
            String warning = "Bad user attribute will be ignored. Name was null. Continuing ...";
            LOG.warn(warning);
            continue;
         }

         // set up the user attribute
         UserAttributeImpl attr = new UserAttributeImpl(uat.getName().getValue());
         for (Description desc : handleDescriptions(uat.getDescription())) {
            attr.addDescription(desc);
         }

         // add it to the model
         pad.addUserAttribute(attr);

      }
   }

   /**
    * Filters
    */
   private void handleFilters(List<FilterType> args) {
      for (FilterType item : args) {

         // Filter name may not be empty
         String fn = item.getFilterName();
         if (fn == null || fn.length() == 0) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Bad Filter definition.");
            txt.append(" Filter name is empty. ");
            txt.append(", Filter class: ").append(item.getFilterClass());
            LOG.warn(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         // Filter class may only be empty if an annotated filter of that name
         // is already present
         String fc = item.getFilterClass();
         if (pad.getFilter(fn) == null) {
            if ((fc == null) || (fc.length() == 0)) {
               StringBuilder txt = new StringBuilder(128);
               txt.append("Bad Filter definition.");
               txt.append(" Filter name: ").append(item.getFilterName());
               txt.append(", Filter class is empty.");
               LOG.warn(txt.toString());
               throw new IllegalArgumentException(txt.toString());
            }
         }

         // set up the filter config
         Filter newitem = new FilterImpl(item.getFilterName());
         newitem.setFilterClass(item.getFilterClass());
         for (InitParam ip : handleInitParam(item.getInitParam())) {
            newitem.addInitParam(ip);
         }
         for (String lc : item.getLifecycle()) {
            newitem.addLifecycle(lc);
         }
         for (Description desc : handleDescriptions(item.getDescription())) {
            newitem.addDescription(desc);
         }
         for (DisplayName dispName : handleDisplayNames(item.getDisplayName())) {
            newitem.addDisplayName(dispName);
         }
         newitem.setOrdinal((item.getOrdinal() == null) ? 0 : item.getOrdinal());

         // add it to the model
         pad.addFilter(newitem);

      }
   }

   /**
    * FilterMappings
    */
   private void handleFilterMappings(List<FilterMappingType> args) {
      for (FilterMappingType item : args) {

         // validate data
         String fname = item.getFilterName();
         if ((fname == null) || (item.getPortletName().size() == 0)) {
            String warning = "Bad FilterMapping definition. Filter name or portlet name is null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the filter mapping
         FilterMapping newitem = new FilterMappingImpl(fname);
         for (PortletNameType pnt : item.getPortletName()) {
            newitem.addPortletName(pnt.getValue());
         }

         // add it to the model
         pad.addFilterMapping(newitem);

      }
   }

   /**
    * Listeners
    */
   private void handleListeners(List<ListenerType> args) {
      for (ListenerType item : args) {

         String name = item.getListenerName();

         // validate data. Empty class allowed if annotated config present
         if ((name == null) || (name.length() == 0) || (pad.getListener(name) == null)) {
            if (item.getListenerClass() == null || item.getListenerClass().length() == 0) {
               String warning = "Bad Listener definition. Class was null.";
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
         }

         if (name == null || name.length() == 0) {
            name = genUniqueName();
         }

         // set up the listener
         Listener newitem = new ListenerImpl(item.getListenerClass());

         for (Description desc : handleDescriptions(item.getDescription())) {
            newitem.addDescription(desc);
         }
         for (DisplayName dispName : handleDisplayNames(item.getDisplayName())) {
            newitem.addDisplayName(dispName);
         }

         newitem.setOrdinal((item.getOrdinal() == null) ? 0 : item.getOrdinal());

         newitem.setListenerName(name);

         // add it to the model
         pad.addListener(newitem);

      }
   }

   /**
    * Custom portlet modes
    */
   private void handleCPM(List<CustomPortletModeType> cpms) {
      for (CustomPortletModeType cpm : cpms) {

         // validate data
         if ((cpm.getPortletMode() == null) || (cpm.getPortletMode().getValue() == null)) {
            String warning = "Custom portlet mode cannot be null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         } else {
            String val = cpm.getPortletMode().getValue();
            if (val.equalsIgnoreCase("view") || val.equalsIgnoreCase("edit") || val.equalsIgnoreCase("help")) {
               String warning = "Bad custom portlet mode: " + val;
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
         }

         // set up the custom portlet mode
         CustomPortletMode pm = new CustomPortletModeImpl(cpm.getPortletMode().getValue());
         for (Description desc : handleDescriptions(cpm.getDescription())) {
            pm.addDescription(desc);
         }
         boolean isPortalManaged = true; // default is true
         if (cpm.getPortalManaged() != null && cpm.getPortalManaged().value() != null) {
            isPortalManaged = cpm.getPortalManaged().value().equalsIgnoreCase("true");
         }
         pm.setPortalManaged(isPortalManaged);

         // add it to the model
         pad.addCustomPortletMode(pm);

      }
   }

   /**
    * Custom window states
    */
   private void handleCWS(List<CustomWindowStateType> cwss) {
      for (CustomWindowStateType cws : cwss) {

         // validate data
         if ((cws.getWindowState() == null) || (cws.getWindowState().getValue() == null)) {
            String warning = "Custom window state cannot be null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         } else {
            String val = cws.getWindowState().getValue();
            if (val.equalsIgnoreCase("normal") || val.equalsIgnoreCase("maximized")
                  || val.equalsIgnoreCase("minimized")) {
               String warning = "Bad custom window state: " + val;
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
         }

         // set up the custom portlet mode
         CustomWindowState ws = new CustomWindowStateImpl(cws.getWindowState().getValue());
         for (Description desc : handleDescriptions(cws.getDescription())) {
            ws.addDescription(desc);
         }

         // add it to the model
         pad.addCustomWindowState(ws);

      }

   }

   private List<Supports> handleSupports(List<SupportsType> sts) {
      ArrayList<Supports> newSupps = new ArrayList<Supports>();
      for (SupportsType st : sts) {

         // validate Mime type & portlet mode
         MimeTypeType mtt = st.getMimeType();
         if (mtt == null || mtt.getValue() == null) {
            String warning = "Null Mime type, ignoring Supports block.";
            LOG.warn(warning);
            continue;
         }
         
         List<PortletModeType> pmlist = st.getPortletMode();
         if (pmlist.size() == 0) {
            String info = "No portlet modes found in Supports block.";
            LOG.trace(info);
         }
         List<WindowStateType> wslist = st.getWindowState();
         if (wslist.size() == 0) {
            String info = "No window states found in Supports block.";
            LOG.trace(info);
         }

         // set up Supports, discarding MIME type parameters & blanks
         String mimetype = mtt.getValue().replaceAll("([^;]*).*", "$1").replaceAll(" ", "");
         Supports sup = new SupportsImpl(mimetype);
         for (PortletModeType item : pmlist) {
            sup.addPortletMode(item.getValue());
         }
         for (WindowStateType item : wslist) {
            sup.addWindowState(item.getValue());
         }

         // add to model
         newSupps.add(sup);

      }
      return newSupps;
   }

   /**
    * Init parameters
    */
   private List<InitParam> handleInitParam(List<InitParamType> parms) {
      ArrayList<InitParam> newParms = new ArrayList<InitParam>();
      for (InitParamType parm : parms) {

         // validate data
         if ((parm.getName() == null) || (parm.getName().getValue() == null)
               || (parm.getName().getValue().length() == 0)) {
            String warning = "Bad init parameter. Parameter name was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the init parameter
         String name = parm.getName().getValue();
         String value = parm.getValue().getValue();
         InitParam newp = new InitParamImpl(name, value);
         for (Description desc : handleDescriptions(parm.getDescription())) {
            newp.addDescription(desc);
         }

         newParms.add(newp);
      }
      return newParms;
   }

   /**
    * Portlet preferences
    */
   private List<Preference> handlePreferences(List<PreferenceType> args) {
      ArrayList<Preference> list = new ArrayList<Preference>();
      for (PreferenceType item : args) {

         // validate data
         if ((item.getName() == null) || (item.getName().getValue() == null)
               || (item.getName().getValue().length() == 0)) {
            String warning = "Bad portlet preference. Preference name was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the preference
         String name = item.getName().getValue();
         List<ValueType> vals = item.getValue();
         ArrayList<String> lines = new ArrayList<String>(16);
         for (ValueType vt : vals) {
            lines.add(vt.getValue());
         }
         boolean isRO = false; // default if not specified
         if (item.getReadOnly() != null && item.getReadOnly().value() != null) {
            isRO = (item.getReadOnly().value().equalsIgnoreCase("true"));
         }

         Preference pref = new PreferenceImpl(name, isRO, lines);
         list.add(pref);
      }
      return list;
   }

   private List<ContainerRuntimeOption> handleRTOptions(List<ContainerRuntimeOptionType> args) {
      ArrayList<ContainerRuntimeOption> list = new ArrayList<ContainerRuntimeOption>();
      for (ContainerRuntimeOptionType arg : args) {

         // validate data
         if ((arg.getName() == null) || (arg.getName().getValue() == null) || arg.getName().getValue().equals("")) {
            String warning = "Bad container runtime option. Name was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the runtime option
         String name = arg.getName().getValue();
         List<ValueType> vals = arg.getValue();
         ArrayList<String> lines = new ArrayList<String>(16);
         for (ValueType vt : vals) {
            lines.add(vt.getValue());
         }

         ContainerRuntimeOption item = new ContainerRuntimeOptionImpl(name, lines);
         list.add(item);

      }
      return list;
   }

   /**
    * Security role references
    */
   private List<SecurityRoleRef> handleSecRoleRef(List<SecurityRoleRefType> args) {
      ArrayList<SecurityRoleRef> list = new ArrayList<SecurityRoleRef>();
      for (SecurityRoleRefType item : args) {

         // validate data
         if ((item.getRoleName() == null) || (item.getRoleName().length() == 0)) {
            String warning = "Bad security role reference. Name was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the role ref
         String name = item.getRoleName();
         SecurityRoleRef srr = new SecurityRoleRefImpl(name);
         RoleLinkType roleLink = item.getRoleLink();
         if (roleLink != null) {
            String roleLinkValue = roleLink.getValue();
            if ((roleLinkValue != null) && (roleLinkValue.length() > 0)) {
               srr.setRoleLink(roleLinkValue);
            }
         }
         for (Description desc : handleDescriptions(item.getDescription())) {
            srr.addDescription(desc);
         }

         list.add(srr);
      }
      return list;
   }

   /**
    * Event definition references - supported publishing events & supported processing events
    */
   private List<EventDefinitionReference> handleEventDefRefs(List<EventDefinitionReferenceType> args) {
      ArrayList<EventDefinitionReference> list = new ArrayList<EventDefinitionReference>();
      for (EventDefinitionReferenceType item : args) {

         // validate data
         if ((item.getName() == null) && (item.getQname() == null)) {
            String warning = "Bad Even definition reference. Name and QName are null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // prepare the qname
         String name = item.getName();
         QName qname = item.getQname();
         if (qname == null) {
            qname = new QName(pad.getDefaultNamespace(), name);
         }

         // set up the event def ref
         EventDefinitionReference newedr = new EventDefinitionReferenceImpl(qname);

         list.add(newedr);
      }
      return list;
   }

   /**
    * Event definitions
    */
   private List<EventDefinition> handleEventDefs(List<EventDefinitionType> args) {
      ArrayList<EventDefinition> list = new ArrayList<EventDefinition>();
      for (EventDefinitionType item : args) {

         // validate data
         if ((item.getName() == null) && (item.getQname() == null)) {
            String warning = "Bad Event definition. Name and QName are null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // prepare the qname
         String name = item.getName();
         QName qname = item.getQname();
         if (qname == null) {
            qname = new QName(pad.getDefaultNamespace(), name);
         }

         // set up the event definition
         EventDefinition newed = new EventDefinitionImpl(qname);
         String clsName = item.getValueType();
         if (clsName != null && clsName.length() > 0) {
            newed.setValueType(clsName);
         }
         for (Description desc : handleDescriptions(item.getDescription())) {
            newed.addDescription(desc);
         }
         for (QName qn : item.getAlias()) {
            newed.addAlias(qn);
         }

         list.add(newed);
      }
      return list;
   }

   private List<PublicRenderParameter> handlePRPs(List<PublicRenderParameterType> args) {
      ArrayList<PublicRenderParameter> list = new ArrayList<PublicRenderParameter>();
      for (PublicRenderParameterType item : args) {

         // validate data
         if ((item.getName() == null) && (item.getQname() == null)) {
            String warning = "Bad public render parameter definition. Name and QName are null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }
         String id = item.getIdentifier();
         if ((id == null) || (id.length() == 0)) {
            String warning = "Bad public render parameter definition. Identifier is null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // prepare the qname
         String name = item.getName();
         QName qname = item.getQname();
         if (qname == null) {
            qname = new QName(pad.getDefaultNamespace(), name);
         }

         // set up the prp definition
         PublicRenderParameter newprp = new PublicRenderParameterImpl(qname, id);
         for (Description desc : handleDescriptions(item.getDescription())) {
            newprp.addDescription(desc);
         }

         list.add(newprp);
      }
      return list;

   }

   /**
    * Handle Portlets
    */
   private void handlePortlets(List<PortletType> portlets) {
      for (PortletType portlet : portlets) {

         // validate portlet name & class
         String warning;
         if (portlet.getPortletName() == null || portlet.getPortletName().getValue() == null
               || portlet.getPortletName().getValue().length() == 0) {
            warning = "Portlet name may not be null";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         String pn = portlet.getPortletName().getValue();
         String clsName = portlet.getPortletClass();

         // set up portlet definition

         PortletDefinition pd = pad.getPortlet(pn);
         if (pd == null) {
            // If no annotated definition, the class name must be present
            if (clsName == null || clsName.length() == 0) {
               warning = "Portlet class may not be null. Portlet name: " + pn;
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
            pd = new PortletDefinitionImpl(pn, pad);
            pd.setPortletClass(portlet.getPortletClass());
         } else {
            if ((clsName != null) && (clsName.length() > 0)) {
               // The portlet class set in the portlet DD overrides the annotated class.
               pd.setPortletClass(portlet.getPortletClass());
            }
         }

         if (portlet.getResourceBundle() != null) {
            pd.setResourceBundle(portlet.getResourceBundle().getValue());
         }

         if (portlet.getExpirationCache() != null) {
            pd.setExpirationCache(portlet.getExpirationCache().getValue());
         }

         if (portlet.getCacheScope() != null) {
            pd.setCacheScope(portlet.getCacheScope().getValue());
         }

         for (DisplayName dispName : handleDisplayNames(portlet.getDisplayName())) {
            pd.addDisplayName(dispName);
         }

         for (Description desc : handleDescriptions(portlet.getDescription())) {
            pd.addDescription(desc);
         }

         for (Supports s : handleSupports(portlet.getSupports())) {
            pd.addSupports(s);
         }

         // handle portlet info

         PortletInfoType pit = portlet.getPortletInfo();
         if (pit != null) {

            PortletInfo info = pd.getPortletInfo();
            if (info == null) {
               info = new PortletInfoImpl();
            }

            for (TitleType item : pit.getTitle()) {
               Locale loc = (item.getLang() == null) ? Locale.ENGLISH : Locale.forLanguageTag(item.getLang());
               info.addTitle(new LocaleTextImpl(loc, item.getValue()));
            }

            for (ShortTitleType item : pit.getShortTitle()) {
               Locale loc = (item.getLang() == null) ? Locale.ENGLISH : Locale.forLanguageTag(item.getLang());
               info.addShortTitle(new LocaleTextImpl(loc, item.getValue()));
            }

            for (KeywordsType item : pit.getKeywords()) {
               Locale loc = (item.getLang() == null) ? Locale.ENGLISH : Locale.forLanguageTag(item.getLang());
               info.addKeywords(new LocaleTextImpl(loc, item.getValue()));
            }

            pd.setPortletInfo(info);
         }

         for (SupportedLocaleType slt : portlet.getSupportedLocale()) {
            pd.addSupportedLocale(slt.getValue());
         }

         for (InitParam ip : handleInitParam(portlet.getInitParam())) {
            pd.addInitParam(ip);
         }

         PortletPreferencesType prefs = portlet.getPortletPreferences();
         if (prefs != null) {

            // merge the new prefs with the old
            Preferences newprefs = pd.getPortletPreferences();

            clsName = prefs.getPreferencesValidator();
            if (clsName != null && clsName.length() > 0) {
               if (clsName.equals("null")) {
                  // marks that an annotated preferences validator should not be
                  // applied to this portlet
                  newprefs.setNullValidator(true);
               } else {
                  newprefs.setPreferencesValidator(clsName);
               }
            }

            for (Preference p : handlePreferences(prefs.getPreference())) {
               newprefs.addPreference(p);
            }

            pd.setPortletPreferences(newprefs);
         }

         for (SecurityRoleRef srr : handleSecRoleRef(portlet.getSecurityRoleRef())) {
            pd.addSecurityRoleRef(srr);
         }

         for (ContainerRuntimeOption cro : handleRTOptions(portlet.getContainerRuntimeOption())) {
            pd.addContainerRuntimeOption(cro);
         }

         for (String prp : portlet.getSupportedPublicRenderParameter()) {
            if ((prp == null) || (prp.length() == 0)) {
               warning = "Supported public render parameter definition may not be null.";
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
            pd.addSupportedPublicRenderParameter(prp);
         }

         // Supported processing events
         for (EventDefinitionReference edr : handleEventDefRefs(portlet.getSupportedProcessingEvent())) {
            pd.addSupportedProcessingEvent(edr);
         }

         // Supported publishing events
         for (EventDefinitionReference edr : handleEventDefRefs(portlet.getSupportedPublishingEvent())) {
            pd.addSupportedPublishingEvent(edr);
         }

         // dependencies
         for (DependencyType dt : portlet.getDependency()) {
            if (dt.getName() == null || dt.getName().length() == 0) {
               String warn = "Dependency name is empty, ignoring Dependency block.";
               LOG.warn(warn);
               continue;
            }
            if (dt.getVersion() == null || dt.getVersion().length() == 0) {
               String warn = "Dependency version is empty.";
               LOG.info(warn);
            }
            Dependency dep = new DependencyImpl(dt.getName(), dt.getScope(), dt.getVersion());
            pd.addDependency(dep);
         }

         // Async supported
         if (portlet.isAsyncSupported() != null) {
            pd.setAsyncSupported(portlet.isAsyncSupported());
         }

         // multipart config
         MultipartType muty = portlet.getMultipartConfig();
         if (muty != null) {
            pd.setMultipartSupported(true);
            pd.setLocation(muty.getLocation());
            pd.setFileSizeThreshold(muty.getFileSizeThreshold());
            pd.setMaxFileSize(muty.getMaxFileSize());
            pd.setMaxRequestSize(muty.getMaxRequestSize());
         }

         pad.addPortlet(pd);

      }
   }

   /**
    * validate the v3.0 configuration
    */
   public void validate() {

      // If the filter mapping portlet names element contains a single '*', expand
      // the portlet names into a list of all portlet names in the application.
      for (FilterMapping fm : pad.getFilterMappings()) {
         if (fm.getPortletNames().size() == 1) {
            if (fm.getPortletNames().get(0).equals("*")) {
               fm.removePortletName("*");
               for (PortletDefinition pd : pad.getPortlets()) {
                  fm.addPortletName(pd.getPortletName());
               }
               pad.addFilterMapping(fm);
            }
         }
      }

      // Apply the stored annotated preference validators to the
      // portlet definitions

      for (PortletPreferencesValidator vali : prefValidators.keySet()) {
         String[] pns = vali.portletNames();
         String clsName = prefValidators.get(vali);

         if ((pns.length > 0) && pns[0].equals("*")) {

            for (PortletDefinition pd : pad.getPortlets()) {

               // If a preferences validator is already configured, it had to have
               // come from the portlet DD, so don't overwrite.

               Preferences prefs = pd.getPortletPreferences();
               String oldVali = prefs.getPreferencesValidator();
               if (oldVali == null || oldVali.length() == 0) {
                  // If the validator was explicitly set to null in the
                  // deployment descriptor, don't apply annotated validator
                  if (!prefs.isNullValidator()) {
                     prefs.setPreferencesValidator(clsName);
                     pd.setPortletPreferences(prefs);
                     pad.addPortlet(pd);
                  }
               }

            }

         } else {
            for (String pn : pns) {
               PortletDefinition pd = pad.getPortlet(pn);

               if (pd == null) {
                  StringBuilder txt = new StringBuilder(128);
                  txt.append("Portlet name defined in preferences validator annotation could not be found in configuration.");
                  txt.append(" Portlet name: ").append(pn);
                  txt.append(" Preferences validator class: ").append(clsName);
                  LOG.warn(txt.toString());
                  continue;
               }

               // If a preferences validator is already configured, it had to have
               // come from the portlet DD, so don't overwrite.

               Preferences prefs = pd.getPortletPreferences();
               String oldVali = prefs.getPreferencesValidator();
               if (oldVali == null || oldVali.length() == 0) {
                  // If the validator was explicitly set to null in the
                  // deployment descriptor, don't apply annotated validator
                  if (!prefs.isNullValidator()) {
                     prefs.setPreferencesValidator(clsName);
                     pd.setPortletPreferences(prefs);
                     pad.addPortlet(pd);
                  }
               }

            }
         }
      }

      super.validate(); // reuse the 2.0 validation code
   }

   /**
    * Extracts the data from the portlet application annotation and adds it to the portlet application definition
    * structure.
    * <p>
    * This method is designed to be called before the portlet deployment descriptor is read so that data from the
    * portlet DD can override that provided through annotations.
    * 
    * @param app
    *           The portlet application annotation
    */
   @Override
   public void processPortletAppAnnotation(PortletApplication app) {

      // version
      if (!app.version().equals("3.0")) {
         String warning = "Bad version in annotation. Expected 3.0, was: " + app.version();
         LOG.warn(warning);
         throw new IllegalArgumentException(warning);
      }
      pad.setVersion(app.version());

      // default namespace & resource bundle
      if (app.defaultNamespaceURI().length() > 0) {
         pad.setDefaultNamespace(app.defaultNamespaceURI());
      }
      if (app.resourceBundle().length() > 0) {
         pad.setResourceBundle(app.resourceBundle());
      }

      // runtime options
      for (RuntimeOption ro : app.runtimeOptions()) {
         ContainerRuntimeOption cro = new ContainerRuntimeOptionImpl(ro.name(), Arrays.asList(ro.values()));
         pad.addContainerRuntimeOption(cro);
      }

      // User Attributes
      for (UserAttribute ua : app.userAttributes()) {
         org.apache.pluto.container.om.portlet.UserAttribute attrib = new UserAttributeImpl(ua.name());
         for (LocaleString ls : ua.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            attrib.addDescription(d);
         }
         pad.addUserAttribute(attrib);
      }

      // Public render parameter defs
      for (PublicRenderParameterDefinition prpd : app.publicParams()) {
         QName qn = new QName(prpd.qname().namespaceURI(), prpd.qname().localPart());
         PublicRenderParameter prp = new PublicRenderParameterImpl(qn, prpd.identifier());
         for (LocaleString ls : prpd.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            prp.addDescription(d);
         }
         for (LocaleString ls : prpd.displayName()) {
            DisplayName d = new DisplayNameImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            prp.addDisplayName(d);
         }
         pad.addPublicRenderParameter(prp);
      }

      // Event defs
      for (javax.portlet.annotations.EventDefinition ed : app.events()) {
         String nsuri = ed.qname().namespaceURI();
         if (nsuri.length() == 0) {
            nsuri = pad.getDefaultNamespace();
         }
         QName qn = new QName(nsuri, ed.qname().localPart());
         EventDefinition evt = new EventDefinitionImpl(qn);
         for (LocaleString ls : ed.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            evt.addDescription(d);
         }
         for (LocaleString ls : ed.displayName()) {
            DisplayName d = new DisplayNameImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            evt.addDisplayName(d);
         }
         if (!ed.payloadType().equals(void.class)) {
            evt.setValueType(ed.payloadType().getCanonicalName());
         }
         pad.addEventDefinition(evt);
      }

      // Custom portlet mode
      for (javax.portlet.annotations.CustomPortletMode cpm : app.customPortletModes()) {
         org.apache.pluto.container.om.portlet.CustomPortletMode mode = new CustomPortletModeImpl(cpm.name());
         for (LocaleString ls : cpm.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            mode.addDescription(d);
         }
         mode.setPortalManaged(cpm.portalManaged());
         pad.addCustomPortletMode(mode);
      }

      // Custom window state
      for (javax.portlet.annotations.CustomWindowState cpm : app.customWindowStates()) {
         org.apache.pluto.container.om.portlet.CustomWindowState ws = new CustomWindowStateImpl(cpm.name());
         for (LocaleString ls : cpm.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            ws.addDescription(d);
         }
         pad.addCustomWindowState(ws);
      }

   }

   /**
    * Extracts the data from the portlet annotation and adds it to a portlet filter definition structure. The portlet
    * filter definition will be created if it does not already exist.
    * <p>
    * This method is designed to be called before the portlet deployment descriptor is read so that data from the
    * portlet DD can override that provided through annotations.
    * 
    * @param cls
    *           The annotated class.
    */
   @Override
   public void processPortletFilterAnnotation(Class<?> cls) {

      PortletLifecycleFilter prf = cls.getAnnotation(PortletLifecycleFilter.class);
      if (prf != null) {

         // determine the lifecycles based on the implemented filter interfaces
         List<String> lc = new ArrayList<String>();
         if (ActionFilter.class.isAssignableFrom(cls)) {
            lc.add(PortletRequest.ACTION_PHASE);
         }
         if (RenderFilter.class.isAssignableFrom(cls)) {
            lc.add(PortletRequest.RENDER_PHASE);
         }
         if (ResourceFilter.class.isAssignableFrom(cls)) {
            lc.add(PortletRequest.RESOURCE_PHASE);
         }
         if (EventFilter.class.isAssignableFrom(cls)) {
            lc.add(PortletRequest.EVENT_PHASE);
         }
         if (HeaderFilter.class.isAssignableFrom(cls)) {
            lc.add(PortletRequest.HEADER_PHASE);
         }

         if (lc.size() == 0) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("@PortletLifecycleFilter annotated class must implement ActionFilter, RenderFilter, EventFilter, ResourceFilter, or HeaderFilter. ");
            txt.append(", class: ").append(cls.getCanonicalName());
            LOG.warn(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         // prepare the filter definition
         String clsName = cls.getCanonicalName();
         String fn = prf.filterName();
         if (fn.length() == 0) {
            fn = genUniqueName();
         }
         if (isTrace) {
            LOG.trace("Adding filter named: " + fn);
         }

         if (pad.getFilter(fn) != null) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Duplicate filter annotation. FilterName: ").append(fn);
            txt.append(", class 1: ").append(cls.getCanonicalName());
            txt.append(", class 2: ").append(pad.getFilter(fn).getFilterClass());
            LOG.warn(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         Filter filter = new FilterImpl(fn);
         filter.setFilterClass(clsName);
         for (String l : lc) {
            filter.addLifecycle(l);
         }
         filter.setOrdinal(prf.ordinal());

         for (LocaleString ls : prf.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            filter.addDescription(d);
         }
         for (LocaleString ls : prf.displayName()) {
            DisplayName d = new DisplayNameImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            filter.addDisplayName(d);
         }

         for (InitParameter ip : prf.initParams()) {
            InitParam plutoInitParam = new InitParamImpl(ip.name(), ip.value());
            for (LocaleString ls : ip.description()) {
               Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
               plutoInitParam.addDescription(d);
            }
            filter.addInitParam(plutoInitParam);
         }

         pad.addFilter(filter);

         // now prepare and store the filter mapping

         FilterMapping mapping = new FilterMappingImpl(fn);
         for (String portletName : prf.portletNames()) {
            mapping.addPortletName(portletName);
         }
         pad.addFilterMapping(mapping);

      }
   }

   @Override
   public void processListenerAnnotation(Class<?> cls) {

      PortletListener listener = cls.getAnnotation(PortletListener.class);
      if (listener != null) {

         if (!PortletURLGenerationListener.class.isAssignableFrom(cls)) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("@PortletListener annotated class must implement PortletURLGenerationListener interface. ");
            txt.append(", class: ").append(cls.getCanonicalName());
            LOG.warn(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         String clsName = cls.getCanonicalName();
         String name = listener.listenerName();
         if (name.length() == 0) {
            name = genUniqueName();
         }

         if (pad.getListener(name) != null) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Duplicate listener annotation. Listener name: ").append(name);
            txt.append(", class 1: ").append(clsName);
            txt.append(", class 2: ").append(pad.getListener(name).getListenerClass());
            LOG.warn(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         Listener newItem = new ListenerImpl(clsName);
         newItem.setListenerName(name);
         newItem.setOrdinal(listener.ordinal());

         for (LocaleString ls : listener.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            newItem.addDescription(d);
         }
         for (LocaleString ls : listener.displayName()) {
            DisplayName d = new DisplayNameImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            newItem.addDisplayName(d);
         }

         pad.addListener(newItem);

      }
   }

   /**
    * Processes PortletPreferencesValidator annotated classes. The preferences validators are temorarily stored while
    * the portlet configuration annotations are being processed.
    * 
    * @param cls
    *           The annotated class
    */
   @Override
   public void processValidatorAnnotation(Class<?> cls) {

      PortletPreferencesValidator vali = cls.getAnnotation(PortletPreferencesValidator.class);
      if (vali != null) {

         if (!PreferencesValidator.class.isAssignableFrom(cls)) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("@PortletPreferencesValidator annotated class must implement PreferencesValidator interface. ");
            txt.append(", class: ").append(cls.getCanonicalName());
            LOG.warn(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         String clsName = cls.getCanonicalName();
         prefValidators.put(vali, clsName);
      }
   }

   /**
    * Extracts the data from the portlet annotation and adds it to a portlet definition structure. The portlet
    * definition will be created if it does not already exist.
    * <p>
    * This method is designed to be called before the portlet deployment descriptor is read so that data from the
    * portlet DD can override that provided through annotations.
    * 
    * @param pc
    *           The portlet configuration annotation
    * @param cls
    *           The annotated class
    */
   @Override
   public void processPortletConfigAnnotation(PortletConfiguration pc, Class<?> cls) {

      if (pc != null) {

         // Each portlet config annotation must have a unique portlet name
         String portletName = pc.portletName();
         if (pad.getPortlet(portletName) != null) {
            StringBuilder txt = new StringBuilder(128);
            txt.append("Duplicate portlet configuration annotation. Portlet name: ").append(portletName);
            txt.append(", class: ").append(cls.getCanonicalName());
            LOG.warn(txt.toString());
            throw new IllegalArgumentException(txt.toString());
         }

         PortletDefinition pd = new PortletDefinitionImpl(portletName, pad);

         // If the portlet config annotation is applied to a class that implements the
         // Portlet interface, add the portlet class, otherwise, don't.
         if (Portlet.class.isAssignableFrom(cls)) {
            pd.setPortletClass(cls.getCanonicalName());
         }

         // handle descriptions, display names, and init params

         for (LocaleString ls : pc.description()) {
            Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            pd.addDescription(d);
         }

         for (LocaleString ls : pc.displayName()) {
            DisplayName d = new DisplayNameImpl(Locale.forLanguageTag(ls.locale()), ls.value());
            pd.addDisplayName(d);
         }

         for (InitParameter ip : pc.initParams()) {
            InitParam plutoInitParam = new InitParamImpl(ip.name(), ip.value());
            for (LocaleString ls : ip.description()) {
               Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
               plutoInitParam.addDescription(d);
            }
            pd.addInitParam(plutoInitParam);
         }

         // cache scope, expiration time, resource bundle, async flag

         pd.setCacheScope(pc.cacheScopePublic() ? "public" : "private");
         pd.setExpirationCache(pc.cacheExpirationTime());
         pd.setResourceBundle(pc.resourceBundle());
         pd.setAsyncSupported(pc.asyncSupported());

         // multipart config

         if (pc.multipart().supported() == true) {
            Multipart mp = pc.multipart();
            pd.setMultipartSupported(true);
            pd.setLocation(mp.location());
            pd.setFileSizeThreshold(mp.fileSizeThreshold());
            pd.setMaxFileSize(mp.maxFileSize());
            pd.setMaxRequestSize(mp.maxRequestSize());
         }

         // handle portlet info - title, short title, keywords

         PortletInfo info = new PortletInfoImpl();
         boolean infoAdded = false;

         for (LocaleString item : pc.title()) {
            Locale loc = (item.locale().length() == 0) ? Locale.ENGLISH : Locale.forLanguageTag(item.locale());
            info.addTitle(new LocaleTextImpl(loc, item.value()));
            infoAdded = true;
         }

         for (LocaleString item : pc.shortTitle()) {
            Locale loc = (item.locale().length() == 0) ? Locale.ENGLISH : Locale.forLanguageTag(item.locale());
            info.addShortTitle(new LocaleTextImpl(loc, item.value()));
            infoAdded = true;
         }

         for (LocaleString item : pc.keywords()) {
            Locale loc = (item.locale().length() == 0) ? Locale.ENGLISH : Locale.forLanguageTag(item.locale());
            info.addKeywords(new LocaleTextImpl(loc, item.value()));
            infoAdded = true;
         }

         if (infoAdded) {
            pd.setPortletInfo(info);
         }

         // public parameters, supported locales

         for (String prp : pc.publicParams()) {
            pd.addSupportedPublicRenderParameter(prp);
         }

         for (String loc : pc.supportedLocales()) {
            pd.addSupportedLocale(loc);
         }

         // Container runtime options

         for (RuntimeOption ro : pc.runtimeOptions()) {
            ContainerRuntimeOption cro = new ContainerRuntimeOptionImpl(ro.name(), Arrays.asList(ro.values()));
            pd.addContainerRuntimeOption(cro);
         }

         // Portlet preferences

         Preferences prefs = new PreferencesImpl();
         for (javax.portlet.annotations.Preference pa : pc.prefs()) {
            Preference pref = new PreferenceImpl(pa.name(), pa.isReadOnly(), Arrays.asList(pa.values()));
            prefs.addPreference(pref);
         }
         if (prefs.getPortletPreferences().size() > 0) {
            pd.setPortletPreferences(prefs);
         }

         // Supports

         for (javax.portlet.annotations.Supports sa : pc.supports()) {
            Supports supps = new SupportsImpl(sa.mimeType());
            for (String pm : sa.portletModes()) {
               supps.addPortletMode(pm);
            }
            for (String ws : sa.windowStates()) {
               supps.addWindowState(ws);
            }
            pd.addSupports(supps);
         }

         // Security role refs

         for (javax.portlet.annotations.SecurityRoleRef srra : pc.roleRefs()) {
            SecurityRoleRef ref = new SecurityRoleRefImpl(srra.roleName());
            ref.setRoleLink(srra.roleLink());
            for (LocaleString ls : srra.description()) {
               Description d = new DescriptionImpl(Locale.forLanguageTag(ls.locale()), ls.value());
               ref.addDescription(d);
            }
            pd.addSecurityRoleRef(ref);
         }

         // dependencies

         for (javax.portlet.annotations.Dependency da : pc.dependencies()) {
            Dependency dep = new DependencyImpl(da.name(), da.scope(), da.version());
            pd.addDependency(dep);
         }

         pad.addPortlet(pd);
      }
   }

}
