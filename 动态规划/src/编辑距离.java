public class 编辑距离 {
}
class Solution91 {
    public int minDistance(String word1, String word2) {
        //1.dp数组含义
        //dp[i][j]：前i个元素组成的序列和前j个元素组成的序列，前一个变成和第二个相等，最少操作数；
        int n = word1.length();
        int k = word2.length();
        int[][] dp = new int[n+1][k+1];

        //3.dp数组初始化
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        //2.递推公式
        //第i个元素等于第j个元素
        //第i个元素不等于第j个元素；增dp[i][j-1]+1; 删dp[i-1][j]+1; 改dp[i-1][j-1]+1
        //4.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i][j-1]+1, Math.min(dp[i-1][j]+1,dp[i-1][j-1]+1));
                }
            }
        }
        //返回的是最后一个对吧
        return dp[n][k];
    }
}
