package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by work on 22.02.2017.
 */
public class Solution {
    public static void main(String... args) {

        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 500);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> setKey = new HashSet<Long>();
        for (String string : strings) {
            setKey.add(shortener.getId(string));
        }
        return setKey;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> setValue = new HashSet<String>();
        for (Long key : keys) {
            setValue.add(shortener.getString(key));
        }
        return setValue;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Set<String> setValue = new HashSet<String>();
        Set<String> setValue1 = new HashSet<String>();
        Set<Long> setkey = new HashSet<Long>();
        Helper.printMessage(strategy.getClass().getSimpleName());

        for (int i = 0; i < elementsNumber; i++) {
            setValue.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date dateStart1 = new Date();
        setkey.addAll(getIds(shortener, setValue));
        Date dateEnd1 = new Date();
        Helper.printMessage("getId -" + String.valueOf(dateEnd1.getTime() - dateStart1.getTime()));

        Date dateStart2 = new Date();
        setValue1.addAll(getStrings(shortener, setkey));
        Date dateEnd2 = new Date();
        Helper.printMessage("getString -  " + String.valueOf(dateEnd2.getTime() - dateStart2.getTime()));
        if (setValue1.containsAll(setValue) && setValue.size() == setValue1.size()) {
            Helper.printMessage("Тест пройден.");

        } else Helper.printMessage("Тест не пройден.");
    }
}

