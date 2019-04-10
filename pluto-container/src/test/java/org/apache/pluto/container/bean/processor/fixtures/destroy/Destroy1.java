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


package org.apache.pluto.container.bean.processor.fixtures.destroy;

import javax.portlet.annotations.DestroyMethod;
import javax.portlet.annotations.RenderMethod;

import org.apache.pluto.container.bean.processor.fixtures.InvocationResults;

/**
 * @author Scott Nicklous
 *
 */
public class Destroy1 {
   
   private InvocationResults meths = InvocationResults.getInvocationResults();
   
   @DestroyMethod("portlet1")
   public void destroy1() {
      meths.addMethod(this.getClass().getSimpleName() + "#destroy1");
   }
   
   @DestroyMethod("portlet2")
   public void destroy2() {
      meths.addMethod(this.getClass().getSimpleName() + "#destroy2");
   }
   
   // dummy render method to keep config processor happy
   
   @RenderMethod(portletNames= {"portlet1", "portlet2", "portlet3"})
   public void render1() {}

}
