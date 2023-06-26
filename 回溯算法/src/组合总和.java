import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 */
public class 组合总和 {
}

class Solution3 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (candidates==null) return pathList;
        List<Integer> path = new ArrayList<>();
        backTracking(candidates, target, path, pathList, 0);
        return pathList;
    }

    //组合问题-回溯。这里并不确定组合的元素个数，只要求组合的和一个条件，并且数据集不需要更换。
    // 不对，题目要求的是组合，不动数据集就会出现重复的组合。如何让组合不重复呢，也就是只保留数据之间的单向选择（很像哈希表里的两数之和）
    int sum = 0; //记录路径的求和
    public void backTracking(int[] candidates, int target, List<Integer> path, List<List<Integer>> pathList, int startIndex) {
        if (sum == target) {
            pathList.add(new ArrayList<>(path));
            return; //yiding o
        }
        if (sum > target) return;
        //3.数据集一直是candidates不需要更换，然后就是处理、递归、回溯
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backTracking(candidates, target, path, pathList, i);
            sum = sum - candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
