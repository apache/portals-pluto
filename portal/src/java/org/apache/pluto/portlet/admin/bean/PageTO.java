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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.pluto.portalImpl.om.page.impl.FragmentImpl;
import org.apache.pluto.portlet.admin.BaseAdminObject;

/**
 * A Transfer Object repesenting a page in pageregistry.xml
 * where the fragment type equals page. It is used to decouple
 * the XML persistence model from the JSP view.
 *
 * @author Craig Doremus
 *
 */
public class PageTO extends BaseAdminObject {

	public static final String CLASS_NAME = "PageTO";

	private FragmentImpl _page = null;
	//By default there will be one row and one col
	private int _rows = 1;
	private int _cols = 1;
	private String _name = "";
	private String _title = "";
	private String _description = "";
	private List _portlets = new ArrayList();


	/**
	 *
	 */
	public PageTO() {
		super(CLASS_NAME);
	}
	/**
	 *
	 */
	public PageTO(FragmentImpl page) {
		super(CLASS_NAME);
		_page = page;
	}

	/**
	 * @return Returns the cols.
	 */
	public int getCols() {
		return _cols;
	}
	/**
	/**
	 * @return Returns the page.
	 */
	public FragmentImpl getPage() {
		return _page;
	}
	/**
	 * @param page The page to set.
	 */
	public void setPage(FragmentImpl page) {
		_page = page;
		_name = page.getName();
	}
	/**
	 * @return Returns the rows.
	 */
	public int getRows() {
		return _rows;
	}

	/**
	 * @param cols The cols to set.
	 */
	public void setCols(int cols) {
		_cols = cols;
	}
	/**
	 * @param rows The rows to set.
	 */
	public void setRows(int rows) {
		_rows = rows;
	}
	public String getName() {
	    return _name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		_name = name;
	}
	public String getTitle(){
	    return _title;
	}

/*
	public void printFragment(FragmentType frag) {
		final String METHOD_NAME = "printFragment()";
		List frags = frag.getFragmentOrNavigationOrProperty();
		Iterator iter = frags.iterator();
		int count = 0;
		while (iter.hasNext()) {
			count++;
			try {
				FragmentType element = (FragmentType) iter.next();
				logDebug(METHOD_NAME, "Fragment: " + element.getName() + " type: " + element.getTypeattr());
			} catch (ClassCastException e) {
				logDebug(METHOD_NAME, "Not a fragment: ");
			}
			logDebug(METHOD_NAME, "Element number: " + count);
		}
	}
*/

/*
	public void recursePageFragment(FragmentType pagefragment) {
		final String METHOD_NAME = "recurseFragment(pagefragment)";
		List frags = pagefragment.getFragmentOrNavigationOrProperty();
		Iterator iter = frags.iterator();
		int count = 0;
		while (iter.hasNext()) {
			count++;
			try {
				FragmentType element = (FragmentType) iter.next();
				logDebug(METHOD_NAME, "Fragment: " + element.getName() + " type: " + element.getTypeattr());
			} catch (ClassCastException e) {
				logDebug(METHOD_NAME, "Not a fragment: ");
			}
			logDebug(METHOD_NAME, "Element number: " + count);
		}
	}
*/

	/**
	 *
	 * @param row
	 * @param col
	 * @return
	 */
	public PortletTO getPortlet(int row, int col) {
		PortletTO portlet = null;
		_portlets = getPortlets();
		Iterator iter = _portlets.iterator();
		while (iter.hasNext()) {
			PortletTO plet = (PortletTO) iter.next();
			if (plet.getRow() == row && plet.getCol() == col) {
				portlet = plet;
				break;
			}
		}
		return portlet;
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	public PortletTO getPortlet(String value) {
		final String METHOD_NAME = "getPortlet(value)";
		logMethodStart(METHOD_NAME);
		PortletTO portlet = null;
		Iterator iter = _portlets.iterator();
		while (iter.hasNext()) {
			PortletTO plet = (PortletTO) iter.next();
			if (plet.getValue().equals(value)) {
				portlet = plet;
				break;
			}
		}
		logMethodEnd(METHOD_NAME, portlet);
		return portlet;
	}


	/**
	 *
	 * @param value
	 * @return
	 */
	public PortletTO getPortletByCell(int row, int col) {
		final String METHOD_NAME = "getPortletByCell(row,col)";
		logMethodStart(METHOD_NAME);
		PortletTO portlet = null;
		Iterator iter = _portlets.iterator();
		while (iter.hasNext()) {
			PortletTO plet = (PortletTO) iter.next();
			if (plet.getRow() == row && plet.getCol() == col) {
				portlet = plet;
				break;
			}
		}
		logMethodEnd(METHOD_NAME, portlet);
		return portlet;
	}

	/**
	 * @return Returns the portlets.
	 */
	public List getPortlets() {
		return _portlets;
	}

	/**
	 * @param portlets The portlets to set.
	 */
	public void setPortlets(List portlets) {
		_portlets = portlets;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		_description = description;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		_title = title;
	}
	/**
	 * @return Returns the portlets.
	 */
	public String getDescription() {
		return _description;
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Page[ ");
		sb.append(_title);
		sb.append(" Rows=");
		sb.append(_rows);
		sb.append(" Cols=");
		sb.append(_cols);
		sb.append(" Portlets[ ");
		Iterator iter = _portlets.iterator();
		while (iter.hasNext()) {
			PortletTO element = (PortletTO) iter.next();
			sb.append(element + " ");
		}
		sb.append("] ]");
		return sb.toString();
	}
}
