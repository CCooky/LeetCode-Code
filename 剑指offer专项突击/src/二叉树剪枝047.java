public class 二叉树剪枝047 {

    public TreeNode pruneTree(TreeNode root) {
        // 直接dfs，且带返回值的
        // dfs写完了，那每个节点都需要判断一次啊，然后进行删除,现在是要前序遍历，再来一个dfs
        // 删除需要知道该节点的上一个节点
        TreeNode rRoot = new TreeNode();
        rRoot.left = root;
        preOrder(rRoot.left, rRoot);
        return rRoot.left;
    }

    public void preOrder(TreeNode root, TreeNode pre) {
        if (root == null) return;
        if (dfs(root)) {
            if (pre.left == root) { //比较引用地址
                pre.left = null;
            } else {
                pre.right = null;
            }
            return; // 当前节点都没了，不用往下判断子节点了
        }
        preOrder(root.left, root);
        preOrder(root.right, root);
    }

    // 以当前节点为根节点的树，是否全为0
    public boolean dfs(TreeNode node) {
        if (node == null) return true;
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        if (node.val == 0 && left && right) {
            return true;
        }
        return false;
    }
}
