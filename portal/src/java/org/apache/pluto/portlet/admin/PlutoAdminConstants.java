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

	String ENCODING = "UTF-8";
	String FS = File.separator;
	String LS = System.getProperty("line.separator");
	String PROP_FILENAME = "pluto-admin.properties";
	String PAGE_ATTR = "page";
	String PORTLET_MAP_ATTR = "portlet-map";
	String PORTLET_APP_LIST_ATTR = "portlet-app-list";

	// for pageregistry
    String PAGE_LIST_ATTR = "pagelist";

    // for portlet entity registry
	String PER_LIST_ATTR = "perlist";
	String APP_ATTR = "app";
	String PREF_LIST_ATTR = "preflist";

    //  public static final String PAGE_ATTR = "portletpage";
	// Used for messages
	String MESSAGE_ATTR = "message";
	String ERROR_ATTR = "error";
}
