package tree.avl;

public class AVLTreeDemo {
    public static void main(String args[]) {
//        int arr[] = {4, 3, 6, 5, 7, 8};
        int arr[] = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //中序遍历
        System.out.println("原始数组");
//        avlTree.midOrder();
        System.out.println("树高度：" + avlTree.getRoot().height());
        System.out.println("树左子树高度：" + avlTree.getRoot().leftHeight());
        System.out.println("树右子树高度：" + avlTree.getRoot().rightHeight());
    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void midOrder() {
        if (root != null) {
            root.midOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }
}

//创建节点
class Node {
    int value;
    Node left;
    Node right;

    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    //    返回当前节点的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
//        判断传入节点的值与当前节点的值的大小
        if (node.value < this.value) {
            if (this.left == null) {
//                直接挂在左子树上
                this.left = node;
            } else {
//                递归向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

//        当右子树高度-左子树高度>1
//        if (rightHeight() - leftHeight() > 1) {
//            if (right != null && right.rightHeight() < right.leftHeight()) {
//                right.rightRotate();
//                leftRotate();
//            } else {
//                leftRotate();
//            }
//            return;
//        }

        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                midOrder();
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }

    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //查找该节点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left != null)
                return this.left.search(value);
        } else if (value > this.value) {
            if (this.right != null)
                return this.right.search(value);
        }
        return null;
    }

    //    查找父节点
    public Node parentSearch(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else if (value < this.value) {
            if (this.left != null)
                return this.left.parentSearch(value);
        } else if (value >= this.value) {
            if (this.right != null)
                return this.right.parentSearch(value);
        }
        return null;
    }

    //左旋转
    public void leftRotate() {
//        创建新的节点
        Node newNode = new Node(value);
//        新节点的左子树是当前节点左子树
        newNode.left = left;
//        新节点的右子树是当前节点右子树的左子树
        newNode.right = right.left;
//        把当前节点值替换成右子节点的值
        value = right.value;
//        当前节点的右子树设置成右子树的右子树
        right = right.right;
//        把当前节点的左子节点设置成新的节点
        left = newNode;
    }

    //右旋转
    public void rightRotate() {
//        创建新的节点
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
}