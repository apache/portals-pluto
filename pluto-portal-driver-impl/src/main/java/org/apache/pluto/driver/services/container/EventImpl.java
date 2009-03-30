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
package org.apache.pluto.driver.services.container;

import javax.portlet.Event;
import javax.xml.namespace.QName;

/**
 * Implementation of JSR-286 <code>Event</code>.
 *
 * @since 2.0
 */
public class EventImpl implements Event {

	private QName _qname;
	private java.io.Serializable _value;
	
	public EventImpl(QName qname){
		_qname = qname;
	}
	
	public EventImpl(QName qname, java.io.Serializable value){
		this(qname);
		_value = value;
	}

	public QName getQName() {
		return _qname;
	}

	public java.io.Serializable getValue() {
		return _value;
	}

	public String getName() {
		return _qname.getLocalPart();
	}
}
