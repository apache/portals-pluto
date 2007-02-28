package org.apache.pluto.spi.optional;

import org.apache.pluto.spi.ContainerService;
import org.apache.pluto.PortletContainerException;

import javax.portlet.PortletRequest;
import java.util.Map;

/**
 * Used to access user information attributes as described in
 * PLT.17.2 of the JSR-168 specificiation. Attribute persistence is
 * not covered by the spec so it is not done here.
 *
 * @author <a href="cdoremus@apache.org">Craig Doremus</a>
 * @author <a href="ddewolf@apache.org">David DeWolf</a>
 */
public interface UserInfoService extends ContainerService {
    /**
     * To access user information attributes as defined in PLT.17
     * of JSR-168.
     *
     * @param request Used to extract the authenticated user name.
     * @return A map of names and values of user information attributes
     *         for a particular authenticated user.
     */
    Map getUserInfo(PortletRequest request) throws PortletContainerException;
}
