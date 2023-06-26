import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root和一个表示目标和的整数 targetSum。判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum。如果存在，返回 true ；否则，返回 false 。
 */
public class 路径总和 {

}

class Solution13 {
    /**
     * 先求出所有路径的集合啊啊，然后做，我就猜到了会考这个，因为前面那道题巧用了String的不可变特性
     *
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        getAllPaths(root,path,pathList);
        for (List<Integer> list : pathList) { //有点麻烦，还有两个for，我直接计算计算出来算了，在pathList.add(path1)这里，把path1循环一遍，然后List<List<Integer>> pathList类型变成List<Integer>类型
            int sum = 0;
            for (Integer integer : list) {
                sum = sum+integer;
            }
            if (sum == targetSum){
                return true;
            }
        }
        return false;
    }

    // 求所有路径撒，前序遍历就行了。
    //1.三个参数了，无返回值，结果封装在引用数据list集合了。
    public void getAllPaths(TreeNode node, List<Integer> path, List<List<Integer>> pathList) {
        //2.遇到空节点返回。然后还有遇到了叶子节点也要返回，并且把路径集合给到list里面
        if (node == null) return;
        List<Integer> path1 = new ArrayList<>(path);
        path1.add(node.val);
        if (node.left == null && node.right == null) {
            pathList.add(path1);
            return;
        }
        getAllPaths(node.left, path1, pathList);
        getAllPaths(node.right, path1, pathList);
    }
}
