import java.util.PriorityQueue;
import java.util.Queue;

public class 数据流中的中位数 {
    public static void main(String[] args) {

    }
}

class MedianFinder {
    /** initialize your data structure here. */
    // 使用两个优先队列（即大根堆、小根堆去维护），大根堆==》》小根堆是有序的，且大根堆的数量奇数是多1
    // 右边大根堆，左边小根堆；大根堆存放数组的前一半数据（n、n+1），小根堆存放后半段数（n、n）
    // 当两个堆的数量相等时，即为偶数，那么mid = （大根堆堆顶+小根堆堆顶）/2
    // 不相等，即奇数，那么mid = 大根堆堆顶；
    // 插入时数据时，分为数组整体大小奇数、偶数两种情况，
    // 奇数时：肯定是右边小根堆元素加1。先把num加入大根堆内排序，然后把大根堆最大值弹出加入右边
    // 偶数时：肯定是左边大根堆元素加1。先把num加入右边小根堆内排序，然后把小根堆最小值弹出加入左边
    Queue<Integer> queue1 = new PriorityQueue<>((o1,o2)-> o2-o1); //左边，大根堆
    Queue<Integer> queue2 = new PriorityQueue<>(); //右边，小根堆
    public int size = 0; //数据总数
    public MedianFinder() {

    }

    public void addNum(int num) {
        //偶数时，两个堆数量相等。最后入左边的大根堆
        if (queue1.size()==queue2.size()){
            queue2.add(num);
            queue1.add(queue2.poll());
        }else {
            //奇数时，最后入右边小根堆
            queue1.add(num);
            queue2.add(queue1.poll());
        }
    }

    public double findMedian() {
        if (queue1.size()==0) return 0;
        //
        if (queue1.size()==queue2.size()){
            return (queue1.peek()+queue2.peek())/2.0; //运算符最后结果类型和前面的那个数据类型保持一致
        }else {
            return queue1.peek();
        }
    }
}

