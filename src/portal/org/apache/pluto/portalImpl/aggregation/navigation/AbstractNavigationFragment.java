/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2003 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Pluto", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
/* 

 */

package org.apache.pluto.portalImpl.aggregation.navigation;

import javax.servlet.ServletConfig;

import org.apache.pluto.portalImpl.aggregation.AbstractFragmentSingle;
import org.apache.pluto.portalImpl.core.PortalURL;

public abstract class AbstractNavigationFragment extends AbstractFragmentSingle
{

    public AbstractNavigationFragment(String id,
                                      ServletConfig config, 
                                      org.apache.pluto.portalImpl.aggregation.Fragment parent,
                                      org.apache.pluto.portalImpl.om.page.Fragment fragDesc,
                                      org.apache.pluto.portalImpl.aggregation.navigation.Navigation navigation)
    throws Exception 
    {
        super(id, config, parent, fragDesc, navigation);
    }

    public void createURL(PortalURL url)
    {
        getParent().createURL(url);
        url.addGlobalNavigation(getId());
    }

    public boolean isPartOfURL(PortalURL url)
    {
        return url.isPartOfGlobalNavigation(getId());
    }

    public org.apache.pluto.portalImpl.aggregation.navigation.Navigation getRootNavigation()
    {
        org.apache.pluto.portalImpl.aggregation.Fragment returnvalue = this;
        for (; returnvalue.getParent() != null; returnvalue = returnvalue.getParent()) {
        }
        return returnvalue.getNavigation();
    }

    /**
     * If the given parent is NULL, the method returns the first fragment containing
     * navigational information after the root element.
     * <P>
     * if the given parent points to a fragment, the method returns the first child
     * fragment that contains navigational information
     * 
     * @param parent the parent fragment or NULL
     * @return Returns the first fragment that contains navigational information.
     */
/*
    public org.apache.pluto.portalImpl.aggregation.Fragment 
        getFirstNavigation(org.apache.pluto.portalImpl.aggregation.Fragment parent)
    {
        org.apache.pluto.portalImpl.aggregation.Fragment returnvalue = null;
        if (parent==null)
        {
            returnvalue = this;
            // get root fragment...this does not need to have a navigation
            for (; returnvalue.getParent()!=null; returnvalue = returnvalue.getParent()) {}
            
            // root element does not have a navigation information
            if (returnvalue.getNavigation()==null)
            {
                returnvalue = getFirstNavigation(returnvalue);
            }

        }
        else
        {
            Iterator iterator = parent.getChildFragments().iterator();
            while (iterator.hasNext())
            {
                org.apache.pluto.portalImpl.aggregation.Fragment fragment =
                    (org.apache.pluto.portalImpl.aggregation.Fragment)iterator.next();
                if (fragment.getNavigation()!=null)
                {
                    returnvalue = fragment;
                    break;
                }
            }

            // no fragment with navigational information found yet, so try a deep search
            if (returnvalue==null)
            {
                iterator = parent.getChildFragments().iterator();
                while (iterator.hasNext())
                {
                    org.apache.pluto.portalImpl.aggregation.Fragment fragment =
                        (org.apache.pluto.portalImpl.aggregation.Fragment)iterator.next();

                    returnvalue = getFirstNavigation(fragment);

                    if (returnvalue!=null)
                        break;

                }

            }

        }
        return returnvalue;
    }

    public org.apache.pluto.portalImpl.aggregation.Fragment 
        getNextNavigation(org.apache.pluto.portalImpl.aggregation.Fragment previous)
    {
        if (previous==null)
            throw new IllegalArgumentException("previous navigation mus not be null!");


        return null;
    }
*/
}
