/**
 * 求这个完全二叉树有几个节点
 */
public class 完全二叉树的节点个数 {
}
class Solution8{
    /**
     * 感觉还是比较简单的哦，把树遍历一遍就行了。前序、层次遍历都可以啊
     */
    public int countNodes(TreeNode root){
        countNode(root);
        return countNum;

    }

    //1.确定函数参数和返回值。这个传入的是一个节点，返回值的话好像不需要，因为可以定义一个全局遍历
    //2.确定终止条件，传入的是一个空节点，则return。
    //3.确定单层执行逻辑。只要这个节点不为空的话，就计数器加一啊.然后接着统计他的两个字节点
    int countNum=0;
    public void countNode(TreeNode node){
        if (node == null) return;
        countNum++;
        countNode(node.left);
        countNode(node.right);
    }

    /**
     * 复杂度小于O（N）的利用完全二叉树性质的写法
     */
    //1.确定参数、返回值。参数就是一个节点。然后有返回值，是以这个节点为根节点的树的节点数量。
    //2、确定终止条件。首先遍历下去到了空节点，返回数量一定是0。但不仅仅只有这个终止条件，还有你遇到了满二叉树的情况，也是终止条件哦，
    //遇到了子树是满二叉树时，就要把这个树的节点数量返回上去啊，这也是终止条件撒。判断子树是不是满二叉树的逻辑也是在终止条件里面的。
    //3、单层递归逻辑。后序的左右中。先分别获取根节点左子树、右子树的节点数，中的处理逻辑是返回总的节点数。然后总的就是1+这两个。
    public int getNodes(TreeNode node){
        if (node==null) return 0;
        TreeNode left = node.left;
        TreeNode right = node.right;
        int leftDepth = 1;
        int rightDepth = 1;
        while (left!=null){
            left = left.left;
            leftDepth++;
        }
        while (right!=null){
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth){
            return (int) (Math.pow(2,leftDepth)-1);
        }

        int leftNodes = getNodes(node.left);
        int rightNodes = getNodes(node.right);
        return 1+leftNodes+rightNodes;
    }
}
