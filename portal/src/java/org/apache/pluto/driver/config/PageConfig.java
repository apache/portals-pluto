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
package org.apache.pluto.driver.config;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class PageConfig {

    private String name;
    private String uri;
    private Collection portletIds;
    private int orderNumber;

    public PageConfig() {
        this.portletIds = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Collection getPortletIds() {
        return portletIds;
    }

    public void setPortletIds(Collection ids) {
        this.portletIds = ids;
    }

    public void addPortlet(String contextPath, String portletName) {
        portletIds.add(
            PortletWindowConfig.createPortletId(contextPath, portletName));
    }

    void setOrderNumber(int number) {
        this.orderNumber = number;
    }

    int getOrderNumber() {
        return orderNumber;
    }


}
