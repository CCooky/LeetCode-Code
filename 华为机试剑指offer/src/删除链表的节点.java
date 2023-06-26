public class 删除链表的节点 {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getResult(ListNode head, int val) {
        ListNode rhead = new ListNode(-1);
        rhead.next = head;
        ListNode temp = rhead;
        //
        while (temp.next != null) {
            //先处理后移动
            if (temp.next.val == val) { //删除后，不要移动temp节点，需要接着判断新接入的节点
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return rhead.next;

    }
}

