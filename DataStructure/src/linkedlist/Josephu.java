package linkedlist;

/**
 * 约瑟夫环（单向环形链表）
 */
public class Josephu {
    public static void main(String args[]) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.show();

        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    //    先创建一个first节点，没有编号
    private Boy first = new Boy(-1);

    public void add(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
//        辅助节点
        Boy cur = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环
                cur = first;
            } else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy;
            }
        }
    }

    //    遍历当前环形链表
    public void show() {
        if (first.getNext() == null) {
            System.out.println("链表为空");
        }
//        因为first不能动，使用辅助指针完成遍历
        Boy cur = first;
        while (true) {
            System.out.println("小孩编号" + cur.getNo());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有几个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

//        报数之前，让first和helper移动startNo-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
//        当小孩报数时候，让first和helper移动countNum-1次
        while (true) {
            if (helper == first) {//圈中只有一人
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("小孩出圈" + first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩标号" + first.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
