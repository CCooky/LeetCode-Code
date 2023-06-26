import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 扑克牌中的顺子 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 2, 5};
        System.out.println(getRes(nums));
    }

    public static boolean getRes(int[] nums) {
        //题目已经提前给我们做了转换，我们只需要判断数组是不是严格递增即可。0是特殊字符
        Arrays.sort(nums);
        int num_0 = 0; //0的个数
        Set<Integer> set = new HashSet<>(); //出现重复的非0数字也不行
        for (int num : nums) {
            if (num == 0) num_0++;
            else {
                if (set.contains(num)) return false;
                else set.add(num);
            }
        }
        if (num_0 == 5) return true;
        // 到这里，说没有出现非0的重复数字。
        //从宏观的角度来观察五张牌，找出0以外最小的值、最大的值。
        // 检查这两个值之间缺牌的个数gap与大小王的个数num0的关系：若gap>num0，说明缺的牌太多，0补不过来；
        // 若gap<=num0，说明缺的牌可以被0当赖子填上。
        int diff = nums[nums.length - 1] - nums[num_0] - 1; //最大值-最小值，他们中间差几个填充
        if (diff == 0) return true;
        int tt = (nums.length  - num_0  - 2); //目前已经有了几个填充值了
        if (num_0 >= diff-tt) return true;
        return false;

    }
}
