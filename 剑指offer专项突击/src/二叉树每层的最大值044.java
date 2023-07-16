import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 二叉树每层的最大值044 {


    public List<Integer> getRes(TreeNode root) {
        // bfs
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        int maxLayer;
        queue.offer(root);

        while (!queue.isEmpty()) {
            maxLayer = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                maxLayer = Math.max(maxLayer, poll.val);
                list.add(poll);
            }
            ans.add(maxLayer);
            for (TreeNode node : list) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.clear();
        }
        return ans;
    }
}
