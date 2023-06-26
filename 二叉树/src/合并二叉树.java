/**
 * https://leetcode.cn/problems/merge-two-binary-trees/
 */
public class 合并二叉树 {
}
class Solution {
    // 题目给了提示，递归函数返回值是node。
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null) return root2;
        if (root2==null) return root1;
        TreeNode mergeRoot = new TreeNode(root1.val + root2.val);
        TreeNode leftTree = mergeTrees(root1.left, root2.left);
        TreeNode rightTree = mergeTrees(root1.right, root2.right);
        mergeRoot.left = leftTree;
        mergeRoot.right = rightTree;
        return mergeRoot;
    }

}
