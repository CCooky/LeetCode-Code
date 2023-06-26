/**
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 */
public class 不同的二叉搜索树 {
}
class Solution11 {
    public int numTrees(int n) {
        if (n==0) return 1;
        if (n==1) return 1;
        //1.dp
        int[] dp = new int[n+1];
        //3.
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2; // n+1-1>=2 ==> n>=2
        //2.dp[n] = dp[0]*dp[n-1] +dp[1] *dp[n-2] +.....+dp[n-1] *dp[0]
        for (int i = 3; i < dp.length; i++) {
            for (int j = 0; j <= i-1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
