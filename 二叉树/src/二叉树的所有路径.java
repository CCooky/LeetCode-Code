import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，
 * 返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class 二叉树的所有路径 {
    public static void main(String[] args) {
        //构建一个二叉树
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(5);
        root.left = root1;
        root.right = root2;
        root1.right = root3;

        Solution12 solution12 = new Solution12();
        List<String> list = solution12.binaryTreePaths(root);
    }
}
/**
 * 使用到了回溯思想的解法，每次到了最后一个节点截止后，我remove集合里面的最后一个节点
 */
class Solution15{
    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null) return null;
        List<TreeNode> path = new ArrayList<>();
        List<List<TreeNode>> pathList = new ArrayList<>();
        getBinaryTreePaths(root,path,pathList);
        // 封装返回结果
        List<String> stringList = new ArrayList<>();
        for (List<TreeNode> list : pathList) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i==list.size()-1) stringBuilder.append(list.get(i).val);
                else stringBuilder.append(list.get(i).val + "->");
            }
            stringList.add(stringBuilder.toString());
        }
        return stringList;
    }
    //1.参数、返回值。前序遍历，参数为一个节点，一个随着节点遍历记录路径的集合，一个装符合要求路径的集合
    //2.终止条件
    //3.单层递归
    public void getBinaryTreePaths(TreeNode node, List<TreeNode> path, List<List<TreeNode>> pathList){
        /**
         * 这里和之前的不一样哦，为什么null节点也要丢进去呢，因为不管是不是空，我都会去remove一个元素。
         * remove是一定执行的，所以我们add也一定要执行，这样才平衡
         */
        path.add(node);
        if (node==null) return; //不做任何操作，直接终止
        if (node.left==null && node.right==null){
            // 这里要注意哦，必须new一个新对象扔进去了
            List<TreeNode> yepath = new ArrayList<>(path);
            pathList.add(yepath);
        }
        // 左递归,
        getBinaryTreePaths(node.left, path,pathList );
        // 左递归完了，要将集合数据回溯，不能接着往后增加
        path.remove(path.size()-1);
        // 右递归, 同样递归完了，将集合元素回溯到上一个
        getBinaryTreePaths(node.right,path,pathList);
        path.remove(path.size()-1);
    }
}

/**
 * 没有使用回溯思想，这里产生了很多无用对象，极容易发生OOM
 */
class Solution12 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        treePathUseStringBuilder(root, stringBuilder, pathList);
        return pathList;
    }

    //就是从上往下遍历啊，遇到了叶子节点的话，就停止，然后把记录的路径加到最后的结果集合.不需要使用后序遍历返回给上一层信息呀
    //1.确定参数、返回值。参数有三个，一个节点，一个记录的String对象，一个List集合
    //String是不可变对象，这是一个关键点，假如是list集合传进来我们最后取拼就不一样了哦
    //2.确定终止条件。首先空节点返回。然后遇到了叶子节点的时候是不是就把路径给到最后结果里面
    public void treePath(TreeNode node, String path, List<String> pathList) {
        if (node == null) {
            return;
        }
        path = path + node.val; //拼上当前节点值
        //判断是不是叶子节点
        if (node.left == null && node.right == null) {
            pathList.add(path);
        } else {//不是叶子节点，我们就接着往左子树、右子树去拼。
            path = path + "->";
            treePath(node.left, path, pathList);
            treePath(node.right, path, pathList);
        }
    }

    public void treePathUseStringBuilder(TreeNode node, StringBuilder path, List<String> pathList) {
        //2.终止条件；遇到了叶子节点是不是就停了，把结果给我们的list集合。一是遇到空节点，二是遇到了叶子节点
        if (node == null) return;
        StringBuilder path1 = new StringBuilder(path);
        path1.append(node.val); //拼上当前节点值
        if (node.left == null && node.right == null) {
            pathList.add(path1.toString());
            return;
        }
        //3.应该接着往下去找到叶子节点，左右两边(这里其实就什么，有问题，因为传入的是引用数据类型，所有的指针都是指向一个地址）
        path1.append("->");
        treePathUseStringBuilder(node.left, path1, pathList);
        treePathUseStringBuilder(node.right, path1, pathList);
    }

    /**
     * 层序遍历也可以，但要借助两个队列。就是一层层遍历，找到叶子节点的时候就将拼的路径加到list集合。然后难的就是如何去拼路径
     * 这里很聪明，用到了两个队列的想法，一个存每层的节点，一个按照每层节点顺序，存对应上上往下的路径。
     */
    public List<String> binaryTreePathBFS(TreeNode root) {
        //1.简单判断
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        //
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> stringQueue = new LinkedList<>();
        nodeQueue.offer(root);
        stringQueue.offer(String.valueOf(root.val));

        while (!nodeQueue.isEmpty()) {
            // 哦，这里不一样哦，这里要一个个取出来，一次性也可以把我试试,试过了，因为两个要同步很麻烦管理，逻辑上可以的
            TreeNode node = nodeQueue.poll();
            String path = stringQueue.poll();
            if (node.left == null && node.right == null) {
                list.add(path);
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                stringQueue.offer(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                stringQueue.offer(path + "->" + node.right.val);
            }
            // 会产生很多多余的字符串对象，但这必须要这样，因为你必须保证我每次操作的字符串对象都是不相同的
        }
        return list;
    }

}