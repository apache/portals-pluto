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

import org.apache.pluto.container.om.portlet.Preference;

/**
 * @author Scott Nicklous
 *
 */
public class PreferenceImpl implements Preference {
   
   private String name;
   private boolean isReadOnly;
   private final ArrayList<String> values = new ArrayList<String>();
   
   public PreferenceImpl() {
      name = "";
      isReadOnly = false;
   }
   
   /**
    * Copy constructor
    * @param pi
    */
   public PreferenceImpl(Preference pi) {
      this.name = pi.getName();
      this.isReadOnly = pi.isReadOnly();
      this.values.addAll(pi.getValues());
   }
   
   /**
    * Basic Constructor
    * @param name
    * @param isRO
    * @param vals
    */
   public PreferenceImpl(String name, boolean isRO, List<String> vals) {
      this.name = name;
      this.isReadOnly = isRO;
      values.addAll(vals);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preference#getName()
    */
   @Override
   public String getName() {
      return name;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preference#getValues()
    */
   @Override
   public List<String> getValues() {
      return new ArrayList<String>(values);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preference#addValue(java.lang.String)
    */
   @Override
   public void addValue(String value) {
      values.add(value);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preference#isReadOnly()
    */
   @Override
   public boolean isReadOnly() {
      return isReadOnly;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.Preference#setReadOnly(boolean)
    */
   @Override
   public void setReadOnly(boolean readOnly) {
      isReadOnly = readOnly;
   }

}
