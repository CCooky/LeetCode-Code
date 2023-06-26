public class 整数中1出现的次数 {
}
class Solution36{
    public int getResult(int n){
        int[] nums = new int[n];
        int x = 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = x;
            x++;
        }
        //
        int count = 0;
        StringBuilder s = new StringBuilder();
        for (int num : nums) {
            s.append(num);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='1'){
                    count++;
                }
            }
            s.delete(0,s.length());
        }
        return count;
    }
}
