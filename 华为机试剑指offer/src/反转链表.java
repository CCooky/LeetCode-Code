import java.util.Stack;

public class 反转链表 {

}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution26{

    public ListNode getResult2(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp!=null){
            //先处理后移动；
            stack.push(temp);
            //注意移动时的问题：要将每个节点的next指向null，否则会出现环
            ListNode p = temp.next;
            temp.next = null;
            temp = p;
        }

        ListNode rhead = new ListNode(-1);
        ListNode tt = rhead;
        while (!stack.isEmpty()){
            tt.next = stack.pop();
            tt = tt.next;
        }
        return rhead.next;
    }

    public ListNode getResult1(ListNode head){
        ListNode left = null;
        ListNode right = head;

        while (right!=null){
            //先处理后移动
            ListNode temp = right.next;
            right.next = left;
            //move
            left = right;
            right = temp;
        }
        return left;
    }
}
