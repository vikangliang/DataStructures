package queue;

import java.util.Scanner;

/**
 * 数组模拟队列
 */
public class ArrayQueueDemo {
    public static void main(String args[]) {
//        测试
//        创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.showQueue();
                    break;
                case 'a': {
                    System.out.println("请输入一个数据");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                }
                break;
                case 'g': {
                    int a = arrayQueue.getQueue();
                    System.out.println("取出的数据为" + a);
                }
                break;
            }
        }
    }
}

class ArrayQueue {
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队列尾的数据（即就是队列最后一个位置）
    }

    //判断队列是否为满
    public boolean isFull() {
        return rear == maxsize - 1;
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
        rear++;//rear后移
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            return -1;
        }
        front++;
        return arr[front];
    }

    //    显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无法遍历");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "/t");
        }
    }

    //    显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return -1;
        }
        return arr[front + 1];
    }
}
