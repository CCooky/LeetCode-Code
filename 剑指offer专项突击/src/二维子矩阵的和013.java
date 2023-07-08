public class 二维子矩阵的和013 {


}

/**
 * 暴力解法1
 */
class NumMatrix {
    private int[][] matrix;

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }


    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}

/**
 * 前缀和解法！凡是这种连续元素累计求和的，都可以使用前缀和。这道题和该系列010思想一模一样
 * 为什么要这样做，不直接累计和呢？
 * 1、一劳永逸和每次重复性机械工作是不一样的，计算sumRegion的次数越多，差距越大
 * 2、缓存的思想 你不懂
 */
class NumMatrixPrefix {
    private int[][] matrix;
    private int[][] matrixPrefix; // 每一行的前缀和数组

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += matrixPrefix[i][col2] - matrixPrefix[i][col1] + matrix[i][col1];
        }
        return sum;
    }

    public NumMatrixPrefix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.matrix = matrix;
        this.matrixPrefix = new int[m][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
                matrixPrefix[i][j] = sum;
            }
        }
    }
}
