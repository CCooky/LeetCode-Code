/**
 * 给定两个单词 word1 和 word2 ，
 * 返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 */
public class 两个字符串的删除操作 {
}
class Solution {
    public int minDistance(String word1, String word2) {
        //1.dp数组含义大小
        //dp[i][j]: 前i个元素组成的子序列（nums[0,..i-1]），和前j个元素组成子序列，要想达到相等，所需要删除元素的最小次数。
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
        // 两个当前元素相等；dp[i][j] = dp[i-1][j-1];
        // 两个当前元素不相等；dp[i][j] = min( dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+2)
        //4.遍历顺序
        for (int i = 1; i <dp.length; i++) {
            for (int j = 1; j <dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1,dp[i-1][j-1]+2));
                }
            }
        }
        return dp[n][k];
    }
}
