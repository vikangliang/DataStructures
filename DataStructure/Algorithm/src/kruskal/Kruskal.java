package kruskal;

import java.util.Arrays;

public class Kruskal {
    static private int edgeNum;
    static private char[] vertex;
    static int weight[][];//临街矩阵
    public static final int INF = 10000;

    public static void main(String args[]) {
        char arr[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int weight[][] = new int[][]{{0, 12, 10000, 10000, 10000, 16, 14},
                {12, 0, 10, 10000, 10000, 7, 10000},
                {10000, 10, 0, 3, 5, 6, 10000},
                {10000, 10000, 3, 0, 4, 10000, 10000},
                {10000, 10000, 5, 4, 0, 2, 8},
                {16, 7, 6, 10000, 2, 0, 9},
                {14, 10000, 10000, 10000, 8, 9, 0}};
        show(weight);
//        Edata[] E = getEdata();
//        System.out.println(Arrays.toString(sort(E)));
        Kruskal kruskal = new Kruskal(arr, weight);
        kruskal.kruskal();

    }

    public Kruskal(char[] vertex, int weight[][]) {
        int len = vertex.length;
        this.vertex = vertex;
        this.weight = weight;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (weight[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //    显示图对应的矩阵
    public static void show(int weight[][]) {
        for (int i[] : weight) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public Edata[] getEdata() {
        int index = 0;
        Edata[] edata = new Edata[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (weight[i][j] != INF) {
                    edata[index++] = new Edata(vertex[i], vertex[j], weight[i][j]);
                }
            }
        }
        return edata;
    }

    public static Edata[] sort(Edata edata[]) {
        Edata temp = null;
        for (int i = 0; i < edata.length - 1; i++) {
            for (int j = 0; j < edata.length - 1 - i; j++) {
                if (edata[j + 1].weight < edata[j].weight) {
                    temp = edata[j + 1];
                    edata[j + 1] = edata[j];
                    edata[j] = temp;
                }
            }
        }
        return edata;
    }

    public static int getEnd(int end[], int i) {
        while (end[i] != 0) {
            i = end[i];
        }
        return i;
    }

    /*
     * 克鲁斯卡尔（Kruskal)最小生成树
     */
    public void kruskal() {
        int index = 0;                      // rets数组的索引
        int[] vends = new int[edgeNum];     // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点。
        Edata[] rets = new Edata[edgeNum];  // 结果数组，保存kruskal最小生成树的边
        Edata[] edges;                      // 图对应的所有边

        // 获取"图中所有的边"
        edges = getEdata();
        // 将边按照"权"的大小进行排序(从小到大)
        sort(edges);

        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);      // 获取第i条边的"起点"的序号
            int p2 = getPosition(edges[i].end);        // 获取第i条边的"终点"的序号

            int m = getEnd(vends, p1);                 // 获取p1在"已有的最小生成树"中的终点
            int n = getEnd(vends, p2);                 // 获取p2在"已有的最小生成树"中的终点
            // 如果m!=n，意味着"边i"与"已经添加到最小生成树中的顶点"没有形成环路
            if (m != n) {
                vends[m] = n;                       // 设置m在"已有的最小生成树"中的终点为n
                rets[index++] = edges[i];           // 保存结果
            }
        }

        // 统计并打印"kruskal最小生成树"的信息
        int length = 0;
        for (int i = 0; i < index; i++)
            length += rets[i].weight;
        System.out.printf("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++)
            System.out.printf("(%c,%c) ", rets[i].start, rets[i].end);
        System.out.printf("\n");
    }
}


class Edata {
    char start;
    char end;
    int weight;

    public Edata(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edata{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }


}