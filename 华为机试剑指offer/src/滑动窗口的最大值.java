import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        getRes(nums,3);
    }

    public static int[] getRes(int[] nums, int k){
        //
        MyQueue myQueue = new MyQueue() ;
        //放入k个元素啊
        for (int i = 0; i < k; i++) {
            myQueue.offer(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(myQueue.peek());
        //再加
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.offer(nums[i]);
            list.add(myQueue.peek());
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        System.out.println(list);
        return res;

    }


}
//手写一个单调队列，单调递减的，即队头是最大值
class MyQueue{
    private Deque<Integer> deque;

    public MyQueue(){
        this.deque = new ArrayDeque<>();
    }
    //1、插入某个元素(只能队尾）
    public void offer(int n){
        if (deque.isEmpty()) deque.offer(n);
        else {
            //因为单调递减，所以插入元素要判断
            if (deque.peekLast() >= n){
                deque.offer(n);
            }else {
                while (!deque.isEmpty() && deque.peekLast()<n){
                    deque.pollLast();
                }
                deque.offer(n);
            }
        }
    }
    //2、删除某个元素（只能队头删除）
    public void poll(int n){
        if (deque.isEmpty()) return;
        if (n == deque.peek()){
            deque.pollFirst();
        }
    }
    //3、查看队头元素，即查看最大值
    public int peek(){
        if (deque.isEmpty()) return -1;
        return deque.peek();
    }
}
