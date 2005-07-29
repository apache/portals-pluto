package org.apache.pluto.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by IntelliJ IDEA. User: David Date: Jun 3, 2005 Time: 9:26:17 PM To
 * change this template use File | Settings | File Templates.
 */
public class ArgumentUtility {

    public static final Log LOG = LogFactory.getLog(ArgumentUtility.class);

    public static void validateNotNull(String argumentName, Object argument)
    throws IllegalArgumentException {
        if(argument == null) {
            IllegalArgumentException exception =
                new IllegalArgumentException("Illegal Argument: "+argumentName+". Argument may not be null.");
            if(LOG.isInfoEnabled()) {
                LOG.info("Validation Error for argument: "+argumentName+". Argument may not be null.", exception);
            }
            throw exception;
        }
    }

    public static void validateNotEmpty(String argumentName, String argument) {
        if(argument == null || "".equals(argument)) {
            IllegalArgumentException exception =
                new IllegalArgumentException("Illegal Argument: "+argumentName+". Argument may not be null or empty.");
            if(LOG.isInfoEnabled()) {
                LOG.info("Validation Error for argument: "+argumentName+". Argument may not be null or empty.", exception);
            }
            throw exception;
        }
    }
}
