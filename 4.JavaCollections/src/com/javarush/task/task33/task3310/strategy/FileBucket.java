package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by work on 22.02.2017.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

    }

    //, он должен возвращать размер файла на который указывает path.
    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        return 0L;
    }

    //— должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.
    public void putEntry(Entry entry) {
        try ( ObjectOutputStream obs = new ObjectOutputStream(Files.newOutputStream(path))){
            obs.writeObject(entry);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    //— должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
    public Entry getEntry() {
        if(getFileSize()<=0){
            return null;
        }
        try (ObjectInputStream obs = new ObjectInputStream(Files.newInputStream(path))){
            Object obj = obs.readObject();
            Entry entry = (Entry) obj;
            return entry;
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }catch (ClassNotFoundException e){
            ExceptionHandler.log(e);
        }
        return null;
    }

    //– удалять файл на который указывает path.
    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
