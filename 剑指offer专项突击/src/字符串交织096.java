public class 字符串交织096 {

    /**
     * 采用分割的思路肯定做不了，很混乱
     */
    // 使用DP的方法做，也没见过这种的题目
    public boolean getRes(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) return false;
        // dp[i][j]: 前i个元素的字符串s1和前j个元素的字符串s2，能否组成前（i+j）个元素的字符串s3。求dp[n1][n2]
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // 初始化，第一行第一列
        for (int i = 1; i < dp[0].length; i++) {
            if (s2.substring(0, i).equals(s3.substring(0, i))) {
                dp[0][i] = true;
            } else dp[0][i] = false;
        }
        for (int i = 1; i < dp.length; i++) {
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                dp[i][0] = true;
            }else dp[i][0] = false;
        }
        dp[0][0] = true;

        // dp[i][j] = dp[i-1][j], dp[i][j-1], dp[i-1][j-1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } else if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j - 1]) {
                    //这种情况起始已经被上面两种情况包括了
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
