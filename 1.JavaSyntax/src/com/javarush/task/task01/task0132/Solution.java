package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int d = 0;
        int sum =0;
        while(d<3){
            sum += number%10;
            number = number/10;
            d++;
        }
        return sum;
    }
}