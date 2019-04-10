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

import javax.activity.InvalidActivityException;
import javax.portlet.HeaderRequest;
import javax.portlet.HeaderResponse;
import javax.portlet.annotations.HeaderMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott Nicklous
 *
 */
public class Header2 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @HeaderMethod(portletNames="portlet2", portletMode="edit", ordinal=-100)
   public void header2c(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header2c");
   }
   
   @HeaderMethod(portletNames="portlet2", portletMode="edit", ordinal=100)
   public void header2d(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header2d");
   }
   
   // invalid signature
   @HeaderMethod(portletNames="portlet4")
   public void header4(String x, HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header4");
   }
   
   // invalid signature
   @HeaderMethod(portletNames="portlet5", portletMode="edit")
   public String header5(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header5");
      return null;
   }
   
   // invalid signature, bad exception
   @HeaderMethod(portletNames="portlet8")
   public String header8(HeaderRequest req, HeaderResponse resp) throws InvalidActivityException {
      meths.addMethod(this.getClass().getSimpleName() + "#header8");
      return null;
   }
   
   @HeaderMethod(portletNames= {"portlet6", "portlet7"})
   public void header6and7(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header6and7");
   }
   
   // ignored asterisk
   @HeaderMethod(portletNames= {"portlet6", "*"}, ordinal=100)
   public void header6andStar(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#header6andStar");
   }
   
   @HeaderMethod(portletNames="*", portletMode="admin")
   public void headerAll(HeaderRequest req, HeaderResponse resp) {
      meths.addMethod(this.getClass().getSimpleName() + "#headerAll");
   }
   

}
