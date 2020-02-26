package tree.treadedBinaryTree;

/**
 * 线索化二叉树
 */
public class TreadedBinaryTreeDemo {
    public static void main(String args[]) {
        HeroNode2 heroNode1 = new HeroNode2(1, "1");
        HeroNode2 heroNode2 = new HeroNode2(3, "3");
        HeroNode2 heroNode3 = new HeroNode2(6, "6");
        HeroNode2 heroNode4 = new HeroNode2(8, "8");
        HeroNode2 heroNode5 = new HeroNode2(10, "10");
        HeroNode2 heroNode6 = new HeroNode2(14, "14");

        heroNode1.setLeft(heroNode2);
        heroNode1.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);


        BinaryTree2 binaryTree2 = new BinaryTree2();
        binaryTree2.setRoot(heroNode1);
        binaryTree2.threadedBinaryTree2();

        HeroNode2 leftNode = heroNode5.getLeft();
        System.out.println(leftNode.getNo());
        HeroNode2 rightNode = heroNode5.getRight();
        System.out.println(rightNode.getNo());


        binaryTree2.threadedList();
    }
}

/**
 * 线索化二叉树（中序）
 */
class BinaryTree2 {
    private HeroNode2 root;
    //    前置指针
    private HeroNode2 pre;

    public void threadedBinaryTree2() {
        this.threadedBinaryTree2(root);
    }

    //    中序遍历线索二叉树
    public void threadedList() {
//        定义一个变量，存储当前节点，开始是root
        HeroNode2 temp = root;
        while (temp != null) {
//            循环找到leftType=1的节点
            while (temp.getLeftType() == 0) {
                temp = temp.getLeft();
            }
//            打出这个节点
            System.out.println(temp);
//            如果当前节点的右节点指向后继节点，就一直输出
            while (temp.getRightType() == 1) {
//                获取后继节点
                temp = temp.getRight();
                System.out.println(temp);
            }
            temp = temp.getRight();
        }
    }

    /**
     * 线索化二叉树
     *
     * @param node2
     */
    public void threadedBinaryTree2(HeroNode2 node2) {
        if (node2 == null) {
            return;
        }
//        线索化左子树
        threadedBinaryTree2(node2.getLeft());
//        线索化该节点
//        先处理当前节点的前驱节点
        if (node2.getLeft() == null) {
//            左边指向前驱
            node2.setLeft(pre);
//            修改当前节点左指针的类型
            node2.setLeftType(1);
        }
//        处理后继节点
        if (pre != null && pre.getRight() == null) {
//            前驱节点的右指针指向当前节点
            pre.setRight(node2);
            pre.setRightType(1);
        }
//        没处理一个节点，当前节点是下一个节点的前驱节点
        pre = node2;
//        线索化右子树
        threadedBinaryTree2(node2.getRight());
    }

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }


/**
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

 public HeroNode2 preOrderSearch(int no) {
 if (root != null) {
 return this.root.preOrderSearch(no);
 } else {
 return null;
 }
 }

 public HeroNode2 midOrderSearch(int no) {
 if (root != null) {
 return this.root.midOrderSearch(no);
 } else {
 return null;
 }
 }

 public HeroNode2 postOrderSearch(int no) {
 if (root != null) {
 return this.root.postOrderSearch(no);
 } else {
 return null;
 }
 }
 **/

}

class HeroNode2 {
    private int no;
    private String name;
    private HeroNode2 left;
    private HeroNode2 right;
    //0指向左子树，1指向前驱节点
    private int leftType;
    //0指向右子树，1指向后继节点
    private int rightType;


    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
/**
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
 public HeroNode2 preOrderSearch(int no) {
 if (this.no == no) {
 return this;
 }
 HeroNode2 resNode = null;
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
 public HeroNode2 midOrderSearch(int no) {
 HeroNode2 resNode = null;
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
 public HeroNode2 postOrderSearch(int no) {
 HeroNode2 resNode = null;
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
 **/
}