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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;

/**
 * Portlet applications can register portlet URL listeners in order to filter URLs 
 * before they get generated.
 * In order to receive a callback from the portlet container before a 
 * portlet URL is generated the portlet application needs to implement this 
 * interface and register it in the deployment descriptor with the
 * <code>listener</code> element.
 *
 * @since 2.0
 */
public interface PortletURLGenerationListener {

	/**
	 * Callback being called by the portlet container
	 * before <code>toString</code> or <code>write</code>
	 * are executed on action URLs.
	 * 
	 * @param actionURL  action URL to be generated
	 */
	public void filterActionURL(PortletURL actionURL);

	/**
	 * Callback being called by the portlet container
	 * before <code>toString</code> or <code>write</code>
	 * are executed on render URLs.
	 * 
	 * @param renderURL  render URL to be generated
	 */
	public void filterRenderURL(PortletURL renderURL);
	
	/**
	 * Callback being called by the portlet container
	 * before <code>toString</code> or <code>write</code>
	 * are executed on resource URLs.
	 * 
	 * @param resourceURL  resource URL to be generated
	 */
	public void filterResourceURL(ResourceURL resourceURL);
	
}
