import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {

    }
}

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;
 }
 }
 */


class Solution33 {
    List<TreeNode> list = new ArrayList<>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        if (list.size() == 0) return null;
        // 1、中序遍历保持各个节点
        // 先拿到头节点，这里就弄一个虚拟头节点，最后再去掉
        TreeNode rhead = new TreeNode(-1);
        TreeNode temp = rhead;
        for (int i = 0; i < list.size(); i++) {
            //
            temp.right = list.get(i);
            list.get(i).left = temp;
            //
            temp = temp.right;
        }
        // 最后做一下扫尾工作;
        // 处理第一个节点、最后一个节点。此时temp在最后一个节点
        TreeNode head = rhead.right;
        head.left = null;
        rhead.right = null;
        temp.right = null;
        return head;

    }

    public void inOrder(TreeNode TreeNode) {
        if (TreeNode == null) {
            return;
        }
        inOrder(TreeNode.left);
        list.add(TreeNode);
        inOrder(TreeNode.right);
    }
}


