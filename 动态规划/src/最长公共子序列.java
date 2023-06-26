import java.util.Arrays;

public class 最长公共子序列 {
}
class Solution37 {
    public int longestCommonSubsequence(String text1, String text2) {

        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();
        //简单判断，dp的初始化
        if (nums1.length==0 || nums2.length==0){
            return 0;
        }

        //1.dp数组，使用二维的记录每个元素比较情况
        // dp[i][j]: 数组A中前i个元素组成的子序列，和数组B中前j个元素组成的子序列，最长重复子数组长度
        int n = nums1.length;
        int k = nums2.length;
        int[][] dp = new int[n+1][k+1];

        //3.dp数组初始化
        // 明显需要第一行，但是dp[0][...] 没有意义。dp[1][..]的话，确定不了又，需要用一个for去确定,
        // 使用dp[0][..]试试，看递推公式这里应该为0即可，其实是可以得
        // 哦，还有第一列，也是0吧，没问题
        Arrays.fill(dp[0],0);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        //2.递推公式
        //当第i个元素等于第j个元素时，是不是就直接等于dp[i-1][j-1] +1;
        //当第i个元素不等于第j个元素时，当前两个子序列的最长重复子数组长度就有几种分析了
        //第一种：两个序列都退一格，两个子数组的最长重复子数组长度啊，都退后一格好像就等于dp[i][j]
        //第二种：第一个序列退一格，第二个不动，两个子数组的最长重复子数组长度dp[i-1][j]
        //第二种：第一个序列不退，第二个退一格，两个子数组的最长重复子数组长度dp[i][j-1]
        // 最后取里面的最大值啊
        //4.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i-1][j-1]));
                }
            }
        }
        // 最后返回的是，dp的最后一个元素
        return dp[n][k];

    }

    public int longestCommonSubsequence2(String text1, String text2) {
        /**
         * 这两个转换太费时间了
         */
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();
        //简单判断，dp的初始化
        if (nums1.length==0 || nums2.length==0){
            return 0;
        }

        //1.dp数组，使用二维的记录每个元素比较情况
        // dp[i][j]: 数组A中以第i个元素结尾的子序列，和数组B中以第j个元素结尾的子序列，最长重复子数组长度
        int n = nums1.length;
        int k = nums2.length;
        int[][] dp = new int[n+1][k+1];

        //3.dp数组初始化
        // 明显需要第一行，但是dp[0][...] 没有意义。dp[1][..]的话，确定不了又，需要用一个for去确定,
        // 使用dp[0][..]试试，看递推公式这里应该为0即可，其实是可以得
        // 哦，还有第一列，也是0吧，没问题
        Arrays.fill(dp[0],0);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        //2.递推公式
        //4.
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    //dp[i][j] = dp[i-1][j-1] + 1;
                    //这里不需要连续了，那我们就应该在这两个元素前面的所有情况dp，取最大值
                    int max = 0;
                    for (int l = i-1; l >=1; l--) { //两个同时减1哦
                        for (int m = j-1; m >=1 ; m--) {
                            max = Math.max(max,dp[l][m]);
                        }
                    }
                    dp[i][j] = max +1;

                }else {
//                    dp[i][j] = 0;
                    //这里不需要连续了，并且当前两个元素不相等，那么还是一样的啊
                    dp[i][j] = 0;
                }
                // 懒得再写一个for遍历了
                result = Math.max(result,dp[i][j]);
            }
        }
        // 最后应该返回二维数组里面的最大值！，那我们直接在上面两个for得到算了
        return result;
    }

}
