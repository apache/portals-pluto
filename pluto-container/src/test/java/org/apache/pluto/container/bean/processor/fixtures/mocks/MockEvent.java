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


package org.apache.pluto.container.bean.processor.fixtures.mocks;

import java.io.Serializable;

import javax.portlet.Event;
import javax.xml.namespace.QName;

/**
 * @author Scott Nicklous
 *
 */
public class MockEvent implements Event {
   
   private final QName qn;
   
   public MockEvent(QName qn) {
      this.qn = qn;
   }

   /* (non-Javadoc)
    * @see javax.portlet.Event#getName()
    */
   @Override
   public String getName() {
      return qn.getLocalPart();
   }

   /* (non-Javadoc)
    * @see javax.portlet.Event#getQName()
    */
   @Override
   public QName getQName() {
      return qn;
   }

   /* (non-Javadoc)
    * @see javax.portlet.Event#getValue()
    */
   @Override
   public Serializable getValue() {
      return null;
   }

}
