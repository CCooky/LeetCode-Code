import com.sun.org.apache.xerces.internal.impl.xs.identity.UniqueOrKey;

import java.util.*;

public class 从上到下打印二叉树3 {
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
class Solution41 {
    public List<List<Integer>> getResult(TreeNode root) {
        //很简单，弄一个计数器，记录操作的是第几层即可。偶数层就逆序一下list
        List<List<Integer>> resList = new ArrayList<>();
        if (root==null) return resList;
        //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //
        List<TreeNode> nodeList = new ArrayList<>();
        int k = 1; //记录处理的是第几层
        while (!queue.isEmpty()){
            while (!queue.isEmpty()){
                nodeList.add(queue.poll());
            }
            List<Integer> dataList = new ArrayList<>();  //存放每一层遍历的存储节点值
            for (TreeNode node : nodeList) {
                //先放入下一层节点
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);
                //处理该层结果
                dataList.add(node.val);
            }
            nodeList.clear(); //注意这里罗
            //放入结果集，判断是否逆序,偶数逆序
            if (k%2==0){
                Collections.reverse(dataList);
                resList.add(dataList);
            }else {
                resList.add(dataList);
            }
            k++;
        }
        return resList;
    }
}
