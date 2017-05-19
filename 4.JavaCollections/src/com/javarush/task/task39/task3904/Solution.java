package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/
public class Solution {
    private static int n = 0;

    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {
            if (n < 0) return 0L;
            else if(n == 0) return 1L;
            else {
                long value0 = 1L;
                long value1 = 1L;
                long value2 = 2L;
                long value3 = 4L;
                for (int i = 0; i < n-2; i++){
                    value3 = value0+value1+value2;
                    value0 = value1;
                    value1 = value2;
                    value2 = value3;
                }
                return value3;
            }
        }

      /* if(n> 2){
            return countPossibleRunups(n-1)+countPossibleRunups(n-2) +countPossibleRunups(n-3);
        }else return n;*/
        /*double t = (double)1/3;
        double aplus = (double) Math.pow((19 + (double)3 * Math.sqrt(33)),t);
        //System.out.print(t);
        double aminus = (double) Math.pow((19 -(double) 3 * Math.sqrt(33)), t);

        double b = (double)Math.pow((586 +(double) 102 * Math.sqrt(33)), t);
        //System.out.print(b);
        double div = (double)3 * b * Math.pow(((t) * (aplus + aminus + 1)), n);
        double dv = (double)b * b - 2 * b + 4;
        //System.out.print(div);
        long res = (long) Math.round((double) div / dv);
        return res;*/
    //}
}

