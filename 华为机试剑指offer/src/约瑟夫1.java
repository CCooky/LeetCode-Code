import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 已知n个人坐成一圈，按顺时针由1开始给大家编号。然后由第一个人开始顺时针循环报数从1开始，数到m的人出局，然后从下一个人接着开始从1报数，循环此过程直到最后只剩一个人。
 * 给定两个int n和m，要求编写函数返回最后一个人的编号。保证n和m小于等于1000。
 */
public class 约瑟夫1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();
        String[] split = next.split(",");
        int n = Integer.parseInt(split[0]);//n个人
        int m = Integer.parseInt(split[1]);//数到该数m出列
        //采用单向循环链表去做, 节点值是这个人的编号
        //1.构建单向循环链表
        ListNode first = new ListNode(1);
        ListNode temp = first;
        for (int i = 2; i <= n; i++) {
            ListNode node = new ListNode(i);
            temp.next = node;
            temp = temp.next;
        }
        //此时temp处于最后第n个节点,这里完成链表循环
        temp.next  = first;

        // 循环链表第一个节点（编号为1）为first；
        // 既然要删除节点，那么就需要找到被删节点的前一个才行！
        // 我们直接取第一个节点的前一个不就行了，也就是最后一个节点
        ListNode node = temp;
        int count = 0; //记录报的数字
        while (node.next!=node){ //注意第一个节点可能一来就被删啊
            count++;
            if (count==m){
                node.next = node.next.next;
                count = 0;
                continue;
            }
            //
            node = node.next;
        }
        System.out.println(node.val);
    }

    public static int getResult(int n, int m){
        //约瑟夫使用队列去做，直接拿双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        //存入每一个人的编号，
        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }
        //依次出队列，并且报数。不踢出的就出了队列后，接着放入队列尾部，踢出去的就踢出去
        int count = 0;
        while (true){
            count++;
            Integer gay = deque.poll();
            if (count==m){
                count = 0;
            } else {
                deque.offer(gay);
            }
            // 这里判断如果队列只有一个元素了，就stop
            if (deque.size()==1){
                break;
            }
        }
        return deque.poll();
    }
}
class ListNode{
    public int val;
    public ListNode next;
    public ListNode(){};
    public ListNode(int val){this.val = val;};
}



