public class 最佳买卖股票时机含冷冻期 {
}
class Solution29 {
    public int maxProfit(int[] prices) {

        //因为有冷冻期出现，一天就有三个状态，某一天卖出股票后，就马上处于冷冻期，当天不能再买入后一天也不能买入
        // dp[i][0]: 第i天持有股票最大利润；
        // dp[i][1]：第i天不持有股票，且不处于冷冻期（今天不能卖出），最大利润
        // dp[i][2]：第i天不持有股票，且处于冷冻期（今天必须卖出），最大利润
        int n = prices.length;
        int[][] dp = new int[n+1][3];

        //3.
        dp[1][0] = -prices[0];
        dp[1][1] = 0;
        dp[1][2] = 0; //tui dao

        //2.
        // dp[i][0] = MAX( dp[i-1][0], dp[i-1][1] - prices[i-1] )
        // dp[i][1] = MAX( dp[i-1][1], dp[i-1][2] )
        // dp[i][2] = MAX( dp[i][0]+prices[i-1] )
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max( dp[i-1][0], dp[i-1][1] - prices[i-1] );
            dp[i][1] = Math.max( dp[i-1][1], dp[i-1][2] );
            dp[i][2] =  dp[i][0]+prices[i-1];
        }
        return Math.max(dp[n][1], dp[n][2]);

    }
}
