package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import static com.javarush.task.task38.task3804.FactotyException.getException;

public class Solution {
    public static Class getFactoryClass() {

        return FactotyException.class;
    }

    public static void main(String[] args) {

            Throwable e = getException(ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT);
        System.out.println(e.getMessage());
    }
}