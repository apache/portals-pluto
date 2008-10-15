/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pluto.om;

import java.util.ArrayList;

/**
 * @version $Id$
 *
 */
public class ElementFactoryList<E> extends ArrayList<E>
{
    private static final long serialVersionUID = 8828577482341849961L;

    public interface Factory<E>
    {
        public E newElement();
        public Class<? extends E> getElementClass();
    }
    
    private Factory<E> factory;
    
    public ElementFactoryList(Factory<E> factory)
    {
        super();
    }
    
    public E newElement()
    {
        return factory.newElement();
    }
    
    private void checkElementType(E element)
    {
        if (element == null)
        {
            throw new NullPointerException("Adding or setting a null value not allowed.");
        }
        if (element.getClass() != factory.getElementClass())
        {
            throw new IllegalArgumentException("Incorrect object type: "+element.getClass().getName()+". Required type: "+factory.getElementClass().getName()+".");
        }
    }

    @Override
    public boolean add(E element)
    {
        checkElementType(element);
        return super.add(element);
    }

    @Override
    public void add(int index, E element)
    {
        checkElementType(element);
        super.add(index, element);
    }

    @Override
    public E set(int index, E element)
    {
        checkElementType(element);
        return super.set(index, element);
    }
}
