import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution45 {
    // 二叉树的路径问题，直接暴力前序遍历即可,注意中间有回溯
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        getAllPaths(root);
        //遍历一次所有路径
        List<List<Integer>> resList = new ArrayList<>();
        int sum = 0;
        List<Integer> dataList = new ArrayList<>();
        for (List<TreeNode> path : pathList) {
            // 遍历一条路径情况
            sum = 0;
            dataList.clear();
            for (TreeNode node : path) {
                sum +=node.val;
                dataList.add(node.val);
            }
            if (sum == targetSum) {
                resList.add(new ArrayList<>(dataList));
            }
        }
        return resList;
    }

    // 直接递归前序+回溯
    List<List<TreeNode>> pathList = new ArrayList<>();
    List<TreeNode> path = new ArrayList<>();
    public void getAllPaths(TreeNode node) {
        path.add(node); //这个写在第一行
        //2.stop
        if (node == null) {
            return;
        }
        // 收集到一条完整路径
        if (node.left == null && node.right == null) {
            pathList.add(new ArrayList<>(path));
        }
        //3.单层递归逻辑;根左右
        getAllPaths(node.left);
        path.remove(path.size() - 1); //每次递归完一次后需要回溯一下
        getAllPaths(node.right);
        path.remove(path.size() - 1);
    }
}






















