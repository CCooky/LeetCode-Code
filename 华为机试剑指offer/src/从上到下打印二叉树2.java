import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树2 {
    public static void main(String[] args) {

    }
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
class Solution39{
    public List<List<Integer>> getResult(TreeNode root){
        //1.
        List<List<Integer>> resList = new ArrayList<>();
        if (root==null) return resList;

        //2.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //3.
        List<TreeNode> nodeList = new ArrayList<>();
        while (!queue.isEmpty()){
            //按照层取出该层的所有节点
            while (!queue.isEmpty()){
                nodeList.add(queue.poll());
            }
            //将下一层节点全部放入queue，并且封装结果
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : nodeList) {
                list.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            nodeList.clear();
            resList.add(list);
        }
        return resList;

    }
}
