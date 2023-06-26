public class 买卖股票的最佳时机含手续费 {
}
class Solution30 {
    public int maxProfit(int[] prices, int fee) {
        //输入简单判断
        if (prices.length<=1) return 0;
        int n = prices.length;
        //1.dp数组含义大小；求dp[n][]
        // dp[i][0]: 第i天持有股票获得的最大利润；
        // dp[i][1]: 第i天不持有股票获得的最大利润；
        int[][] dp = new int[n+1][2];
        //3.dp数组初始化
        //dp[0] 第0天，股票大厅还没有开门都
        //dp[1] 第1天，可以买入股票了,但不能卖啊
        dp[1][0] = -prices[0];
        dp[1][1] = 0; //把第二天带入递推公式看看
        //2.递推公式
//        dp[i][0] = dp[i-1][0], dp[i-1][1] -prices[i-1];
//        dp[i][1] = dp[i-1][1], dp[i-1][0] + prices[i-1] - fee;
        //4.遍历顺序
        for (int i = 2; i <dp.length ; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] -prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i-1]-fee);
        }
        return dp[n][1];

    }
}
