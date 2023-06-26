/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 这道题啊！！！！
 * 先掌握双指针写法，然后一定掌握递归写法，很有可能面试官要你写递归写法
 */
public class 单链表翻转 {
}

class Solution1 {
    /**
     * 双指针写法
     */
    public ListNode reverseList(ListNode head) {
        //1.链表为空
        if (head == null) {
            return null;
        }
        //2.链表只有一个节点
        if (head.next == null) {
            return head;
        }
        //3. 这里其实不需要头节点，少见的不需要头节点情况，
        // 因为我们翻转完之后，原第一个数据节点应该指向null。所以我们应该pre指针=null才对
        // 然后cur指针指向第一个数据节点
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            // 更新prev、cur位置
            pre = cur;
            cur = temp;
        }
        return pre;
    }



    /**
     * 递归写法
     * 和双指针的解法类似，就是用函数递归替代了之前的while循环的感觉！！！！
     */
    public ListNode reverseList2(ListNode head) {
        //1.链表为空
        if (head == null) {
            return null;
        }
        //2.链表只有一个节点
        if (head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        return reverse(pre, cur);
    }

    // 和双指针的解法类似，就是用函数递归替代了之前的while循环的感觉！！！！
    public ListNode reverse(ListNode pre, ListNode cur) {
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        if (cur == null) {
            return pre;
        }
        return reverse(pre, cur);
    }
}
