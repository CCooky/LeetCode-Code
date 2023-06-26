import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 */
public class N叉树的前序遍历 {
}
class Solution2{
    public List<Integer> preorder(Node root){
        // 根左右，写递归
        List<Integer> list = new ArrayList<>();
        preorderRecursion(root,list);
        return list;

    }
    //1.确定函数参数和返回值,因为要最后得到一个遍历的集合，所以要一个list，一个头节点，不需要返回值
    //2.确定终止条件，传入节点为null，则直接终止
    //3.确定单层逻辑，先获取当前节点的数据存到list集合，然后遍历他的子节点集合，一个个的进行迭代
    public void preorderRecursion(Node node, List<Integer> reslist){
        if (node == null){
            return;
        }
        reslist.add(node.val);
        for (Node child : node.children) {
            preorderRecursion(child,reslist);
        }
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
