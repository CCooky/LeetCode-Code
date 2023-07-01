/**
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 */
public class 和为k的子数组010_2 {

    public int getRes(int[] nums, int k) {
        // 不能使用滑动窗口了，因为数组不是非负整数；
        // 我们使用暴力，第一个for确定终止位置，第二个for确定起始位置，然后区间求和，这个求和过程可以优化的；从后往前求，很巧妙，和之前一个思想特别像，一下子想不起来了。
        // 这样就从 n3 变成了 n2
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }

    //解法2，使用前缀数组，复杂度还是n2
    public int getRes2(int[] nums, int k) {
        // 前缀和数组就是，当前元素之前的所有元素的和，包括当前元素；
        // 那么所有的连续子数组和就可以使用前缀和来表示，比如下标 j->i 的连续数组的和就等于preSum[i]-preSum[j-1]
        int[] preSum = new int[nums.length];
        //1.
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        //2.
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) { //遍历所有子连续数组
                if (preSum[i] - preSum[j] + nums[j] == k) ans++;
            }
        }
        return ans;
    }
}
