import java.util.Scanner;

public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        //测试，构建一个链表
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nodevalues = new int[n];
        for (int i = 0; i < n; i++) {
            nodevalues[i] = sc.nextInt();
        }
        //
        if (n==0) return;
        //
        ListNode rhead = new ListNode(-1); //virtual
        ListNode temp = rhead;
        for (int i = 0; i < nodevalues.length; i++) {
            ListNode node = new ListNode(nodevalues[i]);
            temp.next = node;
            temp = temp.next;
        }
        //调用方法
        Solution80 solution = new Solution80();
        ListNode newhead = solution.swapPairs2(rhead.next);
        while (newhead != null){
            System.out.print(newhead.val+"-");
            newhead = newhead.next;
        }
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution80 {
    // 两两交换链表中的节点
    //递归法：返回值是当前节点为头节点的链表交换完之后的新头节点
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 两个节点为一对，进行两两交换
    // 返回值是当前节点为头节点的链表交换完之后的新头节点
    public ListNode swapPairs2(ListNode head){
        //少于三个节点不需要交换（0，1，2）
        if (head ==null || head.next==null || head.next.next==null){
            return head;
        }
        //
        ListNode newHead = head.next.next;
//        head.next.next = swapPairs2(newHead.next.next);
//        newHead.next.next = head;
        if (newHead.next!=null) { //当第二对有两个元素时
            head.next.next = swapPairs2(newHead.next.next);
            newHead.next.next = head;
        }
        if (newHead.next==null) { //当第二队只有一个元素时
            head.next.next = swapPairs2(newHead.next);
            newHead.next = head;
        }

        return newHead;
    }
}

