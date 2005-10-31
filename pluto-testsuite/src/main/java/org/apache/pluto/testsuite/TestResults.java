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

import org.apache.pluto.testsuite.TestResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.io.Serializable;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class TestResults implements Serializable {

    private String name;
    private ArrayList list = new ArrayList();
    private boolean failed;
    private boolean inQuestion;

    public TestResults(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(TestResult res) {
        if(TestResult.FAILED.equals(res.getReturnCode())) {
            failed = true;
        }
        if(TestResult.WARNING.equals(res.getReturnCode())) {
            inQuestion = true;
        }
        list.add(res);
    }

    public boolean isFailed() {
        return failed;
    }

    public boolean isInQuestion() {
        return inQuestion;
    }

    public Collection getCollection() {
        return Collections.unmodifiableCollection(list);
    }

}
