import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围
 */
public class 不同的子序列 {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        Solution40 solution40 = new Solution40();
        solution40.numDistinct2(s,t);
    }
}
class Solution40 {
    public int numDistinct(String s, String t) {
        //输入的判断。这里不用加了，在dp数组里面都有
        //1.dp数组含义
        // dp[i][j] ：以前i个元素组成的s子序列中出现以前j个元素组成的t子序列的次数
        int n = s.length();
        int k = t.length();
        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();
        int[][] dp = new int[n+1][k+1];
        //3.
        dp[0][0] = 1; //n,k大于大于0
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        //2.
        //4.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        //返回的结果是最后一个dp数
        return dp[n][k];
    }

    public int numDistinct2(String s, String t) {
        //输入的判断。这里不用加了，在dp数组里面都有
        //1.dp数组含义
        // dp[i][j] ：以第i个元素结尾的s子序列中出现 前j个元素组成的t子序列的次数
        int n = s.length();
        int k = t.length();
        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();
        int[][] dp = new int[n+1][k+1];
        //3.
        dp[0][0] = 1; //n,k大于大于0
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        //2.
        //4.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    int sum = 0;
                    for (int l = 0; l < i; l++) {
                        sum += dp[l][j];
                    }
                    dp[i][j] = dp[i-1][j-1] + sum;
                    //dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        //返回的结果是最后一个dp数
//        dp[...][k]
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = res + dp[i][k];
        }
        return res;
    }
}
