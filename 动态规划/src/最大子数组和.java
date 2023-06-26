public class 最大子数组和 {
}
class Solution38 {
    public int maxSubArray(int[] nums) {
        if (nums.length==0) return 0;
        //1.dp
        int n = nums.length;
        int [] dp = new int[n+1];
        //这里的初始化可要小心了，后面的操作和dp[0]都没有关系，假如要加上它，那dp[0]必须=Integer.MIN_VALUE!!!
        dp[1] = nums[0];
        //2.
        //4.
        for (int i = 2; i < dp.length; i++) {
            if (nums[i-1]>0&&dp[i-1]>0 || nums[i-1]<=0&&dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i-1];
            }
            if (nums[i-1]>0 && dp[i-1]<=0 || nums[i-1]<=0&&dp[i-1]<=0){
                dp[i] = nums[i-1];
            }
        }
        // 返回值取dp数组里面的最大哦
        int res = dp[1];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
