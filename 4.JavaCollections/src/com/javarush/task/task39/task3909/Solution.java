package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("rrrrrrrrrrrggggjhhg", "rrrrrrrrsrrggggjhhg"));
    }

    public static boolean isOneEditAway(String first, String second) {
        int dif = 0;
        String s1, s2 = null;
        if (first == null || second == null) {
            return false;
        }
        int a = first.length() - second.length();
        if (Math.abs(a) > 1) {
            return false;
        }
        if (a > 0) {
            if (first.contains(second)) {
                return true;
            }
            s1 = first;
            s2 = second;

        } else if (a < 0) {
            if (second.contains(first)) {
                return true;
            }
            s1 = second;
            s2 = first;
        } else {
            if (first.equals(second)) {
                return true;
            }
            s1 = first;
            s2 = second;
        }
        int i = 0;
        int j = 0;
        while (i < s1.length()) {
            if (s1.codePointAt(i) != s2.codePointAt(j)) {
                dif += 1;
                if (s1.length() > s2.length()) {
                    i++;
                    System.out.println(s1);

                }else if(s1.length() == s2.length()){
                   i++;j++;
                }
            }else {
                    i++;
                    j++;
            }
            if (dif > 1) {
                return false;
            }
        }
        return true;
    }
}
