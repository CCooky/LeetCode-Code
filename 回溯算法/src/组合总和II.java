import java.util.*;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次 。
 * candidates内有重复的元素
 */
public class 组合总和II {
}

class Solution4 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        if (nums.length==0){
            return pathList;
        }
        int startIndex = 0;
        //为了将重复的数字都放到一起，一定要先进行排序
        Arrays.sort(nums);
        backTracking(nums,target,path,pathList,startIndex);
        return pathList;
    }


    // 组合问题。数据集合内有重复的元素，会导致最后组合集合内出现相同的组合（但是由不同的元素构成，只是元素的数值相同）
    // 需要树层去重，使最后组合集合无重复组合，去重第一步：排序。然后树层上使用过的元素数值直接跳过，不往下递归
    //1.确定参数：同一个数据集合找组合需要startIndex保证组合不重复，然后两个list，一个全局sum。
    int sum = 0;
    public void backTracking(int[] nums, int target, List<Integer> path, List<List<Integer>> pathList, int startIndex) {
        //2.终止条件。不要求组合内元素个数
        if (sum == target) {
            pathList.add(new ArrayList<>(path)); //..
            return;
        }
        if (sum > target) return;
        //3.回溯逻辑（处理、递归、回溯）
        for (int i = startIndex; i < nums.length; i++) {
            // 这里需要数层去重，因为前面已经做了排序，所以就是判断当前元素是否和前一个元素数值相同就行
//            if (i > 0 && nums[i] == nums[i - 1]) { //注意还要i>0,WOC，这里不对，应该是>target才行，>0的话就同时还进行了树枝去重！！！！！我草
//                continue;
//            }
            if (i > startIndex && nums[i] == nums[i - 1]) { //使用>target就是单纯的树层去重
                continue;
            }
            path.add(nums[i]);
            sum = sum + nums[i];
            backTracking(nums, target, path, pathList, i + 1); //递归纵向遍历，每个元素只能用一次需要+1
            sum = sum - nums[i];
            path.remove(path.size() - 1);
        }
    }
}
