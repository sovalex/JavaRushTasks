package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals =
                getAllAnimals("C:\\JavaRushTasks\\out\\production\\4.JavaCollections\\com\\javarush\\task\\task35\\task3507\\data");
                        //Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() +
                        //Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        File fileClass = new File(pathToAnimals);
        Set<Animal> set = new HashSet<>();
        for (File file : fileClass.listFiles()) {
            try {
                ClassLoader classLoader = new ClassLoader() {
                    @Override
                    public Class<?> loadClass(String name) throws ClassNotFoundException {
                        return super.loadClass(name);
                    }

                    @Override
                    public Class<?> findClass(String name) throws ClassNotFoundException {
                        try {
                            /**
                             * Получем байт-код из файла и загружаем класс в рантайм
                             */
                            byte b[] = fetchClassFromFS(file.getAbsolutePath());
                            return defineClass(null, b, 0, b.length);
                        } catch (FileNotFoundException ex) {
                            return super.findClass(file.getName().replace(".class",""));
                        } catch (IOException ex) {
                            return super.findClass(file.getName().replace(".class",""));
                        }
                    }
                };
                Class cl =  classLoader.loadClass(file.getName().replace(".class",""));
                Class[] inters =  cl.getInterfaces();
                for (Class cls :inters){
                    if(Animal.class.equals(cls)){
                       Constructor[] constructors = cl.getConstructors();
                        for(Constructor con:constructors ){
                            if(con.getParameterCount()==0& Modifier.isPublic(con.getModifiers())){
                               set.add((Animal) cl.newInstance());
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException c) {

            } catch (InstantiationException e) {

            } catch (IllegalAccessException e) {

            }
        }

        return set;

    }

    private static byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));

        // Get the size of the file
        long length = new File(path).length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+path);
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;

    }
}
