package org.apache.pluto.container;

import javax.servlet.AsyncContext;

public interface PortletAsyncContext extends AsyncContext {

   void init(PortletResourceRequestContext prctx);

   /**
    * @param actx the async context to set
    */
   void setWrapped(AsyncContext actx);

}