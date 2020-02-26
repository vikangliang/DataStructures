package linkedlist;

/**
 * 双链表
 */
public class DoubleLinkedListDemo {
    public static void main(String args[]) {
        HeroNode2 songjiang = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 rujunyi = new HeroNode2(2, "如君意", "玉麒麟");

        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();

        doubleLinkedList.add(songjiang);
        doubleLinkedList.add(rujunyi);

        doubleLinkedList.list();

        System.out.println("修改后打印");
        HeroNode2 rujunyi1 = new HeroNode2(2, "路君意", "玉麒麟**");
        doubleLinkedList.update(rujunyi1);
        doubleLinkedList.list();

        System.out.println("删除后打印");
        doubleLinkedList.del(rujunyi1);
        doubleLinkedList.list();

    }
}

class DoubleLinkedList {
    //    先初始化一个头结点
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void add(HeroNode2 node) {
//        因为head节点不能动，需要一个辅助变量遍历
        HeroNode2 temp = head;
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
        node.pre = temp;
    }

    //    修改节点信息：根据no来修改,即no不能变
    public void update(HeroNode2 newNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head;
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

    public void del(HeroNode2 node) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
            temp.pre.next = temp.next;
        } else {
            System.out.println("没有找到");
        }
    }
}


class HeroNode2 {
    int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "no" + no + ",name" + name + ",nickname" + nickname;
    }
}
