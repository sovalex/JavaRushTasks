package com.javarush.task.task31.task3113;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path path = Paths.get(str);
        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
        } else {
            int countDir = -1;
            int countFile = 0;
            long totalSize = 0;

            List<Path> pathList = Files.walk(Paths.get(str))
                    //.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            for (Path path1 : pathList) {
                if (Files.isDirectory(path1)) {
                    countDir++;
                } else {
                    totalSize += Files.size(path1);
                    countFile++;
                }
            }
            System.out.println("Всего папок - " + countDir);
            System.out.println("Всего файлов - " + countFile);
            System.out.println("Общий размер - " + totalSize);
        }
    }
}

