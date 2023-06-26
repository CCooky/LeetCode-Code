public class 顺时针打印矩阵 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     */
    public static void main(String[] args) {

    }
}
class Solution21 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null) return null;
        if (matrix.length==0) return new int[0];
        if (matrix[0].length==0) return new int[0];
        // 至少有一行一列，防止索引越界
        // 重点就是 定义4个边界出来
        int m = matrix.length;
        int n = matrix[0].length;
        int k = 0;
        int[] nums = new int[m*n];
        int l = 0;
        int r = n-1;
        int t = 0;
        int b = m-1;
        // 循环结束条件，每次边界发生变化都要判断，是l>r || t>b 。
        while (true){
            //左到右、上到下、右到左、下到上
            for (int i = l; i <=r ; i++) {
                nums[k] = matrix[t][i];
                k++;
            }
            t++;
            if (l>r||t>b) break;
            //左到右、上到下、右到左、下到上
            for (int i = t; i <=b ; i++) {
                nums[k] = matrix[i][r];
                k++;
            }
            r--;
            if (l>r||t>b) break;
            //左到右、上到下、右到左、下到上
            for (int i = r; i >=l ; i--) {
                nums[k] = matrix[b][i];
                k++;
            }
            b--;
            if (l>r||t>b) break;
            //左到右、上到下、右到左、下到上
            for (int i = b; i >=t ; i--) {
                nums[k] = matrix[i][l];
                k++;
            }
            l++;
            if (l>r||t>b) break;
        }
        return nums;
    }

    public int[][] generateMatrix(int n) {
        if (n<1) return new int[0][0];
        // 至少有一行一列，防止索引越界。一共有 n*n个数字
        int[][] matrix = new int[n][n];
        // 重点就是 定义4个边界出来
        int l = 0;
        int r = matrix[0].length-1;
        int t = 0;
        int b = matrix.length-1;
        // 循环结束条件，每次边界发生变化都要判断，是l>r || t>b 。
        int num = 1;
        while (true){
            //左到右、上到下、右到左、下到上
            for (int i = l; i <=r ; i++) {
                matrix[t][i] = num;
                num++;
            }
            t++;
            if (l>r||t>b) break;
            //左到右、上到下、右到左、下到上
            for (int i = t; i <=b ; i++) {
                matrix[i][r] = num;
                num++;
            }
            r--;
            if (l>r||t>b) break;
            //左到右、上到下、右到左、下到上
            for (int i = r; i >=l ; i--) {
                matrix[b][i] = num;
                num++;
            }
            b--;
            if (l>r||t>b) break;
            //左到右、上到下、右到左、下到上
            for (int i = b; i >=t ; i--) {
                matrix[i][l] = num;
                num++;
            }
            l++;
            if (l>r||t>b) break;
        }
        return matrix;
    }
}
