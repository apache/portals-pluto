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

package org.apache.pluto.internal.impl;

import javax.portlet.Event;

/**
 * Implementation of JSR-286 <code>Event</code>.
 *
 * @since 2.0
 */
public class EventImpl implements Event {

	private String _name;
	private Object _value;
	
	public EventImpl(String name){
		_name = name;
	}
	
	public EventImpl(String name, Object value){
		this(name);
		_value = value;
	}

	public String getName() {
		return _name;
	}

	public Object getValue() {
		return _value;
	}
}
