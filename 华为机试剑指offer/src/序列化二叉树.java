import java.util.*;

public class 序列化二叉树 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Codec codec = new Codec();
        System.out.println(codec.deserialize(s));
        String serialize = codec.serialize(codec.deserialize(s));
        System.out.println(serialize);
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "";
        //easy
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); // 其他两个实现类不能添加null空指针进队列
        List<TreeNode> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                ans.add(poll == null ? null : poll.val);
                list.add(poll);
            }
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if(node==null) continue;
                queue.add(node.left);
                queue.add(node.right);
            }
            list.clear();
        }
        // 去掉最后多余的null指针
        for (int i = ans.size()-1; i >=0 ; i--) {
            if(ans.get(i)!=null){
                break;
            }
            ans.remove(i);
        }
        return ans.toString();
    }

    // 不能使用数组进行每个元素的遍历，因为我们要按照数组从前往后遍历节点，无法直接根据索引i定位已经被挂载的节点地址，所以想到queue
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        //hard
        data = data.substring(1, data.length() - 1);
        String[] valString = data.split(", ");
        Queue<TreeNode> queue = new ArrayDeque<>();
        int p = 0; // 指针指向数组中未被挂载的元素
        TreeNode root = new TreeNode(Integer.parseInt(valString[p]));
        queue.offer(root);
        p++;
        while (p < valString.length) {
            TreeNode poll = queue.poll();
            if (valString[p].equals("null")) {
                poll.left = null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(valString[p]));
                poll.left = node;
                queue.offer(node);
            }
            p++;
            if (p >= valString.length) break;
            if (valString[p].equals("null")) {
                poll.right = null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(valString[p]));
                poll.right = node;
                queue.offer(node);
            }
            p++;
        }
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

