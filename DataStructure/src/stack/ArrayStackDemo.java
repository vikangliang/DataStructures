package stack;

public class ArrayStackDemo {
    public static void main(String args[]) {
        ArrayStack arrayStack=new ArrayStack(4);
        arrayStack.push(1);
        arrayStack.show();
        arrayStack.push(2);
        arrayStack.show();
        arrayStack.push(3);
        arrayStack.show();
        arrayStack.push(4);
        arrayStack.show();
        arrayStack.push(5);
        arrayStack.show();
        arrayStack.pop();
        arrayStack.show();
        arrayStack.pop();
        arrayStack.show();
        arrayStack.pop();
        arrayStack.show();
        arrayStack.pop();
        arrayStack.show();
    }
}

//表示栈结构
class ArrayStack {
    private int maxSize;//表示栈的大小
    private int stack[];//数组模拟栈
    private int top = -1;//表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //判栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空");
            return -1;
        }
        int value = stack[top];
        top--;
        return value;
    }

    //    遍历栈，从栈顶往下
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
