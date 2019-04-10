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
import javax.portlet.PreferencesValidator;
import javax.xml.bind.JAXBElement;

import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.CustomWindowState;
import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.InitParam;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PortletInfo;
import org.apache.pluto.container.om.portlet.Preference;
import org.apache.pluto.container.om.portlet.Preferences;
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.SecurityRoleRef;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.om.portlet.UserDataConstraint;
import org.apache.pluto.container.om.portlet10.impl.CustomPortletModeType;
import org.apache.pluto.container.om.portlet10.impl.CustomWindowStateType;
import org.apache.pluto.container.om.portlet10.impl.DescriptionType;
import org.apache.pluto.container.om.portlet10.impl.DisplayNameType;
import org.apache.pluto.container.om.portlet10.impl.InitParamType;
import org.apache.pluto.container.om.portlet10.impl.MimeTypeType;
import org.apache.pluto.container.om.portlet10.impl.PortletAppType;
import org.apache.pluto.container.om.portlet10.impl.PortletCollectionType;
import org.apache.pluto.container.om.portlet10.impl.PortletInfoType;
import org.apache.pluto.container.om.portlet10.impl.PortletModeType;
import org.apache.pluto.container.om.portlet10.impl.PortletNameType;
import org.apache.pluto.container.om.portlet10.impl.PortletPreferencesType;
import org.apache.pluto.container.om.portlet10.impl.PortletType;
import org.apache.pluto.container.om.portlet10.impl.PreferenceType;
import org.apache.pluto.container.om.portlet10.impl.RoleLinkType;
import org.apache.pluto.container.om.portlet10.impl.SecurityConstraintType;
import org.apache.pluto.container.om.portlet10.impl.SecurityRoleRefType;
import org.apache.pluto.container.om.portlet10.impl.SupportedLocaleType;
import org.apache.pluto.container.om.portlet10.impl.SupportsType;
import org.apache.pluto.container.om.portlet10.impl.UserAttributeType;
import org.apache.pluto.container.om.portlet10.impl.UserDataConstraintType;
import org.apache.pluto.container.om.portlet10.impl.ValueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Processes configuration for JSR 168 portlet app.
 * 
 * @author Scott Nicklous
 * 
 */
public class JSR168ConfigurationProcessor extends ConfigurationProcessor {

   /** Logger. */
   private static final Logger          LOG     = LoggerFactory
                                                      .getLogger(JSR168ConfigurationProcessor.class);
   // private static final boolean         isDebug = LOG.isDebugEnabled();
   private static final boolean         isTrace = LOG.isTraceEnabled();
   
   public JSR168ConfigurationProcessor(PortletApplicationDefinition pad) {
      super(pad);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.impl.jsr168.ConfigurationProcessor#process(javax.xml.bind.JAXBElement)
    */
   @Override
   public void process(JAXBElement<?> rootElement)
         throws IllegalArgumentException {

      // make sure we were called properly
      assert (rootElement != null);
      assert (rootElement.getValue() instanceof PortletAppType);

      PortletAppType app = (PortletAppType) rootElement.getValue();

      // handle string values

      pad.setId(app.getId());

      if ((app.getVersion() == null) || !app.getVersion().equals("1.0")) {
         String warning = "Bad version. Expected 1.0, was: " + app.getVersion();
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

      handleCPM(app.getCustomPortletMode());
      handleCWS(app.getCustomWindowState());
      handleSC(app.getSecurityConstraint());
      handleUA(app.getUserAttribute());
      handlePortlets(app.getPortlet());

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
         List<PortletModeType> list = st.getPortletMode();
         if (list.size() == 0) {
            String warning = "No portlet modes found, ignoring Supports block.";
            LOG.warn(warning);
            continue;
         }

         // set up Supports, discarding MIME type parameters & blanks
         String mimetype = mtt.getValue().replaceAll("([^;]*).*", "$1").replaceAll(" ", "");
         Supports sup = new SupportsImpl(mimetype);
         for (PortletModeType item : list) {
            sup.addPortletMode(item.getValue());
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
         warning = "Bad portlet class: " + clsName;
         if (!isValidIdentifier(clsName)) {
            LOG.warn(warning);
            throw new IllegalArgumentException(warning);
         }
         
         // Make sure the class can be loaded
         Class<?> valClass = null;
         try {
            ClassLoader cl = this.getClass().getClassLoader();
            valClass = cl.loadClass(clsName);
            if (!Portlet.class.isAssignableFrom(valClass)) {
               throw new Exception("specified class is not a Portlet.");
            }
         } catch (Exception e) {
            LOG.warn(warning);
            throw new IllegalArgumentException(warning, e);
         }

         // set up portlet definition

         PortletDefinition pd = new PortletDefinitionImpl(pn, pad);
         pd.setPortletClass(portlet.getPortletClass());

         if (portlet.getResourceBundle() != null) {
            pd.setResourceBundle(portlet.getResourceBundle().getValue());
         }

         if (portlet.getExpirationCache() != null) {
            pd.setExpirationCache(portlet.getExpirationCache().getValue());
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
            warning = "Bad portlet preferences validator class: " + clsName;
            if (!isValidIdentifier(clsName)) {
               LOG.warn(warning);
               throw new IllegalArgumentException(warning);
            }
            
            // Make sure the class can be loaded
            valClass = null;
            try {
               ClassLoader cl = this.getClass().getClassLoader();
               valClass = cl.loadClass(clsName);
               if (!PreferencesValidator.class.isAssignableFrom(valClass)) {
                  throw new Exception("specified class is not a PreferencesValidator.");
               }
            } catch (Exception e) {
               LOG.warn(warning);
               throw new IllegalArgumentException(warning, e);
            }

            
            newprefs.setPreferencesValidator(clsName);
            for (Preference p : handlePreferences(prefs.getPreference())) {
               newprefs.addPreference(p);
            }
            pd.setPortletPreferences(newprefs);
         }
         
         for (SecurityRoleRef srr : handleSecRoleRef(portlet.getSecurityRoleRef())) {
            pd.addSecurityRoleRef(srr);
         }

         pad.addPortlet(pd);

      }
   }

   @Override
   public void validate() throws IllegalArgumentException {
      // For version 1.0, do nothing.
   }

}
