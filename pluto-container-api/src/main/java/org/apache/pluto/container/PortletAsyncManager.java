package org.apache.pluto.container;

import javax.servlet.AsyncContext;

public interface PortletAsyncManager {

   void setWrapped(AsyncContext actx);
   void registerContext(boolean isListener);
   void deregisterContext(boolean isListener);
   void removeContext();
   void launchRunner();
   boolean isComplete();
   void setComplete(boolean complete);

}