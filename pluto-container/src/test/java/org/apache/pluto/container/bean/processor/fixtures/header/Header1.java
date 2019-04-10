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


package org.apache.pluto.container.bean.processor.fixtures.header;

import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.annotations.HeaderMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott Nicklous
 *
 */
public class Header1 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @HeaderMethod(portletNames="portlet1")
   public void header1a(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header1a");
   }
   
   @HeaderMethod(portletNames="portlet1")
   public void header1b() {
      meths.addMethod(this.getClass().getSimpleName() + "#header1b");
   }
   
   @HeaderMethod(portletNames="portlet1")
   public String header1c() {
      meths.addMethod(this.getClass().getSimpleName() + "#header1c");
      return null;
   }
   
   @HeaderMethod(portletNames="portlet2", portletMode="help")
   public void header2a(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header2a");
   }
   
   @HeaderMethod(portletNames="portlet2", portletMode="edit")
   public void header2b(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header2b");
   }
   
   @HeaderMethod(portletNames="portlet2", portletMode="config")
   public void header2c(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header2c");
   }
   
   @HeaderMethod(portletNames="portlet3", ordinal=200)
   public void header3a(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header3a");
   }
   
   @HeaderMethod(portletNames="portlet3", ordinal=300)
   public void header3b() {
      meths.addMethod(this.getClass().getSimpleName() + "#header3b");
   }
   
   @HeaderMethod(portletNames="portlet3", ordinal=-42)
   public String header3c() {
      meths.addMethod(this.getClass().getSimpleName() + "#header3c");
      return null;
   }
   
   @HeaderMethod(portletNames="portlet3", ordinal=300, portletMode="help")
   public void header3e() {
      meths.addMethod(this.getClass().getSimpleName() + "#header3e");
   }
   

}
