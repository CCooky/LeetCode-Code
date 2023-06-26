import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，
 * 返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 树中节点的数目范围是 [2, ]
 */
public class 二叉搜索树的最小绝对差 {
}

class Solution20 {
    //考虑对升序数组 aaa 求任意两个元素之差的绝对值的最小值，答案一定为相邻两个元素之差的最小值，
    // 中序遍历得到升序数组，然后一个for就行了
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int minSub = Math.abs(list.get(0)-list.get(1));
        for (int i = 1; i < list.size(); i++) { //保证有两个元素
            int Sub = Math.abs(list.get(i)-list.get(i-1));
            if (minSub>Sub) minSub = Sub;
        }
        return minSub;
    }

    //中序遍历
    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

}
