package org.apache.pluto.container.om.portlet.impl.jsr286;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.pluto.container.om.portlet.DisplayName;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.UserDataConstraint;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.DisplayNameImpl;
import org.apache.pluto.container.om.portlet.impl.SecurityConstraintImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecurityConstraint286ImplTest {

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet286Generated.xml";
   
   private static PortletApplicationDefinition pad;
   
   private ArrayList<SecurityConstraint> constraints;
   private SecurityConstraint constraint;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      InputStream in = SecurityConstraint286ImplTest.class
            .getClassLoader().getResourceAsStream(XML_FILE);
      
      ConfigurationHolder cfp = new ConfigurationHolder();
      try {
         cfp.processPortletDD(in);
         pad = cfp.getPad();
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
   }
   
   @Before
   public void setUpBefore() throws Exception {
      constraints = new ArrayList<SecurityConstraint>();
      for (SecurityConstraint sc : pad.getSecurityConstraints()) {
         // test the copy constructor
         constraints.add(new SecurityConstraintImpl(sc));
      }
      assertEquals(1, constraints.size());
      constraint = constraints.get(0);
   }

   @Test
   // tests the UserDataConstraint as well
   public void testGetUserDataConstraint() {
      UserDataConstraint udc = constraint.getUserDataConstraint();
      assertNotNull(udc);
      
   }

   @Test
   public void testGetDisplayName() {
      Locale loc = new Locale("DE");
      DisplayName name = constraint.getDisplayName(loc);
      assertNotNull(name);
      assertEquals("display-name", name.getText());
   }

   @Test
   public void testGetDisplayNames() {
      List<DisplayName> list = constraint.getDisplayNames();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("display-name", list.get(0).getText());
   }

   @Test
   public void testAddDisplayName() {
      Locale loc = Locale.FRENCH;
      String text = "Some display name";
      DisplayName d = new DisplayNameImpl(loc, text);
      constraint.addDisplayName(d);

      List<DisplayName> list = constraint.getDisplayNames();
      assertNotNull(list);
      assertEquals(2, list.size());
      for (DisplayName desc : list) {
         if (desc.getLocale().equals(loc)) {
            assertEquals(text, desc.getText());
         } else {
            assertEquals("display-name", desc.getText());
         }
      }
   }

   @Test
   public void testGetPortletNames() {
      List<String> list = constraint.getPortletNames();
      assertNotNull(list);
      assertEquals(1, list.size());
   }

   @Test
   public void testAddPortletName() {
      String text = "SomeName";
      constraint.addPortletName(text);;

      List<String> list = constraint.getPortletNames();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertTrue(list.contains(text));
      assertTrue(list.contains("portlet.name"));
   }

}
