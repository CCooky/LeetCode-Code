import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 */
public class 全排列2 {
}

class SOlution11 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        Set<Integer> usedIndex = new HashSet<>();
        //1.简单判断
        if (nums.length == 0) return pathList;
        //2.去重第一步排序
        Arrays.sort(nums);
        backTracking(nums, path, pathList,usedIndex);
        return pathList;
    }

    //排列问题-回溯搜索：不需要startIndex+不能重复使用元素+排列长度等于数据集合长度
    // 由于数据集合含有重复的元素，所以要进行树层去重（数值意义上的去重）,
    //1.参数
    public void backTracking(int[] nums, List<Integer> path, List<List<Integer>> pathList, Set<Integer> usedIndex) {
        //2.stop
        if (path.size() == nums.length) {
            pathList.add(new ArrayList<>(path));
            return;
        }
        //3.回溯搜索：处理、递归、回溯
        for (int i = 0; i < nums.length; i++) {
            //不重复使用一个元素
            if (usedIndex.contains(i)) {
                continue;
            }
            //树层去重
            if (i > 0 && nums[i] == nums[i - 1] && !usedIndex.contains(i-1)) {
                continue;
            }
            //
            path.add(nums[i]);
            usedIndex.add(i);
            //
            backTracking(nums, path, pathList,usedIndex);
            //
            path.remove(path.size() - 1);
            usedIndex.remove(i);
        }
    }
}
