import java.time.chrono.ThaiBuddhistChronology;
import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {

    }
}
//class TreeNode{
//    public int val;
//    public TreeNode left;
//    public TreeNode right;
//    public TreeNode(int val){
//        this.val = val;
//    }
//}
class Solution76{
    public TreeNode lowestCommonAncestor( TreeNode root, TreeNode p, TreeNode q){
        getRes(root,p,q);
        //拿到两条路径
        List<TreeNode> nodeList = pathList.get(0);
        List<TreeNode> nodeList1 = pathList.get(1);
        System.out.println(nodeList);
        System.out.println(nodeList1);
        //从前往后找到分叉点。一定有祖先的
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i)!=nodeList1.get(i)){
                return nodeList.get(i-1);
            }
            //长度不一样，只要有一个遍历完了，就需要返回了
            if (i==nodeList.size()-1 || i==nodeList1.size()-1){
                return nodeList.get(i);
            }
        }

        return null;

    }
    //递归函数; 我草又写错了
    public List<TreeNode> path = new ArrayList<>();
    public List<List<TreeNode>> pathList = new ArrayList<>();
    public void getRes(TreeNode node, TreeNode p, TreeNode q){
        path.add(node); //中逻辑放在最前面，后面一定发送回溯
        //2.
        if (node == null) {
            return;
        }
        if (node == p){
            pathList.add(new ArrayList<>(path));
        }
        if (node == q){
            pathList.add(new ArrayList<>(path));
        }
        //3.前序遍历
        getRes(node.left,p,q);
        path.remove(path.size()-1);
        getRes(node.right,p,q);
        path.remove(path.size()-1);
    }
}
