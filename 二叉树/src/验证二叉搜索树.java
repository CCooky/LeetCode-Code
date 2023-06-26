/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树
 */
public class 验证二叉搜索树 {
}

class Solution19 {
    public boolean isValidBST(TreeNode root) {
            return isValidBST2(root);
    }

    public boolean isValidBST2(TreeNode node) {
        if (node == null) return false;
        if (node.left != null && node.val > node.left.val) {
            return true; //满足这两个条件则说明当前节点满足二叉搜索树
        } else if (node.left != null && node.val < node.left.val) {
            return false;
        }
        if (node.right != null && node.val < node.right.val) {
            return true; //满足这两个条件则说明当前节点满足二叉搜索树
        } else if (node.right != null && node.val > node.right.val) {
            return false;
        }
        if (node.left==null && node.right==null){
            return true;
        }
        //
        boolean left = isValidBST(node.left);
        boolean right = isValidBST(node.right);
        return left && right;
    }

    /**
     * 递归法
     */
    public boolean isVVV(TreeNode node){

        return false;
    }

    /**
     * 中序遍历得到一个单调递增的数组.
     */

    /**
     * 使用中序遍历，不使用数组在遍历过程判断递增
     */
    long  maxVal = Long.MIN_VALUE; // 因为后台测试数据中有int最小值
    public boolean isValidBy(TreeNode node){
        if (node==null) return true;//假设传进来的根节点为空
        boolean left = isValidBy(node.left);
        if (node.val > maxVal ){
            maxVal = node.val; //max这里其实记录的一直都是中间节点的值
        }else {
            return false;
        }
        boolean right = isValidBy(node.right);
        return left&&right;

    }
}
