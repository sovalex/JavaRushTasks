package com.javarush.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датами
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = null;
        Date dat = null;
        try {
        if(date.length()>15) {
            df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            dat = df.parse(date);
            calendar.setTime(dat);
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK)-1>0?calendar.get(Calendar.DAY_OF_WEEK)-1:7));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
            if (calendar.get(Calendar.AM_PM)==1) {
                System.out.println("AM или PM: PM");
            }else{
                System.out.println("AM или PM: AM");
            }
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }else if (date.contains(":")){
            df = new SimpleDateFormat("HH:mm:ss");
            dat = df.parse(date);
            calendar.setTime(dat);
            if (calendar.get(Calendar.AM_PM)==1) {
                System.out.println("AM или PM: PM");
            }else{
                System.out.println("AM или PM: AM");
            }
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));

        }else if (date.contains(".")){
            df = new SimpleDateFormat("dd.MM.yyyy");
            dat = df.parse(date);
            calendar.setTime(dat);
            System.out.println("День: " + calendar.get(Calendar.DATE));
            System.out.println("День недели: " + (calendar.get(Calendar.DAY_OF_WEEK)-1>0?calendar.get(Calendar.DAY_OF_WEEK)-1:7));
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
