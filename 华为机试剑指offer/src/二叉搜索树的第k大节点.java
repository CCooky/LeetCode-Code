import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的第k大节点 {
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
class Solution64 {
    public int kthLargest(TreeNode root, int k) {
        //中序遍历，递增序列
        inOrder(root);
        return list.get(list.size()-k);

    }
    List<Integer> list = new ArrayList<>();
    public void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
