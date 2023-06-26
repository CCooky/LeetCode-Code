
/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * 其实就是有环链表入口问题
 */
public class 环形链表2 {
}

class Solution5 {
    public ListNode detectCycle(ListNode head) {
        //使用快慢指针不需要头节点
        // 链表为空/链表只有一个元素
        if (head == null || head.next == null) {
            return null;
        }
        ListNode rhead = new ListNode();
        rhead.next = head;
        ListNode fast = rhead;
        ListNode slow = rhead;
        //1.判断是否有环,无环怎么样，有环怎么样(单链表怎么办）
        while (true) {
            if (fast == null || fast.next == null) return null;
            //move
            fast = fast.next.next;
            slow = slow.next;
            // 如果相同，则有环，记录这个位置,就用slow节点吧
            if (fast == slow) {
                break;
            }
        }

        //2.再找环的入口
        // 经过一吨分析后，相遇节点位置，安排一个指针，链表开始安排一个指针。
        // 两个均一位位移动，相遇点就是链表环的入口节点
        ListNode temp = rhead;
        while (true) {
            temp = temp.next;
            slow = slow.next;
            if (temp == slow) {
                break;
            }
        }
        return temp;
    }

    public ListNode detectCycle2(ListNode head){
        //头节点
        ListNode rhead = new ListNode();
        rhead.next = head;
        //
        ListNode fast = rhead;
        ListNode slow = rhead;
        // 需要保证至少两个节点
        if (rhead.next==null||rhead.next.next==null) return null;
        //1.先找到有没有环
        while (true){
            if (fast==null||fast.next==null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) break;//有环了，环的交点就是当前位置，我们就是要slow记录
        }
        //2.找到入口
        ListNode temp = rhead;
        while (true){
            temp = temp.next;
            slow = slow.next;
            if (temp==slow){
                break;
            }
        }
        return temp;

    }
}
