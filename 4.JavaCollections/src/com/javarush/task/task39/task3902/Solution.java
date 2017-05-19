package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please type in a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("Number of ones in a given number is " + result);

    }

    public static boolean isWeightEven(long number) {
        System.out.println(Long.toBinaryString(number));
        String s = Long.toBinaryString(number);
        int sum = 0;
        for(int i =0;i<s.length();i++){
            sum += Integer.parseInt(""+(char)s.codePointAt(i));
        }
        if (sum%2 ==0){
            return true;
        }
        return false;
    }
}
