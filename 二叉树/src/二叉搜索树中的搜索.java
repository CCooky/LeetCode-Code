/**
 *给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */
public class 二叉搜索树中的搜索 {
}
class Solution17 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }else if (val>root.val){
            return searchBST(root.right,val);
        }else {
            return searchBST(root.left,val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root==null) return null;
        while (root!=null){
            if (root.val==val) return root;
            else {
                if (root.val<val) root = root.right;
                if (root.val>val) root = root.left;
            }
        }
        return null;
    }
}
