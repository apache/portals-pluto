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
package org.apache.pluto.portlet.admin.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import org.apache.pluto.portalImpl.om.page.impl.FragmentImpl;
import org.apache.pluto.portalImpl.om.page.impl.PortalImpl;
import org.apache.pluto.portlet.admin.BaseAdminObject;
import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.bean.PageTO;
import org.apache.pluto.portlet.admin.bean.PortletTO;

/**
 * Service concerned with pageregistry.xml persistence
 *
 *
 * @author Craig Doremus
 * @see org.apache.pluto.portlet.admin.controller.PageRegistryPortlet
 *
 */
public class PageRegistryService extends BaseAdminObject {

	private static final String CLASS_NAME = "PageRegistryService";

//	private List _rows = new ArrayList();
//	private int _rowIndex = 1;
//	private List _cols = new ArrayList();
//	private int _colIndex = 1;

	/**
	 *
	 */
	public PageRegistryService() {
		super(CLASS_NAME);
	}

/*
	public Iterator getPageRegistry(String prPath) {
	    final String METHOD_NAME = "getPageRegistry(prPath)";
		List pages = new ArrayList();
		PageRegistryXao xao = new PageRegistryXao();
		List prpages = xao.getFragments(prPath);
		Iterator iter = prpages.iterator();
		while (iter.hasNext()) {
            FragmentType frag = (FragmentType) iter.next();
            //get rid of navigation fragment
            if(!frag.getName().equals("navigation")) {
                pages.add(frag);
            }
        }
	    logDebug(METHOD_NAME, "Page count: " + pages.size());
		return pages.iterator();
	}
*/

	public Iterator getPageRegistry() {
    final String METHOD_NAME = "getPageRegistry()";
		List pages = new ArrayList();
		PortalImpl portal;
		try {
			org.apache.pluto.portlet.admin.model.PageRegistryXao xao = new org.apache.pluto.portlet.admin.model.PageRegistryXao();
			portal = xao.load();
		} catch (Exception e) {
			PlutoAdminException pae = new PlutoAdminException(e);
			logError(CLASS_NAME, METHOD_NAME, e);
			throw pae;
		}
		Collection prpages = portal.getFragments();
		Iterator iter = prpages.iterator();
		while (iter.hasNext()) {
          FragmentImpl frag = (FragmentImpl) iter.next();
          //exclude navigation fragment
          if(!frag.getName().equals("navigation")) {
          	//fill a PageTO
          	PageTO page = new PageTO();
          	page.setName(frag.getName());
          	//figure out number of rows and columns
          	//rows first
          	Collection rfrags = frag.getFragments();
          	page.setTitle(frag.getNavigation().getTitle());
          	page.setDescription(frag.getNavigation().getDescription());
          	int rows = rfrags.size();
          	page.setRows(rows);
          	if (rows > 0) {
          		FragmentImpl row = (FragmentImpl)rfrags.iterator().next();
          		Collection cfrags = row.getFragments();
          		FragmentImpl col = (FragmentImpl)cfrags.iterator().next();
          		int cols = col.getFragments().size();
          		page.setCols(cols);
          	}
            pages.add(page);
          }
      }
    logDebug(METHOD_NAME, "Page count: " + pages.size());
	return pages.iterator();
	}

	/* *
	 * Get list for View page.
	 *
	 * @param prPath
	 * @return
	public List getPageVOList(String prPath) {
	    final String METHOD_NAME = "getPageVOList(prPath)";
	    logMethodStart(METHOD_NAME);
	    List pagevos = new ArrayList();
	    Iterator iter = getPageRegistry(prPath);
	    while (iter.hasNext()) {
            FragmentType frag = (FragmentType) iter.next();
            pagevos.add(new PageTO(frag));
        }
	    logMethodEnd(METHOD_NAME, "PageTO count: " + pagevos.size());
	    return pagevos;
	}
	 */

/*
	public FragmentType getPage(String prPath, String name) {
		FragmentType page = null;
		Iterator iter  = getPageRegistry(prPath);
		while (iter.hasNext()) {
            FragmentType frag = (FragmentType) iter.next();
            //get rid of navigation fragments
            if(frag.getName().equals(name)) {
                page = frag;
                break;
            }
        }
		return page;
	}
*/

/*
	public PageTO getPageVO(String prPath, String name){
		final String METHOD_NAME = "getPage(prPath,name)";
		logMethodStart(METHOD_NAME);
		PageTO page = null;
		List pages = getPageVOList(prPath);
		Iterator iter = pages.iterator();
		while (iter.hasNext()) {
			PageTO element = (PageTO) iter.next();
			if (element.getName().equals(name)) {
				page = element;
				break;
			}
		}
		logMethodEnd(METHOD_NAME, page);
		return page;
	}
*/

	public PageTO getPageVO(String name){
		final String METHOD_NAME = "getPageVO(name)";
		logMethodStart(METHOD_NAME);
		PageTO page = null;
		Iterator iter = getPageRegistry();
		while (iter.hasNext()) {
			PageTO element = (PageTO) iter.next();
			if (element.getName().equals(name)) {
				page = element;
				break;
			}
		}
		logMethodEnd(METHOD_NAME, page);
		return page;
	}


/*
	private List getPortletList(int index, PageTO page) {
		final String METHOD_NAME = "getPortletList(index,page)";
		logMethodStart(METHOD_NAME);
		logParam(METHOD_NAME, "index", index);
		logParam(METHOD_NAME, "page", page);
		List cplets = new ArrayList();
		List plets = page.getPortlets();
		logDebug(METHOD_NAME, "Portlet list: " + plets);
		Iterator iter = plets.iterator();
		while (iter.hasNext()) {
			PortletTO plet = (PortletTO) iter.next();
			if (plet.getCol() == index) {
				PropertyType prop = new PropertyTypeImpl();
				prop.setName(plet.getName());
				prop.setValue(plet.getValue());
				cplets.add(prop);
			}
		}
		logMethodEnd(METHOD_NAME, cplets);
		return cplets;
	}
*/

/*
	private void addRow() {
		final String METHOD_NAME = "addRow()";
		logMethodStart(METHOD_NAME);
		FragmentType frag = new FragmentTypeImpl();
		frag.setTypeattr("row");
		frag.setName("r" + _rowIndex);
		List list = frag.getFragmentOrNavigationOrProperty();
		list.addAll(_cols);
		_rows.add(frag);
		_rowIndex++;
		logMethodEnd(METHOD_NAME);
	}
*/

/*
	private void addCol(PageTO page) {
		final String METHOD_NAME = "addCol(page)";
		logMethodStart(METHOD_NAME);
		logParam(METHOD_NAME, "page", page);
		FragmentType frag = new FragmentTypeImpl();
		frag.setTypeattr("col");
		frag.setName("c" + _colIndex);
		List list = frag.getFragmentOrNavigationOrProperty();
		List portlets = getPortletList(_colIndex, page);
		list.addAll(portlets);
		_cols.add(frag);
		_colIndex++;
		logMethodEnd(METHOD_NAME);
	}
*/

	/**
	 * Gets the pages from pageregistry.xml for the View.
	 * @param prPath
	 * @param req
	 */
	public void getAllPages(RenderRequest req) {
		Iterator iter = getPageRegistry();
		req.setAttribute(PlutoAdminConstants.PAGE_LIST_ATTR, iter);
//		req.getPortletSession().removeAttribute(PlutoAdminConstants.PAGE_ATTR);
	}

	public void getPage(ActionRequest req) {
		String pageName = req.getParameter("pageName");
		PageTO page = getPageVO(pageName);
		req.getPortletSession().setAttribute(PlutoAdminConstants.PAGE_ATTR, page);
	}

	public void modifyPageAttributes(ActionRequest req) {
		final String METHOD_NAME = "modifyRowsAndCols(request)";
		logMethodStart(METHOD_NAME);
		PageTO page = (PageTO)req.getPortletSession().getAttribute(PlutoAdminConstants.PAGE_ATTR);
		logDebug(METHOD_NAME, "Current page: " + page);
		String title = req.getParameter("title");
		page.setTitle(title);
		String description = req.getParameter("description");
		page.setDescription(description);
		String rows = req.getParameter("numrows");
		page.setRows(Integer.parseInt(rows));
		String cols = req.getParameter("numcols");
		page.setCols(Integer.parseInt(cols));
		logDebug(METHOD_NAME, "Updated current page: " + page);
		req.getPortletSession().setAttribute(PlutoAdminConstants.PAGE_ATTR, page);
		logMethodEnd(METHOD_NAME);
	}

	public Map getPortletMapForSelect(String app) {
		Map map = new HashMap();
		List portlets = null;
		Iterator iter = getPageRegistry();
		while (iter.hasNext()) {
			PageTO page = (PageTO)iter.next();
			if (page.getName().equalsIgnoreCase(app)) {
				portlets = page.getPortlets();
				break;
			}
		}
		//go through portlets
		Iterator piter = portlets.iterator();
		while(piter.hasNext()){
			PortletTO plet = (PortletTO)piter.next();
			map.put(plet.getName(), plet.getValue());
		}
		return map;
	}
}
