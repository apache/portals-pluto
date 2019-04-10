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

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;

/**
 * Represents a single container runtime option
 * 
 * @author Scott Nicklous
 *
 */
public class ContainerRuntimeOptionImpl implements ContainerRuntimeOption {
   
   private String name;
   private final ArrayList<String> values = new ArrayList<String>();
   
   /**
    * Constructs container rt options object
    * @param name    Runtime option name
    * @param vals    Runtime option value
    */
   public ContainerRuntimeOptionImpl(String name, List<String> vals) {
      this.name = name;
      values.addAll(vals);
   }
   
   /**
    * Copy constructor
    * @param croi
    */
   public ContainerRuntimeOptionImpl(ContainerRuntimeOption croi) {
      this.name = croi.getName();
      values.addAll(croi.getValues());
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.ContainerRuntimeOption#getName()
    */
   @Override
   public String getName() {
      return name;
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.ContainerRuntimeOption#getValues()
    */
   @Override
   public List<String> getValues() {
      return new ArrayList<String>(values);
   }

   /* (non-Javadoc)
    * @see org.apache.pluto.container.om.portlet.ContainerRuntimeOption#addValue(java.lang.String)
    */
   @Override
   public void addValue(String value) {
      values.add(value);
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
      ContainerRuntimeOptionImpl other = (ContainerRuntimeOptionImpl) obj;
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
