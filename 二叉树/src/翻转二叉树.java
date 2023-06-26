import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 就是将每个节点的左右子节点互换位置
 */
public class 翻转二叉树 {
}
class Solution1{
    /**
     *明显递归就行了，把每个节点的左右子节点进行交换
     */
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;

    }
    // 递归三部曲：
    //1.确定参数以及返回值,参数就是一个节点，不需要返回值, 我们传入根节点就行了，后面根据根节点拿数据
    //2.确定终止条件，传入的节点为null就不需要进行交换了撒，该节点的左右子节点为空为无所谓啊
    //3.确定单层的逻辑
    public void swap(TreeNode node){
        if (node ==null){
            return;
        }
        //交换两个子节点
        TreeNode temp = node.left;
        node.left = node.right;
        node.right  = temp;
        // 左子节点开始交换
        swap(node.left);
        // 右子节点开始教化吧
        swap(node.right);
    }

    /**
     * BFS--
     */
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root==null){
            return root;
        }
        //1.BFS-队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 开始层序遍历
        while (!queue.isEmpty()){
            // 按层取出数据
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
            }
            // 遍历取出的数据
            for (TreeNode treeNode : list) {
                // 交换(这里左右子节点为null不影响）
                TreeNode temp = treeNode.right;
                treeNode.right = treeNode.left;
                treeNode.left = temp;
                // 左、右子节点入队列
                if (treeNode.right!=null)queue.offer(treeNode.right);
                if (treeNode.left!=null)queue.offer(treeNode.left);
            }
        }
        return root;
    }

}
