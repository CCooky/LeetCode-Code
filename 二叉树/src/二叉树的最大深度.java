import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */
public class 二叉树的最大深度 {
}

class Solution6 {
    /**
     * 深度是从下上往下树，根节点的深度为1，如果是从上往下的话就是下一层我就加一个1，先拿到上一层的深度然后加一。这样的话最简单的办法就是BFS，一层一层进，一层层出。
     * 但这道题要使用递归思想，是很多其他只能用递归的基础。根据经验，我们从下往上会计较简单，也就是后序，我们收集子孩子的信息通过返回值return回去，子孩子的信息就是其高度。
     * 我们用求高度替代求深度，根节点的高度等于最大深度。
     */
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }

    //1.确定参数、返回值。参数就是一个节点撒（这里分析不带题目逻辑意义），然后返回值是要有的为int，表示子孩子的高度
    //2.确定终止条件。带着题目逻辑思考。什么时候终止呢，我们会一直深度往下直到碰到了空节点，也就是叶子节点的下一个。
    // 那返回什么东西呢，返回的是高度对吧，那叶子节点高度为1，所以null节点高度是0对了
    //3.确定当初执行逻辑。带着题目逻辑思考。我们这里是后序方式，所以应该获取左子树、右子树的两个高度，然后选里面一个最大值加1，就是我这个节点的高度。
    public int getMaxDepth(TreeNode node) {
        if (node==null) return 0;

        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);
        return 1+Math.max(left,right);
    }

    /**
     * 层序遍历BFS,这个很简单撒。
     */
    public int maxDepth2(TreeNode root){
        //1.root=null
        if (root ==null) return 0;
        // BFS-队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> list = new ArrayList<>();// 记录每次出队的节点
        int maxDepth = 0;
        while (!queue.isEmpty()){
            // 一次性将该层的节点出队
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node);
            }
            maxDepth++;
            for (TreeNode node : list) {
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
            list.clear();
        }
        return maxDepth;

    }
}


