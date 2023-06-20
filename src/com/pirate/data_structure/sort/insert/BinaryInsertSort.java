package com.pirate.data_structure.sort.insert;

import java.util.Random;

/**
 * @author 小孩贼
 * @version 1.0
 * @since 2023-06-20 15:46:35
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] data = new int[100];
        // 初始化数据
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(200);
        }
        // 排序
        binaryInsertSort(data);

        for (int e : data) {
            System.out.println(e);
        }
    }

    /**
     * 思想：
     *      直接插入主要是两个步骤：
     *              1；查找插入位置
     *              2：后移元素
     *      将这两个操作分离开来，即，找到位置后，统一移动元素；
     *      这样在有序子序列中查找插入位置可以采用折半查找。
     * @param arr 待排序数组
     */
    public static void binaryInsertSort(int[] arr) {
        int n = arr.length;
        int mid;

        for (int i = 1; i < n; i++) {
            int low = 0;
            int high = i-1;
            int temp = arr[i];
            // 找插入位置
            while(low<=high) {
                mid = (low + high)/2;
                if (temp < arr[mid]) {
                    high = mid - 1;
                }else {
                    // 包含”==“情况，是为了保证算法的稳定性
                    low = mid + 1;
                }
            }
            // 循环结束，插入位置为low指向地方
            // 进行元素位移
            for (int j = i-1; j>=low ; j--) {
                arr[j+1]  = arr[j];
            }
            // 插入
            arr[low] = temp;
        }
    }

}
