package test;

import sort.MaxPriorityQueue;

public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue queue = new MaxPriorityQueue(5);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);

//        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.offer(100);
        System.out.println(queue.peek());
        System.out.println(queue.size);
    }
}
