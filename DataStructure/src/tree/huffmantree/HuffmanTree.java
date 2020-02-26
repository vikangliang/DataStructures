package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String args[]) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};

        Node root = creatHuffmantree(arr);
        preOrder(root);

    }

    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("树为空");
        }
    }

    public static Node creatHuffmantree(int arr[]) {
        ArrayList<Node> list = new ArrayList();
        //        创建Huffmantree
        for (int i = 0; i < arr.length; i++) {
            list.add(new Node(arr[i]));
        }
//        从小到大排序
        Collections.sort(list);
        System.out.println(list);

        while (list.size() > 1) {
//        取出最小的两颗二叉树
            Node nodeLeft = list.get(0);
            Node nodeRight = list.get(1);
//        构建新的父二叉树
            Node parent = new Node(nodeLeft.value + nodeRight.value);
            parent.left = nodeLeft;
            parent.right = nodeRight;
//        从list删除
            list.remove(nodeLeft);
            list.remove(nodeRight);
//        将父节点加入
            list.add(parent);
            Collections.sort(list);
            System.out.println(list);
        }
        return list.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value + "";
    }

    @Override
    public int compareTo(Node o) {
//        表示从小到大进行排序
        return this.value - o.value;
    }

    //    前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
