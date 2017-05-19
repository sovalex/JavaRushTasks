package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor Dpljr");
        System.out.println(decode(reader, -3));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        try {
            String s ="";
            StringWriter stringWriter = new StringWriter();
            String line = "";
            BufferedReader br = new BufferedReader(reader);
            //читаем строку из Reader’а
            while ((line=br.readLine())!=null) {

                stringWriter.write(line);
            }

            for (byte b : stringWriter.toString().getBytes()) {

                s += (char) ((b==32)?(b):(b+key));
            }
            return s;
        } catch (Exception e) {
            return "";
        }
    }

}
