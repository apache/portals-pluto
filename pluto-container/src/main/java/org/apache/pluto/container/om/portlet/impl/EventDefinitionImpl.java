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

import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.EventDefinition;

/**
 * A single event declaration
 * 
 * @author Scott Nicklous
 */
public class EventDefinitionImpl implements EventDefinition {
   
   private QName qn;
   private final ArrayList<QName> aliases = new ArrayList<QName>();
   private final List<Description> descs = new ArrayList<Description>();
   private final List<DisplayName> dispNames = new ArrayList<DisplayName>();
   private String valType;

   /**
    * Copy constructor
    * @param edi
    */
   public EventDefinitionImpl(EventDefinition edi) {
      this.qn = new QName(edi.getQName().getNamespaceURI(), edi.getQName().getLocalPart());
      this.valType = edi.getValueType();
      for (QName qn : edi.getAliases()) {
         this.aliases.add(new QName(qn.getNamespaceURI(), qn.getLocalPart()));
      }
      for (Description desc : edi.getDescriptions()) {
         descs.add(new DescriptionImpl(desc));
      }
      for (DisplayName disp : edi.getDisplayNames()) {
         dispNames.add(new DisplayNameImpl(disp));
      }
   }
   
   /**
    * Basic constructor
    * @param qn
    */
   public EventDefinitionImpl(QName qn) {
      this.qn = qn;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#getQName()
    */
   @Override
   public QName getQName() {
      return qn;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#setQName(javax.xml.namespace.QName)
    */
   @Override
   public void setQName(QName qn) {
      this.qn = qn;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#getAliases()
    */
   @Override
   public List<QName> getAliases() {
      return new ArrayList<QName>(aliases);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#addAlias(javax.xml.namespace.QName)
    */
   @Override
   public void addAlias(QName qName) {
      aliases.add(qName);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#getDescription(java.util.Locale)
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
    * @see org.apache.pluto.container.om.portlet.EventDefinition#getDescriptions()
    */
   @Override
   public List<Description> getDescriptions() {
      return new ArrayList<Description>(descs);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#addDescription(org.apache.pluto.container.om.portlet.Description)
    */
   @Override
   public void addDescription(Description desc) {
      descs.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#getDisplayName(java.util.Locale)
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
    * @see org.apache.pluto.container.om.portlet.EventDefinition#getDisplayNames()
    */
   @Override
   public List<DisplayName> getDisplayNames() {
      return new ArrayList<DisplayName>(dispNames);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#addDisplayName(org.apache.pluto.container.om.portlet.DisplayName)
    */
   @Override
   public void addDisplayName(DisplayName desc) {
      dispNames.add(desc);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#getValueType()
    */
   @Override
   public String getValueType() {
      return valType;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinition#setValueType(java.lang.String)
    */
   @Override
   public void setValueType(String valueType) {
      valType = valueType;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((qn == null) ? 0 : qn.hashCode());
      return result;
   }

   /* (non-Javadoc)
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
      EventDefinitionImpl other = (EventDefinitionImpl) obj;
      if (qn == null) {
         if (other.qn != null) {
            return false;
         }
      } else if (!qn.equals(other.qn)) {
         return false;
      }
      return true;
   }

}
