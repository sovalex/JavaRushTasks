package com.javarush.task.task38.task3804;

/**
 * Created by work on 26.02.2017.
 */
public class FactotyException {

    public static Throwable getException(Enum e) {
        if (e != null) {
            String mes = e.name().substring(0,1)+e.name().substring(1).toLowerCase().replace("_"," ");
            if (e instanceof ExceptionApplicationMessage) {
                return new Exception(mes);
            } else if (e instanceof ExceptionDBMessage) {
                return new RuntimeException(mes);
            } else if (e instanceof ExceptionUserMessage) {
                return new Error(mes);
            }
        }
        return  new IllegalArgumentException();
    }
}
