/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.portals.pluto.demo.v3annotated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.annotations.ActionMethod;
import javax.portlet.annotations.LocaleString;
import javax.portlet.annotations.PortletConfiguration;
import javax.portlet.annotations.RenderMethod;
import javax.portlet.annotations.ServeResourceMethod;
import javax.servlet.http.Part;

/**
 * Test vehicle for multipart orm support
 * 
 * @author Scott Nicklous
 * 
 */
@PortletConfiguration(portletName="MultipartPortlet", cacheExpirationTime=0,
      title=@LocaleString("Multipart Form Test"))
public class MultipartPortlet {
   private static final Logger logger = LoggerFactory.getLogger(MultipartPortlet.class);

   private static final String JSP    = "/WEB-INF/jsp/multipartDialog.jsp";
   private static final String TMP    = "/MultipartPortlet/temp/";
   private static final String TFILE  = "uploadFile";

   @ActionMethod(portletName = "MultipartPortlet")
   public void handleDialog(ActionRequest req, ActionResponse resp) throws IOException, PortletException {
      List<String> lines = new ArrayList<String>();
      req.getPortletSession().setAttribute("lines", lines);

      lines.add("handling dialog");
      StringBuilder txt = new StringBuilder(128);

      String clr = req.getActionParameters().getValue("color");
      txt.append("Color: ").append(clr);
      lines.add(txt.toString());
      logger.debug(txt.toString());

      resp.getRenderParameters().setValue("color", clr);

      txt.setLength(0);
      Part part = null;
      try {
         part = req.getPart("file");
      } catch (Throwable t) {}
      
      if ((part != null) && (part.getSubmittedFileName() != null) && 
            (part.getSubmittedFileName().length() > 0)) {
         txt.append("Uploaded file name: ").append(part.getSubmittedFileName());
         txt.append(", part name: ").append(part.getName());
         txt.append(", size: ").append(part.getSize());
         txt.append(", content type: ").append(part.getContentType());
         lines.add(txt.toString());
         logger.debug(txt.toString());
         txt.setLength(0);
         txt.append("Headers: ");
         String sep = "";
         for (String hdrname : part.getHeaderNames()) {
            txt.append(sep).append(hdrname).append("=").append(part.getHeaders(hdrname));
            sep = ", ";
         }
         lines.add(txt.toString());
         logger.debug(txt.toString());

         // Store the file in a temporary location in the webapp where it can be served. 

         try {
            String fn = part.getSubmittedFileName();
            String ct = part.getContentType();
            
            if (ct != null && (ct.equals("text/plain") || ct.matches("image/(?:png|gif|jpg|jpeg)"))) {
               
               String ext = ct.replaceAll("\\w+/", "");
               lines.add("determined extension " + ext + " from content type " + ct);
               File img = getFile();
               if (img.exists()) {
                  lines.add("deleting existing temp file: " + img.getCanonicalPath());
                  img.delete();
               }
               InputStream is = part.getInputStream();
               Files.copy(is, img.toPath(), StandardCopyOption.REPLACE_EXISTING);
               
            } else {
               lines.add("Bad file type. Must be plain text or image (gif, jpeg, png).");
            }

            resp.getRenderParameters().setValue("fn", fn);
            resp.getRenderParameters().setValue("ct", ct);

         } catch (Exception e) {
            lines.add("Exception doing I/O: " + e.toString());
            
            txt.setLength(0);
            txt.append("Problem getting temp file: " + e.getMessage() + "\n");
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            pw.flush();
            txt.append(sw.toString());
            logger.warn(txt.toString());
         }
      } else {
         lines.add("file part was null");
      }

   }

   @RenderMethod(portletNames = "MultipartPortlet")
   public void render(RenderRequest req, RenderResponse resp) throws PortletException, IOException {
      List<String> lines = new ArrayList<String>();
      @SuppressWarnings("unchecked")
      List<String> actionlines = (List<String>) req.getPortletSession().getAttribute("lines");
      if (actionlines != null) {
         lines.addAll(actionlines);
      }
      req.setAttribute("lines", lines);
      lines.add("rendering");

      String clr = req.getRenderParameters().getValue("color");
      if (clr == null) {
         clr = "#E0FFE0";
      }
      req.setAttribute("color", clr);

      // If there is a temp file, read it

      String fn = req.getRenderParameters().getValue("fn");
      String ct = req.getRenderParameters().getValue("ct");
      if ((fn == null) || (ct == null)) {
         lines.add("No file stored.");
      } else {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Rendering for uploaded file: ").append(fn);
         txt.append(", type: ").append(ct);
         lines.add(txt.toString());

         List<String> flist = new ArrayList<String>();
         req.setAttribute("flist", flist);

         FileInputStream fis = null;
         BufferedReader rdr = null;
         try {
            File file = getFile();
            fis = new FileInputStream(file);

            if (ct.equals("text/plain")) {
               lines.add("Processing text file.");
               if (file.length() < 2000) {
                  rdr = new BufferedReader(new InputStreamReader(fis));
                  String line;
                  while ((line = rdr.readLine()) != null) {
                     line = line.replaceAll("&", "&amp;");
                     line = line.replaceAll(" ", "&nbsp;");
                     line = line.replaceAll("<", "&lt;");
                     flist.add(line);
                  }
               } else {
                  flist.add("Sorry, file size > 2000 and is too big.");
               }
            } else if (ct.matches("image/(?:png|gif|jpg|jpeg)")) {
               lines.add("Processing image.");

               BufferedImage bimg = ImageIO.read(fis);
               int h = bimg.getHeight();
               int w = bimg.getWidth();

               txt.setLength(0);
               txt.append("Image height: ").append(h);
               txt.append(", width: ").append(w);
               lines.add(txt.toString());

               req.setAttribute("h", h);
               req.setAttribute("w", w);
               req.setAttribute("img", fn);

            } else {
               flist.add("Sorry, can't display this kind of file.");
            }
         } catch (Exception e) {
            flist.add("Exception preparing for render: " + e.toString());
         } finally {
            if (rdr != null) {
               rdr.close();
            } 
            if (fis != null) {
               fis.close();
            }
         }
      }

      PortletRequestDispatcher rd = req.getPortletContext().getRequestDispatcher(JSP);
      rd.include(req, resp);
   }
   
   @ServeResourceMethod(portletNames="MultipartPortlet")
   public void serveImage(ResourceRequest req, ResourceResponse resp) throws IOException {
      String ct = req.getRenderParameters().getValue("ct");
      
      resp.setContentType(ct);

      try {
         File file = getFile();
         OutputStream os = resp.getPortletOutputStream();
         Files.copy(file.toPath(), os);
         os.flush();
      } catch (Exception e) {
         StringBuilder txt = new StringBuilder(128);
         txt.append("Problem retrieving temp file: " + e.getMessage() + "\n");
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         e.printStackTrace(pw);
         pw.flush();
         txt.append(sw.toString());
         logger.warn(txt.toString());
      }
      
   }

   /**
    * Returns a File object representing the uploaded temporary file location. Note that the file may or may not exist.
    * The temp directories are created as necessary.
    * 
    * @return the File object
    * @throws IOException 
    */
   private File getFile() throws IOException {
      File tmp = null;

      String path = System.getProperty("java.io.tmpdir") + TMP;
      File dir = new File(path);
      if (!dir.exists()) {
         logger.debug("Creating directory. Path: " + dir.getCanonicalPath());
         Files.createDirectories(dir.toPath());
      }
      tmp = new File(dir, TFILE);
      logger.debug("Temp file: " + tmp.getCanonicalPath());

      return tmp;
   }
}
