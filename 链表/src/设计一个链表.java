import java.util.Stack;

/**
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。第一个节点对应 index=0；
 * <p>
 * 在链表类中实现这些功能：
 * 这个index指的是索引下标（0，1，2，....）
 * get(index)：获取链表中下标index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index个节点。
 * getHead(): 获得链表的头节点（这种都是指的数据节点）
 */

public class 设计一个链表 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtTail(0);
        linkedList.deleteAtIndex(1);
        linkedList.addAtTail(5);
        linkedList.print();
        linkedList.addAtIndex(1, 1);
    }
}

/**
 * 用双链表实现：真的超级容易出错，改了好久！！！主要是这个tail很烦！！！！
 */
class MyLinkedList {

    public Node head;  // 头节点（不存数据）
    public Node tail;  // 最后一个数据节点
    public int size;  // 数据节点个数

    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        size = 0;
    }

    //获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        // 这个索引标识看得到我头疼！！！统一把索引变成第几个节点表示
        int realIndex = index + 1;
        Node temp = head;
        if (realIndex >= 1 && realIndex <= size) {
            for (int i = 0; i < realIndex; i++) {
                temp = temp.next;
            }
            return temp.val;

        } else return -1;
    }

    //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        Node temp = head;
        Node newNode = new Node(val);
        //如果链表为空，则该节点成为第一个节点
        if (temp.next == null) {
            temp.next = newNode;
            newNode.pre = temp;
            tail = newNode;
            size++;
        } else { //链表有至少一个数据节点
            temp.next.pre = newNode;
            newNode.next = temp.next;
            newNode.pre = temp;
            temp.next = newNode;
            size++;
        }
    }

    // 将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node temp = head;
        //1.链表为空时
        if (head.next == null) {
            temp.next = newNode;
            newNode.pre = temp;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.pre = tail;
            // tail 需要后移，指向最后那个
            tail = newNode;
            size++;
        }
    }

    // 在链表中的第 index 个节点之前添加值为 val的节点。
// 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
// 如果 index 大于链表长度，则不会插入节点。
// 如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        int realIndex = index + 1;
        //1.如果 index 等于链表的长度，则该节点将附加到链表的末尾。
        if (realIndex == (size + 1)) {
            addAtTail(val);
        }
        //2.如果 index 大于链表长度，则不会插入节点。
        else if (realIndex > (size + 1)) {
            return;
        }
        //3.如果index小于0，则在头部插入节点。
        else if (realIndex <= 0) {
            addAtHead(val);
        }
        //4.在链表中的第 index 个节点之前添加值为 val的节点。realIndex>=1 && realIndex<=size
        else {
            Node temp = head;
            for (int i = 0; i < (realIndex); i++) {  //找到该节点
                temp = temp.next;
            }
            //在前面添加一个节点
            Node newNode = new Node(val);
            temp.pre.next = newNode;
            newNode.pre = temp.pre;
            newNode.next = temp;
            temp.pre = newNode;
            size++;
        }
    }

    // 5.如果索引 index 有效，则删除链表中的第 index个节点。
    public void deleteAtIndex(int index) {
        int realIndex = index + 1;
        if (realIndex >= 1 && realIndex <= size) {
            Node temp = head;
            for (int i = 0; i < (realIndex); i++) {
                temp = temp.next;
            }
            /**
             * 假如index是尾节点那个呢，需要加判断哦
             * 如果是尾节点,tail要移动！！！！！
             */
            if (temp.next == null) { //如果是尾节点,tail要移动哦！
                tail = temp.pre;
                temp.pre.next = null;
                temp.pre = null;
            } else {  //如果不是尾节点
                temp.pre.next = temp.next;
                temp.next.pre = temp.pre;
            }
            size--;
        }
    }

    public Node getHead() {
        if (head.next == null) {
            System.out.println("链表为空！！！");
            return null;
        } else {
            return head.next;
        }
    }

    public void print() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.print(temp);
        }
        System.out.println();
    }
}

/**
 * 用单链表实现
 */
class MyLinkedList2 {
    public Node head;
    public int size;

    public MyLinkedList2() {
        head = new Node();
        size = 0;
    }

    //1、获取链表中下标index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        int realIndex = index + 1;
        if (realIndex >= 1 && realIndex <= size) {
            Node temp = head;
            for (int i = 0; i < realIndex; i++) {
                temp = temp.next;
            }
            return temp.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node temp = head;
        Node node = new Node(val);
        //1.判断链表为空
        if (head.next == null) {
            temp.next = node;
        } else {
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        size++;
    }

    // 在链表中的第 index 个节点之前添加值为 val的节点。
// 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
// 如果 index 大于链表长度，则不会插入节点。
// 如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        int realIndex = index + 1;
        if (realIndex == (size + 1)) {
            addAtTail(val);
        } else if (realIndex > (size + 1)) {
            return;
        } else if (realIndex <= 0) {
            addAtHead(val);
        } else {  // realIndex:[1,size]
            Node temp = head;
            Node node = new Node(val);
            for (int i = 0; i < (realIndex-1); i++) { // 找到该节点前一个元素
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        //链表为空
        int realIndex = index+1;
        Node temp = head;
        if (realIndex>=1 && realIndex<=size){
            for (int i=0; i<(realIndex-1);i++){  // 找到前一个
                temp = temp.next;
            }
            // 如果被删除的是尾节点
            if (temp.next.next==null){
                temp.next = null;
            }else {
                // 被删除的不是尾节点
                temp.next = temp.next.next;
            }
            size--;
        }
    }
}

class Node {
    public int val;
    public Node next;
    public Node pre;

    public Node(int val) {
        this.val = val;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
