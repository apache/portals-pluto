package org.apache.pluto.container.bean.processor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;

import javax.inject.Qualifier;

/**
 * An annotation that is used as a qualifier for events fired when
 * a name is added.
 * 
 * @author nick
 *
 */
/* 
 * Just making a new annotation for our event.
 * What we learn from here is not only implementations
 * but also events can be specified as a Qualifier.
 * To see the usage - See FormController class
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Target({FIELD, METHOD, PARAMETER, TYPE})
public @interface PortletEvent {}
