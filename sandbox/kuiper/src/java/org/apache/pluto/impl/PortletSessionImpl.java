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

/** PortletSession implementation.  Leverages the decorated
 *  HttpSession wherever possible.
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 4, 2004 at 10:00:57 PM
 */
public class PortletSessionImpl implements PortletSession {

    /** Decorated session. */
    private HttpSession session;

    /** The portlet prefix which identifies us. */
    private String prefix;

    /** The PortletContext in which we reside. */
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

    /** Retrieve the attribute (within portlet scope)
     *  with the given key.
     */
    public Object getAttribute(String s) {
        return getAttribute(s, PORTLET_SCOPE);
    }

    /** Retrieve the attribute with the given key
     *  and scope.
     * @param s
     * @param i
     * @return
     */
    public Object getAttribute(String s, int i) {
        if(i==PortletSession.APPLICATION_SCOPE) {
            return session.getAttribute(s);
        }
        else {
            return session.getAttribute(prefix+s);
        }
    }

    /** Retrieve all of the attribute names
     *  which reside within Portlet scope.
     * @return
     */
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

    /** Retrieve the time at which the
     *  underlying session was created.
     * @return
     */
    public long getCreationTime() {
        return session.getCreationTime();
    }

    /** Retrieve the id of the underlying session. */
    public String getId() {
        return session.getId();
    }

    /** Retrieve the last time this session was accessed. */
    public long getLastAccessedTime() {
        return session.getLastAccessedTime();
    }

    /** Retrieve the maximum timeout interval of
     *  the underlying session.
     * @return
     */
    public int getMaxInactiveInterval() {
        return session.getMaxInactiveInterval();
    }

    /** Invalidate this and the underlying session. */
    public void invalidate() {
        session.invalidate();
    }

    /** Determine if the underlying session is new. */
    public boolean isNew() {
        return session.isNew();
    }

    /** Remove the named attribute. */
    public void removeAttribute(String s) {
        removeAttribute(s, PortletSession.PORTLET_SCOPE);
    }

    /** Remove the named attribute in the given scope. */
    public void removeAttribute(String s, int i) {
        if(i==PortletSession.APPLICATION_SCOPE) {
            session.removeAttribute(s);
        }
        else {
            session.removeAttribute(prefix+s);
        }
    }

    /** Set the attribute with the given name
     *  and value.
     * @param s
     * @param o
     */
    public void setAttribute(String s, Object o) {
        setAttribute(s,o,PortletSession.PORTLET_SCOPE);
    }

    /** Set the attribute with the given name,
     *  value and scope.
     * @param s
     * @param o
     * @param i
     */
    public void setAttribute(String s, Object o, int i) {
        if(i==PortletSession.APPLICATION_SCOPE) {
            session.setAttribute(s,o);
        }
        else {
            session.setAttribute(prefix+s,o);
        }
    }

    /** Set the maximum inactive interval for the
     *  underlying session.
     * @param i
     */
    public void setMaxInactiveInterval(int i) {
        session.setMaxInactiveInterval(i);
    }

    public PortletContext getPortletContext() {
        return context;
    }
}
