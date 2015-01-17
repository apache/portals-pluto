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


package org.apache.pluto.driver.url;

import static java.util.logging.Level.*;

import java.util.logging.Logger;

import javax.xml.namespace.QName;

/**
 * Encapsulates concrete public render parameters used with the portal URLs.
 * @author msnicklous
 * @since  16/01/2014
 */
public class PortalURLPublicParameter extends PortalURLParameter {
   private static final String LOG_CLASS = PortalURLPublicParameter.class.getName();
   private final Logger        LOGGER    = Logger.getLogger(LOG_CLASS);
   
   private QName  qname;

   /**
    * Constructor when no value is available
    * @param window
    * @param name
    * @param qname
    */
   public PortalURLPublicParameter(String window, String name, QName qname) {
      super(window, name);
      this.qname = qname;
   }

   /**
    * Constructor with single value
    * @param window
    * @param name
    * @param qname
    * @param value
    */
   public PortalURLPublicParameter(String window, String name, QName qname, String value) {
      super(window, name, value);
      this.qname = qname;
   }

   /**
    * Constructor with multiple values
    * @param window
    * @param name
    * @param qname
    * @param values
    */
   public PortalURLPublicParameter(String window, String name, QName qname, String[] values) {
      super(window, name, values);
      this.qname = qname;
   }
   
   public QName getQName() {
      return qname;
   }
   
   public void setQName(QName qname) {
      this.qname = qname;
   }

}
