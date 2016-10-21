package org.apache.pluto.container;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequestWrapper;

public interface PortletAsyncManager {

   void setWrapped(AsyncContext actx);
   void registerContext(boolean isListener);
   void deregisterContext(boolean isListener);
   void removeContext();
   void launchRunner();
   boolean isComplete();
   void setComplete(boolean complete);
   void setContextInactive();
   HttpServletRequestWrapper getAsyncRequestWrapper();

}