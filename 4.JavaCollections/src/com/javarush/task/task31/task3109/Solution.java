package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("//src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        File file = new File(fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (file.getName().endsWith(".xml")) {

                properties.loadFromXML(fileInputStream);
                fileInputStream.close();
            }else{
                properties.load(fileInputStream);
                fileInputStream.close();
            }
        } catch (Exception e) {

        }


        return properties;
    }
}
