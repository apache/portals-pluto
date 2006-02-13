package org.apache.pluto.testsuite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Static class that provides utility methods for Pluto testsuite.
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @since 2006-02-13
 */
public class TestUtils {
	
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(TestUtils.class);
	
	
	// Private Constructor -----------------------------------------------------
	
	/**
	 * Private method that prevents external instantiation.
	 */
	private TestUtils() {
		// Do nothing.
	}
	
	
	// Public Static Methods ---------------------------------------------------
	
	/**
	 * Sets the test result return code to <code>FAILED</code>, and reports
	 * assertion details by specifying values got and values expected.
	 * @param valueName  the name of the values to assert.
	 * @param valueGot  the values got.
	 * @param valueExpected  the values expected.
	 * @param result  the test result.
	 */
	public static void failOnAssertion(String valuesName,
	                                   String[] valuesGot,
	                                   String[] valuesExpected,
	                                   TestResult result) {
		failOnAssertion(valuesName,
		                arrayToString(valuesGot),
		                arrayToString(valuesExpected),
		                result);
	}
	
	/**
	 * Sets the test result return code to <code>FAILED</code>, and reports
	 * assertion details by specifying value got and value expected.
	 * @param valueName  the name of the value to assert.
	 * @param valueGot  the value got.
	 * @param valueExpected  the value expected.
	 * @param result  the test result.
	 */
	public static void failOnAssertion(String valueName,
	                                   String valueGot,
	                                   String valueExpected,
	                                   TestResult result) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Assertion failed: ");
		buffer.append("got ").append(valueName).append(": ").append(valueGot);
		buffer.append(", expected: ").append(valueExpected);
    	result.setReturnCode(TestResult.FAILED);
    	result.setResultMessage(buffer.toString());
	}
	
    /**
     * Sets the test result return code to <code>FAILED</code>, and reports
     * exception details.
     * @param message  the error message.
     * @param cause  the cause exception.
     * @param result  the test result.
     */
    public static void failOnException(String message,
                                       Throwable cause,
                                       TestResult result) {
    	// Construct error message.
    	StringBuffer buffer = new StringBuffer();
    	if (message != null) {
    		buffer.append(message);
    	} else {
    		buffer.append("Exception occurred.");
    	}
    	buffer.append(" Cause (").append(cause.getClass().getName()).append("): ");
    	buffer.append(cause.getMessage());
    	
    	// Log error message.
    	if (LOG.isErrorEnabled()) {
    		LOG.error(buffer.toString(), cause);
    	}
    	
    	// Set error message to test result.
    	result.setReturnCode(TestResult.FAILED);
    	result.setResultMessage(buffer.toString());
    }
    
    
    // Private Static Methods --------------------------------------------------
    
    /**
     * Converts a string array to a string.
     * @param values  the string array to convert.
     * @return a string representing the values in the string array.
     */
    private static String arrayToString(String[] values) {
		StringBuffer buffer = new StringBuffer();
		if (values == null) {
			buffer.append("null");
		} else {
			buffer.append("{");
			for (int i = 0; i < values.length; i++) {
				buffer.append(values[i]);
				if (i < values.length - 1) {
					buffer.append(",");
				}
			}
			buffer.append("}");
		}
    	return buffer.toString();
    }
    
	
}
