package com.bridgelabz.customannotation.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Amrut";
    String date();
    int revision() default 1;
    String comments();
}