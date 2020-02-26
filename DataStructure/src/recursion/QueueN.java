package recursion;

/**
 * 一维数组8皇后问题（递归回溯法）
 */
public class QueueN {
    int N = 8;
    int array[] = new int[N];

    public static void main(String args[]) {
        QueueN queueN = new QueueN();
        queueN.check(0);
    }

    public void check(int n) {
        if (n == N) {
            print();
            return;
        }
        for (int i = 0; i < N; i++) {
            array[n] = i;
            if (judge(n)) {//true不冲突
                check(n + 1);
            }
        }
    }

    //判断n皇后是否和前后的冲突
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
