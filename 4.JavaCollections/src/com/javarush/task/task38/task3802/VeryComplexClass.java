package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileInputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("ytut");

    }

    public static void main(String[] args) {

    }
}
