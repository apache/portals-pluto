package org.apache.pluto.portalImpl.portlet.test;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public abstract class AbstractReflectivePortletTest implements PortletTest {

    public TestResults doTest(PortletContext context,
                              PortletRequest req,
                              PortletResponse res) {
        TestResults results = new TestResults(getTestSuiteName());
        
        Class klass = getClass();
        Method[] methods = klass.getDeclaredMethods();

        for(int i = 0; i<methods.length;i++) {
            if(methods[i].getName().startsWith("check")) {
                try {
                    results.add(invoke(methods[i], context, req, res));
                }
                catch(Exception e) {
                    e.printStackTrace();
                    TestResult result = new TestResult();
                    result.setName(methods[i].getName());
                    result.setDesc("Unknown");
                    result.setReturnCode(TestResult.FAILED);
                    result.setResults(e.getMessage());
                    results.add(result);
                }
            }
        }
        return results;
    }
    
    public TestResult invoke(Method method, PortletContext context,
                             PortletRequest req, PortletResponse res)
    throws IllegalAccessException, InvocationTargetException {

        TestResult result = null;
        Class[] paramTypes= method.getParameterTypes();
        Object[] paramValues = new Object[paramTypes.length];

        for(int i=0;i<paramTypes.length;i++) {
            if(paramTypes[i].equals(PortletContext.class)) {
                paramValues[i] = context;
            }
            if(paramTypes[i].equals(PortletRequest.class)) {
                paramValues[i] = req;
            }
            if(paramTypes[i].equals(PortletResponse.class)) {
                paramValues[i] = res;
            }
            if(paramTypes[i].equals(PortletSession.class)) {
                paramValues[i] = req.getPortletSession();
            }
            result = (TestResult)method.invoke(this, paramValues);
        }
        return result;
    }

    public Map getRenderParameters(PortletRequest req) {
        Map map = new java.util.HashMap();
        return map;
    }
}
