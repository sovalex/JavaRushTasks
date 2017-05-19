package com.javarush.task.task38.task3811;

import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.scene.layout.Priority;

import java.lang.annotation.*;

/**
 * Created by work on 26.02.2017.
 */
@Retention(RetentionPolicy.RUNTIME)//Должна быть доступна во время выполнения программы.
@Target(value = ElementType.TYPE )//Применяться может только к новым типам данных.
public @interface Ticket {

    enum Priority {
        LOW,
        MEDIUM,
        HIGH;
    }
    Priority priority() default Priority.MEDIUM;
    String[] tags() default {};
    String createdBy() default "Amigo";

}

