/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分
 */
public class 最大子数组和 {
}

class Solution {
    /**
     * 这道题滑动窗口也做不了，因为求的是最大和，所以我就是要遍历出所有的子序列情况，直接两个for暴力解开，或者回溯暴力分割开都是一样的
     */
    public int maxSubArray(int[] nums) {
        //先暴力解开
        int MaxSum = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum>MaxSum){
                    MaxSum = sum;
                }
            }
        }
        //
        return MaxSum;
    }
}
