package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] bytes = new byte[8];
            //48-57 65-90 97 -122
            Random random = new Random();
            int i = 0;
            while (true) {
                int a = random.nextInt(123);
                if ((a > 47 & a < 58) | (a > 96 & a < 123) | (a > 64 & a < 91)) {

                    bytes[i] = (byte) a;
                    i++;
                }
                if (i > 7) {
                    boolean isdigital = false;
                    boolean isUpperCase = false;
                    boolean isLowerCase = false;
                    for (byte b : bytes) {
                        if (b > 47 & b < 58) {
                            isdigital = true;
                        }
                        if (b > 96 & b < 123) {
                            isUpperCase = true;
                        }
                        if (a > 64 & a < 91) {
                            isLowerCase = true;
                        }

                    }
                    if (isdigital & isLowerCase & isUpperCase) {
                        break;
                    } else i = 0;
                }
            }
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream;
        } catch (Exception e) {
            return new ByteArrayOutputStream();
        }
    }
}