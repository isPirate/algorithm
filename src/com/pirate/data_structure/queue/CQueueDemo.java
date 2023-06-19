package com.pirate.data_structure.queue;

import java.util.Scanner;

/**
 * @author 小孩贼
 * @version 1.0
 * @since 2023-03-30 16:58:01
 */
public class CQueueDemo {
    public static void main(String[] args) {
// 测试
        CQueue cQueue = new CQueue(3);
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
                    cQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数：");
                    cQueue.enQueue(s.nextInt());
                    break;
                case 'g':
                    System.out.println("出队元素：" + cQueue.deQueue());
                    break;
                case 'h':
                    System.out.println("当前队头：" + cQueue.getHead());
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

class CQueue {
    private int maxSize; // 队列的最大容量
    private int front; // 队头指针
    private int rear; // 队尾指针
    private int[] arr; // 存放队列元素

    // 创建一个队列的构造器
    public CQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; // 初始化，指向队头元素
        rear = 0; // 指向队尾的下一个位置
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 入队
    public void enQueue(int e) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满， 数据加入失败!");
            return;
        }
        arr[rear] = e;
        rear = (rear + 1) % maxSize; // 循环改变
    }

    // 出队
    public int deQueue() {
        // 判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据。");
        }
        int ret = arr[front];
        front = (front + 1) % maxSize;
        return ret;
    }

    // 遍历队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空， 没有数据");
            return;
        }
        // 区别 普通队列
        /*for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }*/
        for (int i = front; i < front + getSize(); i++) {
            System.out.println("arr[" + (i % maxSize)+ "]=" + arr[i % maxSize]);
        }
    }

    // 获取对头
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    // 获取队列元素个数
    public int getSize() {
        return (rear - front + maxSize) % maxSize;
    }

}
