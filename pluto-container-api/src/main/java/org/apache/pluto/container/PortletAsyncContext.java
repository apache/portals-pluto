package org.apache.pluto.container;

import javax.enterprise.inject.spi.BeanManager;
import javax.portlet.ResourceRequest;
import javax.servlet.AsyncContext;

public interface PortletAsyncContext extends AsyncContext {

   void init(PortletResourceRequestContext prctx, ResourceRequest resreq, BeanManager beanmgr);
   void setWrapped(AsyncContext actx);
   void registerContext();
   void deregisterContext();
   void removeContext();

}