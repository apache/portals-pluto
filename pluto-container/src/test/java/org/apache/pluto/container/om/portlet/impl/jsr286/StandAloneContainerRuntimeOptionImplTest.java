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


package org.apache.pluto.container.om.portlet.impl.jsr286;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.impl.ContainerRuntimeOptionImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Scott Nicklous
 *
 */
public class StandAloneContainerRuntimeOptionImplTest {
   
   private static final String NAME = "name";
   private static final String VAL3 = "v3";
   private static final String[] VALS = {"v1", "v2"}; 
   private static final String[] VALS3 = {"v1", "v2", "v3"}; 
   
   private ContainerRuntimeOption cro;

   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception {
      cro = new ContainerRuntimeOptionImpl(NAME, Arrays.asList(VALS));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.ContainerRuntimeOptionImpl#ContainerRuntimeOptionImpl(java.lang.String, java.util.List)}.
    */
   @Test
   public void testContainerRuntimeOptionImplStringListOfString() {
      assertEquals(NAME, cro.getName());
      assertArrayEquals(VALS, cro.getValues().toArray());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.ContainerRuntimeOptionImpl#ContainerRuntimeOptionImpl(org.apache.pluto.container.om.portlet.ContainerRuntimeOption)}.
    */
   @Test
   public void testContainerRuntimeOptionImplContainerRuntimeOption() {
      ContainerRuntimeOption cro2 = new ContainerRuntimeOptionImpl(cro);
      assertEquals(NAME, cro2.getName());
      assertArrayEquals(VALS, cro2.getValues().toArray());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.ContainerRuntimeOptionImpl#getName()}.
    */
   @Test
   public void testGetName() {
      assertEquals(NAME, cro.getName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.ContainerRuntimeOptionImpl#getValues()}.
    */
   @Test
   public void testGetValues() {
      assertArrayEquals(VALS, cro.getValues().toArray());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.ContainerRuntimeOptionImpl#addValue(java.lang.String)}.
    */
   @Test
   public void testAddValue() {
      ContainerRuntimeOption cro2 = new ContainerRuntimeOptionImpl(cro);
      cro.addValue(VAL3);
      assertArrayEquals(VALS3, cro.getValues().toArray());
      assertArrayEquals(VALS, cro2.getValues().toArray());
   }

}
