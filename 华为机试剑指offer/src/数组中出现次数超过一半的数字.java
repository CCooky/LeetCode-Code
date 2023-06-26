import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {

    }
}
class Solution37{
    public int getResult(int[] nums){
        //统计数组里面每个元素出现次数即可。哈希表
        // 不知道会出现哪些元素，使用map过
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        //遍历map集合即可；
        // 三种方式遍历，一种是keySet，一种是Map.entrySet，一种是lambda
        int res = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue()> nums.length/2){
                res = entry.getKey();break;
            }
        }
        return res;
    }
}
