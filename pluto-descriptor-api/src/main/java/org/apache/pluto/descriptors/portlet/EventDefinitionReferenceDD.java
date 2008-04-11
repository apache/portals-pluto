package org.apache.pluto.descriptors.portlet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.apache.pluto.om.portlet.EventDefinitionReference;

/**
 * 
 * the event definition reference type
 * 
 * <complexType name="event-definition-referenceType">
 *		&lt;annotation&gt;
 *			<documentation>
 * 			The event-definition-referenceType is used to refernece events 
 *			declared with the event-definition element on application level.
 *			Used in: portlet
 *			</documentation>
 *		&lt;/annotation&gt;
 *		<choice>
 *			<element name="qname" type="xs:QName"/>
 *			<element name="name" type="string"/>
 *		</choice>
 *		<attribute name="id" type="string" use="optional"/>
 *	</complexType>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "event-definition-referenceType", propOrder = {
    "qname",
    "name"
})
public class EventDefinitionReferenceDD implements EventDefinitionReference {
	
	/**
	 * Name of the Event
	 * <choice>
	 * 		<element name="qname" type="xs:QName"/>
	 * 		<element name="name" type="string"/>
	 * </choice>
	 */
	private QName qname;	
	private String name;
	
	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.EventDefinitionReference#getName()
	 */
	public QName getName() {
		if ((qname == null) && (name == null))
			return null;		
		return (qname==null) ? new QName(name) : qname; 
	}

	/* (non-Javadoc)
	 * @see org.apache.pluto.descriptors.portlet.EventDefinitionReference#setName(javax.xml.namespace.QName)
	 */
	public void setName(QName qname) {
		this.qname = qname;
	}

}
