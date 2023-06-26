import java.util.Arrays;

/**
 *
 */
public class 将有序数组转换为二叉搜索树 {
}

class Solution26 {
    /**
     * 和二叉树构建的逻辑一样的，背下来，使用挂载的方式。
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        //1.简单判断数组为空，则返回的被挂载的是空节点
        //2.找到根节点
        //3.切分左子树数组、右子树数组
        //4.递归左子树数字组，右子树数组
        //5.将返回得到的左子树、右子树挂载根节点上，最后返回
        if (nums.length == 0) return null;
        //2.
        int minIndex = (0 + nums.length - 1) / 2; //偶数个的数组取前面那个值
        TreeNode root = new TreeNode(nums[minIndex]);
        //3.
        int[] leftNums = Arrays.copyOfRange(nums, 0, minIndex);
        int[] rightNums = Arrays.copyOfRange(nums, minIndex + 1, nums.length);
        //4.
        TreeNode leftTree = sortedArrayToBST(leftNums);
        TreeNode rightTree = sortedArrayToBST(rightNums);
        //
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }

    /**
     * 切分采用索引的方式，需要多写一个方法
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        TreeNode rootNode = constructTree(nums, 0, nums.length-1);
        return rootNode;
    }

    public TreeNode constructTree(int[] nums, int left, int right) {
        //1.
        if (left>right) return null;
        //2.
        int minIndex = (left + right) / 2; //偶数个的数组取前面那个值
        TreeNode root = new TreeNode(nums[minIndex]);
        //3.
        //4.
        TreeNode leftTree = constructTree(nums, left, minIndex-1);
        TreeNode rightTree = constructTree(nums, minIndex + 1, right);
        //5.
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
