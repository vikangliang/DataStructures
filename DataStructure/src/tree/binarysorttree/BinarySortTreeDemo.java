package tree.binarysorttree;

/**
 * 二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String args[]) {
        int arr[] = {7, 3, 10, 12, 5, 1, 9, 0};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
//中序遍历
        System.out.println("原始数组");
        binarySortTree.midOrder();
        System.out.println("删除后");
        binarySortTree.del(5);
        binarySortTree.midOrder();

    }
}

//创建二叉排序树
class BinarySortTree {
    private Node root;

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

    public Node search(int value) {
        if (root != null) {
            return root.search(value);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public Node parentSearch(int value) {
        if (root != null) {
            return root.parentSearch(value);
        } else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    public void del(int value) {
        if (root == null) {
            return;
        } else {
            Node target = search(value);
            if (target == null) {
                System.out.println("不存在");
            }
//            二叉树只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = parentSearch(value);
//判断target是不是叶子节点
            if (target.left == null && target.right == null) {
//                判断target是左子节点还是右子节点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (target.left != null && target.right != null) {//删除有两颗子树的节点
                int min = delMin(target.right);
                target.value = min;
            } else {//删除有1棵子树的节点
//如果target有左子节点
                if (target.left != null) {
                    if (parent != null) {
//                    如果target是parent的左子节点
                        if (parent.left != null && parent.left.value == value) {
                            parent.left = target.left;
                        } else if (parent.right != null && parent.right.value == value) {//如果target是parent的右子节点
                            parent.right = target.left;
                        }
                    } else {
                        root = target.left;
                    }
                } else {//如果target有右子节点
                    if (parent != null) {
                        //                    如果target是parent的左子节点
                        if (parent.left != null && parent.left.value == value) {
                            parent.left = target.right;
                        } else if (parent.right != null && parent.right.value == value) {//如果target是parent的右子节点
                            parent.right = target.right;
                        }
                    } else {
                        root = target.right;
                    }
                }
            }
        }
    }

    /**
     * @param node 传入的节点
     * @return 删除并返回二叉排序树最小节点的值
     */
    public int delMin(Node node) {
        Node target = node;
//        循环查找左节点
        while (target.left != null) {
            target = target.left;
        }
        del(target.value);
        return target.value;
    }
}

//创建节点
class Node {
    int value;
    Node left;
    Node right;

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
}
