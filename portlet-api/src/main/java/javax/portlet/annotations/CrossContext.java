package javax.portlet.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;

import javax.inject.Qualifier;

/**
 * An annotation that is used as a qualifier for cross context
 * CDI events 
 * 
 * @author ahmed
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Target({FIELD, PARAMETER})
public @interface CrossContext {}
