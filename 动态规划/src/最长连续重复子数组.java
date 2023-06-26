import java.util.Arrays;

public class 最长连续重复子数组 {
    public static void main(String[] args) {
        int[] nums1 = {0,1,1,1,1};
        int[] nums2 = {1,0,1,0,1};
        Solution35 solution35 = new Solution35();
        solution35.findLength(nums1,nums2);
    }
}
class Solution35 {
    public int findLength(int[] nums1, int[] nums2) {
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
        //这里只和两个当前的元素是否相等有关系，如果当前两个元素相等的话，那么dp[i][j] = dp[i - 1][j - 1] + 1;
        // 不相等的话，那么dp[i][j] = 0啊
        //4.
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = 0;
                }
                result = Math.max(result,dp[i][j]);
            }
        }
        // 最后应该返回二维数组里面的最大值！，那我们直接在上面两个for得到算了
        return result;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        //简单判断，dp的初始化
        if (nums1.length==0 || nums2.length==0){
            return 0;
        }
        //1.dp数组，使用二维的记录每个元素比较情况
        // dp[i][j]: 数组A中前i个元素组成的子序列，和数组B中前j个元素组成子序列，最长重复子数组长度
        int n = nums1.length;
        int k = nums2.length;
        int[][] dp = new int[n+1][k+1];

        //3.dp数组初始化
        // 明显需要第一行，但是dp[0][...] 没有意义。dp[1][..]的话，确定不了又，需要用一个for去确定,
        // 使用dp[0][..]试试，看递推公式这里应该为0即可，其实是可以得
        // 哦，还有第一列，也是0吧，没问题
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;

        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        //2.递推公式
        // dp[i][j]: 数组A中前i个元素组成的子序列，和数组B中前j个元素组成子序列，最长连续重复子数组长度
        //4.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        // 最后应该返回二维数组里面的最大值！，那我们直接在上面两个for得到算了
        return dp[n][k];
    }
}
