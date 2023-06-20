package com.pirate.data_structure.sort.insert;

import java.util.Random;

/**
 * @author 小孩贼
 * @version 1.0
 * @since 2023-06-20 16:06:19
 */
public class ShellSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] data = new int[100];
        // 初始化数据
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt(200);
        }
        // 排序
        shellSort2(data);

        for (int e : data) {
            System.out.println(e);
        }
    }

    /**
     * 划分的子表，每个表轮流排序
     *
     * @param arr 待排序数组
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int d = n / 2; d >= 1; d /= 2) { // 增量的控制
            // 各个子表 轮换插入排序
            for (int i = d; i < n; i++) {
                if (arr[i] < arr[i - d]) {
                    int temp = arr[i]; // 待排序元素
                    int j;
                    for (j = i - d; j >= 0 && temp < arr[j]; j -= d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }

            }
        }
    }

    /**
     * 结构更清晰
     *      思想：
     *          与上述相遇，控制增量的循环是一定存在的，同时知道d也代表这次划分的子序列数
     *          所以，“一次增量”对d个子序列依次进行直接插入排序处理
     *
     * @param arr 待排序数组
     */
    public static void shellSort2(int[] arr) {
        int n = arr.length;

        for (int d = n / 2; d >= 1; d /= 2) { // 增量控制,(d不仅表示增量，也是划分的子序列数）
            for (int i = 0; i < d; i++) {
                // 子表插入排序
                for (int j = i + d; j < n; j += d) {
                    if (arr[j] < arr[j - d]) {
                        int temp = arr[j];
                        int k;
                        for (k = j - d; k >= 0 && temp < arr[k]; k -= d) {
                            arr[k + d] = arr[k];
                        }
                        arr[k + d] = temp;
                    }
                }
            }
        }
    }
}
