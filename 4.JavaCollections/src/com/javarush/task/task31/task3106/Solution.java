package com.javarush.task.task31.task3106;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;


/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws Exception {

        String resultFileName = args[0];

        List<String> fileList = new ArrayList<>();

        fileList.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileList);

        List<FileInputStream> fileInputStreamList = new ArrayList<>();

        for (int i = 0; i < fileList.size(); i++) {

            try {
                fileInputStreamList.add(new FileInputStream(fileList.get(i)));
            } catch (FileNotFoundException e) {

            }
        }

        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(fileInputStreamList));

        ZipInputStream zipInStream = new ZipInputStream(sequenceInputStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        copyData(zipInStream, fileOutStream);
        sequenceInputStream.close();
        zipInStream.close();
        fileOutStream.close();
    }


    public static void copyData(ZipInputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[1024 * 1024];
        while (in.getNextEntry() != null) {
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        }

    }
}
