import java.util.ArrayDeque;
import java.util.Deque;

public class 队列的最大值 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(94);
        maxQueue.push_back(16);
        maxQueue.push_back(89);
        maxQueue.push_back(22);
        System.out.println(maxQueue.deque);
        System.out.println(maxQueue.dequeAll);
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
    }
}

class MaxQueue {

    public Deque<Integer> deque;
    public Deque<Integer> dequeAll;

    public MaxQueue() {
        this.deque = new ArrayDeque<>();
        this.dequeAll = new ArrayDeque<>(); //用一个队列记录所有被插入的值，这样删除的时候我就知道删除的是哪个数
    }

    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.peek();
    }

    public void push_back(int value) {
        dequeAll.offer(value);
        if (deque.isEmpty()) deque.offer(value);
        else {
            if (deque.peekLast() >= value) deque.offer(value);
            else {
                while (!deque.isEmpty() && deque.peekLast() < value) {
                    deque.pollLast();
                }
                deque.offer(value);
            }
        }
    }

    // 哦豁，有点问题，这里要得到队头元素，不是得到最大值，但我们已经删除了啊！
    // 办法：再来一个队列，存放所有被插入的值，即一个正常的队列
    public int pop_front() {
        if (dequeAll.isEmpty()) return -1;
        int poll = dequeAll.poll();
        if (poll == deque.peek()){
            deque.poll();
        }
        return poll;
    }
}
