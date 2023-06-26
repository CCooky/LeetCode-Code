/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * （在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class 不同路径 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int num = solution5.uniquePaths(2, 1);
        System.out.println(num);
    }
}

class Solution5 {
    /**
     * 很明显，DP的题目；1 <= m, n <= 100
     */
    public int uniquePaths(int m, int n) {
        // 记得return, 这里易错了，m、n是棋盘的长度
        if (m < 1 || n < 1) return 0;
        //1.dp，大小确定
        int[][] dp = new int[m][n];
        //3.初始化,记得return,所以这里要求 m>=1,N>=1，同时满足
        dp[0][0] = 1; //就在出生岛位置，1，不走也是一条路径啊
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        //2.递推关系，dp[i, j] = dp[i-1, j] + dp[i, j-1]；
        for (int i = 1; i < dp.length; i++) { //先行后列
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
