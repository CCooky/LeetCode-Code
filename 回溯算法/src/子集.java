import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。
 * 返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class 子集 {
}
class Solution8 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> pathList = new ArrayList<>();
        if (nums.length==0) return pathList; //！！！！！！！！！！！！！！！！
        int startIndex = 0;
        backTracking(nums,path,pathList,startIndex);
        return pathList;
    }
    //组合问题——回溯，不限制组合元素个数；那就是startIndex=nums.length停止（startIndex相当于是索引）
    // 这里集合收集的是所有叶子节点，所以直接全部加进去就行了
    public void backTracking(int[] nums, List<Integer> path, List<List<Integer>> pathList, int startIndex){
        //2.遇到了就加进去，没有终止条件其实
        pathList.add(new ArrayList<>(path)); //又没有new，我去你的那个！！！！！！！！！！
//        if (startIndex== nums.length) return; //不加也是一样的这里，因为下面的for也不会执行
        //3.处理、递归、回溯
        for (int i = startIndex; i < nums.length ; i++) {
            path.add(nums[i]);
            backTracking(nums, path, pathList, i+1); //递归，在横向基础上，并且元素不能重复使用，
            path.remove(path.size()-1);
        }
    }
}
