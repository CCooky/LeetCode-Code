import java.util.HashMap;
import java.util.Map;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 */
public class 打家劫舍3 {
}

class Solution27{

    public int rob(TreeNode root) {
        int[] dp = robTreeDP(root);
        return Math.max(dp[0],dp[1]);
    }
    //1、确定递推公式参数、返回值。一定是什么啊，后序遍历前面讲过了为什么
    // 参数就是一个节点，返回值是一个长度为2的数组dp，dp[0]表示偷该节点的最大金额，dp[1]表示不偷该节点的最大金额，
    public int[] robTreeDP(TreeNode node){
        //2.确定终止条件
        if (node==null) return new int[]{0,0};
        //3.单层递归逻辑; 必须是后序，因为.....
        int[] leftdp = robTreeDP(node.left);
        int[] rightdp = robTreeDP(node.right);
        //先得到偷该节点下得到的最大金额
        int[] dp = new int[2];
        dp[0] = node.val + leftdp[1] + rightdp[1];
        //然后得到不偷该节点下得到的最大金额，左右孩子可偷可不偷哦
//        dp[1] = Math.max(leftdp[0],leftdp[1]) + Math.max(rightdp[0],rightdp[1]);
        return dp;
    }
}

class Solution26 {

    /**
     * 可以使用二叉树的递归写，就是分两种情况，一种是当前节点被偷的值，一种是当前节点不被偷的值
     * 需要使用后序遍历，返回的是当前节点为根节点的数被偷的最大金额；前序遍历呢？我试试
     * 【为什么只能后序】所以为什么说一定要后序遍历，懂了吧，因为我当前节点要拿到两个值去比较，
     * 一个是当前节点被偷后得到的最大金额，一个是我孩子被偷后拿到的最大金额，需要子孩子的信息，才可以去正确判断
     */
    public int rob(TreeNode root) {
        return robPost(root);
    }

    //1.后序。返回值意义：当前节点为根节点是可以偷盗的最大金额
    Map<TreeNode, Integer> moneyMap = new HashMap<>();
    public int robPost(TreeNode node) {
        //2.终止条件
        if (node == null) return 0;
        // ****查询缓存****
        if (moneyMap.containsKey(node)){
            return moneyMap.get(node);
        }
        //当前节点被偷
        int money1 = node.val;
        if (node.left != null) {
            money1 = money1 + robPost(node.left.left) + robPost(node.left.right);
        }
        if (node.right != null) {
            money1 = money1 + robPost(node.right.right) + robPost(node.right.left);
        }
        // 当前节点不被偷
        int money2 = robPost(node.left) + robPost(node.right);
        int maxMoney = Math.max(money1, money2);
        //****存入缓存****
        moneyMap.put(node,maxMoney);
        return maxMoney;

    }
    // 前序遍历
    int MaxMoney1 = 0;
    int MaxMoney2 = 0;
    int MaxMoney3 = 0;

    public void preOrderRob(TreeNode node) {
        //2.终止条件
        if (node == null) return;
        //3.
        // 偷当前节点
        MaxMoney1 += node.val;
        if (node.left != null) {
            MaxMoney2 = MaxMoney2 + node.left.val;
            preOrderRob(node.left.left);
            preOrderRob(node.left.right);
        }
        if (node.right != null) {
            MaxMoney3 = MaxMoney3 + node.right.val;
            preOrderRob(node.right.right);
            preOrderRob(node.right.left);
        }
        // 不偷当前节点，好像写不了啊，要再起一个方法,
        // 不行只能后序
    }

}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
