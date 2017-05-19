package com.javarush.task.task29.task2909.human;

/**
 * Created by work on 10.02.2017.
 */
public class Soldier extends Human {

    @Override
    public String getPosition() {
        return super.getPosition();
    }

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {

            fight();
    }
    public void fight() {
    }
}
