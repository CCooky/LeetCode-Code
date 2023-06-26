import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。
 * 你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class 全排列 {
}

class Solution10 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        Set<Integer> usedIndex = new HashSet<>();
        //1.简单判断
        if (nums.length==0) return pathList;
        backTracking(nums,path,pathList,usedIndex);
        return pathList;
    }

    //排列问题：回溯搜索。不需要startIndex+不能重复使用元素+排列长度等于数据集合长度
    //1.参数，一个收集单个排列的集合，一个存储排列结果的集合
    public void backTracking(int[] nums, List<Integer> path, List<List<Integer>> pathList, Set<Integer> usedIndex) {
        //2.终止条件。
        if (path.size()==nums.length){
            pathList.add(new ArrayList<>(path));
            return;
        }
        //3.回溯搜索。处理、递归、回溯
        for (int i = 0; i < nums.length; i++) {
            //不重复使用一个元素
            if (usedIndex.contains(i)) { //这种写法就不对了啊，会把数据集合里面两个不同的1给去掉
                continue;
            }
            //处理
            path.add(nums[i]);
            usedIndex.add(i);
            //递归
            backTracking(nums, path, pathList,usedIndex);
            //回溯
            path.remove(path.size()-1);
            usedIndex.remove(i);
        }
    }
}

