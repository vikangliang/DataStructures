package stack;

public class Calculator {
    public static void main(String args[]) {
        String s = "70+2*6-2";
        ArrayStack1 num = new ArrayStack1(10);
        ArrayStack1 oper = new ArrayStack1(10);
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int opers = 0;
        char ch = ' ';
        String keepNum = "";//用于拼接多位数
        while (true) {
            ch = s.substring(index, index + 1).charAt(0);
            if (oper.isOper(ch)) {
                if (oper.isEmpty()) {
                    oper.push(ch);
                } else {
                    if (oper.priority(ch) <= oper.priority(oper.peek())) {
                        num1 = num.pop();
                        num2 = num.pop();
                        opers = oper.pop();
                        res = oper.cal(num1, num2, opers);
                        num.push(res);
                        oper.push(ch);
                    } else {
                        oper.push(ch);
                    }
                }
            } else {
//                num.push(ch - 48);
//                处理多位数时，不能及时发现立即入栈，他可能是多位数
//                在处理多位数的时候，需要向s再多看一位，如果是数继续扫描，否则入栈
                keepNum = keepNum + ch;

//                如果ch已经是最后一位
                if (index == s.length() - 1) {
                    num.push(Integer.parseInt(keepNum));
                } else {
                    if (oper.isOper(s.substring(index + 1, index + 2).charAt(0))) {
                        num.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= s.length()) {
                break;
            }
        }

        while (true) {
            if (oper.isEmpty()) {
                break;
            }
            num1 = num.pop();
            num2 = num.pop();
            opers = oper.pop();
            res = oper.cal(num1, num2, opers);
            num.push(res);
        }
        int res1 = num.pop();
        System.out.println(res1);
    }
}

//表示栈结构
class ArrayStack1 {
    private int maxSize;//表示栈的大小
    private int stack[];//数组模拟栈
    private int top = -1;//表示栈顶，初始化为-1

    public ArrayStack1(int maxSize) {
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

    //数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/')
            return 1;
        else if (oper == '+' || oper == '-')
            return 0;
        else
            return -1;
    }

    //判断是否是运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

    public int peek() {
        return stack[top];
    }
}

