import java.util.HashMap;


public class LRU {
    public static void main(String[] args) {
        LRU lRUCache = new LRU(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));  // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }

    private BiListNode head; //虚拟头节点
    private BiListNode tail; //虚拟尾节点
    private HashMap<Integer, BiListNode> hashMap; //存储key-value
    private int capacity;
    private int count;

    public LRU(int capacity) {
        hashMap = new HashMap<>();
        head = new BiListNode();
        tail = new BiListNode();
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        //1、如果是插入的新key，则直接插入链表头节点
        if (!hashMap.containsKey(key)) {
            BiListNode newNode = new BiListNode(key, value);
            insertHead(newNode);
            hashMap.put(key, newNode);
            count++;
        } else {
            //2、如果已存在，则删除该key在链表位置，更新value重新插入头节点
            BiListNode node = hashMap.get(key);
            node.val = value;
            deleteNode(node);
            insertHead(node);
        }
        //3、插入完成后判断链表是否超出容量
        if (count > capacity) {
            hashMap.remove(tail.pre.key);
            deleteNode(tail.pre);
            count--;
        }
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            BiListNode node = hashMap.get(key);
            deleteNode(node);
            insertHead(node);
            return hashMap.get(key).val;
        }
        return -1;
    }

    private void insertHead(BiListNode node) {
        BiListNode temp = head.next;
        head.next = node;
        node.pre = head;
        node.next = temp;
        temp.pre = node;
    }

    private void deleteNode(BiListNode node) {
        BiListNode pre = node.pre;
        BiListNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

}

// 双向链表节点
class BiListNode {
    public int key;
    public int val;
    public BiListNode pre;
    public BiListNode next;

    public BiListNode() {
    }

    public BiListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
