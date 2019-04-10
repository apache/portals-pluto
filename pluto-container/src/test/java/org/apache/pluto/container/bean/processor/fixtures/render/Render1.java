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

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.annotations.RenderMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott
 *
 */
public class Render1 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @RenderMethod(portletNames="portlet1")
   public void render1a(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render1a");
   }
   
   @RenderMethod(portletNames="portlet1")
   public void render1b() {
      meths.addMethod(this.getClass().getSimpleName() + "#render1b");
   }
   
   @RenderMethod(portletNames="portlet1")
   public String render1c() {
      meths.addMethod(this.getClass().getSimpleName() + "#render1c");
      return null;
   }
   
   @RenderMethod(portletNames="portlet2", portletMode="help")
   public void render2a(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render2a");
   }
   
   @RenderMethod(portletNames="portlet2", portletMode="edit")
   public void render2b(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render2b");
   }
   
   @RenderMethod(portletNames="portlet2", portletMode="config")
   public void render2c(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render2c");
   }
   
   @RenderMethod(portletNames="portlet3", ordinal=200)
   public void render3a(RenderRequest req, RenderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#render3a");
   }
   
   @RenderMethod(portletNames="portlet3", ordinal=300)
   public void render3b() {
      meths.addMethod(this.getClass().getSimpleName() + "#render3b");
   }
   
   @RenderMethod(portletNames="portlet3", ordinal=-42)
   public String render3c() {
      meths.addMethod(this.getClass().getSimpleName() + "#render3c");
      return null;
   }
   
   @RenderMethod(portletNames="portlet3", ordinal=-420, portletMode="")
   public String render3d() {
      meths.addMethod(this.getClass().getSimpleName() + "#render3d");
      return null;
   }
   
   @RenderMethod(portletNames="portlet3", ordinal=300, portletMode="help")
   public void render3e() {
      meths.addMethod(this.getClass().getSimpleName() + "#render3e");
   }
   

}
