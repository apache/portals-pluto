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
package org.apache.pluto.tags.el;

import javax.servlet.jsp.el.ExpressionEvaluator;
import javax.servlet.jsp.el.ELException;
import javax.servlet.jsp.JspException;


public class ParamTag extends org.apache.pluto.tags.ParamTag {
	
	private static final long serialVersionUID=286L;

    public String getValue() throws JspException {
        String string = super.getValue();

        ExpressionEvaluator eval = pageContext.getExpressionEvaluator();

        try {
            Object evaluated = eval.evaluate(
                    string,
                    Object.class,
                    pageContext.getVariableResolver(),
                    null
            );

            if(evaluated != null) {
                string = evaluated.toString();
            }

        }
        catch(ELException el) {
            throw new JspException(el);
        }
        return string;
    }

}
