import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class 滑动窗口最大值 {
}

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 用队列做, 只放k个数
        Queue<Integer> queue = new LinkedList<>();
        // 1.如果数组长度小于等于k呢
        if (nums.length <= k) {
            // 不进入队列中，直接求最大值
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return new int[]{max};
        }
        // 2.数组长度大于k
        // 先入队列k个数
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        // 然后再从后面开始一个个入，一个个出

        return nums;
    }

    /**
     * 单调队列：只能队尾进，但可以两端删除的双端队列。
     */
    public int[] maxSlidingWindow2(int[] nums, int k){
        // 1.如果数组长度小于等于k呢
        if (nums.length <= k) {
            // 不进入队列中，直接求最大值
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            return new int[]{max};
        }
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        //2. 先放入数组前K个数
        for (int i = 0; i < k; i++) {
            monotonicQueue.offer(nums[i]); //此时队列内元素个数小于等于k，队首是最大的元素
        }
        int[] res = new int[nums.length - k +1]; //结果对象,不对会有默认值0
        res[0] = monotonicQueue.getMaxK();
        int j = 1;
        // 3. 然后剩余的数一个个进入
        for (int i = k; i < nums.length; i++) {
            // 先入再出，先出再入都是一样的
            monotonicQueue.poll(nums[i-k]);
            monotonicQueue.offer(nums[i]);
            // 只能放在得到目前窗口的最大值
            res[j++] = monotonicQueue.getMaxK();
        }
        return res;
    }

}

class MonotonicQueue {
    // 1.定义双端队列
    Deque<Integer> deque = new ArrayDeque<>();

    //1.定义队列的删除，每次调用这个都是队首的删除哇！！插入才伴随的队尾删除
    public void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    //2.定义队列的插入，
    public void offer(int val) {
        while (!deque.isEmpty() && deque.peekLast() < val) {
            deque.pollLast();
        }
        deque.offer(val);
    }
    //3. 定义获取当前队列最大值
    public Integer getMaxK(){
        if (deque.isEmpty()) return null;
        return deque.peek();
    }

}