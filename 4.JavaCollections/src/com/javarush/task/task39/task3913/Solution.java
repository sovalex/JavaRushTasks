package com.javarush.task.task39.task3913;

import java.nio.file.Paths;

import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/test/logs/"));
        //System.out.print(Event.DONE_TASK.toString());
        Set<Object> set = logParser.execute("get ip for status = \"OK\" and date between \"null\" and \"null\"");
        for(Object o:set){
            System.out.println(o.toString());
        }
        //System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
    }
}