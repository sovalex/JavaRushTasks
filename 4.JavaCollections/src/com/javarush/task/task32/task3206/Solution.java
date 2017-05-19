package com.javarush.task.task32.task3206;

import com.javarush.task.task32.task3206.Big;
import com.javarush.task.task32.task3206.Item;
import com.javarush.task.task32.task3206.Small;

import java.lang.reflect.Proxy;

/* 
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
    public <T extends Item> T getProxy(Class<T> cl,Class<?>...cls){

        ClassLoader classLoader = cl.getClassLoader();
        Class<?>[] interfaces = new Class[cls.length+1];
        System.arraycopy(cls,0,interfaces,0,cls.length);
        interfaces[interfaces.length-1] = cl;
        ItemInvocationHandler invocationHandler = new ItemInvocationHandler();

        return (T) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

    }
}