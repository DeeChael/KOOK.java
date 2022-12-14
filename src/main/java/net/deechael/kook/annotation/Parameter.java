package net.deechael.kook.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Parameter {

    String name();

    String location() default "";

    Class<?> type();

    String mustBe() default "";

}
