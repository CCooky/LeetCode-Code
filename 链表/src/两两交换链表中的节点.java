/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class 两两交换链表中的节点 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = new int[]{1,2,3,4,5};
        ListNode rhead = new ListNode(100);
        ListNode temp = rhead;
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            temp.next = node;
            temp = temp.next;
        }
        temp = rhead;
        while (temp.next!=null){
            temp = temp.next;
            System.out.println(temp.val);
        }
        //
        ListNode node = solution2.swapPairs(rhead.next);
        while (node.next!=null){
            System.out.print(node.val+"->");
            node = node.next;
        }

    }

}
//class Solution2{
//    public ListNode swapPairs(ListNode head){
//        //头节点
//        ListNode rhead = new ListNode();
//        rhead.next = head;
//        //1.链表为空，和链表只有一个节点
//        if (rhead.next==null) return null;
//        if (rhead.next.next==null) return head;
//        //2.链表有两个节点以上
//        // 定义两个节点，一个是指向被交换的两个位置对的前一个，一个是这对的第一个位置
//        ListNode first = rhead;
//        ListNode second = rhead.next;
//        while (true){
//            //开始三步走交换指向
//            first.next = second.next;
//            second.next = second.next.next;
//            first.next.next = second;
//            // 移动两个指针(第一个两下，第二个一下）
//            first = first.next.next;
//            second = second.next;
//            // 判断是否继续交换（看后面是否还有两个节点）
//            if (second==null || second.next==null){
//                break;
//            }
//        }
//        return rhead.next;
//    }
//}

class Solution2{
    public ListNode swapPairs(ListNode head){
        //头节点
        ListNode rhead = new ListNode();
        rhead.next = head;
        //1.链表为空，和链表只有一个节点
        if (rhead.next==null) return null;
        if (rhead.next.next==null) return head;
        if (rhead.next.next.next==null) return head;
        //2.链表有两个节点以上
        // 定义两个节点，一个是指向被交换的两个位置对的前一个，一个是这对的第一个位置
        ListNode first = rhead;
        ListNode second = rhead.next;
        while (true){
            //开始三步走交换指向
            first.next = second.next.next;
            second.next.next = second.next.next.next.next;
            first.next.next = second;
            // 移动两个指针(第一个两下，第二个一下）
            first = first.next.next.next.next;
            second = second.next.next;
            // 判断是否继续交换（看后面是否还有两个节点）
            if (second==null || second.next==null){
                break;
            }
        }
        return rhead.next;
    }
}
