package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {
            int number = Integer.parseInt(args[1]);
            String text = args[2];
            byte[] readBytes = new byte[text.length()];
            randomAccessFile.seek(number);
            randomAccessFile.read(readBytes, 0, readBytes.length);

            if (convertByteToString(readBytes).equals(text)) {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write("true".getBytes());
            } else {
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write("false".getBytes());
            }

        } catch (Exception e) {
        }

    }

    public static String convertByteToString(byte[] readBytes) {
        String string = "";
        for (byte b : readBytes) {
            string += (char) b;
        }
        return string;
    }
}
