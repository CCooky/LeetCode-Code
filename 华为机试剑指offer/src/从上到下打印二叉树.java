import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树 {
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
class Solution38{
    // 层序遍历啊
    public int[] getResult(TreeNode root){
        if (root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> list = new ArrayList<>();
        List<Integer> dataLIst = new ArrayList<>();
        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                list.add(queue.poll());
            }
            for (TreeNode node : list) {
                dataLIst.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
            }
            list.clear();
        }
        int[] res = new int[dataLIst.size()];
        for (int i = 0; i < dataLIst.size(); i++) {
            res[i] = dataLIst.get(i);
        }
        return res;

    }

}
