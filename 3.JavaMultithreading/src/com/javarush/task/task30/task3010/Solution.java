package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/


import java.math.BigInteger;





public class Solution {
    public static void main(String[] args) {
            int j = 0;
            Boolean found = false;
            for (j = 36; j >= 2; ) {
                try {
                    new BigInteger(args[0], j).toString();
                    found = true;
                    j--;
                } catch (Exception e) {
                    break;
                }
            }
            if (found) System.out.println(j+1);
            else System.out.println("incorrect");
    }
}