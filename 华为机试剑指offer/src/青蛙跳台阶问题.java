public class 青蛙跳台阶问题 {
}

class Solution4 {
    public int numWays(int n) {
        //输入简单判断
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return 1;
        //1.dp。一维dp[i]：跳了i个台阶，站在第i个台阶上面，的方案数; 求dp[n]
        int[] dp = new int[n + 1];
        //3.Initial;
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2; //n>=2
        //2.
        //4.遍历顺序
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
