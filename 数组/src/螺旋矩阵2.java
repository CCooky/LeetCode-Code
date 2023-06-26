import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例：输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * 这道题目可以说在面试中出现频率较高的题目，
 * 本题并不涉及到什么算法，就是模拟过程，但却十分考察对代码的掌控能力。
 */
public class 螺旋矩阵2 {
    public static void main(String[] args) {
//        int n = 3;
//        Solution2 solution2 = new Solution2();
//        int[][] ints = solution2.generateMatrix(n);
//        for (int i = 0; i < n; i++) {
//            System.out.print(Arrays.toString(ints[i]));
        int[][] nums = new  int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        Solution02 solution02 = new Solution02();
        solution02.spiralOrder(nums);
    }
}

class Solution2 {
    public int[][] generateMatrix(int n) {
        //1. 定义四个边界初始值以及二维数组
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] matrix = new int[n][n];
        //2. 定义被填充数num=1，最大数target=n*n，填充终止条件num>tar;
        int num = 1, target = n * n;
        //3. 模拟螺旋过程：从左到右，从上到下，从右到左，从下到上
        while (num <= target) {
            // 1.左到右，结束后，t要往下移动
            for (int i = l; i <= r; i++) {
                matrix[t][i] = num;
                num++;
            }
            t++;
            //2.上到下，结束后r要往左移
            for (int i = t; i <= b; i++) {
                matrix[i][r] = num;
                num++;
            }
            r--;
            //3. 右到左，结束后，b上移动
            for (int i = r; i >= l; i--) {
                matrix[b][i] = num;
                num++;
            }
            b--;
            //4.下到上，结束后，l右移
            for (int i = b; i >= t; i--) {
                matrix[i][l] = num;
                num++;
            }
            l++;
        }

        return matrix;
    }
}

class Solution02 {
    public int[][] matrix(int n) {
        // 填入的数为：1....n^2
        //设定四个边界先
        int[][] matrix = new int[n][n];
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        //左到右——上到下——右到左——下到上
        int x = 1;
        while (true) {
            //stop
//            if (x > n * n) break;
            if (l>r || t>b) break;

            //begin
            for (int i = l; i <= r; i++) {
                matrix[t][i] = x;
                x++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                matrix[i][r] = x;
                x++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                matrix[b][i] = x;
                x++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                matrix[i][l] = x;
                x++;
            }
            l++;
        }
        return matrix;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        int x = 1;
        //左到右——上到下——右到左——下到上
        while (true) {
            if (l > r || t > b) break;
            //begin
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
                x++;
            }
            t++;
            if (l > r || t > b) break;
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
                x++;
            }
            r--;
            if (l > r || t > b) break;
            for (int i = r; i >= l; i--) {
                list.add(matrix[b][i]);
                x++;
            }
            b--;
            if (l > r || t > b) break;
            for (int i = b; i >= t; i--) {
                list.add(matrix[i][l]);
                x++;
            }
            l++;
        }
        return list;
    }
}
