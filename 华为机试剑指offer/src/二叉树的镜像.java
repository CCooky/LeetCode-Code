public class 二叉树的镜像 {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution12 {
    // 将每个节点左子树和右子树交换位置即可；递归挂载 / 前序遍历都可以
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        TreeNode leftTree = mirrorTree(root.left);
        TreeNode rightTree = mirrorTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        preOrder(root);
        return root;
    }
    //前序遍历
    public void preOrder(TreeNode node){
        if (node==null)return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        preOrder(node.left);
        preOrder(node.right);
    }
}
