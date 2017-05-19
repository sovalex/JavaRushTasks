package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Проверка на упорядоченность
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

        int j = list.get(0).length();
        for (int k = 1; k < list.size(); k++) {

            if (list.get(k).length() > j) {
                j = list.get(k).length();
            } else {
                System.out.println(k);
                break;
            }
        }
    }
}

