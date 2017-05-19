package com.javarush.task.task38.task3810;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Changelog {
    Revision[] value() default {};
}
