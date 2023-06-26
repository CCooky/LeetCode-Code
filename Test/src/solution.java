import java.util.*;
public class solution {
    public static void main(String[] args) {
        int[] nums = new int[]{10,14,12,11};
        int size = 0;
        maxInWindows(nums,size);
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        if(size ==0 || size>num.length) {
            return null;
        }
        //实现一个单调队列(数据结构)
        MyQueue myqueue = new MyQueue();
        //ru
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<size; i++){
            myqueue.offer(num[i]);
        }

        list.add(myqueue.getMax());
        for(int i=size; i<num.length; i++){
            myqueue.poll();
            myqueue.offer(num[i]);
            list.add(myqueue.getMax());
        }
        System.out.println(list);
        return list;
    }
}

//单调队列：队列元素是单调的，然后可以后端插入，两端删除。对外弹出的操作均是队列头部
class MyQueue{
    //两个双端队列即可实现，第一个是单调的，第二个就是正常的
    private Deque<Integer> deque;
    private Deque<Integer> dequeAll;

    public MyQueue(){
        deque = new ArrayDeque<>();
        dequeAll = new ArrayDeque<>();
    }

    public void offer(int num){
        dequeAll.offer(num);
        //单调队列
        if(deque.isEmpty()){
            deque.offer(num);
        }else{
            //那插入元素和队尾元素循环判断，出队列
            while(!deque.isEmpty() && num > deque.peekLast()){
                deque.pollLast();
            }
            deque.offer(num);
        }
    }

    public int poll(){
        int poll = dequeAll.poll();
        if(poll == deque.peek()){
            deque.poll();
        }
        return poll;
    }

    public int getMax(){
        return deque.peek();
    }
}