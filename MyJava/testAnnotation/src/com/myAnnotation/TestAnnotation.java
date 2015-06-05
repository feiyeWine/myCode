package com.myAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ×¢½â
 * @author YR
 *
 */
@Target(value = {ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String column();
    String uname();
    int length() default 10;
}
