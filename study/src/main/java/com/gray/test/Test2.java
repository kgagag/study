package com.gray.test;

import java.io.FileNotFoundException;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            Random random = new Random();
            int start = random.nextInt(100000);
            arr[i] = start;
        }
        long s = System.currentTimeMillis();
        swap(arr);
        long e = System.currentTimeMillis();
        System.out.println(e - s);
    }

    public static void swap(int[] arr) {
        int k = arr.length; // 获取数组元素的数量
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}
