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


package org.apache.pluto.driver.services.portal;

/**
 * Contains identification data for a page resource.
 * 
 * @author Scott Nicklous
 *
 */
public class PageResourceId {
   
   private String name;
   private String scope;
   private String version;
   
   public PageResourceId(String name, String scope, String version) {
      this.name = name;
      this.scope = scope;
      this.version = version;
   }
   
   /**
    * @return the name
    */
   public String getName() {
      return name;
   }
   
   /**
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * @return the scope
    */
   public String getScope() {
      return scope;
   }
   
   /**
    * @param scope the scope to set
    */
   public void setScope(String library) {
      this.scope = library;
   }
   
   /**
    * @return the version
    */
   public String getVersion() {
      return version;
   }
   
   /**
    * @param version the version to set
    */
   public void setVersion(String version) {
      this.version = version;
   }
   
   @Override
   public String toString() {
      StringBuilder txt = new StringBuilder(128);
      txt.append("Page resource ID. Name: ").append(name);
      txt.append(", Scope: ").append(scope);
      txt.append(", Version: ").append(version);
      return txt.toString();
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((scope == null) ? 0 : scope.hashCode());
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + ((version == null) ? 0 : version.hashCode());
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
      PageResourceId other = (PageResourceId) obj;
      if (scope == null) {
         if (other.scope != null) {
            return false;
         }
      } else if (!scope.equals(other.scope)) {
         return false;
      }
      if (name == null) {
         if (other.name != null) {
            return false;
         }
      } else if (!name.equals(other.name)) {
         return false;
      }
      if (version == null) {
         if (other.version != null) {
            return false;
         }
      } else if (!version.equals(other.version)) {
         return false;
      }
      return true;
   }

}
