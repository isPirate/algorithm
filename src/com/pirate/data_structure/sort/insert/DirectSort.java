package com.pirate.data_structure.sort.insert;

import java.util.Random;

/**
 * @author 小孩贼
 * @version 1.0
 * @since 2023-06-20 14:56:41
 */
public class DirectSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] data = new int[100];
        // 初始化数据
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(200);
        }
        // 排序
        directSort(data);

        for (int e : data) {
            System.out.println(e);
        }


    }

    public static void directSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                // 比较，后移，找插入位置
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) { // 非哨兵方式，注意“j>=0"防止下标越界
                    arr[j + 1] = arr[j];
                }
                // 插入
                arr[j + 1] = temp;
            }
        }
    }
}
