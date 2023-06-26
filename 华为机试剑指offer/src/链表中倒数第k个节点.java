public class 链表中倒数第k个节点 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution23 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 虚拟头节点，采用间隔指针即可
        ListNode rhead = new ListNode(-1);
        rhead.next = head;
        //快指针指向最后一个节点时，慢指针少移动k-1次，倒数第k个节点
        ListNode fast = rhead;
        ListNode slow = rhead;
        for (int i = 0; i < k-1; i++) {
            fast = fast.next; //先移动k-1次
        }
        while (fast.next!=null){
            //先处理再移动，这里没有要处理的
            fast = fast.next;
            slow = slow.next;
        }
        //此时slow指向倒数第k个节点
        return slow;
    }
}