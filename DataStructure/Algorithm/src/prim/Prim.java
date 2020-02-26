package prim;

import java.util.Arrays;

public class Prim {
    public static void main(String args[]) {
        char arr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertex = arr.length;
//        大的数表示不连通
        int weight[][] = new int[][]{{10000, 5, 7, 10000, 10000, 10000, 2}, {5, 10000, 10000, 9, 10000, 10000, 3}, {7, 10000, 10000, 10000, 8, 10000, 10000}, {10000, 9, 10000, 10000, 10000, 4, 10000}, {10000, 10000, 8, 10000, 10000, 5, 4}, {10000, 10000, 10000, 4, 5, 10000, 6}, {2, 3, 10000, 10000, 4, 6, 10000}};
        MGraph mGraph = new MGraph(vertex);
        MinTree minTree = new MinTree();
        minTree.creatGraph(mGraph, vertex, arr, weight);
        minTree.show(mGraph);
        minTree.prim(mGraph,0);
    }
}

class MinTree {
    public void creatGraph(MGraph mGraph, int vertex, char data[], int weight[][]) {
        int i, j;
        for (i = 0; i < vertex; i++) {
            mGraph.data[i] = data[i];
            for (j = 0; j < vertex; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    //    显示图对应的矩阵
    public void show(MGraph mGraph) {
        for (int i[] : mGraph.weight) {
            System.out.println(Arrays.toString(i));
        }
    }

    //        编写prim算法
    public void prim(MGraph m, int v) {
        int visited[] = new int[m.vertex];
//        标记当前为已访问
        visited[v] = 1;
//        h1h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < m.vertex; k++) {
            for (int i = 0; i < m.vertex; i++) {
                for (int j = 0; j < m.vertex; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && m.weight[i][j] < minWeight) {
                        minWeight = m.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
//            找到边最小
            System.out.println("边<" + m.data[h1] + "," + m.data[h2] + ">权值：" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }
}

class MGraph {
    int vertex;//表示图的节点个数
    char data[];//存放节点数据
    int weight[][];//领结矩阵

    public MGraph(int vertex) {
        this.vertex = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }
}
