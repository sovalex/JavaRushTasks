package com.javarush.task.task28.task2812;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        List<Runnable> list = new ArrayList<Runnable>( executor.shutdownNow());
       for (Runnable runnable : list){
           System.out.println(runnable.toString()+" was not completed");
       }

    }

    private static void doExpensiveOperation(int localId) {
            System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}