package com.gray.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class Test implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Test());
            t.start();
        }
    }

    public void run() {
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod("http://www.6789.com");
        for (int i = 0; i < 1000; i++) {
            try {
                client.executeMethod(getMethod);
                System.out.println(getMethod.getResponseBodyAsString());
            }
            catch (HttpException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
