/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.descriptors.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.Marshaller;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

/**
 * Abstract deployment descriptor support class.
 * This Base class provides support for reading
 * and writing deployment descriptors using Castor.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 5, 2005
 */
abstract class AbstractCastorDescriptorService {

    private String contextPath;

    /**
     * Default Constructor.
     */
    protected AbstractCastorDescriptorService(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getContextPath() {
        return contextPath;
    }


    /**
     * Read the and convert the descriptor into it's Object graph.
     * @return
     * @throws IOException
     */
    protected Object readInternal() throws IOException {
        Object object = null;
        InputStream is = getInputStream();
        try {
            Mapping mapping = getCastorMapping();
            Unmarshaller unmarshaller = new Unmarshaller(mapping);
            unmarshaller.setIgnoreExtraElements(getIgnoreExtraElements());
            if(is!=null) {
                InputStreamReader in = new InputStreamReader(is);
                object = unmarshaller.unmarshal(in);
            }
        }
        catch(Exception me) {
            me.printStackTrace();
            throw new IOException(me.getMessage());
        }
        finally {
            if(is != null) {
                is.close();
            }
        }
        return object;
    }

    /**
     * Write the object graph to it's descriptor.
     * @param object
     * @throws IOException
     */
    protected void writeInternal(Object object) throws IOException {
        OutputFormat of = new OutputFormat();
        of.setIndenting(true);
        of.setIndent(2);
        of.setLineWidth(600);
        of.setDoctype(getPublicId(), getDTDUri());

        OutputStreamWriter writer =
            new OutputStreamWriter(getOutputStream());
        XMLSerializer serializer = new XMLSerializer(writer, of);

        try {
            Marshaller marshaller =
                new Marshaller(serializer.asDocumentHandler());
            marshaller.setMapping(getCastorMapping());
            marshaller.marshal(object);
        } catch(IOException io) {
            throw io;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
        finally {
            writer.flush();
            writer.close();
        }
    }

    protected boolean getIgnoreExtraElements() {
        return false;
    }

    protected abstract Mapping getCastorMapping() throws IOException, MappingException;
    protected abstract InputStream getInputStream() throws IOException;
    protected abstract OutputStream getOutputStream() throws IOException;

    protected abstract String getPublicId();
    protected abstract String getDTDUri();


}

