import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change-ii/
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * coins 中的所有值 互不相同
 * 1 <= coins[i] <= 5000
 */
public class 零钱兑换II {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = new int[]{1,1,2};
        int ans = solution16.change1(3, nums);
        System.out.println(ans);
    }
}
class Solution16 {

    /**
     * 完全背包一维dp
     */
    public int change2(int amount, int[] coins) {
        int bagSize = amount;
        int n = coins.length;
        int[] weight = coins;
        //使用完全背包的一维dp，求背包装满的方案数（组合数）：背包正序遍历，保证物品可以放入多次即可;组合数要求先遍历物品
        //1.dp数组大小含义，dp[j]：容量j的背包装满的方案数，求dp[bagSize]
        int[] dp = new int[bagSize+1];

        //3.dp数组初始化。物品数量为0
        Arrays.fill(dp, 0);
        dp[0] = 1; //

        //2.递推公式
        //4.遍历顺序：保证背包正序遍历，物品可以放入多次，组合数要求先遍历物品
        for (int i = 1; i <=n; i++) { //第一个物品到第n个物品
            for (int j = 1; j <=bagSize; j++) { //背包正序
                // 如果第i个物品可以放下
                if (j-weight[i-1]>=0){
                    dp[j] = dp[j] + dp[j-weight[i-1]];
                }else{
                    dp[j] = dp[j];
                }
            }
        }
        return dp[bagSize];
    }

    /**
     * 先来一个完全背包；二维dp
     */
    public int change1(int amount, int[] coins) {
        //基本信息
        int n = coins.length; //物品数量
        int bagSize = amount; //背包大小
        int[] weight = coins; //物品重量数组
        //1.dp数组大小、含义
        // dp[i][j]: 从i个物品选，背包容量为j，装满背包的方案数（物品可以重复选取）
        int[][] dp = new int[n+1][bagSize+1];

        //2.dp初始化；
        dp[0][0] = 1; //0个物品背包容量为0，方案数为1
        //第一行，从0个物品选，背包容量大于0，装满方案为0
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0 ;
        }
        for (int i = 1 ;i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j-weight[i-1]>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-weight[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][bagSize];

    }



}
