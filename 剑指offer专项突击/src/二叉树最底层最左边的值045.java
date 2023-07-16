import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 二叉树最底层最左边的值045 {

    public int getRes(TreeNode root){
        // bfs
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        queue.offer(root);
        TreeNode ans;
        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                list.add(poll);
            }
            ans = list.get(0); // 记录该层的左端节点
            for (TreeNode node : list) {
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.clear();
            // 判断是否到了最后一层，此时队列为空了
            if (queue.isEmpty()){
                return ans.val;
            }
        }
        return -1;
    }

}
class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int val;
}