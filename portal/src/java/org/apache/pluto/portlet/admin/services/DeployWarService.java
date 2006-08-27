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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.PortletDiskFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.pluto.descriptors.portlet.PortletDD;
//import org.apache.pluto.driver.portlets.admin.FileUploadPortlet;
import org.apache.pluto.portalImpl.om.entity.impl.PortletApplicationEntityImpl;
import org.apache.pluto.portlet.admin.BaseAdminObject;
import org.apache.pluto.portlet.admin.PlutoAdminConstants;
import org.apache.pluto.portlet.admin.PlutoAdminException;
import org.apache.pluto.portlet.admin.bean.PageTO;
import org.apache.pluto.portlet.admin.bean.PortletMessage;
import org.apache.pluto.portlet.admin.bean.PortletMessageType;
import org.apache.pluto.portlet.admin.bean.PortletTO;
import org.apache.pluto.portlet.admin.model.PageRegistryXao;
import org.apache.pluto.portlet.admin.model.PortletEntityRegistryXao;
import org.apache.pluto.portlet.admin.util.PlutoAdminContext;

/**
 * This is the service that does is called by DeployWarPortlet to
 * do the work of deploying a portlet war.
 *
 * @author Ken Atherton
 * @author Craig Doremus
 *
 */
public class DeployWarService extends BaseAdminObject {

    public static final String ERROR_NO_FILE = "ERROR_NO_FILE";
	public static final String CLASS_NAME = "DeployWarService";

	/**
	 * Default constructor
	 */
	public DeployWarService() {
		super(CLASS_NAME);
	}

	/**
	 * Constructor taking a String used to identify a logging record.
	 * @param logId
	 */
	public DeployWarService(String logId) {
		super(CLASS_NAME, logId);
	}

	/**
	 * Does the work of this service to deploy a portlet war file.
	 * 
	 * @param request DeployWarService request object.
	 * @param response DeployWarService response object.
	 */
  public String processFileUpload(ActionRequest request, ActionResponse response, int mbMaxSize) {
  	final String METHOD_NAME = "processFileUpload(request,response)";
    logDebug(METHOD_NAME, "Doing file upload with max upload size = " + mbMaxSize);
    String fileName = null;
    String serverFileName = null;
    boolean modifyWebXml = true;
    request.getPortletSession().setAttribute(PlutoAdminConstants.MESSAGE_ATTR, new PortletMessage("Deployment unsuccessful", PortletMessageType.ERROR));
    // Check the request content type to see if it starts with multipart/
    if (PortletDiskFileUpload.isMultipartContent(request))
    {

    	//Create a factory for disk-based file items
    	FileItemFactory factory = new DiskFileItemFactory();

    	//Create a new file upload handler
    	PortletFileUpload pfu = new PortletFileUpload(factory);

    	//Set overall request size constraint
    	pfu.setSizeMax(mbMaxSize * 1000 * 1000);

    	try
        {
            //get the FileItems
            List fileItems = pfu.parseRequest(request);
            Iterator iter = fileItems.iterator();
            while (iter.hasNext())
            {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField())
                {
                    //pass along to render request
                    String fieldName = item.getFieldName();
                    String value = item.getString();
                    response.setRenderParameter(fieldName, value);
                    if (fieldName.equalsIgnoreCase("NoWebXmlModification")) {
                        String noWebXmlModification = item.getString();
                        logWarn(METHOD_NAME, "Don't modify web.xml? " + noWebXmlModification);
                        if (noWebXmlModification != null) {
                        	modifyWebXml = false;
                        }
                    }
                }
                else
                {
                    //write the uploaded file to a new location
                    fileName = item.getName();
                    String contentType = item.getContentType();
                    long size = item.getSize();
                    response.setRenderParameter("size", Long.toString(size));
                    response.setRenderParameter("contentType", contentType);
                    String tempDir = System.getProperty("java.io.tmpdir");
                    serverFileName = getRootFilename(File.separatorChar, fileName);
                    File serverFile = new File(tempDir, serverFileName);
                    item.write(serverFile);
                    response.setRenderParameter("serverFileName",  serverFileName);

                    //Add to portletentityregistry.xml
					int index = serverFileName.indexOf(".war");
					String context = "";
					if ( index != -1) {
						context = serverFileName.substring(0, index);
					} else {
						context = serverFileName;
					}
			        //Check to see if a record exists
  		            PortletEntityRegistryXao xao = new PortletEntityRegistryXao();
			        boolean appExists = xao.applicationExists(context);
					ArrayList  argList = createDeploymentArgs(serverFileName, tempDir, request, appExists, context);
					Map pmap = (HashMap) request.getPortletSession().getAttribute(PlutoAdminConstants.PORTLET_MAP_ATTR);
					logDebug(METHOD_NAME, "Arguments for Deploy.main():");
					String[] args = arrayListToStringArray(argList);
					for (int i =0; i < args.length; i++) {
						logDebug(METHOD_NAME, "args["+i+"]="+args[i]);
					}
		            org.apache.pluto.portalImpl.Deploy.main(args);
		            //NEW: Update web.xml with new servlet elements
		            if (modifyWebXml) {
		            	updateWebXml(context);
		            }
		            if (appExists) {
		            	request.getPortletSession().setAttribute(PlutoAdminConstants.MESSAGE_ATTR, new PortletMessage("Deployment of the new portlet app has been successful, but the portlet app record '" + context + "' already exists in portletentityregistry.xml. " +
		            			"This may have occurred if the portlet was previously partially deployed. If that is the case, continue with this screen and the next to register the portlet in pageregistry.xml. " +
		            			"If you are deploying a previously deployed portlet app, click on the 'Deploy War home' link below and then the 'Hot deploy . . .' link on the resulting page to see your redeployed portlet. " +
		            			"However, caching of the old app may require that you restart Pluto to see the new changes.", PortletMessageType.INFO));
		            } else {
		            	request.getPortletSession().setAttribute(PlutoAdminConstants.MESSAGE_ATTR, new PortletMessage("Deployment and addition to portletentityregistry.xml successful.", PortletMessageType.SUCCESS));
		            }
		         }
            }
        }
        catch (FileUploadException e){
            String msg = "File Upload Exception: " + e.getMessage();
            logError(METHOD_NAME, msg, e);
            throw new PlutoAdminException(e);
        } catch (Exception e) {
            String msg = "Exception: " + e.getMessage();
            logError(METHOD_NAME, msg, e);
            throw new PlutoAdminException(e);
        }
    } else {
        //set an error message
      	request.getPortletSession().setAttribute(PlutoAdminConstants.MESSAGE_ATTR, new PortletMessage("No file appears to have been selected.", PortletMessageType.ERROR));
    }
    logMethodEnd(METHOD_NAME, serverFileName);
    return serverFileName;
  }


  private String getRootFilename(char delimiter, String pathName) {
    int startFilenameIndex = pathName.lastIndexOf(delimiter)  + 1;
    String filename =  pathName.substring(startFilenameIndex);
    return filename;
  }

	private static String[] arrayListToStringArray(ArrayList argStringArrayList) {
		return  (String[]) argStringArrayList.toArray(new String[argStringArrayList.size()]);
	}



	private InputStream extractFile(String zipfilename, String filename) {
  	final String METHOD_NAME = "extractFile(zipfilename,filename)";
	    InputStream ins = null;
	    try {
	        ZipFile zf = new ZipFile(zipfilename);
	        if (null != zf) {
	            ZipEntry ze = zf.getEntry(filename);
	            if (null != ze) {
	                ins = zf.getInputStream(ze);
 	            } else {
                      String MSG = "InputStream for " + filename + " is null.  " +
                         "Unable to extract " + filename + " from " + zipfilename + ".  " +
                         "Check if " + zipfilename + " contains " + filename + ".  ";
 	                throw new PlutoAdminException( MSG ); 
	            }
	        }
	    }
	    catch (Exception e) {
        logError(CLASS_NAME, METHOD_NAME, e);
        throw new PlutoAdminException(e);
	    }
	    return ins;
	}



	/**
	 * Creates arguments (parameters) for Deploy class that does
	 * the deployment.
	 *  
	 * @param serverFileName The name of the war file to be deployed
	 * @param tempDir Full path to temp dir that holds the war file to be deployed
	 * @param request ActionRequest of the portlet.
	 * @param appExists True if this is a re-deployment, else false
	 * @return ArrayList of arguments
	 * @throws Exception
	 * @see org.apache.pluto.portalImpl.Deploy#main
	 */
	private ArrayList createDeploymentArgs(String serverFileName, String tempDir, ActionRequest request, boolean appExists, String context) throws Exception {
	  	final String METHOD_NAME = "createDeploymentArgs(serverFileName,tempDir,request)";
	  	Properties props = PlutoAdminContext.getProperties();
	    final String CONTAINER_HOME =  PlutoAdminContext.getContainerHome();
	    final String PORTLET_DEPLOY_DIR = props.getProperty("portlet-deploy-dir");
	
	    ArrayList  args = new ArrayList();
	    args.add(PlutoAdminContext.getDeploymentPath());
	    args.add(PlutoAdminContext.getPlutoWebContext());
	    args.add(tempDir + PlutoAdminConstants.FS + serverFileName);
	    //This is probably not used???, but left here to as to not change
	    //	args indexing used by Deploy class.
	    args.add(CONTAINER_HOME + PlutoAdminConstants.FS + PORTLET_DEPLOY_DIR);
	    String appId = PortletRegistryService.getNextAppId();
	    //check if a record in portletentityregistry exists
	    if (!appExists) {
		    args.add("-addToEntityReg");
		    args.add(appId);
	    } else {
	        //Don't add it to portletentityregistry.xml,
	        //and retreive id using webapp context and XAO
			PortletEntityRegistryXao xao = new PortletEntityRegistryXao();
			PortletApplicationEntityImpl app = xao.getApplication(context);
		    appId = app.getCastorId();
	    }
	
	    //Add Map of portlet name/values to session
	    // to be used in drop downs on page layout page
	    Map pmap = new HashMap();
	    InputStream ins = extractFile(tempDir + PlutoAdminConstants.FS + serverFileName, "WEB-INF/portlet.xml");
	    if (null != ins) {
		    ArrayList names = PortletNameFinder.getPortletNames(ins);
		    for (int i = 0; i < names.size(); i++) {
		      //check if a record in portletentityregistry exists
		      if (!appExists) {
		      	args.add(i + ":" + names.get(i));
		      }
		      pmap.put(names.get(i), appId+"." +i);
		    }
		    ins.close();
	    } else {
	    	String msg = "Input stream is null";
	    	PlutoAdminException e = new PlutoAdminException(msg);
	    	logError(METHOD_NAME, e);
	    	throw e;
	    }
	    request.getPortletSession().setAttribute(PlutoAdminConstants.PORTLET_MAP_ATTR, pmap);
	    return args;
	}


	public static String mapToEntrySetString(Map inputMap) {
    StringBuffer sb = new StringBuffer();
    Set es = inputMap.entrySet();
    Iterator it = es.iterator();
    sb.append("Number of entries: " +  es.size());
    for (int i = 0; i < es.size(); i++) {
        Map.Entry entry = (Map.Entry) it.next();
        sb.append(entry.getKey().toString());
        sb.append(entry.getValue().toString());
        sb.append("\n");
    }
    return sb.toString();
	}

	/**
	 * Sets the page information into a PageTO object that is loaded into the
	 * session.
	 *
	 * @param req
	 */
	public void setPage(ActionRequest req) {
		final String METHOD_NAME = "setPage(request)";
		logMethodStart(METHOD_NAME);
		PageTO page = (PageTO)req.getPortletSession().getAttribute(PlutoAdminConstants.PAGE_ATTR);
		if (page == null) {
			page = new PageTO();
		}
		String title = req.getParameter("title");
//		logDebug(METHOD_NAME, "Title: " + title);
		page.setTitle(title);
		String desc = req.getParameter("description");
//		logDebug(METHOD_NAME, "Description: " + desc);
		page.setDescription(desc);
		String rows = req.getParameter("numrows");
//		logDebug(METHOD_NAME, "Row count: " + rows);
		page.setRows(Integer.parseInt(rows));
		String cols = req.getParameter("numcols");
//		logDebug(METHOD_NAME, "Col count: " + cols);
		page.setCols(Integer.parseInt(cols));
		req.getPortletSession().setAttribute(PlutoAdminConstants.PAGE_ATTR, page);
//		logDebug(METHOD_NAME, "New page: " + page);
		logMethodEnd(METHOD_NAME);
	}

	public void savePageLayout(ActionRequest req) {
		final String METHOD_NAME = "savePageLayout(request)";
		logMethodStart(METHOD_NAME);
		//get current page
		PageTO page = (PageTO)req.getPortletSession().getAttribute(PlutoAdminConstants.PAGE_ATTR);
//		logDebug(METHOD_NAME, "PageTO from session: " + page);
		List list = new ArrayList();
		int rows = page.getRows();
		int cols = page.getCols();
	    for (int i = 1; i <= rows ; i++) {
	      for (int j = 1; j <= cols ; j++) {
	      	String portletParam = "portlet" + i + "." + j;
	      	String name_val = req.getParameter(portletParam);
	      	//portlet name and values are separated by an underscore
	      	int underscore = name_val.lastIndexOf("_");
	      	String name = name_val.substring(0, underscore);
	      	String val = name_val.substring(underscore + 1);
	
	      	//create a PortletTO and add it to the list
	      	PortletTO nPortlet = new PortletTO();
	      	nPortlet.setName(name);
	      	nPortlet.setValue(val);
	      	nPortlet.setRow(i);
	      	nPortlet.setCol(j);
	      	list.add(nPortlet);
	      }
	    }
	    page.setPortlets(list);
//		logDebug(METHOD_NAME, "Updated PageTO: " + page);

		addToPageReg(page);
		logMethodEnd(METHOD_NAME);
	}

	/**
	 * Add a new page record to the pageregistry.xml file.
	 * @param page The new page to add
	 */
  public void addToPageReg(PageTO page) {
		final String METHOD_NAME = "addToPageReg(PageTO)";
		logMethodStart(METHOD_NAME);
		RandomAccessFile ras = null;

//		int rows = page.getRows();
		int cols = page.getCols();
		String name = page.getName();
	  try {
			  	//get path to pageregistry.xml
			String pageregpath = PlutoAdminContext.getInstance().getPageRegistryPath();
			//String pageregpath = "/pluto-1.0.1/webapps/pluto/WEB-INF/data/pageregistry.xml";

			File file = new File(pageregpath);
			ras = new RandomAccessFile(file, "rw");
			long length = ras.length();
			byte[] contentByte = new byte[(int) length];
			ras.read(contentByte);
			String contentString = new String(contentByte);
			//Check for previous deployment in pageregistry.xml
			String prev = "fragment name=\"" + name;
			if (contentString.lastIndexOf(prev) != -1){
				String errMsg = "Portlet '" + name + "' already exists in pageregistry.xml";
				PlutoAdminException e = new PlutoAdminException(errMsg);
				logError(METHOD_NAME, errMsg, e);
				throw e;//throw exception here
			}
			//start before close of root element
			long pos = contentString.lastIndexOf("</portal>");
			ras.seek(pos);

			//start page fragment
			ras.writeBytes("    <fragment name=\"" + name + "\" type=\"page\" >" + PlutoAdminConstants.LS);
			ras.writeBytes("        <navigation>" + PlutoAdminConstants.LS);
			ras.writeBytes("	        <title>" + page.getTitle());
			ras.writeBytes("</title>" + PlutoAdminConstants.LS);
			ras.writeBytes("	        <description>" + page.getDescription());
			ras.writeBytes("</description>" + PlutoAdminConstants.LS);
			ras.writeBytes("        </navigation>" + PlutoAdminConstants.LS);

			//iterate through portlets
			List portlets = page.getPortlets();
			//Sort list using Comparable implementation in PortletTO. This makes sure
			//	the items in the list are ordered by rows
			Collections.sort(portlets);
			Iterator iter = portlets.iterator();
			int count = 0;
			int currRow = 0;
			int lastRow = 0;
			int currCol = 0;
			while (iter.hasNext()) {
					count++;
					PortletTO portlet = (PortletTO)iter.next();
					logDebug(METHOD_NAME, "Portlet: " + portlet);
					currRow = portlet.getRow();
					currCol = portlet.getCol();
					//start row fragment
					//	Add row fragment when row changes
					if (currRow != lastRow) {
						ras.writeBytes("          <fragment name=\"row" + currRow + "\" type=\"row\">" + PlutoAdminConstants.LS);
						ras.writeBytes("             <fragment name=\"col" + count + "\" type=\"column\">" + PlutoAdminConstants.LS);
					}

						ras.writeBytes("                  <fragment name=\"p" + count + "\" type=\"portlet\">" + PlutoAdminConstants.LS);
						ras.writeBytes("                    <property name=\"portlet\" value=\"" + portlet.getValue() + "\"/>" + PlutoAdminConstants.LS);
						ras.writeBytes("                  </fragment><!-- end of portlet frag -->" + PlutoAdminConstants.LS);

						//end row fragment
						if (cols == currCol) {
							ras.writeBytes("             </fragment><!-- end of col frag -->" + PlutoAdminConstants.LS);
							//end of column iteration
							ras.writeBytes("         </fragment><!-- end of row frag -->" + PlutoAdminConstants.LS);
						}
					lastRow = currRow;
			}

			//end page fragment
			ras.writeBytes("    </fragment><!-- end of 'page' frag -->" + PlutoAdminConstants.LS);
			//add a couple of newlines to separate records
			ras.writeBytes(PlutoAdminConstants.LS);
			ras.writeBytes(PlutoAdminConstants.LS);
			//replace closing root element
			ras.writeBytes("</portal>" + PlutoAdminConstants.LS);

		} catch (IOException e) {
				logError(METHOD_NAME, e);
				throw new PlutoAdminException(e);
		} finally {
			if (ras != null) {
				try {
					ras.close();
				} catch (IOException e) {
					logError(METHOD_NAME, e);
				}
			}
		}
		logMethodEnd(METHOD_NAME);
  }

  public boolean addToPortletContexts(String context) {
  	final String METHOD_NAME = "addToPortletContexts(context)";
	logMethodStart(METHOD_NAME);
  	logParam(METHOD_NAME, "context", context);
  	String path = PlutoAdminContext.getInstance().getPortletContextsPath();
  	logDebug(METHOD_NAME, "portletcontexts.txt path: " + path);
  	File file = new File(path);
		boolean found = false;
  	if (file.exists()) { //check for Pluto 1.0.1-rc1
			String fileContents = readFileToString(file);
			logDebug(METHOD_NAME, "portletcontexts.txt contents: " + fileContents);

			//Check to see whether the context already is found in 
			//	the portletcontexts.txt file.
			int ind = fileContents.indexOf(context);
			found = ind == -1 ? false : true;

			//Make sure that context name is not a substring of 
			//	another context name. For example, /foo ,
			//	/foobar and /barfoo are all valid contexts.
			//check if a slash before the found context name in portletcontexts.txt file
			if (found && !fileContents.substring(ind - 1, ind).equals("/")) {
			    found = false;
			}
			//check if there is a line-separator after the found context name in portletcontexts.txt file
			// or that this context is the last token in the file
			if (found) {
			    int len = context.length();//length of context String
			    String contextInFile = fileContents.substring(ind);//substring that starts with context
			    int indLS = contextInFile.indexOf(PlutoAdminConstants.LS);
			    long fileLen = file.length(); //length of file
			    if ((indLS != len) && (ind + len != fileLen) ) {
				    found = false;			        
			    }
			}
			if (!found) {
				logDebug(METHOD_NAME, "Writing new context: " + context);
				StringBuffer buf = new StringBuffer(fileContents);
				buf.append(PlutoAdminConstants.LS);
				buf.append("/");
				buf.append(context);
				writeStringToFile(file,buf.toString());
			}
  	} else {
			logWarn(METHOD_NAME, "File portletcontexts.txt cannot be found! You must be using Release Candidate 1.");
  	}
	logMethodEnd(METHOD_NAME, Boolean.toString(found));
	return found;
  }


  public boolean pageExists(String pageName) {
  	final String METHOD_NAME = "pageExists(pageName)";
  	boolean exists = true;
  	try {
			PageRegistryXao xao = new PageRegistryXao();
			exists = xao.pageExists(pageName);
		} catch (Exception e) {
			logError(METHOD_NAME, e);
			throw new PlutoAdminException(e);
		}
  	return exists;
  }

  /**
   * Puts the contents of a file into a String. This only works
   * with text files.
   * 
   * @param file The File to read
   * @return A String containing the contents of the file.
   */
  public String readFileToString(File file){
  	final String METHOD_NAME = "readFileToString(path)";
  	String contents = null;
		FileInputStream fis = null;
  	try {
			fis = new FileInputStream(file);
			int c;
			char b;
			StringBuffer sb = new StringBuffer();
			while((c = fis.read()) != -1) {
				b = (char)c;
				sb.append(b);
			}
			contents = sb.toString().trim();
		} catch (FileNotFoundException e) {
			logError(METHOD_NAME, e);
			throw new PlutoAdminException(e);
		} catch (IOException e) {
			logError(METHOD_NAME, e);
			throw new PlutoAdminException(e);
		}	finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logError(METHOD_NAME, e);
					throw new PlutoAdminException(e);
				}
			}
		}
  	return contents;
  }

  /**
   * Writes the contents of a file into a String.
   * 
   * @param file Te File to write.
   * @param contents The String to add to the file.
   */
  public void writeStringToFile(File file, String contents){
  	final String METHOD_NAME = "addFileToStringToFile(contents)";
		FileOutputStream fos = null;
  	try {
			fos = new FileOutputStream(file);
			byte[] bytes = contents.getBytes();
			fos.write(bytes);
		} catch (FileNotFoundException e) {
			logError(METHOD_NAME, e);
			throw new PlutoAdminException(e);
		} catch (IOException e) {
			logError(METHOD_NAME, e);
			throw new PlutoAdminException(e);
		}	finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					logError(METHOD_NAME, e);
					throw new PlutoAdminException(e);
				}
			}
		}
  }

	  /**
	   * Updates web.xml with servlet and servlet-mapping records
	   * related to PortletServlet.
	   * 
	   * @param context
	   */
	  void updateWebXml(String context) {
		  String METHOD_NAME = "updateWebXml(context)";
		  //These constants are used to place the
		  //new record in web.xml in the proper place
		  	//elements to check prior to servlet (if not found)
		     final String[] PRIOR_ELEMENTS_SERVLET = 
		     	{"servlet", "listener", "filter-mapping", "filter", "context-param", 
		    		 "distributable", "description", "display-name", "icon", "web-app"};
			  	//elements to check prior to servlet-mapping  (if not found)
		     final String[] PRIOR_ELEMENTS_SERVLET_MAPPING = 
		     	{"servlet-mapping", "servlet"};
			String webapps = PlutoAdminContext.getDeploymentPath();
		     File webXml = new File(webapps + 
	 		 		 PlutoAdminConstants.FS + 
	 		 		 context + 
	 		 		 PlutoAdminConstants.FS + 
	 		 		 "WEB-INF" + 
	 		 		 PlutoAdminConstants.FS + 
	 		 		 "web.xml");
		     DeployWarService svc = new DeployWarService();
		     String contents = svc.readFileToString(webXml);
		     File portletXml = new File(webapps + 
	 		 		 PlutoAdminConstants.FS + 
	 		 		 context + 
	 		 		 PlutoAdminConstants.FS + 
	 		 		 "WEB-INF" + 
	 		 		 PlutoAdminConstants.FS + 
	 		 		 "portlet.xml");
			List plist = null;
			try {
				InputStream ins = new FileInputStream(portletXml);
			     PortletConfigService pcsvc = new PortletConfigService(ins);
			     plist = pcsvc.getPortletDDList();
			} catch (FileNotFoundException e) {
				logError(METHOD_NAME, e);
				throw new PlutoAdminException(e);
			}
			 String newWebXml = svc.addRecordsToWebXml(context, contents, 
					 PRIOR_ELEMENTS_SERVLET, plist); 
			 contents = newWebXml;
			 newWebXml = svc.addRecordsToWebXml(context, contents, 
					 PRIOR_ELEMENTS_SERVLET_MAPPING, plist); 
			 writeStringToFile(webXml, newWebXml);
		}
		  
	  
	  
	 /**
	  * Adds ServletPortlet servlet or servlet-mapping records to web.xml 
	  * for new portlet deployment.
	  * 
	  * @param context Web context or directory under webapps
	  * @param contents Current contents of the web.xml file
	  * @param elements Elements in web.xml to search for. If found, new
	  * elements will be inserted to the contents String. NOTE: First element
	  * (elements[0] signals the kind of record to add (servlet or servlet-mapping).
	  * @param portletData A List of PortletDD items containing the data of 
	  * portlets to be deployed.
	  */
		 String addRecordsToWebXml(String context, String contents, 
				 	String[] elements, List portletData ) {
			 String METHOD_NAME = "addRecordsToWebXml(context.contents,elements,portletData)";
			StringBuffer results = new StringBuffer(contents);
			 int index = -1;//index indicating the start of the insertion point
			 int len = portletData.size();
			 int lenElements = elements.length;
			 //string before a found element
			 String before = null;
			 //The new record to be added
			 String newRecord = null;
			 //The remainder of the string after the found element (tag)
			 String remainder = null;
			 //Rest of the string after the opening of the element
			 String rest = null;
			 //go through the list of portlets in ArrayLists 
			 for (int i = 0; i < len; i++) {
				 //check each element in web.xml contents
				 for (int j = 0; j < lenElements; j++) {
				     if ((index = results.lastIndexOf("</" + elements[j]+ ">")) != -1 ||
                                      // Added for PLUTO-219: <distributable/> is an empty element according to servlet spec 2.3 (and 2.4)
                                      (index = results.lastIndexOf("<" + elements[j] + "/>")) != -1 ) {
					     //get the length to the end of the element (>)
				    	 rest = results.substring(index);
				    	 int elementLen = rest.indexOf('>') + 1;
				    	 //First portlet could have to deal with web-app element
				    	 //so the new records will be put after the web-app start element.
				    	 //Also account for web-app's attributes in calculating the element length
				    	 if (i == 0 & elements[j].equals("web-app")) {
							 index = results.indexOf("<web-app");
							 //Get the rest of the results String after <web-app
							 rest = results.substring(index);//get string starting with <web-app
							 elementLen = rest.indexOf('>') + 1;//end of starting web-app element
				    	 }
				    	 logDebug(METHOD_NAME, "Length of '" + elements[j] + "' tag = " + elementLen);
				    	 //get everything before the found element including the tag
				    	 before = results.substring(0, index + elementLen);
				    	 //get everything after the found element starting at the end of the tag
				    	 remainder = results.substring(index + elementLen);
				        //add the new element with child elements
				        //create the new element using the first item in the elements array
				        if (elements[0].equals("servlet")) {
				        	newRecord = getServletRecord(context, (PortletDD)portletData.get(i));
				        } else if (elements[0].equals("servlet-mapping")) {
				        	newRecord = getServletMappingRecord((PortletDD)portletData.get(i));
				        }
				        results = new StringBuffer();
				        results.append(before);
				        //start the new content with a newline
				        results.append(PlutoAdminConstants.LS);
				        results.append(newRecord);
				        results.append(remainder);
				        break;
				     }
				 }
			 }
			 return results.toString();
		
		}

		/**
	    * Gets the web.xml servlet record for PortletServlet
	    * from portlet.xml data
	    * 
	    * @param context Context name
	    * @param portletData Data from portlet.xml
	    * @return
	    */
		 private String getServletRecord(String context, PortletDD portletData) {
		     
		     StringBuffer record = new StringBuffer();
		     
		     record.append("    <servlet>" + PlutoAdminConstants.LS);
		     record.append("      <servlet-name>" + portletData.getPortletName() + "</servlet-name>" + PlutoAdminConstants.LS);
		     record.append("      <display-name>" + portletData.getPortletName() + " Wrapper</display-name>" + PlutoAdminConstants.LS);
		     record.append("      <description>Automated generated Portlet Wrapper</description>" + PlutoAdminConstants.LS);
		     record.append("      <servlet-class>org.apache.pluto.core.PortletServlet</servlet-class>" + PlutoAdminConstants.LS);
		     record.append("      <init-param>" + PlutoAdminConstants.LS);
		     record.append("        <param-name>portlet-guid</param-name>" + PlutoAdminConstants.LS);
		     record.append("        <param-value>" + context + "." + portletData.getPortletName() + "</param-value>" + PlutoAdminConstants.LS);
		     record.append("      </init-param>" + PlutoAdminConstants.LS);
		     record.append("      <init-param>" + PlutoAdminConstants.LS);
		     record.append("        <param-name>portlet-class</param-name>" + PlutoAdminConstants.LS);
		     record.append("        <param-value>" + portletData.getPortletClass() + "</param-value>" + PlutoAdminConstants.LS);
		     record.append("      </init-param>" + PlutoAdminConstants.LS);
		     //Add list of security-role-ref elements with 
		     // corresponding role-name and role-link if there is one in portlet.xml
		     String securityRef = getSecurityRoleRefRecord(context, portletData);
		     if (securityRef != null && !securityRef.equals("")) {
		    	 record.append(securityRef);
		     }
		     record.append("    </servlet>" + PlutoAdminConstants.LS);
		  
		     return record.toString();
		 }

			/**
		    * Gets the web.xml security-role-ref record for PortletServlet
		    * from portlet.xml data
		    * 
		    * @param context Context name
		    * @param portletData Data from portlet.xml
		    * @return
		    */
			 private String getSecurityRoleRefRecord(String context, PortletDD portletData) {
			     
			     StringBuffer record = new StringBuffer("");
			     
			     List refs = portletData.getSecurityRoleRefs();
			     String link = null;
			     for (Iterator iter = refs.iterator(); iter.hasNext();) {
			    	 PortletConfigService.RoleRef ref = (PortletConfigService.RoleRef) iter.next();
				     record.append("      <security-role-ref>" + PlutoAdminConstants.LS);
				     record.append("        <role-name>"+ ref.roleName + "</role-name>" + PlutoAdminConstants.LS);
				     //role-link is optional
				     link = ref.roleLink;
				     if (link != null && !link.equals("")) {
				    	 record.append("        <role-link>" + link + "</role-link>" + PlutoAdminConstants.LS);
				     }
				     record.append("      </security-role-ref>" + PlutoAdminConstants.LS);
				 } 
			  
			     return record.toString();
			 }

	  /**
	    * Gets the web.xml servlet-mapping record for PortletServlet
	    * from portlet.xml data
	    * 
	    * @param context Context name
	    * @param portletData Data from portlet.xml
	    * @return
	    */
	   private String getServletMappingRecord(PortletDD portletData) {
	       
	       StringBuffer record = new StringBuffer();
	       
	       record.append("    <servlet-mapping>" + PlutoAdminConstants.LS);
	       record.append("      <servlet-name>" + portletData.getPortletName() + "</servlet-name>" + PlutoAdminConstants.LS);
	       //pattern = /PortletName/*
	       record.append("      <url-pattern>/" + portletData.getPortletName() + "/*</url-pattern>" + PlutoAdminConstants.LS);
	       record.append("    </servlet-mapping>" + PlutoAdminConstants.LS);
	    
	       return record.toString();
	   }

}
