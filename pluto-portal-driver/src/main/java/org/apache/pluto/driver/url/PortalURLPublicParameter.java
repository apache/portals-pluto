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

import javax.xml.namespace.QName;

/**
 * Encapsulates concrete public render parameters used with the portal URLs.
 * @author msnicklous
 * @since  16/01/2014
 */
public class PortalURLPublicParameter extends PortalURLParameter {
   
   private final QName  qname;
   
   // mark if this PRP is to be removed from the current set
   private boolean removed = false;

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
   
   /**
    * Returns the Qname
    * @return     QName
    */
   public QName getQName() {
      return qname;
   }
   
   /**
    * Provides the information that the public render parameter designated by this object is to be 
    * removed from the current set.
    *  
    * @param removed     marks whether the PR is to be removed
    */
   public void setRemoved(boolean removed) {
      this.removed = removed;
   }
   
   /**
    * Tests whether the PRP has been removed
    * @return
    */
   public boolean isRemoved() {
      return removed;
   }
   
   /**
    * Returns a clone of the parameter
    */
   @Override
   public PortalURLPublicParameter clone() {
      // shallow clone of the values array works because strings are immutable
      QName qn = new QName(qname.getNamespaceURI(), qname.getLocalPart(), qname.getPrefix());
      PortalURLPublicParameter pupp =  new PortalURLPublicParameter(window, name, qn, (values == null ? values : values.clone()));
      pupp.setRemoved(removed);
      return pupp;
   }
   
}
