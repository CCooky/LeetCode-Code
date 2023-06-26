public class 买卖股票问题1 {
}
class Solution28 {
    /**
     * 暴力还是比较简单的
     * 最数组中两个数字之间的最大差值（即，最大利润）。找到一个最大值，一个最小值，并且满足最大值的索引大于最小值。
     * 两个for循环就可以了。
     * 注意到一点：这里求的很简单，不问你什么时候买入，什么时候卖出，就问最大利润，那么肯定有DP的操作，dp最擅长了。
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i <prices.length-1; i++) { //最后一天不能买入
            for (int j = i+1; j <prices.length ; j++) { //第1天不能卖出
                int money = prices[j] - prices[i];
                if (money>0){
                    max = Math.max(max, money);
                }
            }
        }
        return max;
    }
    /**
     * 暴力优化：66666。同时记录一个最低价格和一个最大利润
     * 遍历的时候同时记录最低点，如果今天最低点价值被更新，那么今天就不卖出
     * 如果今天最低点价格不变，那我就想我今天卖出能赚多少钱，算出来和记录的最大利润比较
     */
    public int maxProfit2(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice>prices[i]){ //今天买入
                minPrice = prices[i];
            }else { //看看今天要不要卖出
                int profit = prices[i] - minPrice;
                if (profit>maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * DP
     */
    public int maxProfit3(int[] prices){
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
            //1.dp[i][0]
            dp[i][0] = Math.max(dp[i-1][0], - prices[i-1]);
            //2.dp[i][1]
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+ prices[i-1]);
        }
        // 返回的是第n天，所得的最大金额。那是不是当天不持有股票金额肯定大于当天持有股票的啊
        return dp[n][1];
    }
}
