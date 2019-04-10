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

import java.util.List;

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
 * The public render parameters contain a 'removed' flag that marks whether or not the
 * PRP has been set. If the <code>removed</code> flag is set, the PRP is considered to
 * be inactive, or 'not set'. A newly-created PRP mapper will contain public render parameters
 * whose <code>removed</code> flag is set. When a value is set, the <code>removed</code>
 * flag is automatically reset.
 * 
 * @author msnicklous
 * @since  19/01/2015
 */
public interface PublicRenderParameterMapper {

   /**
    * Returns the set of public render parameters specified by the input group index.
    * 
    * @param index   The group index
    * @return        Set containing all matching PRPs.
    * 
    * @throws        IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= getNumberOfGroups())
    */
   public List<PortalURLPublicParameter> getPublicParameterGroup(int index);
   
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
    * Setting a value automatically resets the 'removed' flag so that the values are made available
    * to portlets using the public render parameter in question.
    * 
    * @param index      Group index
    * @param values     Values array for the public render parameters contained in the group
    */
   public void setValues(int index, String[] values);

   /**
    * Gets the string value array that is set for all the public render parameters within  
    * the group specified by the index. Returns null if the PRP is marked as removed.
    * 
    * @param index      Group index
    * @return           String array 
    * 
    * @throws           IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= getNumberOfGroups())
    */
   public String[] getValues(int index);
   
   /**
    * Sets the 'removed' flag for all public render parameters in the group specified by the index.
    * 
    * When the 'removed' flag is set, the public render parameter is considered to be not set.
    * the value <code>null</code> will be returned to a portlet attempting to read the parameter.
    * 
    * @param index      Group index
    * @param removed    <code>true</code> marks the PRP as removed. <code>false</code> resets the value to <code>null</code> and marks it as being available.
    */
   public void setRemoved(int index, boolean removed);

   /**
    * Gets the 'removed' flag that is set for all the public render parameters within  
    * the group specified by the index.
    * 
    * @param index      Group index
    * @return           The removed flag.  
    * 
    * @throws           IndexOutOfBoundsException - if the index is out of range (index < 0 || index >= getNumberOfGroups())
    */
   public boolean getRemoved(int index);
   
   /**
    * Returns an array containing the indexes of all active PRP groups (<code>removed</code> flag
    * is reset).
    * 
    * @return   an array of indexes. If no groups are active, the array will be empty.
    */
   public List<Integer> getActiveIndexes();
   
   /**
    * Returns an array containing the indexes of all indexes (= PRPs) defined for the given portlet window.
    * 
    * @param   wid         window ID
    * @param   onlyActive  if true, only the active ( = set) PRPs are returned
    * @return              a list of public render parameters for the window. If none are found, the list will be empty.
    */
   public List<PortalURLPublicParameter> getPRPsForWindow(String wid, boolean onlyActive);
   
   /**
    * Returns a clone of the mapper. All public render parameters contained in the mapper are cloned as well.
    * @return
    */
   public PublicRenderParameterMapper clone();
}
