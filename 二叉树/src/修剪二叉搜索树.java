import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 */
public class 修剪二叉搜索树 {
}

class Solution25 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 半暴力解法
        //1. 中序得到所有节点，找到需要被删除的
        List<Integer> allNodeList = new ArrayList<>();
        inOrder(root, allNodeList);
        //2.就在原集合上删除吧
        allNodeList.removeIf(num -> num >= low && num <= high);
        System.out.println(allNodeList);
        //3. 遍历一次次删除
        //3.1 使用非挂载的方法去删除
//        TreeNode rootParent = new TreeNode(0);
//        rootParent.left = root;
//        for (Integer integer : allNodeList) {
//            deleteNodeNeedParent(rootParent.left, rootParent, integer);
//        }
//        return rootParent.left;
        //3.2 使用挂载的方法去删除
        for (Integer integer : allNodeList) {
            root = deleteNode2(root, integer);
        }
        return root;
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

    }

    public TreeNode deleteNode2(TreeNode node, int key) {
        // 返回值意义是挂载的意思
        if (node == null) return null;
        // 找到该节点
        if (node.val == key) {
            if (node.left == null && node.right != null) {
                return node.right;
            } else if (node.left != null && node.right == null) {
                return node.left;
            } else if (node.left == null && node.right == null) {
                return null;
            } else {
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                temp.left = node.left;
                return node.right;
            }
        }
        // 后序挂载上去，二叉搜索树哦，接着从左子树找或者右子树
        if (key > node.val) {
            TreeNode right = deleteNode2(node.right, key); //得到找到后整理好的右子树
            node.right = right;
        } else {
            TreeNode left = deleteNode2(node.left, key); //得到找到后整理好的右子树
            node.left = left;
        }
        return node;
    }

    public void deleteNodeNeedParent(TreeNode node, TreeNode parent, int val) {
        if (node == null) return;
        // get node
        if (node.val == val) {
            if (node.left == null && node.right == null) {
                if (parent.left == node) parent.left = null;
                if (parent.right == node) parent.right = null;
//                node = null; //这个是什么意思，将对象销毁？？java不能自己销毁对象啊
            } else if (node.left == null && node.right != null) {
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
            } else if (node.left != null && node.right == null) {
                if (parent.left == node) parent.left = node.left;
                if (parent.right == node) parent.right = node.left;
            } else if (node.left != null && node.right != null) {
                TreeNode temp = node.right;
                while (true) {
                    if (temp.left != null) temp = temp.left;
                    else break;
                }
                temp.left = node.left;
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
            }
            return;
        }
        // go down
        if (node.val < val) {
            deleteNodeNeedParent(node.right, node, val);
        } else {
            deleteNodeNeedParent(node.left, node, val);
        }
    }

}
