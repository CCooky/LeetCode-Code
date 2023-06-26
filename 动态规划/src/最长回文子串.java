public class 最长回文子串 {
}

class Solution99 {
    public String longestPalindrome(String s) {
        //1.dp 索引在[i, j]范围这个字符串是不是回文串，是则为true
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        //3.dp初始化为false
        //2.
        // 索引i处等于索引j处；
        //  i==j >>> dp[i][j]=true; j-1==1 >>> dp[i][j]=true; j-i>1 >>>dp[i][j]=dp[i+1][j-1]
        // 不等于的话；直接就有dp[i][j]=false
        //4. 左下角开始遍历啊
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) dp[i][j] = true;
                    if (j - i == 1) dp[i][j] = true;
                    if (j - i > 1) dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        // 最后需要得到这个字符串最长的回文子串长度（连续）
        int maxLen = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp[0].length; j++) {
                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);//java源码左闭右开
    }
}
