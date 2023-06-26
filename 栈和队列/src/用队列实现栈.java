import java.util.LinkedList;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，
 * 并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 */
public class 用队列实现栈 {
}
class MyStack {
    // queue1用来存放数据,顺序和栈的保持一样，借助q2完成

    public Queue<Integer> queue1;
    public Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue2;
        queue2 = queue1;
        queue1 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    // peek()
    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
