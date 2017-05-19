package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
        for (Class clazz : classes) {
            if(List.class.isAssignableFrom(clazz)&&
                    Modifier.isPrivate(clazz.getModifiers())&&
                    Modifier.isStatic(clazz.getModifiers())){
                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    try {
                        List list = (List) constructor.newInstance();
                        try {
                            list.get(0);
                        }catch(IndexOutOfBoundsException ei){
                            if (clazz!=null)
                            return clazz;
                            //System.out.println(clazz.getSimpleName());
                        }
                    } catch (InstantiationException e) {

                    } catch (IllegalAccessException e) {

                    } catch (InvocationTargetException e) {

                    }
                } catch (NoSuchMethodException e) {
                }

                }

            }

        return null;
    }
}
