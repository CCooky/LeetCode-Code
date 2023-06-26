package sort;

public class MaxPriorityQueue {
    public int capacity; //队列容量
    public int size; //当前队列元素个数

    public MaxPriorityQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity+1];
    }
    //1、往队列中添加元素value
    public void offer(int value){
        if (size==capacity) return;
        size++;
        heap[size] = value;
        rise(size);
    }
    //2、弹出队列中最大值
    public int poll(){
        if (size==0) return -1; //无元素弹出
        int temp = heap[1];
        heap[1] = heap[size];
        heap[size] = temp;
        // 弹出的元素
        int res = heap[size];
        size--;
        sink(1);
        return res;
    }
    //3、查看队列中最大值
    public int peek(){
        if (size==0) return -1;
        return heap[1];
    }

    // 对外隐藏的部分
    private int[] heap; //从1开始存储
    //1、索引k处的元素上浮操作；属于范围上浮
    private void rise(int k){
        while (k/2>=1){ //存在父节点
            if (heap[k]>heap[k/2]){
                int temp = heap[k];
                heap[k] = heap[k/2];
                heap[k/2] = temp;
                k = k/2; //
            }else {
                break;
            }
        }
    }

    //2、索引k处的元素下沉操作，范围下沉；
    // 删除的时候，同堆排序类似，将1处和最大索引处元素交换，然后删除最大索引处元素，对1处进行下沉
    private void sink(int k){
        int maxIndex = size;
        while (2*k<=maxIndex){ //size就是heap堆数组中有效最大索引
            int maxChild = 0;
            if (2*k+1<=maxIndex){
                if (heap[2*k]>heap[2*k+1]){
                    maxChild = 2*k;
                }else maxChild = 2*k+1;
            }else {
                maxChild = 2*k;
            }
            //
            if (heap[k]<heap[maxChild]){
                int temp = heap[k];
                heap[k] = heap[maxChild];
                heap[maxChild] = temp;
                //
                k = maxChild;
            }else {
                break;
            }
        }
    }
}
