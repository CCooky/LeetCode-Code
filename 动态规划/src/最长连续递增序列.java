public class 最长连续递增序列 {
}
class Solution33 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        //1.dp数组；
        // dp[i]: 从i个元素里面找，以第i个元素（nums[i-1])结尾的最长递增子序列长度。
        int[] dp = new int[n + 1]; //一共有n个元素
        //3.dp数组初始化
        dp[0] = 0;//没有意义，不用管
        dp[1] = 1; //n>=1

        //2.递推公式
        //4.遍历顺序
        for (int i = 2; i < dp.length; i++) { //从i个元素里面
            //1.
            if (nums[i-1] > nums[i-2]){
                dp[i] = dp[i-1] +1;
            }else {
                dp[i] = 1;
            }
        }
        // 最后返回结果是，整个数组内最长递增子序列长度，所以是不是我们取dp数组里面最大值啊
        int dpMax = 0; //这里0是没有意义的，
        for (int i = 1; i < dp.length; i++) {
            dpMax = Math.max(dp[i], dpMax);
        }
        return dpMax;
    }
}
