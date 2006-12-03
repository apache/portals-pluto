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
package org.apache.pluto.util.publish;

import org.apache.pluto.util.UtilityException;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Dec 5, 2005
 */
public class PublishException extends UtilityException {

    public PublishException() {
    }

    public PublishException(String message) {
        super(message);
    }

    public PublishException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublishException(Throwable cause) {
        super(cause);
    }
}
