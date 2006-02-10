/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
package org.apache.pluto.testsuite;

import java.io.Serializable;

/**
 * The test result represents the result of one test method.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class TestResult implements Serializable {

    public static final String PASSED = "Passed";
    public static final String FAILED = "Failed";
    public static final String WARNING = "Warning";
    
    
    // Private Member Variables ------------------------------------------------
    
    /** The name of the test. */
    private String name = null;
    
    /** The description of the test. */
    private String description = "[unknown]";
    
    /** The return code of the test result: PASSED, WARNING, FAILED. */
    private String returnCode;
    
    /** The message of the test result. */
    private String resultMessage ="[unknown]";
    
    
    // Public Methods ----------------------------------------------------------
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    /**
     * @deprecated use getDescription()
     */
    public String getDesc() {
        return getDescription();
    }
    
    /**
     * @deprecated use setDescription(String)
     */
    public void setDesc(String desc) {
    	setDescription(desc);
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    
    public String getResultMessage() {
    	return resultMessage;
    }
    
    public void setResultMessage(String resultMessage) {
    	this.resultMessage = resultMessage;
    }
    
    /**
     * @deprecated use getResultMessage()
     */
    public String getResults() {
        return getResultMessage();
    }
    
    /**
     * @deprecated use setResultMessage(String)
     */
    public void setResults(String results) {
        setResultMessage(results);
    }
    
    
    // Object Methods ----------------------------------------------------------
    
    /**
     * Override of toString() that prints out name and results values.
     * @see java.lang.Object#toString()
     */
    public String toString(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append(getClass().getName());
    	buffer.append("[name=").append(name);
    	buffer.append(";returnCode=").append(returnCode);
    	buffer.append(";resultMessage=").append(resultMessage).append("]");    	
    	return buffer.toString();
    }
    
}
