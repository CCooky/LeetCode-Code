import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的根节点 root，请找出该二叉树的最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 */
public class 找树左下角的值 {
}
class Solution100{
    /**
     * 找到最下面一层不就行了吗，BFS行不行呢。最底层全部都是叶子节点，取第一个
     */
    public int findBottomLeftValue(TreeNode root){
        // 已知最少一个节点，这里不用判断root==null
        // 只有一个节点的时候，应该就是该节点的。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>(); //记得清空
        while (!queue.isEmpty()){
            // 这里要一层层取出
            while (!queue.isEmpty()){
                list.add(queue.poll());
            }
            //判断这一层是不是全是叶子节点,就按层序遍历的实现，假如这里过后，队列为空则说明上一层全部是叶子节点
            for (TreeNode node : list) {
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            // 队列为空则说明上一层全部是叶子节点
            if (queue.isEmpty()){
                return list.get(0).val; //最底最左的节点
            }
            list.clear();
        }
        return 11111; //这里不可能执行到
    }
}
