public class 股票的最大利润 {
    public static void main(String[] args) {

    }
    // 买卖一次股票，最简单问题
    public static int getRes(int[] prices){
        if (prices.length<2) return 0;
        //1、二维dp，一天有两个状态：dp[i][0]第i天持有股票最大利润，dp[i][1]第i天不持有股票最大利润；
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        //3、初始化
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = -prices[0];
        dp[1][1] = 0;

        //2、递推
        // dp[i][0]: 1.第i-1天就已经持有股票 dp[i][0] = dp[i-1][0];
        //           2.第i-1天不持有，今天持有就是今天买入 dp[i][1] = -prices[i-1];(这里注意不要加上dp[i][1])
        // dp[i][1]:1.第i-1天不持有股票dp[i][1]=dp[i-1][1];
        //          2.第i-1天持有，今天不持有就是今天卖出 dp[i][1] = dp[i-1][0]+prices[i-1]
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i-1]);
        }
        return dp[n][1]; //不持有
    }
}
