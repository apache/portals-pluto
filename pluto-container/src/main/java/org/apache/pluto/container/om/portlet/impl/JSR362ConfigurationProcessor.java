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

import javax.portlet.Portlet;
import javax.portlet.PortletURLGenerationListener;
import javax.portlet.PreferencesValidator;
import javax.portlet.filter.PortletFilter;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.CustomWindowState;
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
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.om.portlet.UserDataConstraint;
import org.apache.pluto.container.om.portlet30.impl.ContainerRuntimeOptionType;
import org.apache.pluto.container.om.portlet30.impl.CustomPortletModeType;
import org.apache.pluto.container.om.portlet30.impl.CustomWindowStateType;
import org.apache.pluto.container.om.portlet30.impl.DescriptionType;
import org.apache.pluto.container.om.portlet30.impl.DisplayNameType;
import org.apache.pluto.container.om.portlet30.impl.EventDefinitionReferenceType;
import org.apache.pluto.container.om.portlet30.impl.EventDefinitionType;
import org.apache.pluto.container.om.portlet30.impl.FilterMappingType;
import org.apache.pluto.container.om.portlet30.impl.FilterType;
import org.apache.pluto.container.om.portlet30.impl.InitParamType;
import org.apache.pluto.container.om.portlet30.impl.ListenerType;
import org.apache.pluto.container.om.portlet30.impl.MimeTypeType;
import org.apache.pluto.container.om.portlet30.impl.PortletAppType;
import org.apache.pluto.container.om.portlet30.impl.PortletCollectionType;
import org.apache.pluto.container.om.portlet30.impl.PortletInfoType;
import org.apache.pluto.container.om.portlet30.impl.PortletModeType;
import org.apache.pluto.container.om.portlet30.impl.PortletNameType;
import org.apache.pluto.container.om.portlet30.impl.PortletPreferencesType;
import org.apache.pluto.container.om.portlet30.impl.PortletType;
import org.apache.pluto.container.om.portlet30.impl.PreferenceType;
import org.apache.pluto.container.om.portlet30.impl.PublicRenderParameterType;
import org.apache.pluto.container.om.portlet30.impl.SecurityConstraintType;
import org.apache.pluto.container.om.portlet30.impl.SecurityRoleRefType;
import org.apache.pluto.container.om.portlet30.impl.SupportedLocaleType;
import org.apache.pluto.container.om.portlet30.impl.SupportsType;
import org.apache.pluto.container.om.portlet30.impl.UserAttributeType;
import org.apache.pluto.container.om.portlet30.impl.UserDataConstraintType;
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
public class JSR362ConfigurationProcessor extends ConfigurationProcessor {

   /** Logger. */
   private static final Logger          LOG     = LoggerFactory
                                                      .getLogger(JSR362ConfigurationProcessor.class);
   // private static final boolean isDebug = LOG.isDebugEnabled();
   private static final boolean         isTrace = LOG.isTraceEnabled();

   private PortletApplicationDefinition pad;

   /*
    * (non-Javadoc)
    * 
    * @see
    * org.apache.pluto.container.om.portlet.impl.jsr168.ConfigurationProcessor
    * #process(javax.xml.bind.JAXBElement)
    */
   @Override
   public PortletApplicationDefinition process(JAXBElement<?> rootElement)
         throws IllegalArgumentException {
      pad = new PortletApplicationDefinitionImpl();

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

      if (app.getDefaultNamespace() != null
            && !app.getDefaultNamespace().equals("")) {
         pad.setDefaultNamespace(app.getDefaultNamespace());
      } else {
         pad.setDefaultNamespace(XMLConstants.NULL_NS_URI);
      }

      if (app.getResourceBundle() != null
            && app.getResourceBundle().getValue() != null
            && !app.getResourceBundle().getValue().equals("")) {
         pad.setResourceBundle(app.getResourceBundle().getValue());
      }

      for (EventDefinition ed : handleEventDefs(app.getEventDefinition())) {
         pad.addEventDefinition(ed);
      }

      for (PublicRenderParameter prp : handlePRPs(app
            .getPublicRenderParameter())) {
         pad.addPublicRenderParameter(prp);
      }
      
      for (ContainerRuntimeOption cro : handleRTOptions(app.getContainerRuntimeOption())) {
         pad.addContainerRuntimeOption(cro);
      }

      handleCPM(app.getCustomPortletMode());
      handleCWS(app.getCustomWindowState());
      handleSC(app.getSecurityConstraint());
      handleUA(app.getUserAttribute());
      handleListeners(app.getListener());
      handleFilters(app.getFilter());
      handlePortlets(app.getPortlet());
      handleFilterMappings(app.getFilterMapping());

      return pad;
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
         UserAttributeImpl attr = new UserAttributeImpl(uat.getName()
               .getValue());
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

         // validate data
         if ((item.getFilterName() == null)
               || (item.getFilterClass() == null)) {
            String warning = "Bad Filter definition. name or class was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }
         String clsName = item.getFilterClass();
         if (clsName != null && !clsName.equals("")) {
            checkValidClass(clsName, PortletFilter.class,
                  "Bad filter definition. Filter class is invalid: ");
         }

         // set up the custom portlet mode
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
         if (pad.getFilter(fname) == null) {
            String warning = "Bad FilterMapping definition. Filter definition not found: " + fname;
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }
         
         // set up the filter mapping
         FilterMapping newitem = new FilterMappingImpl(fname);
         for (PortletNameType pnt : item.getPortletName()) {
            String pname = pnt.getValue();
            if (pad.getPortlet(pname) == null) {
               String warning = "Bad FilterMapping definition. Portlet definition not found: " + pname;
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
            newitem.addPortletName(pname);
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

         // validate data
         if (item.getListenerClass() == null) {
            String warning = "Bad Listener definition. Class was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }
         String clsName = item.getListenerClass();
         if (clsName != null && !clsName.equals("")) {
            checkValidClass(clsName, PortletURLGenerationListener.class,
                  "Bad listener definition. Listener class is invalid: ");
         }

         // set up the custom portlet mode
         Listener newitem = new ListenerImpl(item.getListenerClass());
         for (Description desc : handleDescriptions(item.getDescription())) {
            newitem.addDescription(desc);
         }
         for (DisplayName dispName : handleDisplayNames(item.getDisplayName())) {
            newitem.addDisplayName(dispName);
         }
         
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
         if ((cpm.getPortletMode() == null)
               || (cpm.getPortletMode().getValue() == null)) {
            String warning = "Bad custom portlet mode. Mode was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         } else {
            String val = cpm.getPortletMode().getValue();
            if (val.equalsIgnoreCase("view") || val.equalsIgnoreCase("edit")
                  || val.equalsIgnoreCase("help")) {
               String warning = "Bad custom portlet mode. Mode was: " + val;
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
         }

         // set up the custom portlet mode
         CustomPortletMode pm = new CustomPortletModeImpl(cpm.getPortletMode()
               .getValue());
         for (Description desc : handleDescriptions(cpm.getDescription())) {
            pm.addDescription(desc);
         }
         boolean isPortalManaged = true; // default is true
         if (cpm.getPortalManaged() != null
               && cpm.getPortalManaged().value() != null) {
            isPortalManaged = cpm.getPortalManaged().value()
                  .equalsIgnoreCase("true");
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
         if ((cws.getWindowState() == null)
               || (cws.getWindowState().getValue() == null)) {
            String warning = "Bad custom portlet mode. Mode was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         } else {
            String val = cws.getWindowState().getValue();
            if (val.equalsIgnoreCase("view") || val.equalsIgnoreCase("edit")
                  || val.equalsIgnoreCase("help")) {
               String warning = "Bad custom portlet mode. Mode was: " + val;
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
         }

         // set up the custom portlet mode
         CustomWindowState ws = new CustomWindowStateImpl(cws.getWindowState()
               .getValue());
         for (Description desc : handleDescriptions(cws.getDescription())) {
            ws.addDescription(desc);
         }

         // add it to the model
         pad.addCustomWindowState(ws);

      }

   }

   /**
    * Security constraints
    */
   private void handleSC(List<SecurityConstraintType> scs) {
      for (SecurityConstraintType sc : scs) {

         // validate data
         PortletCollectionType pct = sc.getPortletCollection();
         if ((pct == null) || (pct.getPortletName() == null)
               || (pct.getPortletName().size() == 0)) {
            String warning = "Portlet collection is empty.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         } else {
            for (PortletNameType pnt : pct.getPortletName()) {
               if (!isValidIdentifier(pnt.getValue())) {
                  String warning = "Bad portlet name: " + pnt.getValue();
                  LOG.warn(warning);
                  throw new IllegalArgumentException(warning);
               }
            }
         }

         UserDataConstraintType udc = sc.getUserDataConstraint();
         if ((udc == null) || (udc.getTransportGuarantee() == null)
               || (udc.getTransportGuarantee().value() == null)) {
            String warning = "User data constraint contains null value.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the user data constraint
         UserDataConstraint newudc = new UserDataConstraintImpl(udc
               .getTransportGuarantee().value());
         for (Description desc : handleDescriptions(udc.getDescription())) {
            newudc.addDescription(desc);
         }

         // set up the security constraint
         SecurityConstraint newsc = new SecurityConstraintImpl(newudc);
         for (DisplayName dispName : handleDisplayNames(sc.getDisplayName())) {
            newsc.addDisplayName(dispName);
         }
         for (PortletNameType portletName : pct.getPortletName()) {
            newsc.addPortletName(portletName.getValue());
         }

         // add it to the model
         pad.addSecurityConstraint(newsc);

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
            LOG.info(info);
         }
         List<WindowStateType> wslist = st.getWindowState();
         if (wslist.size() == 0) {
            String info = "No window states found in Supports block.";
            LOG.info(info);
         }

         // set up Supports
         Supports sup = new SupportsImpl(mtt.getValue());
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
         if ((parm.getName() == null) || (parm.getName().getValue() == null)) {
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
         if ((item.getName() == null) || (item.getName().getValue() == null)) {
            String warning = "Bad portlet preference. Ppreference name was null.";
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
         boolean isRO = (item.getReadOnly().value().equalsIgnoreCase("true"));

         Preference pref = new PreferenceImpl(name, isRO, lines);
         list.add(pref);
      }
      return list;
   }

   private List<ContainerRuntimeOption> handleRTOptions(
         List<ContainerRuntimeOptionType> args) {
      ArrayList<ContainerRuntimeOption> list = new ArrayList<ContainerRuntimeOption>();
      for (ContainerRuntimeOptionType arg : args) {

         // validate data
         if ((arg.getName() == null) || (arg.getName().getValue() == null)
               || arg.getName().getValue().equals("")) {
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

         ContainerRuntimeOption item = new ContainerRuntimeOptionImpl(name,
               lines);
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
         if ((item.getRoleName() == null) || (item.getRoleLink() == null)
               || (item.getRoleLink().getValue() == null)) {
            String warning = "Bad security role reference. Name or link was null.";
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the role ref
         String name = item.getRoleName();
         String link = item.getRoleLink().getValue();
         SecurityRoleRef srr = new SecurityRoleRefImpl(name);
         srr.setRoleLink(link);
         for (Description desc : handleDescriptions(item.getDescription())) {
            srr.addDescription(desc);
         }

         list.add(srr);
      }
      return list;
   }

   /**
    * Event definition references - supported publishing events & supported
    * processing events
    */
   private List<EventDefinitionReference> handleEventDefRefs(
         List<EventDefinitionReferenceType> args) {
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

         if (pad.getEventDefinition(qname) == null) {
            String warning = "Bad Event definition reference. No event definition found for qname: "
                  + qname;
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }

         // set up the event def ref
         EventDefinitionReference newedr = new EventDefinitionReferenceImpl(
               qname);

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
         String clsName = item.getValueType();
         if (clsName != null && !clsName.equals("")) {
            checkValidClass(clsName, null,
                  "Bad Event definition. Payload type is invalid: ");
         }

         // prepare the qname
         String name = item.getName();
         QName qname = item.getQname();
         if (qname == null) {
            qname = new QName(pad.getDefaultNamespace(), name);
         }

         // set up the event definition
         EventDefinition newed = new EventDefinitionImpl(qname);
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

   private List<PublicRenderParameter> handlePRPs(
         List<PublicRenderParameterType> args) {
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
         for (QName qn : item.getAlias()) {
            newprp.addAlias(qn);
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
         String pn = portlet.getPortletName().getValue();
         if (!isValidIdentifier(pn)) {
            warning = "Portlet name not valid Java identifier: " + pn;
            LOG.warn(warning);
            // throw new IllegalArgumentException(warning);
         }

         String clsName = portlet.getPortletClass();
         checkValidClass(clsName, Portlet.class, "Bad portlet class: ");

         // set up portlet definition

         PortletDefinition pd = new PortletDefinitionImpl(pn, pad);
         pd.setPortletClass(portlet.getPortletClass());

         if (portlet.getResourceBundle() != null) {
            pd.setResourceBundle(portlet.getResourceBundle().getValue());
         }

         if (portlet.getExpirationCache() != null) {
            pd.setExpirationCache(portlet.getExpirationCache().getValue());
         }

         if (portlet.getCacheScope() != null) {
            pd.setCacheScope(portlet.getCacheScope().getValue());
         }

         for (DisplayName dispName : handleDisplayNames(portlet
               .getDisplayName())) {
            pd.addDisplayName(dispName);
         }

         for (Description desc : handleDescriptions(portlet.getDescription())) {
            pd.addDescription(desc);
         }

         for (Supports s : handleSupports(portlet.getSupports())) {
            pd.addSupports(s);
         }

         PortletInfoType pit = portlet.getPortletInfo();
         if (pit != null) {
            if (pit.getTitle().getValue() == null) {
               warning = "Portlet info section does not contain title. Ingoring ...";
               LOG.warn(warning);
            } else {
               String title, st = null, kw = null;
               title = pit.getTitle().getValue();
               if (pit.getShortTitle() != null) {
                  st = pit.getShortTitle().getValue();
               }
               if (pit.getKeywords() != null) {
                  kw = pit.getKeywords().getValue();
               }
               PortletInfo info = new PortletInfoImpl(title, kw, st);
               pd.setPortletInfo(info);
            }
         }

         for (SupportedLocaleType slt : portlet.getSupportedLocale()) {
            pd.addSupportedLocale(slt.getValue());
         }

         for (InitParam ip : handleInitParam(portlet.getInitParam())) {
            pd.addInitParam(ip);
         }

         PortletPreferencesType prefs = portlet.getPortletPreferences();
         if (prefs != null) {
            Preferences newprefs = new PreferencesImpl();

            clsName = prefs.getPreferencesValidator();
            checkValidClass(clsName, PreferencesValidator.class,
                  "Bad portlet preferences validator class: ");

            newprefs.setPreferencesValidator(clsName);
            for (Preference p : handlePreferences(prefs.getPreference())) {
               newprefs.addPreference(p);
            }
            pd.setPortletPreferences(newprefs);
         }

         for (SecurityRoleRef srr : handleSecRoleRef(portlet
               .getSecurityRoleRef())) {
            pd.addSecurityRoleRef(srr);
         }

         for (ContainerRuntimeOption cro : handleRTOptions(portlet
               .getContainerRuntimeOption())) {
            pd.addContainerRuntimeOption(cro);
         }

         for (String prp : portlet.getSupportedPublicRenderParameter()) {
            boolean ok = false;
            for (PublicRenderParameter prpdef : pad.getPublicRenderParameters()) {
               if (prpdef.getIdentifier().equals(prp)) {
                  ok = true;
               }
            }
            if (!ok) {
               warning = "Public render parameter definition not found for: " + prp;
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
            pd.addSupportedPublicRenderParameter(prp);
         }

         // Supported processing events
         for (EventDefinitionReference edr : handleEventDefRefs(portlet
               .getSupportedProcessingEvent())) {
            pd.addSupportedProcessingEvent(edr);
         }

         // Supported publishing events
         for (EventDefinitionReference edr : handleEventDefRefs(portlet
               .getSupportedPublishingEvent())) {
            pd.addSupportedPublishingEvent(edr);
         }

         pad.addPortlet(pd);

      }
   }

}
