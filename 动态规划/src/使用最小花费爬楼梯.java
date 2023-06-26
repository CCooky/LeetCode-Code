/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费,
 */
public class 使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        Solution4 solution4 = new Solution4();
        int i = solution4.minCostClimbingStairs(cost);
        System.out.println(i); //正确应该是15
    }
}

class Solution4 {
    public int minCostClimbingStairs(int[] cost) {
        //需要爬的台阶数：cost的长度+1
        int n = cost.length+1;
        if (n==1) return 0;  //要对初始化后的dp进行return
        if (n==2) return 0;
        //1.dp数组，
        int[] dp = new int[n + 1];
        dp[0] = 0; //n=0，不爬其实是没有意义的
        dp[1] = 0;
        dp[2] = 0;
        //2.
        for (int i = 3; i < dp.length; i++) {
            int expense1 = dp[i - 1] + cost[i - 2];
            int expense2 = dp[i - 2] + cost[i - 3];
            dp[i] = Math.min(expense1, expense2);
        }
        return dp[n];
    }
}
