import java.util.HashSet;
import java.util.Set;

public class 和为s的两个数字 {
}
class Solution51{
    public int[] getResult(int[] nums, int target){
        //使用哈希表做，直接输出数字即可，使用Set；加法变减法
        Set<Integer> set = new HashSet<>();
        int[] res = new int[2];
        for (int num : nums) {
            if (num>target) return new int[0];
            if (set.contains(target-num)){
                res[0] = num;
                res[1] = target-num;
                return res;
            }else {
                set.add(num);
            }
        }
        return new int[0];
    }
}
