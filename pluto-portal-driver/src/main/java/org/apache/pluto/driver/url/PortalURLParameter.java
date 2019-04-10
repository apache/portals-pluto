/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.driver.url;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The portal URL parameter.
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Sep 30, 2004
 */
public class PortalURLParameter {
   private final Logger LOGGER = LoggerFactory.getLogger(PortalURLParameter.class);

   public final static String PARAM_TYPE_RENDER = "rp";
   public final static String PARAM_TYPE_ACTION = "ap";
   public final static String PARAM_TYPE_RESOURCE = "re";
   public final static String PARAM_TYPE_PUBLIC = "sp";
   
   private final static HashSet<String> allowedTypes = new HashSet<String>();
   {
      allowedTypes.add(PARAM_TYPE_RENDER);
      allowedTypes.add(PARAM_TYPE_ACTION);
      allowedTypes.add(PARAM_TYPE_RESOURCE);
   }

   protected final String window;
   protected final String name;
   protected String[] values;
   protected String type;
   protected boolean persistent = false;
   
   // Copy constructor
   public PortalURLParameter(PortalURLParameter pup) {
      window = pup.window;
      name = pup.name;
      values = (pup.values == null) ? null : pup.values.clone();
      type = pup.type;
      persistent = pup.persistent;
   }

   // Constructors for use by extending classes
   protected PortalURLParameter(String window, String name) {
      this.window = window;
      this.name = name;
      this.values = null;
   }

   // Create a new parameter of specified type
   public PortalURLParameter(String window, String name, String[] values) {
      this.window = window;
      this.name = name;
      this.values = values;
      this.type = PARAM_TYPE_RENDER;
   }

   public PortalURLParameter(String window, String name, String[] values, String type) {
      this.window = window;
      this.name = name;
      this.values = values;
      this.type = type;
      if (!allowedTypes.contains(type)) {
         LOGGER.warn("Parameter type: " + type + " is not in allowed set: " + allowedTypes.toString());
      }
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      if (!allowedTypes.contains(type)) {
         LOGGER.warn("Parameter type: " + type + " is not in allowed set: " + allowedTypes.toString());
      }
      this.type = type;
   }
   
   public String getName() {
      return name;
   }

   public String[] getValues() {
      return values;
   }

   public void setValues(String[] values) {
      this.values = values;
   }

   public String getWindowId() {
      return window;
   }
   
   /**
    * @return <code>true</code> if the parameter is flagged as persistent
    */
   public boolean isPersistent() {
      return persistent;
   }

   /**
    * Sets the persistent flag
    * @param persistent the persistent to set
    */
   public void setPersistent(boolean persistent) {
      this.persistent = persistent;
   }

   @Override
   public String toString() {
      StringBuilder txt = new StringBuilder(128);
      txt.append("Type: ").append(type);
      txt.append(", persistent: ").append(persistent);
      txt.append(", name: ").append(name);
      txt.append(", values: ").append((values == null) ? "null" : Arrays.toString(values));
      txt.append(", window ID: ").append(window);
      return txt.toString();
   }

   @Override
   public PortalURLParameter clone() {
      return new PortalURLParameter(this);
   }

   /**
    * For this class, "equals" means "refers to the same parameter". The parameter type, name & window
    * are compared, the values are NOT compared. The combination of window ID and parameter name 
    * must always be unique when the objects are used in collections. 
    */
   @Override
   public boolean equals(Object o) {
      boolean eq = false;
      if (o instanceof PortalURLParameter) {
         if (o == this) {
            eq = true; 
         } else {
            PortalURLParameter pup = (PortalURLParameter) o;
            if (equals(window, pup.window)) {
               if (equals(name, pup.name)) {
                  if (equals(type, pup.type)) {
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
      if (window != null) {
         hc += 37*hc + window.hashCode();
      }
      if (name != null) {
         hc += 37*hc + name.hashCode();
      }
      if (type != null) {
         hc += 37*hc + type.hashCode();
      }
      return hc;
   }

   /**
    * helper function for comparison. 
    */
   protected boolean equals(Object o1, Object o2) {
      boolean eq = false;
      if (o1 == o2) {
         eq = true;
      } else if (o1 != null && o2 != null) {
         eq = o1.equals(o2);
      }
      return eq;
   }

}

