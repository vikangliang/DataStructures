package dynamic;

public class BagProblem {
    public static void main(String args[]) {
        int w[] = {1, 4, 3};//重量、
        int val[] = {1500, 3000, 2000};
        int m = 4;//背包容量
        int n = val.length;//物体个数

        int v[][] = new int[n + 1][m + 1];
        int path[][] = new int[n + 1][m + 1];

//        根据公式
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
//                        v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个物品放入背包");
                j = j - w[i - 1];
            }
            i--;
        }
    }

}
