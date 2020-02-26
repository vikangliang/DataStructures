package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图的创建及深度优先遍历和广度优先遍历
 */
public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//邻接矩阵
    private int numsOfEdges;//存储边的数目
    private boolean isVisted[];//节点是否被访问

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numsOfEdges = 0;
        isVisted = new boolean[n];
    }

    //    插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //    插入边

    /**
     * @param v1     表示点的下标
     * @param v2     第二个点的下标
     * @param weight 是否有边，1为有
     */
    public void insertEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numsOfEdges++;
    }

    //返回节点个数
    public int getNumsOfVertex() {
        return vertexList.size();
    }

    //    得到边的数目
    public int getNumsOfEdges() {
        return numsOfEdges;
    }

    //返回节点i对应的数据
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //    返回v1v2的权值
    public int weight(int v1, int v2) {
        return edges[v1][v2];
    }

    //    显示图对应的矩阵
    public void show() {
        for (int i[] : edges) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String args[]) {
        int n = 5;
        String vertex[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (int i = 0; i < n; i++) {
            graph.insertVertex(vertex[i]);
        }

//        添加边
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

//        显示
//        graph.show();

//        graph.dfs();
        graph.bfs();
    }


    //    得到第一个临街节点的下标
    public int getFirstIndex(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //    得到下个节点下标
    public int getNextIndex(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean isVisted[], int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisted[i] = true;
        int w = getFirstIndex(i);
        while (w != -1) {//说明有
            if (!isVisted[w]) {//未被访问过
                dfs(isVisted, w);
            }
//            被访问过，访问下一个节点
            w = getNextIndex(i, w);
        }
    }

    public void dfs() {
//        遍历所有节点
        for (int i = 0; i < getNumsOfVertex(); i++) {
            if (!isVisted[i]) {
                dfs(isVisted, i);
            }
        }
    }

    public void bfs(boolean isVisted[], int i) {
        int u;//表示队列头结点下标
        int w;//临街节点
        LinkedList queue = new LinkedList();//记录节点访问顺序
        System.out.print(getValueByIndex(i) + "->");
        isVisted[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u = (int) queue.removeFirst();
            w = getFirstIndex(u);
            while (w == -1) {
                if (!isVisted[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisted[w] = true;
                    queue.addLast(w);
                }
                w = getNextIndex(u, w);
            }
        }
    }

    public void bfs() {
//        遍历所有节点
        for (int i = 0; i < getNumsOfVertex(); i++) {
            if (!isVisted[i]) {
                bfs(isVisted, i);
            }
        }
    }
}
