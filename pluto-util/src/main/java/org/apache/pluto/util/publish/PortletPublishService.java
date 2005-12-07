package org.apache.pluto.util.publish;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Dec 5, 2005
 */
public interface PortletPublishService {

    void publish(PortletPublishConfig config) throws PublishException;

}
