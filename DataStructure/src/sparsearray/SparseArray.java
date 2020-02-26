package sparsearray;

/**
 * 稀疏数组的转换
 */
public class SparseArray {
    public static void main(String args[]) {
        int chessArray[][] = new int[3][3];
        chessArray[0][2] = 1;
        chessArray[1][1] = 2;
        chessArray[2][0] = 3;
        for (int row[] : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

//        将二维数组转稀疏数组
//        1.先遍历二维数组得到sum
        int sum = 0;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }

//        2.创建对应的稀疏数组
        int array[][] = new int[sum + 1][3];
//        稀疏数组赋值
        array[0][0] = chessArray.length;
        array[0][1] = chessArray[0].length;
        array[0][2] = sum;
//        count用于记录第几个非0数据
        int count = 0;
//        遍历二维数组，将非0的值存进稀疏数组
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    array[count][0] = i;
                    array[count][1] = j;
                    array[count][2] = chessArray[i][j];
                }
            }
        }
//        输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int row[] : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


//        将稀疏数组恢复成二维数组
        int chessArrays[][] = new int[array[0][0]][array[0][1]];
//        遍历稀疏数组
        for (int i = 1; i < array.length; i++) {
            chessArrays[array[i][0]][array[i][1]] = array[i][2];
        }

//        输出二维数组
        System.out.println("输出二维数组");
        for (int row[] : chessArrays) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
