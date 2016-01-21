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


package org.apache.portals.samples;

import java.io.Serializable;

import javax.portlet.annotations.PortletSessionScoped;

/**
 * Provides a random number generated once per request.
 * @author Scott Nicklous
 *
 */
@PortletSessionScoped
public class PortletSessionRandomNumberBean implements Serializable{
   private static final long serialVersionUID = -7072838091228517612L;

   private int randomNumber;
   
   public PortletSessionRandomNumberBean() {
      randomNumber = ((int)(Math.random() * 1000));
   }

   /**
    * @return the randomNumber
    */
   public int getRandomNumber() {
      return randomNumber;
   }

   /**
    * @param randomNumber the randomNumber to set
    */
   public void setRandomNumber(int randomNumber) {
      this.randomNumber = randomNumber;
   }

}
