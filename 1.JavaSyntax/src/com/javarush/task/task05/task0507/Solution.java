package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int count = 0;
        int sum = 0;
        while (true) {
            a = scanner.nextInt();
            if (a != -1) {
                sum += a;

                count++;
            }else break;
        }
        System.out.println((double)sum/count);
    }
}

