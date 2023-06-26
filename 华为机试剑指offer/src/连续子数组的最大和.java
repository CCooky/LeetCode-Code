public class 连续子数组的最大和 {
    public static void main(String[] args) {

    }
}
class Solution32{
    //求所有的连续子数组中，最大和。假如用暴力肯定不行，这里只要和，不要具体的数组，考虑一下dp
    public int getResult(int[] nums){
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        //果然是dp的题目啊
        //1.dp数组含义
        // dp[i]：以第i个元素结尾的子数组，最大和为多少。dp[n]
        int[] dp = new int[nums.length+1];
        //3.dp初始化
        dp[0] = 0;
        dp[1] = nums[0];
        //2.

        //4.遍历顺序;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i-1]>0){
                // 1、第i个元素的值大于0
                if (dp[i-1]<=0){
                    dp[i] = nums[i-1];
                }else {
                    dp[i] = dp[i-1] + nums[i-1];
                }
            }else {
                // 2、第i个元素的值小于0
                if (dp[i-1]<=0){
                    dp[i] = nums[i-1];
                }else {
                    dp[i] = dp[i-1] + nums[i-1];
                }
            }
        }
        //返回结果是dp数组内最大值
        int res = dp[1];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
