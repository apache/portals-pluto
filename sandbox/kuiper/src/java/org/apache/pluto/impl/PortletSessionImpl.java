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

package org.apache.pluto.impl;

import javax.portlet.PortletSession;
import javax.portlet.PortletContext;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 10:00:57 PM
 */
public class PortletSessionImpl implements PortletSession {
    
    private HttpSession session;
    private String prefix;
    private PortletContext context;

    /** Constructs a PortletSessionImpl for the given
     *  PortletContext, windowID, and HttpSession.
     *
     * @param context
     * @param windowID
     * @param session
     */
    public PortletSessionImpl(PortletContext context,
                              String windowID,
                              HttpSession session) {
        this.context = context;
        this.prefix = "javax.portlet.p."+windowID+"?";
        this.session = session;
    }
    
    public Object getAttribute(String s) {
        return getAttribute(s, PORTLET_SCOPE);
    }

    public Object getAttribute(String s, int i) {
        if(i==PortletSession.APPLICATION_SCOPE) {
            return session.getAttribute(s);
        }
        else {
            return session.getAttribute(prefix+s);
        }
    }

    public Enumeration getAttributeNames() {
        return getAttributeNames(PortletSession.PORTLET_SCOPE);
    }

    /** Returns an Enumeration of String objects containing
     *  the names of all the objects bound to this session
     *  in the given scope, or an empty Enumeration if no
     *  attributes are available in the given scope.
     *
     */
    public Enumeration getAttributeNames(int i) {
        if(i==PortletSession.APPLICATION_SCOPE) {
            return session.getAttributeNames();
        }
        else {
            Vector returnValues = new Vector();
            Enumeration enum = session.getAttributeNames();
            while(enum.hasMoreElements()) {
            String name = (String)enum.nextElement();
                if(name.startsWith(prefix)) {
                    returnValues.add(name.substring(prefix.length()));
                }
            }
            return returnValues.elements();
        }
    }

    public long getCreationTime() {
        return session.getCreationTime();
    }

    public String getId() {
        return session.getId();
    }

    public long getLastAccessedTime() {
        return session.getLastAccessedTime();
    }

    public int getMaxInactiveInterval() {
        return session.getMaxInactiveInterval();
    }

    public void invalidate() {
        session.invalidate();
    }

    public boolean isNew() {
        return session.isNew();
    }

    public void removeAttribute(String s) {
        removeAttribute(s, PortletSession.PORTLET_SCOPE);
    }

    public void removeAttribute(String s, int i) {
        if(i==PortletSession.APPLICATION_SCOPE) {
            session.removeAttribute(s);
        }
        else {
            session.removeAttribute(prefix+s);
        }
    }

    public void setAttribute(String s, Object o) {
        setAttribute(s,o,PortletSession.PORTLET_SCOPE);
    }

    public void setAttribute(String s, Object o, int i) {
        if(i==PortletSession.APPLICATION_SCOPE) {
            session.setAttribute(s,o);
        }
        else {
            session.setAttribute(prefix+s,o);
        }
    }

    public void setMaxInactiveInterval(int i) {
        session.setMaxInactiveInterval(i);
    }

    public PortletContext getPortletContext() {
        return context;
    }
}
