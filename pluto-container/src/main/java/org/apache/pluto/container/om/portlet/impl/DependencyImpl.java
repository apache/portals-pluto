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

import org.apache.pluto.container.om.portlet.Dependency;


/**
 * Encapsulates the dependency configuration data.
 * 
 * @author Scott Nicklous
 *
 */
public class DependencyImpl implements Dependency {

   private String name    = null;
   private String scope = null;
   private String version = null;
   
   public DependencyImpl() {
   }
   
   public DependencyImpl(String name, String scope, String version) {
      this.name = name;
      this.scope = scope;
      this.version = version;
   }
   
   public DependencyImpl(Dependency di) {
      this.name = di.getName();
      this.scope = di.getScope();
      this.version = di.getVersion();
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.impl.Dependency#getName()
    */
   @Override
   public String getName() {
      return name;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.impl.Dependency#setName(java.lang.String)
    */
   @Override
   public void setName(String name) {
      this.name = name;
   }

   /**
    * @return the scope
    */
   @Override
   public String getScope() {
      return scope;
   }

   /**
    * @param scope the scope to set
    */
   @Override
   public void setScope(String scope) {
      this.scope = scope;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.impl.Dependency#getVersion()
    */
   @Override
   public String getVersion() {
      return version;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.impl.Dependency#setVersion(java.lang.String)
    */
   @Override
   public void setVersion(String version) {
      this.version = version;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      DependencyImpl other = (DependencyImpl) obj;
      if (name == null) {
         if (other.name != null) {
            return false;
         }
      } else if (!name.equals(other.name)) {
         return false;
      }
      return true;
   }
   
   
}
