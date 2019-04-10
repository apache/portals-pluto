package org.apache.pluto.container.om.portlet;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public interface Dependency {

   /**
    * @return the name
    */
   String getName();

   /**
    * @param name the name to set
    */
   void setName(String name);

   /**
    * @return the version
    */
   String getVersion();

   /**
    * @param version the version to set
    */
   void setVersion(String version);

   /**
    * @return the scope name
    */
   String getScope();
   
   /**
    * @param scope - the scope name
    */
   void setScope(String scope);

}