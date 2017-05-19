package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {

        StringBuilder hexString = new StringBuilder();

        MessageDigest messageDigest = MessageDigest.getInstance("md5");

        messageDigest.reset();
        messageDigest.update(byteArrayOutputStream.toByteArray());


        byte[] messageDigestByte = messageDigest.digest();

        BigInteger bigInt = new BigInteger(1, messageDigestByte);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }


        /*for (int i = 0; i < messageDigestByte.length; i++) {
            hexString.append(Integer.toHexString(0xFF & messageDigestByte[i]));
        }*/

            return md5Hex.equals(md5);
    }
}
