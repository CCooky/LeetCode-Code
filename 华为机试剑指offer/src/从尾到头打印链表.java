
import java.util.*;


public class 从尾到头打印链表 {
}
class Solution7 {
    public int[] reversePrint(ListNode head) {
        //1.虚拟头节点
        ListNode rhead = new  ListNode(100);
        rhead.next = head;
        //找一个temp节点，帮助遍历
        ListNode temp = rhead;
        Stack<Integer> stack = new Stack<>();
        //
        while (temp.next != null) { //到达尾节点时，已经全部遍历了一遍
            stack.push(temp.next.val);
            temp = temp.next;
        }
        int[]  res = new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        return res;
    }
}
