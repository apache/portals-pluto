package org.apache.pluto.descriptors.portlet;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.pluto.om.portlet.ContainerRuntimeOption;

/**
 * <pre>
 * &lt;complexType name="container-runtime-optionType">
 *		&lt;annotation>
 *			&lt;documentation>
 *			 The container-runtime-option element contains settings
 *			 for the portlet container that the portlet expects to be honored
 *			 at runtime. These settings may re-define default portlet container
 *			 behavior, like the javax.portlet.escapeXml setting that disables
 *			 XML encoding of URLs produced by the portlet tag library as
 *			 default.
 *			 Names with the javax.portlet prefix are reserved for the Java
 *			 Portlet Specification.
 *			Used in: portlet-app, portlet
 *			&lt;/documentation>
 * 		&lt;/annotation>
 * 		&lt;sequence>
 *			&lt;element name="name" type="portlet:nameType"/>
 * 			&lt;element name="value" type="portlet:valueType" minOccurs="0" maxOccurs="unbounded"/>
 *		&lt;/sequence>
 *	&lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container-runtime-optionType", propOrder = {
    "name",
    "value"
})
public class ContainerRuntimeOptionDD implements ContainerRuntimeOption {

	private String name = null;
	
	private List<String> value = null;

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.ContainerRuntimeOption#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.ContainerRuntimeOption#getValue()
	 */
	public List<String> getValue() {
		return value;
	}
}
