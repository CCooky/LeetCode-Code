import java.util.ArrayList;
import java.util.List;

public class 二叉树的前序遍历 {
}
class Solution4 {
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return list;
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
