public class 乘积小于K的子数组009 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //只需要输出个数，直接dp；滑动窗口也可以；dp好像做不了，算了，滑动起来for+while
        // 注意forwhile只能求大于的条件，我们可以逆序转换成大于的条件,这道题有点难
        int multiply = 1;
        int start = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) { // 终止位置
            multiply *= nums[i];
            if (multiply < k) {
                ans += i - start + 1; // 以窗口右端点结尾的子连续数组的个数
            } else {
                while (multiply >= k && start <= i) {
                    multiply /= nums[start];
                    start++;
                }
                if (start <= i){
                    ans += i - start + 1; // 以窗口右端点结尾的子连续数组的个数
                }
            }
        }
        return ans;
    }
}
