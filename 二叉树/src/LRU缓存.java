import java.util.HashMap;
import java.util.Map;

public class LRU缓存 {
    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        System.out.println(lRUCache.get(1));  // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
//        System.out.println(lRUCache.get(3));    // 返回 3
//        System.out.println(lRUCache.get(4));    // 返回 4

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(1, 1); // 缓存是 {1=1, 2=2}
        lRUCache.put(2, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(2));    // 返回 3
    }
}

/**
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */

//存键值对，使用哈希表——map，但map是无序的，需要想办法让其有序才行，肯定不可能让这个集合有序，只能想一些其他办法；
//linkedHashMap：hashMap+双向链表。它可以按两种顺序排列，一种是按照插入的顺序，一种是按照读取的顺序；
//逻辑：put、get调用的缓存就是最新的缓存，需要放到链表的头部；
// map集合，key——存入的key，value——链表节点（节点内存了真正的value）；之所以使用双向链表，因为它在已知了某个节点的地址后，可以O(1)操作完成移动
class doubleListNode {
    public int val;
    public int key;
    public doubleListNode pre;
    public doubleListNode next;

    public doubleListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    //1. 成员变量
    public int capacity; //缓存容量
    public int size; //目前存储的数据量
    private Map<Integer, doubleListNode> mapcache;
    private doubleListNode rhead;
    private doubleListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        mapcache = new HashMap<>();
        //我草，还有一个双向链表需要定义，但这个链表对外其实是不可见的，我们就直接在内部写就行了，头节点和尾节点
        rhead = new doubleListNode(-1, -1);
        tail = new doubleListNode(-1, -1);
        rhead.next = tail;
        tail.pre = rhead;
    }

    //双向链表的方法，抽出来的
    //1、传入要插入的节点，将其插入到头部第一个位置
    public void addToHead(doubleListNode node){
        doubleListNode temp = rhead.next;
        rhead.next = node;
        node.pre = rhead;
        node.next = temp;
        temp.pre = node;
    }
    //2、传入被删除的节点，将其删除，返回被删除的节点
    public void removeNode(doubleListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    //3、直接删除尾部的节点，返回被删除的节点;
    public doubleListNode removeToTail(){
        doubleListNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public int get(int key) {
        doubleListNode node = mapcache.get(key);
        if (node == null) return -1;
        //node存在，则需要移动它的位置到链表头部
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        //put操作：1、判断是否已有，有就覆盖节点里面的val，并且移动节点到头部
        //2、没有就新建节点，存入map，并且移动到头部
        //3、最后要判断是否超出容量了
        doubleListNode node = mapcache.get(key);
        if (node == null) {
            doubleListNode newNode = new doubleListNode(key, value);
            mapcache.put(key, newNode);
            //将newNode插到链表第一个位置
            addToHead(newNode);
            this.size++;
            //判断是否超出容量，超出则需要踢出最后一个节点，同时移除map的缓存
            if (size > capacity) {
                doubleListNode removenode = removeToTail();
                mapcache.remove(removenode.key);
                this.size--;
            }
        } else {
            node.val = value;
            //node存在，则需要移动它的位置到链表头部
            //1.将node移除出去
            removeNode(node);
            //2.将node插到链表第一个位置
            addToHead(node);
        }
    }

}



