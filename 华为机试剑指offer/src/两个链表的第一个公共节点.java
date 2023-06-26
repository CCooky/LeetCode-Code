public class 两个链表的第一个公共节点 {

}
class Solution57{
    public ListNode getRes(ListNode headA, ListNode headB){
        //判断两个链表为空情况
        if (headA==null || headB==null) return null;
        //两个节点一起跑，先跑自己的部分，再跑别人的部分，终止条件是两个指针相等 A==B
        //直接遍历即可，其实不需要虚拟头节点，处理temp即可，temp！=null
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (true){
            if (tempA == tempB){
                //找到了，要么为一个节点要么为null
                return tempA;
            }
            if (tempA == null){
                tempA = headB;
            }else {
                tempA = tempA.next;
            }
            if (tempB==null){
                tempB = headA;
            }else {
                tempB = tempB.next;
            }
        }
    }
}
