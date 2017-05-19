package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by work on 25.02.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String fileName = f.getName().toLowerCase();

        if (fileName.endsWith(".html") || fileName.endsWith(".htm")) {
            return true;

        }else return false;
    }

    @Override
    public String getDescription() {

        return "HTML и HTM файлы";

    }
}
