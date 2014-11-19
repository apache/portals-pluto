package basic.portlet;

import java.util.HashMap;
import java.util.Map;

public class Constants {
   
   // maps the names of the images to the paths to the images -
   public final static Map<String, String> imgMap = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
   {
      put("baseball", "/resources/images/baseball-trans.gif");
      put("golfball", "/resources/images/golfball-trans.gif");
      put("fussball", "/resources/images/fussball-trans.gif");
   }};

   public final static String DEFAULT_IMAGE = "/resources/images/FullMoon.gif";

   public final static String PARAM_SELTYPE = "selType";
   public final static String PARAM_SELTYPE_RADIO = "radio";
   public final static String PARAM_SELTYPE_DROPDOWN = "dropdown";
   
   public final static String PARAM_IMGNAME = "imgName";
   public final static String PARAM_COLOR = "color";
   public final static String PARAM_ERRMSG = "errmsg";
   public final static String PARAM_BORDER = "bo";
   public final static String PARAM_BORDER_COLOR = "border";
   public final static String PARAM_CACHE = "ca";
   public final static String PARAM_CACHE_PAGE = "pa";
   public final static String PARAM_CACHE_PORTLET = "po";
   public final static String PARAM_CACHE_FULL = "fu";
}
