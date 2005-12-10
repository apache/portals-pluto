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
package org.apache.pluto.util.publish.http;

import org.apache.pluto.util.publish.PortletPublishConfig;
import org.apache.pluto.util.publish.PortletPublishService;
import org.apache.pluto.util.publish.PublishException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import java.io.IOException;

/**
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Dec 5, 2005
 */
public class HttpPortletPublishService implements PortletPublishService {

    private static final Log LOG = LogFactory
        .getLog(HttpPortletPublishService.class);

    public void publish(PortletPublishConfig config) throws PublishException {

        HttpClient client = new HttpClient();
        client.setHostConfiguration(getHostConfiguration(config));
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);

        StringBuffer sb = new StringBuffer();
        sb.append("/").append(config.getContext())
          .append("/admin/Publish?context=")
          .append(config.getPortletApplicationContext());

        System.out.println(sb.toString());

        if(LOG.isDebugEnabled()) {
            LOG.debug("Request url: "+sb.toString());
        }

        GetMethod get = new GetMethod(sb.toString());

        try {
            client.executeMethod(get);
            System.out.println(get.getStatusLine().toString());
            if(LOG.isDebugEnabled()) {
                LOG.debug("Publish Response: "+get.getStatusLine().toString());
            }
            String response = get.getResponseBodyAsString();
            System.out.println(response);
            if(LOG.isDebugEnabled()) {
                LOG.debug("Response Details: \n"+response);
            }
        }
        catch(HttpException he) {
            throw new PublishException("Unable to publish. "+he.getMessage(), he);
        }
        catch(IOException io) {
            throw new PublishException("Unable to publish. "+io.getMessage(), io);
        }
    }

    private HostConfiguration getHostConfiguration(PortletPublishConfig config) {
        HostConfiguration host = new HostConfiguration();
        host.setHost(config.getHost(), config.getPort(), config.getProtocol());
        return host;
    }
}
