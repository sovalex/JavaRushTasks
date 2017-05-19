package com.javarush.task.task39.task3908;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("taaatt"));
    }

    public static boolean isPalindromePermutation(String s) {
        List<String> list = new ArrayList<String>();
        for (char ch : s.toLowerCase().trim().toCharArray()) {
            list.add(String.valueOf(ch));
        }
        int p = 0;
        String s1 = "";
        for (String str : list) {
            int fr = Collections.frequency(list, str);
            if (fr % 2 != 0 &&!s1.equals(str))  {
                s1 = str;
                p += 1;
            }
        }
        if (p > 1) {
            return false;
        } else {
            return true;
        }
    }
}
