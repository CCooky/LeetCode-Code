public class 最大的异或067 {

    /**
     * 前缀树，每个多叉树节点只有两个，一个标识比特位为0，一个标识为1，树的深度固定就是31位
     */
    private final Trie2 root = new Trie2(); // 前缀树的根节点
    private static final int HIGH_BIT = 30; // 一共考虑31位，所以我们右移最大30即可

    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        int x = 0;
        for (int i = 1; i < n; i++) {
            add(nums[i - 1]); // 将元素依次放入前缀树
            x = Math.max(x, check(nums[i])); // 找出最大的异或值
        }
        return x;
    }

    // 将当前元素放入前缀树里
    private void add(int num) {
        Trie2 cur = root;
        for (int k = HIGH_BIT; k >= 0; k--) { // 从高位开始计算哦
            int bit = (num >> k) & 1; // 当前比特位是0还是1
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new Trie2();
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Trie2();
                }
                cur = cur.right;
            }
        }
    }

    // 求出当前元素和前缀树已有元素的最大异或值
    private int check(int num) {
        Trie2 cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; k--) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.right != null) { // 第k个二进制位为 0，应当往表示1的子节点right走
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                }else {
                    cur = cur.right;
                    x = x*2;
                }
            }
        }
        return x;
    }
}

class Trie2 {

    public Trie2 left; // 左子树执行表示0的子节点
    public Trie2 right; // 右子树指向表示1的子节点
}
