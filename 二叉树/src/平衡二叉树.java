/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class 平衡二叉树 {
}
class Solution9 {
    /**
     * 求左右子树的最大深度然后比较是不是相差 1，用不了BFS层序遍历把，那就是递归。因为需要子树的信息，根节点才可以判断所以说后序。
     * 求出左右子树的最大深度，如果平衡的话，我们返回该树的最大深度，不平衡我们选一个标志如（-1）返回
     */
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height != -1;
    }
    //1.确定参数、返回值。参数就是一个节点，返回值为int表示传入节点为根节点的树的高度。
    //2.确定终止条件，带逻辑。向下递归遇到了空节点返回，返回高度为0;
    //3.确定单层递归逻辑，带入根节点。就是先拿到左子树的高度，再拿到右子树的，假如
    // 最后比较他们两个差值是不是1，不是1的话就不平衡，返回一个标志-1，是的话我们就返回最大深度
    public int getHeight(TreeNode node){
        if (node==null) return 0;

        int leftDepth = getHeight(node.left);
        int rightDepth = getHeight(node.right);
        //如果子树高度为-1，则子树不平衡，那么我们整个数也就不平衡
        if (leftDepth==-1 || rightDepth==-1) return -1;
        int abs = Math.abs(leftDepth - rightDepth);
        if (abs==1||abs==0){
            return 1+Math.max(leftDepth,rightDepth);
        }else {
            return -1;
        }
    }
}
