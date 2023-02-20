package com.libgdx.roguelike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Mates extends Player implements Runnable{

    int timeout = 99999999;
    @Override
    public void run() {
        int random  = (int) (Math.random()*100);
        System.out.println("debut tache " + Thread.currentThread().getName());
        for(int i = 0  ; i < 500000000; i++){
            System.out.println("Hello  thread numéro random -> " + random );
            requestURL();
            try {

                Thread.sleep(2);
                requestURL();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        System.out.println("fin tache");
    }

    private void requestURL() {

        String GET_URL = "http://172.16.200.237:8080/DAMCorp/PlayerPosition";
        String USER_AGENT = "Mozilla/5.0";
        URL url = null;
        try {
            url = new URL(GET_URL);
            HttpURLConnection con =  (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent",USER_AGENT);
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                    System.out.println("inputLine " + inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request did not work.");
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
