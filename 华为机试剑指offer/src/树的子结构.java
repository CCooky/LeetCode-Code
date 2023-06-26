public class 树的子结构 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution11 {
    /*
    死死记住isSubStructure()的定义:判断B是否为A的子结构
    */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 若A与B其中一个为空,立即返回false
        if (A == null || B == null) {
            return false;
        }
        // B为A的子结构有3种情况,满足任意一种即可:
        // 1.B的子结构起点为A的根节点,此时结果为recur(A,B)
        // 2.B的子结构起点隐藏在A的左子树中,而不是直接为A的根节点,此时结果为isSubStructure(A.left, B)
        // 3.B的子结构起点隐藏在A的右子树中,此时结果为isSubStructure(A.right, B)
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /*
    判断B是否为A的子结构,其中B子结构的起点为A的根节点
    */
    private boolean recur(TreeNode A, TreeNode B) {
        // 若B走完了,说明查找完毕,B为A的子结构。为什么呢，因为B第一次传入进来肯定不为null的，我们在上面那个函数已经判断了
        if (A == null && B == null) return true;
        if (A != null && B == null) return true;
        // 若B不为空并且A为空，可以判断B不是A的子结构
        if (A == null && B != null) return false;
//        if (A.val != B.val) return false; //这里是提前判断——属于剪枝，但也可以放在中的处理逻辑上，按照后序的逻辑就应该在中

        // 当A与B当前节点值相等,若要判断B为A的子结构
        // 还需要判断B的左子树是否为A左子树的子结构 && B的右子树是否为A右子树的子结构
        // 若两者都满足就说明B是A的子结构,并且该子结构以A根节点为起点
        return recur(A.left, B.left) && recur(A.right, B.right) &&(A.val == B.val);
    }
}
