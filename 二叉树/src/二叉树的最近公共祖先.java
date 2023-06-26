import java.util.ArrayList;
import java.util.List;

/**
 * 所有 Node.val 互不相同 。 暴力法的话，相同也不所谓。但是利用特性的话，相同就不行了
 * 树中节点数目在范围 [2, 105] 内。
 * p != q
 */
public class 二叉树的最近公共祖先 {
}

class Solution22 {
    /**
     * 暴力起来，先找到两个节点的 从根到节点的路径，然后一个个比较，easy
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        List<TreeNode> path = new ArrayList<>();
        List<List<TreeNode>> pathList = new ArrayList<>();
        getBinaryTreePaths(root, path, pathList, p, q);
        // 取出两条路径
        System.out.println(pathList);
        List<TreeNode> path1 = pathList.get(0);
        List<TreeNode> path2 = pathList.get(1);
        //
        for (int i = 0; i < path1.size(); i++) {
            if (path1.get(i) != path2.get(i)){
                // 前一个节点是公共祖先
                return path1.get(i-1);
            }
            if (i==path1.size()-1 || i==path2.size()-1){
                return path1.get(i);
            }
        }

        return null; //不可能到这一步，随便返回啥都行
    }

    public void getBinaryTreePaths(TreeNode node, List<TreeNode> path, List<List<TreeNode>> pathList,TreeNode p, TreeNode q){
        /**
         * 这里和之前的不一样哦，为什么null节点也要丢进去呢，因为不管是不是空，我都会去remove一个元素。
         * remove是一定执行的，所以我们add也一定要执行，这样才平衡
         */
        path.add(node);
        if (node==null) return; //不做任何操作，直接终止
        if (node==p || node==q ){
            // 这里要注意哦，必须new一个新对象扔进去了
            List<TreeNode> yepath = new ArrayList<>(path);
            pathList.add(yepath);
        }
        // 左递归,
        getBinaryTreePaths(node.left, path,pathList,p,q );
        // 左递归完了，要将集合数据回溯，不能接着往后增加
        path.remove(path.size()-1);
        // 右递归, 同样递归完了，将集合元素回溯到上一个
        getBinaryTreePaths(node.right,path,pathList,p,q );
        path.remove(path.size()-1);
    }
}
