/*
 * Copyright 2003,2004,2005 The Apache Software Foundation.
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
package org.apache.pluto.portlet.admin;

import java.io.File;

/**
 * PlutoAdminConstants
 *
 * @author Craig Doremus
 *
 */
public interface PlutoAdminConstants {

	public static final String ENCODING = "UTF-8";
	public static final String FS = File.separator;
	public static final String LS = System.getProperty("line.separator");
	public static final String PROP_FILENAME = "pluto-admin.properties";
	public static final String PAGE_ATTR = "page";
	public static final String PORTLET_MAP_ATTR = "portlet-map";
	public static final String PORTLET_APP_LIST_ATTR = "portlet-app-list";

	//for pageregistry
  public static final String PAGE_LIST_ATTR = "pagelist";

  //for portlet entity registry
	public static final String PER_LIST_ATTR = "perlist";
	public static final String APP_ATTR = "app";
	public static final String PREF_LIST_ATTR = "preflist";

  //  public static final String PAGE_ATTR = "portletpage";
	//Used for messages
	public static final String MESSAGE_ATTR = "message";
	public static final String ERROR_ATTR = "error";
}
