package cn.enaium.cf4m.annotation.module;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Attached {@link Module}
 * <p>
 * Add this annotation to the class to that this class is a module extend
 *
 * @author Enaium
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Extend {
}
