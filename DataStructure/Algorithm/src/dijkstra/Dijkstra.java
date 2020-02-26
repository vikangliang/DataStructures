package dijkstra;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String args[]) {
        char arr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 10000;
        int weight[][] = new int[][]{{0, 12, 10000, 10000, 10000, 16, 14},
                {12, 0, 10, 10000, 10000, 7, 10000},
                {10000, 10, 0, 3, 5, 6, 10000},
                {10000, 10000, 3, 0, 4, 10000, 10000},
                {10000, 10000, 5, 4, 0, 2, 8},
                {16, 7, 6, 10000, 2, 0, 9},
                {14, 10000, 10000, 10000, 8, 9, 0}};
        MGraph mGraph = new MGraph(arr, weight);
        mGraph.show();
        mGraph.dsj(6);
    }
}

class MGraph {
    char vertex[];//顶点数组
    int weight[][];//领结矩阵
    VisitedVertex visitedVertex;


    public MGraph(char vertex[], int weight[][]) {
        this.vertex = vertex;
        this.weight = weight;
    }

    //    显示图对应的矩阵
    public void show() {
        for (int i[] : weight) {
            System.out.println(Arrays.toString(i));
        }
    }

    public void dsj(int index) {
        visitedVertex = new VisitedVertex(vertex.length, index);
        update(index);
        for (int j = 1; j < vertex.length; j++) {
            index = visitedVertex.updatearr();
            update(index);
        }
    }

    public void update(int index) {
        int len = 0;
        for (int j = 0; j < weight[index].length; j++) {
            len = visitedVertex.getDis(index) + weight[index][j];
            if (!visitedVertex.in(j) && len < visitedVertex.getDis(j)) {
                visitedVertex.updateDis(j, len);
                visitedVertex.updatePre(j, index);
            }
        }

    }
}

class VisitedVertex {
    //    表示是否访问过，1有，0没有
    public int already_arr[];
    //    每个下标对应的值为下一个顶点的下标
    public int pre_visited[];
    //    记录出发点到下一个顶点的距离
    public int dis[];


    public VisitedVertex(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
//        初始化dis
        Arrays.fill(dis, 10000);
        this.already_arr[index] = 1;
        this.dis[index] = 0;//设置出发点的访问距离为0
    }

    //是否访问过
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    //更新出发点到index顶点的距离
    public void updateDis(int index, int length) {
        dis[index] = length;
    }

    //    更新pre
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    public int getDis(int index) {
        return dis[index];
    }

    public int updatearr() {
        int min = 10000, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }
}