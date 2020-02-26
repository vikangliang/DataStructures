package queue;

import java.util.Scanner;

/**
 * 环形队列
 */
public class CircleArrayQueueDemo {
    public static void main(String args[]) {
//        测试
//        创建一个队列
        CircleArraysQueue circleArraysQueue = new CircleArraysQueue(4);//有效数据最大为3
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
//        控制循环
        boolean loop = true;
//        输入一个菜单
        while (loop) {
            System.out.println("show");
            System.out.println("add");
            System.out.println("get");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArraysQueue.showQueue();
                    break;
                case 'a': {
                    System.out.println("请输入一个数据");
                    int value = scanner.nextInt();
                    circleArraysQueue.addQueue(value);
                }
                break;
                case 'g': {
                    int a = circleArraysQueue.getQueue();
                    System.out.println("取出的数据为" + a);
                }
                break;
            }
        }
    }
}

class CircleArraysQueue {
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArraysQueue(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
        front = 0;//指向队列头位置
        rear = 0;//指向队列尾后一个的数据（即就是队列最后一个的后一个位置）
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }


    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队满，不能添加数据");
            return;
        }
//直接将数据输入
        arr[rear] = n;
//        rear后移，考虑取模
        rear = (rear + 1) % maxsize;
    }

    //获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            return -1;
        }
//        1.将front对应值保存到一个临时变量里面
//        2.front后移
//        3.返回临时变量
        int value = front;
        front = (front + 1) % maxsize;
        return arr[value];
    }

    //    显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法遍历");
            return;
        }
//        思路：从front开始遍历，遍历几个元素
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i % maxsize]);
        }
    }

    //    显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return -1;
        }
        return arr[front];
    }

    public int size() {
        return (rear + maxsize - front) % maxsize;
    }
}