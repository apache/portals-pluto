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

import javax.activity.InvalidActivityException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ServeResourceMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott
 *
 */
public class Resource2 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @ServeResourceMethod(portletNames="portlet2", resourceID="edit", ordinal=-100)
   public void resource2c(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource2c");
   }
   
   @ServeResourceMethod(portletNames="portlet2", resourceID="edit", ordinal=100)
   public void resource2d(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource2d");
   }
   
   // invalid signature
   @ServeResourceMethod(portletNames="portlet4")
   public void resource4(String x, ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource4");
   }
   
   // invalid signature
   @ServeResourceMethod(portletNames="portlet5")
   public String resource5(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource5");
      return null;
   }
   
   // invalid signature, bad exception
   @ServeResourceMethod(portletNames="portlet8")
   public String resource8(ResourceRequest req, ResourceResponse resp) throws InvalidActivityException {
      meths.addMethod(this.getClass().getSimpleName() + "#resource8");
      return null;
   }
   
   @ServeResourceMethod(portletNames= {"portlet6", "portlet7"})
   public void resource6and7(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource6and7");
   }
   
   // ignored asterisk
   @ServeResourceMethod(portletNames= {"portlet6", "*"}, ordinal=100)
   public void resource6andStar(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resource6andStar");
   }
   
   @ServeResourceMethod(portletNames="*", resourceID="admin")
   public void resourceAll(ResourceRequest req, ResourceResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#resourceAll");
   }
   

}
