package dac;

public class Hanoitower {
    public static void main(String args[]) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    //汉诺塔
    public static void hanoiTower(int nums, char a, char b, char c) {
        if (nums == 1) {
            System.out.println("第1盘" + a + "->" + c);
        } else {
//            nums大于二，总是把他看做两个盘，1.最下面2.上面的盘
//            先把上面的盘a移动到b
            hanoiTower(nums - 1, a, c, b);
//            把下面的盘从a移到c
            System.out.println("第" + nums + "盘" + a + "->" + c);
//            把b所有盘移动到c
            hanoiTower(nums - 1, b, a, c);
        }
    }
}
