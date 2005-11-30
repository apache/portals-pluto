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
package org.apache.pluto.services.optional;

import java.util.Map;

import org.apache.pluto.services.ContainerService;

/**
 * Used to access user information attribute as described in
 * PLT.17.2 of the JSR-168 specificiation.
 * 
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 */
public interface UserInfoAttributesService extends ContainerService  {

	/**
	 * To access user information attributes as defined in PLT.17
	 * of JSR-168.
	 * 
	 * @param authUser The authenticated user name.
	 * @return A map of names and values of user information attributes
	 * for a particular authenticated user.
	 */
    Map getAttributes(String authUser);

}
