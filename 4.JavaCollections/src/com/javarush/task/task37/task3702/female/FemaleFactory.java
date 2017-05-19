package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by work on 20.02.2017.
 */
public class FemaleFactory implements AbstractFactory{
    public Human getPerson(int age) {
        if (age < 13) {
            KidGirl kidGirl = new KidGirl();
            return kidGirl;
        } else if (age > 12 & age < 20) {
            TeenGirl teenGirl = new TeenGirl();
            return teenGirl;
        } else if(age>19) {
            Woman woman = new Woman();
            return woman;
        }
        return null;
    }
}
