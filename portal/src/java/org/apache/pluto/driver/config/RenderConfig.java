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

import java.util.Collection;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class RenderConfig {
    private static final Log LOG =
        LogFactory.getLog(RenderConfig.class);

    private Map pages;
    private String defaultPageId;

    // internally used.
    private int orderNumberCounter = 0;
    private Comparator pageComparator;

    public RenderConfig() {
        this.pages = new java.util.HashMap();
        this.pageComparator = new Comparator() {
            public int compare(Object a, Object b) {
                PageConfig pa = (PageConfig)a;
                PageConfig pb = (PageConfig)b;
                if(pa.getOrderNumber() > pb.getOrderNumber()) {
                    return 1;
                }
                else if(pa.getOrderNumber() == pb.getOrderNumber()) {
                    return 0;
                }
                else {
                    return -1;
                }
            }

            public boolean equals(Object a) {
                return false;
            }
        };
    }


    public String getDefaultPageId() {
        return defaultPageId;
    }

    public void setDefaultPageId(String defaultPageId) {
        this.defaultPageId = defaultPageId;
    }

    public Collection getPages() {
        List col =  new ArrayList(pages.values());
        Collections.sort(col, pageComparator);
        return col;
    }

    public PageConfig getPageConfig(String pageId) {
        if (pageId == null || "".equals(pageId)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(
                    "Requested page is null.  Returning default: " +
                    defaultPageId);
            }
            pageId = defaultPageId;
        }
        return (PageConfig) pages.get(pageId);
    }

    public void addPage(PageConfig config) {
        config.setOrderNumber(orderNumberCounter++);
        pages.put(config.getName(), config);
    }

}
