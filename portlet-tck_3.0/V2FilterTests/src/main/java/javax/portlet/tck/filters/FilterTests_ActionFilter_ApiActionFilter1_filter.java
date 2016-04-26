package javax.portlet.tck.filters;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.PortletSession.*;
import static javax.portlet.ResourceURL.*;

/**
 * Filter for JSR 362 request dispatcher testing.
 * Used by portlet: FilterTests_ActionFilter_ApiActionFilter
 *
 * @author nick
 *
 */
public class FilterTests_ActionFilter_ApiActionFilter1_filter implements ActionFilter {
   private static final String LOG_CLASS = 
         FilterTests_ActionFilter_ApiActionFilter1_filter.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

   private FilterConfig filterConfig;

   @Override
   public void init(FilterConfig filterConfig) throws PortletException {
      this.filterConfig = filterConfig;
   }

   @Override
   public void destroy() {
   }
  
   @Override
   public void doFilter(ActionRequest portletReq, ActionResponse portletResp,
         FilterChain chain) throws IOException, PortletException {
      LOGGER.entering(LOG_CLASS, "doFilter");
      StringWriter writer = new StringWriter();

      // first execute the chain
      
    	  chain.doFilter(portletReq, portletResp);
     
    	 
      
         
     
      
      portletReq.getPortletSession().setAttribute(
              Constants.RESULT_ATTR_PREFIX + "FilterTests_ActionFilter_ApiActionFilter1",
              writer.toString(), APPLICATION_SCOPE);
   }
   
}

