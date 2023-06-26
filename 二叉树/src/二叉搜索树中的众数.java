import java.util.*;

/**
 *
 */
public class 二叉搜索树中的众数 {
}
class Solution21 {
    public int[] findMode(TreeNode root) {
        if (root==null) return new int[0];

        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        // 求频率用什么。先map，然后使用优先队列（堆排序）构建过程O（n）
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer integer : list) {
            if (!map.containsKey(integer)){
                map.put(integer,1);
            }else {
                map.put(integer,map.get(integer)+1);
            }
        }
        // 优先队列,存放的是我们的Map.Entry对象，指定排序规则
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue()- o1.getValue());
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            queue.offer(entry);
        }
        //先弹出第一个
        List<Integer> resList = new ArrayList<>();
        Map.Entry<Integer, Integer> first = queue.poll();
        Integer maxFrequency = first.getValue();
        resList.add(first.getKey());
        while (!queue.isEmpty()){
            if (Objects.equals(queue.peek().getValue(), maxFrequency)){
                resList.add(queue.poll().getKey());
            }else {
                break;
            }
        }
        int[] resArr = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    //中序
    public void inOrder(TreeNode node, List<Integer> list){
        if (node==null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }
}
