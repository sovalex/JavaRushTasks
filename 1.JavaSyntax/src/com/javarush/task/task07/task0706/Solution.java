package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[15];
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        while (i < 15) {
            arr[i] = scanner.nextInt();
            i++;
        }
        int sumOdd = 0;
        int sumEven = 0;
        for (int k = 0; k < arr.length; k++) {

            if (k % 2 == 0) {
                sumOdd += arr[k];
            } else {
                sumEven += arr[k];
            }
        }
        if (sumOdd > sumEven) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}