package com.pirate.data_structure.queue;

import java.util.Scanner;

/**
 * @author 小孩贼
 * @version 1.0
 * @since 2023-03-29 22:33:18
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 测试
        ArrayQueue queue = new ArrayQueue(3);
        Scanner s = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):入队");
            System.out.println("g(get):出队");
            System.out.println("h(head):获取队头");
            switch (s.next().charAt(0)) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    queue.enQueue(s.nextInt());
                    break;
                case 'g':
                    System.out.println("出队元素：" + queue.deQueue());
                    break;
                case 'h':
                    System.out.println("当前队头：" + queue.getHead());
                    break;
                case 'e':
                    s.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序安全退出！");

    }
}

// 使用数组模拟队列——编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; // 队列的最大容量
    private int front; // 队头指针
    private int rear; // 队尾指针
    private int[] arr; // 存放队列元素

    // 创建一个队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 初始化，指向队头元素的前一个位置
        rear = -1; // 指向队尾的前一个位置
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 入队
    public void enQueue(int e) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满， 数据加入失败!");
            return;
        }
        arr[++rear] = e;
    }

    // 出队
    public int deQueue() {
        // 判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据。");
        }
        return arr[++front];
    }

    // 遍历队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空， 没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }

    // 获取对头
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}