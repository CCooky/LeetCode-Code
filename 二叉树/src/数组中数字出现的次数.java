import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 数组中数字出现的次数 {
}
class Solution49{
    public int[] getResult(int[] nums){
        //不可能小于2
        int[] res = new int[2];
        //
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        //遍历map，取出
        int i = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue()==1){
                res[i++] = entry.getKey();
            }
        }
        return res;
    }
}
