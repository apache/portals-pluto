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
/* 

 */

package org.apache.pluto.portalImpl.om.page.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletConfig;

import org.apache.pluto.portalImpl.om.page.Fragment;
import org.apache.pluto.portalImpl.om.page.Navigation;
import org.apache.pluto.portalImpl.services.log.Log;
import org.apache.pluto.util.StringUtils;

public class FragmentImpl implements Fragment, java.io.Serializable {

    private String name;
    private String classname;
    private String type;
    private Navigation navigation;
    private ArrayList fragments;
    private ArrayList properties;

    public FragmentImpl()
    {
        name = "";
        fragments = new ArrayList();
        properties = new ArrayList();
    }

    // Fragment implementation.

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getClassname()
    {
        return classname;
    }

    public void setClassname(String classname)
    {
        this.classname = classname;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Navigation getNavigation()
    {
        return navigation;
    }

    public void setNavigation(Navigation navigation)
    {
        this.navigation = navigation;
    }

    public Collection getFragments()
    {
        return fragments;
    }

    public Collection getProperties()
    {
        return properties;
    }

    // additional methods.
    
    public void setFragments(Collection fragments)
    {
        this.fragments = new ArrayList(fragments);
    }

    public org.apache.pluto.portalImpl.aggregation.Fragment build(ServletConfig config, 
                                                                  org.apache.pluto.portalImpl.aggregation.Fragment fragmentParent)
    throws Exception
    {        
        org.apache.pluto.portalImpl.aggregation.navigation.Navigation 
        nav = fragmentParent.getNavigation();
        // create navigation class, if navigational information is available
        if (navigation!=null) {
            nav = new org.apache.pluto.portalImpl.aggregation.navigation.Navigation(fragmentParent.getNavigation(),
                                                                                    navigation);
        }

        org.apache.pluto.portalImpl.aggregation.Fragment fragment = null;
        if (classname == null) {
            if (type == null) {
                Log.error("No type defined in pageregistry.xml");
                return null;
            }
            if (type.equalsIgnoreCase("page")) {
                fragment = new org.apache.pluto.portalImpl.aggregation.PageFragment(getName(),
                                                                                    config,
                                                                                    fragmentParent,
                                                                                    this,
                                                                                    nav);
            } else if (type.equalsIgnoreCase("row")) {
                fragment = new org.apache.pluto.portalImpl.aggregation.RowFragment(getName(),
                                                                                   config,
                                                                                   fragmentParent,
                                                                                   this,
                                                                                   nav);
            } else if (type.equalsIgnoreCase("column")) {
                fragment = new org.apache.pluto.portalImpl.aggregation.ColumnFragment(getName(),
                                                                                      config,
                                                                                      fragmentParent,
                                                                                      this,
                                                                                      nav);
            } else if (type.equalsIgnoreCase("portlet")) {
                fragment = new org.apache.pluto.portalImpl.aggregation.PortletFragment(getName(),
                                                                                       config,
                                                                                       fragmentParent,
                                                                                       this,
                                                                                       nav);
            } else {
                Log.error("Unknown type "+type+" defined in pageregistry.xml");
                return null;
            }
        } else {
            // create fragment class
            Class[] parameterClasses = {
                String.class,
                ServletConfig.class, 
                org.apache.pluto.portalImpl.aggregation.Fragment.class, 
                org.apache.pluto.portalImpl.om.page.Fragment.class,
                org.apache.pluto.portalImpl.aggregation.navigation.Navigation.class
            };
            Constructor constructor = null;
            try {
                constructor = Class.forName(classname).getConstructor(parameterClasses);
            } catch (NoSuchMethodException e) {
                Log.error("Invalid class or classname defined in pageregistry.xml",e);
                return null;
            } catch (ClassNotFoundException e) {
                Log.error("Invalid class or classname defined in pageregistry.xml",e);
                return null;
            }
            Object[] parameters = {
                getName(),
                config,
                fragmentParent,
                this,
                nav
            };
            try {
                Object _fragment = constructor.newInstance(parameters);
                if (!(_fragment instanceof org.apache.pluto.portalImpl.aggregation.Fragment)) {
                    Log.error("Invalid class or classname defined in pageregistry.xml");
                    return null;
                }
                fragment = (org.apache.pluto.portalImpl.aggregation.Fragment)_fragment;
            } catch (InstantiationException e) {
                Log.error("Invalid class or classname defined in pageregistry.xml",e);
                return null;
            } catch (IllegalAccessException e) {
                Log.error("Invalid class or classname defined in pageregistry.xml",e);
                return null;
            } catch (InvocationTargetException e) {
                Log.error("Invalid class or classname defined in pageregistry.xml",e);
                return null;
            }
        }        

        // bind all data to the newly created navigational object
        if (navigation!=null) {
            nav.setLinkedFragment(fragment);
        }

        // create next level of fragments
        Iterator iterator = fragments.iterator();

        while (iterator.hasNext()) {
            FragmentImpl fragmentimpl = (FragmentImpl)iterator.next();

            org.apache.pluto.portalImpl.aggregation.Fragment _fragment = 
            fragmentimpl.build(config, fragment);
            if (_fragment != null) {
                fragment.addChild(_fragment);
            }
        }

        return fragment;
    }

    public String toString()
    {
        return toString(0);
    }

    public String toString(int indent)
    {
        StringBuffer buffer = new StringBuffer(1000);
        StringUtils.newLine(buffer,indent);
        buffer.append(getClass().toString()); buffer.append(":");
        StringUtils.newLine(buffer,indent);
        buffer.append("{");
        StringUtils.newLine(buffer,indent);
        buffer.append("name='");
        buffer.append(name);
        buffer.append("'");
        if (classname!=null) {
            StringUtils.newLine(buffer,indent);
            buffer.append("classname='");
            buffer.append(classname);
            buffer.append("'");
        }
        if (type!=null) {
            StringUtils.newLine(buffer,indent);
            buffer.append("type='");
            buffer.append(type);
            buffer.append("'");
        }
        if (navigation!=null) {
            StringUtils.newLine(buffer,indent);
            buffer.append("Navigation:");
            buffer.append(((NavigationImpl)navigation).toString(indent));
        }
        Iterator iterator = properties.iterator();
        if (iterator.hasNext()) {
            StringUtils.newLine(buffer,indent);
            buffer.append("Properties:");
        }
        while (iterator.hasNext()) {
            buffer.append(((PropertyImpl)iterator.next()).toString(indent));
        }
        iterator = fragments.iterator();
        if (iterator.hasNext()) {
            StringUtils.newLine(buffer,indent);
            buffer.append("Fragments:");
        }
        while (iterator.hasNext()) {
            buffer.append(((FragmentImpl)iterator.next()).toString(indent+2));
        }
        StringUtils.newLine(buffer,indent);
        buffer.append("}");
        return buffer.toString();
    }

}
