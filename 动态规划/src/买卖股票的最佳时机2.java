/**
 *
 */
public class 买卖股票的最佳时机2 {
}
class Solution111 {
    public int maxProfit(int[] prices) {
        //简单判断输入
        if (prices.length<=1) return 0;
        int n = prices.length; //天数
        //1.dp: 第i天持有、不持有股票的最大现金.求dp[n][]
        int[][] dp = new int[n+1][2];
        //3.初始化。0天、1天
        dp[0][0] = 0; //第0天没有意义啊，这里肯定不行！！！要从1开始
        dp[0][1] = 0;
        dp[1][0] = -prices[0];
        dp[1][1] = 0; //天数>=1;
        //2.
        //4.
        for (int i = 2; i <dp.length; i++) {
            //1.dp[i][0] 第i天持有股票的最大现金
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i-1]);
            //2.dp[i][1] 第i天 不持有股票的最大现金
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+ prices[i-1]);
        }
        // 返回的是第n天，所得的最大金额。那是不是当天不持有股票金额肯定大于当天持有股票的啊
        return dp[n][1];  // 卖出股票收益高于持有股票收益，因此取[0]
    }
}