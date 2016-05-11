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
 * Provides data for the source of a resource to be placed on a page.
 * 
 * @author Scott Nicklous
 *
 */
public class PageResourceSource {
   
   private final String type;
   private final String source;
   
   public PageResourceSource(String type, String source) {
      this.type = type;
      this.source = source;
   }

   /**
    * @return the type
    */
   public String getType() {
      return type;
   }

   /**
    * @return the source
    */
   public String getSource() {
      return source;
   }
   
   @Override
   public String toString() {
      StringBuilder txt = new StringBuilder(128);
      txt.append("Page resource source. Type: ").append(type);
      txt.append(", Source: ").append(source);
      return txt.toString();
   }
}
