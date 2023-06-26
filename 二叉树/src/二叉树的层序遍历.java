import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。
 * （即逐层地，从左到右访问所有节点）。
 * 输入：root = []
 * 输出：[]
 */
public class 二叉树的层序遍历 {
}
class Solution11{
    public List<List<Integer>> levelOrder(TreeNode root){
        // 定义最后的结果对象
        List<List<Integer>> resList = new ArrayList<>();
        // 树根节点为Null
        if (root ==null){
            return resList;
        }
        // BFS——使用队列数据结构，
        Queue<TreeNode> queue = new LinkedList<>();
        // 先放入根节点
        queue.offer(root);
        // 每次在出队列后将其左、右节点放入, 然后循环，直到队列为空停
        // 因为是结果要分别记录出来第一层哪些值，二层哪些值，所以要一次性弹出队列元素，一次性入队下一层元素
        List<TreeNode> list1 = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            // 一次性弹出节点
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list1.add(node);
            }
            // 一次性录入下一层节点，并且记录该层的数据
            for (TreeNode node : list1) {
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                list.add(node.val);
            }
            list1.clear();
            resList.add(list);
        }
        return resList;
    }
}
class TreeNode {
    public int val;
    public TreeNode right;
    public TreeNode left;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode right,TreeNode left){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}