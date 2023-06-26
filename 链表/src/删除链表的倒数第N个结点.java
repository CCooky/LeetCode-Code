/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 其中告诉你了，1 <= n <= 节点数
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class 删除链表的倒数第N个结点 {
}
class Solution3{
    /**
     * 第一种：先扫描一遍，获得链表长度len，
     * 然后就可以得出要删除的节点在第（len-n+1）个位置，再次扫描即可
     */
    public ListNode removeNthFormEnd(ListNode head, int n){
        return null;
    }
    /**
     * 只扫描一遍的话，就使用双指针，主要是找到被删除节点的前一个位置
     * 模拟快指针到达链表末尾时，慢指针到被删除的元素那里
     * 具体就是：快指针指向最后的null，慢指针在其前面n+1个位置（被删除的前一个节点），慢指针少后移n+1次
     */
    public ListNode removeNthFormEnd2(ListNode head, int n){
        //1.链表为空
        if (head==null) return null;
        //头节点
        ListNode rhead = new ListNode();
        rhead.next = head;
        // 已知道n有效, 且至少有一个节点
        ListNode fast = rhead;
        ListNode slow = rhead;
        // 快指针先移动n+1次
        for (int i = 0;i<(n+1);i++){
            fast = fast.next;
        }
        while (fast!=null){ //知道快指针移动到最后的null
            fast = fast.next;
            slow = slow.next;
        }
        // slow 为被删除的前一个节点位置 (slow下一个节点肯定不为null）
        slow.next = slow.next.next;
        return rhead.next;
    }

}

