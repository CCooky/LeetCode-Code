import java.util.*;

/**
 * 给你一个整数数组nums和一个整数k，请你返回其中出现频率前k高的元素。
 * 你可以按 任意顺序 返回答案。
 */
public class 前K个高频元素 {

}

class Solution3 {
    /**
     * map集合呢？contains为O(1)，
     * 最后取出value最大的k个数怎么做，不行做不了啊
     */
    public int[] topKFrequent(int[] nums, int k) {
        // 1.map集合计算每个元素及其频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        //2. 将map集合遍历，直接获取键值对对象呀
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        //3. 优先队列，放我们的entry对象了。
//        Queue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o2.getValue() - o1.getValue();
//            }
//        });
        Queue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getValue()-o1.getValue());
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            priorityQueue.offer(entry);
        }
        // 4.依次取出队列头，保证队头为最大值。取完了之后，他会去进行堆重构再次选出最大值
        int[] res = new int[k];
        int j = 0;
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = priorityQueue.poll();
            res[j++] = poll.getKey();
        }
        return res;

    }
}


