

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表没有交点，返回 null 。题目数据 保证 整个链式结构中不存在环。
 */
public class 链表相交 {

}
class Solution4{
    // 这里只和节点的指向有关系，即判断A链表的下一个指向节点，是否和B链表的下一个指向节点一致
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        //1.链表为空时
        if (headA==null || headB==null) return null;
        // 定义两个头节点
        ListNode rheadA = new ListNode();
        ListNode rheadB = new ListNode();
        rheadA.next = headA;
        rheadB.next = headB;
        // 2. 头节点不动，定义两个辅助节点进行遍历,查询取第一个数据节点
        ListNode tempA = rheadA.next;
        ListNode tempB = rheadB.next;
        while (tempA!=tempB){
            if (tempA==null) {  //如果A到了最后，则切换到B链表
                tempA=rheadB.next;
            }else {
                tempA = tempA.next;
            }
            if (tempB==null) {
                tempB = rheadA.next;
            }else {
                tempB = tempB.next;
            }
            // 不会无限循环哦，因为不管怎样，A、B走过的长度都一样的
        }
        return tempA;
    }
}


