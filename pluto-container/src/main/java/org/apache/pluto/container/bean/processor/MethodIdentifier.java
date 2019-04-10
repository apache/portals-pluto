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


package org.apache.pluto.container.bean.processor;


/**
 * Identifies the annotated method type.
 * <p>
 * The dispatchId is the action name for action methods, resource ID for resource
 * methods, the portlet mode as string for header & render methods, and the processing
 * event reference QName for event methods. 
 * 
 * @author Scott
 *
 */
public class MethodIdentifier {
   
   private final  String portletName;
   private        Object dispatchId;
   private final  MethodType type;

   /**
    * Constructor
    */
   public MethodIdentifier(String name, Object id, MethodType type) {;
      this.portletName = name;
      this.dispatchId = id;
      this.type = type;
   }
   
   /**
    * Copy constructor
    */
   public MethodIdentifier(MethodIdentifier mi) {
      this.portletName = mi.portletName;
      this.dispatchId = mi.dispatchId;
      this.type = mi.type;
   }
   
   public String getName() {
      return portletName;
   }
   
   public Object getId() {
      return dispatchId;
   }
   
   public void setId(Object id) {
      this.dispatchId = id;
   }
   
   public MethodType getType() {
      return type;
   }

   @Override
   public boolean equals(Object o) {
      boolean eq = false;
      if (o instanceof MethodIdentifier) {
         if (o == this) {
            eq = true; 
         } else {
            MethodIdentifier mi = (MethodIdentifier) o;
            if (equals(portletName, mi.portletName)) {
               if (equals(type, mi.type)) {
                  if (equals(dispatchId, mi.dispatchId)) {
                     eq = true;
                  }
               }
            }
         }
      }
      return eq;
   }

   @Override
   public int hashCode() {
      int hc = 17;
      if (portletName != null) {
         hc += 37*hc + portletName.hashCode();
      }
      if (dispatchId != null) {
         hc += 37*hc + dispatchId.hashCode();
      }
      if (type != null) {
         hc += 37*hc + type.hashCode();
      }
      return hc;
   }

   /**
    * helper function for equality comparison. 
    */
   private boolean equals(Object o1, Object o2) {
      boolean eq = false;
      if (o1 == o2) {
         eq = true;
      } else if (o1 != null && o2 != null) {
         eq = o1.equals(o2);
      }
      return eq;
   }
   
   public String toString() {
      StringBuilder txt = new StringBuilder(256);
      txt.append("Portlet name='").append(portletName).append("'");
      txt.append(", Method type='").append(type).append("'");
      txt.append(", Dispatch ID='").append(dispatchId).append("'");
      return txt.toString();
   }

}
