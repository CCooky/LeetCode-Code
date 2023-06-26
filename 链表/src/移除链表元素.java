
/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 例如：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 */



public class 移除链表元素 {

}
class Solution{
    public ListNode remove(ListNode head, int val){
        // 创建真正的头节点
        ListNode rhead = new ListNode();
        rhead.next = head;
        // 1. 判断链表空
        if (rhead.next == null){
            return null;
        }

        //2. 头节点不能动，新建辅助节点(第一个数据节点）
        ListNode temp = rhead;
        while (temp.next != null){  //next为null，则该节点为尾节点
            if (temp.next.val == val){  // 等于val，则删除next节点，接着判断新接上的节点
                temp.next = temp.next.next;
            }else {  //直到不等于val的节点，才移动temp指针。
                temp = temp.next;
            }
        }
        return rhead.next;
    }
}

class ListNode {
    public int val;  //private也可以，但写算法就算了，麻烦
    public ListNode next;
    // public ListNode pre;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}