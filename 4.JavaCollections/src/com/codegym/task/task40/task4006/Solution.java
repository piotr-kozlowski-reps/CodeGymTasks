package com.codegym.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

/* 
Sending a GET request via a socket

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://codegym.cc/social.html"));
    }

    public static void getSite(URL url) {

        try {
            String ipAddress = url.getHost();
            String path = url.getPath();
            Socket socket = new Socket(ipAddress, 80);

            PrintStream pwtr = new PrintStream(socket.getOutputStream());
            pwtr.println("GET " + path);
            pwtr.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }

            bufferedReader.close();
            pwtr.close();
            socket.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}