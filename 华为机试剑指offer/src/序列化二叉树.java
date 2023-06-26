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
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
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
//class Codec {
//
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        //中序遍历即可，不用递归，记得把null节点也存进去哦
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        List<TreeNode> list = new ArrayList<>(); //存储层序遍历结果
//        while (!queue.isEmpty()) {
//            while (!queue.isEmpty()) {
//                list.add(queue.poll());
//            }
//            for (TreeNode node : list) {
//                // 把null节点也放进去了
//                if (node != null) {
//                    queue.offer(node.left);
//                    queue.offer(node.right);
//                }
//            }
//        }
//        //按照格式序列化
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
//        for (TreeNode treeNode : list) {
//            if (treeNode == null) {
//                stringBuilder.append("null,");
//            } else {
//                stringBuilder.append(treeNode.val + ",");
//            }
//        }
//        //去掉最后一个，
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        stringBuilder.append("]");
//        return stringBuilder.toString();
//    }
//
//    public TreeNode deserialize(String data) {
//        if (data.equals("[]")) return null;
//        String[] vals = data.substring(1, data.length() - 1).split(",");
//        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int i = 1;
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (!vals[i].equals("null")) {
//                node.left = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.left);
//            }
//            i++;
//            if (!vals[i].equals("null")) {
//                node.right = new TreeNode(Integer.parseInt(vals[i]));
//                queue.add(node.right);
//            }
//            i++;
//        }
//        return root;
//    }
//
//}
