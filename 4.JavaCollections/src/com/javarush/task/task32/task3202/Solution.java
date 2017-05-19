package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c:/test/properties.txt"));///testFile.log"));
        System.out.println(writer.toString());

    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        try {
            byte[] bytes = new byte[is.available()];
            while (is.available() > 0) {
                is.read(bytes);
            }
            String s = "";
            for (byte b : bytes) {
                s += (char) b;
            }

            StringWriter stringWriter = new StringWriter();
            stringWriter.write(s);
            if (stringWriter == null) {
                return new StringWriter();
            } else return stringWriter;
        } catch (Exception e) {
            return new StringWriter();
        }
    }
}