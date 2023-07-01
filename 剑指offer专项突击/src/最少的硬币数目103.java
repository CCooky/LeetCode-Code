import java.util.Arrays;

public class 最少的硬币数目103 {

    // 背包问题：物品个数无限属于完全背包，求装满的最少物品个数
    public int getRes(int[] coins, int amount) {
        // dp[i][j]: 从前i个物品选，容量为j的背包装满所用的最少物品数
        //1、定义dp数组
        int bagSize = amount;
        int[] weights = coins;
        int[][] dp = new int[weights.length + 1][bagSize + 1];
        //3、dp初始化
        Arrays.fill(dp[0], Integer.MAX_VALUE - 2);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        dp[0][0] = 0;
        //2、递推公式
        // dp[i][j]  第i个物品能不能选
        // 能选：我又可以选或者不选 dp[i][j] = dp[i][j-weights[i-1]] + 1 || dp[i-1][j]
        // 不能选：dp[i][j] = dp[i-1][j];
        //4、遍历顺序
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - weights[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i][j - weights[i - 1]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int ans = dp[weights.length][bagSize] == Integer.MAX_VALUE - 2 ? -1 : dp[weights.length][bagSize];
        System.out.println(ans);
        return ans;
    }
}
