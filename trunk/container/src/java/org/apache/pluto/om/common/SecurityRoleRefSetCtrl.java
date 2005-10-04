/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* 

 */


package org.apache.pluto.om.common;

/**
 * <P>
 * The <CODE>SecurityRoleRefSetCtrl</CODE> interface  ...
 * </P>
 * <P>
 * This interface defines the controller as known from the MVC pattern.
 * Its purpose is to provide write access to the data stored in the model.
 */

public interface SecurityRoleRefSetCtrl extends org.apache.pluto.om.Controller
{


    /**
     * Adds a SecurityRoleRef to the set
     * 
     * @param securityRoleRef the security-role-ref to be added
     * 
     * @return the new SecurityRoleRef
     */
    public SecurityRoleRef add(SecurityRoleRef securityRoleRef);

    /**
     * Removes the SecurityRoleRef with the given name
     * from the set
     * 
     * @param name   the name of the SecurityRoleRef to be removed
     * 
     * @return the removed SecurityRoleRef
     */
    public SecurityRoleRef remove(String name);

    /**
     * Removes the given SecurityRoleRef from the set
     * 
     * @param securityRoleRef the SecurityRoleRef to be removed
     */
    public void remove(SecurityRoleRef securityRoleRef);

}
