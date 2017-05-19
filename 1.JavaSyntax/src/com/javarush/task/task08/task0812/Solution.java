package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/*
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        while (i < 10) {
            list.add(scanner.nextInt());
            i++;
        }

        int count = 0;
        int max = Integer.MIN_VALUE;

        int j = list.get(0);
        for (Integer digit : list) {
            if (digit.compareTo(j)==0) {

                count++;
                max = (max > count) ? max : count;
            } else {
                j = digit;
                count = 1;
            }
        }
        System.out.println(max);

    }
}