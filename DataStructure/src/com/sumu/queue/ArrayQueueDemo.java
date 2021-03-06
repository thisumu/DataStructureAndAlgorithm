package com.sumu.queue;

import java.util.Scanner;

/**
 * 数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("=====数组模拟队列=====");
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; // 接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列中的所有数据");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("o(out)：使数据退出队列");
            System.out.println("h(head)：查看队列头数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("请输入功能字母编号：");
            key = scanner.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int value = scanner.nextInt();
                    arrayQueue.addDataToQueue(value);
                    break;
                case 'o':
                    try {
                        int res = arrayQueue.outDataFromQueue();
                        System.out.printf("出队的数据是：%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是：%d\n",res);
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出！");
    }
}

/**
 * 使用数组模拟队列----编写一个ArrayQueue类
 */
class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 表示队列头
    private int rear; // 表示队列尾
    private int[] arr; // 该数组用于存放数据，模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头的数据的前一个位置
        rear = -1; // 指向队列尾的数据（即队列的最后一个数据）
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1; // rear == maxSize-1时队列为满
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return front == rear; // front == rear时队列为空
    }

    // 添加数据到队列
    public void addDataToQueue(int n) {
        // 判断队列是否为满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据！");
            return;
        }
        rear++; // 使rear后移
        arr[rear] = n;
    }

    // 从队列中获取数据（出队列）
    public int outDataFromQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常处理
            throw new RuntimeException("队列为空，不能获取数据！");
        }
        front++; // 使front后移
        return arr[front];
    }

    // 显示队列中的所有数据
    public void showQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据，而不是取数据
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front + 1];
    }
}