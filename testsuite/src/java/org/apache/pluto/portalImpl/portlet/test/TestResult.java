package org.apache.pluto.portalImpl.portlet.test;

/**
 * @author <a href="david.dewolf@vivare.com">David H. DeWolf</a>
 */
public class TestResult {

    public static final String PASSED = "Passed";
    public static final String FAILED = "Failed";
    public static final String WARNING = "Warning";

    private String name;
    private String desc;
    private String returnCode;
    private String results ="uknown";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

}
