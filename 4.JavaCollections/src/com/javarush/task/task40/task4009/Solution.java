package com.javarush.task.task40.task4009;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(weekDayOfBirthday("30.05.1984", "2015"));
    }

    public static String weekDayOfBirthday(String birthday, String year) {
        //String dat = "";
        //String[] strings = birthday.split("\\.");
        //dat = normalizeFormatDate(strings);
        LocalDate ldt = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("d.M.yyyy"));
        Year year1 = Year.parse(year);
        LocalDate nw = ldt.with(year1);
        return nw.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ITALIAN);
    }
   /* public static String normalizeFormatDate(String[] strings){
        String dat = "";
        if (strings[1].length() == 1) {
            strings[1] = "0" + strings[1];
        }
        if (strings[0].length() ==1){
            strings[0] = "0" + strings[0];
        }
        for (String s1 : strings) {
            dat += s1 + ".";
        }
        return  dat.substring(0, dat.length() - 1);
    }*/
}
