public class 二叉搜索树中的插入操作 {
}

class Solution23 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);
        if (root == null) {
            return insertNode;
        }
        insert(root, insertNode);
        return root;
    }

    //1.
    public void insert(TreeNode node, TreeNode insertNode) {
        if (node == null) return;
        // zuo
        if (node.val > insertNode.val && node.left == null) {
            node.left = insertNode;
        } else if (node.val > insertNode.val) {
            insert(node.left, insertNode);
        }
        //you
        if (node.val < insertNode.val && node.right == null) {
            node.right = insertNode;
        } else if (node.val < insertNode.val) {
            insert(node.right, insertNode);
        }
    }
}
