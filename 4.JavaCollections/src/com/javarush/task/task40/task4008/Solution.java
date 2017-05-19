package com.javarush.task.task40.task4008;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }
    public static String normalizeFormatDate(String[] strings){
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
    }

    public static String normalizeFormatTime(String[] strings){
        String dat = "";
        if (strings[1].length() == 1) {
            strings[1] = "0" + strings[1];
        }
        if (strings[0].length() ==1){
            strings[0] = "0" + strings[0];
        }
        if (strings[2].length() ==1){
            strings[2] = "0" + strings[2];
        }
        for (String s1 : strings) {
            dat += s1 + ":";
        }
        return  dat.substring(0, dat.length() - 1);
    }


    public static void printDate(String date) {
        String[] strings = date.split(" ");
        String[] dates = null;
        String[] times = null;
        String dateTime ="";
        if (strings.length>1){
            dates = strings[0].split("\\.");
            times = strings[1].split(":");
            dateTime = normalizeFormatDate(dates) +" "+normalizeFormatTime(times);
        }else if(date.contains(".") ){
            dates = strings[0].split("\\.");
            dateTime = normalizeFormatDate(dates);

        }else if (date.contains(":")){
            times = strings[0].split(":");
            dateTime = normalizeFormatTime(times);
        }

        try {
            if (dateTime.length() > 15) {
                LocalDate ld = LocalDate.parse(dateTime.split(" ")[0],
                       DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                LocalTime lt = LocalTime.parse(dateTime.split(" ")[1],
                        DateTimeFormatter.ofPattern("HH:mm:ss"));
                System.out.println("День: " + ld.getDayOfMonth());
                System.out.println("День недели: " + digitalDayOfWeek(ld.getDayOfWeek()));
                System.out.println("День месяца: " + ld.getDayOfMonth());
                System.out.println("День года: " + ld.getDayOfYear());
                WeekFields weekFields = WeekFields.of(Locale.getDefault());
                int weekNumberMonth = ld.get(weekFields.weekOfMonth());
                System.out.println("Неделя месяца: " + weekNumberMonth);
                int weekNumberYear = ld.get(weekFields.weekOfWeekBasedYear());
                System.out.println("Неделя года: " + weekNumberYear);
                System.out.println("Месяц: " + ld.getMonthValue());
                System.out.println("Год: " + ld.getYear());
                if (lt.getHour() > 12) {
                    System.out.println("AM или PM: PM");
                    System.out.println("Часы: " + (lt.getHour() - 12));
                } else {
                    System.out.println("AM или PM: AM");
                    System.out.println("Часы: " + lt.getHour());
                }
                System.out.println("Часы дня: " + lt.getHour());
                System.out.println("Минуты: " + lt.getMinute());
                System.out.println("Секунды: " + lt.getSecond());
            } else if (dateTime.contains(":")) {
                LocalTime ldt = LocalTime.parse(dateTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
                if (ldt.getHour() > 12) {
                    System.out.println("AM или PM: PM");
                    System.out.println("Часы: " + (ldt.getHour() - 12));
                } else {
                    System.out.println("AM или PM: AM");
                    System.out.println("Часы: " + ldt.getHour());
                }

                System.out.println("Часы дня: " + ldt.getHour());
                System.out.println("Минуты: " + ldt.getMinute());
                System.out.println("Секунды: " + ldt.getSecond());
            } else if (dateTime.contains(".")) {
                LocalDate ldt = LocalDate.parse(dateTime, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                System.out.println("День: " + ldt.getDayOfMonth());
                System.out.println("День недели: " + digitalDayOfWeek(ldt.getDayOfWeek()));
                System.out.println("День месяца: " + ldt.getDayOfMonth());
                System.out.println("День года: " + ldt.getDayOfYear());
                WeekFields weekFields = WeekFields.of(Locale.getDefault());
                int weekNumberMonth = ldt.get(weekFields.weekOfMonth());
                System.out.println("Неделя месяца: " + weekNumberMonth);
                int weekNumberYear = ldt.get(weekFields.weekOfWeekBasedYear());
                System.out.println("Неделя года: " + weekNumberYear);
                System.out.println("Месяц: " + ldt.getMonthValue());
                System.out.println("Год: " + ldt.getYear());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int digitalDayOfWeek(DayOfWeek month) {
        switch (month) {
            case MONDAY:
                return 1;
            case TUESDAY:
                return 2;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 4;
            case FRIDAY:
                return 5;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 7;

            default:
                return 0;
        }
    }
}

