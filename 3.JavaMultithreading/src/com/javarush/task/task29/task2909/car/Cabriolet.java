package com.javarush.task.task29.task2909.car;

/**
 * Created by work on 10.02.2017.
 */
public class Cabriolet extends  Car {
    private final int MAX_CABRIOLET_SPEED = 90;

    public Cabriolet(int numberOfPassengers) {
        super(2, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
