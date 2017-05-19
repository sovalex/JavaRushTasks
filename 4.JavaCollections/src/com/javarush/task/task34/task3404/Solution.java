package com.javarush.task.task34.task3404;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

/*
Рекурсия для мат. выражения
*/

public class Solution {
    public static void main(String[] args) {//sin(2*(-5+1.5*4)+28)
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        if (expression == null || expression.isEmpty()) {
            return;
        }
        Map<Integer,String> map = new HashMap<>();
        Locale.setDefault(Locale.ENGLISH);
        DecimalFormat df = new DecimalFormat("#.##");
        //System.out.println(expression + " " + countOperation);
        StringBuilder str = new StringBuilder();
        str.append(expression.replaceAll(" ", ""));
        int count = 0, j = 0, pos = 0;
        String buc = "", znak = "";
        while (str.charAt(j) != ')') {
            if (str.charAt(j) == '(') {
                buc = "";
            } else {
                buc += str.charAt(j);
            }
            if (j < str.length() - 1) {
                j++;
            } else break;
        }
        try {
            boolean negativeTwice = false;
            //System.out.println(str.toString() + " " + buc + " " + str.toString().equals(buc));
            if (!str.toString().equals(buc)) {
                if (buc.charAt(0) == '-' && buc.charAt(1) == '-') {
                    buc = buc.substring(2);
                    negativeTwice = true;
                    //System.out.println(negativeTwice);
                }
            }
            Double d = Double.parseDouble(buc);
           /* if (d < 0) {
                count += 1;
            }*/
            if (j - buc.length() - 4 >= 0 && str.substring(j - buc.length() - 4, j - buc.length() - 1).equals("sin")) {
                str.replace(j - buc.length() - 4, j + 1, String.valueOf(df.format(Math.sin(Math.toRadians(d)))));
                count += 1;
            } else if (j - buc.length() - 4 >= 0 && str.substring(j - buc.length() - 4, j - buc.length() - 1).equals("cos")) {
                str.replace(j - buc.length() - 4, j + 1, String.valueOf(df.format(Math.cos(Math.toRadians(d)))));
                count += 1;
            } else if (j - buc.length() - 4 >= 0 && str.substring(j - buc.length() - 4, j - buc.length() - 1).equals("tan")) {
                str.replace(j - buc.length() - 4, j + 1, String.valueOf(df.format(Math.tan(Math.toRadians(d)))));
                count += 1;
            } else {
                if (negativeTwice) {
                    str.replace(j - buc.length() - 3, j + 1, buc);
                } else str.replace(j - buc.length() - 1, j + 1, buc);

            }
        } catch (
                Exception e)

        {
        }
        if (buc.isEmpty()) buc = str.toString();
        //System.out.println(" j= " + j + " buc= " + buc);
        if (buc.contains("^")){
            znak = "^";
            pos = buc.indexOf(znak);
            map= operation(buc, znak, str.toString(), pos, j - buc.length(), df,count);
            str.replace(0, str.length(), map.get((Integer) map.keySet().toArray()[0]));
            count += 1+(Integer) map.keySet().toArray()[0];
        } else if (buc.contains("/")) {
            znak = "/";
            pos = buc.indexOf(znak);
            map= operation(buc, znak, str.toString(), pos, j - buc.length(), df,count);
            str.replace(0, str.length(), map.get((Integer) map.keySet().toArray()[0]));
            count += 1+(Integer) map.keySet().toArray()[0];
        } else if (buc.contains("*")) {
            znak = "*";
            pos = buc.indexOf(znak);
            map= operation(buc, znak, str.toString(), pos, j - buc.length(), df,count);
            str.replace(0, str.length(), map.get((Integer) map.keySet().toArray()[0]));
            count += 1+(Integer) map.keySet().toArray()[0];
        } else if (buc.contains("+") || buc.contains("-")) {
            int l = 0;
            if (buc.charAt(0) == '-' & buc.charAt(1) != '-') {
                l = 1;
                while (l < buc.length()) {
                    if (!Character.isDigit(buc.charAt(l)) && buc.charAt(l) != '.') {
                        znak = String.valueOf(buc.charAt(l));
                        //System.out.println("znak = "+znak);
                        map= operation(buc, znak, str.toString(), l, j - buc.length(), df,count);
                        str.replace(0, str.length(), map.get((Integer) map.keySet().toArray()[0]));
                        count += 1+(Integer) map.keySet().toArray()[0];
                        break;
                    }
                    l++;
                }
            } else if (buc.charAt(0) == '-' & buc.charAt(1) == '-') {
                l = 2;
                while (l < buc.length()) {
                    if (!Character.isDigit(buc.charAt(l)) && buc.charAt(l) != '.') {
                        znak = String.valueOf(buc.charAt(l));
                        //System.out.println("j - buc.length()+3 = " + (j - buc.length() + 3));
                        if (str.toString().equals(buc)) str.replace(0, str.length(), buc.substring(2));
                        map= operation(buc, znak, str.toString(), l, j - buc.length(), df,count);
                        str.replace(0, str.length(), map.get((Integer) map.keySet().toArray()[0]));
                        count += 1+(Integer) map.keySet().toArray()[0];
                        break;
                    }
                    l++;
                }
            } else if (buc.contains("-")) {
                znak = "-";
                pos = buc.indexOf(znak);
                if (buc.charAt(pos - 1) == '+' || buc.charAt(pos - 1) == '-') {
                    pos = pos - 1;
                    znak = String.valueOf(buc.charAt(pos));
                }
                map = operation(buc, znak, str.toString(), pos, j - buc.length(), df, count);
                str.replace(0, str.length(), map.get((Integer) map.keySet().toArray()[0]));
                count += 1+(Integer) map.keySet().toArray()[0];
            } else if (buc.contains("+")) {
                znak = "+";
                pos = buc.indexOf(znak);
                map= operation(buc, znak, str.toString(), pos, j - buc.length(), df,count);
                str.replace(0, str.length(), map.get((Integer) map.keySet().toArray()[0]));
                count += 1+(Integer) map.keySet().toArray()[0];
            }
        }

        try
        {
            Double res = Double.parseDouble(str.toString());//Math.rint(res*100)/100+" "+(countOperation+count)
            System.out.println(df.format(res) + " " + (countOperation + count));
        } catch (Exception e)

        {//String.format(Locale.ENGLISH,"%.2f %d",res,countOperation+count));
            recursion(str.toString(), countOperation + count);
        }

    }

    public Map<Integer,String> operation(String str, String sign, String strTotal, int pos, int offset, DecimalFormat df,int count) {
        Map<Integer,String> map = new HashMap<>();
        if (str.equals(strTotal)) {
            offset = 0;
        }
        int right = pos + 1;
        boolean rightNegative = false;
        String rigthDecimal = "";

        if (str.charAt(right) == '-') {
            rightNegative = true;
            right += 1;
        }
        while (Character.isDigit(str.charAt(right)) || str.charAt(right) == '.') {
            rigthDecimal += str.charAt(right);
            if (right < str.length() - 1) {
                right++;
            } else break;
        }
        if (right == str.length() - 1) {
            right += 1;
        }
        int left = pos - 1;
        StringBuilder leftDecimal = new StringBuilder();
        boolean leftNegative = false;
       /* System.out.println(pos);
        System.out.println(left);*/
        while (Character.isDigit(str.charAt(left)) || str.charAt(left) == '.'||str.charAt(left) == '&') {
            leftDecimal.append(str.charAt(left));
            if (left > 0) {
                left--;
            } else break;
        }

        if (str.charAt(left) == '-' && left == 0) {
            leftNegative = true;
        } else if (str.charAt(left) == '-' && !Character.isDigit(str.charAt(left - 1))) {
            leftNegative = true;
        } else if (str.charAt(left) == '+' || str.charAt(left) == '*' || str.charAt(left) == '/'
                || str.charAt(left) == '^'
                || str.charAt(left) == '-') {
            left = left + 1;
        }
        if (leftNegative) {
            //System.out.println(leftNegative);
            leftDecimal.append("-");
            count += 1;
        }
        leftDecimal = leftDecimal.reverse();

        //if(leftDecimal.toString().contains("&")) leftDecimal.replace(leftDecimal.indexOf("&"),1,"-");
        if (rightNegative) {
            rigthDecimal = "-" + rigthDecimal;
            count += 1;
        }

        /*System.out.println(leftDecimal);
        System.out.println(rigthDecimal);
        System.out.println(offset);
        System.out.println(left);
        System.out.println(right);
        System.out.println(str.length());
        System.out.println(sign);
        System.out.println(str.substring(left, right));*/
        StringBuilder buc1 = new StringBuilder();
        buc1.append(strTotal);
        if (sign.equals("*")) {
            buc1.replace(offset + left, offset + right,
                    String.valueOf(df.format(Double.parseDouble(leftDecimal.toString())
                    * Double.parseDouble(rigthDecimal))));
        } else if (sign.equals("/")) {
            buc1.replace(offset + left, offset + right,
                    String.valueOf(df.format(Double.parseDouble(leftDecimal.toString())
                    / Double.parseDouble(rigthDecimal))));
        } else if (sign.equals("^")) {
            if (leftNegative) {
                System.out.println(leftDecimal.toString().substring(1));
                buc1.replace(offset + left + 1, offset + right,
                        String.valueOf(df.format(Math.pow(Double.parseDouble(leftDecimal.toString().substring(1)),
                        Double.parseDouble(rigthDecimal)))));
            } else {
                buc1.replace(offset + left, offset + right,
                        String.valueOf(df.format(Math.pow(Double.parseDouble(leftDecimal.toString()),
                        Double.parseDouble(rigthDecimal)))));
            }
        } else if (sign.equals("-")) {
            buc1.replace(offset + left, offset + right,
                    String.valueOf(df.format(Double.parseDouble(leftDecimal.toString())
                    - Double.parseDouble(rigthDecimal))));
        } else if (sign.equals("+")) {
            buc1.replace(offset + left, offset + right,
                    String.valueOf(df.format(Double.parseDouble(leftDecimal.toString())
                    + Double.parseDouble(rigthDecimal))));
        }
        //System.out.println("buc1 = " + buc1.toString());
        map.put(count,buc1.toString());
        return map;
    }

    public Solution() {
        //don't delete
    }
}

