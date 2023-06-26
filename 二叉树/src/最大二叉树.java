import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-binary-tree/
 * nums 中的所有整数 互不相同
 */
public class 最大二叉树 {
}
class Solution16 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //1.简单判断数组为空
        if (nums.length==0) return null;
        //2.找到根节点，求出传入数组最大值所在索引就是
        int index = getMaxIndexOfArr(nums);
        TreeNode root = new TreeNode(nums[index]);//根节点
        //3.切分左子树数组、右子树数组
        int[] leftNums = Arrays.copyOfRange(nums, 0, index);
        int[] rightNums = Arrays.copyOfRange(nums, index + 1, nums.length);
        //4.递归左子树数组、右子树数组
        TreeNode leftTree = constructMaximumBinaryTree(leftNums);
        TreeNode rightTree = constructMaximumBinaryTree(rightNums);
        //5.将左右子树挂到根节点下面
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    public int getMaxIndexOfArr(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>nums[index]){
                index = i;
            }
        }
        return index;
    }
}