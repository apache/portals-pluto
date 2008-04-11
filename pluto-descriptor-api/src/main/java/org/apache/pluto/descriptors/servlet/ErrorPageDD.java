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
 * See the License for the specific language governing permissionTypes and
 * limitationTypes under the License.
 */
package org.apache.pluto.descriptors.servlet;

import org.apache.pluto.om.servlet.ErrorPage;

/**
 * <B>TODO</B>: Document
 * @version $Id: ErrorPageDD.java 156636 2005-03-09 12:16:31Z cziegeler $
 * @since Mar 4, 2005
 */
public class ErrorPageDD implements ErrorPage {

    private String errorCode;
    private String exceptionType;
    private String location;

    public ErrorPageDD() {

    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ErrorPage#getErrorCode()
	 */
    public String getErrorCode() {
        return errorCode;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ErrorPage#setErrorCode(java.lang.String)
	 */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ErrorPage#getExceptionType()
	 */
    public String getExceptionType() {
        return exceptionType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ErrorPage#setExceptionType(java.lang.String)
	 */
    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ErrorPage#getLocation()
	 */
    public String getLocation() {
        return location;
    }

    /* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.servlet.ErrorPage#setLocation(java.lang.String)
	 */
    public void setLocation(String location) {
        this.location = location;
    }

}

