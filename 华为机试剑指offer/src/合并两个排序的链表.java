public class 合并两个排序的链表 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    //0 <= 链表长度 <= 1000
    //输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
class Solution8 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //如果两个链表长度为0
        if (l1==null) return l2;
        if (l2==null) return l1;
        //1.新建虚拟头节点
        ListNode rhead = new ListNode(-1);
        ListNode temp = rhead;
        //2.依次比较两个链表节点,这里就不新建虚拟头节点了
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        //此时有一个不为空，
        while (l1!=null){
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2!=null){
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        return rhead.next;
    }
}
