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
package org.apache.pluto.descriptors.servlet;

import org.apache.pluto.om.servlet.MimeMapping;

/**
 * <B>TODO</B>: Document
 * @version $Id:$
 * @since Feb 28, 2005
 */
public class MimeMappingDD implements MimeMapping {

    private String extension;
    private String mimeType;

    public MimeMappingDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.MimeMapping#getMimeType()
	 */
    public String getMimeType() {
        return mimeType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.MimeMapping#setMimeType(java.lang.String)
	 */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.MimeMapping#getExtension()
	 */
    public String getExtension() {
        return extension;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.MimeMapping#setExtension(java.lang.String)
	 */
    public void setExtension(String extension) {
        this.extension = extension;
    }

}

