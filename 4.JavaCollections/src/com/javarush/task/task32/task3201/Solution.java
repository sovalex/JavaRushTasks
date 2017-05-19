package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(args[0],"rw")){
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        byte[] bytes = text.getBytes();
        if(number< randomAccessFile.length()){
            randomAccessFile.seek(number);
            randomAccessFile.write(bytes);
        }else{
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(bytes);
        }
        }catch(Exception e){}
    }
}
