import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
 */
public class 把二叉搜索树转换为累加树 {
}

class Solution27 {
    public TreeNode convertBST2(TreeNode root) {
        reverseInOrder(root);
        return root;
    }
    int sum = 0;
    public void reverseInOrder(TreeNode node){
        if (node==null) return;
        reverseInOrder(node.right);
        sum = sum + node.val;
        node.val = sum;
        reverseInOrder(node.left);
    }
    /**
     * 因为本来就是二叉搜索树，那这样算的话，原来最小的节点应该变成数值最大的节点了
     * 导致最后是每个节点的左节点小、右节点大，根节点还是一样的。左子树都大于根节点，右子树都小于根节点。
     * 然后题目做了简化，只要我们完成每个节点的累加就行了，不用管其他的
     * 中序遍历得到树的递增序列-list。map存一下递增序列每个元素的索引，这样o（1），不然拿到一个节点先要去遍历整个集合，然后又遍历一遍求和
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        //1.
        List<Integer> nodeValueList = new ArrayList<>();
        inOrder(root, nodeValueList);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nodeValueList.size(); i++) {
            map.put(nodeValueList.get(i), i);
        }
        //2.再遍历一遍树，我去，再写个中序吧
        inOrder2(root,nodeValueList,map);
        return root;
    }

    //中序1拿到所有节点存储数据
    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public void inOrder2(TreeNode node, List<Integer> list, Map<Integer, Integer> map) {
        if (node == null) return;
        inOrder2(node.left, list, map);  //左
        Integer index = map.get(node.val);  //中-处理逻辑
        int newValue = 0;
        for (int i = index; i < list.size(); i++) {
            newValue = newValue + list.get(i);
        }
        node.val = newValue;
        inOrder2(node.right, list, map); //右
    }
}