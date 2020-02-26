package linkedlist;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String args[]) {
        HeroNode songjiang = new HeroNode(1, "宋江", "及时雨");
        HeroNode rujunyi = new HeroNode(2, "如君意", "玉麒麟");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(rujunyi);
//        singleLinkedList.add(songjiang);

        singleLinkedList.addByOrder(rujunyi);
        singleLinkedList.addByOrder(songjiang);


        singleLinkedList.list();


        HeroNode rujunyi1 = new HeroNode(2, "路君意", "玉麒麟**");
        singleLinkedList.update(rujunyi1);
        singleLinkedList.list();

        singleLinkedList.del(rujunyi1);
        singleLinkedList.list();

    }
}

class SingleLinkedList {
    //    先初始化一个头结点
    private HeroNode head = new HeroNode(0, "", "");

    //当不考虑节点的顺序时
//    1.先找到链表的最后
//    2.将这个节点的next指向新的节点
    public void add(HeroNode node) {
//        因为head节点不能动，需要一个辅助变量遍历
        HeroNode temp = head;
//        遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
//            若没有找到最后，将temp后移
            temp = temp.next;
        }
//        当退出while循环是，temp指向链表的最后一个节点
        temp.next = node;
    }

    //    按编号插入
    public void addByOrder(HeroNode node) {
//        1.使用临时变量
        HeroNode temp = head;
        boolean flag = false;//标识编号是否存在
//        2.查找位置为添加位置的前一个位置
        while (true) {
            if (temp.next == null) {//说明temp在链表的最后
                break;
            }
            if (temp.next.no > node.no) {//位置找到，node添加到temp后面，temp.next的前面
                break;
            } else if (temp.next.no == node.no) {//位置已经存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("编号已经存在");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    //    修改节点信息：根据no来修改,即no不能变
    public void update(HeroNode newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == newNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.name = newNode.name;
            temp.next.nickname = newNode.nickname;
        } else {
            System.out.println("没有找到");
        }
    }

    public void del(HeroNode node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到");
        }
    }

    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //    统计单链表的有效长度，不统计头结点
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            System.out.println("空链表");
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
}

//每个heronode就是一个节点
class HeroNode {
    int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "no" + no + ",name" + name + ",nickname" + nickname;
    }
}
