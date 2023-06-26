import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class 从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int[] ints = Arrays.copyOfRange(arr, 0, 2);
        System.out.println(Arrays.toString(ints));
    }
}
class Solution14{
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //1.简单判断数组为空，则没有树
        if (inorder.length==0) return null;
        //2。后序找切分点,是根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        //3,找到中序数组中根节点的索引
        int index = 0; //记录根节点的索引
        for (index= 0; index < inorder.length; index++) {
            if (inorder[index]==rootValue)break;
        }
        //4.切分中序数组，分别为左中序数组、右中序数组
        int[] leftInOrder = Arrays.copyOfRange(inorder,0,index);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        //5.切分后序数组，这里切分依据就是 左中序数组的长度了（中序是左根右、后序是左右根）
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInOrder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, leftInOrder.length, postorder.length-1);
        //6. 递归处理左区间和右区间
        TreeNode leftTree = buildTree(leftInOrder, leftPostOrder);
        TreeNode rightTree = buildTree(rightInOrder, rightPostOrder);
        //7. 将左子树、右子树接到根节点上面
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
