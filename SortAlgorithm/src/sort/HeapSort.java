package sort;

public class HeapSort {
    //原地修改
    public static int[] heap;
    public static void sort(int[] nums){
        heap = new int[nums.length + 1]; //加1，因为是从1开始存储
        System.arraycopy(nums, 0, heap, 1, nums.length);
        createHeap();
        // 到这里heap[1,heap.length-1]就是我们构建的堆
        // 索引1处为最大值，将他和堆数组最后一个元素交换，然后再对索引1元素进行范围下沉
        getSort();
        // 此时heap[1,heap.length-1] 是已经排序好的数组，最后修改原nums数组即可
        System.arraycopy(heap, 1, nums, 0, nums.length);
    }

    //1.构建堆数组（数据存储从索引1开始）
    public static void createHeap(){
        //对非叶子节点进行全部下沉即可
        // 索引k的节点：父节点-k/2，子节点——2k、2k+1
        for (int i = (heap.length-1)/2; i >=1; i--) {
            sink(i,heap.length-1);
        }
    }

    //2.元素下沉函数（范围下沉）
    public static void sink(int k, int maxIndex){
        while (2*k <= maxIndex){
            int maxchild = 0;
            if(2*k+1 <= maxIndex){
                //取左右节点最大值
                if (heap[2*k]>heap[2*k+1]) maxchild = 2*k;
                else maxchild = 2*k+1;
            }else maxchild = 2*k;
            //
            if (heap[maxchild]>heap[k]){
                int temp = heap[maxchild];
                heap[maxchild] = heap[k];
                heap[k] = temp;
                k = maxchild;// k change
            }
        }
    }

    //3.得到从小到大的排序结果
    public static void getSort(){
        //将树的根节点，与最后一个节点交换，然后对新根节点下沉即可
        int sinkIndex = heap.length-1;
        while (sinkIndex>=2){
            int temp = heap[sinkIndex];
            heap[sinkIndex] = heap[1];
            heap[1] = temp;
            sinkIndex--;
            sink(1,sinkIndex);
        }
    }
}

//public class HeapSort {
//
//    private static int[] heap; //构建的堆数组
//
//    //入口——排序方法——从小到大（int[] 类型数组）
//    public static void sort(int[] nums){
//        heap = new int[nums.length+1]; //加1，因为是从1开始存储
//        System.arraycopy(nums,0,heap,1,nums.length);
//        createHeap();
//        // 到这里heap[1,heap.length-1]就是我们构建的堆
//        // 索引1处为最大值，将他和堆数组最后一个元素交换，然后再对索引1元素进行范围下沉
//        getSortHeap();
//        // 此时heap[1,heap.length-1] 是已经排序好的数组，最后修改原nums数组即可
//        System.arraycopy(heap,1,nums,0,nums.length);
//    }
//
//    //1、根据原数组，构建一个大根堆，索引为1的元素是最大值
//    private static void createHeap(){
//        // 对 索引[N-1/2，..1] 这些节点依次下沉
//        int maxIndex = heap.length - 1;
//        for (int i = maxIndex/2; i >=1 ; i--) {
//            sink(i,maxIndex);
//        }
//    }
//    //2、对堆中索引为k的元素进行下沉操作; maxIndex是数组范围下沉——最大索引
//    private static void sink(int k, int sinkIndex){
//        while (2*k<=sinkIndex){
//            //1、找到子节点的最大值
//            int maxChild = 0;
//            if (2*k+1 <= sinkIndex){//存在右子节点，取两者最大值
//                if (heap[2*k]> heap[2*k+1]) maxChild = 2*k;
//                else maxChild = 2*k+1;
//            }else {
//                maxChild = 2*k;
//            }
//            //2、和子节点最大值进行比较
//            if (heap[k] >= heap[maxChild]){
//                break;
//            }else {
//                //交换
//                int temp = heap[k];
//                heap[k] = heap[maxChild];
//                heap[maxChild] = temp;
//                //
//                k = maxChild;
//            }
//        }
//    }
//
//    //3、对已构建好的堆数组heap，进行从小到大排序，就在原heap进行，采用范围下沉
//    // 排序完的heap就不是堆数组了哦
//    private static void getSortHeap(){
//        int sinkIndex = heap.length-1;
//        while(sinkIndex!=1){ //直到下沉的范围只有一个元素为止，即堆只有一个元素了
//            int temp = heap[1];
//            heap[1] = heap[sinkIndex];
//            heap[sinkIndex] = temp;
//            sinkIndex--;
//            sink(1,sinkIndex);
//        }
//        // heap[1,..sinkIndex]这部分依然是大根堆数组
//    }
//
//}
