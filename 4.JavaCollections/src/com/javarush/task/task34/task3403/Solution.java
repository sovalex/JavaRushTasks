package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public static void main(String... args) {
        Solution solution = new Solution();
        solution.recursion(1322);
    }

    public void recursion(int n) {
        int i = 2;
        if (n % i == 0) {
            System.out.print(i + " ");
            recursion(n / i);
        } else {
            while (true) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                    recursion(n / i);
                    break;
                } else {
                    if(n<2)break;else i++;
                }
            }
        }
    }
}
