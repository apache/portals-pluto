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


package org.apache.pluto.container.bean.processor.fixtures.render;

import javax.activity.InvalidActivityException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.RenderMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott Nicklous
 *
 */
public class Render2 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @RenderMethod(portletNames="portlet2", portletMode="edit", ordinal=-100)
   public void render2c(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render2c");
   }
   
   @RenderMethod(portletNames="portlet2", portletMode="edit", ordinal=100)
   public void render2d(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render2d");
   }
   
   // invalid signature
   @RenderMethod(portletNames="portlet4")
   public void render4(String x, RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render4");
   }
   
   // invalid signature
   @RenderMethod(portletNames="portlet5")
   public String render5(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render5");
      return null;
   }
   
   // invalid signature, bad exception
   @RenderMethod(portletNames="portlet8")
   public String render8(RenderRequest req, RenderResponse resp) throws InvalidActivityException {return null;}
   
   @RenderMethod(portletNames= {"portlet6", "portlet7"})
   public void render6and7(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render6and7");
   }
   
   // ignored asterisk
   @RenderMethod(portletNames= {"portlet6", "*"}, ordinal=100)
   public void render6andStar(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render6andStar");
   }
   
   @RenderMethod(portletNames="*", portletMode="admin")
   public void renderAll(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#renderAll");
   }
   

}
