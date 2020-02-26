package floyd;

import java.util.Arrays;

public class Floyd {
    public static void main(String args[]) {
        char arr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 10000;
        int weight[][] = new int[][]{{0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0}};
        MGraph graph = new MGraph(arr.length, arr, weight);
        graph.floyd();
        graph.show();
    }
}

class MGraph {
    char vertex[];//顶点数组
    int weight[][];//领结矩阵
    int dis[][];
    int pre[][];


    public MGraph(int len, char vertex[], int weight[][]) {
        this.vertex = vertex;
        this.dis = weight;
        this.pre = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    //    显示图对应的矩阵
    public void show() {

        for (int i[] : dis) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        for (int i[] : pre) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }


//    public void update(int index) {
//        int len = 0;
//        for (int j = 0; j < weight[index].length; j++) {
//            len = visitedVertex.getDis(index) + weight[index][j];
//            if (!visitedVertex.in(j) && len < visitedVertex.getDis(j)) {
//                visitedVertex.updateDis(j, len);
//                visitedVertex.updatePre(j, index);
//            }
//        }
//
//    }

    public void floyd() {
        int len = 0;
//        对中间节点遍历
        for (int k = 0; k < dis.length; k++) {
//            对开始节点遍历
            for (int i = 0; i < dis.length; i++) {
//                对结束节点遍历
                for (int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}