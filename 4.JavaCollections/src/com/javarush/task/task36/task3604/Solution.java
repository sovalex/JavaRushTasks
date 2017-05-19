package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(13);
        redBlackTree.insert(5);
        redBlackTree.insert(4);
        redBlackTree.insert(16);
        redBlackTree.insert(8);//13, 5, 4, 16, 8, 11, 10
        redBlackTree.insert(11);
        redBlackTree.insert(10);
    }
}
