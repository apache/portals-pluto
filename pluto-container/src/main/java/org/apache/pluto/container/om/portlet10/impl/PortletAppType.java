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
package org.apache.pluto.container.om.portlet10.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
import org.apache.pluto.container.om.portlet.UserAttribute;

/**
 * <p>Java class for portlet-appType complex type.</p> <p>The following schema fragment specifies the expected
 * content contained within this class.</p>
 * 
 * <pre>
 * &lt;complexType name=&quot;portlet-appType&quot;&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *       &lt;sequence&gt;
 *         &lt;element name=&quot;portlet&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}portletType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;custom-portlet-mode&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}custom-portlet-modeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;custom-window-state&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}custom-window-stateType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;user-attribute&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}user-attributeType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *         &lt;element name=&quot;security-constraint&quot; type=&quot;{http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd}security-constraintType&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name=&quot;version&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *       &lt;attribute name=&quot;id&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}string&quot; /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * @version $Id$
 */
@XmlRootElement(name = "portlet-app")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "portlet-appType", propOrder = { "portlet", "customPortletMode", "customWindowState", "userAttribute",
                                                "securityConstraint" })
public class PortletAppType
{
    @XmlElement(name = "portlet")
    List<PortletType> portlet;
    @XmlElement(name = "custom-portlet-mode")
    List<CustomPortletModeType> customPortletMode;
    @XmlElement(name = "custom-window-state")
    List<CustomWindowStateType> customWindowState;
    @XmlElement(name = "user-attribute")
    List<UserAttributeType> userAttribute;
    @XmlElement(name = "security-constraint")
    List<SecurityConstraintType> securityConstraint;
    @XmlAttribute(required = true)
    String version = PortletApplicationDefinition.JSR_168_VERSION;
    
    public PortletAppType()
    {
    }
    
    public PortletAppType(PortletApplicationDefinition app)
    {
        // downgrade
        for (PortletDefinition pd : app.getPortlets())
        {
            if (portlet == null)
            {
                portlet = new ArrayList<PortletType>();
            }
            PortletType pt = new PortletType();
            downgradePortlet(pd, pt);
            portlet.add(pt);            
        }
        for (CustomPortletMode cpm : app.getCustomPortletModes())
        {
            if (customPortletMode == null)
            {
                customPortletMode = new ArrayList<CustomPortletModeType>();
            }
            CustomPortletModeType cpmt = new CustomPortletModeType();
            cpmt.portletMode = cpm.getPortletMode();
            for (Description d : cpm.getDescriptions())
            {
                if (cpmt.description == null)
                {
                    cpmt.description = new ArrayList<DescriptionType>();
                }
                DescriptionType dt = new DescriptionType();
                dt.lang = d.getLang();
                dt.value = d.getDescription();
                cpmt.description.add(dt);
            }
        }
        for (CustomWindowState cws : app.getCustomWindowStates())
        {
            if (customWindowState == null)
            {
                customWindowState = new ArrayList<CustomWindowStateType>();
            }
            CustomWindowStateType cwst = new CustomWindowStateType();
            cwst.windowState = cws.getWindowState();
            for (Description d : cws.getDescriptions())
            {
                if (cwst.description == null)
                {
                    cwst.description = new ArrayList<DescriptionType>();
                }
                DescriptionType dt = new DescriptionType();
                dt.lang = d.getLang();
                dt.value = d.getDescription();
                cwst.description.add(dt);
            }
        }
    }
    
    public PortletApplicationDefinition upgrade()
    {
        PortletApplicationDefinition app = new org.apache.pluto.container.om.portlet.impl.PortletAppType();
        app.setVersion(version);
        if (portlet != null)
        {
            for (PortletType src : portlet)
            {
                PortletDefinition target = app.addPortlet(src.portletName);
                upgradePortlet(src, target);
            }
        }
        if (customPortletMode != null)
        {
            for (CustomPortletModeType src : customPortletMode)
            {
                CustomPortletMode target = app.addCustomPortletMode(src.portletMode);
                if (src.description != null)
                {
                    for (DescriptionType d : src.description)
                    {
                        Description desc = target.addDescription(d.lang);
                        desc.setDescription(d.value);
                    }
                }
            }
        }
        if (customWindowState != null)
        {
            for (CustomWindowStateType src : customWindowState)
            {
                CustomWindowState target = app.addCustomWindowState(src.windowState);
                if (src.description != null)
                {
                    for (DescriptionType d : src.description)
                    {
                        Description desc = target.addDescription(d.lang);
                        desc.setDescription(d.value);
                    }
                }
            }
        }
        if (userAttribute != null)
        {
            for (UserAttributeType src : userAttribute)
            {
                UserAttribute target = app.addUserAttribute(src.name);
                if (src.description != null)
                {
                    for (DescriptionType d : src.description)
                    {
                        Description desc = target.addDescription(d.lang);
                        desc.setDescription(d.value);
                    }
                }
            }
        }
        if (securityConstraint != null)
        {
            for (SecurityConstraintType src : securityConstraint)
            {
                SecurityConstraint target = app.addSecurityConstraint(src.userDataConstraint.transportGuarantee);
                if (src.displayName != null)
                {
                    for (DisplayNameType d : src.displayName)
                    {
                        DisplayName dname = target.addDisplayName(d.lang);
                        dname.setDisplayName(d.value);
                    }
                }
                if (src.portletCollection != null && src.portletCollection.portletName != null)
                {
                    for (String pname : src.portletCollection.portletName)
                    {
                        target.addPortletName(pname);
                    }
                }
            }
        }
        return app;
    }
    
    private void downgradePortlet(PortletDefinition src, PortletType target)
    {
        for (Description d : src.getDescriptions())
        {
            if (target.description == null)
            {
                target.description = new ArrayList<DescriptionType>();
            }
            DescriptionType dt = new DescriptionType();
            dt.lang = d.getLang();
            dt.value = d.getDescription();
            target.description.add(dt);
        }
        for (DisplayName d : src.getDisplayNames())
        {
            if (target.displayName == null)
            {
                target.displayName = new ArrayList<DisplayNameType>();
            }
            DisplayNameType dnt = new DisplayNameType();
            dnt.lang = d.getLang();
            dnt.value = d.getDisplayName();
            target.displayName.add(dnt);
        }
        target.portletClass = src.getPortletClass();
        if (src.getExpirationCache() != 0)
        {
            target.expirationCache = new Integer(src.getExpirationCache());
        }
        for (InitParam p : src.getInitParams())
        {
            if (target.initParam == null)
            {
                target.initParam = new ArrayList<InitParamType>();
            }
            InitParamType pt = new InitParamType();
            pt.name = p.getParamName();
            pt.value = p.getParamValue();
            for (Description d : p.getDescriptions())
            {
                if (pt.description == null)
                {
                    pt.description = new ArrayList<DescriptionType>();
                }
                DescriptionType dt = new DescriptionType();
                dt.lang = d.getLang();
                dt.value = d.getDescription();
                pt.description.add(dt);
            }
            target.initParam.add(pt);
        }
        for (Supports s : src.getSupports())
        {
            if (target.supports == null)
            {
                target.supports = new ArrayList<SupportsType>();
            }
            SupportsType st = new SupportsType();
            st.mimeType = s.getMimeType();
            for (String name : s.getPortletModes())
            {
                if (st.portletMode == null)
                {
                    st.portletMode = new ArrayList<String>();
                }
                st.portletMode.add(name);
            }
            target.supports.add(st);
        }
        for (String lang : src.getSupportedLocales())
        {
            if (target.supportedLocale == null)
            {
                target.supportedLocale = new ArrayList<String>();
            }
            target.supportedLocale.add(lang);
        }
        target.resourceBundle = src.getResourceBundle();
        PortletInfoType pit = new PortletInfoType();
        pit.title = src.getPortletInfo().getTitle();
        pit.shortTitle = src.getPortletInfo().getShortTitle();
        pit.keywords = src.getPortletInfo().getKeywords();
        if (pit.title != null || pit.shortTitle != null || pit.keywords != null)
        {
            target.portletInfo = pit;
        }
        PortletPreferencesType ppt = new PortletPreferencesType();
        ppt.preferencesValidator = src.getPortletPreferences().getPreferencesValidator();
        for (Preference p : src.getPortletPreferences().getPortletPreferences())
        {
            if (ppt.preference == null)
            {
                ppt.preference = new ArrayList<PreferenceType>();                
            }
            PreferenceType pt = new PreferenceType();
            pt.name = p.getName();
            pt.readOnly = p.isReadOnly() ? Boolean.TRUE : null;
            for (String value : p.getValues())
            {
                if (pt.value == null)
                {
                    pt.value = new ArrayList<String>();
                }
                pt.value.add(value);
            }
            ppt.preference.add(pt);
        }
        if (ppt.preferencesValidator != null || ppt.preference != null)
        {
            target.portletPreferences = ppt;
        }
        for (SecurityRoleRef srr : src.getSecurityRoleRefs())
        {
            if (target.securityRoleRef == null)
            {
                target.securityRoleRef = new ArrayList<SecurityRoleRefType>();                
            }
            SecurityRoleRefType srrt = new SecurityRoleRefType();
            srrt.roleName = srr.getRoleName();
            srrt.roleLink = srr.getRoleLink();
            for (Description d : srr.getDescriptions())
            {
                if (srrt.description == null)
                {
                    srrt.description = new ArrayList<DescriptionType>();
                }
                DescriptionType dt = new DescriptionType();
                dt.lang = d.getLang();
                dt.value = d.getDescription();
                srrt.description.add(dt);
            }
            target.securityRoleRef.add(srrt);
        }
    }
    
    private void upgradePortlet(PortletType src, PortletDefinition target)
    {
        if (src.description != null)
        {
            for (DescriptionType d : src.description)
            {
                Description desc = target.addDescription(d.lang);
                desc.setDescription(d.value);
            }
        }
        if (src.displayName != null)
        {
            for (DisplayNameType d : src.displayName)
            {
                DisplayName dname = target.addDisplayName(d.lang);
                dname.setDisplayName(d.value);
            }
        }
        target.setPortletClass(src.portletClass);
        if (src.expirationCache != null)
        {
            target.setExpirationCache(src.expirationCache.intValue());
        }
        if (src.initParam != null)
        {
            for (InitParamType p : src.initParam)
            {
                InitParam param = target.addInitParam(p.name);
                param.setParamValue(p.value);
                if (p.description != null)
                {
                    for (DescriptionType d : p.description)
                    {
                        Description desc = param.addDescription(d.lang);
                        desc.setDescription(d.value);
                    }
                }
            }
        }
        if (src.supports != null)
        {
            for (SupportsType st : src.supports)
            {
                Supports s = target.addSupports(st.mimeType);
                if (st.portletMode != null)
                {
                    for (String mode : st.portletMode)
                    {
                        s.addPortletMode(mode);
                    }
                }
            }
        }
        if (src.supportedLocale != null)
        {
            for (String lang : src.supportedLocale)
            {
                target.addSupportedLocale(lang);
            }
        }
        target.setResourceBundle(src.resourceBundle);
        if (src.portletInfo != null)
        {
            PortletInfo pi = target.getPortletInfo();
            pi.setTitle(src.portletInfo.title);
            pi.setShortTitle(src.portletInfo.shortTitle);
            pi.setKeywords(src.portletInfo.keywords);
        }
        if (src.portletPreferences != null)
        {
            Preferences prefs = target.getPortletPreferences();
            prefs.setPreferencesValidator(src.portletPreferences.preferencesValidator);
            if (src.portletPreferences.preference != null)
            {
                for (PreferenceType p : src.portletPreferences.preference)
                {
                    Preference pref = prefs.addPreference(p.name);
                    if (p.value != null)
                    {
                        for (String value : p.value)
                        {
                            pref.addValue(value);
                        }
                    }
                    if (p.readOnly != null)
                    {
                        pref.setReadOnly(p.readOnly.booleanValue());
                    }
                }
            }
        }
        if (src.securityRoleRef != null)
        {
            for (SecurityRoleRefType rrt : src.securityRoleRef)
            {
                SecurityRoleRef srr = target.addSecurityRoleRef(rrt.roleName);
                srr.setRoleLink(rrt.roleLink);
                if (rrt.description != null)
                {
                    for (DescriptionType d : rrt.description)
                    {
                        Description desc = srr.addDescription(d.lang);
                        desc.setDescription(d.value);
                    }
                }
            }
        }
    }
}
