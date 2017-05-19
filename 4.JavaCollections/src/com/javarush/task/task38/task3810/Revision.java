package com.javarush.task.task38.task3810;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Calendar;


public @interface Revision {
    int revision();
    Date date() ;
    Author[] authors() default {};
    String comment() default "";

}
