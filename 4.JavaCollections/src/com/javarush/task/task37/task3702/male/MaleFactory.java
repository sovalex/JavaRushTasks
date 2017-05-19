package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by work on 20.02.2017.
 */
public class MaleFactory implements AbstractFactory{
    public Human getPerson(int age) {
        if (age < 13) {
            KidBoy kidBoy = new KidBoy();
            return kidBoy;
        } else if (age > 12 & age < 20) {
            TeenBoy teenBoy = new TeenBoy();
            return teenBoy;
        } else if(age>19) {
            Man man = new Man();
            return man;
        }
        return null;
    }
}
