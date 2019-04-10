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


package org.apache.pluto.container.bean.processor.fixtures.resource;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ServeResourceMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott
 *
 */
public class Resource1 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @ServeResourceMethod(portletNames="portlet1")
   public void resource1a(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource1a");
   }
   
   @ServeResourceMethod(portletNames="portlet1")
   public void resource1b() {
      meths.addMethod(this.getClass().getSimpleName() + "#resource1b");
   }
   
   @ServeResourceMethod(portletNames="portlet1")
   public String resource1c() {
      meths.addMethod(this.getClass().getSimpleName() + "#resource1c");
      return null;
   }
   
   @ServeResourceMethod(portletNames="portlet2", resourceID="help")
   public void resource2a(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource2a");
   }
   
   @ServeResourceMethod(portletNames="portlet2", resourceID="edit", asyncSupported=false)
   public void resource2b(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource2b");
   }
   
   @ServeResourceMethod(portletNames="portlet2", resourceID="config")
   public void resource2c(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource2c");
   }
   
   @ServeResourceMethod(portletNames="portlet3", ordinal=200)
   public void resource3a(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource3a");
   }
   
   @ServeResourceMethod(portletNames="portlet3", ordinal=300, asyncSupported=true)
   public void resource3b() {
      meths.addMethod(this.getClass().getSimpleName() + "#resource3b");
   }
   
   @ServeResourceMethod(portletNames="portlet3", ordinal=-42)
   public String resource3c() {
      meths.addMethod(this.getClass().getSimpleName() + "#resource3c");
      return null;
   }
   
   @ServeResourceMethod(portletNames="portlet3", ordinal=200, resourceID="help")
   public String resource3e() {
      meths.addMethod(this.getClass().getSimpleName() + "#resource3e");
      return null;
   }
   

}
