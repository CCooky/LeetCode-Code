import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 数组中重复的数字 {

}
class Solution001{
    public int getResult(int[] nums){
        //直接map过啊可以
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
