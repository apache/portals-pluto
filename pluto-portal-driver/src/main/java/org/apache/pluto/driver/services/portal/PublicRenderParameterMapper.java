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

package org.apache.pluto.driver.services.portal;

import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.pluto.driver.url.PortalURLPublicParameter;

/**
 * Interface for the public render parameter mapper.
 * 
 * The mapper maps the public render parameters into groups. All PRPs within a group
 * are considered to be referring to the same underlying parameter, and should 
 * therefore have the same value.
 * 
 * The algorithm for mapping the parameters into groups is determined by the specific 
 * public render parameter mapping service / mapper implementation.
 * 
 * The mapper provides a standard interface for manipulating the mapped PRP groups.
 * 
 * The groups are numbered beginning at 0, and they are addressed through the numeric
 * index much like an ArrayList. 
 * 
 * Proper functioning of the mapper is dependent on the PortalURLPublicParameter 
 * equals() function, which determines equality of public render parameters
 * based on comparison of the window ID and the parameter name (= PRP identifier).
 * 
 * @author msnicklous
 * @since  16/01/2015
 */
public interface PublicRenderParameterMapper {

   /**
    * Returns the set of public render parameters matching the input public render parameter.
    * The returned set will include the input PRP (providing that it is used on the page at all).
    * 
    * @param prp     The public render parameter to be matched
    * @return        Set containing all matching PRPs
    */
   public Set<PortalURLPublicParameter> getMappedPublicParameters(PortalURLPublicParameter prp);

   /**
    * Returns the set of public render parameters specified by the input group index.
    * 
    * @param index   The group index
    * @return        Set containing all matching PRPs.
    *                If no group matches the index, an empty set is returned
    */
   public Set<PortalURLPublicParameter> getMappedPublicParameters(int index);
   
   /**
    * Returns the number of distinct PRP groups available from the mapper.
    * 
    * @return     number of groups
    */
   public int getNumberOfGroups();
   
   /**
    * Returns the group index for the given public render parameter. If the input
    * PRP cannot be found in the overall set, -1 is returned.
    * 
    * @param prp     input PRP
    * @return        if the PRP is found in the overall set, the index of the group containing the PRP.
    *                if the PRP cannot be found, -1 is returned
    */
   public int getIndex(PortalURLPublicParameter prp);
   
   /**
    * Returns the group index for the given window ID / PRP identifier pair. 
    * If the input PRP cannot be found in the overall set, -1 is returned.
    * 
    * @param windowId   Window ID   
    * @param identifier PRP identifier
    * @return        if the PRP is found in the overall set, the index of the group containing the PRP.
    *                if the PRP cannot be found, -1 is returned
    */
   public int getIndex(String windowId, String identifier);
   
   /**
    * Returns the group index for the given PRP QName unique identifier. 
    * If the input PRP cannot be found in the overall set, -1 is returned.
    * 
    * @param qname      QName  
    * @return           if the PRP is found in the overall set, the index of the group containing the PRP.
    *                   if the PRP cannot be found, -1 is returned
    */
   public int getIndex(QName qname);
   
   /**
    * Sets the values of all public render parameters within the specified group. 
    * 
    * @param index      Group index
    * @param values     Values array for the public render parameters contained in the group
    */
   public void setValue(int index, String[] values);

   // scafolding function - to be thrown away then the URL generation is complete.
   public Set<PortalURLPublicParameter> getPRPsForId(String id, String[] vals);
   
}
