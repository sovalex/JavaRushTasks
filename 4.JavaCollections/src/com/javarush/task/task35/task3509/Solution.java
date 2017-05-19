package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T extends Object> ArrayList<T>  newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<T>();
        list.addAll(Arrays.asList((T[]) elements));
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> set = new HashSet<T>();
        set.addAll((Collection<? extends T>) Arrays.asList(elements));
        return set;
    }

    public static <K extends Object, V extends Object> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size()==values.size()){
            HashMap<K,V> map = new HashMap<K, V>();
            for(int i =0;i<keys.size();i++){
                map.put(keys.get(i),values.get(i));
            }
            return map;
        }else {
            throw new IllegalArgumentException();
        }
    }
}
