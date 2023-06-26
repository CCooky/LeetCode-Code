import java.util.PriorityQueue;
import java.util.Queue;

public class 最小的k个数 {
    public static void main(String[] args) {

    }
}

class Solution29 {
    public int[] getResult(int[] arr, int k) {
        //最快解法，优先队列
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2); //升序排列，小根堆
        for (int i : arr) {
            queue.offer(i);
        }
        int[] res= new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }


}
