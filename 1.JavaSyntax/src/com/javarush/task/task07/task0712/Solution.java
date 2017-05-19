package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        while (i < 10) {
            list.add(scanner.nextLine());
            i++;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (String str : list) {
            min = (min < str.length()) ? min : str.length();
            max = (max > str.length()) ? max : str.length();
        }
        for (String str : list) {
            if (min == str.length()||max ==str.length()){
                System.out.println(str);
                break;
            }
        }

    }
}
