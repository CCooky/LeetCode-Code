import java.util.PriorityQueue;
import java.util.Queue;

public class 数据流的第K大数值059 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        KthLargest kth = new KthLargest(1, nums);
        kth.add(-3);
        kth.add(-2);
        kth.add(-4);
    }


}

// 思路1，按照正常的想法来做：保存所有的元素，排序，得到第k大的。插入一个元素就要排序一次，复杂度为nlogn，可以使用数组来实现，排序完后支持随机访问
// 思路2，不保存所有的元素，只要前k个大的元素即可，就可以使用优先队列实现了—小根堆，队头是最小的，队列长度为k，每次和队头元素比较即可，假如更大就踢掉队头，插入新的；
// 复杂度为：第一次需要klogk进行堆排，后面就不是每次都需要排序。
class KthLargest {

    private Queue<Integer> priorityQueue;
    private int k;
    private int capacity; //当前队列数据量

    public int add(int val) {
        if (capacity < k) {
            priorityQueue.offer(val);
            capacity++;
        } else {
            if (priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }
        return priorityQueue.peek();
    }

    public KthLargest(int k, int[] nums) {
        this.priorityQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        this.k = k;
        if (nums.length <= k) {
            for (int i = 0; i < nums.length; i++) {
                priorityQueue.add(nums[i]);
                capacity++;
            }
        } else {
            for (int i = 0; i < k; i++) {
                priorityQueue.offer(nums[i]);
                capacity++;
            }
            for (int i = k; i < nums.length; i++) {
                if (!priorityQueue.isEmpty() && priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }
    }
}


















