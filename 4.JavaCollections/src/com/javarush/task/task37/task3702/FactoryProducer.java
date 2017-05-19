package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Created by work on 20.02.2017.
 */
public class FactoryProducer {
    public static enum HumanFactoryType{
        MALE,
        FEMALE;
    }
    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType){
        switch(humanFactoryType){
            case MALE:
                return new MaleFactory();
            case FEMALE:
                return  new FemaleFactory();
            default:
                return null;
        }
    }

}
