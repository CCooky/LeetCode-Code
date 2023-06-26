import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class 组合总和III {
    public static void main(String[] args) {
        int k = 4;
        int n = 1;
        Solution1 solution1 = new Solution1();
        solution1.combinationSum3(4,1);
    }
}

class Solution1 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        int startIndex = 1;
        backTracking(k, n, path, pathList, startIndex);
        return pathList;
    }

    // 组合问题：暴力回溯
    //1.回溯参数。除了下面还要一个成员变量，保存path里面的和，回溯的时候同时减去就行了
    int sum = 0;
    public void backTracking(int k, int n, List<Integer> path, List<List<Integer>> pathList, int startIndex) {
        //2. 哇这里很容易出错啊，第一个条件和第一个条件不能使用&&链接，这两个意思完全不一样，首先长度=k了，就必须终止了，不管sum什么情况
        if (path.size() == k) {
            if (sum == n) {
                pathList.add(new ArrayList<>(path));
            }
            return;
        }
        //3.
        // 9-i+1 >= k-path.size()
        for (int i = startIndex; i <= 10 - k + path.size(); i++) {
            path.add(i); // 处理
            sum = sum + i;
            backTracking(k, n, path, pathList, i+1);//递归
            sum = sum - path.get(path.size() - 1); //回溯
            path.remove(path.size() - 1);
        }
    }
}
