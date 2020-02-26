package hashtable;

/**
 * 哈希表
 */
public class HashtableDemo {
    public static void main(String args[]) {
        Emp emp1 = new Emp(1, "111");
        Emp emp2 = new Emp(2, "222");
        Emp emp8 = new Emp(8, "888");
        HashTable hashTable = new HashTable(7);
        hashTable.add(emp1);
        hashTable.list();
        System.out.println();
        hashTable.add(emp2);
        hashTable.list();
//        hashTable.add(emp1);
//        hashTable.add(emp2);
        System.out.println();
        System.out.println();
        hashTable.add(emp8);
        hashTable.list();
//        hashTable.add(emp2);
//        hashTable.list();
//        EmpLinkedList linkedList = new EmpLinkedList();
//        linkedList.add(emp1);
//        linkedList.add(emp2);
//        linkedList.list();
//        System.out.println(linkedList.find(emp8).id);

        hashTable.find(8);
    }
}

class HashTable {
    int size;
    EmpLinkedList[] empLinkedLists;

    public HashTable(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int eLinkedListNO = hashFun(emp.id);
        empLinkedLists[eLinkedListNO].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public int hashFun(int id) {
        return id % size;
    }

    public void find(int id) {
        int eLinkedListNO = hashFun(id);
        Emp e = empLinkedLists[eLinkedListNO].find(id);
        if (e == null) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到"+e.name);
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head = new Emp(0, "000");

    //假定添加到最后
    public void add(Emp emp) {
        if (head.next == null) {
            head.next = emp;
            return;
        }
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = emp;
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;
    }

    public void list(int no) {
        if (head.next == null) {
            System.out.println("第" + (no + 1) + "条链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "条链表信息为：");
        Emp temp = head.next;
        while (true) {
            if (temp != null) {
                System.out.println("  节点id " + temp.id + "，节点名 " + temp.name);
                temp = temp.next;
            } else
                break;
        }
    }

    public Emp find(int id) {
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp temp = head;
        while (true) {
            if (head.next != null) {
                if (id == temp.id) {
                    return temp;
                }
                temp = temp.next;
            } else {
                return null;
            }
        }
    }
}
