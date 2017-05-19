package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        StringBuilder sb = new StringBuilder(number+" =");
        int remainder = 0;
        int pow = 0;
        int i = 0;
        while(true){

            if (number == 1){
                i = (int) Math.pow(3,pow);
                sb.append(" + " +i);
                break;
            }
            remainder = number%3;
            if (remainder==2 ){
                number = number/3 +1;
                i = (int) Math.pow(3,pow);
                sb.append(" - "+i);
                pow++;
            }else if(remainder%3==1){
                number = number/3;
                i = (int) Math.pow(3,pow);
                sb.append(" + " +i);
                pow++;
            }else if(remainder%3 == 0){
                pow++;
                number = number/3;
            }
        }
        System.out.print(sb.toString());
    }
}