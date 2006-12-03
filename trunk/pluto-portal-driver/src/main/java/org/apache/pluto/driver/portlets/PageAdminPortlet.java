/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.driver.portlets;


public class PageAdminPortlet extends GenericPlutoPortlet {

    private static final String VIEW_PAGE = "/WEB-INF/fragments/admin/page/view.jsp";
    private static final String EDIT_PAGE = "/WEB-INF/fragments/admin/page/edit.jsp";
    private static final String HELP_PAGE = "/WEB-INF/fragments/admin/page/help.jsp";


    public String getViewPage() {
        return VIEW_PAGE;
    }

    public String getEditPage() {
        return EDIT_PAGE;
    }

    public String getHelpPage() {
        return HELP_PAGE;
    }
}
