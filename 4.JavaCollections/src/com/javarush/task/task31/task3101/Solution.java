package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        String directoryPath = args[0];
        String resultFileAbsolutePath11 = args[1];
        String allFilesContent = "allFilesContent.txt";

        Path source = Paths.get(resultFileAbsolutePath11);
        Path out = source.resolveSibling(allFilesContent);

        List<File> list = new ArrayList<File>();

        File resultFileAbsolutePath = new File(source.toString());
        File resultFile = new File(out.toString());
        File folder = new File(directoryPath);

        FileUtils.renameFile(resultFileAbsolutePath,resultFile);
        BufferedOutputStream  write = null;
            try{
                write= new BufferedOutputStream(new FileOutputStream(resultFile));
                list = findAllFiles(folder, list);
                Collections.sort(list, new Comparator<File>() {
                    @Override
                    public int compare(File o1, File o2) {

                        return o1.getName().compareTo(o2.getName());
                    }
                });

            for (File file : list) {
                BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[reader.available()];
                while (reader.available()>0) {
                    reader.read(buffer,0,reader.available());
                    write.write(buffer,0,buffer.length);
                }
                reader.close();
                write.flush();
                write.write(10);
            }
        }catch(IOException e){

        }finally{
            try {
                write.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static List<File> findAllFiles(File folder, List<File> list) {

        for (File file : folder.listFiles()) {
            if (file.length() <= 50 & file.isFile()) {
                list.add(file);
            } else {
                FileUtils.deleteFile(file);
            }
            if (file.isDirectory()) {
                findAllFiles(file, list);
            }

        }
        return list;
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
