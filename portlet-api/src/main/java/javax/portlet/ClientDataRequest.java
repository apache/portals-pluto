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

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.Part;

/**
 * <span class="changed_modified_3_0">The</span>
 * <CODE>ClientDataRequest</CODE> represents the request information 
 * of the HTTP request issued from the client to the portal.<BR>
 * It extends the PortletRequest interface.
 * 
 * @since 2.0
 * @see PortletRequest
 */
public interface ClientDataRequest extends PortletRequest {

    /**
     * Retrieves the body of the HTTP request from client to
     * portal as binary data using
     * an <CODE>InputStream</CODE>. Either this method or 
     * {@link #getReader} may be called to read the body, but not both.
     * <p>
     * For HTTP POST data of type application/x-www-form-urlencoded
     * this method throws an <code>IllegalStateException</code>
     * as this data has been already processed by the 
     * portal/portlet-container and is available as request parameters.
     *
     * @return an input stream containing the body of the request
     *
     * @exception java.lang.IllegalStateException
     *                   if getReader was already called, or it is a 
     *                   HTTP POST data of type application/x-www-form-urlencoded
     * @exception java.io.IOException
     *                   if an input or output exception occurred
     */
    public java.io.InputStream getPortletInputStream () throws java.io.IOException;



    /**
     * Overrides the name of the character encoding used in the body of this
     * request. This method must be called prior to reading input 
     * using {@link #getReader} or {@link #getPortletInputStream}.
     * <p>
     * This method only sets the character set for the Reader that the
     * {@link #getReader} method returns.
     *
     * @param   enc a <code>String</code> containing the name of 
     *          the character encoding.
     *
     * @exception       java.io.UnsupportedEncodingException if this is not a valid encoding
     * @exception       java.lang.IllegalStateException      if this method is called after 
     *                                   reading request parameters or reading input using 
     *                                   <code>getReader()</code>
     */

    public void setCharacterEncoding(String enc) 
      throws java.io.UnsupportedEncodingException;


    /**
     * Retrieves the body of the HTTP request from the client to the portal
     * as character data using
     * a <code>BufferedReader</code>.  The reader translates the character
     * data according to the character encoding used on the body.
     * Either this method or {@link #getPortletInputStream} may be called to read the
     * body, not both.
     * <p>
     * For HTTP POST data of type application/x-www-form-urlencoded
     * this method throws an <code>IllegalStateException</code>
     * as this data has been already processed by the 
     * portal/portlet-container and is available as request parameters.
     *
     * @return  a <code>BufferedReader</code>
     *      containing the body of the request  
     *
     * @exception  java.io.UnsupportedEncodingException     
     *                 if the character set encoding used is 
     *           not supported and the text cannot be decoded
     * @exception  java.lang.IllegalStateException      
     *                 if {@link #getPortletInputStream} method
     *           has been called on this request,  it is a 
     *                   HTTP POST data of type application/x-www-form-urlencoded.
     * @exception  java.io.IOException
     *                 if an input or output exception occurred
     *
     * @see #getPortletInputStream
     */
    
    public java.io.BufferedReader getReader()
      throws java.io.UnsupportedEncodingException, java.io.IOException;
      
      
    /**
     * Returns the name of the character encoding used in the body of this request.
     * This method returns <code>null</code> if the request
     * does not specify a character encoding.
     *
     * @return      a <code>String</code> containing the name of 
     *          the character encoding, or <code>null</code>
     *          if the request does not specify a character encoding.
     */
    
    public java.lang.String getCharacterEncoding();



    /**
     * Returns the MIME type of the body of the request, 
     * or null if the type is not known.
     *
     * @return      a <code>String</code> containing the name 
     *          of the MIME type of the request, or null 
     *                    if the type is not known.
     */

    public java.lang.String getContentType();


    /**
     * Returns the length, in bytes, of the request body 
     * which is made available by the input stream, or -1 if the
     * length is not known.
     *
     * @return      an integer containing the length of the 
     *          request body or -1 if the length is not known
     *
     */

    public int getContentLength();

    /**
     * <div class="changed_added_3_0">
     * Returns the length, in bytes, of the request body 
     * which is made available by the input stream, or -1 if the
     * length is not known. 
     * </div> 
     *
     *
     * @return      a <code>long</code> containing the length of the 
     *          request body or -1 if the length is not known
     *          
     * @since  3.0
     *
     */
    public long getContentLengthLong();
      
    /**
     * Returns the name of the HTTP method with which this request was made, 
     * for example, GET, POST, or PUT.
     * 
     * @since 2.0
     * @return  a String specifying the name of the HTTP method with which 
     *          this request was made
     */
    public String getMethod();

    /**
     * <div class="changed_added_3_0">
     * Gets the Part with the given name.
     * </div> 
     *
     * @param name - the name of the requested Part
     *
     * @return The Part with the given name, or null if this request is of type 
     *      multipart/form-data, but does not contain the requested Part
     *
     *
     * @throws IOException if an I/O error occurred during the retrieval of the Part components of 
     *    this request
     * @throws PortletException if this request is not of type multipart/form-data
     * @throws IllegalStateException if the request body is larger than maxRequestSize, or any Part in 
     *    the request is larger than maxFileSize, or there is no multipart configuration 
     *    present
     *          
     * @since  3.0
     *
     */
    public Part getPart(String name) throws IOException, PortletException;

    /**
     * <div class="changed_added_3_0">
     * Gets all the Part components of this request, provided that it is of type multipart/form-data.
     * <p>
     * If this request is of type multipart/form-data, but does not contain any Part components, the returned Collection will be empty.
     * <p>
     * Any changes to the returned Collection must not affect this request object.
     * </div> 
     *
     * @return      a (possibly empty) Collection of the Part components of this request
     *
     * @throws IOException if an I/O error occurred during the retrieval of the Part components of 
     *    this request
     * @throws PortletException if this request is not of type multipart/form-data
     * @throws IllegalStateException if the request body is larger than maxRequestSize, or any Part in 
     *    the request is larger than maxFileSize, or there is no multipart configuration 
     *    present
     *           
     * @since  3.0
     *
     */
    public Collection<Part> getParts() throws IOException, PortletException;


}
