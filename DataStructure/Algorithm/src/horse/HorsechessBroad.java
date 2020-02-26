package horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HorsechessBroad {

    private static int X;//棋盘列
    private static int Y;//棋盘行
    private static boolean finshed[];//true成功
    private static boolean finsh;

    public static void main(String args[]) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int chess[][] = new int[X][Y];
        finshed = new boolean[X * Y];
        travl(chess, row - 1, column - 1, 1);
        for (int rows[] : chess) {
            System.out.println(Arrays.toString(rows));
        }
    }

    public static void travl(int chess[][], int row, int column, int step) {
        chess[row][column] = step;
        finshed[row * X + column] = true;//标记已经访问
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);//取出下一个可以走的位置
            if (!finshed[p.x * X + p.x]) {//没访问过
                travl(chess, p.y, p.x, step + 1);
            }
        }
        if (step < X * Y && !finsh) {
            chess[row][column] = 0;
            finshed[row * X + column] = false;
        } else {
            finsh = true;
        }
    }

    /**
     * 计算能走哪些位置
     *
     * @param cur
     * @return
     */
    public static ArrayList<Point> next(Point cur) {
        ArrayList<Point> ps = new ArrayList<>();
        Point p1 = new Point();
        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cur.x + 2) < X && (p1.y = cur.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cur.x + 1) < X && (p1.y = cur.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cur.x - 1) >= 0 && (p1.y = cur.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = cur.x - 2) >= 0 && (p1.y = cur.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2)
                    return 0;
                else {
                    return 1;
                }
            }
        });
    }
}
