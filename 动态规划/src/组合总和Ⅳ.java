/**
 *给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 顺序不同的序列被视作不同的组合。
 */
public class 组合总和Ⅳ {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        int[] nums = new int[]{1,1,2};
        int target = 3;
        int res = solution19.combinationSum4(nums, target);
        System.out.println(res);
    }
}
class Solution19 {
    public int combinationSum4(int[] nums, int target) {
        // 求完全背包装满的方案数——排列情况
        //基本信息
        int bagSize = target;
        int n = nums.length;
        int[] weight = nums;
        // 完全背包北满的方案数，——排列情况；那么背包正序遍历保证物品重复加入，先遍历背包保证统计到排列情况
        //1.dp数组含义；
        int[] dp = new int[bagSize+1];
        //3.
        dp[0] = 1;
        //2.递推公式——背满的方案数
        for (int j = 1; j <=bagSize; j++) { //先遍历背包，正序
            for (int i = 1; i <=n; i++) {
                if (j-weight[i-1]>=0){
                    dp[j] = dp[j] + dp[j-weight[i-1]];
                }else{
                    dp[j] = dp[j];
                }
            }
        }
        return dp[bagSize];
    }
}
