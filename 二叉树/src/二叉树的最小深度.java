import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class 二叉树的最小深度 {
}

class Solution7 {
    /**
     * 这个使用递归的话，我是真的没有搞明白啊。先用层序遍历
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //1.BFS-队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();
        int minDepth = 0;
        while (!queue.isEmpty()) {
            // 一次性取出该层节点
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            minDepth++;
            // 这里判断集合中的节点，只要某个节点没有左右子树，那么就是第一个叶子节点，此时他就对应了最小深度
            for (TreeNode node : list) {
                if (node.left == null && node.right == null) {
                    // 此时这是找的叶子节点
                    return minDepth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.clear();
        }
        return minDepth;
    }

    /**
     * 递归遍历，看看怎么做。遇到第一个叶子节点的地方返回对吧，那我按照什么顺序呢，有可能最上的叶子节点在左，有可能在右啊
     * 肯定是需要返回值的，也就是只能为后序遍历。收集左右子节点的高度给中，那是不是就是选取左右子树里面高度的最小值啊，
     */
    //1.确定函数参数、返回值。参数就是一个节点，返回值是该节点高度
    //2.确定终止条件。带...。会一直向下遇到空节点对吧，那到了空节点就要返回了，返回高度为0
    //3.确定单层执行逻辑，这里也就会重复调用自己来实现递归的过程。左右中。先拿到左子树的高度，再拿到右子树的高度，取两个里面小的那个高度，加1就是我根节点的高度
    public int getMindepth(TreeNode node) {
        if (node == null) return 0;

//        int left = getMindepth(node.left);
//        int right = getMindepth(node.right);
//        return 1+Math.min(left,right);

        int leftDepth = getMindepth(node.left);
        int rightDepth = getMindepth(node.right);
        //中应该怎么写？
        //如果左子树为空，右子树不为空，是不是应该为1+右子树的深度呢，因为该节点不是叶子节点啊
        //如果右子树为空，左子树不为空也是一个意思
        // 如果左右子树都不为空呢？那应该是选两个里面高度最小值+1.都为空呢，也是选两个里面高度最小值+1
        if (node.left == null && node.right != null) return 1 + rightDepth;
        if (node.left != null && node.right == null) return 1 + leftDepth;
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
