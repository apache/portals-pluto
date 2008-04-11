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

import java.util.List;

import org.apache.pluto.om.servlet.WelcomeFileList;

/**
 * <B>TODO</B>: Document
 * @version $Id: WelcomeFileListDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Feb 28, 2005
 */
public class WelcomeFileListDD implements WelcomeFileList {

    private List welcomeFiles;

    public WelcomeFileListDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WelcomeFileList#getWelcomeFiles()
	 */
    public List getWelcomeFiles() {
        return welcomeFiles;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.WelcomeFileList#setWelcomeFiles(java.util.List)
	 */
    public void setWelcomeFiles(List welcomeFiles) {
        this.welcomeFiles = welcomeFiles;
    }

}

