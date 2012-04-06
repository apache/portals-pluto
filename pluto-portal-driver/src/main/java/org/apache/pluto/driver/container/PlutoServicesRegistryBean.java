package org.apache.pluto.driver.container;

import org.apache.pluto.container.driver.PlutoServicesRegistry;
import org.apache.pluto.container.driver.PortalDriverServices;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PlutoServicesRegistryBean implements InitializingBean, DisposableBean {
    private PortalDriverServices portalDriverServices;

    public PlutoServicesRegistryBean(PortalDriverServices portalDriverServices) {
        this.portalDriverServices = portalDriverServices;
    }

    public void afterPropertiesSet() throws Exception {
        PlutoServicesRegistry.registerPortalDriverServices(portalDriverServices);
    }

    public void destroy() throws Exception {
        PlutoServicesRegistry.unregisterPortalDriverServices(portalDriverServices);        
    }
}
