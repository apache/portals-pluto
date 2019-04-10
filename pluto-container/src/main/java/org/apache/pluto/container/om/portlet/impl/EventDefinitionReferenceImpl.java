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

import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.EventDefinitionReference;

/**
 * Reference to an event definition
 * 
 * @author Scott Nicklous
 *
 */
public class EventDefinitionReferenceImpl implements EventDefinitionReference {

   private QName qname;

   
   /**
    * Copy Constructor
    * @param edri
    */
   public EventDefinitionReferenceImpl(EventDefinitionReference edri) {
      QName qn = edri.getQualifiedName();
      this.qname = new QName(qn.getNamespaceURI(), qn.getLocalPart());
   }
   
   /**
    * Constructor
    * @param qname
    */
   public EventDefinitionReferenceImpl(QName qname) {
      this.qname = qname;
   }
   
   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinitionReference#getQualifiedName()
    */
   @Override
   public QName getQualifiedName() {
      return qname;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.EventDefinitionReference#setQualifiedName(javax.xml.namespace.QName)
    */
   @Override
   public void setQualifiedName(QName qn) {
      this.qname = qn;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((qname == null) ? 0 : qname.hashCode());
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
      EventDefinitionReferenceImpl other = (EventDefinitionReferenceImpl) obj;
      if (qname == null) {
         if (other.qname != null) {
            return false;
         }
      } else if (!qname.equals(other.qname)) {
         return false;
      }
      return true;
   }

}
