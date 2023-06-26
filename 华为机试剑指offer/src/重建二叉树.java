import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class 重建二叉树 {
}


class Solution9 {
    //前序遍历和中序遍历
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //1、终止条件，当数组长度为0时，返回挂载的节点为null
        //2、后序找到根节点
        //3.根据根节点的数值划分中序遍历，得到左子树中序遍历、右子树中序遍历
        //4.根据左子树中序遍历长度，划分后序数组，得到左子树后序遍历、右子树后序遍历
        //5.递归左子树构建，递归右子树构建，得到左子树、右子树
        //6.将左子树、右子树挂载到根节点
        if (preorder.length==0){
            return null;
        }
        //1.
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        //2.
        int index = 0; //根节点在中序数组的索引
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        //3.
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftInorder.length);//左闭右开
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftPreorder.length, preorder.length);
        //4.
        TreeNode left = buildTree(leftPreorder, leftInorder);
        TreeNode right = buildTree(rightPreorder, rightInorder);
        //5.
        root.left = left;
        root.right = right;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
