package recursion;

/**
 * 二维数组迷宫（递归回溯法）
 */
public class Migong {
    public static void main(String arg[]) {
//        先创建一个二维数组模拟迷宫
        int map[][] = new int[8][7];
//        上下全部置为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[map.length - 1][i] = 1;
        }
//        左右全部置为1
        for (int j = 1; j < map.length - 1; j++) {
            map[j][0] = 1;
            map[j][map[0].length - 1] = 1;
        }
//        设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
//        显示地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        //        显示地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 选择地图
     * @param i   从位置开始找
     * @param j
     * @return 找得到通路true
     */
    public static boolean setWay(int map[][], int i, int j) {
        if (map[map.length - 2][map[0].length - 2] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //设定行走策略
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j + 1)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
//                    说明此路走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
