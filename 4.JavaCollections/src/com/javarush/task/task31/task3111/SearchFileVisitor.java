package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> foundFiles = new ArrayList<Path>();
    private String partOfName;
    private String partOfContent;
    private int maxSize;
    private int minSize;

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isPartOfName = (partOfName == null) || file.getFileName().toString().contains(partOfName);
        boolean isPartOfContent = (partOfContent == null) || ispartOfContent(file);
        boolean isminSize = (minSize == 0) ||  Files.size(file) > minSize;
        boolean ismaxSize = (maxSize == 0) ||  Files.size(file) < maxSize;
        if (isPartOfName && isPartOfContent && ismaxSize && isminSize) {

            foundFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public boolean ispartOfContent(Path path) throws IOException {
        boolean found = false;
        List<String> list = new ArrayList<String>();
        list = Files.readAllLines(path);
        if (partOfContent != null) {
            for (String string : list) {
                if (string.contains(partOfContent)) {
                    found = true;
                    break;
                }
            }

        }
        return found;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }
}
