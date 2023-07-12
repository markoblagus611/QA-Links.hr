package utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Verify {
    String INVALID_TITLE = "\0";
    String title() default INVALID_TITLE;
    String INVALID_XPATH = "\0";
    String xpath() default INVALID_XPATH;
    String INVALID_CSS = "\0";
    String css() default INVALID_CSS;
}