package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));//Не нужно указывать протокол, хост и «Connection: close\r\n»
    }

    public static void getSite(URL url) {

        try (Socket clientSocket = new Socket(url.getHost(), url.getDefaultPort());
             PrintWriter pw = new PrintWriter(clientSocket.getOutputStream())) {
            pw.println("GET "+url.getPath());
            pw.println("");
            pw.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String responseLine = null;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}