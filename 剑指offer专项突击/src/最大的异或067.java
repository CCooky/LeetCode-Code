public class 最大的异或067 {

    public int getRes(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(nums[i] ^ nums[j], ans);
            }
        }
        return ans;
    }
}
