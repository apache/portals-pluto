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

package org.apache.pluto.container;

/**
 * Contains identification data for a page resource.
 * 
 * @author Scott Nicklous
 * 
 */
public class PageResourceId implements Comparable<PageResourceId> {

   private final String name;
   private final String scope;
   private final String version;

   public PageResourceId(String name, String scope, String version) {
      this.name    = name;
      this.scope   = scope;
      this.version = version;
   }
   
   public PageResourceId(PageResourceId other) {
      this.name    = other.name;
      this.scope   = other.scope;
      this.version = other.version;
   }

   /**
    * @return the name
    */
   public String getName() {
      return name;
   }

   /**
    * @return the scope
    */
   public String getScope() {
      return scope;
   }

   /**
    * @return the version
    */
   public String getVersion() {
      return version;
   }

   public boolean resourceMatches(PageResourceId other) {
      if (this == other) {
         return true;
      }
      if (other == null) {
         return false;
      }
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

      return true;
   }

   @Override
   public String toString() {
      StringBuilder txt = new StringBuilder(128);
      txt.append("Page resource ID. Name: ").append(name);
      txt.append(", Scope: ").append(scope);
      txt.append(", Version: ").append(version);
      return txt.toString();
   }

   /*
    * (non-Javadoc)
    * 
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

   /*
    * (non-Javadoc)
    * 
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

   /**
    * Allows page resource IDs to be compared and ordered. 
    * <p>
    * Note that it doesn't really make much since to order page resource IDs unless they 
    * they refer to the same type of resource (meaning that they differ only in version).
    */
   @Override
   public int compareTo(PageResourceId id) {
      if (!equals(id)) {
         if (id == null) {
            return 1;
         }
         if (scope == null) {
            if (id.scope != null) {
               return -1;
            }
         } else if (!scope.equals(id.scope)) {
            return scope.compareTo(id.scope);
         }
         if (name == null) {
            if (id.name != null) {
               return -1;
            }
         } else if (!name.equals(id.name)) {
            return name.compareTo(id.name);
         }

         // now they must differ only in version

         String currVersion = null;
         String newVersion = null;
         String[] currDecimals = new String[0];
         String[] newDecimals = new String[0];

         // Extract the dotted decimal version numbers
         String regex = "^[vV=]{0,1}(\\d+(?:\\.\\d+){0,2}).*$";
         currVersion = version.replaceFirst(regex, "$1");
         newVersion = id.version.replaceFirst(regex, "$1");

         String dottedDecimalRegex = "^\\d+(?:\\.\\d+)*$";
         if (currVersion.matches(dottedDecimalRegex)) {

            // the current version is conforming dotted decimal.
            // If the new version is also conforming, compare version numbers.
            // otherwise new version is less then this one.

            if (newVersion.matches(dottedDecimalRegex)) {
               currDecimals = currVersion.split("\\.");
               newDecimals = newVersion.split("\\.");
               for (int ii = 0; (ii < currDecimals.length) && (ii < newDecimals.length); ii++) {
                  int currDigit = Integer.parseInt(currDecimals[ii]);
                  int newDigit = Integer.parseInt(newDecimals[ii]);
                  if (newDigit > currDigit) {
                     return 1;
                  } else if (newDigit < currDigit) {
                     return -1;
                  }
               }
               
               // they're equal so far, so the one with the most digits is greater
               
               if (currDecimals.length > newDecimals.length) {
                  return -1;
               } else if (currDecimals.length < newDecimals.length) {
                  return 1;
               } 
            }

         } else {

            // If new version conforms, use it, otherwise string compare

            if (newVersion.matches(dottedDecimalRegex)) {
               return 1;
            } else {
               // if neither conform, use string compare
               return version.compareTo(id.version);
            }

         }

      }
      return 0;
   }

}
