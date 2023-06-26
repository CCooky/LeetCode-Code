import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class 左叶子之和 {
}

class Solution10 {
    /**
     * 那我一个个遍历，看是不是左叶子撒
     */
    public int sumOfLeftLeaves(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        search(root,list);
        int sum=0;
        for (TreeNode node : list) {
            sum = sum+node.val;
        }
        return sum;

    }
    //1.参数一个节点，一个集合存放左叶子节点

    public void search(TreeNode node, List<TreeNode> list) {
        if (node == null) return;

        if (node.left!=null && node.left.left==null&& node.left.right==null){
            //左叶子节点
            list.add(node.left);
        }
        search(node.left,list);
        search(node.right,list);
    }

    /**
     * BFS试试
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left!=null && node.left.left==null && node.left.right==null){
                sum = sum + node.left.val;
            }
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
        }
        return sum;
    }

}
