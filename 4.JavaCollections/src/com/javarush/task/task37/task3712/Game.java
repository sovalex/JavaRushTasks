package com.javarush.task.task37.task3712;

/**
 * Created by work on 24.02.2017.
 */
public abstract class Game {
    public abstract void prepareForTheGame();
    public abstract void playGame();
    public abstract void congratulateWinner();
    void run(){
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
