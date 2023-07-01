/**
 * 给定一个非负整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 * 这是我自己改的题目。（注意k是一个整数）
 */
public class 和为k的子数组010_1 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 3, 4};
        int k = 3;
        new 和为k的子数组010_1().getRes(nums, k);
    }

    public int getRes(int[] nums, int k) {
        // 元素非负且连续子数组，可以滑动窗口，forwhile
        int sum = 0;
        int start = 0; //start
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {// i: end
            sum += nums[i];
            if (sum == k) {
                ans++;
                while (sum == k) { //数组出现0情况的判断
                    sum -= nums[start];
                    start++;
                    if (sum == k) ans++;
                }
            } else if (sum > k) {
                //循环移动
                while (sum > k && start <= i) { // k小于0时，有非法区间
                    sum -= nums[start];
                    start++;
                }
                if (sum == k && start <= i) ans++; // 易错，因为start可能是i+1，已经不是一个有效区间
            }
        }
        System.out.println(ans);
        return ans;
    }
}
