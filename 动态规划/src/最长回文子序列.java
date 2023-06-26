public class 最长回文子序列 {
}

class Solution42 {
    public int longestPalindromeSubseq(String s) {
        //1.dp数组含义
        //dp[i][j]：索引【i，j】范围内最长回文子序列的长度
        int n = s.length();
        int[][] dp = new int[n][n];

        //3.dp数组初始化, 无法直接得到有用的，全部设为0

        //2.递推公式
        //如果索引i处等于索引j处：根据i、j的大小差值分了三种
        // i==j, dp[i][j]=1; j-i==1,dp[i][j]=2; j-i>1,dp[i][j]=dp[i+1][j-1]+2
        //如果不相等呢，那么应该就是，i往后缩小一位的情况+j往前缩一位的情况，两个取最大值
        // max(dp[i+1][j] , dp[i][j-1]
        //4.遍历顺序，左下角开始，看递推公式
        for (int i = dp.length-1; i >=0; i--) {
            for (int j = i; j <dp[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (i==j) dp[i][j] = 1;
                    if (j-i==1) dp[i][j] = 2;
                    if (j-i>1) dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
                }
            }
        }
        //
        return dp[0][n-1];
    }
}
