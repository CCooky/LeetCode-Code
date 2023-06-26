public class 对称的二叉树 {
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
class Solution15 {
    // 后序遍历；需要拿到左右孩子的信息，才可以判断；
    // 不用管根节点，我们直接拿左子树、右子树两棵树去匹配判断即可
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isOK(root.left,root.right);
    }

    //函数返回值意义：这两颗树是否对称
    public boolean isOK(TreeNode leftTree, TreeNode rightTree){
        if (leftTree==null && rightTree==null) return true;
        if (leftTree!=null && rightTree==null) return false;
        if (leftTree==null && rightTree!=null) return false;
        // 剪枝
        if (leftTree.val != rightTree.val) return false;
        boolean outSide = isOK(leftTree.left, rightTree.right); //根据比较规则
        boolean inSide = isOK(leftTree.right, rightTree.left);
        return outSide&&inSide;
    }

    //入口：采用前序遍历
    public boolean getRes(TreeNode root){
        preOrder(root.left,root.right);
        return isOK;
    }

    // 前序我看看
    boolean isOK = true;
    public void preOrder(TreeNode leftTree, TreeNode rightTree){
        if (leftTree==null && rightTree ==null){ //同时为null
            return;
        }
        if (leftTree==null || rightTree ==null){ //只有一个为null
            isOK = false; return;
        }
        if (leftTree.val != rightTree.val) {
            isOK = false; return;
        }
        //
        preOrder(leftTree.left, rightTree.right);
        preOrder(leftTree.right, rightTree.left);
    }



}
