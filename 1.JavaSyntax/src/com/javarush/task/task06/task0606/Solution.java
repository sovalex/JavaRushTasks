package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        while (true) {
            if ((a % 10) % 2 == 0 & a > 0) {

                a /= 10;
                even++;
            } else if ((a % 10) % 2 != 0 & a > 0) {

                a /= 10;
                odd++;
            } else if (a == 0) break;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
