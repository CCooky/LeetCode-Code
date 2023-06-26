import javafx.scene.control.Alert;

import java.util.Arrays;
import java.util.Scanner;

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int length = in.nextInt();
//        int[] postOrder = new int[length];
//        for (int i = 0; i < length; i++) {
//            postOrder[i] = in.nextInt();
//        }
        int[] postOrder = new int[]{4, 6, 7, 5};
        Solution43 solution = new Solution43();
        System.out.println(solution.getResult(postOrder));
    }
}

class Solution43 {
    // 递归函数意义：判断传入序列是不是一个合法的二叉搜索树后序遍历。
    public boolean getResult(int[] postorder) {
        //.递归终止条件
        if (postorder.length == 0) return true;
        //1.找到根节点，rootValue
        int rootValue = postorder[postorder.length - 1];
        //2.根据rootValue划分出左子树后序
        int leftIndex = 0; //在找左子树索引的时候，要记录满足要求的索引，一步步走，不然很容易出问题，还不好排查出来
        while (rootValue > postorder[leftIndex]) {
            leftIndex++; //最后leftIndex是开的
        }
        // 例如下面这个写法，就必须将leftIndex初始化为postorder.length-1
//        int leftIndex = postorder.length-1;
//        for (int i = 0; i < postorder.length - 1; i++) {
//            if (postorder[i] > rootValue){
//                leftIndex = i;break;
//            }
//        }

        int[] leftpost = Arrays.copyOfRange(postorder, 0, leftIndex);//左闭右开的撒，0、0的话就是空
        //3.判断剩下的右子树后序数组，是不是满足要求
        for (int i = leftIndex; i < postorder.length - 1; i++) {
            if (postorder[i] < rootValue) return false;
        }
        int[] rightpost = Arrays.copyOfRange(postorder, leftIndex, postorder.length - 1);
        //4.上面都满足就递归左子树、右子树去判断；递归的终止条件是后序数组长度为0，为1也可以
        boolean leftResult = getResult(leftpost);
        boolean rightResult = getResult(rightpost);
        return leftResult && rightResult; //中
    }
}
