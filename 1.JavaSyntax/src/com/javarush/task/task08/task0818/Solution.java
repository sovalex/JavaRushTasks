package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("fsfs",1000);
        map.put("ftfs",1000);
        map.put("fffs",1000);
        map.put("fhfs",1000);
        map.put("fnfs",1000);
        map.put("fcfs",1000);
        map.put("fmfs",1000);
        map.put("fafs",1010);
        map.put("fefs",450);
        map.put("fwfs",1000);
        return (HashMap<String,Integer>)map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        for(Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();iterator.hasNext();){
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue()<500){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}