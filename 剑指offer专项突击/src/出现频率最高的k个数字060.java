import java.util.*;

public class 出现频率最高的k个数字060 {

    public int[] topKFrequent(int[] nums, int k) {
        // 直接统计数组里面每个元素出现的次数就行了，然后使用大根堆得出前k个，直接拿出优先队列即可，排序规则为次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        //
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : set) {
            queue.offer(entry);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}
