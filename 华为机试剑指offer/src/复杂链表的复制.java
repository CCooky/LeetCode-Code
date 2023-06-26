import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {
    public static void main(String[] args) {

    }
}

class Solution28 {
    public Node copyRandomList(Node head) {
        //map集合存储old节点和它复制的新节点
        Map<Node,Node> map = new HashMap<>();
        //原链表直接遍历，不需要虚拟头节点了；
        //新链表需要虚拟头节点
        Node newhead = new Node(-1); //虚拟
        Node oldtemp = head;
        Node newtemp = newhead;
        while (oldtemp!=null){
            //先处理后move
            Node node = new Node(oldtemp.val);
            newtemp.next = node;
            map.put(oldtemp,node); //老节点：对应复制出来的新节点
            //move
            newtemp = newtemp.next;
            oldtemp = oldtemp.next;
        }
        // 第二次遍历完成新节点的random复制
        oldtemp = head;
        newtemp = newhead.next; //这里也可以从虚拟头节点开始，无所谓
        while (oldtemp!=null){
            //先处理后move
            Node random = oldtemp.random;
            newtemp.random = map.get(random);
            //
            oldtemp = oldtemp.next;
            newtemp = newtemp.next;
        }
        return newhead.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}