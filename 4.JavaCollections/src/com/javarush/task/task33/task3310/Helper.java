package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by work on 22.02.2017.
 */
public class Helper {
    public static String generateRandomString(){
        Random random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
