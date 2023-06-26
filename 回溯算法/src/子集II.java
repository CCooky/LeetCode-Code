import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你一个整数数组 nums ，其中可能包含重复元素，
 * 请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class 子集II {
}

class Solution9 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        int startIndex = 0;
        //1.简单判断先
        if (nums.length==0) return pathList;
        //去重第一步排序
        Arrays.sort(nums);
        backTracking(nums,path,pathList,startIndex);
        return pathList;
    }

    //组合问题+树层去重无树枝去重+无终止条件
    //1.参数：同一个集合里面取组合，需要startIndex，进行组合去重
    public void backTracking(int[] nums, List<Integer> path, List<List<Integer>> pathList, int startIndex) {
        //2.终止条件：无
        pathList.add(new ArrayList<>(path));
        //3.回溯搜索过程：先去重，然后处理+递归+回溯
        for (int i = startIndex; i < nums.length; i++) {
            //去重
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            //处理
            path.add(nums[i]);
            //递归
            backTracking(nums, path, pathList, i + 1);
            //回溯
            path.remove(path.size()-1);
        }
    }
}
