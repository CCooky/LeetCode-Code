import java.util.ArrayList;
import java.util.List;

public class 组合问题 {
}

class Solution {
    /**
     * 回溯暴力搜索算法
     */
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        int startIndex = 1;
        backTracking(n, k, path, pathList, startIndex);
        return pathList;
    }

    //1.确定回溯函数的参数、无返回值。参数除了n、k以外，还需要一个用来存放符合条件单一结果，一个用来存放符合条件结果的集合，
    // 一个开始的索引，记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。startIndex 就是防止出现重复的组合。
    public void backTracking(int n, int k, List<Integer> path, List<List<Integer>> pathList, int startIndex) {
        //2.确定终止条件。到了叶子节点就终止，转换过来就算当单一集合长度达到k时即停止.
        if (path.size() == k) {
            pathList.add(new ArrayList<>(path)); //这里要new哦
            return;
        }
        //3.确定回溯搜索的遍历过程
//        for (int i = startIndex; i <= n; i++) { //组合可选数据的范围是【1，n】
        // 优化剪枝 n-i+1 >= k-path.size()
        for (int i = startIndex; i <= n + 1 - k + path.size(); i++) {
            path.add(i); //处理
            backTracking(n, k, path, pathList, 1 + i);  //递归
            path.remove(path.size() - 1);  //回溯
        }
    }
}
