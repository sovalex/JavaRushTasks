package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        String str = "";
        if (s==null||s.isEmpty()){
            return 0;
        }
        List<String> list = new ArrayList<String>();
       for(int j= 0;j<s.length();j++) {
           str="";
           for (int i = j; i < s.length(); i++) {

               if (!str.contains("" + (char) s.codePointAt(i))) {
                   str += (char) s.codePointAt(i);
                   //System.out.println(str);
               } else {

                   str = "" + (char) s.codePointAt(i);
               }
               list.add(str);
           }
       }
        str="";
        for(String s1: list){
            if(str.length()<s1.length()){
                //System.out.println(s1);
                str=s1;
            }

        }
            return str.length();
        }
    }
