import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，检查它是否轴对称。
 */
public class 对称二叉树 {
}

class Solution3 {
    /**
     * 分析1：层序遍历，一层层输出，然后我们使用栈进行配对，这样最后栈里面如果栈为空不就说明两边对称嘛
     */
    public boolean isSymmetric1(TreeNode root) {
        return false;
    }

    /**
     * 错误了，因为有可能我左子树叶子节点为两个2，右子树的叶子节点为两个7呢，这也会清空啊！
     * 哦哦，那我想想，那这就是比较根节点下的两个子树是不是一样，也就是使用递归去一个个比较他们的左右子树是不是对称的，然后返回给上一级
     */
    public boolean isSymmetric(TreeNode root) {
        return isMatch(root.left,root.right);

    }
    //1.确定参数、返回值。参数这里是两个节点嘛（逻辑意思是两个子树），然后是需要有返回值的，因为我们根节点要获取两个子树是不是配对的信息，基本数据类型Boolean
    //2.确定终止条件，我们是左右子树的对应节点进行匹配，就会出现节点同时为null，这种就不能往下走了，并且返回true；
    // 然后一个null一个不null，说明这两个节点不匹配，返回false；然后两个值不相等也是不匹配，停止不往下走，返回false。
    // 如果两个值相等的话，就不停止的撒，往下走
    //3.有返回值后序遍历思想。先获取左右子树配对的信息，然后返回给我，我根节点要看内存外侧是不是都为true才行
    public boolean isMatch(TreeNode left, TreeNode right){
        if (left==null && right==null) return true;
        if (left!=null&&right==null) return false;
        if (left==null&&right!=null)return false;
        if (left.val!=right.val) return false;

        boolean outside = isMatch(left.left, right.right);
        boolean inside = isMatch(left.right, right.left);
        return outside&&inside;
    }




}
