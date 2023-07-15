public class 最大的异或067_2 {
    /**
     * 和前一个思路一样，这里直接写成了一个数据结构，看起来感觉比较舒服
     */
    public int findMaximumXOR(int[] nums) {
        XORTrie xorTrie = new XORTrie();
        int ans = 0;
        for (int num : nums) {
            xorTrie.insert(num);
            ans = Math.max(xorTrie.getMaxXOR(num), ans);
        }
        return ans;
    }
}

class XORTrie{
    public static final int HIGH_BIT = 30;
    private XORTrie[] children; //[0]:标识0, [1]:标识1

    public XORTrie(){
        children = new XORTrie[2];
    }

    // 元素插入前缀树里面
    public void insert(int num){
        XORTrie node = this; // 根节点：我们在外部调用初始化的那个，内部是没有根节点的
        for (int i = HIGH_BIT; i >=0 ; i--) { // 从高到低哦
            int bit = (num >> i) & 1;
            if (bit == 0){
                if (node.children[0] == null){
                    node.children[0] = new XORTrie();
                }
                node = node.children[0];
            }else {
                if (node.children[1] == null){
                    node.children[1] = new XORTrie();
                }
                node = node.children[1];
            }
        }
    }

    // 求出当前数与前缀树中已有数字的最大异或（从高到低哦）
    public int getMaxXOR(int num){
        XORTrie node = this;
        int maxXOR = 0;
        for (int i = HIGH_BIT; i >=0 ; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0){
                if (node.children[1] != null){
                    maxXOR = maxXOR * 2 + 1;
                    node = node.children[1];
                }else {
                    maxXOR = maxXOR * 2;
                    node = node.children[0];
                }
            }else {
                if (node.children[0] != null){
                    maxXOR = maxXOR * 2 + 1;
                    node = node.children[0];
                }else {
                    maxXOR = maxXOR * 2;
                    node = node.children[1];
                }
            }
        }
        return maxXOR;
    }

}