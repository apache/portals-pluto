package org.apache.pluto.portalImpl.portlet.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class TestResults {

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
