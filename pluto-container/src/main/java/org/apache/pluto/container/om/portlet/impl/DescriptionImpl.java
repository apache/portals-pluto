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

import java.util.Locale;

import org.apache.pluto.container.om.portlet.Description;

/**
 * A single locale-specific description
 * 
 * @author Scott Nicklous
 *
 */
public class DescriptionImpl extends LocaleTextImpl implements Description {
   
   /**
    * default: lang = english
    */
   public DescriptionImpl() {
      super();
   }
   
   /**
    * Constructor
    * @param locale     Locale language tag according to BCP 47
    * @param disp       description string
    */
   public DescriptionImpl(Locale locale, String desc) {
      super(locale, desc);
   }
   
   /**
    * Copy constructor
    */
   public DescriptionImpl(Description di) {
      super(di);
   }

}
