/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.descriptors.common;

import org.apache.pluto.om.common.Icon;

/**
 * Resource Icon configuration.
 *
 * @version $Id: IconDD.java 157038 2005-03-11 03:44:40Z ddewolf $
 * @since Feb 28, 2005
 */
public class IconDD implements Icon{

    /** The large icon uri. */
    private String largeIcon;

    /** The small icon uri. */
    private String smallIcon;

    /**
     * Default Constructor.
     */
    public IconDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.Icon#getLargeIcon()
	 */
    public String getLargeIcon() {
        return largeIcon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.Icon#setLargeIcon(java.lang.String)
	 */
    public void setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.Icon#getSmallIcon()
	 */
    public String getSmallIcon() {
        return smallIcon;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.common.Icon#setSmallIcon(java.lang.String)
	 */
    public void setSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
    }

}

