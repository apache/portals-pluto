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

import java.util.Arrays;

import javax.xml.namespace.QName;

/**
 * Encapsulates concrete public render parameters used with the portal URLs.
 * 
 * The public render parameters contain a 'removed' flag that marks whether or not the
 * PRP has been set. If the <code>removed</code> flag is set, the PRP is considered to
 * be inactive, or 'not set'. A newly-created PRP have the <code>removed</code> flag set. 
 * When a value is set, the <code>removed</code> flag is automatically reset.
 * 
 * @author msnicklous
 * @since  16/01/2014
 */
public class PortalURLPublicParameter extends PortalURLParameter {
   
   private final QName  qname;
   
   // mark if this PRP is to be removed from the current set
   private boolean removed = true;

   /**
    * Constructor when no value is available
    * @param window
    * @param name
    * @param qname
    */
   public PortalURLPublicParameter(String window, String name, QName qname) {
      super(window, name);
      this.qname = qname;
      this.type = PARAM_TYPE_PUBLIC;
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
      removed = false;
      this.type = PARAM_TYPE_PUBLIC;
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
      // Note that the QNames don't need to be cloned, as the internal fields are set thru constructor and cannot be changed.
      PortalURLPublicParameter pupp =  new PortalURLPublicParameter(window, name, qname, (values == null ? null : values.clone()));
      pupp.setRemoved(removed);
      return pupp;
   }
   
   /**
    * make sure removed flag is handled properly.
    */
   @Override
   public void setValues(String[] value) {
      super.setValues(value);
      removed = false;
   }
   
   @Override
   public String toString() {
      StringBuilder str = new StringBuilder("PRP: Window ID=");
      str.append(window)
         .append(", Name=").append(name)
         .append(", Qname=").append(qname)
         .append(", Values=").append(Arrays.toString(values));
      return str.toString();
   }
   
}
