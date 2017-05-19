package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {
        System.out.print(isPowerOfThree(3));
    }

    public static boolean isPowerOfThree(int n) {

        if (n % 3 == 0) {
            if (n / 3 > 1) {
                return isPowerOfThree(n / 3);
            } else{
                if (n ==0){
                    return false;
                }else return true;
            }
        } else {
            if (n == 1) {
                return true;
            } else return false;
        }
    }
}
