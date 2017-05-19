package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> treeSet = new TreeSet<String>();
        try(FileInputStream fis = new FileInputStream(args[0])){
            byte[] bytes = new byte[fis.available()];
            while(fis.available()>0){
                fis.read(bytes,0,bytes.length);
            }
            for(byte b:bytes){
                if(b>=97&b<=122){
                    String s = String.valueOf((char) b);
                    treeSet.add(s);
                }else if(b>=65&b<=90){
                    String s = String.valueOf((char) b);
                    treeSet.add(s.toLowerCase());
                }
            }
            int i = 0;
            for(String s: treeSet){
                if(i<5){
                    System.out.print(s);
                    i++;
                }else break;

                }

            }
        }

    }

