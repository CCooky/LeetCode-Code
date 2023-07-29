import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;

public class 链表排序077 {

    public ListNode getRes(ListNode head) {

        // 直接冒泡排序吧，或者堆排序，我使用堆排序
        Queue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> Float.compare(o1.val, o2.val)));
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }
        ListNode rhead = new ListNode(-1);
        ListNode temp = rhead;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
        }
        //注意最后一个节点的next应该指向null
        temp.next = null;
        return rhead.next;
    }
}
