package tree;

/**
 * 二叉树前中后序遍历
 */
public class BinaryTreeDemo {
    public static void main(String args[]) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root1 = new HeroNode(1, "111");
        HeroNode heroNode2 = new HeroNode(2, "222");
        HeroNode heroNode3 = new HeroNode(3, "333");
        HeroNode heroNode4 = new HeroNode(4, "444");

        root1.setLeft(heroNode2);
        root1.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        binaryTree.setRoot(root1);

        System.out.println("前序遍历：");
        binaryTree.preOrder();

        System.out.println("中序遍历：");
        binaryTree.midOrder();

        System.out.println("后序遍历：");
        binaryTree.postOrder();

        System.out.println("查找：");
        HeroNode heroNode = binaryTree.postOrderSearch(4);
        if (heroNode != null) {
            System.out.println(heroNode);
        } else {
            System.out.println("没有找到");
        }

        System.out.println("删除4：");
        binaryTree.delNode(4);
        binaryTree.preOrder();
    }
}


class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void delNode(int no) {
        if (root != null) {
            //如果root只有一个节点，判断root是不是要删除的
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void midOrder() {
        if (root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode midOrderSearch(int no) {
        if (root != null) {
            return this.root.midOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }


}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
//        向左子树遍历
        if (this.left != null) {
            this.left.preOrder();
        }
//        向右子树遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {

//        向左子树遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
//        向右子树遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder() {

//        向左子树遍历
        if (this.left != null) {
            this.left.postOrder();
        }
//        向右子树遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //    前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //    中序遍历查找
    public HeroNode midOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.midOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.midOrderSearch(no);
        }
        return resNode;
    }

    //    后序遍历查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 删除节点及其子树
     *
     * @param no
     */
    public void delNode(int no) {
        //        当前左节点不空，且等于找的值，则删除，并返回
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //        当前右节点不空，且等于找的值，则删除，并返回
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
//        不满足这两步，则向左子树递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
//向左没有执行，则向右
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}
