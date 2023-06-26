/**
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 */
public class 删除二叉搜索树中的节点 {

}

class Solution24 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        // 根节点没有父节点啊，这个好麻烦，如果删除根节点的话，就不好做，那我们给他加一个根节点算了
        TreeNode rootParent = new TreeNode(0);
        rootParent.right = root;
        deleteNodeNeedParent(rootParent.right, rootParent, key);
        return rootParent.right;
    }


    public void deleteNodeNeedParent(TreeNode node, TreeNode parent, int val) {
        if (node == null) return;
        // get node
        if (node.val == val) {
            if (node.left == null && node.right == null) {
                if (parent.left == node) parent.left = null;
                if (parent.right == node) parent.right = null;
//                node = null; //这个是什么意思，将对象销毁？？java不能自己销毁对象啊
            } else if (node.left == null && node.right != null) {
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
            } else if (node.left != null && node.right == null) {
                if (parent.left == node) parent.left = node.left;
                if (parent.right == node) parent.right = node.left;
            } else if (node.left != null && node.right != null) {
                TreeNode temp = node.right;
                while (true) {
                    if (temp.left != null) temp = temp.left;
                    else break;
                }
                temp.left = node.left;
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
            }
            return;
        }
        // go down
        if (node.val < val) {
            deleteNodeNeedParent(node.right, node, val);
        } else {
            deleteNodeNeedParent(node.left, node, val);
        }
    }

    public TreeNode deleteNode2(TreeNode node, int key) {
        // 返回值意义是挂载的意思
        if (node == null) return null;
        // 找到该节点
        if (node.val == key) {
            if (node.left == null && node.right != null) {
                return node.right;
            } else if (node.left != null && node.right == null) {
                return node.left;
            } else if (node.left == null && node.right == null) {
                return null;
            }else {
                TreeNode temp = node.right;
                while (temp.left!=null){
                    temp = temp.left;
                }
                temp.left = node.left;
                return node.right;
            }
        }
        // 后序挂载上去，二叉搜索树哦，接着从左子树找或者右子树
        if (key>node.val){
            TreeNode right = deleteNode2(node.right, key); //得到找到后整理好的右子树
            node.right = right;
        }else {
            TreeNode left = deleteNode2(node.left, key); //得到找到后整理好的右子树
            node.left = left;
        }
        return node;
    }
}
