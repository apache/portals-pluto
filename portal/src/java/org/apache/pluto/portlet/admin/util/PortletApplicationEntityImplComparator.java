/*
 * Copyright 2003,2004,2005 The Apache Software Foundation.
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
package org.apache.pluto.portlet.admin.util;

import java.util.Comparator;

import org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityImpl;
import org.apache.pluto.portlet.admin.BaseAdminObject;

/**
 * Implementation of Comparator for comparing Castor
 * PortletApplicationEntityImp instances.
 * .
 *
 * @author Craig Doremus
 * @see org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityImpl
 */
public class PortletApplicationEntityImplComparator extends BaseAdminObject implements Comparator {

	private static final String CLASS_NAME = "PortletApplicationEntityImplComparator";
	public PortletApplicationEntityImplComparator() {
		super(CLASS_NAME);
	}
	/**
	 * Implementation method
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object obj1, Object obj2) {
		if (!(obj1 instanceof PortletApplicationEntityImpl) || !(obj2 instanceof PortletApplicationEntityImpl)) {
			throw new ClassCastException("Wrong class type used for PortletApplicationEntityImplComparator");
		} else {
			PortletApplicationEntityImpl app1 = (PortletApplicationEntityImpl)obj1;
			Integer app1ID = new Integer(Integer.parseInt(app1.getCastorId()));
			PortletApplicationEntityImpl app2 = (PortletApplicationEntityImpl)obj2;
			Integer app2ID = new Integer(Integer.parseInt(app2.getCastorId()));
			return app1ID.compareTo(app2ID);
		}
	}

}
