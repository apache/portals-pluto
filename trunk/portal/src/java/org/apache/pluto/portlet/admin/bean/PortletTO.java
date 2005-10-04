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
package org.apache.pluto.portlet.admin.bean;

import org.apache.pluto.portlet.admin.BaseAdminObject;

/**
 * A Transfer Object repesenting a portlet in pageregistry.xml
 * where the fragment type equals portlet. It is used to decouple
 * the XML persistence model from the JSP view.
 *
 * @author Craig Doremus
 *
 */
public class PortletTO extends BaseAdminObject implements Comparable {
	private static final String CLASS_NAME = "PortletTO";
	private String _name = "";
	//Value is appID.portletID
	private String _value;
	//row in column in the page layout
	private int _row = 1;
	private int _col = 1;

	/*
	 * Default constuctor
	 */
	public PortletTO(){
		super(CLASS_NAME);
	}

	/**
	 *
	 *
	 * @param name
	 * @param value
	 * @param row
	 * @param col
	 */
	public PortletTO(String name, String value, int row, int col) {
		super(CLASS_NAME);
		_name = name;
		_value = value;
		_row = row;
		_col = col;
	}


	/**
	 * @return Returns the col.
	 */
	public int getCol() {
		return _col;
	}
	/**
	 * @param col The col to set.
	 */
	public void setCol(int col) {
		_col = col;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return _name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		_name = name;
	}
	/**
	 * @return Returns the row.
	 */
	public int getRow() {
		return _row;
	}
	/**
	 * @param row The row to set.
	 */
	public void setRow(int row) {
		_row = row;
	}
	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return _value;
	}
	/**
	 * @param value The value to set.
	 */
	public void setValue(String value) {
		_value = value;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("portlet[");
		sb.append(_name);
		sb.append("=");
		sb.append(_value);
		sb.append(" ; row: ");
		sb.append(_row);
		sb.append(" col: ");
		sb.append(_col);
		sb.append("] ");
		return sb.toString();
	}
	/**
	 * Implemented to portlets to show in correct row/column order
	 * in the user interface.
	 *
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object p_portlet) {
		int retVal = 0;
		PortletTO portlet = (PortletTO)p_portlet;
		int p_row = portlet.getRow();
		if (_row > p_row) {
			retVal = 1;
		} else if (_row < p_row){
			retVal = -1;
		} else {
			int p_col = portlet.getCol();
			if (_col > p_col) {
				retVal = 1;
			} else if (_col < p_col) {
				retVal = -1;
			}
		}
		return retVal;
	}
}
