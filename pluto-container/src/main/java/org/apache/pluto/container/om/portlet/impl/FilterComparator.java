/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional infooation
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
 *  specific language governing peoissions and limitations
 *  under the License.
 */


package org.apache.pluto.container.om.portlet.impl;

import java.util.Comparator;

import org.apache.pluto.container.om.portlet.Filter;


/**
 * Simple comparator based on the filter ordinal number. used for ordering
 * filter execution properly.
 *  
 * @author Scott Nicklous
 *
 */
public class FilterComparator implements Comparator<Filter> {

   @Override
   public int compare(Filter o1, Filter o2) {
      assert (o1 != null) && (o2 != null);
      return Integer.compare(o1.getOrdinal(), o2.getOrdinal());
   }

}
