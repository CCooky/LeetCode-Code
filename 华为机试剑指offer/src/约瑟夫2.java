import java.security.PublicKey;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/ff063da83b1a4d91913dd1b1e8b01466
 * 来源：牛客网
 * <p>
 * 现有n个人围坐一圈，顺时针给大家编号，第一个人编号为1，然后顺时针开始报数。
 * 第一轮依次报1，2，1，2...没报1的人出局。接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...没报1的人都出局。
 * 以此类推直到剩下以后一个人。现给定一个int n，要求返回最后一个人的编号。
 */
public class 约瑟夫2 {

    public int getResult(int n) {
        // write code here
        //1.两个队列解决这个问题，因为我们要记录循环了几次，第一个队列挨个到第二个队列里面去
        //队列存的是每个人的编号
        Deque<Integer> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue1.offer(i);
        }
        //开始报数，报一个数出一个队列
        int count = 0; //记录报数
        int num = 1; //第几轮
        while (true) { //q2里面只有一个人的时候，表示结束了
            while (!queue1.isEmpty()) { //q1全部出去了，表示一轮结束了
                count++;
                Integer gay = queue1.poll();
                if (count == 1) {
                    queue2.offer(gay);
                }
                if (count == num + 1) {
                    count = 0;
                }
            }
            count = 0;
            num++;
            //接着第二轮再从上一轮最后一个报数的人开始依次报, 最后一个报数的在q2的尾巴啊，要把他拿到前面来，使用双端队列才行
            queue2.offerFirst(queue2.pollLast());
            if (queue2.size()==1){
                break;
            }
            // 让q1、q2交换指针指向，
            Deque<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        // 当q2只有一个时结束了
        return queue2.poll();
    }
}

