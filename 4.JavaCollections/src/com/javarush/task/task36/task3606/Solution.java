package com.javarush.task.task36.task3606;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
        System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        File file = new File(packageName);
        for (File file1 : file.listFiles()) {
            if (file1.getName().endsWith(".class")) {
                ClassLoader classLoader = new ClassLoader() {
                    @Override
                    protected Class<?> findClass(String name) throws ClassNotFoundException {
                        try {
                            /**
                             * Получем байт-код из файла и загружаем класс в рантайм
                             */
                            byte b[] = fetchClassFromFS(file1.getAbsolutePath());
                            return defineClass(null, b, 0, b.length);
                        } catch (FileNotFoundException ex) {
                            return super.findClass(file1.getName().replace(".class", ""));
                        } catch (IOException ex) {
                            return super.findClass(file1.getName().replace(".class", ""));
                        }
                    }
                };
                Class cl = null;
                try {
                    cl = classLoader.loadClass(file.getName().replace(".class", ""));
                    if (HiddenClass.class.isAssignableFrom(cl)) {
                        hiddenClasses.add(cl);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        }

    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class clas : hiddenClasses) {
            if (clas.getSimpleName().toLowerCase().contains(key.toLowerCase())) {
                try {
                    Constructor<?> con = clas.getDeclaredConstructor();
                    if (con.getParameterCount() == 0) {
                        try {
                            con.setAccessible(true);
                            try {
                                HiddenClass hc = (HiddenClass) con.newInstance();
                                return hc;
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }

                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(new File(path));

        // Get the size of the file
        long length = new File(path).length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + path);
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;

    }
}

