public class 平衡二叉树 {
    public static void main(String[] args) {

    }
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
class Solution72 {
    public boolean isBalanced(TreeNode root) {
        //判断平衡二叉树——借助求二叉树的深度来求解
        int depth = getDepth(root);
        return depth!=-1;
    }

    //借助二叉树的深度，如果左子树右子树深度相差大于1，把该节点的深度赋值为-1；最后传入根节点判断深度是否为-1即可
    public int getDepth(TreeNode node){
        if (node == null) return 0;
        // 后序
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth==-1 || rightDepth == -1) return -1;
        if (Math.abs(leftDepth-rightDepth)>1) return -1;
        int nodeDepth = Math.max(leftDepth,rightDepth) + 1;
        return nodeDepth;
    }
}
