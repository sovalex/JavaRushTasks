package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int sz = 0;
        for (List<V> values : map.values()) {
            if (values.size() > 1) {
                sz += values.size()-1;
            }
        }
        return map.size() + sz;
    }

    @Override
    public V put(K key, V value) {
        List<V> append = new ArrayList<V>();
        List<V> list = null;
        if (!map.containsKey(key)) {
            append.add(value);
            map.put(key, append);
            return null;
        } else if (map.get(key).size() < repeatCount) {
            append.addAll(map.get(key));
            append.add(value);
            list = map.put(key, append);
            return list.get(list.size() - 1);
        } else if (map.get(key).size() == repeatCount) {
            append.addAll(map.get(key));
            append.remove(0);
            append.add(value);
            list = map.put(key, append);
            return list.get(list.size() - 1);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key)) {
            return null;
        }
        V value = null;
        if (map.get(key).size() > 0) {
            value = map.get(key).remove(0);
        }
        for(Iterator<Map.Entry<K, List<V>>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<K, List<V>> entry = it.next();
            if (entry.getValue().size() == 0) {
                it.remove();
            }
        }
        return value;
    }

    @Override
    public Set<K> keySet() {
        return  map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> total = new ArrayList<V>();
        for (List<V> list : map.values()) {
            total.addAll(list);
        }
        return total;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<V> values : map.values()) {
            if (values.contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}