package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 */
public class PolandNotation {
    public static void main(String args[]) {
        String s = "3 4 + 5 * 6 -";
        //System.out.println(calculate(getListString(s)));
        System.out.println(toInfix("(1+1)*3"));
        System.out.println(parse(toInfix("(1+1)*3")));
        System.out.println(calculate(parse(toInfix("(1+1)*3"))));
    }

    //将逆波兰表达式放进Arraylist
    public static List<String> getListString(String s) {
        List<String> arrayList = new ArrayList<>();
        String split[] = s.split(" ");
        for (String el : split) {
            arrayList.add(el);
//            System.out.println(el);
        }
        return arrayList;
    }

    //计算逆波兰表达式的值
    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack();
        for (String s : list) {
            if (s.matches("\\d+")) {//匹配的是多位数
                stack.push(s);
            } else {
                int res = 0;
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+": {
                        res = num1 + num2;
                    }
                    break;
                    case "-": {
                        res = num2 - num1;
                    }
                    break;
                    case "*": {
                        res = num1 * num2;
                    }
                    break;
                    case "/": {
                        res = num2 / num1;
                    }
                    break;
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //中缀表达式转成list
    public static List<String> toInfix(String s) {
        //存放中缀表达式
        List<String> list = new ArrayList<>();
        //指针，用来遍历List
        int i = 0;
        //多位数拼接
        String str;
        //遍历的每一个字符
        char c;
        do {
//            如果c不是数字，加入list
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add(c + "");
                i++;
            } else {//考虑多位数问题
                str = "";
                while (i < s.length() && ((c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57)) {
                    str = str + c;//拼接
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    //中缀表达式转后缀表达式
    public static List<String> parse(List<String> list) {
//定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        List<String> s2 = new ArrayList<>();//存中间结果栈
        for (String s : list) {
            if (s.matches("\\d+")) {//多位数
                s2.add(s);
            } else if (s.equals("(")) {
                s1.push(s);
            } else if (s.equals(")")) {//右括号，一次弹出s1的运算符，并进入s2，直到遇到左括号，再将最对括号抛弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                //当前运算符优先级小于等于栈顶的运算符时，将s1的栈顶元素弹出加入s2，再重复比较
                while (s1.size() != 0 && Operation.getValue(s) <= Operation.getValue(s1.peek())) {
                    s2.add(s1.pop());
                }
                //再将s加入s1栈
                s1.push(s);
            }
        }
        //将s1剩下的加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }
}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String oper) {
        switch (oper) {
            case "+": {
                return ADD;
            }
            case "-": {
                return SUB;
            }
            case "*": {
                return MUL;
            }
            case "/": {
                return DIV;
            }
            default: {
                System.out.println("没有该运算符");
            }
            break;
        }
        return 0;
    }
}