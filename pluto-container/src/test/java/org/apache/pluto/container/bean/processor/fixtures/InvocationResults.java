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


package org.apache.pluto.container.bean.processor.fixtures;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Scott
 *
 */
@ApplicationScoped
public class InvocationResults {

   private List<String> methods = new ArrayList<String>();
   boolean configExists = false;
   
   private static InvocationResults results;

   /**
    * singleton
    */
   private InvocationResults() {
   }
   
   public static InvocationResults getInvocationResults() {
      if (results == null) {
         results = new InvocationResults();
      }
      return results;
   }

   /**
    * @return the methods
    */
   public List<String> getMethods() {
      return methods;
   }
   
   /**
    * clears all methods
    */
   public void reset() {
      methods.clear();
      configExists = false;
   }
   
   /**
    * adds method to results
    * 
    * @param meth
    */
   public void addMethod(String meth) {
      methods.add(meth);
   }

   /**
    * @return the configExists
    */
   public boolean isConfigExists() {
      return configExists;
   }

   /**
    * @param configExists the configExists to set
    */
   public void setConfigExists(boolean configExists) {
      this.configExists = configExists;
   }
}
